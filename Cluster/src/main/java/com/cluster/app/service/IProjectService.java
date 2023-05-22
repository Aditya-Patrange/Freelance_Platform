package com.cluster.app.service;

import com.cluster.app.dto.ApiResponse;
import com.cluster.app.dto.ProjectDto;

public interface IProjectService {

	ApiResponse<?> getProjectList();

	ApiResponse<?> addProject(ProjectDto data);

	ApiResponse<?> deleteProject(ProjectDto name);

	ApiResponse<?> getMaxBudget();

	ApiResponse<?> getMinBudget();

	ApiResponse<?> getProjectName();

	ApiResponse<?> getNameAndMinBudget();
}
