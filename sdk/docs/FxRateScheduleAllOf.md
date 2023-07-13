

# FxRateScheduleAllOf


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**flowConventions** | [**FlowConventions**](FlowConventions.md) |  |  [optional]
**fxConversionTypes** | **List&lt;String&gt;** | List of flags to indicate if coupon payments, principal payments or both are converted |  [optional]
**rate** | **java.math.BigDecimal** | FxRate used to convert payments. Assumed to be in units of the ToCurrency so conversion is paymentAmount x fxRate |  [optional]
**toCurrency** | **String** | Currency that payments are converted to |  [optional]
**scheduleType** | [**ScheduleTypeEnum**](#ScheduleTypeEnum) | The available values are: Fixed, Float, Optionality, Step, Exercise, FxRate, Invalid | 



## Enum: ScheduleTypeEnum

Name | Value
---- | -----
FIXED | &quot;Fixed&quot;
FLOAT | &quot;Float&quot;
OPTIONALITY | &quot;Optionality&quot;
STEP | &quot;Step&quot;
EXERCISE | &quot;Exercise&quot;
FXRATE | &quot;FxRate&quot;
INVALID | &quot;Invalid&quot;



