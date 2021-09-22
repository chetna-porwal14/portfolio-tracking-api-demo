package com.example.portfoliotracking.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.portfoliotracking.entity.Trade;

@Repository
public interface TradeRepo extends JpaRepository<Trade, Integer>{

}
