

# PricingContext

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**modelRules** | [**List&lt;VendorModelRule&gt;**](VendorModelRule.md) | The set of model rules that are available. There may be multiple rules for Vendors, but only one per model-instrument pair.  Which of these preference sets is used depends upon the model choice selection if specified, or failing that the global default model specification  in the options. |  [optional]
**modelChoice** | [**Map&lt;String, ModelSelection&gt;**](ModelSelection.md) | The choice of which model selection (vendor library, pricing model) to use in evaluation of a given instrument type. |  [optional]
**options** | [**PricingOptions**](PricingOptions.md) |  |  [optional]
**resultDataRules** | [**List&lt;ResultDataKeyRule&gt;**](ResultDataKeyRule.md) | Set of rules that control querying of unit results either for direct queries into aggregation or for  overriding intermediate calculations. For example, a dirty price is made up from a clean price and the accrued interest.  One might consider overriding the accrued interest calculated by a model (perhaps one wants to match an external value or simply disagrees with the  calculated result) and use that in calculation of the dirty price. |  [optional]



