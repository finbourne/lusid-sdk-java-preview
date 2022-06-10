

# InstrumentEventHolder

An instrument event equipped with additional metadata.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**instrumentIdentifiers** | **Map&lt;String, String&gt;** | The set of identifiers which determine the instrument this event relates to. | 
**corporateActionSourceId** | [**ResourceId**](ResourceId.md) |  | 
**instrumentEvent** | [**InstrumentEvent**](InstrumentEvent.md) |  | 
**properties** | [**List&lt;Property&gt;**](Property.md) | The properties attached to this instrument event. |  [optional]
**anchorDate** | **OffsetDateTime** | The date the event is determined to have occured. |  [optional]
**lusidInstrumentId** | **String** | The LUID for the instrument. | 
**instrumentScope** | **String** | The scope of the instrument. | 
**instrumentEventId** | **String** | The unique identifier of this corporate action. | 
**description** | **String** | The description of the instrument event. | 



