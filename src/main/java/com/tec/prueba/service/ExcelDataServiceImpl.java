package com.tec.prueba.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.tec.prueba.entity.UploadExcel;
import com.tec.prueba.repository.UploadExcelRepository;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ExcelDataServiceImpl implements IExcelDataService {

    @Value("${app.upload.file:${user.home}}")
    public String EXCEL_FILE_PATH;

    @Autowired
    UploadExcelRepository uploadExcelRepository;

    Workbook workbook;

    @Override
    public List<UploadExcel> getExcelDataAsList() {

        List<String> list = new ArrayList<String>();

        DataFormatter dataFormatter = new DataFormatter();

        try {
            workbook = WorkbookFactory.create(new File(EXCEL_FILE_PATH));
        }catch (EncryptedDocumentException | IOException e){
            e.printStackTrace();
        }
        System.out.println("------------Workbook has '"+ workbook.getNumberOfSheets() +"' Sheets-----");

        Sheet sheet = workbook.getSheetAt(0);

        int noOfColumns = sheet.getRow(0).getLastCellNum();
        System.out.println("-------Sheet has '"+noOfColumns+"' columns------");
        for (Row row : sheet) {
            for (Cell cell : row) {
                String cellValue = dataFormatter.formatCellValue(cell);
                list.add(cellValue);
            }
        }
        List<UploadExcel> uploadList = createList(list, noOfColumns);

        try {
            workbook.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return uploadList;
    }
    private List<UploadExcel> createList (List<String> excelData, int noOfColumns){
        ArrayList<UploadExcel> uploadList = new ArrayList<UploadExcel>();

        int i = noOfColumns;
        do{
            UploadExcel uploadExcel = new UploadExcel();
            uploadExcel.setNombre(excelData.get(i));
            uploadExcel.setPromedio(Integer.valueOf(excelData.get(i+1)));
            uploadExcel.setResultado(excelData.get(i+2));
            uploadExcel.setCarrera(excelData.get(i+3));
            uploadExcel.setTipo(excelData.get(i+4));
        }while (i<excelData.size());

        return uploadList;
    }
    @Override
    public int saveExcelData(List<UploadExcel> uploadExcels){
        uploadExcels = uploadExcelRepository.saveAll(uploadExcels);
        return uploadExcels.size();
    }
}
