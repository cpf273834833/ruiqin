package com.fly.rq_house_service.mapper;

import com.fly.rq_house_service.entity.House;
import org.apache.ibatis.annotations.*;

/**
 * Created by Administrator on 2018/11/17 0017.
 */
public interface HouseMapper {


    /**
     * insert house
     */
    @Insert("insert into house(adress,user_name) values(#{adress},#{userName})")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    Long insert(House house);


    /**
     * findById
     */
    @Select("select * from house where id = #{id}")
    @Results({
            @Result(column = "user_name",property = "userName"),
    })
    House findById(Long id);


}
