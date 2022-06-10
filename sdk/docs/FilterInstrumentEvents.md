

# FilterInstrumentEvents

Instrument event query structure. The fields in the body act in and AND-wise fashion  for any instrument event query endpoint.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**instrumentEventIds** | **List&lt;String&gt;** | The set of instrument events ids. |  [optional]
**corporateActionSourceIds** | [**List&lt;ResourceId&gt;**](ResourceId.md) | The corporate action sources in which to search for events. |  [optional]
**lusidInstrumentIds** | **List&lt;String&gt;** | The lusid identifers for instruments on which the events apply. |  [optional]
**instrumentScopes** | **List&lt;String&gt;** | The set of scopes in which the instruments of interest belong. |  [optional]
**instrumentEventTypes** | **List&lt;String&gt;** | The subset of instrument event types. |  [optional]



