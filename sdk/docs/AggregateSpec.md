

# AggregateSpec

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**key** | **String** | The key that uniquely identifies the property. It has the format {domain}/{scope}/{code}. |  [optional]
**op** | [**OpEnum**](#OpEnum) | The available values are: Sum, Proportion, Average, Count, Min, Max, Value |  [optional]



## Enum: OpEnum

Name | Value
---- | -----
SUM | &quot;Sum&quot;
PROPORTION | &quot;Proportion&quot;
AVERAGE | &quot;Average&quot;
COUNT | &quot;Count&quot;
MIN | &quot;Min&quot;
MAX | &quot;Max&quot;
VALUE | &quot;Value&quot;



