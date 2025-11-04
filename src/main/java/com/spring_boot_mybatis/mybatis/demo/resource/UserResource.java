package com.spring_boot_mybatis.mybatis.demo.resource;

import com.spring_boot_mybatis.mybatis.demo.mapper.UserMapper;
import com.spring_boot_mybatis.mybatis.demo.model.Users;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/users")
public class UserResource {

    private UserMapper userMapper;

    public UserResource(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    @GetMapping("/all")
    public List<Users> getAll(){
        return userMapper.findAll();
    }

    @GetMapping("/update")
    public List<Users> update(){
        Users users = new Users();
        users.setName("JiXuan");
        users.setSalary("4000");

        userMapper.insert(users);

        return userMapper.findAll()
    }
}
