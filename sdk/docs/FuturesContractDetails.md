

# FuturesContractDetails

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**domCcy** | **String** | currency in which the contract is paid. | 
**contractCode** | **String** | The two letter contract code abbreviation. e.g. CL &#x3D;&gt; Crude Oil. | 
**contractMonth** | **String** | which month does the contract trade for. | 
**contractSize** | **Double** | Size of a single contract. By default this should be set to 1000 if otherwise unknown and is defaulted to such. | 
**convention** | [**ConventionEnum**](#ConventionEnum) | The available values are: Actual360, Act360, MoneyMarket, Actual365, Act365, Thirty360, ThirtyU360, Bond, ThirtyE360, EuroBond, ActAct, ActualActual, ActActIsda, ActActIsma, ActActIcma, Invalid | 
**country** | **String** | Country (code) for the exchange. | 
**description** | **String** | Description of contract | 
**exchangeCode** | **String** | Exchange code for contract | 
**exchangeName** | **String** | Exchange name (for when code is not automatically recognized) | 
**tickerStep** | **Double** | Minimal step size change in ticker | 
**unitValue** | **Double** | The value in the currency of a 1 unit change in the contract price | 



## Enum: ConventionEnum

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
ACTACTISMA | &quot;ActActIsma&quot;
ACTACTICMA | &quot;ActActIcma&quot;
INVALID | &quot;Invalid&quot;



