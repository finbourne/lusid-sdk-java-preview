

# FlowConventions

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**currency** | **String** | Currency of the flow convention. | 
**paymentFrequency** | [**Tenor**](Tenor.md) |  | 
**dayCountBasis** | [**DayCountBasisEnum**](#DayCountBasisEnum) | When calculating the fraction of a year between two dates, what convention is used to represent the number of days in a year  and difference between them. | 
**rollConvention** | [**RollConventionEnum**](#RollConventionEnum) | When generating a set of dates, what convention should be used for adjusting dates that coincide with a non-business day. | 
**holidayCalendars** | **String** | A comma separated string denoting holiday calendars that apply to generation and payment. | 



## Enum: DayCountBasisEnum

Name | Value
---- | -----
ACTUAL360 | &quot;Actual360&quot;
ACT360 | &quot;Act360&quot;
MONEYMARKET | &quot;MoneyMarket&quot;
ACTUAL365 | &quot;Actual365&quot;
ACT365 | &quot;Act365&quot;
THIRTY360 | &quot;Thirty360&quot;
THIRTYU360 | &quot;ThirtyU360&quot;
BOND | &quot;Bond&quot;
INVALID | &quot;Invalid&quot;



## Enum: RollConventionEnum

Name | Value
---- | -----
NOADJUSTMENT | &quot;NoAdjustment&quot;
NONE | &quot;None&quot;
PREVIOUS | &quot;Previous&quot;
P | &quot;P&quot;
FOLLOWING | &quot;Following&quot;
F | &quot;F&quot;
MODIFIEDPREVIOUS | &quot;ModifiedPrevious&quot;
MP | &quot;MP&quot;
MODIFIEDFOLLOWING | &quot;ModifiedFollowing&quot;
MF | &quot;MF&quot;
ENDOFMONTH | &quot;EndOfMonth&quot;
EOM | &quot;EOM&quot;
ENDOFMONTHPREVIOUS | &quot;EndOfMonthPrevious&quot;
EOMP | &quot;EOMP&quot;
ENDOFMONTHFOLLOWING | &quot;EndOfMonthFollowing&quot;
EOMF | &quot;EOMF&quot;
INVALID | &quot;Invalid&quot;



