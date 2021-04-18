package com.personal.apisecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personal.apisecurity.model.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

}
