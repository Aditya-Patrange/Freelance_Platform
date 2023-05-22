package com.cluster.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cluster.app.model.LoginEntity;

@Repository
public interface IUserRepository extends JpaRepository<LoginEntity, Integer>{

	@Query(value="select u.email from LoginEntity u ")
	List<String> getAllRegisteredUsers();
}
