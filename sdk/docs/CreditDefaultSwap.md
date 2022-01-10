

# CreditDefaultSwap

IL CDS Instrument; Lusid-ibor internal representation of a Credit Default Swap instrument

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**ticker** | **String** | A ticker to uniquely specify then entity against which the cds is written. | 
**startDate** | **OffsetDateTime** | The start date of the instrument. This is normally synonymous with the trade-date. | 
**maturityDate** | **OffsetDateTime** | The final maturity date of the instrument. This means the last date on which the instruments makes a payment of any amount.  For the avoidance of doubt, that is not necessarily prior to its last sensitivity date for the purposes of risk; e.g. instruments such as  Constant Maturity Swaps (CMS) often have sensitivities to rates beyond their last payment date. | 
**flowConventions** | [**CdsFlowConventions**](CdsFlowConventions.md) |  |  [optional]
**couponRate** | **Double** | The coupon rate paid on each payment date of the premium leg as a fraction of 100 percent, e.g. \&quot;0.05\&quot; meaning 500 basis points or 5%.  For a standard corporate CDS (North American) this must be either 100bps or 500bps. | 
**conventionName** | [**FlowConventionName**](FlowConventionName.md) |  |  [optional]
**notional** | **Double** | The notional protected by the Credit Default Swap |  [optional]
**protectionDetailSpecification** | [**CdsProtectionDetailSpecification**](CdsProtectionDetailSpecification.md) |  | 



