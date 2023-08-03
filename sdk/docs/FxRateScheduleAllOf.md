

# FxRateScheduleAllOf


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**flowConventions** | [**FlowConventions**](FlowConventions.md) |  |  [optional]
**fxConversionTypes** | **List&lt;String&gt;** | List of flags to indicate if coupon payments, principal payments or both are converted |  [optional]
**rate** | **java.math.BigDecimal** | FxRate used to convert payments. Assumed to be in units of the ToCurrency so conversion is paymentAmount x fxRate |  [optional]
**toCurrency** | **String** | Currency that payments are converted to |  [optional]
**scheduleType** | [**ScheduleTypeEnum**](#ScheduleTypeEnum) | The available values are: FixedSchedule, FloatSchedule, OptionalitySchedule, StepSchedule, Exercise, FxRateSchedule, Invalid | 



## Enum: ScheduleTypeEnum

Name | Value
---- | -----
FIXEDSCHEDULE | &quot;FixedSchedule&quot;
FLOATSCHEDULE | &quot;FloatSchedule&quot;
OPTIONALITYSCHEDULE | &quot;OptionalitySchedule&quot;
STEPSCHEDULE | &quot;StepSchedule&quot;
EXERCISE | &quot;Exercise&quot;
FXRATESCHEDULE | &quot;FxRateSchedule&quot;
INVALID | &quot;Invalid&quot;



