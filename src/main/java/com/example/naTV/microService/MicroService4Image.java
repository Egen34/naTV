package com.example.naTV.microService;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "photo-micro-service",url = "http://localhost:8011")
public interface MicroService4Image {
    @PostMapping(value = "/api/v1/file/upload", consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
    MicroServiceResponse upload(@RequestPart("file") MultipartFile multipartFile);
}
