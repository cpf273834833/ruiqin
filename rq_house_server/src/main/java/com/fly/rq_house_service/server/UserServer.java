package com.fly.rq_house_service.server;

import com.fly.rq_house_service.fallBack.UserServerFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by Administrator on 2018/11/18 0018.
 * 调用user服务中的接口
 */
@FeignClient(name = "rq-user-server",fallback = UserServerFallBack.class)
public interface UserServer {

    @RequestMapping("/api/v1/adminUser/findById")
    Map<String,Object> findById(@RequestParam("user_id")Long userId);

}
