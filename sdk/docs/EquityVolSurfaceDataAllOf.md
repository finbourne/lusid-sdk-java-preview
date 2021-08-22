

# EquityVolSurfaceDataAllOf

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**baseDate** | [**OffsetDateTime**](OffsetDateTime.md) | Base date of the surface | 
**instruments** | [**List&lt;LusidInstrument&gt;**](LusidInstrument.md) | The set of instruments that define the surface. | 
**quotes** | [**List&lt;MarketQuote&gt;**](MarketQuote.md) | The set of market quotes that define the surface, in NormalVol or LogNormalVol terms. | 
**marketDataType** | [**MarketDataTypeEnum**](#MarketDataTypeEnum) | The available values are: DiscountFactorCurveData, EquityVolSurfaceData, FxVolSurfaceData, IrVolCubeData, OpaqueMarketData, YieldCurveData | 



## Enum: MarketDataTypeEnum

Name | Value
---- | -----
DISCOUNTFACTORCURVEDATA | &quot;DiscountFactorCurveData&quot;
EQUITYVOLSURFACEDATA | &quot;EquityVolSurfaceData&quot;
FXVOLSURFACEDATA | &quot;FxVolSurfaceData&quot;
IRVOLCUBEDATA | &quot;IrVolCubeData&quot;
OPAQUEMARKETDATA | &quot;OpaqueMarketData&quot;
YIELDCURVEDATA | &quot;YieldCurveData&quot;



