package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
	
	
	@Query("delete from User u where u.name =:name")
	User deleteByName(String name);
	
	 	 	
	
	@Query("SELECT u FROM User u WHERE u.name = :name")
    User findByName(String name);
	
	

}
