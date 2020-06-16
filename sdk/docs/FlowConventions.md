

# FlowConventions

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**currency** | **String** | Currency of the flow convention. | 
**paymentFrequency** | [**Tenor**](Tenor.md) |  | 
**dayCountConvention** | [**DayCountConventionEnum**](#DayCountConventionEnum) | The available values are: Actual360, Act360, MoneyMarket, Actual365, Act365, Thirty360, ThirtyU360, Bond, ThirtyE360, EuroBond, ActAct, ActualActual, ActActIsda, Invalid | 
**rollConvention** | [**RollConventionEnum**](#RollConventionEnum) | The available values are: NoAdjustment, None, Previous, P, Following, F, ModifiedPrevious, MP, ModifiedFollowing, MF, EndOfMonth, EOM, EndOfMonthPrevious, EOMP, EndOfMonthFollowing, EOMF, Invalid | 
**holidayCalendars** | **List&lt;String&gt;** | An array of strings denoting holiday calendars that apply to generation and payment. | 



## Enum: DayCountConventionEnum

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
THIRTYE360 | &quot;ThirtyE360&quot;
EUROBOND | &quot;EuroBond&quot;
ACTACT | &quot;ActAct&quot;
ACTUALACTUAL | &quot;ActualActual&quot;
ACTACTISDA | &quot;ActActIsda&quot;
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



