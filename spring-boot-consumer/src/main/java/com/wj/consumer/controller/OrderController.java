package com.wj.consumer.controller;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.wj.consumer.service.UserAddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/wj")
public class OrderController {

	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	private UserAddressService userAddressService;

	@GetMapping("/queryUserDetail")
	public Map<String, Object> queryUserDetail(@RequestParam("uid")String uid) {
		logger.info("initOrder: uid={}", uid);
		Map<String, Object> map = new HashMap<>();
		if (StringUtils.isBlank(uid)) {
			map.put("code", 200);
			map.put("msg", "操作失败：参数 uid 为空！！！");
			map.put("data", null);
			return map;
		}
		try {
			map.put("code", 200);
			map.put("msg", "操作成功");
			map.put("data", userAddressService.getUserDetail(uid));
		} catch (Exception e) {
			map.put("code", 200);
			map.put("msg", "操作失败：" + e.getMessage());
			map.put("data", null);
		}
		return map;
	}
}
