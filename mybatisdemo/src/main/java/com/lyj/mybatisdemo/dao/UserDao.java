package com.lyj.mybatisdemo.dao;

import com.lyj.mybatisdemo.entity.PageVo;
import com.lyj.mybatisdemo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserDao {
     /** 增加*/
     int save(User user);

     /** 查询*/
      List<User> query(int id);

     /** 删除*/
     int delete(int id);

     /** 更新*/
     int update(User user);
     /** 分页查询*/
     List<User> getUserList(User user);



}
