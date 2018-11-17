package com.fly.rq_house_service.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by Administrator on 2018/11/18 0018.
 * JSON 工具类
 *
 */
public class JsonUtils {

    /**
     *   str  转  JsonNode
     * @param str
     * @return
     */
    public static JsonNode str2JsonNode(String str){
        JsonNode jsonNode = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            jsonNode = mapper.readTree(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonNode;
    }

}
