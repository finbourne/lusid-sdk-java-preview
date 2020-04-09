

# SwaptionAllOf

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**startDate** | [**OffsetDateTime**](OffsetDateTime.md) |  | 
**isPayerNotReceiver** | **Boolean** | True if on exercise the holder of the option enters the swap paying fixed, false if floating. | 
**isDeliveryNotCash** | **Boolean** | True of the option is settled in cash false if by delivery of the swap. | 
**swap** | [**LusidInstrument**](LusidInstrument.md) |  | 
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



