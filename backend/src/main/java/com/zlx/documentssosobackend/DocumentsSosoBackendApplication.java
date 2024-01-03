package com.zlx.documentssosobackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zlx.documentssosobackend.mapper")
public class DocumentsSosoBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(DocumentsSosoBackendApplication.class, args);
    }

}
