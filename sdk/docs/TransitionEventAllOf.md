

# TransitionEventAllOf


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**announcementDate** | **OffsetDateTime** | The announcement date of the corporate action |  [optional]
**exDate** | **OffsetDateTime** | The ex date of the corporate action |  [optional]
**recordDate** | **OffsetDateTime** | The record date of the corporate action |  [optional]
**paymentDate** | **OffsetDateTime** | The payment date of the corporate action |  [optional]
**transitions** | [**List&lt;CorporateActionTransitionRequest&gt;**](CorporateActionTransitionRequest.md) | The transitions that result from this corporate action |  [optional]
**instrumentEventType** | [**InstrumentEventTypeEnum**](#InstrumentEventTypeEnum) | The Type of Event. The available values are: TransitionEvent, InternalEvent, CouponEvent, OpenEvent, CloseEvent | 



## Enum: InstrumentEventTypeEnum

Name | Value
---- | -----
TRANSITIONEVENT | &quot;TransitionEvent&quot;
INTERNALEVENT | &quot;InternalEvent&quot;
COUPONEVENT | &quot;CouponEvent&quot;
OPENEVENT | &quot;OpenEvent&quot;
CLOSEEVENT | &quot;CloseEvent&quot;



