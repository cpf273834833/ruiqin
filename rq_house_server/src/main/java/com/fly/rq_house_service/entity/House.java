package com.fly.rq_house_service.entity;

import java.io.Serializable;

/**
 *  房屋实体类
 */
public class House implements Serializable{

    private static final long serialVersionUID = -4247996477106551084L;

    /**
     * 房屋id
     */
    private Long id;

    /**
     * 房屋地址
     */
    private String adress;

    /**
     * 权利人
     */
    private String userName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
