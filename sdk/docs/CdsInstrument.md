

# CdsInstrument

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**ticker** | **String** | A ticker to uniquely specify then entity against which the cds is written | 
**flowConventions** | [**CdsFlowConventions**](CdsFlowConventions.md) |  | 
**couponRate** | **Double** | The coupon rate paid on each payment date of the premium leg as a fraction of 100 percent, e.g. \&quot;0.05\&quot; meaning 500 basis points or 5%.  For a standard corporate CDS (North American) this must be either 100bps or 500bps. | 
**protectionDetailSpecification** | [**CdsProtectionDetailSpecification**](CdsProtectionDetailSpecification.md) |  | 
**startDate** | [**OffsetDateTime**](OffsetDateTime.md) | Starting date of the credit default swap | 
**maturityDate** | [**OffsetDateTime**](OffsetDateTime.md) | Maturity date of the credit default swap | 
**domCcy** | **String** | Domestic currency of the credit default swap | 



