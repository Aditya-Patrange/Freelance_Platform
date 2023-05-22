package com.cluster.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cluster.app.dto.ApiResponse;
import com.cluster.app.dto.ProjectDto;
import com.cluster.app.model.LoginEntity;
import com.cluster.app.model.Project;
import com.cluster.app.model.RoleEntity;
import com.cluster.app.repository.ILoginRepository;
import com.cluster.app.repository.IProjectStatusRepository;
import com.cluster.app.repository.ProjectRepository;
import com.cluster.app.utils.CommonUtils;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProjectServiceImpl implements IProjectService{

	
	@Autowired
	private ProjectRepository projectRepository;
		
	@Autowired
	private CommonUtils commonUtils;
	
	@Autowired
	private ILoginRepository loginRepository;
	
	@Autowired
	private IProjectStatusRepository projectStatusRepository  ;
	
	
	@Override
	public ApiResponse<?> getProjectList() {
		
		return commonUtils.setApiResponses(projectRepository.findAll(),"Getting project list successfully", true);
	}

	@Override
	public ApiResponse<?> addProject(ProjectDto data) {
		
		System.out.println(data.toString());
		Project existProject = projectRepository.findByName(data.getProjectName());
		
		if(existProject==null) {
			Project project = new Project();
			LoginEntity loginEntity = loginRepository.findById(data.getClientId()).get();
			RoleEntity roleEntity = loginEntity.getRole();
			if(roleEntity.getRoleId() == 2) {
				project.setClientId(loginEntity);
				project.setProjectEstimatedBudget(data.getProjectBudget());
				//project.setProjectDuration(data.getProjectDuration());		
				project.setProjectDeadline(data.getProjectDeadline());
				project.setProjectName(data.getProjectName());
				project.setNumberOfResource(data.getNumberOfResource());
				project.setTechnology(data.getTechnology());
				project.setProjectStatus(projectStatusRepository.findById(1).get());
			 System.out.println(project.toString());		
				projectRepository.save(project);
				return commonUtils.setApiResponses("Project :"+data.getProjectName(), "Project added successfully", true);
			}
			
		return commonUtils.setApiResponses("Role : "+loginEntity.getRole(), "Only CLIENT can add project !!", false);
			
		}
		return commonUtils.setApiResponses(null, "Duplicate project not allowed", false);
	}

	
	
	@Override
	public ApiResponse<?> deleteProject(ProjectDto name) {
		Project existProject = projectRepository.findByName(name.getProjectName());
		if(existProject !=null) {
			projectRepository.deleteByProjectName(existProject.getProjectName());
			return commonUtils.setApiResponses(existProject.getProjectName()
					, "Project deleted successfully", true);
		}
		return commonUtils.setApiResponses(null, "Can't delete project !!!", false);
	}

	@Override
	public ApiResponse<?> getMaxBudget() {
		
		return commonUtils.setApiResponses(projectRepository.MaxBudget(), "Maximun budget Project!!", true);
	}

	@Override
	public ApiResponse<?> getMinBudget() {
		
		return commonUtils.setApiResponses(projectRepository.MinBudget(), "Minimum bugted Project", true);
	}

	@Override
	public ApiResponse<?> getProjectName() {
		
		return commonUtils.setApiResponses(projectRepository.projectName(), "Project name fetched successfully", true);
	}

	@Override
	public ApiResponse<?> getNameAndMinBudget() {
		
		return commonUtils.setApiResponses(projectRepository.getMinBudgetAndNameOfProject(), "Project name and budget fetched successfully!!", true);
	}
	
	

}
