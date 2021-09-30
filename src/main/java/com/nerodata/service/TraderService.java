package com.nerodata.service;

import com.nerodata.model.OutputTaxation;
import com.nerodata.model.Trader;
import com.nerodata.repository.TraderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class TraderService {

	private final TraderRepository traderRepository;

	public List<Trader> getAllTraders() {
		List<Trader> traders = new ArrayList<>();
		traderRepository.findAll().forEach(traders::add);
		return traders;
	}

	public Trader getTraderById(int id) {
		Optional<Trader> byId = traderRepository.findById(id);
		return byId.orElseThrow(() -> new EntityNotFoundException("Trader not found with id: " + id));
	}

	public Trader saveOrUpdate(Trader trader) {
		return traderRepository.save(trader);
	}

	public void delete(int id) {
		traderRepository.deleteById(id);
	}

	public OutputTaxation calculateTaxation(int traderId, double purchaseAmount) {
		OutputTaxation result = new OutputTaxation();
		Trader trader = getTraderById(traderId);
		double taxationAmount = trader.getTaxationAmount(purchaseAmount);
		result.setTaxRate(trader.getTaxRate());
		result.setNetSales(purchaseAmount - taxationAmount);
		result.setTaxAmount(taxationAmount);
		return result;
	}

}