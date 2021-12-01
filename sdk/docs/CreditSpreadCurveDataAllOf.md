

# CreditSpreadCurveDataAllOf


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**baseDate** | **OffsetDateTime** | EffectiveAt date of the quoted rates | 
**domCcy** | **String** | Domestic currency of the curve | 
**recoveryRate** | **Double** | The recovery rate in default. | 
**spreads** | **List&lt;Double&gt;** | Par spread quotes corresponding to the tenors. | 
**tenors** | **List&lt;String&gt;** | The tenors for which the rates apply | 
**marketDataType** | [**MarketDataTypeEnum**](#MarketDataTypeEnum) | The available values are: DiscountFactorCurveData, EquityVolSurfaceData, FxVolSurfaceData, IrVolCubeData, OpaqueMarketData, YieldCurveData, FxForwardCurveData, FxForwardPipsCurveData, FxForwardTenorCurveData, FxForwardTenorPipsCurveData, FxForwardCurveByQuoteReference, CreditSpreadCurveData | 



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
FXFORWARDCURVEBYQUOTEREFERENCE | &quot;FxForwardCurveByQuoteReference&quot;
CREDITSPREADCURVEDATA | &quot;CreditSpreadCurveData&quot;



