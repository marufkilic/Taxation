package com.nerodata.model;

public class OutputTaxation implements Taxation{

	private float taxRate;
	private float taxAmount;
	private float netSales;
	
	public OutputTaxation() {
		this.setTaxRate(0);
		this.setTaxAmount(0);
		this.setNetSales(0);
	}
	
	public void calculate(float taxRate, float purchaseAmount) {
		this.taxRate   = taxRate;
		this.taxAmount = purchaseAmount * taxRate;
		this.netSales  = purchaseAmount - this.taxAmount;
	}
	
	public float getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(float taxRate) {
		this.taxRate = taxRate;
	}

	public float getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(float taxAmount) {
		this.taxAmount = taxAmount;
	}

	public float getNetSales() {
		return netSales;
	}

	public void setNetSales(float netSales) {
		this.netSales = netSales;
	}
	
}