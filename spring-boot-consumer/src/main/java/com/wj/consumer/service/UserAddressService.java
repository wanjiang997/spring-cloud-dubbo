package com.wj.consumer.service;

import com.wj.entity.UserAddress;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wanjiang
 * Date: 2019/11/2
 * Time: 15:38
 */
public interface UserAddressService {

    List<UserAddress> getUserDetail(String uid);
}
