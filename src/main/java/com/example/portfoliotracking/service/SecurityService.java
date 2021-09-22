package com.example.portfoliotracking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.portfoliotracking.entity.Security;
import com.example.portfoliotracking.repo.SecurityRepo;

@Service
public class SecurityService {
	
	@Autowired
	private SecurityRepo repo;
	
	private final double CURRENT_PRICE = 100;
	
	public List<Security> listAllSecurityWithTrades()
	{
		return repo.findAll();
	}
	
	public double fetchReturns() {
		double returns = 0;
		List<Security> securities= repo.findAll();
		for(Security s:securities) {
			returns = returns + ((CURRENT_PRICE - s.getAvgPrice()) * 
					s.getSharesQuantity());

		}
		return returns;
	}
}