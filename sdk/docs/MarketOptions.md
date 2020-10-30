

# MarketOptions

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**defaultSupplier** | **String** | The default supplier of data. This controls which &#39;dialect&#39; is used to find particular market data. e.g. one supplier might address data by RIC, another by PermId |  [optional]
**defaultInstrumentCodeType** | **String** | When instrument quotes are searched for, what identifier should be used by default |  [optional]
**defaultScope** | **String** | For default rules, which scope should data be searched for in |  [optional]
**attemptToInferMissingFx** | **Boolean** | if true will calculate a missing Fx pair (e.g. THBJPY) from the inverse JPYTHB or from standardised pairs against USD, e.g. THBUSD and JPYUSD |  [optional]



