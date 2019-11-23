package com.wj.provider.mapper;

import com.wj.entity.UserAddress;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wanjiang
 * Date: 2019/11/23
 * Time: 14:34
 */
public interface UserMapper {

    List<UserAddress> queryUserList(String id);
}
