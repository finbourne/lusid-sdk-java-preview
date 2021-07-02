

# ExecutionRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | [**ResourceId**](ResourceId.md) |  | 
**placementId** | [**ResourceId**](ResourceId.md) |  | 
**properties** | [**Map&lt;String, PerpetualProperty&gt;**](PerpetualProperty.md) | Client-defined properties associated with this execution. |  [optional]
**instrumentIdentifiers** | **Map&lt;String, String&gt;** | The instrument ordered. | 
**quantity** | **Double** | The quantity of given instrument ordered. | 
**state** | **String** | The state of this execution (typically a FIX state; Open, Filled, etc). | 
**side** | **String** | The side (Buy, Sell, ...) of this execution. | 
**type** | **String** | The type of this execution (Market, Limit, etc). | 
**createdDate** | [**OffsetDateTime**](OffsetDateTime.md) | The active date of this execution. | 
**settlementDate** | [**OffsetDateTime**](OffsetDateTime.md) | The (optional) settlement date for this execution |  [optional]
**price** | [**CurrencyAndAmount**](CurrencyAndAmount.md) |  | 
**settlementCurrency** | **String** | The execution&#39;s settlement currency. | 
**settlementCurrencyFxRate** | **Double** | The exectuion&#39;s settlement currency rate. | 
**counterparty** | **String** | The market entity this placement is placed with. | 



