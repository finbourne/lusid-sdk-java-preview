

# QuoteId

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**provider** | **String** |  | 
**priceSource** | **String** |  |  [optional]
**instrumentId** | **String** |  | 
**instrumentIdType** | [**InstrumentIdTypeEnum**](#InstrumentIdTypeEnum) |  | 
**quoteType** | [**QuoteTypeEnum**](#QuoteTypeEnum) |  | 
**priceSide** | [**PriceSideEnum**](#PriceSideEnum) |  | 



## Enum: InstrumentIdTypeEnum

Name | Value
---- | -----
LUSIDINSTRUMENTID | &quot;LusidInstrumentId&quot;
FIGI | &quot;Figi&quot;
RIC | &quot;RIC&quot;
QUOTEPERMID | &quot;QuotePermId&quot;
ISIN | &quot;Isin&quot;
CURRENCYPAIR | &quot;CurrencyPair&quot;



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



