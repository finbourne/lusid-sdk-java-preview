

# GetQuotesResponse

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**href** | **String** |  |  [optional]
**values** | [**Map&lt;String, Quote&gt;**](Quote.md) | The collection of requested quote series with their latest values |  [optional]
**notFound** | [**Map&lt;String, List&lt;String&gt;&gt;**](List.md) | If any quotes could not be retrieved, they will be listed in &#39;NotFound&#39;, along  with a reason why. |  [optional]
**failed** | [**Map&lt;String, List&lt;String&gt;&gt;**](List.md) | If any quotes could not be requested, due to errors in the structure of the   QuoteSeriesId, they will be listed in &#39;Failed&#39;, along with the reason(s) why. |  [optional]
**links** | [**List&lt;Link&gt;**](Link.md) |  |  [optional]



