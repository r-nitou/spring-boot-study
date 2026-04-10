package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration		//これが設定クラスであることを示す
@EnableWebSecurity	
public class WebSecurityConfig {
	@Bean			//認証のルールを決める設定
	public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
		http
		.csrf((csrf)->csrf.disable())
		.authorizeHttpRequests((requests)->requests
				.anyRequest().authenticated()					//すべてのリクエストに認証が必要
				)
				.formLogin((from)->from.permitAll()				//ログイン画面は誰でも見れる
				);
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean			//ユーザー情報をメモリ上に作成する
	public UserDetailsService userDetailsService() {
		UserDetails user =User.builder()
					.username("admin")					//ユーザー名
					.password(passwordEncoder().encode("password"))				//パスワード
					.roles("USER")
					.build();
		
		return new InMemoryUserDetailsManager(user);
	}
}


