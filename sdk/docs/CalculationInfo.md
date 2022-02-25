

# CalculationInfo


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**calculationMethod** | [**CalculationMethodEnum**](#CalculationMethodEnum) | Method of calculating the fees or commission among: BasisPoints, Percentage, Rate, Flat etc. The available values are: Rate, BasisPoints, Percentage, Flat | 
**multiplier** | [**MultiplierEnum**](#MultiplierEnum) | . The available values are: None, Quantity, Value | 
**calculationAmount** | **Double** | Numerical fee amount | 



## Enum: CalculationMethodEnum

Name | Value
---- | -----
RATE | &quot;Rate&quot;
BASISPOINTS | &quot;BasisPoints&quot;
PERCENTAGE | &quot;Percentage&quot;
FLAT | &quot;Flat&quot;



## Enum: MultiplierEnum

Name | Value
---- | -----
NONE | &quot;None&quot;
QUANTITY | &quot;Quantity&quot;
VALUE | &quot;Value&quot;



