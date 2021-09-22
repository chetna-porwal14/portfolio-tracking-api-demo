package com.example.portfoliotracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.portfoliotracking.entity.Trade;
import com.example.portfoliotracking.service.TradeService;

@RestController
@RequestMapping("/trade")
public class TradeController {
	
	@Autowired
	private TradeService service;
	
	@PostMapping("/add/{security_id}")
	public Trade addTrade(@RequestBody @Validated Trade trade, @PathVariable("security_id") String security_id) throws Exception {
		
		return service.addTrade(trade,security_id);
		
	}
	
	@PutMapping("/update/{trade_id}")
	public Trade updateTrade(@RequestBody @Validated Trade trade, @PathVariable("trade_id") Integer trade_id) throws Exception {
		return service.updateTrade(trade, trade_id);
	}
	
	@DeleteMapping("/remove/{trade_id}")
	public String removeTrade(@PathVariable("trade_id") Integer trade_id) {
		return service.deleteTrade(trade_id);
	}
}