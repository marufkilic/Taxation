package com.nerodata.service;

import java.util.ArrayList;  
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;

import com.nerodata.model.Trader;
import com.nerodata.repository.TraderRepository;  
 
  
@Service  
public class TraderService   
{  
	@Autowired  
	TraderRepository traderRepository;    
	public List<Trader> getAllTraders()   
	{  
		List<Trader> traders = new ArrayList<Trader>();  
		traderRepository.findAll().forEach(trader -> traders.add(trader));  
		return traders;  
	}  
  
	public Trader getTraderById(int id)   
	{  
		return traderRepository.findById(id).get();  
	}  
  
	public Trader saveOrUpdate(Trader trader)   
	{  
		return traderRepository.save(trader);  
	}  
  
	public void delete(int id)   
	{  
		traderRepository.deleteById(id);  
	}  
  
	public void update(Trader trader, int bookid)   
	{  
		traderRepository.save(trader);  
	}  
}  