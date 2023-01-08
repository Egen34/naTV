package com.example.naTV.microService;

import lombok.Data;

@Data
public class MicroServiceResponse {

    private String fileName;
    private String downloadUri;
    private String fileType;
    private long size;

    public MicroServiceResponse(String fileName, String downloadUri, String fileType, long size) {
        this.fileName = fileName;
        this.downloadUri = downloadUri;
        this.fileType = fileType;
        this.size = size;
    }
}