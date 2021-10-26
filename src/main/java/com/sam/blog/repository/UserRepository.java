package com.sam.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sam.blog.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
