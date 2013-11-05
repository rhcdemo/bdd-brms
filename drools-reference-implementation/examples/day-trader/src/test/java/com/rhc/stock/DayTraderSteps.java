package com.rhc.stock;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.annotation.Resource;

import org.drools.logger.KnowledgeRuntimeLogger;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rhc.drools.reference.StatelessDroolsComponent;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

@ContextConfiguration
@RunWith(Cucumber.class)
public class DayTraderSteps {
	
	@Resource(name = "stocksDroolsComponent")
	private StatelessDroolsComponent drools;
	static KnowledgeRuntimeLogger logger;

	Set<Stock> stocks = new HashSet<Stock>();
	private Stock stock;

	@Before
	public void init() throws MalformedURLException, IOException, ParseException {
	    Stock stock = new Stock();
	    stock.setName("GOOG");
	    stock.setTicker("GOOG");
	    stock.populateHistory();
	    stock.populateBollingerBands(stock.getHistory().get(stock.getHistory().lastKey()));
	    
	    

	}
	
	@SuppressWarnings("unchecked")
	@Given("^a stock \"([^\"]*)\"$")
	public void a_stock(String name) throws Throwable {
	    Stock stock = new Stock();
	    stock.setName(name);
	    stock.setTicker(name);
	    stock.populateHistory();
	   
	    stocks.add(stock);
	}

	@When("^the value of \"([^\"]*)\" is high$")
	public void the_value_of_is_high(String arg1) throws Throwable {
	    // Express the Regexp above with the code you wish you had
		if (!stocks.isEmpty()){
			Iterator<Stock> stockIT = stocks.iterator();
			while(stockIT.hasNext()){
				stock = stockIT.next();
				if (stock.getName().equalsIgnoreCase(arg1)){
//					if (stock.getQuote().getValue().compareTo(new Float(100)) > 0 ){
//						System.out.println("The most current value of " + arg1 + "--" + stock.getQuote().getValue() + "-- is high.");
//					}
					drools.execute(stock, Stock.class);
				}
			}
		}
//	    throw new PendingException();
	}

	@Then("^sell \"([^\"]*)\"$")
	public void sell(String arg1) throws Throwable {
	    // Express the Regexp above with the code you wish you had
		System.out.println("Selling " + arg1);
//	    throw new PendingException();
	}

}
