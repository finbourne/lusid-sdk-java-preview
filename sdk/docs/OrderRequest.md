

# OrderRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**properties** | [**Map&lt;String, PerpetualProperty&gt;**](PerpetualProperty.md) | Client-defined properties associated with this order. |  [optional]
**instrumentIdentifiers** | **Map&lt;String, String&gt;** | The instrument ordered. | 
**quantity** | **Integer** | The quantity of given instrument ordered. | 
**side** | **String** | The client&#39;s representation of the order&#39;s side (buy, sell, short, etc) | 
**orderBook** | [**ResourceId**](ResourceId.md) |  | 
**portfolio** | [**ResourceId**](ResourceId.md) |  | 
**code** | **String** | Uniquely identifies this order. | 



