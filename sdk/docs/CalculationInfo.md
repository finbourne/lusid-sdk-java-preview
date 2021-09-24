

# CalculationInfo


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**calculationDescription** | **String** |  | 
**calculationMethod** | [**CalculationMethodEnum**](#CalculationMethodEnum) | The available values are: Rate, BasisPoints, Bps, Percentage, Flat, FlatFee, None | 
**multiplier** | [**MultiplierEnum**](#MultiplierEnum) | The available values are: Quantity, Value, None | 
**calculationAmount** | **Double** |  | 



## Enum: CalculationMethodEnum

Name | Value
---- | -----
RATE | &quot;Rate&quot;
BASISPOINTS | &quot;BasisPoints&quot;
BPS | &quot;Bps&quot;
PERCENTAGE | &quot;Percentage&quot;
FLAT | &quot;Flat&quot;
FLATFEE | &quot;FlatFee&quot;
NONE | &quot;None&quot;



## Enum: MultiplierEnum

Name | Value
---- | -----
QUANTITY | &quot;Quantity&quot;
VALUE | &quot;Value&quot;
NONE | &quot;None&quot;



