

# InterestRateSwaptionAllOf

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**startDate** | [**OffsetDateTime**](OffsetDateTime.md) | The start date of the instrument. This is normally synonymous with the trade-date. | 
**payOrReceiveFixed** | [**PayOrReceiveFixedEnum**](#PayOrReceiveFixedEnum) | The available values are: NotDefined, Pay, Receive | 
**deliveryMethod** | [**DeliveryMethodEnum**](#DeliveryMethodEnum) | The available values are: Cash, Physical | 
**swap** | [**InterestRateSwap**](InterestRateSwap.md) |  | 
**instrumentType** | [**InstrumentTypeEnum**](#InstrumentTypeEnum) | The available values are: QuotedSecurity, InterestRateSwap, FxForward, Future, ExoticInstrument, FxOption, CreditDefaultSwap, InterestRateSwaption, Bond, EquityOption, FixedLeg, FloatingLeg, BespokeCashFlowsLeg, Unknown, TermDeposit, ContractForDifference, EquitySwap, CashPerpetual, CashSettled, CdsIndex, Basket, FundingLeg, CrossCurrencySwap, FxSwap, ForwardRateAgreement, SimpleInstrument, Repo | 



## Enum: PayOrReceiveFixedEnum

Name | Value
---- | -----
NOTDEFINED | &quot;NotDefined&quot;
PAY | &quot;Pay&quot;
RECEIVE | &quot;Receive&quot;



## Enum: DeliveryMethodEnum

Name | Value
---- | -----
CASH | &quot;Cash&quot;
PHYSICAL | &quot;Physical&quot;



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



