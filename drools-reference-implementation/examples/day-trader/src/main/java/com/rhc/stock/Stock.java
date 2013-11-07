package com.rhc.stock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;
import java.math.*;

import com.rhc.drools.reference.DroolsRequest;

public class Stock implements DroolsRequest{
	
	private String name;
	private String ticker;
	private StockQuote quote;
	private SortedMap<Date, StockDay> history = new TreeMap<Date, StockDay>();
	private static int BOLLINGER_LENGTH = 10;
	
	
	public SortedMap<Date, StockDay> getHistory() {
		return history;
	}

	public void setHistory(SortedMap<Date, StockDay> history) {
		this.history = history;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public StockQuote getQuote() {
		return quote;
	}
	public void setQuote(StockQuote quote) {
		this.quote = quote;
	}
	@Override
	public Set<Object> getAllFacts() {
		Set<Object> set = new HashSet<Object>();
		set.add( getName() );
		set.add( getTicker() );
		set.add( getHistory() );
		set.add( getQuote() );
		set.add( this );
		return set;
	}
	@Override
	public String getProcessId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//Populates the history with trading information from the past 30 calendar days from Yahoo Finance
	public void populateHistory() throws IOException, ParseException, MalformedURLException {
		Date date = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    
	    // Set up a connection to the Yahoo Finance CSV url
	    URL url = new URL(getHistoryUrl());
	    URLConnection urlConn = url.openConnection();
	    InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream());
	    BufferedReader buff = new BufferedReader(inStream);
	    
	    // Spreadsheet Header (1st row) is ommitted
	    buff.readLine();
	    
	    // Prepare each line of spreadsheet data and assign values to POJOs
	    String data;
	    String [] line;

	    while((data = buff.readLine()) != null){
	    	line = data.split(",");
	    	date = sdf.parse(line[0]);
	    	StockDay stockDay = new StockDay();
			stockDay.setDay(date);
			
			stockDay.setDayOpen((float) Double.parseDouble(line[1]));
			stockDay.setDayHigh((float) Double.parseDouble(line[2]));
			stockDay.setDayLow((float) Double.parseDouble(line[3]));
			stockDay.setDayClose((float) Double.parseDouble(line[4]));
			
//			System.out.println(name + "--" + stockDay.getDay().toString() + "--" + stockDay.getDayOpen() + "--" + stockDay.getDayHigh() + "--" + stockDay.getDayLow() + "--" + stockDay.getDayClose());
						
			this.getHistory().put(date, stockDay);
	    }
	    
	    inStream.close();
	    populateBollingerBands();
	    this.updateQuote();
	}

	//Updates the quote with information from the most recent day in history
	public void updateQuote() {
		StockQuote quote = new StockQuote();
		quote.setStock(this);

		Date currentDay = getHistory().lastKey();
		
		StockDay stockDay = new StockDay();
		stockDay = getHistory().get(currentDay);
		
		quote.setValue(stockDay.getDayClose());
		setQuote(quote);
	}
	
	//Creates the url to access Yahoo Finance historical information from last 30 calendary days
	private String getHistoryUrl(){
		String url = new String();
		StringBuffer sb = new StringBuffer();
		
		Integer startMonth = Calendar.getInstance().get(Calendar.MONTH) - 1;
		Integer startDay = Calendar.getInstance().get(Calendar.DATE);
		Integer startYear = Calendar.getInstance().get(Calendar.YEAR);
		Integer endMonth = Calendar.getInstance().get(Calendar.MONTH);
		Integer endDay = Calendar.getInstance().get(Calendar.DATE);
		Integer endYear = Calendar.getInstance().get(Calendar.YEAR);
		
		sb.append("http://ichart.yahoo.com/table.csv?s=");
		sb.append(getTicker());
		sb.append("&a=");
		sb.append( startMonth );
		sb.append("&b=");
		sb.append(startDay);
		sb.append("&c=");
		sb.append(startYear);
		sb.append("&d=");
		sb.append( endMonth );
		sb.append("&e=");
		sb.append(endDay);
		sb.append("&f=");
		sb.append(endYear);
		
		url = sb.toString();
		System.out.println(url);
		return url;
		
	}
	
	
	public void populateBollingerBands() {
		Set<StockDay> days = (Set<StockDay>) history.values();
		List<StockDay> dayList = new ArrayList<StockDay>();
		dayList.addAll(days);
		Collections.sort(dayList);
		ListIterator<StockDay> dayIt = dayList.listIterator();
		for (int i=0; i< BOLLINGER_LENGTH; i++) {
		        dayIt.next();
		}
		while(dayIt.hasNext()){
			ListIterator<StockDay> it = dayIt;
			while(it.hasPrevious()) {
				
			}
		}


		
	}
	
	
	//Pupulates information on Bollinger Band for a specific day
	public void populateBollingerBands(StockDay day) {
		//If there is not enough history, the band for that day will not be created
		//If there is enough history, the band will be created using all historical information available
		if(!history.isEmpty() && history.size() > BOLLINGER_LENGTH) {
			float middleBand = new Float(0);
			float upperBand = new Float(0);
			float lowerBand = new Float(0);
			
			// Determine the middle Bollinger Band
			for (Date date : getHistory().keySet()){
					middleBand += history.get(date).getDayClose() ;
					
			}
			middleBand /= history.size();
			day.setMiddleBand(middleBand);
			
			float sd = standardDeviation(middleBand);
			
			// Determine the bands based on the standard deviation
			upperBand = middleBand + 2*sd;
			lowerBand = middleBand - 2*sd;
			day.setUpperBand(upperBand);
			day.setLowerBand(lowerBand);
			
			//TODO: Remove when not debugging
			//System.out.println(day.getDay().toString() + "--MB--" + middleBand + "--SD--" + sd + "--LB--" + lowerBand + "--UB--" + upperBand);
		}
		//TODO: Remove when not debugging
		System.out.println(day.getDay().toString() + "--MB--" + day.getMiddleBand() + "--LB--" + day.getLowerBand() + "--UB--" + day.getUpperBand());

	}
	
	//Determines the standard deviation of the closing price
	private float standardDeviation(float average) {
		// Determine the std deviation for the Upper & Lower Bands
		float sd = new Float(0.0);
		for (Date date : getHistory().keySet()){
				sd = (float) (sd + Math.pow(history.get(date).getDayClose() - average, 2));
		}
		
		sd = (float) Math.sqrt(sd/(history.size()-1));
		return sd;
	}
		
}
