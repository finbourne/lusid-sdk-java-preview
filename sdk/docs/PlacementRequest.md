

# PlacementRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | [**ResourceId**](ResourceId.md) |  | 
**blockIds** | [**List&lt;ResourceId&gt;**](ResourceId.md) | IDs of Blocks associated with this placement. | 
**properties** | [**Map&lt;String, PerpetualProperty&gt;**](PerpetualProperty.md) | Client-defined properties associated with this order. |  [optional]
**instrumentIdentifiers** | **Map&lt;String, String&gt;** | The instrument ordered. | 
**quantity** | **Double** | The quantity of given instrument ordered. | 
**state** | **String** | The state of this placement (typically a FIX state; Open, Filled, etc). | 
**side** | **String** | The side (Buy, Sell, ...) of this placement. | 
**timeInForce** | **String** | The time in force applicable to this placement (GTC, FOK, Day, etc) | 
**type** | **String** | The type of this placement (Market, Limit, etc). | 
**createdDate** | [**OffsetDateTime**](OffsetDateTime.md) | The active date of this placement. | 
**limitPrice** | [**CurrencyAndAmount**](CurrencyAndAmount.md) |  |  [optional]
**stopPrice** | [**CurrencyAndAmount**](CurrencyAndAmount.md) |  |  [optional]
**counterparty** | **String** | The market entity this placement is placed with. | 



