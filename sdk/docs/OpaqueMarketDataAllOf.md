

# OpaqueMarketDataAllOf


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**document** | **String** | The document as a string. | 
**format** | **String** | What format is the document stored in, e.g. Xml.  Supported string (enumeration) values are: [Unknown, Xml, Json, Csv]. | 
**name** | **String** | Internal name of document. This is not used for search, it is simply a designator that helps identify the document  and could be anything (filename, ftp address or similar) | 
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



