package com.nerodata.model;

import lombok.Data;

@Data
public class OutputTaxation {

	private double taxRate;
	private double taxAmount;
	private double netSales;

}