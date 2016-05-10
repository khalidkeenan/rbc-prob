package com.rbc.prob.basket.cost;

import java.util.Map;

import com.rbc.prob.basket.item.BasketItem;
import com.rbc.prob.store.ItemStore;

public class DefaultBasketCostCalculator implements BasketCostCalculator{

	private final ItemStore itemStore;
	
	public DefaultBasketCostCalculator(ItemStore itemStore) {
		this.itemStore = itemStore;
	}

	/**
	 *  Calculates the cost of all items that are available in the store. Any items in the request list that
	 *  are unavailable are ignored and not included in the cost.
	 *  
	 */
	@Override
	public double calculateCost(Map<BasketItem,Integer> basketItemsAndQuantity) {
		
		if(basketItemsAndQuantity == null || basketItemsAndQuantity.isEmpty()) {
			return 0;
		}
		
		double cost = basketItemsAndQuantity 
			.entrySet()
			.stream()
			.filter(e -> itemStore.isItemAvailable(e.getKey()))
			.mapToDouble(e -> e.getKey().getCost() * e.getValue())
			.sum();
		
		return cost;
	}

}
