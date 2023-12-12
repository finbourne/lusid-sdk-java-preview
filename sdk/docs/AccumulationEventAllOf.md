

# AccumulationEventAllOf


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**announcementDate** | **OffsetDateTime** | Date on which the dividend was announced / declared. |  [optional]
**dividendCurrency** | **String** | Payment currency | 
**dividendRate** | **java.math.BigDecimal** | Dividend rate or payment rate as a percentage.  i.e. 5% is written as 0.05 | 
**exDate** | **OffsetDateTime** | The first business day on which the dividend is not owed to the buying party.  Typically this is T-1 from the RecordDate. | 
**paymentDate** | **OffsetDateTime** | The date the company pays out dividends to shareholders. | 
**instrumentEventType** | [**InstrumentEventTypeEnum**](#InstrumentEventTypeEnum) | The Type of Event. The available values are: TransitionEvent, InformationalEvent, OpenEvent, CloseEvent, StockSplitEvent, BondDefaultEvent, CashDividendEvent, AmortisationEvent, CashFlowEvent, ExerciseEvent, ResetEvent, TriggerEvent, RawVendorEvent, InformationalErrorEvent, BondCouponEvent, DividendReinvestmentEvent, AccumulationEvent, BondPrincipalEvent, DividendOptionEvent | 



## Enum: InstrumentEventTypeEnum

Name | Value
---- | -----
TRANSITIONEVENT | &quot;TransitionEvent&quot;
INFORMATIONALEVENT | &quot;InformationalEvent&quot;
OPENEVENT | &quot;OpenEvent&quot;
CLOSEEVENT | &quot;CloseEvent&quot;
STOCKSPLITEVENT | &quot;StockSplitEvent&quot;
BONDDEFAULTEVENT | &quot;BondDefaultEvent&quot;
CASHDIVIDENDEVENT | &quot;CashDividendEvent&quot;
AMORTISATIONEVENT | &quot;AmortisationEvent&quot;
CASHFLOWEVENT | &quot;CashFlowEvent&quot;
EXERCISEEVENT | &quot;ExerciseEvent&quot;
RESETEVENT | &quot;ResetEvent&quot;
TRIGGEREVENT | &quot;TriggerEvent&quot;
RAWVENDOREVENT | &quot;RawVendorEvent&quot;
INFORMATIONALERROREVENT | &quot;InformationalErrorEvent&quot;
BONDCOUPONEVENT | &quot;BondCouponEvent&quot;
DIVIDENDREINVESTMENTEVENT | &quot;DividendReinvestmentEvent&quot;
ACCUMULATIONEVENT | &quot;AccumulationEvent&quot;
BONDPRINCIPALEVENT | &quot;BondPrincipalEvent&quot;
DIVIDENDOPTIONEVENT | &quot;DividendOptionEvent&quot;



