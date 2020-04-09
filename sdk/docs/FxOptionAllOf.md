

# FxOptionAllOf

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**startDate** | [**OffsetDateTime**](OffsetDateTime.md) | The start date of the option. | 
**optionMaturityDate** | [**OffsetDateTime**](OffsetDateTime.md) | The maturity date of the option. | 
**optionSettlementDate** | [**OffsetDateTime**](OffsetDateTime.md) | The settlement date of the option. | 
**isDeliveryNotCash** | **Boolean** | True of the option is settled in cash false if delivery. | 
**isCallNotPut** | **Boolean** | True if the option is a call, false if the option is a put. | 
**strike** | **Double** | The strike of the option. | 
**domCcy** | **String** | The domestic currency of the FX. | 
**fgnCcy** | **String** | The foreign currency of the FX. | 
**instrumentType** | [**InstrumentTypeEnum**](#InstrumentTypeEnum) | Instrument type, must be property for JSON. | 



## Enum: InstrumentTypeEnum

Name | Value
---- | -----
QUOTEDSECURITY | &quot;QuotedSecurity&quot;
INTERESTRATESWAP | &quot;InterestRateSwap&quot;
FXFORWARD | &quot;FxForward&quot;
EXOTIC | &quot;Exotic&quot;
FXOPTION | &quot;FxOption&quot;
CREDITDEFAULTSWAP | &quot;CreditDefaultSwap&quot;
INTERESTRATESWAPTION | &quot;InterestRateSwaption&quot;
BOND | &quot;Bond&quot;
UNKNOWN | &quot;Unknown&quot;



