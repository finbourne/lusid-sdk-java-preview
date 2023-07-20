

# OptionalityScheduleAllOf


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**exerciseType** | **String** | The exercise type of the optionality schedule (American or European).  For American type, the bond is perpetually callable from a given exercise date until it matures, or the next date in the schedule.  For European type, the bond is only callable on a given exercise date.    Supported string (enumeration) values are: [European, American]. |  [optional]
**optionEntries** | [**List&lt;OptionEntry&gt;**](OptionEntry.md) | The dates at which the bond call/put may be actioned, and associated strikes. |  [optional]
**optionType** | **String** | Type of optionality for the schedule.    Supported string (enumeration) values are: [Call, Put]. |  [optional]
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



