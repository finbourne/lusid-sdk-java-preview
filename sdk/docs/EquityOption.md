

# EquityOption

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**code** | **String** | The reset code of the option. | 
**strike** | **Double** | The strike of the option. | 
**optionMaturityDate** | [**OffsetDateTime**](OffsetDateTime.md) | The maturity date of the option. | 
**optionSettlementDate** | [**OffsetDateTime**](OffsetDateTime.md) | The settlement date of the option. | 
**startDate** | [**OffsetDateTime**](OffsetDateTime.md) | The start date of the instrument. This is normally synonymous with the trade-date. | 
**optionType** | [**OptionTypeEnum**](#OptionTypeEnum) | The available values are: None, Call, Put | 
**deliveryType** | [**DeliveryTypeEnum**](#DeliveryTypeEnum) | The available values are: Cash, Physical | 
**underlyingIdentifier** | [**UnderlyingIdentifierEnum**](#UnderlyingIdentifierEnum) | The available values are: LusidInstrumentId, Isin, Sedol, Cusip, ClientInternal, Figi, RIC, QuotePermId | 
**domCcy** | **String** | The domestic currency of the instrument. | 



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



