package com.wj.clien.service;

import com.wj.entity.UserAddress;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wanjiang
 * Date: 2019/11/2
 * Time: 15:28
 */
public interface UserService {

    List<UserAddress> getUserAddressList(String userId);
}
