

# AggregationQuery


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**addressKey** | **String** | The address that is the query to be made into the system. e.g. a Valuation/Pv or Instrument/MaturityDate | 
**description** | **String** | What does the information that is being queried by the address mean. What is the address for. | 
**displayName** | **String** | The suggested name that the user would wish to put on to the returned information for visualisation in preference to the address. | 
**type** | [**TypeEnum**](#TypeEnum) | The available values are: String, Int, Decimal, DateTime, Boolean, ResultValue, Array, Map, Json | 
**scalesWithHoldingQuantity** | **Boolean** | Is the data scaled when it is for, e.g. a holding in an instrument. A key example would be the difference between price and pv. The present value  of an instrument would scale with the quantity held. The price would be that for a hypothetical unit of that instrument, typically associated with the  contract size. | 
**supportedOperations** | **String** | When performing an aggregation operation, what column type operations can be performed on the data. For example, it makes sense to sum decimals but  not strings. Either can be counted. With more complex types, e.g. ResultValues, operations may be linked to a semantic meaning such as the currency  of the result. In such cases the operations may be supported but context specific. For example, it makes sense to sum PVs in a single currency but not  when the currency is different. In such cases, an error would result (it being assumed that no fx rates for currency conversion were implicit in the context). | 



## Enum: TypeEnum

Name | Value
---- | -----
STRING | &quot;String&quot;
INT | &quot;Int&quot;
DECIMAL | &quot;Decimal&quot;
DATETIME | &quot;DateTime&quot;
BOOLEAN | &quot;Boolean&quot;
RESULTVALUE | &quot;ResultValue&quot;
ARRAY | &quot;Array&quot;
MAP | &quot;Map&quot;
JSON | &quot;Json&quot;



