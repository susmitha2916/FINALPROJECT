package com.vp.repository;

import org.springframework.data.repository.CrudRepository;

import com.vp.model.User;

public interface UserRepository  extends CrudRepository<User, Long>{

}
