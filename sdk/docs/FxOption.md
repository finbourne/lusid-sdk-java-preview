

# FxOption

Lusid-ibor internal representation of a plain vanilla FX Option instrument.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**startDate** | **OffsetDateTime** | The start date of the instrument. This is normally synonymous with the trade-date. | 
**optionMaturityDate** | **OffsetDateTime** | The maturity date of the option. | 
**optionSettlementDate** | **OffsetDateTime** | The settlement date of the option. | 
**isDeliveryNotCash** | **Boolean** | True of the option is settled in cash false if delivery. | 
**isCallNotPut** | **Boolean** | True if the option is a call, false if the option is a put. | 
**strike** | **Double** | The strike of the option. | 
**domCcy** | **String** | The domestic currency of the instrument. | 
**fgnCcy** | **String** | The foreign currency of the FX. | 
**premium** | [**Premium**](Premium.md) |  |  [optional]



