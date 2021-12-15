

# ComplianceRuleResult


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**ruleId** | **String** | The unique identifierof a compliance rule | 
**ruleName** | **String** | The User-given name of the rule | 
**ruleDescription** | **String** | The User-given description of the rule | 
**portfolio** | [**ResourceId**](ResourceId.md) |  | 
**passed** | **Boolean** | The result of an individual compliance run, true if passed | 
**resultValue** | **Double** | The calculation result that was used to confirm a pass/fail | 
**ruleInformationMatch** | **String** | The value matched by the rule | 
**ruleInformationKey** | **String** | The property key matched by the rule | 
**ruleLowerLimit** | **Integer** | The lower limit of the rule | 
**ruleUpperLimit** | **Integer** | The upper limit of the rule | 



