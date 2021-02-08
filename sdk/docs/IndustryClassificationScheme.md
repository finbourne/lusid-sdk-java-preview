

# IndustryClassificationScheme

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**schemeName** | **String** | The type of the industry classification scheme (TRBC, GICs, ICB) | 
**schemeId** | **String** | Within the given scheme, the unique id that identifies this particular classification.  e.g. within \&quot;TRCS\&quot;, 5010202011 identifies \&quot;Oil Exploration \\amp; Production - Onshore\&quot; within the Energy, fossil-fuels and Oil hierarchy. | 
**economicSector** | **String** | Various schemes exist to classify the business sector within which a company operates.  They divide it into various categories around business, economic and sub-sectors (e.g. fossil fuels within energy)  Under ICB, TRBC, GICS which economic sector is the counterparty assigned to. This is Lvl 1 of that scheme (coarsest) | 
**businessSector** | **String** | Various schemes exist to classify the business sector within which a company operates.  They divide it into various categories around business, economic and sub-sectors (e.g. fossil fuels within energy)  Under ICB, TRBC, GICS which business sector is the counterparty assigned to. This is Lvl 2 of that scheme (2nd coarsest)  e.g. Fossil Fuels within energy. | 
**industry** | **String** | Various schemes exist to classify the business sector within which a company operates.  They divide it into various categories around business, economic and sub-sectors (e.g. coal within energy)  Under ICB, TRBC, GICS which business sector is the counterparty assigned to. This is Lvl 3 of that scheme (3rd coarsest)  e.g. Coal or Oil within Fossil Fuels. | 
**industryActivity** | **String** | Various schemes exist to classify the business sector within which a company operates.  They divide it into various categories around business, economic and sub-sectors (e.g. coal within energy)  Under ICB, TRBC, GICS which business sector is the counterparty assigned to. This is Lvl 4 of the scheme (finest)  e.g. Petroleum Refining within Oil within Fossil Fuels. | 



