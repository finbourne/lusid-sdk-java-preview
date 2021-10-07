

# OrderGraphBlock


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**block** | [**Block**](Block.md) |  | 
**orderIds** | [**List&lt;ResourceId&gt;**](ResourceId.md) | Identifiers for all the orders in this block. | 
**placementIds** | [**List&lt;ResourceId&gt;**](ResourceId.md) | Identifiers of all placements for the block. | 
**allocationIds** | [**List&lt;ResourceId&gt;**](ResourceId.md) | Identifiers for all allocations of placements to orders in the block. | 
**executionIds** | [**List&lt;ResourceId&gt;**](ResourceId.md) | Identifiers of all executions against placements in the block. | 
**ordered** | **Double** | Total number of units of the instrument across all orders in the block. | 
**placed** | **Double** | Number of units of the instrument across all placements in the block. | 
**allocated** | **Double** | Number of units of the instrument across all allocations in the block. | 
**executed** | **Double** | How many of the quantity ordered for this block have been executed in the market. | 
**derivedState** | **String** | A simple description of the overall state of a block. | 



