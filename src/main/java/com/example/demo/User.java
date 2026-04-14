package com.example.demo;


import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("users") //Redis名を「users」にする
public class User implements Serializable{ //Redis保存のためにSerializableをつける
	@Id //Redis用ID
	private String id; //RedisではString型の方が扱いやすいらし
	private String name;
	
	//ゲッター・セッター
	
	public  String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
