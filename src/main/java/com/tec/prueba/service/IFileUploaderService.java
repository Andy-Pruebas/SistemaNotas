package com.tec.prueba.service;

import org.springframework.web.multipart.MultipartFile;

public interface IFileUploaderService {
    void uploadFile(MultipartFile file);
}
