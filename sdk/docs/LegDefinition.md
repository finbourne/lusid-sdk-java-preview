

# LegDefinition

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**rateOrSpread** | **Double** | Is there either a fixed rate (non-zero) or spread to be paid over the value of the leg. |  [optional]
**indexConvention** | [**IndexConvention**](IndexConvention.md) |  |  [optional]
**stubType** | [**StubTypeEnum**](#StubTypeEnum) | The available values are: Front, Back, Both | 
**payReceive** | [**PayReceiveEnum**](#PayReceiveEnum) | The available values are: NotDefined, Pay, Receive | 
**notionalExchangeType** | [**NotionalExchangeTypeEnum**](#NotionalExchangeTypeEnum) | The available values are: None, Initial, Final, Both | 
**conventions** | [**FlowConventions**](FlowConventions.md) |  | 



## Enum: StubTypeEnum

Name | Value
---- | -----
FRONT | &quot;Front&quot;
BACK | &quot;Back&quot;
BOTH | &quot;Both&quot;



## Enum: PayReceiveEnum

Name | Value
---- | -----
NOTDEFINED | &quot;NotDefined&quot;
PAY | &quot;Pay&quot;
RECEIVE | &quot;Receive&quot;



## Enum: NotionalExchangeTypeEnum

Name | Value
---- | -----
NONE | &quot;None&quot;
INITIAL | &quot;Initial&quot;
FINAL | &quot;Final&quot;
BOTH | &quot;Both&quot;



