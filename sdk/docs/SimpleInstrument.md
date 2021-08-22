

# SimpleInstrument

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**maturityDate** | [**OffsetDateTime**](OffsetDateTime.md) | The final maturity date of the instrument. This means the last date on which the instruments makes a payment of any amount.  For the avoidance of doubt, that is not necessarily prior to its last sensitivity date for the purposes of risk; e.g. instruments such as  Constant Maturity Swaps (CMS) often have sensitivities to rates beyond their last payment date |  [optional]
**domCcy** | **String** | The domestic currency | 
**assetClass** | [**AssetClassEnum**](#AssetClassEnum) | The available values are: InterestRates, FX, Inflation, Equities, Credit, Commodities, Unknown | 
**fgnCcys** | **List&lt;String&gt;** | The set of foreign currencies, if any (optional) |  [optional]
**simpleInstrumentType** | **String** | The Instrument type of the simple instrument | 



## Enum: AssetClassEnum

Name | Value
---- | -----
INTERESTRATES | &quot;InterestRates&quot;
FX | &quot;FX&quot;
INFLATION | &quot;Inflation&quot;
EQUITIES | &quot;Equities&quot;
CREDIT | &quot;Credit&quot;
COMMODITIES | &quot;Commodities&quot;
UNKNOWN | &quot;Unknown&quot;



