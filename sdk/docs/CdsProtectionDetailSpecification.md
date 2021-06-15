

# CdsProtectionDetailSpecification

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**seniority** | [**SeniorityEnum**](#SeniorityEnum) | The available values are: Unknown, SNR, SUB, JRSUBUT2, PREFT1, SECDOM, SNRFOR, SUBLT2 | 
**restructuringType** | [**RestructuringTypeEnum**](#RestructuringTypeEnum) | The available values are: Unknown, CR, MR, MM, XR | 
**protectStartDay** | **Boolean** | Does the protection leg pay out in the case of default on the start date | 
**payAccruedInterestOnDefault** | **Boolean** | Should accrued interest on the premium leg be paid if a credit event occurs | 



## Enum: SeniorityEnum

Name | Value
---- | -----
UNKNOWN | &quot;Unknown&quot;
SNR | &quot;SNR&quot;
SUB | &quot;SUB&quot;
JRSUBUT2 | &quot;JRSUBUT2&quot;
PREFT1 | &quot;PREFT1&quot;
SECDOM | &quot;SECDOM&quot;
SNRFOR | &quot;SNRFOR&quot;
SUBLT2 | &quot;SUBLT2&quot;



## Enum: RestructuringTypeEnum

Name | Value
---- | -----
UNKNOWN | &quot;Unknown&quot;
CR | &quot;CR&quot;
MR | &quot;MR&quot;
MM | &quot;MM&quot;
XR | &quot;XR&quot;



