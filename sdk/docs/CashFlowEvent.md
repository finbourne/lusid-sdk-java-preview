

# CashFlowEvent

Definition of a CashFlow event.  This is an event that describes the occurence of a cashflow and associated information.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | **java.math.BigDecimal** | The quantity (amount) that will be paid, if known. This value will be negative if it is paid, and positive  if it is received. |  [optional]
**currency** | **String** | The payment currency of the cash flow. | 
**eventType** | **String** | What type of internal event does this represent; coupon, principal, premium etc. |  [readonly]
**eventStatus** | **String** | What is the event status, is it a known (ie historic) or unknown (ie projected) event? | 
**paymentDate** | **OffsetDateTime** | The date on which the cashflow is scheduled to be paid into the recipient&#39;s bank account. | 



