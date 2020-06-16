

# MarketOptions

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**defaultSupplier** | [**DefaultSupplierEnum**](#DefaultSupplierEnum) | The available values are: DataScope, Lusid, Isda, Client, Edi, TraderMade, FactSet |  [optional]
**defaultInstrumentCodeType** | [**DefaultInstrumentCodeTypeEnum**](#DefaultInstrumentCodeTypeEnum) | The available values are: LusidInstrumentId, Figi, RIC, QuotePermId, Isin, CurrencyPair |  [optional]
**defaultScope** | **String** | For default rules, which scope should data be searched for in |  [optional]
**attemptToInferMissingFx** | **Boolean** | if true will calculate a missing Fx pair (e.g. THBJPY) from the inverse JPYTHB or from standardised pairs against USD, e.g. THBUSD and JPYUSD |  [optional]
**manifestLevelOfDetail** | [**ManifestLevelOfDetailEnum**](#ManifestLevelOfDetailEnum) | The available values are: None, Full |  [optional]



## Enum: DefaultSupplierEnum

Name | Value
---- | -----
DATASCOPE | &quot;DataScope&quot;
LUSID | &quot;Lusid&quot;
ISDA | &quot;Isda&quot;
CLIENT | &quot;Client&quot;
EDI | &quot;Edi&quot;
TRADERMADE | &quot;TraderMade&quot;
FACTSET | &quot;FactSet&quot;



## Enum: DefaultInstrumentCodeTypeEnum

Name | Value
---- | -----
LUSIDINSTRUMENTID | &quot;LusidInstrumentId&quot;
FIGI | &quot;Figi&quot;
RIC | &quot;RIC&quot;
QUOTEPERMID | &quot;QuotePermId&quot;
ISIN | &quot;Isin&quot;
CURRENCYPAIR | &quot;CurrencyPair&quot;



## Enum: ManifestLevelOfDetailEnum

Name | Value
---- | -----
NONE | &quot;None&quot;
FULL | &quot;Full&quot;



