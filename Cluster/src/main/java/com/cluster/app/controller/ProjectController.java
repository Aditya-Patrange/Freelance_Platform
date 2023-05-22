package com.cluster.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cluster.app.dto.ProjectDto;
import com.cluster.app.service.IProjectService;


@RestController
@RequestMapping("/api")
public class ProjectController {

	@Autowired
	private IProjectService projectService;

	@GetMapping("/test")
	public String test() {
		return "testing !!";
	}

	@GetMapping("/getAllProjectList")
	public ResponseEntity<?> getAllProjectList() {
		return new ResponseEntity<>(projectService.getProjectList(), HttpStatus.OK);
	}

	@PostMapping("/addProject")
	public ResponseEntity<?> saveProject(@RequestBody ProjectDto data) {

		return new ResponseEntity<>(projectService.addProject(data), HttpStatus.OK);
	}

	@DeleteMapping("/deleteProject")
	public ResponseEntity<?> deleteProject(@RequestBody ProjectDto name) {
		return new ResponseEntity<>(projectService.deleteProject(name), HttpStatus.OK);
	}
	
	@GetMapping("/getmaxBudgetedProject")
	public ResponseEntity<?> getMaximumBudgetedProject(){
		return new ResponseEntity<>(projectService.getMaxBudget(), HttpStatus.OK);
	}
	
	@GetMapping("/getminBugetedProject")
	public ResponseEntity<?> getMinimumBudgtedProject(){
		return new ResponseEntity<>(projectService.getMinBudget(), HttpStatus.OK);
	}
	
	@GetMapping("/getMinBudgetAndNameOfProject")
	public ResponseEntity<?> getMinBudgetAndNameOfProject(){
		return new ResponseEntity<>(projectService.getNameAndMinBudget(),HttpStatus.OK);
	}
}
