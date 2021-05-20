

# Order

An Order for a certain quantity of a specific instrument

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**properties** | [**Map&lt;String, PerpetualProperty&gt;**](PerpetualProperty.md) | Client-defined properties associated with this order. |  [optional]
**version** | [**Version**](Version.md) |  |  [optional]
**instrumentIdentifiers** | **Map&lt;String, String&gt;** | The instrument ordered. | 
**quantity** | **Integer** | The quantity of given instrument ordered. | 
**side** | **String** | The client&#39;s representation of the order&#39;s side (buy, sell, short, etc) | 
**orderBookId** | [**ResourceId**](ResourceId.md) |  |  [optional]
**portfolioId** | [**ResourceId**](ResourceId.md) |  | 
**id** | [**ResourceId**](ResourceId.md) |  | 
**lusidInstrumentId** | **String** | The LUSID instrument id for the instrument ordered. | 
**links** | [**List&lt;Link&gt;**](Link.md) |  |  [optional]



