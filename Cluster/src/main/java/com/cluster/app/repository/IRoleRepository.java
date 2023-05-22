package com.cluster.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cluster.app.model.RoleEntity;
@Repository
public interface IRoleRepository extends JpaRepository<RoleEntity, Integer>{

	
//	@Query(value="select r from RoleEntity r where r.roleName = :rName")
//	RoleEntity findByRoleName(@Param("rName") String rName);
	
	RoleEntity findByRoleName(String roleName);
}
