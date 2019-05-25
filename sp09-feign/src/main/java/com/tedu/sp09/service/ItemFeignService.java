package com.tedu.sp09.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tedu.sp01.pojo.Item;
import com.tedu.web.util.JsonResult;

/**
 *	调用接口的getItems()方法，根据spring mvc注解，
 * 	会调用localhost:8001服务器的 /{orderId}
 * @author Administrator
 *
 *	和商品微服务的控制器定义代码保持一即可
 */
@FeignClient(name="item-service", fallback = ItemFeignServiceFB.class)
public interface ItemFeignService {
	
	@GetMapping("/{orderId}")
	JsonResult<List<Item>> getItems(@PathVariable String orderId);

	
	@PostMapping("/decreaseNumber")
	JsonResult decreaseNumber(@RequestBody List<Item> items);
	
	/*
	 * service.getItems("123")
	 * 向远程微服务发送请求
	 * 请求路径: http://lcoalhost:8001/123
	 */
}