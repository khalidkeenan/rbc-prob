package com.rbc.prob.basket.item;

public class GeneralItem implements BasketItem{

	private final String name;
	private final double cost;
	
	public GeneralItem(String name, double cost) {
		this.name = name;
		this.cost = cost;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public double getCost() {
		return cost;
	}
	
	
}
