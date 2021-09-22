package com.example.portfoliotracking.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.portfoliotracking.entity.HoldingsResponse;
import com.example.portfoliotracking.entity.Security;
import com.example.portfoliotracking.service.SecurityService;

@RestController
@RequestMapping("/other")
public class OtherController {

	@Autowired
	private SecurityService service;

	@GetMapping("/fetch/portfolio")
	public List<Security> fetchPortfolio() {
		return service.listAllSecurityWithTrades();
	}

	@GetMapping("/fetch/holdings")
	public List<HoldingsResponse> fetchHoldings() {
		List<Security> securities = service.listAllSecurityWithTrades();
		List<HoldingsResponse> holdingsResponse = new ArrayList<>();
		for (Security s : securities) {
			holdingsResponse.add(new HoldingsResponse(s));
		}
		return holdingsResponse;
	}

	@GetMapping("/fetch/returns")
	public double fetchReturns() {
		return service.fetchReturns();
	}
}