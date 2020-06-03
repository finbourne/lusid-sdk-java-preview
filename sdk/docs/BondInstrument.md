

# BondInstrument

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**startDate** | [**OffsetDateTime**](OffsetDateTime.md) |  | 
**maturityDate** | [**OffsetDateTime**](OffsetDateTime.md) |  | 
**domCcy** | **String** |  | 
**couponRate** | **Double** | simple coupon rate. | 
**principal** | **Double** | The face-value or principal for the bond at outset.              This might be reduced through its lifetime in the event of amortization or similar. | 
**flowConventions** | [**FlowConventions**](FlowConventions.md) |  | 
**identifiers** | **Map&lt;String, String&gt;** | set of market identifiers along with their types, e.g. ISIN, CUSIP, SEDOL. |  [optional]



