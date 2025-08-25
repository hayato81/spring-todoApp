package com.example.demo.common.dao.mapper;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.common.dao.entity.User;


public interface UserMapper extends JpaRepository<User, Long> {
	User findByUsername(String username);
	boolean existsByUsername(String username);
}
