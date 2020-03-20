

# FxForwardInstrument

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**domAmount** | **Double** | The amount that is to be paid in the domestic currency on the maturity date. | 
**fgnAmount** | **Double** | The amount that is to be paid in the foreign currency on the maturity date | 
**isNdf** | **Boolean** | Is the contract an Fx-Forward of \&quot;Non-Deliverable\&quot; type, meaning a single payment in the domestic currency based on  the change in fx-rate vs  a reference rate is used. |  [optional]
**fixingDate** | [**OffsetDateTime**](OffsetDateTime.md) | The fixing date. Its presence determines the NDF status of the instrument. |  [optional]
**fgnCcy** | **String** | The foreign (other) currency of the instrument. In the NDF case, only payments are made in the domestic currency.  For the outright forward, currencies are exchanged. By domestic is then that of the portfolio. | 
**refSpotRate** | **Double** | The reference Fx Spot rate for currency pair Foreign-Domestic that was seen on the trade start date (time). |  [optional]
**startDate** | [**OffsetDateTime**](OffsetDateTime.md) | The start date of the instrument. This is normally synonymous with the trade-date. | 
**maturityDate** | [**OffsetDateTime**](OffsetDateTime.md) | The final maturity date of the instrument. This means the last date on which the instruments makes a payment of any amount.  For the avoidance of doubt, that is not necessarily prior to its last sensitivity date for the purposes of risk; e.g. instruments such as  Constant Maturity Swaps (CMS) often have sensitivities to rates beyond their last payment date | 
**domCcy** | **String** | The domestic currency of the instrument. | 
**instrumentType** | [**InstrumentTypeEnum**](#InstrumentTypeEnum) | Instrument type, must be property for JSON. | 



## Enum: InstrumentTypeEnum

Name | Value
---- | -----
QUOTEDSECURITY | &quot;QuotedSecurity&quot;
INTERESTRATESWAP | &quot;InterestRateSwap&quot;
FXFORWARD | &quot;FxForward&quot;
EXOTIC | &quot;Exotic&quot;
FXOPTION | &quot;FxOption&quot;
CREDITDEFAULTSWAP | &quot;CreditDefaultSwap&quot;
INTERESTRATESWAPTION | &quot;InterestRateSwaption&quot;
BOND | &quot;Bond&quot;
UNKNOWN | &quot;Unknown&quot;



