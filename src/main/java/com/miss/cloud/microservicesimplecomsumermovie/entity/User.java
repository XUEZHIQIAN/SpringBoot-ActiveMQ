package com.miss.cloud.microservicesimplecomsumermovie.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 用户模型类
 * 
 * @author Hang.W
 * @date 2017年11月28日 下午10:10:58
 * @version 1.0
 */
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Long id;

	private String username;

	private String name;

	private int age;

	private BigDecimal balance;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

}
