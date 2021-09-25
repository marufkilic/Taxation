package com.nerodata.model;

public class InputTaxation implements Taxation{
	private int traderId;
	private float purchaseAmount;
	
	public InputTaxation() {
		this.traderId = -1;
		this.purchaseAmount = 0;
	}
	
	public InputTaxation(int traderId, float purchaseAmount) {
		this.setTraderId(traderId);
		this.setPurchaseAmount(purchaseAmount);
	}

	public float getPurchaseAmount() {
		return purchaseAmount;
	}

	public void setPurchaseAmount(float purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}

	public int getTraderId() {
		return traderId;
	}

	public void setTraderId(int traderId) {
		this.traderId = traderId;
	}
}
