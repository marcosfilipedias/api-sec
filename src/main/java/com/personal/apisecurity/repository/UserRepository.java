package com.personal.apisecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.personal.apisecurity.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("select u.id from User u where u.login = :login")
	Integer getUserByLogin(@Param("login") String login);

}
