package com.fly.rq_user_service.service;

import com.fly.rq_user_service.entity.AdminUser;

import java.util.List;

/**
 *  AdminUser service
 */
public interface AdminUserService {

    String insert();

    AdminUser findById(Long userId);

    List<AdminUser> findAll();

    void update(Long userId);

    void delete(Long userId);


}
