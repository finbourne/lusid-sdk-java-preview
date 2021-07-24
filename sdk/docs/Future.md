

# Future

IL Fx-Forward Instrument; Lusid-ibor internal representation of a Fx Forward instrument                             A future contract, entered into on the start date at an initial reference spot price has zero initial value. It is a committment to buy a certain number of               contracts of a certain size at a date in the future.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**startDate** | **OffsetDateTime** | The start date of the instrument. This is normally synonymous with the trade-date. | 
**maturityDate** | **OffsetDateTime** | The final maturity date of the instrument. This means the last date on which the instruments makes a payment of any amount.              For the avoidance of doubt, that is not necessarily prior to its last sensitivity date for the purposes of risk; e.g. instruments such as              Constant Maturity Swaps (CMS) often have sensitivities to rates beyond their last payment date | 
**identifiers** | **Map&lt;String, String&gt;** | external market codes and identifiers for the bond, e.g. ISIN. | 
**contractDetails** | [**FuturesContractDetails**](FuturesContractDetails.md) |  | 
**contracts** | **Double** | The number of contracts held |  [optional]
**refSpotPrice** | **Double** | The reference spot price for the future at which the contract was entered into. |  [optional]
**underlying** | [**LusidInstrument**](LusidInstrument.md) |  | 



