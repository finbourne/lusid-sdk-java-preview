

# InterestRateSwaption

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**startDate** | [**OffsetDateTime**](OffsetDateTime.md) | The start date of the instrument. This is normally synonymous with the trade-date. | 
**payOrReceiveFixed** | [**PayOrReceiveFixedEnum**](#PayOrReceiveFixedEnum) | The available values are: NotDefined, Pay, Receive | 
**deliveryMethod** | [**DeliveryMethodEnum**](#DeliveryMethodEnum) | The available values are: Cash, Physical | 
**swap** | [**InterestRateSwap**](InterestRateSwap.md) |  | 



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



