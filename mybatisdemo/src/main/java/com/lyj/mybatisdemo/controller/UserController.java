package com.lyj.mybatisdemo.controller;

import com.alibaba.fastjson.JSON;
import com.lyj.mybatisdemo.entity.PageVo;
import com.lyj.mybatisdemo.entity.User;
import com.lyj.mybatisdemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    /** 增加*/
    @RequestMapping(value="/user",method = RequestMethod.POST)
    public int insert(@RequestBody User user){
        logger.info("开始新增user:"+JSON.toJSONString(user));
        return userService.insert(user);
    }

    /** 查询*/
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public List<User> query(@PathVariable(value = "id") int id){
        logger.info(JSON.toJSONString(id));
        return userService.query(id);
    }

    /** 删除*/
    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public int delete(@PathVariable(value = "id") int id){
        logger.info(JSON.toJSONString(id));
        return userService.delete(id);
    }

    /** 更新*/
    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public int update(@RequestBody User user){
        logger.info("开始更新user："+JSON.toJSONString(user));
        return userService.update(user);
    }

//    /** 分页查询*/
//    public Map<String,Object> page(@PathVariable(value = "id") int id,@PathVariable(value = "pageSize") int pageSize,
//                                   @PathVariable(value = "pageNum") int pageNum){
//        Map<String,Object> searchMap = new HashMap<>();
//        searchMap.put("id",id);
//        Page<User> page  = userService.getUserList(id,pageSize,pageNum);
//        Map<String,Object> data = new HashMap<>();
//        data.put("list",page.getTotal());
//        Map<String,Object> result = new HashMap<>();
//        result.put(Common.RESPONSE_DATA,data);
//        result.put(Common.RESPONSE_DATA_PAGE,new PageVo(page));
//        result.put(Common.RESPONSE_CODE_MSG,"查询成功");
//        return result;
//    }

    /** 分页查询*/
    @RequestMapping(value="getUserList",method = RequestMethod.GET)
    public Map<String,Object> getUserList(@RequestBody User user){
        Map<String,Object> data = new HashMap<>();
        PageVo<User> pageVo = userService.getUserList(user);
        data.put("list",pageVo);
        data.put("totalRecords",pageVo.getTotalRecords());
        return data;
    }

}


