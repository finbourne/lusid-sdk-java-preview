

# OrderGraphBlock


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**block** | [**Block**](Block.md) |  | 
**orderIds** | [**List&lt;ResourceId&gt;**](ResourceId.md) | Identifiers for all the orders in this block - DEPRECATED: see Ordered. | 
**placementIds** | [**List&lt;ResourceId&gt;**](ResourceId.md) | Identifiers of all placements for the block - DEPRECATED: see Placed. | 
**allocationIds** | [**List&lt;ResourceId&gt;**](ResourceId.md) | Identifiers for all allocations of placements to orders in the block - DEPRECATED: see Allocated. | 
**executionIds** | [**List&lt;ResourceId&gt;**](ResourceId.md) | Identifiers of all executions against placements in the block - DEPRECATED: see Executed. | 
**ordered** | [**OrderGraphBlockOrderSynopsis**](OrderGraphBlockOrderSynopsis.md) |  | 
**placed** | [**OrderGraphBlockPlacementSynopsis**](OrderGraphBlockPlacementSynopsis.md) |  | 
**executed** | [**OrderGraphBlockExecutionSynopsis**](OrderGraphBlockExecutionSynopsis.md) |  | 
**allocated** | [**OrderGraphBlockAllocationSynopsis**](OrderGraphBlockAllocationSynopsis.md) |  | 
**derivedState** | **String** | A simple description of the overall state of a block. | 
**derivedComplianceState** | **String** | The overall compliance state of a block, derived from the block&#39;s orders. Possible values are &#39;Pending&#39;, &#39;Failed&#39;, &#39;Manually approved&#39; and &#39;Passed&#39;. | 



