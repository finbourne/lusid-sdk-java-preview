

# TransactionConfigurationMovementData


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**movementTypes** | [**MovementTypesEnum**](#MovementTypesEnum) | . The available values are: Settlement, Traded, StockMovement, FutureCash, Commitment, Receivable, CashSettlement, CashForward, CashCommitment, CashReceivable, Accrual, CashAccrual, ForwardFx, CashFxForward, UnsettledCashTypes, Carry, CarryAsPnl | 
**side** | **String** | The movement side | 
**direction** | **Integer** | The movement direction | 
**properties** | [**Map&lt;String, PerpetualProperty&gt;**](PerpetualProperty.md) | The properties associated with the underlying Movement. |  [optional]
**mappings** | [**List&lt;TransactionPropertyMapping&gt;**](TransactionPropertyMapping.md) | This allows you to map a transaction property to a property on the underlying holding. |  [optional]
**name** | **String** | The movement name (optional) |  [optional]



## Enum: MovementTypesEnum

Name | Value
---- | -----
SETTLEMENT | &quot;Settlement&quot;
TRADED | &quot;Traded&quot;
STOCKMOVEMENT | &quot;StockMovement&quot;
FUTURECASH | &quot;FutureCash&quot;
COMMITMENT | &quot;Commitment&quot;
RECEIVABLE | &quot;Receivable&quot;
CASHSETTLEMENT | &quot;CashSettlement&quot;
CASHFORWARD | &quot;CashForward&quot;
CASHCOMMITMENT | &quot;CashCommitment&quot;
CASHRECEIVABLE | &quot;CashReceivable&quot;
ACCRUAL | &quot;Accrual&quot;
CASHACCRUAL | &quot;CashAccrual&quot;
FORWARDFX | &quot;ForwardFx&quot;
CASHFXFORWARD | &quot;CashFxForward&quot;
UNSETTLEDCASHTYPES | &quot;UnsettledCashTypes&quot;
CARRY | &quot;Carry&quot;
CARRYASPNL | &quot;CarryAsPnl&quot;



