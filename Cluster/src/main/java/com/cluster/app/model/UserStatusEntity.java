package com.cluster.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="User_Status")
public class UserStatusEntity extends BaseEntity{

	
	private int statusCode;
	private String status;
}
