

# JELines

An JELines entity.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**accountingDate** | **OffsetDateTime** | The JELines accounting date. | 
**portfolioId** | [**ResourceId**](ResourceId.md) |  | 
**instrumentId** | **String** | To indicate the instrument of the transaction that the JE line posted for, if applicable. | 
**instrumentScope** | **String** | The scope in which the JELines instrument is in. | 
**subHoldingKeys** | [**Map&lt;String, PerpetualProperty&gt;**](PerpetualProperty.md) | The sub-holding properties which are part of the AccountingKey. |  [optional]
**taxLotId** | **String** | The tax lot Id that JE line is impacting. | 
**glCode** | **String** | Code of general ledger the JE lines posting to. | 
**local** | [**CurrencyAndAmount**](CurrencyAndAmount.md) |  | 
**base** | [**CurrencyAndAmount**](CurrencyAndAmount.md) |  | 
**postingModuleId** | [**ResourceId**](ResourceId.md) |  | 
**postingRule** | **String** | The rule generating the JELinse. | 
**asAtDate** | **OffsetDateTime** | The corresponding input date and time of the Transaction generating the JELine. | 
**activitiesDescription** | **String** | This would be the description of the business activities where these JE lines are posting for. |  [optional]
**sourceType** | **String** | So far are 4 types: LusidTxn, LusidValuation, Manual and External. | 
**sourceId** | **String** | For the Lusid Source Type this will be the txn Id. For the rest will be what the user populates. | 
**properties** | [**Map&lt;String, Property&gt;**](Property.md) | Properties to add to the Abor. |  [optional]
**links** | [**List&lt;Link&gt;**](Link.md) | Collection of links. |  [optional]



