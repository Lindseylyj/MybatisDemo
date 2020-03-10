package com.lyj.mybatisdemo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyj.mybatisdemo.dao.UserDao;
import com.lyj.mybatisdemo.entity.PageVo;
import com.lyj.mybatisdemo.entity.User;
import com.lyj.mybatisdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;

    /** 增加*/
    @Override
    public int insert(User user ) {
        return userDao.save(user);
    }

    /** 查询*/
    @Override
    public List<User> query(int id) {
        return userDao.query(id);
    }

    /** 删除*/
    @Override
    public int delete(int id) {
        return userDao.delete(id);
    }

    /** 更新*/
    @Override
    public int update(User user) {
        return userDao.update(user);
    }

    @Override
    public PageVo<User> getUserList(User user) {
        PageVo pageVo = new PageVo();
        PageHelper.startPage(user.getPageNum(),user.getPageSize());
        List<User> userList = userDao.getUserList(user);
        pageVo.setList(userList);
        pageVo.setTotalRecords((int)new PageInfo<User>(userList).getTotal());
        return pageVo;
    }

    /** 分页查询*/



}
