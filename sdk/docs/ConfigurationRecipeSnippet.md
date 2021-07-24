

# ConfigurationRecipeSnippet

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**scope** | **String** | The scope used when updating or inserting the Configuration Recipe snippet | 
**code** | **String** | User given string name (code) to identify the recipe. | 
**aggregationOptions** | [**AggregationOptions**](AggregationOptions.md) |  |  [optional]
**modelRules** | [**List&lt;VendorModelRule&gt;**](VendorModelRule.md) | The set of model rules that are available. There may be multiple rules for Vendors, but only one per model-instrument pair.  Which of these preference sets is used depends upon the model choice selection if specified, or failing that the global default model specification  in the options. |  [optional]
**pricingOptions** | [**PricingOptions**](PricingOptions.md) |  |  [optional]
**marketRules** | [**List&lt;MarketDataKeyRule&gt;**](MarketDataKeyRule.md) | The set of rules that define how to resolve particular use cases. These can be relatively general or specific in nature.  Nominally any number are possible and will be processed in order where applicable. However, there is evidently a potential  for increased computational cost where many rules must be applied to resolve data. Ensuring that portfolios are structured in  such a way as to reduce the number of rules required is therefore sensible. |  [optional]
**marketOptions** | [**MarketOptions**](MarketOptions.md) |  |  [optional]
**recipe** | [**ConfigurationRecipe**](ConfigurationRecipe.md) |  |  [optional]



