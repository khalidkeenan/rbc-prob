package com.rbc.prob.basket.cost;

import java.util.Map;

import com.rbc.prob.basket.item.BasketItem;

public interface BasketCostCalculator {

	public double calculateCost(Map<BasketItem,Integer> basketItemsAndQuantity);
	
}
