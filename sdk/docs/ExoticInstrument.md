

# ExoticInstrument

Class modeling an instrument which is not fully described, in the sense of being able to obtain a price or other analytic result,              by a simple SecurityUid. This would include non-exchange traded instruments such as an interest-rate-swap (IRS) and obviously 3rd generation exotics              like FX-TARNs or FX-Chooser-Redeemers and Credit instruments like CDS or Tranches.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**instrumentFormat** | [**InstrumentDefinitionFormat**](InstrumentDefinitionFormat.md) |  | 
**content** | **String** | The original document received into the system. This format could potentially be anything though is most likely to be either Json or Xml. In the case where no other              interface is supported it is possible to fall back onto this.              For example, a trade from an external client system. This may be recognized internally by Lusid or simply passed through to another vendor system. | 



