

# Portfolio

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**href** | **String** |  |  [optional]
**id** | [**ResourceId**](ResourceId.md) |  | 
**type** | [**TypeEnum**](#TypeEnum) |  | 
**displayName** | **String** |  | 
**description** | **String** |  |  [optional]
**created** | [**OffsetDateTime**](OffsetDateTime.md) |  | 
**parentPortfolioId** | [**ResourceId**](ResourceId.md) |  |  [optional]
**version** | [**Version**](Version.md) |  |  [optional]
**isDerived** | **Boolean** |  |  [optional]
**properties** | [**Map&lt;String, Property&gt;**](Property.md) |  |  [optional]
**links** | [**List&lt;Link&gt;**](Link.md) |  |  [optional]



## Enum: TypeEnum

Name | Value
---- | -----
TRANSACTION | &quot;Transaction&quot;
REFERENCE | &quot;Reference&quot;
DERIVEDTRANSACTION | &quot;DerivedTransaction&quot;



