

# QuoteDependencyAllOf


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**marketIdentifier** | **String** | Type of the code identifying the asset, e.g. ISIN or CUSIP | 
**code** | **String** | The code identifying the corresponding equity, e.g. US0378331005 if the MarketIdentifier was set to ISIN | 
**date** | **OffsetDateTime** | The effectiveAt of the quote for the identified entity. | 
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



