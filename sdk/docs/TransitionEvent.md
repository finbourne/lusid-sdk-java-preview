

# TransitionEvent

A generic event with event consequences modeled as transitions.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**announcementDate** | **OffsetDateTime** | The announcement date of the corporate action |  [optional]
**exDate** | **OffsetDateTime** | The ex date of the corporate action |  [optional]
**recordDate** | **OffsetDateTime** | The record date of the corporate action |  [optional]
**paymentDate** | **OffsetDateTime** | The payment date of the corporate action |  [optional]
**transitions** | [**List&lt;CorporateActionTransitionRequest&gt;**](CorporateActionTransitionRequest.md) | The transitions that result from this corporate action |  [optional]



