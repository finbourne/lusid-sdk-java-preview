

# Allocation

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | [**ResourceId**](ResourceId.md) |  | 
**allocatedOrderId** | [**ResourceId**](ResourceId.md) |  | 
**portfolioId** | [**ResourceId**](ResourceId.md) |  | 
**quantity** | **Integer** | The quantity of given instrument allocated. | 
**instrumentIdentifiers** | **Map&lt;String, String&gt;** | The instrument allocated. | 
**version** | [**Version**](Version.md) |  |  [optional]
**properties** | [**Map&lt;String, PerpetualProperty&gt;**](PerpetualProperty.md) | Client-defined properties associated with this allocation. |  [optional]
**lusidInstrumentId** | **String** | The LUSID instrument id for the instrument allocated. | 
**links** | [**List&lt;Link&gt;**](Link.md) |  |  [optional]



