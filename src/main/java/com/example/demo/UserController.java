package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //Json形式でデータをやり取りする窓口にする
@RequestMapping("/api/users")  //このクラスのURLの基本を /api/usersに設定
public class UserController {
	@Autowired //Springが自動でUserRepositoryを準備してくれる
	private UserRepository userRepository;
	
	//ユーザー一覧を取得する
	@GetMapping
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	//新しいユーザーを登録する
	@GetMapping("/create")
	public User createUser(@RequestParam String name) {
		User user = new User();
		user.setName(name);
		return userRepository.save(user);
	}
}
