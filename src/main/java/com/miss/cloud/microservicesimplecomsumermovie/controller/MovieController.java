package com.miss.cloud.microservicesimplecomsumermovie.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.miss.cloud.microservicesimplecommon.entity.User;
import com.miss.cloud.microservicesimplecommon.inter.UserServiceInterface;
import com.miss.cloud.microservicesimplecomsumermovie.jms.sender.MovieMessageSender;

/**
 * movie服务通过eureka远程调用user服务
 * @author Hang W
 * @Date 2018-12-1 23:18:45
 *
 */
@RestController
@RequestMapping("/comsumer")
public class MovieController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Resource
	private MovieMessageSender movieMessageSender;
	
	@Resource
	private UserServiceInterface userService;
	
	// user.address=http://localhost:8443/miss/query/
	@Value("${user.address}")
	private String host;
	
	@GetMapping("/query/{id}")
	public User queryUserById(@PathVariable Long id) {
		
		User user = restTemplate.getForObject(host + id, User.class);
		
		return user;
	}
	
	@GetMapping("/queryByMQ/{id}")
	public void queryUserByMQ(@PathVariable Long id) {
		
		User user = new User();
		user.setId(3L);
		
		movieMessageSender.send(user);
	}
	
	@GetMapping("/queryByDubbo/{id}")
	public User queryUserByDubbo(@PathVariable Long id) {
		User user = userService.query(id);
		return user;
	}
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		
		// lambda 表达式
		list.forEach(li -> System.out.println(li));
		// 解引用
		list.forEach(System.out :: println);
	}
	
}
