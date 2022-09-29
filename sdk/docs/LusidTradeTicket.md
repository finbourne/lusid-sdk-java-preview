

# LusidTradeTicket

A LUSID Trade Ticket comprising an instrument, a transaction, and a counterparty.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**transactionId** | **String** |  | 
**transactionType** | **String** |  | 
**source** | **String** |  |  [optional]
**transactionDate** | **String** |  | 
**settlementDate** | **String** |  | 
**totalConsideration** | [**CurrencyAndAmount**](CurrencyAndAmount.md) |  | 
**units** | **java.math.BigDecimal** |  | 
**instrumentIdentifiers** | **Map&lt;String, String&gt;** |  | 
**instrumentScope** | **String** |  |  [optional]
**instrumentName** | **String** |  |  [optional]
**instrumentDefinition** | [**LusidInstrument**](LusidInstrument.md) |  |  [optional]
**counterpartyAgreementId** | [**ResourceId**](ResourceId.md) |  |  [optional]
**instrumentProperties** | [**List&lt;Property&gt;**](Property.md) |  |  [optional]
**transactionProperties** | [**List&lt;Property&gt;**](Property.md) |  |  [optional]
**tradeTicketType** | [**TradeTicketTypeEnum**](#TradeTicketTypeEnum) | The available values are: LusidTradeTicket, ExternalTradeTicket | 



## Enum: TradeTicketTypeEnum

Name | Value
---- | -----
LUSIDTRADETICKET | &quot;LusidTradeTicket&quot;
EXTERNALTRADETICKET | &quot;ExternalTradeTicket&quot;



