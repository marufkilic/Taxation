package com.nerodata.repository;

import org.springframework.data.repository.CrudRepository;

import com.nerodata.model.Trader;  

//repository that extends CrudRepository  
public interface TraderRepository extends CrudRepository<Trader, Integer>  
{  
} 