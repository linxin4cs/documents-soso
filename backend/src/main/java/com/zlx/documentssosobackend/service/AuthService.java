package com.zlx.documentssosobackend.service;

import com.zlx.documentssosobackend.entity.User;

public interface AuthService {
    public int login(User user);
    public String register(String password);
}
