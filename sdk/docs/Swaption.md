

# Swaption

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**startDate** | [**OffsetDateTime**](OffsetDateTime.md) | The start date of the instrument. This is normally synonymous with the trade-date. | 
**swap** | [**SwapInstrument**](SwapInstrument.md) |  | 
**payOrReceiveFixed** | [**PayOrReceiveFixedEnum**](#PayOrReceiveFixedEnum) | True if on exercise the holder of the option enters the swap paying fixed, false if floating. | 
**deliveryMethod** | [**DeliveryMethodEnum**](#DeliveryMethodEnum) | How does the option settle | 



## Enum: PayOrReceiveFixedEnum

Name | Value
---- | -----
NOTDEFINED | &quot;NotDefined&quot;
PAY | &quot;Pay&quot;
RECEIVE | &quot;Receive&quot;



## Enum: DeliveryMethodEnum

Name | Value
---- | -----
CASH | &quot;Cash&quot;
PHYSICAL | &quot;Physical&quot;



