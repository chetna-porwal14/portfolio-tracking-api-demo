package com.example.portfoliotracking.entity;

import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Getter;
import lombok.NoArgsConstructor;

@JsonSerialize
@Getter
@NoArgsConstructor
@ResponseBody
public class HoldingsResponse {
	
	private String securityName;
	private Integer finalQuantity;
	private Double avgBuyPrice;
	
	public HoldingsResponse(Security security)
	{
		this.securityName = security.getTickerSymbol();
		this.finalQuantity= security.getSharesQuantity();
		this.avgBuyPrice = security.getAvgPrice();
	}

}