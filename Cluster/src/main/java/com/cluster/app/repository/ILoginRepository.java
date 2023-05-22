package com.cluster.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cluster.app.dto.LoginDto;
import com.cluster.app.model.LoginEntity;

@Repository
public interface ILoginRepository extends JpaRepository<LoginEntity, Integer>{

	@Query(value="select l from LoginEntity l where l.email = :lemail")
	LoginEntity findByEmail(@Param("lemail") String email);
	

	@Modifying
	@Query(value="insert into LoginEntity (email, password, role) values(:email, :password, :roleId)")
	void insertByEmailPasswordAndRoleId(@Param("email") String email, @Param("password") String password, 
															  @Param("roleId") int roleId);
	
	
	@Query(value="select l from LoginEntity l where l.email = :email")
	LoginEntity getAllData(@Param("email") String email);


	//LoginEntity findAllById(LoginEntity clientId);
	


}
