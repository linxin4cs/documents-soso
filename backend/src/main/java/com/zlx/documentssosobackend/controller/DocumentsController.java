package com.zlx.documentssosobackend.controller;

import com.zlx.documentssosobackend.entity.Document;
import com.zlx.documentssosobackend.entity.User;
import com.zlx.documentssosobackend.service.DocumentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class DocumentsController {
    @Autowired
    DocumentsService documentsService;

    @GetMapping("/documents/search/{keyWord}")
    public List<Document> getDocumentsByKeyWord(@PathVariable String keyWord) {
        return documentsService.getDocumentByKeyWord(keyWord);
    }

    @GetMapping("/documents/upload_user/{name}")
    public List<Document> getDocumentsByUploadUser(@PathVariable String name) {
        return documentsService.getDocumentByUploadUser(name);
    }

    @GetMapping("/documents/hot")
    public List<Document> getHotDocuments() {
        return documentsService.getHotDocuments();
    }

    @PostMapping("/documents")
    public int uploadDocument(String user_name, MultipartFile documentFile, HttpServletRequest request) {
        return documentsService.uploadDocument(user_name, documentFile, request);
    }

    @PostMapping("/documents/{id}/download_times")
    public int updateDocumentDownloadTimes(@PathVariable String id) {
        System.out.println(id);
        return documentsService.updateDocumentDownloadTimes(id);
    }
}
