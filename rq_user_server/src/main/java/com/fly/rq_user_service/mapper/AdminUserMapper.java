package com.fly.rq_user_service.mapper;

import com.fly.rq_user_service.entity.AdminUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 访问数据库的接口Mapper
 */
public interface AdminUserMapper {

    /**
     * 新增
     * @param user
     * @return
     */
    @Insert("insert into admin_user(user_name,password,create_time) values(#{userName},#{password},#{createTime})")
    @Options(useGeneratedKeys = true,keyColumn = "user_id",keyProperty = "userId")
    Long insert(AdminUser user);


    /**
     * 查询
     * @param userId
     * @return
     */
    @Select("select * from admin_user where user_id = #{userId}")
    @Results({
        @Result(column = "user_id",property = "userId"),
        @Result(column = "user_name",property = "userName"),
        @Result(column = "create_time",property = "createTime")
    })
    AdminUser findByUserId(Long userId);

    /**
     * 查询所有
     * @return
     */
    @Select("select * from admin_user")
    @Results({
            @Result(column = "user_id",property = "userId"),
            @Result(column = "user_name",property = "userName"),
            @Result(column = "create_time",property = "createTime")
    })
    List<AdminUser> findAll();
    /**
     * 修改
     * @param user
     * @return
     */
    @Update("update admin_user set user_name = #{userName} where user_id = #{userId}")
    void update(AdminUser user);

    /**
     * 删除
     * @param userId
     */
    @Delete("delete from admin_user where user_id = #{userId}")
    void delete (Long userId);


}
