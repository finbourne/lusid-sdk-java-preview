

# UpsertRecipeRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**code** | **String** | User given string name (code) to identify the recipe or snippet for storage in and retrieval from the data store.  Sensibly it would be expected to match the same code given inside the configuration recipe, if that is the element being stored,  though this is not enforced. In the case of a snippet for rules or options, again a sensible naming convention such as options_...  or marketrules_... is advocated to aid in ease of understanding when included elsewhere though not enforced. | 
**configurationRecipe** | [**ConfigurationRecipe**](ConfigurationRecipe.md) |  |  [optional]
**configurationRecipeSnippet** | [**ConfigurationRecipeSnippet**](ConfigurationRecipeSnippet.md) |  |  [optional]



