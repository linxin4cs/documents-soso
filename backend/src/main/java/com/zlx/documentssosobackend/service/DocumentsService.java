package com.zlx.documentssosobackend.service;

import com.zlx.documentssosobackend.entity.Document;
import com.zlx.documentssosobackend.entity.User;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface DocumentsService {
    public int uploadDocument(String user_name, MultipartFile documentFile, HttpServletRequest request);
    public List<Document> getHotDocuments();
    public List<Document> getDocumentByUploadUser(String name);
    public List<Document> getDocumentByKeyWord(String keyword);
    public int updateDocumentDownloadTimes(String document_id);
}
