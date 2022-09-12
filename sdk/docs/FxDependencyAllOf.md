

# FxDependencyAllOf


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**domesticCurrency** | **String** | DomesticCurrency is the first currency in a currency pair quote e.g. eur-gbp, eur is the domestic currency. | 
**foreignCurrency** | **String** | ForeignCurrency is the second currency in a currency pair quote e.g. eur-gbp, gbp is the foreign currency. | 
**date** | **OffsetDateTime** | The effectiveAt of the fx rate. | 
**dependencyType** | [**DependencyTypeEnum**](#DependencyTypeEnum) | The available values are: Opaque, Cash, Discounting, EquityCurve, EquityVol, Fx, FxForwards, FxVol, IndexProjection, IrVol, Quote, Vendor | 



## Enum: DependencyTypeEnum

Name | Value
---- | -----
OPAQUE | &quot;Opaque&quot;
CASH | &quot;Cash&quot;
DISCOUNTING | &quot;Discounting&quot;
EQUITYCURVE | &quot;EquityCurve&quot;
EQUITYVOL | &quot;EquityVol&quot;
FX | &quot;Fx&quot;
FXFORWARDS | &quot;FxForwards&quot;
FXVOL | &quot;FxVol&quot;
INDEXPROJECTION | &quot;IndexProjection&quot;
IRVOL | &quot;IrVol&quot;
QUOTE | &quot;Quote&quot;
VENDOR | &quot;Vendor&quot;



