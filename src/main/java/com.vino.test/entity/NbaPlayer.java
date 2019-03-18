package com.vino.test.entity;

/**
 * @ClassName: User
 * @Description: nba球员
 * @author: wenjie.fei
 * @date: 2019/1/5 10:37
 * @version: V1.0
 */
public class NbaPlayer {

	private Long id;

	private String name;

	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
