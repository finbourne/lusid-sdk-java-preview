

# UpsertReferencePortfolioConstituentsRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**effectiveFrom** | [**OffsetDateTime**](OffsetDateTime.md) | The first date from which the weights will apply | 
**weightType** | [**WeightTypeEnum**](#WeightTypeEnum) | Indicates the weight reset methods. Static, floating or periodical | 
**periodType** | [**PeriodTypeEnum**](#PeriodTypeEnum) | Indicates the period type (daily, weekly) that weights will reset |  [optional]
**periodCount** | **Integer** | How many multiples of the period between resets |  [optional]
**constituents** | [**List&lt;ReferencePortfolioConstituentRequest&gt;**](ReferencePortfolioConstituentRequest.md) | Set of constituents (instrument/weight pairings) | 



## Enum: WeightTypeEnum

Name | Value
---- | -----
STATIC | &quot;Static&quot;
FLOATING | &quot;Floating&quot;
PERIODICAL | &quot;Periodical&quot;



## Enum: PeriodTypeEnum

Name | Value
---- | -----
DAILY | &quot;Daily&quot;
WEEKLY | &quot;Weekly&quot;
MONTHLY | &quot;Monthly&quot;
QUARTERLY | &quot;Quarterly&quot;
ANNUALLY | &quot;Annually&quot;



