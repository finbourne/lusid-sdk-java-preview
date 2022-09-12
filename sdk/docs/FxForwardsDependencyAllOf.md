

# FxForwardsDependencyAllOf


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**domesticCurrency** | **String** | DomesticCurrency is the first currency in a currency pair quote e.g. eur-gbp, eur is the domestic currency. | 
**foreignCurrency** | **String** | ForeignCurrency is the second currency in a currency pair quote e.g. eur-gbp, gbp is the foreign currency. | 
**curveType** | **String** | Used to describe the format in which the curve is expressed  e.g. FxFwdCurve (general term to describe any representation), TenorFxFwdCurve, PipsFxFwdCurve. | 
**date** | **OffsetDateTime** | The effectiveDate of the entity that this is a dependency for.  Unless there is an obvious date this should be, like for a historic reset, then this is the valuation date. | 
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



