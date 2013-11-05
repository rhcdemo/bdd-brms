Feature: Determine Day Trader

@OLD
Scenario: Determine stock value

Given a stock "GOOG"
When the value of "GOOG" is high
Then sell "GOOG"

@Ask
Scenario: Determine high scrape condition

Given a stock "GOOG"
When the current value of "GOOG" is at a high scrape
Then ask to sell "GOOG"


@Bid
Scenario: Determine low scrape condition

Given a stock "GOOG"
When the current value of "GOOG" is at a low scrape
Then bid to buy "GOOG"


@WatchSell
Scenario: Determine potential sell condition

Given a stock "GOOG"
When the current value of "GOOG" approaches a high scrape
Then watch to sell "GOOG"


@WatchBuy
Scenario: Determine potential buy condition

Given a stock "GOOG"
When the current value of "GOOG" approaches a low scrape
Then watch to buy "GOOG"




