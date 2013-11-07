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
import com.rhc.trade.TradeRequest;
import com.rhc.trade.TradeResponse;

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

	private Stock stock = new Stock();
	private StockDay day = new StockDay();
	private TradeResponse tradeResponse;

	@Before
	public void init() throws MalformedURLException, IOException, ParseException {
	}
	
	@Given("^a current price of \"([^\"]*)\" for a stock \"([^\"]*)\"$")
	public void a_current_price_of_for_a_stock(String price, String name) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    stock.setName(name);
	    StockQuote quote = new StockQuote();
	    quote.setPrice(Float.valueOf(price));
	    quote.setStock(stock);
	    stock.setQuote(quote);
//	    throw new PendingException();
	}

	@Given("^a day open of \"([^\"]*)\"$")
	public void a_day_open_of(String open) throws Throwable {
	    // Express the Regexp above with the code you wish you had
		day.setDayOpen(Float.valueOf(open));
		day.setStock(stock);
//	    throw new PendingException();
	}

	@Given("^a daily volatility of \"([^\"]*)\" USD$")
	public void a_daily_volatility_of_USD(String volatility) throws Throwable {
	    // Express the Regexp above with the code you wish you had
		stock.getQuote().setVolatility(Float.valueOf(volatility));
//	    throw new PendingException();
	}

	
	@When("^determining an action for stock \"([^\"]*)\"$")
	public void determining_an_action_for_stock(String arg1) throws Throwable {
		TradeRequest tradeRequest = new TradeRequest();
		tradeRequest.setDay(day);
		tradeRequest.setQuote(stock.getQuote());
		
		tradeResponse = drools.execute(tradeRequest, TradeResponse.class);
//	    throw new PendingException();
	}
	

	@Then("^ask to sell stock \"([^\"]*)\" for \"([^\"]*)\"$")
	public void ask_to_sell_stock_for(String name, String price) throws Throwable {
	    // Express the Regexp above with the code you wish you had
		String action = tradeResponse.getAction();
		if (action != null) {
			if (action.equalsIgnoreCase("sell"))
				System.out.println("Sell stock of " + name + " for " + price );
			
		}
//	    throw new PendingException();
	}

	@Then("^bid to buy \"([^\"]*)\" for \"([^\"]*)\"$")
	public void bid_to_buy_for(String name, String price) throws Throwable {
	    // Express the Regexp above with the code you wish you had
//	    throw new PendingException();
		String action = tradeResponse.getAction();
		if (action != null) {
			if (action.equalsIgnoreCase("buy"))
				System.out.println("Buy stock of " + name + " for " + price );
			
		}
	}
	
	@Then("^do not ask to sell \"([^\"]*)\"$")
	public void do_not_ask_to_sell(String name) throws Throwable {
	    // Express the Regexp above with the code you wish you had
		String action = tradeResponse.getAction();
		if (action == null) {
			System.out.println("Don't sell stock of " + name );		
		}
	}

	@Then("^do not bid to buy \"([^\"]*)\"$")
	public void do_not_bid_to_buy(String name) throws Throwable {
	    // Express the Regexp above with the code you wish you had
		String action = tradeResponse.getAction();
		if (action == null) {
			System.out.println("Don't buy stock of " + name );		
		}
	}


}
