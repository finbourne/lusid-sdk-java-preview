

# IndexConvention

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**fixingReference** | **String** | The reference rate name for fixings | 
**name** | **String** | The name of the index convention | 
**publicationDayLag** | **Integer** | Number of days between spot and publication of the rate. | 
**paymentTenor** | [**Tenor**](Tenor.md) |  | 
**dayCountConvention** | [**DayCountConventionEnum**](#DayCountConventionEnum) | The available values are: Actual360, Act360, MoneyMarket, Actual365, Act365, Thirty360, ThirtyU360, Bond, ThirtyE360, EuroBond, ActAct, ActualActual, ActActIsda, Invalid | 
**currency** | **String** | Currency of the index convention. | 



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



