

# QuoteSeriesId

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**provider** | **String** |  | 
**priceSource** | **String** |  |  [optional]
**instrumentId** | **String** |  | 
**instrumentIdType** | [**InstrumentIdTypeEnum**](#InstrumentIdTypeEnum) |  | 
**quoteType** | [**QuoteTypeEnum**](#QuoteTypeEnum) |  | 
**field** | **String** |  | 



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



