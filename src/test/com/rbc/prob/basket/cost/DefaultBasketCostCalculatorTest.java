package com.rbc.prob.basket.cost;

import static com.rbc.prob.source.SimpleItemSource.APPLES;
import static com.rbc.prob.source.SimpleItemSource.APPLES_COST;
import static com.rbc.prob.source.SimpleItemSource.BANANAS;
import static com.rbc.prob.source.SimpleItemSource.BANANAS_COST;
import static com.rbc.prob.source.SimpleItemSource.PEACHES;
import static com.rbc.prob.source.SimpleItemSource.PEACHES_COST;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.rbc.prob.basket.factory.ItemStore;
import com.rbc.prob.basket.item.BasketItem;
import com.rbc.prob.basket.item.GeneralItem;

public class DefaultBasketCostCalculatorTest {

	private final ItemStore testStore = new ItemStore();
	private DefaultBasketCostCalculator basketCostCalculator;
	
	@Before
	public void setUp(){
		basketCostCalculator = new DefaultBasketCostCalculator(testStore);
	}
	
	@Test
	public void testAvailableItemsWithSingleQuantity() {
		Map<BasketItem,Integer> itemList = new HashMap<>();
		itemList.put(APPLES, 1);
		itemList.put(BANANAS, 1);
		itemList.put(PEACHES, 1);
		
		double expectedcost = APPLES_COST + BANANAS_COST + PEACHES_COST;
		double cost = basketCostCalculator.calculateCost(itemList);
		assertEquals("incorrect expected cost.",expectedcost, cost, 0.00001);
	}
	
	@Test
	public void testAvailableItemsWithMultipleQuantities() {
		Map<BasketItem,Integer> itemList = new HashMap<>();
		itemList.put(APPLES, 2);
		itemList.put(BANANAS, 4);
		itemList.put(PEACHES, 3);
		
		double expectedcost = APPLES_COST*2 + BANANAS_COST*4 + PEACHES_COST*3;
		double cost = basketCostCalculator.calculateCost(itemList);
		assertEquals("incorrect expected cost.",expectedcost, cost, 0.00001);
	}
	
	@Test
	public void testUnavailableItemInRequest(){
		Map<BasketItem,Integer> itemList = new HashMap<>();
		itemList.put(APPLES, 1);
		itemList.put(BANANAS, 1);
		itemList.put(PEACHES, 1);
		itemList.put(new GeneralItem("UnavailableItem", 15), 2);
		
		double expectedcost = APPLES_COST + BANANAS_COST + PEACHES_COST;
		double cost = basketCostCalculator.calculateCost(itemList);
		assertEquals("unavaible item should not have been included in the cost calculation",expectedcost, cost, 0.00001);
	}
	
	@Test
	public void testOnlyUnavailableItemInRequest(){
		Map<BasketItem,Integer> itemList = new HashMap<>();
		itemList.put(new GeneralItem("UnavailableItem", 15), 2);
		
		double expectedcost = 0;
		double cost = basketCostCalculator.calculateCost(itemList);
		assertEquals("unavaible item should not have been included in the cost calculation",expectedcost, cost, 0.00001);
	}

	@Test
	public void testEmptyItemsRequest(){
		double expectedcost = 0;
		double cost = basketCostCalculator.calculateCost(new HashMap<>());
		assertEquals("empty request should return a cost of 0.",expectedcost, cost, 0.00001);
	}
	
	@Test
	public void testNullItemsRequest(){
		double expectedcost = 0;
		double cost = basketCostCalculator.calculateCost(null);
		assertEquals("null request should return a cost of 0.",expectedcost, cost, 0.00001);
	}
	
}
