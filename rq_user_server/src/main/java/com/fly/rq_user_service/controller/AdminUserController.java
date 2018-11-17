package com.fly.rq_user_service.controller;

import com.fly.rq_user_service.entity.AdminUser;
import com.fly.rq_user_service.mapper.AdminUserMapper;
import com.fly.rq_user_service.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/11/17 0017.
 */


@RestController
@RequestMapping("/api/v1/adminUser/")
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    /**
     * 数据库 测试 ---  添加
     */
    @RequestMapping("insert")
    public String insert(){
        return adminUserService.insert();
    }

    /**
     * 数据库 测试 ---  查询
     * @param userId
     * @return AdminUser
     */
    @RequestMapping("findById")
    public AdminUser findById(@RequestParam("user_id")Long userId){
        return adminUserService.findById(userId);
    }


    /**
     * 数据库 测试 ---  查询所有
     * @return List<AdminUser>
     */
    @RequestMapping("findAll")
    public List<AdminUser> findAll(){
        return adminUserService.findAll();
    }

    /**
     * 数据库 测试 ---  修改
     */
    @RequestMapping("update")
    public void update(@RequestParam("user_id")Long userId){
        adminUserService.update(userId);
    }


    /**
     * 数据库 测试 ---  修改
     * @param userId
     */
    @RequestMapping("delete")
    public void delete(@RequestParam("user_id")Long userId){
        adminUserService.delete(userId);
    }

}
