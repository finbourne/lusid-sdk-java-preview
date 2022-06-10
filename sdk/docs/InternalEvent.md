

# InternalEvent

A generic event which contains a number of possible events derived from the economic definition of an instrument.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**eventType** | **String** | What category of event does this represent; instrument opening, closing, transition or other. |  [optional] [readonly]
**eventCategory** | **String** | What category of event does this represent; instrument opening, closing, transition or other. |  [optional]
**eventSource** | **String** | What is the event source, what causes it to happen. |  [optional]
**anchorDate** | **OffsetDateTime** | In the case of a point event, the single date on which the event occurs. In the case of an event which is  spread over a window, e.g. a barrier or American option, the start of that window. |  [optional]
**eventWindowEnd** | **OffsetDateTime** | In the case of a point event this is identical to the anchor date. In the case of an event that is spread over a window,  this is the end of that window. |  [optional] [readonly]



