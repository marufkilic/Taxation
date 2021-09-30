package com.nerodata.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "traders")
public class Trader implements Taxation {

	@Id
	@Column(name = "traderId")
	private int traderId;

	@Column(name = "taxRate")
	private double taxRate;

	@Override
	public double getTaxationAmount(double amount) {
		return amount * taxRate;
	}
}