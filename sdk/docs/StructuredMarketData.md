

# StructuredMarketData

An item of structured market data that is to be inserted into Lusid. This will typically be a Json or Xml document that  contains a set of market quotes (tradables) that can be used to construct a composite view of a market property such as the  interest rates over time; commonly referred to as an interest rate, projection or discount curve. Other examples include  volatility surfaces and credit spread curves.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**documentFormat** | **String** | The format of the accompanying document. | 
**version** | **String** | The semantic version of the document format; MAJOR.MINOR.PATCH |  [optional]
**name** | **String** | The name or description for the document |  [optional]
**document** | **String** | The document that will be stored (or retrieved) and which describes a structured market data entity such as a credit or interest rate curve | 



