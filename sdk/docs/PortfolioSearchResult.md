

# PortfolioSearchResult

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | [**ResourceId**](ResourceId.md) |  | 
**type** | [**TypeEnum**](#TypeEnum) |  | 
**href** | **String** |  |  [optional]
**description** | **String** |  |  [optional]
**displayName** | **String** |  | 
**isDerived** | **Boolean** |  |  [optional]
**created** | [**OffsetDateTime**](OffsetDateTime.md) |  | 
**parentPortfolioId** | [**ResourceId**](ResourceId.md) |  |  [optional]
**properties** | [**List&lt;Property&gt;**](Property.md) |  |  [optional]
**links** | [**List&lt;Link&gt;**](Link.md) |  |  [optional]



## Enum: TypeEnum

Name | Value
---- | -----
TRANSACTION | &quot;Transaction&quot;
REFERENCE | &quot;Reference&quot;
DERIVEDTRANSACTION | &quot;DerivedTransaction&quot;



