

# ContractForDifference

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**startDate** | [**OffsetDateTime**](OffsetDateTime.md) | The start date of the CFD. | 
**maturityDate** | [**OffsetDateTime**](OffsetDateTime.md) | The maturity date for the CFD. If CFDType is Futures, this should be set to be the maturity date of the underlying  future. If CFDType is Cash, this should not be set. |  [optional]
**code** | **String** | The code of the underlying. | 
**contractSize** | **Double** | The size of the CFD contract, this should represent the total number of stocks that the CFD represents. | 
**payCcy** | **String** | The currency that this CFD pays out, this can be different to the UnderlyingCcy. | 
**referenceRate** | **Double** | The reference rate of the CFD, this can be set to 0 but not negative values.  This field is optional, if not set it will default to 0. |  [optional]
**type** | **String** | The type of CFD.  Supported string (enumeration) values are: [Cash, Futures]. | 
**underlyingCcy** | **String** | The currency of the underlying | 
**underlyingIdentifier** | **String** | external market codes and identifiers for the CFD, e.g. RIC.  Supported string (enumeration) values are: [LusidInstrumentId, Isin, Sedol, Cusip, ClientInternal, Figi, RIC, QuotePermId]. | 



