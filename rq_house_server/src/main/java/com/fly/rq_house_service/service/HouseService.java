package com.fly.rq_house_service.service;

import com.fly.rq_house_service.entity.House;

/**
 * Created by Administrator on 2018/11/18 0018.
 */
public interface HouseService {

    Long save(String adress,Long userId);

    House findById(Long id);
}
