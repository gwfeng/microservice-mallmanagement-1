package com.itheima.controller;
import com.itheima.config.OrderLisener;
import com.itheima.mapper.OrderMapper;
import com.itheima.po.Order;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderMapper orderMapper;

	@GetMapping("/findOrders/{userid}")
	public List<Order> findOrder(@PathVariable("userid") Integer userid) {
		System.out.println("输出的端口为："+OrderLisener.getPort());
		List<Order> orders=  this.orderMapper.selectOrder(userid);
		return  orders;
	}

	@PostMapping("/insertOrder")
	public Integer insertOrder(@RequestBody  Order order) {
		this.orderMapper.saveOrder(order);
		return  order.getId();
	}
}