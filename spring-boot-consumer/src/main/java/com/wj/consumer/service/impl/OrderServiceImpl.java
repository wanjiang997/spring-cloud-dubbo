package com.wj.consumer.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wj.clien.service.UserService;
import com.wj.consumer.service.UserAddressService;
import com.wj.entity.UserAddress;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 1、将服务提供者注册到注册中心（暴露服务）
 * 		1）、导入dubbo依赖（2.6.2）\操作zookeeper的客户端(curator)
 * 		2）、配置服务提供者
 * 
 * 2、让服务消费者去注册中心订阅服务提供者的服务地址
 * @author wanjiang
 *
 */
@Service
public class OrderServiceImpl implements UserAddressService {

	@Reference(loadbalance="random",timeout=1000, version = "1.0.0") //RPC dubbo直连
	private UserService userService;

//	@HystrixCommand(fallbackMethod="hello")
	@Override
	public List<UserAddress> getUserDetail(String uid) {
		// TODO Auto-generated method stub
		List<UserAddress> addressList = userService.getUserAddressList(uid);
		for (UserAddress userAddress : addressList) {
			System.out.println(userAddress.getUserAddress());
		}
		return addressList;
	}


	public List<UserAddress> hello(String uid) {
		// TODO Auto-generated method stub
		return null;
	}
}
