package com.personal.apisecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.personal.apisecurity.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("select u.profile.prfName from User u where u.usrEmail = :usrEmail")
	String getProfileByLogin(@Param("usrEmail") String login);
	
	@Query("select u.id from User u where u.usrEmail = :usrEmail")
	Long getUserIdByLogin(@Param("usrEmail") String login);
	
	public User findByEmail(String email);
}
