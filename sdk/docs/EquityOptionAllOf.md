

# EquityOptionAllOf

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**startDate** | [**OffsetDateTime**](OffsetDateTime.md) | The start date of the instrument. This is normally synonymous with the trade-date. | 
**optionMaturityDate** | [**OffsetDateTime**](OffsetDateTime.md) | The maturity date of the option. | 
**optionSettlementDate** | [**OffsetDateTime**](OffsetDateTime.md) | The settlement date of the option. | 
**deliveryType** | [**DeliveryTypeEnum**](#DeliveryTypeEnum) | The available values are: Cash, Physical | 
**optionType** | [**OptionTypeEnum**](#OptionTypeEnum) | The available values are: None, Call, Put | 
**strike** | **Double** | The strike of the option. | 
**domCcy** | **String** | The domestic currency of the instrument. | 
**underlyingIdentifier** | [**UnderlyingIdentifierEnum**](#UnderlyingIdentifierEnum) | The available values are: LusidInstrumentId, Isin, Sedol, Cusip, ClientInternal, Figi, RIC, QuotePermId, REDCode, BBGId, ICECode | 
**code** | **String** | The identifying code for the equity underlying, e.g. &#39;IBM.N&#39;. | 
**instrumentType** | [**InstrumentTypeEnum**](#InstrumentTypeEnum) | The available values are: QuotedSecurity, InterestRateSwap, FxForward, Future, ExoticInstrument, FxOption, CreditDefaultSwap, InterestRateSwaption, Bond, EquityOption, FixedLeg, FloatingLeg, BespokeCashFlowsLeg, Unknown, TermDeposit, ContractForDifference, EquitySwap, CashPerpetual, CashSettled, CdsIndex, Basket, FundingLeg, CrossCurrencySwap, FxSwap, ForwardRateAgreement, SimpleInstrument, Repo | 



## Enum: DeliveryTypeEnum

Name | Value
---- | -----
CASH | &quot;Cash&quot;
PHYSICAL | &quot;Physical&quot;



## Enum: OptionTypeEnum

Name | Value
---- | -----
NONE | &quot;None&quot;
CALL | &quot;Call&quot;
PUT | &quot;Put&quot;



## Enum: UnderlyingIdentifierEnum

Name | Value
---- | -----
LUSIDINSTRUMENTID | &quot;LusidInstrumentId&quot;
ISIN | &quot;Isin&quot;
SEDOL | &quot;Sedol&quot;
CUSIP | &quot;Cusip&quot;
CLIENTINTERNAL | &quot;ClientInternal&quot;
FIGI | &quot;Figi&quot;
RIC | &quot;RIC&quot;
QUOTEPERMID | &quot;QuotePermId&quot;
REDCODE | &quot;REDCode&quot;
BBGID | &quot;BBGId&quot;
ICECODE | &quot;ICECode&quot;



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



