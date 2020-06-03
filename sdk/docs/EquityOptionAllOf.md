

# EquityOptionAllOf

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**code** | **String** | The reset code of the option. | 
**strike** | **Double** | The strike of the option. | 
**optionMaturityDate** | [**OffsetDateTime**](OffsetDateTime.md) | The maturity date of the option. | 
**optionSettlementDate** | [**OffsetDateTime**](OffsetDateTime.md) | The settlement date of the option. | 
**startDate** | [**OffsetDateTime**](OffsetDateTime.md) | The start date of the instrument. This is normally synonymous with the trade-date. | 
**optionType** | [**OptionTypeEnum**](#OptionTypeEnum) | Type of optionality for the option | 
**deliveryType** | [**DeliveryTypeEnum**](#DeliveryTypeEnum) | is the option cash settled or physical delivery of option | 
**underlyingIdentifier** | [**UnderlyingIdentifierEnum**](#UnderlyingIdentifierEnum) | external market codes and identifiers for the option, e.g. RIC. | 
**domCcy** | **String** | The domestic currency of the instrument. | 
**instrumentType** | [**InstrumentTypeEnum**](#InstrumentTypeEnum) | Instrument type, must be property for JSON. | 



## Enum: OptionTypeEnum

Name | Value
---- | -----
NONE | &quot;None&quot;
CALL | &quot;Call&quot;
PUT | &quot;Put&quot;



## Enum: DeliveryTypeEnum

Name | Value
---- | -----
CASH | &quot;Cash&quot;
PHYSICAL | &quot;Physical&quot;



## Enum: UnderlyingIdentifierEnum

Name | Value
---- | -----
LUSIDINSTRUMENTID | &quot;LusidInstrumentId&quot;
ISIN | &quot;Isin&quot;
SEDOL | &quot;Sedol&quot;
CUSIP | &quot;Cusip&quot;
CLIENTINTERNAL | &quot;ClientInternal&quot;
FIGI | &quot;Figi&quot;
RIC | &quot;RIC&quot;
QUOTEPERMID | &quot;QuotePermId&quot;



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
EQUITYOPTION | &quot;EquityOption&quot;
FIXEDRATELEG | &quot;FixedRateLeg&quot;
FLOATINGRATELEG | &quot;FloatingRateLeg&quot;
BESPOKECASHFLOWLEG | &quot;BespokeCashflowLeg&quot;
UNKNOWN | &quot;Unknown&quot;



