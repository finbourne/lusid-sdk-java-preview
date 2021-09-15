

# FxForwardCurveData

Contains data (i.e. dates and rates + metadata) for building fx forward curves

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**baseDate** | **OffsetDateTime** | EffectiveAt date of the quoted rates | 
**domCcy** | **String** | Domestic currency of the fx forward | 
**fgnCcy** | **String** | Foreign currency of the fx forward | 
**dates** | **List&lt;OffsetDateTime&gt;** | Dates for which the forward rates apply | 
**rates** | **List&lt;Double&gt;** | Rates provided for the fx forward (price in FgnCcy per unit of DomCcy) | 



