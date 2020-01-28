

# SwapInstrument

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**startDate** | [**OffsetDateTime**](OffsetDateTime.md) | Starting date of the swap | 
**maturityDate** | [**OffsetDateTime**](OffsetDateTime.md) | Maturity date of the swap | 
**legs** | [**List&lt;Leg&gt;**](Leg.md) | True if the swap is amortizing | 
**notional** | **Double** | The notional. | 
**isAmortizing** | **Boolean** | True if the swap is amortizing | 
**notionalExchange** | [**NotionalExchangeEnum**](#NotionalExchangeEnum) | True notional exchange type. | 
**instrumentType** | [**InstrumentTypeEnum**](#InstrumentTypeEnum) | Instrument type, must be property for JSON. | 



## Enum: NotionalExchangeEnum

Name | Value
---- | -----
NONE | &quot;None&quot;
INITIAL | &quot;Initial&quot;
FINAL | &quot;Final&quot;
BOTH | &quot;Both&quot;



## Enum: InstrumentTypeEnum

Name | Value
---- | -----
QUOTEDSECURITY | &quot;QuotedSecurity&quot;
INTERESTRATESWAP | &quot;InterestRateSwap&quot;
FXFORWARD | &quot;FxForward&quot;
EXOTIC | &quot;Exotic&quot;
FXOPTION | &quot;FxOption&quot;
CREDITDEFAULTSWAP | &quot;CreditDefaultSwap&quot;
UNKNOWN | &quot;Unknown&quot;



