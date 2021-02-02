

# ContractForDifference

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**startDate** | [**OffsetDateTime**](OffsetDateTime.md) | The start date of the CFD. | 
**maturityDate** | [**OffsetDateTime**](OffsetDateTime.md) | The final maturity date of the instrument. This means the last date on which the instruments makes a payment of any amount.  For the avoidance of doubt, that is not necessarily prior to its last sensitivity date for the purposes of risk; e.g. instruments such as  Constant Maturity Swaps (CMS) often have sensitivities to rates beyond their last payment date | 
**code** | **String** | The code of the underlying. | 
**payCcy** | **String** | The currency that this CFD pays out, this can be different to the UnderlyingCcy. | 
**referenceRate** | **Double** | The reference rate of the CFD, this can be set to 0 but not negative values. | 
**underlyingCcy** | **String** | The currency of the underlying | 
**underlyingIdentifier** | **String** | external market codes and identifiers for the CFD, e.g. RIC.  Supported string (enumeration) values are: [LusidInstrumentId, Isin, Sedol, Cusip, ClientInternal, Figi, RIC, QuotePermId]. | 



