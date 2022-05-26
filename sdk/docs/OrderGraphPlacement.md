

# OrderGraphPlacement


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**placement** | [**Placement**](Placement.md) |  | 
**blockId** | [**ResourceId**](ResourceId.md) |  | 
**orderIds** | [**List&lt;ResourceId&gt;**](ResourceId.md) | Identifiers for all orders in the block - DEPRECATED: see Ordered. | 
**allocationIds** | [**List&lt;ResourceId&gt;**](ResourceId.md) | Identifiers for all allocations relating to this placement - DEPRECATED: see Allocated. | 
**executionIds** | [**List&lt;ResourceId&gt;**](ResourceId.md) | Identifiers of all executions against this placement - DEPRECATED: see Executed. | 
**ordered** | [**OrderGraphPlacementOrderSynopsis**](OrderGraphPlacementOrderSynopsis.md) |  | 
**placed** | [**OrderGraphPlacementPlacementSynopsis**](OrderGraphPlacementPlacementSynopsis.md) |  | 
**executed** | [**OrderGraphPlacementExecutionSynopsis**](OrderGraphPlacementExecutionSynopsis.md) |  | 
**allocated** | [**OrderGraphPlacementAllocationSynopsis**](OrderGraphPlacementAllocationSynopsis.md) |  | 
**derivedState** | **String** | A simple description of the overall state of a placement. | 
**calculatedAveragePrice** | **java.math.BigDecimal** | Average price realised on executions for a given placement |  [optional]



