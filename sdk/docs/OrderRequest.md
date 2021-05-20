

# OrderRequest

A request to create or update an Order.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**properties** | [**Map&lt;String, PerpetualProperty&gt;**](PerpetualProperty.md) | Client-defined properties associated with this order. |  [optional]
**instrumentIdentifiers** | **Map&lt;String, String&gt;** | The instrument ordered. | 
**quantity** | **Integer** | The quantity of given instrument ordered. | 
**side** | **String** | The client&#39;s representation of the order&#39;s side (buy, sell, short, etc) | 
**orderBookId** | [**ResourceId**](ResourceId.md) |  |  [optional]
**portfolioId** | [**ResourceId**](ResourceId.md) |  | 
**id** | [**ResourceId**](ResourceId.md) |  | 



