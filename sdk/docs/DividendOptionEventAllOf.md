

# DividendOptionEventAllOf


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**announcementDate** | **OffsetDateTime** | Date on which the dividend was announced / declared. |  [optional]
**cashElections** | [**List&lt;CashElection&gt;**](CashElection.md) | CashElection for this DividendReinvestmentEvent | 
**exDate** | **OffsetDateTime** | The first business day on which the dividend is not owed to the buying party.  Typically this is T-1 from the RecordDate. | 
**paymentDate** | **OffsetDateTime** | The date the company pays out dividends to shareholders. | 
**recordDate** | **OffsetDateTime** | Date you have to be the holder of record in order to participate in the tender. |  [optional]
**securityElections** | [**List&lt;SecurityElection&gt;**](SecurityElection.md) | SecurityElection for this DividendReinvestmentEvent | 
**securitySettlementDate** | **OffsetDateTime** | Date on which the dividend was the security settles.  Equal to the PaymentDate if not provided. |  [optional]
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



