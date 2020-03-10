package com.lyj.mybatisdemo.service;

import com.github.pagehelper.Page;
import com.lyj.mybatisdemo.entity.PageVo;
import com.lyj.mybatisdemo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    /** 增加*/
    int insert (User user);

    /** 查询*/
     List<User> query(int id);

    /** 删除*/
    int delete(int id);

    /** 更新*/
    int update(User user);
    /** 用户列表查询*/
    PageVo<User> getUserList(User user);

}
