

# EquityOption

Lusid-ibor internal representation of a plain vanilla equity option instrument.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**startDate** | **OffsetDateTime** | The start date of the instrument. This is normally synonymous with the trade-date. | 
**optionMaturityDate** | **OffsetDateTime** | The maturity date of the option. | 
**optionSettlementDate** | **OffsetDateTime** | The settlement date of the option. | 
**deliveryType** | [**DeliveryTypeEnum**](#DeliveryTypeEnum) | The available values are: Cash, Physical | 
**optionType** | [**OptionTypeEnum**](#OptionTypeEnum) | The available values are: None, Call, Put | 
**strike** | **Double** | The strike of the option. | 
**domCcy** | **String** | The domestic currency of the instrument. | 
**underlyingIdentifier** | [**UnderlyingIdentifierEnum**](#UnderlyingIdentifierEnum) | The available values are: LusidInstrumentId, Isin, Sedol, Cusip, ClientInternal, Figi, RIC, QuotePermId, REDCode, BBGId, ICECode | 
**code** | **String** | The identifying code for the equity underlying, e.g. &#39;IBM.N&#39;. | 



## Enum: DeliveryTypeEnum

Name | Value
---- | -----
CASH | &quot;Cash&quot;
PHYSICAL | &quot;Physical&quot;



## Enum: OptionTypeEnum

Name | Value
---- | -----
NONE | &quot;None&quot;
CALL | &quot;Call&quot;
PUT | &quot;Put&quot;



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
REDCODE | &quot;REDCode&quot;
BBGID | &quot;BBGId&quot;
ICECODE | &quot;ICECode&quot;



