package com.nerodata.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.PostMapping;  
import org.springframework.web.bind.annotation.RequestBody;  
import org.springframework.web.bind.annotation.RestController;

import com.nerodata.model.InputTaxation;
import com.nerodata.model.OutputTaxation;
import com.nerodata.model.Trader;
import com.nerodata.service.TraderService;  
  
@RestController  
public class TraderController   
{ 
	@Autowired  
	TraderService traderService;  

	
	@GetMapping("/trader")  
	private List<Trader> getAllTraders()   
	{  
		return traderService.getAllTraders();
	}  
	
	@PostMapping("/calculate")
	private ResponseEntity<Object> test(@RequestBody InputTaxation taxation)
	{
		  try {
			  Trader trader = traderService.getTraderById(taxation.getTraderId());
				if (trader != null) {
					OutputTaxation result = new OutputTaxation();
					result.calculate(trader.getTaxRate(), taxation.getPurchaseAmount());
					return new ResponseEntity<>(result, HttpStatus.OK);
				} else {
					return new ResponseEntity<>("Invalid TraderId", HttpStatus.NOT_FOUND);
				}
				
		    }
		    catch(Exception e) {
		    	return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		    }
	}

	@GetMapping("/trader/{id}")
	private Trader getTrader(@PathVariable("id") int id)   
	{  
		return traderService.getTraderById(id);  
	}  
	
	@DeleteMapping("/trader/{id}")  
	private void deleteTrader(@PathVariable("id") int id)   
	{  
		traderService.delete(id);  
	}  

	@PostMapping("/trader")  
	private ResponseEntity<Object> saveTrader(@RequestBody Trader trader)   
	{  
		try {
			traderService.getTraderById(trader.getTraderId());
			return new ResponseEntity<>("The trader you want to add is already added. Please try with different id.", HttpStatus.CONFLICT);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(traderService.saveOrUpdate(trader), HttpStatus.OK);
		}
	}  
}  