

# InterestRateSwap

IL Swap Instrument; Lusid-ibor internal representation of a swap instrument  A swap is the exchange of two sets of cashflows, occurring at one or more dates in one or more currencies.  These may include a notional exchange at the start and, or, maturity of the trade. Depending upon the choice of  payment currency, payment frequency and so on they can be used to match sets of future obligations

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**startDate** | **OffsetDateTime** | The start date of the instrument. This is normally synonymous with the trade-date. | 
**maturityDate** | **OffsetDateTime** | The final maturity date of the instrument. This means the last date on which the instruments makes a payment of any amount.  For the avoidance of doubt, that is not necessarily prior to its last sensitivity date for the purposes of risk; e.g. instruments such as  Constant Maturity Swaps (CMS) often have sensitivities to rates beyond their last payment date | 
**isNonDeliverable** | **Boolean** | Is the contract an IRS of \&quot;Non-Deliverable\&quot; type, meaning a single payment in the settlement currency based on the difference between  the fixed and floating rates. |  [optional]
**legs** | [**List&lt;InstrumentLeg&gt;**](InstrumentLeg.md) | The set of instrument legs that define the swap instrument. | 
**settlementCcy** | **String** | Settlement currency if IRS is non-deliverable |  [optional]



