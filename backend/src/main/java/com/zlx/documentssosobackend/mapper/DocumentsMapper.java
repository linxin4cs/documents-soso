package com.zlx.documentssosobackend.mapper;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zlx.documentssosobackend.entity.Document;
import com.zlx.documentssosobackend.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
@TableName("documents")
public interface DocumentsMapper extends BaseMapper<Document> {
    @Select("select * from documents where upload_user = #{name}")
    public List<Document> queryDocumentByUploadUser(String name);

    @Select("select * from documents order by download_times desc limit 14")
    public List<Document> queryHotDocuments();

    @Select("insert into documents values (#{id}, #{name}, #{type}, #{upload_date}, #{upload_user}, #{download_times}, #{size})")
    public int insertDocuments(Document document);

    @Select("select * from documents where name REGEXP #{keyWord}")
    public List<Document> queryDocumentsByKeyWord(String keyWord);

    @Update("update documents set download_times = download_times + 1 where id = #{id}")
    public void updateDocumentDownloadTimes(String id);
}
