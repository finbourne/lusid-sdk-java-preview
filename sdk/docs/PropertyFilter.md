

# PropertyFilter

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**left** | **String** |  |  [optional]
**operator** | [**OperatorEnum**](#OperatorEnum) |  |  [optional]
**right** | [**Object**](.md) |  |  [optional]
**rightOperandType** | [**RightOperandTypeEnum**](#RightOperandTypeEnum) |  |  [optional]



## Enum: OperatorEnum

Name | Value
---- | -----
EQUALS | &quot;Equals&quot;
NOTEQUALS | &quot;NotEquals&quot;
GREATERTHAN | &quot;GreaterThan&quot;
GREATERTHANOREQUALTO | &quot;GreaterThanOrEqualTo&quot;
LESSTHAN | &quot;LessThan&quot;
LESSTHANOREQUALTO | &quot;LessThanOrEqualTo&quot;
IN | &quot;In&quot;



## Enum: RightOperandTypeEnum

Name | Value
---- | -----
ABSOLUTE | &quot;Absolute&quot;
PROPERTY | &quot;Property&quot;



