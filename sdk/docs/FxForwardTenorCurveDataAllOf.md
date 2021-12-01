

# FxForwardTenorCurveDataAllOf


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**baseDate** | **OffsetDateTime** | EffectiveAt date of the quoted rates | 
**domCcy** | **String** | Domestic currency of the fx forward | 
**fgnCcy** | **String** | Foreign currency of the fx forward | 
**tenors** | **List&lt;String&gt;** | Tenors for which the forward rates apply | 
**rates** | **List&lt;Double&gt;** | Rates provided for the fx forward (price in FgnCcy per unit of DomCcy) | 
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



