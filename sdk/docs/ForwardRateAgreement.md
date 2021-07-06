

# ForwardRateAgreement

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**startDate** | [**OffsetDateTime**](OffsetDateTime.md) | The start date of the instrument. This is normally synonymous with the trade-date. | 
**maturityDate** | [**OffsetDateTime**](OffsetDateTime.md) | The final maturity date of the instrument. This means the last date on which the instruments makes a payment of any amount.  For the avoidance of doubt, that is not necessarily prior to its last sensitivity date for the purposes of risk; e.g. instruments such as  Constant Maturity Swaps (CMS) often have sensitivities to rates beyond their last payment date | 
**domCcy** | **String** | The domestic currency of the instrument. | 
**fixingDate** | [**OffsetDateTime**](OffsetDateTime.md) | The date at which the rate to be paid, the reference rate, is confirmed/observed | 
**fraRate** | **Double** | The rate at which the FRA is traded. | 
**notional** | **Double** | The amount for which the FRA is traded. | 



