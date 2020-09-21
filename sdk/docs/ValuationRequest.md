

# ValuationRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**recipeId** | [**ResourceId**](ResourceId.md) |  |  [optional]
**asAt** | [**OffsetDateTime**](OffsetDateTime.md) | The asAt date to use |  [optional]
**metrics** | [**List&lt;AggregateSpec&gt;**](AggregateSpec.md) | The set of specifications for items to calculate or retrieve during the aggregation and present in the results.  This is logically equivalent to the set of operations in a Sql select statement  select [operation1(field1), operation2(field2), ... ] from results | 
**groupBy** | **List&lt;String&gt;** | The set of items by which to perform grouping. This primarily matters when one or more of the metric operators is a mapping  that reduces set size, e.g. sum or proportion. The group-by statement determines the set of keys by which to break the results out. |  [optional]
**filters** | [**List&lt;PropertyFilter&gt;**](PropertyFilter.md) | A set of filters to use to reduce the data found in a request. Equivalent to the &#39;where ...&#39; part of a Sql select statement.  For example, filter a set of values within a given range or matching a particular value. |  [optional]
**sort** | [**List&lt;OrderBySpec&gt;**](OrderBySpec.md) | A (possibly empty/null) set of specifications for how to order the results. |  [optional]
**reportCurrency** | **String** | Three letter ISO currency string indicating what currency to report in for ReportCurrency denominated queries.  If not present then the currency of the relevant portfolio will be used in its place where relevant. |  [optional]
**portfolioEntityIds** | [**List&lt;PortfolioEntityId&gt;**](PortfolioEntityId.md) | The set of portfolio or portfolio group identifiers that state what is to be valued. |  [optional]
**valuationSchedule** | [**ValuationSchedule**](ValuationSchedule.md) |  |  [optional]



