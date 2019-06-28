

# MarketDataKeyRule

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**key** | **String** | The market data key pattern which this is a rule for. A dot separated string (A.B.C.D.*) | 
**supplier** | [**SupplierEnum**](#SupplierEnum) | The market data supplier (where the data comes from) | 
**dataScope** | **String** | The scope in which the data should be found when using this rule. | 
**quoteType** | [**QuoteTypeEnum**](#QuoteTypeEnum) | Is the quote to be looked for a price, yield etc. |  [optional]
**priceSide** | [**PriceSideEnum**](#PriceSideEnum) | The conceptual qualification for the field. Something like Bid, Ask or Mid. |  [optional]



## Enum: SupplierEnum

Name | Value
---- | -----
DATASCOPE | &quot;DataScope&quot;
LUSID | &quot;Lusid&quot;



## Enum: QuoteTypeEnum

Name | Value
---- | -----
PRICE | &quot;Price&quot;
SPREAD | &quot;Spread&quot;
RATE | &quot;Rate&quot;



## Enum: PriceSideEnum

Name | Value
---- | -----
BID | &quot;Bid&quot;
MID | &quot;Mid&quot;
ASK | &quot;Ask&quot;



