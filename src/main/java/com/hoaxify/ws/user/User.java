package com.hoaxify.ws.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Size(min = 4, max = 255)
	@UniqueUsername
	private String username;

	@NotNull
	@Size(min = 4, max = 255)
	private String displayName;

	@NotNull
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$")
	@Size(min = 8, max = 255)
	private String password;

	@Override
	public String toString() {
		return "User [username=" + username + ", displayName=" + displayName + ", password=" + password + "]";
	}

}
