

# CreateSequenceRequest


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**code** | **String** | The code of the sequence definition to create | 
**increment** | **Long** | The value to increment between each value in the sequence |  [optional]
**minValue** | **Long** | The minimum value of the sequence |  [optional]
**maxValue** | **Long** | The maximum value of the sequence |  [optional]
**start** | **Long** | The start value of the sequence |  [optional]
**cycle** | **Boolean** | Indicates if the sequence would start from minimun value once it reaches maximum value. If set to false, a failure would return if the sequence reaches maximum value. Default to false. |  [optional]
**pattern** | **String** | The pattern to be used to generate next values in the sequence. Default to null. Please provide a null value until further notice. |  [optional]



