

# Basket

Class that models a basket of risky instruments that can default.  Upon default, the weight of a defaulting instrument can (will) change and this then affects the behaviour of the basket.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**basketName** | [**BasketIdentifier**](BasketIdentifier.md) |  | 
**basketType** | **String** | What contents does the basket have. The validation will check that the instrument types contained match those expected.  Supported string (enumeration) values are: [Bonds, Credits, Equities, EquitySwap]. | 
**weightedInstruments** | [**WeightedInstruments**](WeightedInstruments.md) |  | 



