package com.tec.prueba.controller;

import com.tec.prueba.entity.UploadExcel;
import com.tec.prueba.repository.UploadExcelRepository;
import com.tec.prueba.service.IExcelDataService;
import com.tec.prueba.service.IFileUploaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UploadExcelController {

    @Autowired
    IFileUploaderService iFileUploaderService;

    @Autowired
    IExcelDataService iExcelDataService;

    @Autowired
    UploadExcelRepository uploadExcelRepository;

    @GetMapping("/uploadexcelpage")
    public String menu() {
        return "uploadPage";
    }

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

        iFileUploaderService.uploadFile(file);

        redirectAttributes.addFlashAttribute("message",
                "You have successfully uploaded '"+ file.getOriginalFilename()+"' !");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "redirect:/uploadexcelpage";
    }

    @GetMapping("/saveData")
    public String saveExcelData(Model model) {

        List<UploadExcel> excelDataAsList = iExcelDataService.getExcelDataAsList();
        int noOfRecords = iExcelDataService.saveExcelData(excelDataAsList);
        model.addAttribute("noOfRecords",noOfRecords);
        return "success";
    }
}
