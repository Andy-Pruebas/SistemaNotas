package com.tec.prueba.service;

import com.tec.prueba.entity.UploadExcel;

import java.util.List;

public interface IExcelDataService {
    List<UploadExcel> getExcelDataAsList();

    int saveExcelData(List<UploadExcel> uploadExcels);
}
