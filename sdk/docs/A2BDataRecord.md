

# A2BDataRecord

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**instrumentUid** | **String** | The unqiue Lusid Instrument Id (LUID) of the instrument that the holding is in. |  [optional]
**subHoldingKeys** | [**Map&lt;String, PerpetualProperty&gt;**](PerpetualProperty.md) | The sub-holding properties which identify the holding. Each property will be from the &#39;Transaction&#39; domain. These are configured when a transaction portfolio is created. |  [optional]
**currency** | **String** | The holding currency. |  [optional]
**transactionId** | **String** | The unique identifier for the transaction. |  [optional]
**start** | [**A2BCategory**](A2BCategory.md) |  |  [optional]
**flows** | [**A2BCategory**](A2BCategory.md) |  |  [optional]
**gains** | [**A2BCategory**](A2BCategory.md) |  |  [optional]
**carry** | [**A2BCategory**](A2BCategory.md) |  |  [optional]
**end** | [**A2BCategory**](A2BCategory.md) |  |  [optional]
**properties** | [**Map&lt;String, Property&gt;**](Property.md) | The properties which have been requested to be decorated onto the holding. These will be from the &#39;Instrument&#39; domain. |  [optional]



