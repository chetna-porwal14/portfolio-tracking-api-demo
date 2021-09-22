package com.example.portfoliotracking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Positive;

import com.example.portfoliotracking.enums.TradeType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Trade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="trade_type")
	private TradeType tradeType;
	@Column(name="share_count")
	@Positive
	private Integer shareCount;
	@Column(name="share_price")
	private Double sharePrice;
	
    @Column(name = "security_id")
    private String securityId;
}
