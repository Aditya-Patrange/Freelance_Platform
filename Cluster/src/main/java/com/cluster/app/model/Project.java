package com.cluster.app.model;

import java.time.LocalDate;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="project")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int projectId;
	private String projectName;
	private Long projectEstimatedBudget;
	
	private LocalDate projectDeadline;
	private int numberOfResource;
	private String technology;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="Client_Log_id")
	private LoginEntity clientId;
	@ManyToOne
	@JoinColumn(name="project_status")
	private ProjectStatus projectStatus;
	
	
	


	
	
}
