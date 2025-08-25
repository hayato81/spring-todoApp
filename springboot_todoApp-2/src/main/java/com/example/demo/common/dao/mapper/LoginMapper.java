package com.example.demo.common.dao.mapper;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.common.dao.entity.Login;

public interface LoginMapper extends  JpaRepository<Login, Long> {
	 Optional<Login> findByUsername(String username);
}
