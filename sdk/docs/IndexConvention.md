

# IndexConvention

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**fixingReference** | **String** | The reference rate name for fixings | 
**publicationDayLag** | **Integer** | Number of days between spot and publication of the rate. | 
**paymentTenor** | **String** | The tenor of the payment. For an OIS index this is always 1 day. For other indices, e.g. LIBOR it will have a variable tenor typically between 1 day and 1 year. | 
**dayCountConvention** | **String** | when calculating the fraction of a year between two dates, what convention is used to represent the number of days in a year              and difference between them. | 
**currency** | **String** | Currency of the index convention. | 
**scope** | **String** | The scope used when updating or inserting the convention. |  [optional]
**code** | **String** | The code of the convention. |  [optional]



