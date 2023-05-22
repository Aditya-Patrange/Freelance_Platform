package com.cluster.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cluster.app.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer>{


	@Query(value="select p from Project p where p.projectName = :pName")
	Project findByName(@Param("pName") String pName);

	@Query("delete from Project p where p.projectName = :pName")
	@Modifying
	void deleteByProjectName(@Param("pName") String pName);
	
	
	@Query(value="insert into Project  (projectName, projectDeadline) values (:pName , :pDeadline)")
	Project insertByNameAndBudget(@Param("pName") String pName, @Param("pDeadline") int pDuration);
	
	@Query(value="select max(p.projectEstimatedBudget) from Project p")
	int MaxBudget();
	
	
	@Query(value="select min(p.projectEstimatedBudget) from Project p")
	int MinBudget();
	
	@Query(value="select p.projectName from Project p ")
	List<String> projectName();
	
	@Query(value="select p.projectEstimatedBudget, p.projectName from Project p where p.projectEstimatedBudget=(select min(p.projectEstimatedBudget) from Project p)")
	List<Object> getMinBudgetAndNameOfProject();
	
	
}
