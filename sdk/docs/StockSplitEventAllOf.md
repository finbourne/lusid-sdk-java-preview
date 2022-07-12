

# StockSplitEventAllOf


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**equitySplitRatio** | **java.math.BigDecimal** | This number describes the rate at which the company will be dividing their current shares outstanding. It is displayed as new shares per old. | 
**paymentDate** | **OffsetDateTime** | Date on which the stock-split takes effect. | 
**recordDate** | **OffsetDateTime** | Date you have to be the holder of record in order to participate in the tender. | 
**instrumentEventType** | [**InstrumentEventTypeEnum**](#InstrumentEventTypeEnum) | The Type of Event. The available values are: TransitionEvent, InternalEvent, CouponEvent, OpenEvent, CloseEvent, StockSplitEvent, BondDefaultEvent, CashDividendEvent | 



## Enum: InstrumentEventTypeEnum

Name | Value
---- | -----
TRANSITIONEVENT | &quot;TransitionEvent&quot;
INTERNALEVENT | &quot;InternalEvent&quot;
COUPONEVENT | &quot;CouponEvent&quot;
OPENEVENT | &quot;OpenEvent&quot;
CLOSEEVENT | &quot;CloseEvent&quot;
STOCKSPLITEVENT | &quot;StockSplitEvent&quot;
BONDDEFAULTEVENT | &quot;BondDefaultEvent&quot;
CASHDIVIDENDEVENT | &quot;CashDividendEvent&quot;



