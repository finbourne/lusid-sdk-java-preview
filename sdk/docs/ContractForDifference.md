

# ContractForDifference

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**startDate** | [**OffsetDateTime**](OffsetDateTime.md) | The start date of the CFD. | 
**code** | **String** | The code of the underlying. | 
**payCcy** | **String** | The currency that this CFD pays out, this can be different to the UnderlyingCcy. | 
**referenceDate** | [**OffsetDateTime**](OffsetDateTime.md) | The reference date of the CFD. | 
**referenceRate** | **Double** | The reference rate of the CFD. | 
**underlyingCcy** | **String** | The currency of the underlying | 
**underlyingIdentifier** | **String** | external market codes and identifiers for the CFD, e.g. RIC.  Supported string (enumeration) values are: [LusidInstrumentId, Isin, Sedol, Cusip, ClientInternal, Figi, RIC, QuotePermId]. | 



