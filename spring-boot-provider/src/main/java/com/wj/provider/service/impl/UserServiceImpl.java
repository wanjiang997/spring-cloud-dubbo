package com.wj.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wj.clien.service.UserService;
import com.wj.entity.UserAddress;
import com.wj.provider.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wanjiang
 * Date: 2019/11/2
 * Time: 15:06
 */
@Service(version = "1.0.0", timeout = 3000)//暴露服务
@Component
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;

	@HystrixCommand
	@Override
	public List<UserAddress> getUserAddressList(String id) {
//		UserAddress address1 = new UserAddress(1, "北京市昌平区宏福科技园综合楼3层", "1", "李老师", "010-56253825", "Y");
//		UserAddress address2 = new UserAddress(2, "深圳市宝安区西部硅谷大厦B座3层（深圳分校）", "1", "王老师", "010-56253825", "N");
//		return Arrays.asList(address1,address2);
		return userMapper.queryUserList(id);
	}

}
