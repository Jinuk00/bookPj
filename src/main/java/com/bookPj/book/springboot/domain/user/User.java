package com.bookPj.book.springboot.domain.user;

import com.bookPj.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@Entity(name="MEMBER")
public class User extends BaseTimeEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String email;

	private String picture;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;

	@Builder
	public User(String name, String email, String picture, Role role){
		this.name=name;
		this.email=email;
		this.picture=picture;
		this.role=role;
	}

	public User update(String name, String picture){
		this.name=name;
		this.picture=picture;
		return this;
	}

	public String getRoleKey(){
		return this.role.getKey();
	}

}
