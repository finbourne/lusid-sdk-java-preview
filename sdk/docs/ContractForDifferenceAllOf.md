

# ContractForDifferenceAllOf


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**startDate** | **OffsetDateTime** | The start date of the CFD. | 
**maturityDate** | **OffsetDateTime** | The maturity date for the CFD. If CFDType is Futures, this should be set to be the maturity date of the underlying  future. If CFDType is Cash, this should not be set. |  [optional]
**code** | **String** | The code of the underlying. | 
**contractSize** | **Double** | The size of the CFD contract, this should represent the total number of stocks that the CFD represents. | 
**payCcy** | **String** | The currency that this CFD pays out, this can be different to the UnderlyingCcy. | 
**referenceRate** | **Double** | The reference rate of the CFD, this can be set to 0 but not negative values.  This field is optional, if not set it will default to 0. |  [optional]
**type** | **String** | The type of CFD.  Supported string (enumeration) values are: [Cash, Futures]. | 
**underlyingCcy** | **String** | The currency of the underlying | 
**underlyingIdentifier** | **String** | external market codes and identifiers for the CFD, e.g. RIC.  Supported string (enumeration) values are: [LusidInstrumentId, Isin, Sedol, Cusip, ClientInternal, Figi, RIC, QuotePermId, REDCode, BBGId, ICECode]. | 
**instrumentType** | [**InstrumentTypeEnum**](#InstrumentTypeEnum) | The available values are: QuotedSecurity, InterestRateSwap, FxForward, Future, ExoticInstrument, FxOption, CreditDefaultSwap, InterestRateSwaption, Bond, EquityOption, FixedLeg, FloatingLeg, BespokeCashFlowsLeg, Unknown, TermDeposit, ContractForDifference, EquitySwap, CashPerpetual, CashSettled, CdsIndex, Basket, FundingLeg, CrossCurrencySwap, FxSwap, ForwardRateAgreement, SimpleInstrument, Repo | 



## Enum: InstrumentTypeEnum

Name | Value
---- | -----
QUOTEDSECURITY | &quot;QuotedSecurity&quot;
INTERESTRATESWAP | &quot;InterestRateSwap&quot;
FXFORWARD | &quot;FxForward&quot;
FUTURE | &quot;Future&quot;
EXOTICINSTRUMENT | &quot;ExoticInstrument&quot;
FXOPTION | &quot;FxOption&quot;
CREDITDEFAULTSWAP | &quot;CreditDefaultSwap&quot;
INTERESTRATESWAPTION | &quot;InterestRateSwaption&quot;
BOND | &quot;Bond&quot;
EQUITYOPTION | &quot;EquityOption&quot;
FIXEDLEG | &quot;FixedLeg&quot;
FLOATINGLEG | &quot;FloatingLeg&quot;
BESPOKECASHFLOWSLEG | &quot;BespokeCashFlowsLeg&quot;
UNKNOWN | &quot;Unknown&quot;
TERMDEPOSIT | &quot;TermDeposit&quot;
CONTRACTFORDIFFERENCE | &quot;ContractForDifference&quot;
EQUITYSWAP | &quot;EquitySwap&quot;
CASHPERPETUAL | &quot;CashPerpetual&quot;
CASHSETTLED | &quot;CashSettled&quot;
CDSINDEX | &quot;CdsIndex&quot;
BASKET | &quot;Basket&quot;
FUNDINGLEG | &quot;FundingLeg&quot;
CROSSCURRENCYSWAP | &quot;CrossCurrencySwap&quot;
FXSWAP | &quot;FxSwap&quot;
FORWARDRATEAGREEMENT | &quot;ForwardRateAgreement&quot;
SIMPLEINSTRUMENT | &quot;SimpleInstrument&quot;
REPO | &quot;Repo&quot;



