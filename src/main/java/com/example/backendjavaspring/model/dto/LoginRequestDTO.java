package com.example.backendjavaspring.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginRequestDTO {
    @NotBlank
    private String email;
    @NotBlank
    private String password;

    public LoginRequestDTO() {
    }
    
	public LoginRequestDTO(@NotBlank String email, @NotBlank String password) {
		this.email = email;
		this.password = password;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
    
}
