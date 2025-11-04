package com.spring_boot_mybatis.mybatis.demo.mapper;

import com.spring_boot_mybatis.mybatis.demo.model.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from users")
    List<Users> findAll();

    @Insert("insert into users(name, salary) values(#{name}, #{salary})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    void insert(Users users);
}
