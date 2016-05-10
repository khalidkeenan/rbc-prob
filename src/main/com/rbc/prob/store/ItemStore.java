package com.rbc.prob.store;

import static com.rbc.prob.store.source.SimpleItemSource.APPLES;
import static com.rbc.prob.store.source.SimpleItemSource.APPLES_NAME;
import static com.rbc.prob.store.source.SimpleItemSource.BANANAS;
import static com.rbc.prob.store.source.SimpleItemSource.BANANAS_NAME;
import static com.rbc.prob.store.source.SimpleItemSource.LEMONS;
import static com.rbc.prob.store.source.SimpleItemSource.LEMONS_NAME;
import static com.rbc.prob.store.source.SimpleItemSource.ORANGES;
import static com.rbc.prob.store.source.SimpleItemSource.ORANGES_NAME;
import static com.rbc.prob.store.source.SimpleItemSource.PEACHES;
import static com.rbc.prob.store.source.SimpleItemSource.PEACHES_NAME;

import java.util.HashMap;
import java.util.Map;

import com.rbc.prob.basket.item.BasketItem;

public class ItemStore {

	private final Map<String,BasketItem> availableItems = new HashMap<>(); 
	
	public ItemStore(){
		addAvailableFruitItems();
	}
	
	public boolean isItemAvailable(BasketItem basketItem) {
		return availableItems.containsKey(basketItem.getName());
	}
	
	//initialise fruit products that are available and set the relevant price.
	private void addAvailableFruitItems() {
		availableItems.put(APPLES_NAME, APPLES);
		availableItems.put(BANANAS_NAME, BANANAS);
		availableItems.put(ORANGES_NAME, ORANGES);
		availableItems.put(LEMONS_NAME, LEMONS);
		availableItems.put(PEACHES_NAME, PEACHES);
	}
	
	
}
