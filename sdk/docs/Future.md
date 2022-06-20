

# Future

IL Fx-Forward Instrument; Lusid-ibor internal representation of a Fx Forward instrument                A future contract, entered into on the start date at an initial reference spot price has zero initial value. It is a commitment to buy a certain number of  contracts of a certain size at a date in the future.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**startDate** | **OffsetDateTime** | The start date of the instrument. This is normally synonymous with the trade-date. | 
**maturityDate** | **OffsetDateTime** | The final maturity date of the instrument. This means the last date on which the instruments makes a payment of any amount.  For the avoidance of doubt, that is not necessarily prior to its last sensitivity date for the purposes of risk; e.g. instruments such as  Constant Maturity Swaps (CMS) often have sensitivities to rates that may well be observed or set prior to the maturity date, but refer to a termination date beyond it. | 
**identifiers** | **Map&lt;String, String&gt;** | External market codes and identifiers for the bond, e.g. ISIN. | 
**contractDetails** | [**FuturesContractDetails**](FuturesContractDetails.md) |  | 
**contracts** | **java.math.BigDecimal** | The number of contracts held. |  [optional]
**refSpotPrice** | **java.math.BigDecimal** | The reference spot price for the future at which the contract was entered into. |  [optional]
**underlying** | [**LusidInstrument**](LusidInstrument.md) |  |  [optional]



