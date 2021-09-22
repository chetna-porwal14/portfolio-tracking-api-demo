package com.example.portfoliotracking.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Security {
	
	@Id
	private String tickerSymbol;
	
	private String listedCompanyName;
	
    @OneToMany(mappedBy = "securityId")
	private List<Trade> trades;
	
	private Double avgPrice;
	
	@Positive
	private Integer sharesQuantity;

}
