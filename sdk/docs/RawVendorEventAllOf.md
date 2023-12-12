

# RawVendorEventAllOf


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**effectiveAt** | **OffsetDateTime** | The effective date of the event | 
**eventValue** | [**LifeCycleEventValue**](LifeCycleEventValue.md) |  | 
**eventType** | **String** | What type of internal event does this represent; reset, exercise, amortisation etc. | 
**eventStatus** | **String** | What is the event status, is it a known (ie historic) or unknown (ie projected) event? | 
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



