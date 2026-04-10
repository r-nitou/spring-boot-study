package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //DBのテーブルと紐づくクラスの合図
@Table(name = "users") //DB内でのテーブル名を「users」にする
public class User {
	@Id //主キーになる
	@GeneratedValue(strategy = GenerationType.IDENTITY) //番号を自動で振る
	private Long id;
	
	private String name;
	
	//ゲッター・セッター
	
	public  Long getId() {
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
}
