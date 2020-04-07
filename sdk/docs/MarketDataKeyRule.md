

# MarketDataKeyRule

A market data key rule describes a mapping for satisfying a particular market dependency. The supplier, scope, quote type and price side  information define the quote in the market and which Vendor for market data would be used to perform the lookup.  The market data key defines what dependency this satisfies. The key is a rule that describes the asset class, its identifier and any other  specifics required to uniquely describe a specific economic entity (e.g. an Fx currency pair, equity name or credit curve).
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**key** | **String** | The market data key pattern which this is a rule for. A dot separated string (A.B.C.D.*) | 
**supplier** | [**SupplierEnum**](#SupplierEnum) | The market data supplier (where the data comes from) | 
**dataScope** | **String** | The scope in which the data should be found when using this rule. | 
**quoteType** | [**QuoteTypeEnum**](#QuoteTypeEnum) | Is the quote to be looked for a price, yield etc. | 
**field** | **String** | The conceptual qualification for the field, such as bid, mid, or ask.   The field must be one of a defined set for the given supplier, in the same way as it  is for the Finbourne.WebApi.Interface.Dto.Quotes.QuoteSeriesId | 
**quoteInterval** | **String** | Shorthand for the time interval used to select market data. |  [optional]
**asAt** | [**OffsetDateTime**](OffsetDateTime.md) | The AsAt predicate specification. |  [optional]



## Enum: SupplierEnum

Name | Value
---- | -----
DATASCOPE | &quot;DataScope&quot;
LUSID | &quot;Lusid&quot;
ISDA | &quot;Isda&quot;
CLIENT | &quot;Client&quot;
EDI | &quot;Edi&quot;
TRADERMADE | &quot;TraderMade&quot;
FACTSET | &quot;FactSet&quot;



## Enum: QuoteTypeEnum

Name | Value
---- | -----
PRICE | &quot;Price&quot;
SPREAD | &quot;Spread&quot;
RATE | &quot;Rate&quot;
LOGNORMALVOL | &quot;LogNormalVol&quot;
NORMALVOL | &quot;NormalVol&quot;
PARSPREAD | &quot;ParSpread&quot;
ISDASPREAD | &quot;IsdaSpread&quot;
UPFRONT | &quot;Upfront&quot;



