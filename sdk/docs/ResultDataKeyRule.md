

# ResultDataKeyRule

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**resourceKey** | **String** | The result data key that identifies the address pattern that this is a rule for | 
**supplier** | [**SupplierEnum**](#SupplierEnum) | The available values are: DataScope, Lusid, Isda, Client, Edi, TraderMade, FactSet | 
**dataScope** | **String** | which is the scope in which the data should be found | 
**documentCode** | **String** | document code that defines which document is desired | 
**quoteInterval** | **String** | Shorthand for the time interval used to select result data. |  [optional]
**asAt** | [**OffsetDateTime**](OffsetDateTime.md) | The AsAt predicate specification. |  [optional]



## Enum: SupplierEnum

Name | Value
---- | -----
DATASCOPE | &quot;DataScope&quot;
LUSID | &quot;Lusid&quot;
ISDA | &quot;Isda&quot;
CLIENT | &quot;Client&quot;
EDI | &quot;Edi&quot;
TRADERMADE | &quot;TraderMade&quot;
FACTSET | &quot;FactSet&quot;



