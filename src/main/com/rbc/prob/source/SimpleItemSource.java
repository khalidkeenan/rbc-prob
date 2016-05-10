package com.rbc.prob.source;

import com.rbc.prob.basket.item.GeneralItem;

public class SimpleItemSource {

	public final static String BANANAS_NAME = "Bananas";
	public final static String ORANGES_NAME = "Oranges";
	public final static String APPLES_NAME = "Apples";
	public final static String LEMONS_NAME = "Lemons";
	public final static String PEACHES_NAME = "Peaches";
	
	public final static double BANANAS_COST = 2;
	public final static double ORANGES_COST = 1.5;
	public final static double APPLES_COST = 1;
	public final static double LEMONS_COST = 1;
	public final static double PEACHES_COST = 5;
	
	public final static GeneralItem APPLES = new GeneralItem(APPLES_NAME, APPLES_COST);
	public final static GeneralItem BANANAS = new GeneralItem(BANANAS_NAME, BANANAS_COST);
	public final static GeneralItem ORANGES = new GeneralItem(ORANGES_NAME, ORANGES_COST);
	public final static GeneralItem LEMONS = new GeneralItem(LEMONS_NAME, LEMONS_COST);
	public final static GeneralItem PEACHES = new GeneralItem(PEACHES_NAME, PEACHES_COST);
	
}
