package com.rhc.stock;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.rhc.drools.reference.DroolsRequest;

public class StockQuote{
	
	private Stock stock;
	private Float price;
	private Float volatility;

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Float getVolatility() {
		return volatility;
	}

	public void setVolatility(Float volatility) {
		this.volatility = volatility;
	}
	
	
}
