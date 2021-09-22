package com.example.portfoliotracking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.portfoliotracking.entity.Security;
import com.example.portfoliotracking.entity.Trade;
import com.example.portfoliotracking.enums.TradeType;
import com.example.portfoliotracking.repo.SecurityRepo;
import com.example.portfoliotracking.repo.TradeRepo;

@Service
public class TradeService {

	@Autowired
	private TradeRepo repo;

	@Autowired
	private SecurityRepo srepo;

	public Trade addTrade(Trade t, String security_id) throws Exception {

		Security security = srepo.findById(security_id).get();
		if (!security.equals(null)) {
			t.setSecurityId(security_id);
			if (t.getTradeType() == TradeType.BOUGHT) {
				security.setTickerSymbol(security_id);
				security.setAvgPrice(((security.getAvgPrice() * security.getSharesQuantity())
						+ (t.getSharePrice() * t.getShareCount()))
						/ (security.getSharesQuantity() + t.getShareCount()));
				security.setSharesQuantity(security.getSharesQuantity() + t.getShareCount());

				srepo.save(security);
			} else {
				security.setTickerSymbol(security_id);
				security.setSharesQuantity(security.getSharesQuantity() - t.getShareCount());
				srepo.save(security);
			}
			return repo.save(t);
		} else {
			throw new Exception("wrong security id");
		}
	}

	public Trade updateTrade(Trade tr, Integer tradeId) throws Exception {
		Trade trade = repo.getById(tradeId);

		if (trade != null) {
			trade.setId(tradeId);
			trade.setSecurityId(tr.getSecurityId());
			trade.setShareCount(tr.getShareCount());
			trade.setTradeType(tr.getTradeType());
			trade.setSharePrice(tr.getSharePrice());
			return repo.save(trade);
		} else {
			throw new Exception("Invalid trade id");
		}
	}

	public String deleteTrade(Integer tradeId) {
		repo.deleteById(tradeId);
		return "Trade deleted successfully!!";
	}
}