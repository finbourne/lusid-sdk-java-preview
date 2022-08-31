

# TradeTicket

A Trade Ticket comprising of an instrument, a transaction and a counterparty.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**transactionId** | **String** | The unique identifier of the transaction. | 
**type** | **String** | The type of the transaction, for example &#39;Buy&#39; or &#39;Sell&#39;. The transaction type must have been pre-configured using the System Configuration API. If not, this operation will succeed but you are not able to calculate holdings for the portfolio that include this transaction. | 
**source** | **String** | The source of the transaction. This is used to look up the appropriate transaction group set in the transaction type configuration. |  [optional]
**transactionDate** | **String** | The date of the transaction. | 
**settlementDate** | **String** | The settlement date of the transaction. | 
**totalConsideration** | [**CurrencyAndAmount**](CurrencyAndAmount.md) |  | 
**units** | **java.math.BigDecimal** | The number of units of the transacted instrument. | 
**instrumentIdentifiers** | **Map&lt;String, String&gt;** | The set of identifiers that can be used to identify the instrument. | 
**instrumentScope** | **String** | The scope in which the instrument lies. |  [optional]
**instrumentName** | **String** | The name of the instrument. |  [optional]
**instrumentDefinition** | [**LusidInstrument**](LusidInstrument.md) |  |  [optional]
**counterpartyAgreementId** | [**ResourceId**](ResourceId.md) |  |  [optional]



