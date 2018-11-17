package com.fly.rq_user_service.service.impl;

import com.fly.rq_user_service.entity.AdminUser;
import com.fly.rq_user_service.mapper.AdminUserMapper;
import com.fly.rq_user_service.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/11/17 0017.
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    private AdminUserMapper adminUserMapper;



    /**
     * 数据库 测试 ---  添加
     */
    @Override
    public String insert() {
        AdminUser user = new AdminUser();
        user.setUserName("张三");
        user.setPassword("123");
        user.setCreateTime(new Date());
        adminUserMapper.insert(user);
        return String.valueOf(user.getUserId());
    }

    /**
     * 数据库 测试 ---  查询
     * @param userId
     * @return AdminUser
     */
    public AdminUser findById(Long userId){
        AdminUser user = adminUserMapper.findByUserId(userId);
        return user;
    }


    /**
     * 数据库 测试 ---  查询所有
     * @return List<AdminUser>
     */
    public List<AdminUser> findAll(){
        List<AdminUser> userList = adminUserMapper.findAll();
        return userList;
    }

    /**
     * 数据库 测试 ---  修改
     */
    public void update(Long userId){
        AdminUser user = new AdminUser();
        user.setUserId(userId);
        user.setUserName("张三");
        user.setPassword("123");
        user.setCreateTime(new Date());
        adminUserMapper.update(user);
    }


    /**
     * 数据库 测试 ---  修改
     * @param userId
     */
    public void delete(Long userId){
        adminUserMapper.delete(userId);
    }
}
