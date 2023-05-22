package com.cluster.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cluster.app.model.ProjectStatus;

@Repository
public interface IProjectStatusRepository extends JpaRepository<ProjectStatus, Integer>{

}
