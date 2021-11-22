package xpense;

import java.util.ArrayList;
import java.util.Scanner;

public class Investments {
	private double boughtPrice;
	private double boughtCount;
	private String stockSymbol;
	private double costBasis;

	public Investments(String symbol, double boughtCount, double boughtPrice){
		this.stockSymbol = symbol;
		this.boughtCount = boughtCount;
		this.boughtPrice = boughtPrice;

	}
	public double getBoughtCount(){
		return boughtCount;
	}
	public double getBoughtPrice(){
		return boughtPrice;
	}
	public double getCostBasis() {
		return costBasis;
	}
	public void costBasisCalc(ArrayList stocks){
		double costBasis = boughtPrice / boughtCount;
		this.costBasis = costBasis;
	}
	public String toString(){
		return this.stockSymbol + ": Count: " + this.boughtCount + " : Price: " + this.boughtPrice;
	}
}