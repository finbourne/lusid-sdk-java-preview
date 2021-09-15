

# DiscountFactorCurveDataAllOf


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**baseDate** | **OffsetDateTime** | BaseDate for the Curve | 
**dates** | **List&lt;OffsetDateTime&gt;** | Dates for which the discount factors apply | 
**discountFactors** | **List&lt;Double&gt;** | Discount factors to be applied to cashflow on the specified dates | 
**marketDataType** | [**MarketDataTypeEnum**](#MarketDataTypeEnum) | The available values are: DiscountFactorCurveData, EquityVolSurfaceData, FxVolSurfaceData, IrVolCubeData, OpaqueMarketData, YieldCurveData, FxForwardCurveData, FxForwardPipsCurveData, FxForwardTenorCurveData, FxForwardTenorPipsCurveData | 



## Enum: MarketDataTypeEnum

Name | Value
---- | -----
DISCOUNTFACTORCURVEDATA | &quot;DiscountFactorCurveData&quot;
EQUITYVOLSURFACEDATA | &quot;EquityVolSurfaceData&quot;
FXVOLSURFACEDATA | &quot;FxVolSurfaceData&quot;
IRVOLCUBEDATA | &quot;IrVolCubeData&quot;
OPAQUEMARKETDATA | &quot;OpaqueMarketData&quot;
YIELDCURVEDATA | &quot;YieldCurveData&quot;
FXFORWARDCURVEDATA | &quot;FxForwardCurveData&quot;
FXFORWARDPIPSCURVEDATA | &quot;FxForwardPipsCurveData&quot;
FXFORWARDTENORCURVEDATA | &quot;FxForwardTenorCurveData&quot;
FXFORWARDTENORPIPSCURVEDATA | &quot;FxForwardTenorPipsCurveData&quot;



