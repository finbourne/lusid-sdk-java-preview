

# CashDividendEventAllOf


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**grossAmount** | **java.math.BigDecimal** | The before tax amount for each share held being paid out to shareholders. | 
**paymentDate** | **OffsetDateTime** | The date the company pays out dividends to shareholders. | 
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



