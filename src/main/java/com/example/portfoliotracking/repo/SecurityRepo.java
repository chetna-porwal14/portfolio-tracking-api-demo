package com.example.portfoliotracking.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.portfoliotracking.entity.Security;

public interface SecurityRepo extends JpaRepository<Security, String>{

}
