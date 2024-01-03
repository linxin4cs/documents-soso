package com.zlx.documentssosobackend.service;

import com.zlx.documentssosobackend.entity.User;
import com.zlx.documentssosobackend.mapper.UsersMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AuthServiceImpl implements AuthService{
    @Autowired
    private UsersMapper usersMapper;
    public int login(User user) {
        List<User> trueUser = usersMapper.queryUserByName(user.name);
        if(trueUser.size() == 0) return 1;

        if(trueUser.get(0).password.equals(user.password)) {
            return 0;
        } else {
            return 1;
        }
    }

    public String register(String password) {
        User user = new User(RandomStringUtils.randomAlphanumeric(10), password);
        usersMapper.insertUser(user);

        return user.name;
    }
}
