Feature: Determine Day Trader

@OLD
Scenario: Determine stock value

Given a stock "GOOG"
When the value of "GOOG" is high
Then sell "GOOG"

@Ask
Scenario: Determine to ask

Given a current price of "26.00" for a stock "GOOG"
And a day open of "25.00"
And a daily volatility of ".25" USD
When determining an action for stock "GOOG" 
Then ask to sell stock "GOOG" for "25.99"

@Bid
Scenario: Determine to bid

Given a current price of "10.00" for a stock "GOOG"
And a day open of "11.00"
And a daily volatility of ".25" USD
When determining an action for stock "GOOG"
Then bid to buy "GOOG" for "10.01"