

# OutputTransaction

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**transactionId** | **String** |  | 
**type** | **String** |  | 
**description** | **String** |  |  [optional]
**instrumentIdentifiers** | **Map&lt;String, String&gt;** |  |  [optional]
**instrumentUid** | **String** |  | 
**transactionDate** | [**OffsetDateTime**](OffsetDateTime.md) |  | 
**settlementDate** | [**OffsetDateTime**](OffsetDateTime.md) |  | 
**units** | **Double** |  | 
**transactionAmount** | **Double** |  |  [optional]
**transactionPrice** | [**TransactionPrice**](TransactionPrice.md) |  |  [optional]
**totalConsideration** | [**CurrencyAndAmount**](CurrencyAndAmount.md) |  |  [optional]
**exchangeRate** | **Double** |  |  [optional]
**transactionToPortfolioRate** | **Double** |  |  [optional]
**transactionCurrency** | **String** |  |  [optional]
**properties** | [**Map&lt;String, PerpetualProperty&gt;**](PerpetualProperty.md) |  |  [optional]
**counterpartyId** | **String** |  |  [optional]
**source** | **String** |  |  [optional]
**transactionStatus** | [**TransactionStatusEnum**](#TransactionStatusEnum) |  |  [optional]
**entryDateTime** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
**cancelDateTime** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
**realisedGainLoss** | [**List&lt;RealisedGainLoss&gt;**](RealisedGainLoss.md) |  |  [optional]



## Enum: TransactionStatusEnum

Name | Value
---- | -----
ACTIVE | &quot;Active&quot;
AMENDED | &quot;Amended&quot;
CANCELLED | &quot;Cancelled&quot;



