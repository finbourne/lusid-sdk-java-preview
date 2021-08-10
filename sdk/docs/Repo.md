

# Repo

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**startDate** | [**OffsetDateTime**](OffsetDateTime.md) | The start date of the instrument. This is normally synonymous with the trade-date. | 
**maturityDate** | [**OffsetDateTime**](OffsetDateTime.md) | The final maturity date of the instrument. This means the last date on which the instruments makes a payment of any amount.  For the avoidance of doubt, that is not necessarily prior to its last sensitivity date for the purposes of risk; e.g. instruments such as  Constant Maturity Swaps (CMS) often have sensitivities to rates beyond their last payment date | 
**domCcy** | **String** | The domestic currency of the instrument. | 
**accrualBasis** | **String** | For calculation of interest, the accrual basis to be used.  Supported string (enumeration) values are: [Actual360, Act360, MoneyMarket, Actual365, Act365, Thirty360, ThirtyU360, Bond, ThirtyE360, EuroBond, ActualActual, ActAct, ActActIsda, ActActIsma, ActActIcma, OneOne, Act364, Act365F, Act365L, Act365_25, Act252, Bus252, NL360, NL365, Invalid]. | 
**collateralValue** | **Double** | The full value of the collateral in domCcy, before any margin (or haircut) is applied. | 
**margin** | **Double** | The margin (or haircut) applied to the collateral, this should be a number between 0 and 1, i.e. for a 5% haircut this should be 0.05. | 
**repoRate** | **Double** | the rate at which interest is to be accrue and be paid upon redemption of the collateral at maturity. | 



