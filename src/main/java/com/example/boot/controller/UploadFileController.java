package com.example.boot.controller;

import com.example.boot.model.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class UploadFileController {

    @Value("${upload.path}")
    private String link;

    @Value("${display.path}")
    private String displayLink;

    @PostMapping()
    public ResponseEntity<?> uploadFile(@RequestPart(value = "files") List<MultipartFile> multipartFiles){
        List<String> path = new ArrayList<>();
        for (MultipartFile file : multipartFiles){
            String fileName = file.getOriginalFilename();
            try {
                FileCopyUtils.copy(file.getBytes(), new File(link + fileName));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            path.add(displayLink + fileName);
        }
        System.out.println(path.toString());
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<?> get (@RequestBody Test a){
        return new ResponseEntity<>(a, HttpStatus.OK);
    }
}
