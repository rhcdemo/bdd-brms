package com.rhc.stock;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.rhc.drools.reference.DroolsRequest;

public class StockQuote implements DroolsRequest{
	
	private Stock stock;
	private Float value;
	private Float volatility;

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	public Float getVolatility() {
		return volatility;
	}

	public void setVolatility(Float volatility) {
		this.volatility = volatility;
	}

	@Override
	public Collection<Object> getAllFacts() {
		Set<Object> set = new HashSet<Object>();
		set.add( getStock() );
		set.add( getValue() );
		set.add( getVolatility() );
		set.add( this );
		return set;
	}

	@Override
	public String getProcessId() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
