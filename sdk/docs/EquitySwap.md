

# EquitySwap

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**startDate** | [**OffsetDateTime**](OffsetDateTime.md) | The start date of the EquitySwap | 
**maturityDate** | [**OffsetDateTime**](OffsetDateTime.md) | The maturity date of the EquitySwap. | 
**code** | **String** | The code of the underlying. | 
**equityFlowConventions** | [**FlowConventions**](FlowConventions.md) |  | 
**fundingLeg** | [**InstrumentLeg**](InstrumentLeg.md) |  | 
**includeDividends** | **Boolean** | Dividend inclusion flag, if true dividends are included in the equity leg (total return). | 
**initialPrice** | **Double** | The initial equity price of the Equity Swap. | 
**notionalReset** | **Boolean** | Notional reset flag, if true the notional of the funding leg is reset at the start of every  coupon to match the value of the equity leg (equity price at start of coupon times quantity) | 
**quantity** | **Double** | The quantity or number of shares in the Equity Swap. | 
**underlyingIdentifier** | **String** | external market codes and identifiers for the EquitySwap, e.g. RIC.  Supported string (enumeration) values are: [LusidInstrumentId, Isin, Sedol, Cusip, ClientInternal, Figi, RIC, QuotePermId, REDCode, BBGId, ICECode]. | 



