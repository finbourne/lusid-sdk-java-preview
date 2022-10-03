

# FixedScheduleAllOf


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**startDate** | **OffsetDateTime** | Date to start generate from | 
**maturityDate** | **OffsetDateTime** | Date to generate to | 
**flowConventions** | [**FlowConventions**](FlowConventions.md) |  |  [optional]
**couponRate** | **java.math.BigDecimal** | Coupon rate given as a fraction. |  [optional]
**conventionName** | [**FlowConventionName**](FlowConventionName.md) |  |  [optional]
**notional** | **java.math.BigDecimal** | Scaling factor, the quantity outstanding on which the rate will be paid. |  [optional]
**paymentCurrency** | **String** | Payment currency. This does not have to be the same as the nominal bond or observation/reset currency. |  [optional]
**stubType** | **String** | StubType required of the schedule    Supported string (enumeration) values are: [ShortFront, ShortBack, LongBack, LongFront, Both]. |  [optional]
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



