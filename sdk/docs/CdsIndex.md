

# CdsIndex

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**startDate** | [**OffsetDateTime**](OffsetDateTime.md) | The start date of the instrument. This is normally synonymous with the trade-date. | 
**maturityDate** | [**OffsetDateTime**](OffsetDateTime.md) | The final maturity date of the instrument. This means the last date on which the instruments makes a payment of any amount.  For the avoidance of doubt, that is not necessarily prior to its last sensitivity date for the purposes of risk; e.g. instruments such as  Constant Maturity Swaps (CMS) often have sensitivities to rates beyond their last payment date | 
**flowConventions** | [**CdsFlowConventions**](CdsFlowConventions.md) |  |  [optional]
**couponRate** | **Double** | The coupon rate paid on each payment date of the premium leg as a fraction of 100 percent, e.g. \&quot;0.05\&quot; meaning 500 basis points or 5%.  For a standard corporate CDS (North American) this must be either 100bps or 500bps. | 
**identifiers** | **Map&lt;String, String&gt;** | external market codes and identifiers for the cds index, e.g. a RED code, BBG ID or ICE code. | 
**basket** | [**Basket**](Basket.md) |  | 
**conventionName** | [**FlowConventionName**](FlowConventionName.md) |  |  [optional]
**notional** | **Double** | The notional quantity that applies to both the premium and protection legs | 



