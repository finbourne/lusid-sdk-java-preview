

# FeeCalculationDetails


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**ruleType** | **String** | Rule Type | 
**ruleInformation** | **String** | Rule Sub Type | 
**additionalInformation** | **Map&lt;String, String&gt;** | Other property keys populated for the fee | 
**propertyKey** | **String** | The property key which uniquely identifies the property. The format for the property key is {domain}/{scope}/{code}, e.g. &#39;Portfolio/Manager/Id&#39;. | 
**fee** | [**CalculationInfo**](CalculationInfo.md) |  | 
**maxFee** | [**CalculationInfo**](CalculationInfo.md) |  |  [optional]
**minFee** | [**CalculationInfo**](CalculationInfo.md) |  |  [optional]



