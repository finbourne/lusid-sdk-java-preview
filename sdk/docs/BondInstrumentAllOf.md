

# BondInstrumentAllOf

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**startDate** | [**OffsetDateTime**](OffsetDateTime.md) |  | 
**maturityDate** | [**OffsetDateTime**](OffsetDateTime.md) |  | 
**domCcy** | **String** |  | 
**couponRate** | **Double** | simple coupon rate. | 
**principal** | **Double** | The face-value or principal for the bond at outset.              This might be reduced through its lifetime in the event of amortization or similar. | 
**flowConventions** | [**FlowConventions**](FlowConventions.md) |  | 
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



