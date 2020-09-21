

# ValuationSchedule

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**effectiveFrom** | **String** | If present, the EffectiveFrom and EffectiveAt dates are interpreted as a range of dates for which to perform a valuation.  In this case, valuation is calculated for the portfolio(s) for each date that is a business day in the given range. |  [optional]
**effectiveAt** | **String** | The market data time, i.e. the time to run the aggregation request effective of. | 
**tenor** | **String** | Tenor, e.g \&quot;1D\&quot;, \&quot;1M\&quot; to be used in generating the date schedule when effectiveFrom and effectiveAt are both given and are not the same. |  [optional]
**rollConvention** | **String** | When Tenor is given and is not equal to \&quot;1D\&quot;, there may be cases where \&quot;date + tenor\&quot; ends up hitting non business days around month end. In that case,  what convention, e.g. modified following \&quot;MF\&quot; should be applied to determine the next GBD. |  [optional]
**holidayCalendars** | **List&lt;String&gt;** | What holiday calendars should be considered effective in determining the date schedule. Note that where these are not available, perhaps because the user  has insufficient permissions, a recipe setting will be used to determine whether the whole batch should then fail or whether the calendar not being available  should simply be ignored. |  [optional]
**valuationDateTimes** | **List&lt;String&gt;** | If given, the exact set of dates on which to perform a valuation. This will replace/override all other specified values if given |  [optional]



