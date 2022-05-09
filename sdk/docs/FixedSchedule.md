

# FixedSchedule

Schedule for fixed coupon payments

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**startDate** | **OffsetDateTime** | Date to start generate from | 
**maturityDate** | **OffsetDateTime** | Date to generate to | 
**flowConventions** | [**FlowConventions**](FlowConventions.md) |  |  [optional]
**couponRate** | **java.math.BigDecimal** | Coupon rate given as a fraction. |  [optional]
**conventionName** | [**FlowConventionName**](FlowConventionName.md) |  |  [optional]
**notional** | **java.math.BigDecimal** | Scaling factor, the quantity outstanding on which the rate will be paid. |  [optional]
**paymentCurrency** | **String** | Payment currency. This does not have to be the same as the nominal bond or observation/reset currency. |  [optional]



