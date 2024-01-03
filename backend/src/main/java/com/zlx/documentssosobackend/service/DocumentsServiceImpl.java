package com.zlx.documentssosobackend.service;

import com.zlx.documentssosobackend.entity.Document;
import com.zlx.documentssosobackend.entity.User;
import com.zlx.documentssosobackend.mapper.DocumentsMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.apache.ibatis.ognl.OgnlOps.doubleValue;

@Service
public class DocumentsServiceImpl implements DocumentsService{
    @Autowired
    private DocumentsMapper documentsMapper;

    @Override
    public int uploadDocument(String user_name, MultipartFile documentFile, HttpServletRequest request) {

        String path = request.getServletContext().getRealPath("/upload/");
        System.out.println(path);

        String doc_size = "";

        if(documentFile.getSize() > 1024 * 1024) {
            doc_size = String.format("%.2f", doubleValue(documentFile.getSize()) / 1024 / 1024) + "MB";
        } else if(documentFile.getSize() > 1024) {
            doc_size =  String.format("%.2f", doubleValue(documentFile.getSize()) / 1024) + "KB";
        }

        Document document = new Document(RandomStringUtils.randomAlphanumeric(10), documentFile.getOriginalFilename().substring(0,documentFile.getOriginalFilename().lastIndexOf(".")), documentFile.getOriginalFilename().substring(documentFile.getOriginalFilename().lastIndexOf(".")).substring(1),
                new java.sql.Date(new Date().getTime()), user_name, 0, doc_size);

        try {
            saveDocument(path, documentFile, document);
        } catch (Exception e) {
            return 1;
        }

        try {
            documentsMapper.insertDocuments(document);
        } catch (Exception e) {
            System.out.println(e);
        }


        return 0;
    }

    @Override
    public List<Document> getHotDocuments() {
        return documentsMapper.queryHotDocuments();
    }

    @Override
    public List<Document> getDocumentByUploadUser(String name) {
        return documentsMapper.queryDocumentByUploadUser(name);
    }

    @Override
    public List<Document> getDocumentByKeyWord(String keyword) {
        return documentsMapper.queryDocumentsByKeyWord(keyword);
    }

    @Override
    public int updateDocumentDownloadTimes(String document_id) {
        try {
            documentsMapper.updateDocumentDownloadTimes(document_id);
        } catch (Exception e) {
            return 1;
        }

        return 0;
    }

    public void saveDocument(String path, MultipartFile documentFile, Document document) throws IOException {
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdir();
        }

        File file = new File(path + document.getId() + documentFile.getOriginalFilename().substring(documentFile.getOriginalFilename().lastIndexOf(".")));
        documentFile.transferTo(file);
    }
}
