package com.nerodata.repository;

import com.nerodata.model.Trader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraderRepository extends CrudRepository<Trader, Integer> {
}