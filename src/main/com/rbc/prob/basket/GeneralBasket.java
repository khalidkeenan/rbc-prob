package com.rbc.prob.basket;

import java.util.List;

import com.rbc.prob.basket.item.BasketItem;

public class GeneralBasket implements Basket{

	private final List<BasketItem> basketItems;

	public GeneralBasket(List<BasketItem> basketItems) {
		this.basketItems = basketItems;
	}

	public List<BasketItem> getBasketItems() {
		return basketItems;
	}
	
}
