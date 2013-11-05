package com.rhc.stock;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.rhc.drools.reference.DroolsRequest;

@SuppressWarnings("rawtypes")
public class StockDay implements DroolsRequest, Comparable{

	private Stock stock;
	private Float dayOpen;
	private Float dayClose;
	private Float dayLow;
	private Float dayHigh;
	private Date day;
	private Float upperBand;
	private Float lowerBand;
	private Float middleBand;
	
	public Float getUpperBand() {
		return upperBand;
	}

	public void setUpperBand(Float upperBand) {
		this.upperBand = upperBand;
	}

	public Float getLowerBand() {
		return lowerBand;
	}

	public void setLowerBand(Float lowerBand) {
		this.lowerBand = lowerBand;
	}

	public Float getMiddleBand() {
		return middleBand;
	}

	public void setMiddleBand(Float middleBand) {
		this.middleBand = middleBand;
	}

	public StockDay() {
		day = new Date();
	}
	
	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Float getDayOpen() {
		return dayOpen;
	}

	public void setDayOpen(Float dayOpen) {
		this.dayOpen = dayOpen;
	}

	public Float getDayClose() {
		return dayClose;
	}

	public void setDayClose(Float dayClose) {
		this.dayClose = dayClose;
	}

	public Float getDayHigh() {
		return dayHigh;
	}

	public void setDayHigh(Float dayHigh) {
		this.dayHigh = dayHigh;
	}

	public Float getDayLow() {
		return dayLow;
	}

	public void setDayLow(Float dayLow) {
		this.dayLow = dayLow;
	}

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	@Override
	public Collection<Object> getAllFacts() {
		Set<Object> set = new HashSet<Object>();
		set.add( getStock() );
		set.add( getDayOpen() );
		set.add( getDayClose() );
		set.add( getDayHigh() );
		set.add( getDayLow() );
		set.add( getDay() );
		set.add( getUpperBand() );
		set.add( getLowerBand() );
		set.add( getMiddleBand() );
		set.add( this );
		return set;
	}

	@Override
	public String getProcessId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int compareTo(Object o) {
		return this.getDay().compareTo(((StockDay) o).getDay());
	}
	

}
