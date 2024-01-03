package com.zlx.documentssosobackend.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Date;

@Data
public class Document {
    @TableId
    public String id;
    public String name;
    public String type;
    public Date upload_date;
    public String upload_user;
    public int download_times;
    public String size;

    public Document(String id, String name, String type, Date upload_date, String upload_user, int download_times, String size) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.upload_date = upload_date;
        this.upload_user = upload_user;
        this.download_times = download_times;
        this.size = size;
    }
}
