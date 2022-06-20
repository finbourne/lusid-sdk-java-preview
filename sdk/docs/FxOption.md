

# FxOption

LUSID representation of an FX Option.  Including Vanilla, American, European, and Digital (Binary) options.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**startDate** | **OffsetDateTime** | The start date of the instrument. This is normally synonymous with the trade-date. | 
**optionMaturityDate** | **OffsetDateTime** | The maturity date of the option. | 
**optionSettlementDate** | **OffsetDateTime** | The settlement date of the option. | 
**isDeliveryNotCash** | **Boolean** | True if the option is settled in cash, false if delivery. | 
**isCallNotPut** | **Boolean** | True if the option is a call, false if the option is a put. | 
**strike** | **java.math.BigDecimal** | The strike of the option. | 
**domCcy** | **String** | The domestic currency of the instrument. | 
**domAmount** | **java.math.BigDecimal** | The Amount of DomCcy that will be exchanged if the option is exercised.  This amount should be a positive number, with the Call/Put flag used to indicate direction.  The corresponding amount of FgnCcy that will be exchanged is this amount times the strike.  Note there is no rounding performed on this computed value.  This is an optional field, if not set the option ContractSize will default to 1. |  [optional]
**fgnCcy** | **String** | The foreign currency of the FX. | 
**premium** | [**Premium**](Premium.md) |  |  [optional]
**fgnAmount** | **java.math.BigDecimal** | For a vanilla FxOption contract, FgnAmount cannot be set.  In case of a digital FxOption (IsPayoffDigital&#x3D;&#x3D;true)  a payoff (if the option is in the money) can be either  in domestic or in foreign currency - for the latter  FgnAmount must be set.  Note: It is invalid to have FgnAmount and DomAmount  at the same time. |  [optional]
**exerciseType** | **String** | Type of optionality that is present; European, Bermudan, American.    Supported string (enumeration) values are: [European, Bermudan, American]. |  [optional]
**isPayoffDigital** | **Boolean** | By default IsPayoffDigital is false. If IsPayoffDigital&#x3D;true,  the option is &#39;digital&#39;, and the option payoff is 0 or 1 unit of currency,  instead of a vanilla CallPayoff&#x3D;max(spot-strike,0) or PutPayoff&#x3D;max(strike-spot,0). |  [optional]



