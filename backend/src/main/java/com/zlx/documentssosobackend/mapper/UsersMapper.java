package com.zlx.documentssosobackend.mapper;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zlx.documentssosobackend.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
@TableName("users")
public interface UsersMapper extends BaseMapper<User> {
    @Select("select * from users where name = #{name}")
    public List<User> queryUserByName(String name);

    @Insert("insert into users values (#{name}, #{password})")
    public int insertUser(User user);
}
