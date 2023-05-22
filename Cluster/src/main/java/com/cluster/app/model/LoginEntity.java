package com.cluster.app.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="login")
public class LoginEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int logId;
	private String email;
	private String password;
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="user_role")
	private RoleEntity role;
	@ManyToOne( cascade = CascadeType.ALL)
	private UserStatusEntity status;
	
	
	public int getLogId() {
		return logId;
	}
	public void setLogId(int logId) {
		this.logId = logId;
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
	public RoleEntity getRole() {
		return role;
	}
	public void setRole(RoleEntity role) {
		this.role = role;
	}
	public UserStatusEntity getStatus() {
		return status;
	}
	public void setStatus(UserStatusEntity status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "LoginEntity [logId=" + logId + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", status=" + status + "]";
	}
	
	
	

	
	
}
