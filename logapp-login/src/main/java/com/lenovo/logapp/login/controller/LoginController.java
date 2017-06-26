package com.lenovo.logapp.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.lenovo.logapp.login.entities.User;

@RestController
@RequestMapping(value = "/login")
public class LoginController {
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@Value("${user.userServicePath}")
	private String userServicePath;

	@GetMapping("/loginById/{id}")
	public User loginById(@PathVariable Long id) {
		
		ServiceInstance serviceInstance = this.loadBalancerClient.choose("logapp-user");
	    System.out.println("serviceInstance===" + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort());
		return this.restTemplate.getForObject(this.userServicePath + id, User.class);
	}
}
