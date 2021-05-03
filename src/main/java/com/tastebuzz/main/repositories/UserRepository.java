package com.tastebuzz.main.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tastebuzz.main.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	User findUserByEmail(String Email);
	List<User> findAll();
}
