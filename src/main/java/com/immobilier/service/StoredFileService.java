package com.immobilier.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.immobilier.model.StoredFile;


public interface StoredFileService {

    StoredFile store(MultipartFile file) throws IOException;

    StoredFile getFile(String uuid);

    StoredFile getFileById(String uuid);
}
