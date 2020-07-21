

# CreateDerivedPropertyDefinitionRequest

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**domain** | [**DomainEnum**](#DomainEnum) | The domain that the property exists in. The available values are: NotDefined, Transaction, Portfolio, Holding, ReferenceHolding, TransactionConfiguration, Instrument, CutLabelDefinition, Analytic, PortfolioGroup, Person, AccessMetadata, Order, UnitResult, MarketData, ConfigurationRecipe, Allocation, Calendar | 
**scope** | **String** | The scope that the property exists in. | 
**code** | **String** | The code of the property. Together with the domain and scope this uniquely identifies the property. | 
**displayName** | **String** | The display name of the property. | 
**dataTypeId** | [**ResourceId**](ResourceId.md) |  | 
**derivation** | **String** | The string that contains the rule for the derived property. |  [optional]



## Enum: DomainEnum

Name | Value
---- | -----
NOTDEFINED | &quot;NotDefined&quot;
TRANSACTION | &quot;Transaction&quot;
PORTFOLIO | &quot;Portfolio&quot;
HOLDING | &quot;Holding&quot;
REFERENCEHOLDING | &quot;ReferenceHolding&quot;
TRANSACTIONCONFIGURATION | &quot;TransactionConfiguration&quot;
INSTRUMENT | &quot;Instrument&quot;
CUTLABELDEFINITION | &quot;CutLabelDefinition&quot;
ANALYTIC | &quot;Analytic&quot;
PORTFOLIOGROUP | &quot;PortfolioGroup&quot;
PERSON | &quot;Person&quot;
ACCESSMETADATA | &quot;AccessMetadata&quot;
ORDER | &quot;Order&quot;
UNITRESULT | &quot;UnitResult&quot;
MARKETDATA | &quot;MarketData&quot;
CONFIGURATIONRECIPE | &quot;ConfigurationRecipe&quot;
ALLOCATION | &quot;Allocation&quot;
CALENDAR | &quot;Calendar&quot;



