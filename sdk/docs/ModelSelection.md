

# ModelSelection

The combination of a library to use and a model in that library that defines which pricing code will evaluate instruments  having a particular type/class. This allows us to control the model type and library for a given instrument.
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**library** | [**LibraryEnum**](#LibraryEnum) | Which library is used for pricing requests | 
**model** | [**ModelEnum**](#ModelEnum) | Which model should be used for pricing requests | 



## Enum: LibraryEnum

Name | Value
---- | -----
LUSID | &quot;Lusid&quot;
REFINITIVQPS | &quot;RefinitivQps&quot;
REFINITIVTRACSWEB | &quot;RefinitivTracsWeb&quot;
VOLMASTER | &quot;VolMaster&quot;
ISDACDS | &quot;IsdaCds&quot;



## Enum: ModelEnum

Name | Value
---- | -----
SIMPLESTATIC | &quot;SimpleStatic&quot;
DISCOUNTING | &quot;Discounting&quot;
VENDORDEFAULT | &quot;VendorDefault&quot;
BLACKSCHOLES | &quot;BlackScholes&quot;



