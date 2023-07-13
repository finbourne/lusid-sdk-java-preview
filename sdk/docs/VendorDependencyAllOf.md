

# VendorDependencyAllOf


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**vendorName** | **String** | The name of the outside vendor | 
**vendorPath** | **List&lt;String&gt;** | The specific dependency path | 
**date** | **OffsetDateTime** | The effectiveDate of the entity that this is a dependency for. | 
**dependencyType** | [**DependencyTypeEnum**](#DependencyTypeEnum) | The available values are: OpaqueDependency, CashDependency, DiscountingDependency, EquityCurveDependency, EquityVolDependency, FxDependency, FxForwardsDependency, FxVolDependency, IndexProjectionDependency, IrVolDependency, QuoteDependency, Vendor | 



## Enum: DependencyTypeEnum

Name | Value
---- | -----
OPAQUEDEPENDENCY | &quot;OpaqueDependency&quot;
CASHDEPENDENCY | &quot;CashDependency&quot;
DISCOUNTINGDEPENDENCY | &quot;DiscountingDependency&quot;
EQUITYCURVEDEPENDENCY | &quot;EquityCurveDependency&quot;
EQUITYVOLDEPENDENCY | &quot;EquityVolDependency&quot;
FXDEPENDENCY | &quot;FxDependency&quot;
FXFORWARDSDEPENDENCY | &quot;FxForwardsDependency&quot;
FXVOLDEPENDENCY | &quot;FxVolDependency&quot;
INDEXPROJECTIONDEPENDENCY | &quot;IndexProjectionDependency&quot;
IRVOLDEPENDENCY | &quot;IrVolDependency&quot;
QUOTEDEPENDENCY | &quot;QuoteDependency&quot;
VENDOR | &quot;Vendor&quot;



