package com.fly.rq_house_service.fallBack;

import com.fly.rq_house_service.server.UserServer;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by Administrator on 2018/11/18 0018.
 */
@Component
public class UserServerFallBack implements UserServer {
    @Override
    public Map<String, Object> findById(Long userId) {
        System.out.println("user-server-fail");
        return null;
    }
}
