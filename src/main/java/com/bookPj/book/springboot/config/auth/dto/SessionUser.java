package com.bookPj.book.springboot.config.auth.dto;

import com.bookPj.book.springboot.domain.user.User;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SessionUser {
	private String name;
	private String email;
	private String picture;

	public SessionUser(User user){
		this.name=user.getName();
		this.email=user.getEmail();
		this.picture=user.getPicture();
	}
}
