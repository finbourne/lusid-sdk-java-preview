

# LegDefinition

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**conventionName** | [**FlowConventionName**](FlowConventionName.md) |  |  [optional]
**conventions** | [**FlowConventions**](FlowConventions.md) |  |  [optional]
**indexConvention** | [**IndexConvention**](IndexConvention.md) |  |  [optional]
**indexConventionName** | [**FlowConventionName**](FlowConventionName.md) |  |  [optional]
**notionalExchangeType** | **String** | what type of notional exchange does the leg have  Supported string (enumeration) values are: [None, Initial, Final, Both]. | 
**payReceive** | **String** | Is the leg to be paid or received  Supported string (enumeration) values are: [NotDefined, Pay, Receive]. | 
**rateOrSpread** | **Double** | Is there either a fixed rate (non-zero) or spread to be paid over the value of the leg. | 
**resetConvention** | **String** | Control how resets are generated relative to swap payment convention(s).  Supported string (enumeration) values are: [InAdvance, InArrears]. |  [optional]
**stubType** | **String** | If a stub is required should it be at the front or back of the leg.  Supported string (enumeration) values are: [Front, Back, Both]. | 



