

# SwapInstrument

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**startDate** | [**OffsetDateTime**](OffsetDateTime.md) | Starting date of the swap | 
**maturityDate** | [**OffsetDateTime**](OffsetDateTime.md) | Maturity date of the swap | 
**legs** | [**List&lt;InstrumentLeg&gt;**](InstrumentLeg.md) | True if the swap is amortizing | 
**notional** | **Double** | The notional. | 
**isAmortizing** | **Boolean** | True if the swap is amortizing | 
**notionalExchangeType** | [**NotionalExchangeTypeEnum**](#NotionalExchangeTypeEnum) | True notional exchange type. | 



## Enum: NotionalExchangeTypeEnum

Name | Value
---- | -----
NONE | &quot;None&quot;
INITIAL | &quot;Initial&quot;
FINAL | &quot;Final&quot;
BOTH | &quot;Both&quot;



