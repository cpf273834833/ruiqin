package com.fly.rq_house_service.controller;

import com.fly.rq_house_service.entity.House;
import com.fly.rq_house_service.entity.base.XaResult;
import com.fly.rq_house_service.service.HouseService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/11/18 0018.
 */
@RestController
@RequestMapping("/api/v1/house/")
public class HouseController {
    @Autowired
    private HouseService houseService;

    @Autowired
    private StringRedisTemplate redisTemplate;


    /**
     * 保存房屋信息
     * @param adress
     * @param userId
     * @return
     */
    @RequestMapping("save")
    @HystrixCommand(fallbackMethod = "failHouseSave")
    public XaResult<Object> save(@RequestParam("adress")String adress, @RequestParam("user_id")Long userId){
        Long id = houseService.save(adress, userId);
        XaResult<Object> xr = new XaResult<Object>(id);
        return xr;
    }


    /**
     * 查询房屋信息
     * @param id
     * @return
     */
    @RequestMapping("findById")
    public XaResult<Object> findById(@RequestParam("id")Long id){
        House house = houseService.findById(id);
        XaResult<Object> xr = new XaResult<Object>(house);
        return xr;
    }


    /**
     *  save 方法报错 返回兜底数据
     * @param adress
     * @param userId
     * @return
     */
    public XaResult<Object> failHouseSave(String adress,Long userId){
        //发送短信  redis 缓存 20秒之内不重复发送
        String saveHouseKey = "save-house";
        String s = redisTemplate.opsForValue().get(saveHouseKey);

        //开启线程  防止调用短信接口时间过长
        new Thread(()->{
            if(StringUtils.isBlank(s)){
                //调用短信接口，发送报警短信
                System.out.println("紧急短信，用户保存房屋失败，请立即查找原因");

                //redis 存储key  有效时间20秒
                redisTemplate.opsForValue().set(saveHouseKey,"save-house-fail",20, TimeUnit.SECONDS);
            }else {
                System.out.println("已发送短信通知，20秒不重复发送");
            }
        }).start();



        //兜底数据
        XaResult<Object> xr = new XaResult<Object>(-1,"用户太多，您被挤出来了，请稍后再试！");
        return xr;
    }

}
