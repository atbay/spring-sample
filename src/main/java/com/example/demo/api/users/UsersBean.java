package com.example.demo.api.users;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UsersBean {

	private Long id;
	@JsonProperty("user_id")
	private String userId;
	@JsonProperty("name")
	private String name;
	@JsonProperty("password")
	private String password;
	@JsonProperty("tel")
	private String tel;
	@JsonProperty("email")
	private String email;
	@JsonProperty("organizations_id")
	private Long organizationsId;

}
