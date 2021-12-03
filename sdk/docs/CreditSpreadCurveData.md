

# CreditSpreadCurveData

A credit spread curve matching tenors against par spread quotes

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**baseDate** | **OffsetDateTime** | EffectiveAt date of the quoted rates | 
**domCcy** | **String** | Domestic currency of the curve | 
**tenors** | **List&lt;String&gt;** | The tenors for which the rates apply | 
**spreads** | **List&lt;Double&gt;** | Par spread quotes corresponding to the tenors. | 
**recoveryRate** | **Double** | The recovery rate in default. | 



