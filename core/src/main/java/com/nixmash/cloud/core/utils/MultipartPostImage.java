package com.nixmash.cloud.core.utils;

import org.springframework.web.multipart.MultipartFile;

public class MultipartPostImage {

    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}

