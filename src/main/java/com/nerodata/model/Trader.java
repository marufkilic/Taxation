package com.nerodata.model;

import javax.persistence.*;

@Entity
@Table(name = "traders")
public class Trader {

	@Id
	@Column(name = "traderId")
	private int traderId;

	@Column(name = "taxRate")
	private float taxRate;

	public Trader() {

	}

	public Trader(float taxRate) {
		this.taxRate = taxRate;
	}


	public int getTraderId() {
		return traderId;
	}

	
	public float getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(float taxRate) {
		this.taxRate = taxRate;
	}

	@Override
	public String toString() {
		return "";
	}

}