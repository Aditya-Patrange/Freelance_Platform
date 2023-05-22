package com.cluster.app.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class DeactiveUser extends BaseEntity{

	private String user_status;
}
