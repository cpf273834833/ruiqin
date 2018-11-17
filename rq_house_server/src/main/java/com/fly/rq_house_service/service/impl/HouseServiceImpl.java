package com.fly.rq_house_service.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fly.rq_house_service.entity.House;
import com.fly.rq_house_service.mapper.HouseMapper;
import com.fly.rq_house_service.server.UserServer;
import com.fly.rq_house_service.service.HouseService;
import com.fly.rq_house_service.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Administrator on 2018/11/18 0018.
 */
@Service
public class HouseServiceImpl implements HouseService{
    @Autowired
    private HouseMapper houseMapper;
    @Autowired
    private UserServer userServer;



    @Override
    public Long save(String adress,Long userId) {
        House house = new House();
        //调用 用户服务  获取 用户信息
        Map<String, Object> map = userServer.findById(userId);
        String userName = map.get("userName")+"";
        house.setUserName(userName);

        house.setAdress(adress);
        houseMapper.insert(house);

        return house.getId();
    }

    @Override
    public House findById(Long id) {
        House house = houseMapper.findById(id);
        return house;
    }
}
