

# Bond

IL Bond Instrument; Lusid-ibor internal representation of a Bond instrument

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**startDate** | **OffsetDateTime** | The start date of the instrument. This is normally synonymous with the trade-date. | 
**maturityDate** | **OffsetDateTime** | The final maturity date of the instrument. This means the last date on which the instruments makes a payment of any amount.              For the avoidance of doubt, that is not necessarily prior to its last sensitivity date for the purposes of risk; e.g. instruments such as              Constant Maturity Swaps (CMS) often have sensitivities to rates beyond their last payment date | 
**domCcy** | **String** | The domestic currency of the instrument. | 
**flowConventions** | [**FlowConventions**](FlowConventions.md) |  | 
**principal** | **Double** | The face-value or principal for the bond at outset.              This might be reduced through its lifetime in the event of amortization or similar. | 
**couponRate** | **Double** | simple coupon rate. | 
**identifiers** | **Map&lt;String, String&gt;** | external market codes and identifiers for the bond, e.g. ISIN. |  [optional]
**exDividendDays** | **Integer** | The number of days before the next coupon payment for which the bond goes ex-dividend. |  [optional]
**initialCouponDate** | **OffsetDateTime** | The initial coupon date which specifies the accrual start period for a fixed coupon bond with ex dividend schedule |  [optional]



