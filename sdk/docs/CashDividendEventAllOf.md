

# CashDividendEventAllOf


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**paymentDate** | **OffsetDateTime** | The date the company begins distributing the dividend. | 
**exDate** | **OffsetDateTime** | The first business day on which the dividend is not owed to the buying party. | 
**cashElections** | [**List&lt;CashElection&gt;**](CashElection.md) | Possible elections for this event, each keyed with a unique identifier. | 
**announcementDate** | **OffsetDateTime** | Date on which the dividend is announced by the company. |  [optional]
**recordDate** | **OffsetDateTime** | Date you have to be the holder of record in order to participate in the tender. |  [optional]
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



