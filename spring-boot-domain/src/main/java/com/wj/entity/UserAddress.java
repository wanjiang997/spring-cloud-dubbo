package com.wj.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: wanjiang
 * Date: 2019/11/2
 * Time: 15:12
 */
@Data
public class UserAddress implements Serializable {
    private Long id;
    private String userAddress; //用户地址
    private String userId; //用户id
    private String consignee; //收货人
    private String phoneNum; //电话号码
    private Integer isDefault; //是否为默认地址    Y-是     N-否
    private Date createTime;
    private Date updateTime;

    public UserAddress() {
        super();
    }

    public UserAddress(Long id, String userAddress, String userId,
                       String consignee, String phoneNum, Integer isDefault) {
        super();
        this.id = id;
        this.userAddress = userAddress;
        this.userId = userId;
        this.consignee = consignee;
        this.phoneNum = phoneNum;
        this.isDefault = isDefault;
    }
}
