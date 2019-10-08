

# CreateDerivedTransactionPortfolioRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**displayName** | **String** | Portfolio display name | 
**description** | **String** | A long form text description of  the portfolio |  [optional]
**code** | **String** |  | 
**parentPortfolioId** | [**ResourceId**](ResourceId.md) |  | 
**created** | [**OffsetDateTime**](OffsetDateTime.md) | The original creation date, defaults to today if not specified when creating a portfolio |  [optional]
**corporateActionSourceId** | [**ResourceId**](ResourceId.md) |  |  [optional]
**accountingMethod** | [**AccountingMethodEnum**](#AccountingMethodEnum) | Default taxlot selection method for the portfolio |  [optional]
**subHoldingKeys** | **List&lt;String&gt;** | Set of unique holding identifiers, e.g. trader, desk, strategy. |  [optional]



## Enum: AccountingMethodEnum

Name | Value
---- | -----
DEFAULT | &quot;Default&quot;
AVERAGECOST | &quot;AverageCost&quot;
FIRSTINFIRSTOUT | &quot;FirstInFirstOut&quot;
LASTINFIRSTOUT | &quot;LastInFirstOut&quot;
HIGHESTCOSTFIRST | &quot;HighestCostFirst&quot;
LOWESTCOSTFIRST | &quot;LowestCostFirst&quot;



