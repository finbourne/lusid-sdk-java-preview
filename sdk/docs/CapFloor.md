

# CapFloor

Interest rate Cap, Floor or Collar  Derivative instrument on an underlying interest rate index.  Cap Type: Buyer will receive payments at the end of each period when floating rate is above the CapStrike level.  Floor Type: Buyer will receive payments at the end of each period when floating rate is below the FloorStrike level.  Collar Type: Strategy of buying one Cap and selling one Floor where FloorStrike is less than CapStrike.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**capFloorType** | **String** | Determine if it&#39;s CAP, FLOOR, or COLLAR.  Supported string (enumeration) values are: [Cap, Floor, Collar]. | 
**capStrike** | **java.math.BigDecimal** | Strike rate of the Cap. | 
**floorStrike** | **java.math.BigDecimal** | Strike rate of the Floor. | 
**includeFirstCaplet** | **Boolean** | Include first caplet flag. | 
**underlyingFloatingLeg** | [**FloatingLeg**](FloatingLeg.md) |  | 



