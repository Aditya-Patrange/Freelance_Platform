package com.cluster.app.dto;

import java.time.LocalDate;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;


import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {
	@NonNull
	private String projectName;
	@NonNull
	private Long projectBudget;
	@NonNull
	@JsonProperty("date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate projectDeadline;
	@Nonnull
	private int numberOfResource;
	@NonNull
	private String technology;
	@Nonnull
	private int clientId;
		
}
