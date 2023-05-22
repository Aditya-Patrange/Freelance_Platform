package com.cluster.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cluster.app.model.UserStatusEntity;

@Repository
public interface IUserStatusRepository extends JpaRepository<UserStatusEntity, Integer>{

}
