package com.zlx.documentssosobackend.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class User {
    @TableId
    public String name;
    public String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
