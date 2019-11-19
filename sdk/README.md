# lusid-sdk

LUSID API
- API version: 0.10.875

# Introduction  This page documents the [LUSID APIs](https://api.lusid.com/swagger), which allows authorised clients to query and update their data within the LUSID platform.  SDKs to interact with the LUSID APIs are available in the following languages :  * [C#](https://github.com/finbourne/lusid-sdk-csharp) * [Java](https://github.com/finbourne/lusid-sdk-java) * [JavaScript](https://github.com/finbourne/lusid-sdk-js) * [Python](https://github.com/finbourne/lusid-sdk-python)  # Data Model  The LUSID API has a relatively lightweight but extremely powerful data model. One of the goals of LUSID was not to enforce on clients a single rigid data model but rather to provide a flexible foundation onto which clients can map their own data models.  The core entities in LUSID provide a minimal structure and set of relationships, and the data model can be extended using Properties.  The LUSID data model is exposed through the LUSID APIs.  The APIs provide access to both business objects and the meta data used to configure the systems behaviours.   The key business entities are: - * **Portfolios** A portfolio is a container for transactions and holdings (a **Transaction Portfolio**) or constituents (a **Reference Portfolio**). * **Derived Portfolios**. Derived Portfolios allow Portfolios to be created based on other Portfolios, by overriding or adding specific items. * **Holdings** A Holding is a quantity of an Instrument or a balance of cash within a Portfolio.  Holdings can only be adjusted via Transactions. * **Transactions** A Transaction is an economic event that occurs in a Portfolio, causing its holdings to change. * **Corporate Actions** A corporate action is a market event which occurs to an Instrument and thus applies to all portfolios which holding the instrument.  Examples are stock splits or mergers. * **Constituents** A constituent is a record in a Reference Portfolio containing an Instrument and an associated weight. * **Instruments**  An instrument represents a currency, tradable instrument or OTC contract that is attached to a transaction and a holding. * **Properties** All major entities allow additional user defined properties to be associated with them.   For example, a Portfolio manager may be associated with a portfolio.  Meta data includes: - * **Transaction Types** Transactions are booked with a specific transaction type.  The types are client defined and are used to map the Transaction to a series of movements which update the portfolio holdings.  * **Properties Types** Types of user defined properties used within the system.  ## Scope  All data in LUSID is segregated at the client level.  Entities in LUSID are identifiable by a unique code.  Every entity lives within a logical data partition known as a Scope.  Scope is an identity namespace allowing two entities with the same unique code to co-exist within individual address spaces.  For example, prices for equities from different vendors may be uploaded into different scopes such as `client/vendor1` and `client/vendor2`.  A portfolio may then be valued using either of the price sources by referencing the appropriate scope.  LUSID Clients cannot access scopes of other clients.  ## Instruments  LUSID has its own built-in instrument master which you can use to master your own instrument universe.  Every instrument must be created with one or more unique market identifiers, such as [FIGI](https://openfigi.com/). For any non-listed instruments (eg OTCs), you can upload an instrument against a custom ID of your choosing.  In addition, LUSID will allocate each instrument a unique 'LUSID instrument identifier'. The LUSID instrument identifier is what is used when uploading transactions, holdings, prices, etc. The API exposes an `instrument/lookup` endpoint which can be used to lookup these LUSID identifiers using their market identifiers.  Cash can be referenced using the ISO currency code prefixed with \"`CCY_`\" e.g. `CCY_GBP`  ## Instrument Data  Instrument data can be uploaded to the system using the [Instrument Properties](#tag/InstrumentProperties) endpoint.  | Field|Type|Description | | ---|---|--- | | Key|propertykey|The key of the property. This takes the format {domain}/{scope}/{code} e.g. 'Instrument/system/Name' or 'Transaction/strategy/quantsignal'. | | Value|string|The value of the property. | | EffectiveFrom|datetimeoffset|The effective datetime from which the property is valid. |   ## Transaction Portfolios  Portfolios are the top-level entity containers within LUSID, containing transactions, corporate actions and holdings.    The transactions build up the portfolio holdings on which valuations, analytics profit & loss and risk can be calculated.  Properties can be associated with Portfolios to add in additional data.  Portfolio properties can be changed over time, for example to allow a Portfolio Manager to be linked with a Portfolio.  Additionally, portfolios can be securitised and held by other portfolios, allowing LUSID to perform \"drill-through\" into underlying fund holdings  ### Derived Portfolios  LUSID also allows for a portfolio to be composed of another portfolio via derived portfolios.  A derived portfolio can contain its own transactions and also inherits any transactions from its parent portfolio.  Any changes made to the parent portfolio are automatically reflected in derived portfolio.  Derived portfolios in conjunction with scopes are a powerful construct.  For example, to do pre-trade what-if analysis, a derived portfolio could be created a new namespace linked to the underlying live (parent) portfolio.  Analysis can then be undertaken on the derived portfolio without affecting the live portfolio.  ### Transactions  A transaction represents an economic activity against a Portfolio.  Transactions are processed according to a configuration. This will tell the LUSID engine how to interpret the transaction and correctly update the holdings. LUSID comes with a set of transaction types you can use out of the box, or you can configure your own set(s) of transactions.  For more details see the [LUSID Getting Started Guide for transaction configuration.](https://support.lusid.com/configuring-transaction-types)  | Field|Type|Description | | ---|---|--- | | TransactionId|string|The unique identifier for the transaction. | | Type|string|The type of the transaction e.g. 'Buy', 'Sell'. The transaction type should have been pre-configured via the System Configuration API endpoint. If it hasn't been pre-configured the transaction will still be updated or inserted however you will be unable to generate the resultant holdings for the portfolio that contains this transaction as LUSID does not know how to process it. | | InstrumentIdentifiers|map|A set of instrument identifiers to use to resolve the transaction to a unique instrument. | | TransactionDate|dateorcutlabel|The date of the transaction. | | SettlementDate|dateorcutlabel|The settlement date of the transaction. | | Units|decimal|The number of units transacted in the associated instrument. | | TransactionPrice|transactionprice|The price for each unit of the transacted instrument in the transaction currency. | | TotalConsideration|currencyandamount|The total value of the transaction in the settlement currency. | | ExchangeRate|decimal|The exchange rate between the transaction and settlement currency. For example if the transaction currency is in USD and the settlement currency is in GBP this this the USD/GBP rate. | | TransactionCurrency|currency|The transaction currency. | | Properties|map|Set of unique transaction properties and associated values to store with the transaction. Each property must be from the 'Transaction' domain. | | CounterpartyId|string|The identifier for the counterparty of the transaction. | | Source|string|The source of the transaction. This is used to look up the appropriate transaction group set in the transaction type configuration. |   From these fields, the following values can be calculated  * **Transaction value in Transaction currency**: TotalConsideration / ExchangeRate  * **Transaction value in Portfolio currency**: Transaction value in Transaction currency * TradeToPortfolioRate  #### Example Transactions  ##### A Common Purchase Example Three example transactions are shown in the table below.   They represent a purchase of USD denominated IBM shares within a Sterling denominated portfolio.   * The first two transactions are for separate buy and fx trades    * Buying 500 IBM shares for $71,480.00    * A foreign exchange conversion to fund the IBM purchase. (Buy $71,480.00 for &#163;54,846.60)  * The third transaction is an alternate version of the above trades. Buying 500 IBM shares and settling directly in Sterling.  | Column |  Buy Trade | Fx Trade | Buy Trade with foreign Settlement | | ----- | ----- | ----- | ----- | | TransactionId | FBN00001 | FBN00002 | FBN00003 | | Type | Buy | FxBuy | Buy | | InstrumentIdentifiers | { \"figi\", \"BBG000BLNNH6\" } | { \"CCY\", \"CCY_USD\" } | { \"figi\", \"BBG000BLNNH6\" } | | TransactionDate | 2018-08-02 | 2018-08-02 | 2018-08-02 | | SettlementDate | 2018-08-06 | 2018-08-06 | 2018-08-06 | | Units | 500 | 71480 | 500 | | TransactionPrice | 142.96 | 1 | 142.96 | | TradeCurrency | USD | USD | USD | | ExchangeRate | 1 | 0.7673 | 0.7673 | | TotalConsideration.Amount | 71480.00 | 54846.60 | 54846.60 | | TotalConsideration.Currency | USD | GBP | GBP | | Trade/default/TradeToPortfolioRate&ast; | 0.7673 | 0.7673 | 0.7673 |  [&ast; This is a property field]  ##### A Forward FX Example  LUSID has a flexible transaction modelling system, and there are a number of different ways of modelling forward fx trades.  The default LUSID transaction types are FwdFxBuy and FwdFxSell. Other types and behaviours can be configured as required.  Using these transaction types, the holdings query will report two forward positions. One in each currency.   Since an FX trade is an exchange of one currency for another, the following two 6 month forward transactions are equivalent:  | Column |  Forward 'Sell' Trade | Forward 'Buy' Trade | | ----- | ----- | ----- | | TransactionId | FBN00004 | FBN00005 | | Type | FwdFxSell | FwdFxBuy | | InstrumentIdentifiers | { \"CCY\", \"CCY_GBP\" } | { \"CCY\", \"CCY_USD\" } | | TransactionDate | 2018-08-02 | 2018-08-02 | | SettlementDate | 2019-02-06 | 2019-02-06 | | Units | 10000.00 | 13142.00 | | TransactionPrice |1 | 1 | | TradeCurrency | GBP | USD | | ExchangeRate | 1.3142 | 0.760919 | | TotalConsideration.Amount | 13142.00 | 10000.00 | | TotalConsideration.Currency | USD | GBP | | Trade/default/TradeToPortfolioRate | 1.0 | 0.760919 |  ### Holdings  A holding represents a position in an instrument or cash on a given date.  | Field|Type|Description | | ---|---|--- | | InstrumentUid|string|The unqiue Lusid Instrument Id (LUID) of the instrument that the holding is in. | | SubHoldingKeys|map|The sub-holding properties which identify the holding. Each property will be from the 'Transaction' domain. These are configured when a transaction portfolio is created. | | Properties|map|The properties which have been requested to be decorated onto the holding. These will be from the 'Instrument' or 'Holding' domain. | | HoldingType|string|The type of the holding e.g. Position, Balance, CashCommitment, Receivable, ForwardFX etc. | | Units|decimal|The total number of units of the holding. | | SettledUnits|decimal|The total number of settled units of the holding. | | Cost|currencyandamount|The total cost of the holding in the transaction currency. | | CostPortfolioCcy|currencyandamount|The total cost of the holding in the portfolio currency. | | Transaction|transaction|The transaction associated with an unsettled holding. |   ## Corporate Actions  Corporate actions are represented within LUSID in terms of a set of instrument-specific 'transitions'.  These transitions are used to specify the participants of the corporate action, and the effect that the corporate action will have on holdings in those participants.  ### Corporate Action  | Field|Type|Description | | ---|---|--- | | CorporateActionCode|code|The unique identifier of this corporate action | | Description|string|  | | AnnouncementDate|datetimeoffset|The announcement date of the corporate action | | ExDate|datetimeoffset|The ex date of the corporate action | | RecordDate|datetimeoffset|The record date of the corporate action | | PaymentDate|datetimeoffset|The payment date of the corporate action | | Transitions|corporateactiontransition[]|The transitions that result from this corporate action |   ### Transition | Field|Type|Description | | ---|---|--- | | InputTransition|corporateactiontransitioncomponent|Indicating the basis of the corporate action - which security and how many units | | OutputTransitions|corporateactiontransitioncomponent[]|What will be generated relative to the input transition |   ### Example Corporate Action Transitions  #### A Dividend Action Transition  In this example, for each share of IBM, 0.20 units (or 20 pence) of GBP are generated.  | Column |  Input Transition | Output Transition | | ----- | ----- | ----- | | Instrument Identifiers | { \"figi\" : \"BBG000BLNNH6\" } | { \"ccy\" : \"CCY_GBP\" } | | Units Factor | 1 | 0.20 | | Cost Factor | 1 | 0 |  #### A Split Action Transition  In this example, for each share of IBM, we end up with 2 units (2 shares) of IBM, with total value unchanged.  | Column |  Input Transition | Output Transition | | ----- | ----- | ----- | | Instrument Identifiers | { \"figi\" : \"BBG000BLNNH6\" } | { \"figi\" : \"BBG000BLNNH6\" } | | Units Factor | 1 | 2 | | Cost Factor | 1 | 1 |  #### A Spinoff Action Transition  In this example, for each share of IBM, we end up with 1 unit (1 share) of IBM and 3 units (3 shares) of Celestica, with 85% of the value remaining on the IBM share, and 5% in each Celestica share (15% total).  | Column |  Input Transition | Output Transition 1 | Output Transition 2 | | ----- | ----- | ----- | ----- | | Instrument Identifiers | { \"figi\" : \"BBG000BLNNH6\" } | { \"figi\" : \"BBG000BLNNH6\" } | { \"figi\" : \"BBG000HBGRF3\" } | | Units Factor | 1 | 1 | 3 | | Cost Factor | 1 | 0.85 | 0.15 |  ## Reference Portfolios Reference portfolios are portfolios that contain constituents with weights.  They are designed to represent entities such as indices and benchmarks.  ### Constituents | Field|Type|Description | | ---|---|--- | | InstrumentIdentifiers|map|Unique instrument identifiers | | InstrumentUid|string|LUSID's internal unique instrument identifier, resolved from the instrument identifiers | | Currency|decimal|  | | Weight|decimal|  | | FloatingWeight|decimal|  |   ## Portfolio Groups Portfolio groups allow the construction of a hierarchy from portfolios and groups.  Portfolio operations on the group are executed on an aggregated set of portfolios in the hierarchy.   For example:   * Global Portfolios _(group)_   * APAC _(group)_     * Hong Kong _(portfolio)_     * Japan _(portfolio)_   * Europe _(group)_     * France _(portfolio)_     * Germany _(portfolio)_   * UK _(portfolio)_   In this example **Global Portfolios** is a group that consists of an aggregate of **Hong Kong**, **Japan**, **France**, **Germany** and **UK** portfolios.  ## Properties  Properties are key-value pairs that can be applied to any entity within a domain (where a domain is `trade`, `portfolio`, `security` etc).  Properties must be defined before use with a `PropertyDefinition` and can then subsequently be added to entities.   ## Schema  A detailed description of the entities used by the API and parameters for endpoints which take a JSON document can be retrieved via the `schema` endpoint.  ## Meta data  The following headers are returned on all responses from LUSID  | Name | Purpose | | --- | --- | | lusid-meta-duration | Duration of the request | | lusid-meta-success | Whether or not LUSID considered the request to be successful | | lusid-meta-requestId | The unique identifier for the request | | lusid-schema-url | Url of the schema for the data being returned | | lusid-property-schema-url | Url of the schema for any properties |   # Error Codes  | Code|Name|Description | | ---|---|--- | | <a name=\"102\">102</a>|VersionNotFound|  | | <a name=\"103\">103</a>|ApiRateLimitViolation|  | | <a name=\"104\">104</a>|InstrumentNotFound|  | | <a name=\"105\">105</a>|PropertyNotFound|  | | <a name=\"106\">106</a>|PortfolioRecursionDepth|  | | <a name=\"108\">108</a>|GroupNotFound|  | | <a name=\"109\">109</a>|PortfolioNotFound|  | | <a name=\"110\">110</a>|PropertySchemaNotFound|  | | <a name=\"111\">111</a>|PortfolioAncestryNotFound|  | | <a name=\"112\">112</a>|PortfolioWithIdAlreadyExists|  | | <a name=\"113\">113</a>|OrphanedPortfolio|  | | <a name=\"119\">119</a>|MissingBaseClaims|  | | <a name=\"121\">121</a>|PropertyNotDefined|  | | <a name=\"122\">122</a>|CannotDeleteSystemProperty|  | | <a name=\"123\">123</a>|CannotModifyImmutablePropertyField|  | | <a name=\"124\">124</a>|PropertyAlreadyExists|  | | <a name=\"125\">125</a>|InvalidPropertyLifeTime|  | | <a name=\"125\">125</a>|InvalidPropertyLifeTime|  | | <a name=\"127\">127</a>|CannotModifyDefaultDataType|  | | <a name=\"128\">128</a>|GroupAlreadyExists|  | | <a name=\"129\">129</a>|NoSuchDataType|  | | <a name=\"130\">130</a>|UndefinedValueForDataType|  | | <a name=\"131\">131</a>|UnsupportedValueTypeDefinedOnDataType|  | | <a name=\"132\">132</a>|ValidationError|  | | <a name=\"133\">133</a>|LoopDetectedInGroupHierarchy|  | | <a name=\"134\">134</a>|UndefinedAcceptableValues|  | | <a name=\"135\">135</a>|SubGroupAlreadyExists|  | | <a name=\"138\">138</a>|PriceSourceNotFound|  | | <a name=\"139\">139</a>|AnalyticStoreNotFound|  | | <a name=\"141\">141</a>|AnalyticStoreAlreadyExists|  | | <a name=\"143\">143</a>|ClientInstrumentAlreadyExists|  | | <a name=\"144\">144</a>|DuplicateInParameterSet|  | | <a name=\"147\">147</a>|ResultsNotFound|  | | <a name=\"148\">148</a>|OrderFieldNotInResultSet|  | | <a name=\"149\">149</a>|OperationFailed|  | | <a name=\"150\">150</a>|ElasticSearchError|  | | <a name=\"151\">151</a>|InvalidParameterValue|  | | <a name=\"153\">153</a>|CommandProcessingFailure|  | | <a name=\"154\">154</a>|EntityStateConstructionFailure|  | | <a name=\"155\">155</a>|EntityTimelineDoesNotExist|  | | <a name=\"156\">156</a>|EventPublishFailure|  | | <a name=\"157\">157</a>|InvalidRequestFailure|  | | <a name=\"158\">158</a>|EventPublishUnknown|  | | <a name=\"159\">159</a>|EventQueryFailure|  | | <a name=\"160\">160</a>|BlobDidNotExistFailure|  | | <a name=\"162\">162</a>|SubSystemRequestFailure|  | | <a name=\"163\">163</a>|SubSystemConfigurationFailure|  | | <a name=\"165\">165</a>|FailedToDelete|  | | <a name=\"166\">166</a>|UpsertClientInstrumentFailure|  | | <a name=\"167\">167</a>|IllegalAsAtInterval|  | | <a name=\"168\">168</a>|IllegalBitemporalQuery|  | | <a name=\"169\">169</a>|InvalidAlternateId|  | | <a name=\"170\">170</a>|CannotAddSourcePortfolioPropertyExplicitly|  | | <a name=\"171\">171</a>|EntityAlreadyExistsInGroup|  | | <a name=\"173\">173</a>|EntityWithIdAlreadyExists|  | | <a name=\"174\">174</a>|DerivedPortfolioDetailsDoNotExist|  | | <a name=\"176\">176</a>|PortfolioWithNameAlreadyExists|  | | <a name=\"177\">177</a>|InvalidTransactions|  | | <a name=\"178\">178</a>|ReferencePortfolioNotFound|  | | <a name=\"179\">179</a>|DuplicateIdFailure|  | | <a name=\"180\">180</a>|CommandRetrievalFailure|  | | <a name=\"181\">181</a>|DataFilterApplicationFailure|  | | <a name=\"182\">182</a>|SearchFailed|  | | <a name=\"183\">183</a>|MovementsEngineConfigurationKeyFailure|  | | <a name=\"184\">184</a>|FxRateSourceNotFound|  | | <a name=\"185\">185</a>|AccrualSourceNotFound|  | | <a name=\"186\">186</a>|AccessDenied|  | | <a name=\"187\">187</a>|InvalidIdentityToken|  | | <a name=\"188\">188</a>|InvalidRequestHeaders|  | | <a name=\"189\">189</a>|PriceNotFound|  | | <a name=\"190\">190</a>|InvalidSubHoldingKeysProvided|  | | <a name=\"191\">191</a>|DuplicateSubHoldingKeysProvided|  | | <a name=\"192\">192</a>|CutDefinitionNotFound|  | | <a name=\"193\">193</a>|CutDefinitionInvalid|  | | <a name=\"194\">194</a>|TimeVariantPropertyDeletionDateUnspecified|  | | <a name=\"195\">195</a>|PerpetualPropertyDeletionDateSpecified|  | | <a name=\"196\">196</a>|TimeVariantPropertyUpsertDateUnspecified|  | | <a name=\"197\">197</a>|PerpetualPropertyUpsertDateSpecified|  | | <a name=\"200\">200</a>|InvalidUnitForDataType|  | | <a name=\"201\">201</a>|InvalidTypeForDataType|  | | <a name=\"202\">202</a>|InvalidValueForDataType|  | | <a name=\"203\">203</a>|UnitNotDefinedForDataType|  | | <a name=\"204\">204</a>|UnitsNotSupportedOnDataType|  | | <a name=\"205\">205</a>|CannotSpecifyUnitsOnDataType|  | | <a name=\"206\">206</a>|UnitSchemaInconsistentWithDataType|  | | <a name=\"207\">207</a>|UnitDefinitionNotSpecified|  | | <a name=\"208\">208</a>|DuplicateUnitDefinitionsSpecified|  | | <a name=\"209\">209</a>|InvalidUnitsDefinition|  | | <a name=\"210\">210</a>|InvalidInstrumentIdentifierUnit|  | | <a name=\"211\">211</a>|HoldingsAdjustmentDoesNotExist|  | | <a name=\"212\">212</a>|CouldNotBuildExcelUrl|  | | <a name=\"213\">213</a>|CouldNotGetExcelVersion|  | | <a name=\"214\">214</a>|InstrumentByCodeNotFound|  | | <a name=\"215\">215</a>|EntitySchemaDoesNotExist|  | | <a name=\"216\">216</a>|FeatureNotSupportedOnPortfolioType|  | | <a name=\"217\">217</a>|QuoteNotFoundFailure|  | | <a name=\"218\">218</a>|InvalidQuoteIdentifierFailure|  | | <a name=\"219\">219</a>|InvalidInstrumentDefinition|  | | <a name=\"219\">219</a>|InvalidInstrumentDefinition|  | | <a name=\"221\">221</a>|InstrumentUpsertFailure|  | | <a name=\"222\">222</a>|ReferencePortfolioRequestNotSupported|  | | <a name=\"223\">223</a>|TransactionPortfolioRequestNotSupported|  | | <a name=\"224\">224</a>|InvalidPropertyValueAssignment|  | | <a name=\"230\">230</a>|TransactionTypeNotFound|  | | <a name=\"231\">231</a>|TransactionTypeDuplication|  | | <a name=\"232\">232</a>|PortfolioDoesNotExistAtGivenDate|  | | <a name=\"233\">233</a>|QueryParserFailure|  | | <a name=\"234\">234</a>|DuplicateConstituentFailure|  | | <a name=\"235\">235</a>|UnresolvedInstrumentConstituentFailure|  | | <a name=\"236\">236</a>|UnresolvedInstrumentInTransitionFailure|  | | <a name=\"237\">237</a>|MissingSideDefinitionsFailure|  | | <a name=\"300\">300</a>|MissingRecipeFailure|  | | <a name=\"301\">301</a>|DependenciesFailure|  | | <a name=\"304\">304</a>|PortfolioPreprocessFailure|  | | <a name=\"310\">310</a>|ValuationEngineFailure|  | | <a name=\"311\">311</a>|TaskFactoryFailure|  | | <a name=\"312\">312</a>|TaskEvaluationFailure|  | | <a name=\"350\">350</a>|InstrumentFailure|  | | <a name=\"351\">351</a>|CashFlowsFailure|  | | <a name=\"360\">360</a>|AggregationFailure|  | | <a name=\"370\">370</a>|ResultRetrievalFailure|  | | <a name=\"371\">371</a>|ResultProcessingFailure|  | | <a name=\"371\">371</a>|ResultProcessingFailure|  | | <a name=\"372\">372</a>|VendorResultProcessingFailure|  | | <a name=\"373\">373</a>|VendorResultMappingFailure|  | | <a name=\"374\">374</a>|VendorLibraryUnauthorisedFailure|  | | <a name=\"375\">375</a>|VendorConnectivityError|  | | <a name=\"376\">376</a>|VendorInterfaceError|  | | <a name=\"390\">390</a>|AttemptToUpsertDuplicateQuotes|  | | <a name=\"391\">391</a>|CorporateActionSourceDoesNotExist|  | | <a name=\"392\">392</a>|CorporateActionSourceAlreadyExists|  | | <a name=\"393\">393</a>|InstrumentIdentifierAlreadyInUse|  | | <a name=\"394\">394</a>|PropertiesNotFound|  | | <a name=\"395\">395</a>|BatchOperationAborted|  | | <a name=\"400\">400</a>|InvalidIso4217CurrencyCodeFailure|  | | <a name=\"401\">401</a>|CannotAssignInstrumentIdentifierToCurrencyFailure|  | | <a name=\"402\">402</a>|CannotAssignCurrencyIdentifierToNonCurrency|  | | <a name=\"403\">403</a>|CurrencyInstrumentCannotBeDeleted|  | | <a name=\"404\">404</a>|CurrencyInstrumentCannotHaveEconomicDefinition|  | | <a name=\"405\">405</a>|CurrencyInstrumentCannotHaveLookthroughPortfolio|  | | <a name=\"406\">406</a>|CannotCreateCurrencyInstrumentWithMultipleIdentifiers|  | | <a name=\"410\">410</a>|IndexDoesNotExist|  | | <a name=\"411\">411</a>|SortFieldDoesNotExist|  | | <a name=\"413\">413</a>|NegativePaginationParameters|  | | <a name=\"414\">414</a>|InvalidSearchSyntax|  | | <a name=\"420\">420</a>|SideDefinitionInconsistent|  | | <a name=\"601\">601</a>|PersonIdentifierAlreadyInUse|  | | <a name=\"602\">602</a>|PersonNotFound|  | | <a name=\"603\">603</a>|CannotSetIdentifier|  | | <a name=\"-10\">-10</a>|ServerConfigurationError|  | | <a name=\"-1\">-1</a>|Unknown error|  | 

  For more information, please visit [https://www.finbourne.com](https://www.finbourne.com)

*Automatically generated by the [OpenAPI Generator](https://openapi-generator.tech)*


## Requirements

Building the API client library requires:
1. Java 1.8+
2. Maven/Gradle

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```

Refer to the [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>com.finbourne</groupId>
  <artifactId>lusid-sdk</artifactId>
  <version>0.10.875</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "com.finbourne:lusid-sdk:0.10.875"
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/lusid-sdk-0.10.875.jar`
* `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

// Import classes:
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.auth.*;
import com.finbourne.lusid.models.*;
import com.finbourne.lusid.api.AggregationApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost/api");
    
    // Configure OAuth2 access token for authorization: oauth2
    OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
    oauth2.setAccessToken("YOUR ACCESS TOKEN");

    AggregationApi apiInstance = new AggregationApi(defaultClient);
    String scope = "scope_example"; // String | The scope of the portfolio group
    String code = "code_example"; // String | The code of the portfolio group
    List<String> sortBy = Arrays.asList(); // List<String> | Optional. Order the results by these fields. Use use the '-' sign to denote descending order e.g. -MyFieldName
    Integer start = 56; // Integer | Optional. When paginating, skip this number of results
    Integer limit = 56; // Integer | Optional. When paginating, limit the number of returned results to this many.
    AggregationRequest request = new AggregationRequest(); // AggregationRequest | The request specifying the parameters of the aggregation
    try {
      ListAggregationResponse result = apiInstance.getAggregationByGroup(scope, code, sortBy, start, limit, request);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AggregationApi#getAggregationByGroup");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

## Documentation for API Endpoints

All URIs are relative to *http://localhost/api*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*AggregationApi* | [**getAggregationByGroup**](docs/AggregationApi.md#getAggregationByGroup) | **POST** /api/portfoliogroups/{scope}/{code}/$aggregate | [EXPERIMENTAL] Aggregate data in a portfolio group
*AggregationApi* | [**getAggregationByPortfolio**](docs/AggregationApi.md#getAggregationByPortfolio) | **POST** /api/portfolios/{scope}/{code}/$aggregate | [EXPERIMENTAL] Aggregate data in a portfolio
*AggregationApi* | [**getAggregationByResultSet**](docs/AggregationApi.md#getAggregationByResultSet) | **POST** /api/results/{scope}/{resultsKey}/$aggregate | [EXPERIMENTAL] Aggregate using result data
*AggregationApi* | [**getAggregationOfWeightedInstruments**](docs/AggregationApi.md#getAggregationOfWeightedInstruments) | **POST** /api/portfolios/{scope}/$aggregateinlined | [EXPERIMENTAL] Aggregate data in an inlined portfolio
*AggregationApi* | [**getNestedAggregationByGroup**](docs/AggregationApi.md#getNestedAggregationByGroup) | **POST** /api/portfoliogroups/{scope}/{code}/$aggregatenested | [EXPERIMENTAL] Aggregate data in a portfolio group, as nested
*ApplicationMetadataApi* | [**getExcelAddin**](docs/ApplicationMetadataApi.md#getExcelAddin) | **GET** /api/metadata/downloads/exceladdin | [EARLY ACCESS] Download Excel Addin
*ApplicationMetadataApi* | [**getLusidVersions**](docs/ApplicationMetadataApi.md#getLusidVersions) | **GET** /api/metadata/versions | [EARLY ACCESS] Get LUSID versions
*ApplicationMetadataApi* | [**listAccessControlledResources**](docs/ApplicationMetadataApi.md#listAccessControlledResources) | **GET** /api/metadata/access/resources | [EARLY ACCESS] Get resources available for access control
*ConfigurationRecipeApi* | [**deleteConfigurationRecipe**](docs/ConfigurationRecipeApi.md#deleteConfigurationRecipe) | **DELETE** /api/recipes/{scope}/{code} | [EXPERIMENTAL] Delete a Configuration Recipe, assuming that it is present.
*ConfigurationRecipeApi* | [**getConfigurationRecipe**](docs/ConfigurationRecipeApi.md#getConfigurationRecipe) | **GET** /api/recipes/{scope}/{code} | [EXPERIMENTAL] Get Configuration Recipe
*ConfigurationRecipeApi* | [**upsertConfigurationRecipe**](docs/ConfigurationRecipeApi.md#upsertConfigurationRecipe) | **POST** /api/recipes/{scope} | [EXPERIMENTAL] Upsert a Configuration Recipe. This creates or updates the data in Lusid.
*CorporateActionSourcesApi* | [**batchUpsertCorporateActions**](docs/CorporateActionSourcesApi.md#batchUpsertCorporateActions) | **POST** /api/corporateactionsources/{scope}/{code}/corporateactions | [BETA] Upsert corporate actions
*CorporateActionSourcesApi* | [**createCorporateActionSource**](docs/CorporateActionSourcesApi.md#createCorporateActionSource) | **POST** /api/corporateactionsources | [BETA] Create Corporate Action Source
*CorporateActionSourcesApi* | [**deleteCorporateActionSource**](docs/CorporateActionSourcesApi.md#deleteCorporateActionSource) | **DELETE** /api/corporateactionsources/{scope}/{code} | [BETA] Delete a corporate action source
*CorporateActionSourcesApi* | [**getCorporateActions**](docs/CorporateActionSourcesApi.md#getCorporateActions) | **GET** /api/corporateactionsources/{scope}/{code}/corporateactions | [BETA] Get corporate actions
*CorporateActionSourcesApi* | [**listCorporateActionSources**](docs/CorporateActionSourcesApi.md#listCorporateActionSources) | **GET** /api/corporateactionsources | [BETA] Get corporate action sources
*CutLabelDefinitionsApi* | [**createCutLabelDefinition**](docs/CutLabelDefinitionsApi.md#createCutLabelDefinition) | **POST** /api/systemconfiguration/cutlabels | [EARLY ACCESS] Create a Cut Label
*CutLabelDefinitionsApi* | [**deleteCutLabelDefinition**](docs/CutLabelDefinitionsApi.md#deleteCutLabelDefinition) | **DELETE** /api/systemconfiguration/cutlabels/{code} | [EARLY ACCESS] Delete a Cut Label
*CutLabelDefinitionsApi* | [**getCutLabelDefinition**](docs/CutLabelDefinitionsApi.md#getCutLabelDefinition) | **GET** /api/systemconfiguration/cutlabels/{code} | [EARLY ACCESS] Get a Cut Label
*CutLabelDefinitionsApi* | [**listCutLabelDefinitions**](docs/CutLabelDefinitionsApi.md#listCutLabelDefinitions) | **GET** /api/systemconfiguration/cutlabels | [EARLY ACCESS] List Existing Cut Labels
*CutLabelDefinitionsApi* | [**updateCutLabelDefinition**](docs/CutLabelDefinitionsApi.md#updateCutLabelDefinition) | **PUT** /api/systemconfiguration/cutlabels/{code} | [EARLY ACCESS] Update a Cut Label
*DataTypesApi* | [**createDataType**](docs/DataTypesApi.md#createDataType) | **POST** /api/datatypes | [BETA] Create data type definition
*DataTypesApi* | [**getDataType**](docs/DataTypesApi.md#getDataType) | **GET** /api/datatypes/{scope}/{code} | [EARLY ACCESS] Get data type definition
*DataTypesApi* | [**getUnitsFromDataType**](docs/DataTypesApi.md#getUnitsFromDataType) | **GET** /api/datatypes/{scope}/{code}/units | [EARLY ACCESS] Get units from data type
*DataTypesApi* | [**listDataTypes**](docs/DataTypesApi.md#listDataTypes) | **GET** /api/datatypes/{scope} | [EARLY ACCESS] List data types
*DataTypesApi* | [**updateDataType**](docs/DataTypesApi.md#updateDataType) | **PUT** /api/datatypes/{scope}/{code} | [BETA] Update data type definition
*DerivedTransactionPortfoliosApi* | [**createDerivedPortfolio**](docs/DerivedTransactionPortfoliosApi.md#createDerivedPortfolio) | **POST** /api/derivedtransactionportfolios/{scope} | [EARLY ACCESS] Create derived transaction portfolio
*DerivedTransactionPortfoliosApi* | [**deleteDerivedPortfolioDetails**](docs/DerivedTransactionPortfoliosApi.md#deleteDerivedPortfolioDetails) | **DELETE** /api/derivedtransactionportfolios/{scope}/{code}/details | [EARLY ACCESS] Delete portfolio details
*EntitiesApi* | [**getPortfolioChanges**](docs/EntitiesApi.md#getPortfolioChanges) | **GET** /api/entities/changes/portfolios | [BETA] Get the next change to each portfolio in a scope.
*InstrumentsApi* | [**deleteInstrument**](docs/InstrumentsApi.md#deleteInstrument) | **DELETE** /api/instruments/{identifierType}/{identifier} | [EARLY ACCESS] Delete instrument
*InstrumentsApi* | [**deleteInstrumentProperties**](docs/InstrumentsApi.md#deleteInstrumentProperties) | **POST** /api/instruments/{identifierType}/{identifier}/properties/$delete | [EXPERIMENTAL] Delete properties from an instrument
*InstrumentsApi* | [**getInstrument**](docs/InstrumentsApi.md#getInstrument) | **GET** /api/instruments/{identifierType}/{identifier} | Get instrument
*InstrumentsApi* | [**getInstrumentIdentifierTypes**](docs/InstrumentsApi.md#getInstrumentIdentifierTypes) | **GET** /api/instruments/identifierTypes | [EARLY ACCESS] Get instrument identifier types
*InstrumentsApi* | [**getInstruments**](docs/InstrumentsApi.md#getInstruments) | **POST** /api/instruments/$get | Get instruments
*InstrumentsApi* | [**listInstruments**](docs/InstrumentsApi.md#listInstruments) | **GET** /api/instruments | [EARLY ACCESS] List instruments
*InstrumentsApi* | [**updateInstrumentIdentifier**](docs/InstrumentsApi.md#updateInstrumentIdentifier) | **POST** /api/instruments/{identifierType}/{identifier} | [EARLY ACCESS] Update instrument identifier
*InstrumentsApi* | [**upsertInstruments**](docs/InstrumentsApi.md#upsertInstruments) | **POST** /api/instruments | Upsert instruments
*InstrumentsApi* | [**upsertInstrumentsProperties**](docs/InstrumentsApi.md#upsertInstrumentsProperties) | **POST** /api/instruments/$upsertproperties | Upsert instruments properties
*LoginApi* | [**getSamlIdentityProviderId**](docs/LoginApi.md#getSamlIdentityProviderId) | **GET** /api/login/saml/{domain} | Get SAML Identity Provider
*PortfolioGroupsApi* | [**addPortfolioToGroup**](docs/PortfolioGroupsApi.md#addPortfolioToGroup) | **POST** /api/portfoliogroups/{scope}/{code}/portfolios | [EARLY ACCESS] Add portfolio to group
*PortfolioGroupsApi* | [**addSubGroupToGroup**](docs/PortfolioGroupsApi.md#addSubGroupToGroup) | **POST** /api/portfoliogroups/{scope}/{code}/subgroups | [EARLY ACCESS] Add sub group to group
*PortfolioGroupsApi* | [**createPortfolioGroup**](docs/PortfolioGroupsApi.md#createPortfolioGroup) | **POST** /api/portfoliogroups/{scope} | [EARLY ACCESS] Create portfolio group
*PortfolioGroupsApi* | [**deleteGroupProperties**](docs/PortfolioGroupsApi.md#deleteGroupProperties) | **POST** /api/portfoliogroups/{scope}/{code}/properties/$delete | [EARLY ACCESS] Delete group properties
*PortfolioGroupsApi* | [**deletePortfolioFromGroup**](docs/PortfolioGroupsApi.md#deletePortfolioFromGroup) | **DELETE** /api/portfoliogroups/{scope}/{code}/portfolios/{portfolioScope}/{portfolioCode} | [EARLY ACCESS] Delete portfolio from group
*PortfolioGroupsApi* | [**deletePortfolioGroup**](docs/PortfolioGroupsApi.md#deletePortfolioGroup) | **DELETE** /api/portfoliogroups/{scope}/{code} | [EARLY ACCESS] Delete portfolio group
*PortfolioGroupsApi* | [**deleteSubGroupFromGroup**](docs/PortfolioGroupsApi.md#deleteSubGroupFromGroup) | **DELETE** /api/portfoliogroups/{scope}/{code}/subgroups/{subgroupScope}/{subgroupCode} | [EARLY ACCESS] Delete sub group from group
*PortfolioGroupsApi* | [**getGroupProperties**](docs/PortfolioGroupsApi.md#getGroupProperties) | **GET** /api/portfoliogroups/{scope}/{code}/properties | [EARLY ACCESS] Get group properties
*PortfolioGroupsApi* | [**getPortfolioGroup**](docs/PortfolioGroupsApi.md#getPortfolioGroup) | **GET** /api/portfoliogroups/{scope}/{code} | [EARLY ACCESS] Get portfolio group
*PortfolioGroupsApi* | [**getPortfolioGroupCommands**](docs/PortfolioGroupsApi.md#getPortfolioGroupCommands) | **GET** /api/portfoliogroups/{scope}/{code}/commands | [EARLY ACCESS] Get portfolio group commands
*PortfolioGroupsApi* | [**getPortfolioGroupExpansion**](docs/PortfolioGroupsApi.md#getPortfolioGroupExpansion) | **GET** /api/portfoliogroups/{scope}/{code}/expansion | [EARLY ACCESS] Get portfolio group expansion
*PortfolioGroupsApi* | [**listPortfolioGroups**](docs/PortfolioGroupsApi.md#listPortfolioGroups) | **GET** /api/portfoliogroups/{scope} | [EARLY ACCESS] List portfolio groups
*PortfolioGroupsApi* | [**updatePortfolioGroup**](docs/PortfolioGroupsApi.md#updatePortfolioGroup) | **PUT** /api/portfoliogroups/{scope}/{code} | [EARLY ACCESS] Update portfolio group
*PortfolioGroupsApi* | [**upsertGroupProperties**](docs/PortfolioGroupsApi.md#upsertGroupProperties) | **POST** /api/portfoliogroups/{scope}/{code}/properties/$upsert | [EARLY ACCESS] Upsert group properties
*PortfoliosApi* | [**deletePortfolio**](docs/PortfoliosApi.md#deletePortfolio) | **DELETE** /api/portfolios/{scope}/{code} | Delete portfolio
*PortfoliosApi* | [**deletePortfolioProperties**](docs/PortfoliosApi.md#deletePortfolioProperties) | **DELETE** /api/portfolios/{scope}/{code}/properties | Delete portfolio properties
*PortfoliosApi* | [**getPortfolio**](docs/PortfoliosApi.md#getPortfolio) | **GET** /api/portfolios/{scope}/{code} | Get portfolio
*PortfoliosApi* | [**getPortfolioCommands**](docs/PortfoliosApi.md#getPortfolioCommands) | **GET** /api/portfolios/{scope}/{code}/commands | [EARLY ACCESS] Get portfolio commands
*PortfoliosApi* | [**getPortfolioProperties**](docs/PortfoliosApi.md#getPortfolioProperties) | **GET** /api/portfolios/{scope}/{code}/properties | Get portfolio properties
*PortfoliosApi* | [**listPortfolios**](docs/PortfoliosApi.md#listPortfolios) | **GET** /api/portfolios | List portfolios
*PortfoliosApi* | [**listPortfoliosForScope**](docs/PortfoliosApi.md#listPortfoliosForScope) | **GET** /api/portfolios/{scope} | List portfolios for scope
*PortfoliosApi* | [**updatePortfolio**](docs/PortfoliosApi.md#updatePortfolio) | **PUT** /api/portfolios/{scope}/{code} | Update portfolio
*PortfoliosApi* | [**upsertPortfolioProperties**](docs/PortfoliosApi.md#upsertPortfolioProperties) | **POST** /api/portfolios/{scope}/{code}/properties | Upsert portfolio properties
*PropertyDefinitionsApi* | [**createPropertyDefinition**](docs/PropertyDefinitionsApi.md#createPropertyDefinition) | **POST** /api/propertydefinitions | Create property definition
*PropertyDefinitionsApi* | [**deletePropertyDefinition**](docs/PropertyDefinitionsApi.md#deletePropertyDefinition) | **DELETE** /api/propertydefinitions/{domain}/{scope}/{code} | Delete property definition
*PropertyDefinitionsApi* | [**getMultiplePropertyDefinitions**](docs/PropertyDefinitionsApi.md#getMultiplePropertyDefinitions) | **GET** /api/propertydefinitions | Get multiple property definitions
*PropertyDefinitionsApi* | [**getPropertyDefinition**](docs/PropertyDefinitionsApi.md#getPropertyDefinition) | **GET** /api/propertydefinitions/{domain}/{scope}/{code} | Get property definition
*PropertyDefinitionsApi* | [**updatePropertyDefinition**](docs/PropertyDefinitionsApi.md#updatePropertyDefinition) | **PUT** /api/propertydefinitions/{domain}/{scope}/{code} | Update property definition
*QuotesApi* | [**deleteQuotes**](docs/QuotesApi.md#deleteQuotes) | **POST** /api/quotes/{scope}/$delete | [BETA] Delete quotes
*QuotesApi* | [**getQuotes**](docs/QuotesApi.md#getQuotes) | **POST** /api/quotes/{scope}/$get | [BETA] Get quotes
*QuotesApi* | [**listQuotes**](docs/QuotesApi.md#listQuotes) | **GET** /api/quotes/{scope} | [BETA] List quotes
*QuotesApi* | [**upsertQuotes**](docs/QuotesApi.md#upsertQuotes) | **POST** /api/quotes/{scope} | [BETA] Upsert quotes
*ReconciliationsApi* | [**reconcileHoldings**](docs/ReconciliationsApi.md#reconcileHoldings) | **POST** /api/portfolios/$reconcileholdings | [EARLY ACCESS] Reconcile portfolio holdings
*ReconciliationsApi* | [**reconcileValuation**](docs/ReconciliationsApi.md#reconcileValuation) | **POST** /api/portfolios/$reconcileValuation | [EXPERIMENTAL] Reconcile valuations performed on one or two sets of holdings using one or two configuration recipes.
*ReferencePortfolioApi* | [**createReferencePortfolio**](docs/ReferencePortfolioApi.md#createReferencePortfolio) | **POST** /api/referenceportfolios/{scope} | Create reference portfolio
*ReferencePortfolioApi* | [**getReferencePortfolioConstituents**](docs/ReferencePortfolioApi.md#getReferencePortfolioConstituents) | **GET** /api/referenceportfolios/{scope}/{code}/constituents | Get constituents
*ReferencePortfolioApi* | [**listConstituentsAdjustments**](docs/ReferencePortfolioApi.md#listConstituentsAdjustments) | **GET** /api/referenceportfolios/{scope}/{code}/constituentsadjustments | List constituents adjustments
*ReferencePortfolioApi* | [**upsertReferencePortfolioConstituents**](docs/ReferencePortfolioApi.md#upsertReferencePortfolioConstituents) | **POST** /api/referenceportfolios/{scope}/{code}/constituents | Add constituents
*ResultsApi* | [**getResults**](docs/ResultsApi.md#getResults) | **GET** /api/results/{entityScope}/{entityCode}/{calculationScope}/{calculationCode}/{effectiveAt} | [EXPERIMENTAL] Retrieve a page of results all keyed by the provided parameters. The result store is not bi-temporal; a single date  addressed the market effectiveAt.
*ResultsApi* | [**upsertResults**](docs/ResultsApi.md#upsertResults) | **POST** /api/results | [EXPERIMENTAL] Upsert results
*SchemasApi* | [**getEntitySchema**](docs/SchemasApi.md#getEntitySchema) | **GET** /api/schemas/entities/{entity} | [BETA] Get schema
*SchemasApi* | [**getPropertySchema**](docs/SchemasApi.md#getPropertySchema) | **GET** /api/schemas/properties | [BETA] Get property schema
*SchemasApi* | [**getValueTypes**](docs/SchemasApi.md#getValueTypes) | **GET** /api/schemas/types | [BETA] Get value types
*SchemasApi* | [**listEntities**](docs/SchemasApi.md#listEntities) | **GET** /api/schemas/entities | [BETA] List entities
*ScopesApi* | [**listScopes**](docs/ScopesApi.md#listScopes) | **GET** /api/scopes | [EARLY ACCESS] List scopes
*SearchApi* | [**instrumentsSearch**](docs/SearchApi.md#instrumentsSearch) | **POST** /api/search/instruments | [EXPERIMENTAL] Instruments search
*SearchApi* | [**portfolioGroupsSearch**](docs/SearchApi.md#portfolioGroupsSearch) | **POST** /api/search/portfoliogroups | [DEPRECATED] Portfolio groups search
*SearchApi* | [**portfoliosSearch**](docs/SearchApi.md#portfoliosSearch) | **POST** /api/search/portfolios | [DEPRECATED] Portfolios search
*SearchApi* | [**propertiesSearch**](docs/SearchApi.md#propertiesSearch) | **POST** /api/search/propertydefinitions | [DEPRECATED] Search property definitions
*SearchApi* | [**searchPortfolioGroups**](docs/SearchApi.md#searchPortfolioGroups) | **GET** /api/search/portfoliogroups | [EXPERIMENTAL] Search Portfolio Groups
*SearchApi* | [**searchPortfolios**](docs/SearchApi.md#searchPortfolios) | **GET** /api/search/portfolios | [EXPERIMENTAL] Search Portfolios
*SearchApi* | [**searchProperties**](docs/SearchApi.md#searchProperties) | **GET** /api/search/propertydefinitions | [EXPERIMENTAL] Search Property Definitions
*StructuredMarketDataApi* | [**deleteStructuredMarketData**](docs/StructuredMarketDataApi.md#deleteStructuredMarketData) | **POST** /api/structured/{scope}/$delete | [EXPERIMENTAL] Delete one or more items of structured market data, assuming they are present.
*StructuredMarketDataApi* | [**getStructuredMarketData**](docs/StructuredMarketDataApi.md#getStructuredMarketData) | **POST** /api/structured/{scope}/$get | [EXPERIMENTAL] Get structured market data
*StructuredMarketDataApi* | [**upsertStructuredMarketData**](docs/StructuredMarketDataApi.md#upsertStructuredMarketData) | **POST** /api/structured/{scope} | [EXPERIMENTAL] Upsert a set of structured market data items. This creates or updates the data in Lusid.
*StructuredResultDataApi* | [**deleteStructuredResultData**](docs/StructuredResultDataApi.md#deleteStructuredResultData) | **POST** /api/unitresults/{scope}/$delete | [EXPERIMENTAL] Delete one or more items of structured result data, assuming they are present.
*StructuredResultDataApi* | [**getStructuredResultData**](docs/StructuredResultDataApi.md#getStructuredResultData) | **POST** /api/unitresults/{scope}/$get | [EXPERIMENTAL] Get structured result data
*StructuredResultDataApi* | [**upsertStructuredResultData**](docs/StructuredResultDataApi.md#upsertStructuredResultData) | **POST** /api/unitresults/{scope} | [EXPERIMENTAL] Upsert a set of structured result data items. This creates or updates the data in Lusid.
*SystemConfigurationApi* | [**createConfigurationTransactionType**](docs/SystemConfigurationApi.md#createConfigurationTransactionType) | **POST** /api/systemconfiguration/transactions/type | [EARLY ACCESS] Create transaction type
*SystemConfigurationApi* | [**createSideDefinition**](docs/SystemConfigurationApi.md#createSideDefinition) | **POST** /api/systemconfiguration/transactions/side | [EXPERIMENTAL] Create side definition
*SystemConfigurationApi* | [**listConfigurationTransactionTypes**](docs/SystemConfigurationApi.md#listConfigurationTransactionTypes) | **GET** /api/systemconfiguration/transactions | [EARLY ACCESS] List transaction types
*SystemConfigurationApi* | [**setConfigurationTransactionTypes**](docs/SystemConfigurationApi.md#setConfigurationTransactionTypes) | **PUT** /api/systemconfiguration/transactions | [EXPERIMENTAL] Set transaction types
*TransactionPortfoliosApi* | [**adjustHoldings**](docs/TransactionPortfoliosApi.md#adjustHoldings) | **POST** /api/transactionportfolios/{scope}/{code}/holdings | Adjust holdings
*TransactionPortfoliosApi* | [**buildTransactions**](docs/TransactionPortfoliosApi.md#buildTransactions) | **POST** /api/transactionportfolios/{scope}/{code}/transactions/$build | Build transactions
*TransactionPortfoliosApi* | [**cancelAdjustHoldings**](docs/TransactionPortfoliosApi.md#cancelAdjustHoldings) | **DELETE** /api/transactionportfolios/{scope}/{code}/holdings | Cancel adjust holdings
*TransactionPortfoliosApi* | [**cancelExecutions**](docs/TransactionPortfoliosApi.md#cancelExecutions) | **DELETE** /api/transactionportfolios/{scope}/{code}/executions | [EARLY ACCESS] Cancel executions
*TransactionPortfoliosApi* | [**cancelTransactions**](docs/TransactionPortfoliosApi.md#cancelTransactions) | **DELETE** /api/transactionportfolios/{scope}/{code}/transactions | Cancel transactions
*TransactionPortfoliosApi* | [**createPortfolio**](docs/TransactionPortfoliosApi.md#createPortfolio) | **POST** /api/transactionportfolios/{scope} | Create portfolio
*TransactionPortfoliosApi* | [**deletePropertiesFromTransaction**](docs/TransactionPortfoliosApi.md#deletePropertiesFromTransaction) | **DELETE** /api/transactionportfolios/{scope}/{code}/transactions/{transactionId}/properties | Delete properties from transaction
*TransactionPortfoliosApi* | [**getDetails**](docs/TransactionPortfoliosApi.md#getDetails) | **GET** /api/transactionportfolios/{scope}/{code}/details | Get details
*TransactionPortfoliosApi* | [**getHoldings**](docs/TransactionPortfoliosApi.md#getHoldings) | **GET** /api/transactionportfolios/{scope}/{code}/holdings | Get holdings
*TransactionPortfoliosApi* | [**getHoldingsAdjustment**](docs/TransactionPortfoliosApi.md#getHoldingsAdjustment) | **GET** /api/transactionportfolios/{scope}/{code}/holdingsadjustments/{effectiveAt} | Get holdings adjustment
*TransactionPortfoliosApi* | [**getTransactions**](docs/TransactionPortfoliosApi.md#getTransactions) | **GET** /api/transactionportfolios/{scope}/{code}/transactions | Get transactions
*TransactionPortfoliosApi* | [**listHoldingsAdjustments**](docs/TransactionPortfoliosApi.md#listHoldingsAdjustments) | **GET** /api/transactionportfolios/{scope}/{code}/holdingsadjustments | List holdings adjustments
*TransactionPortfoliosApi* | [**setHoldings**](docs/TransactionPortfoliosApi.md#setHoldings) | **PUT** /api/transactionportfolios/{scope}/{code}/holdings | Set holdings
*TransactionPortfoliosApi* | [**upsertExecutions**](docs/TransactionPortfoliosApi.md#upsertExecutions) | **POST** /api/transactionportfolios/{scope}/{code}/executions | [EARLY ACCESS] Upsert executions
*TransactionPortfoliosApi* | [**upsertPortfolioDetails**](docs/TransactionPortfoliosApi.md#upsertPortfolioDetails) | **POST** /api/transactionportfolios/{scope}/{code}/details | Upsert portfolio details
*TransactionPortfoliosApi* | [**upsertTransactionProperties**](docs/TransactionPortfoliosApi.md#upsertTransactionProperties) | **POST** /api/transactionportfolios/{scope}/{code}/transactions/{transactionId}/properties | Upsert transaction properties
*TransactionPortfoliosApi* | [**upsertTransactions**](docs/TransactionPortfoliosApi.md#upsertTransactions) | **POST** /api/transactionportfolios/{scope}/{code}/transactions | Upsert transactions


## Documentation for Models

 - [AccessControlledAction](docs/AccessControlledAction.md)
 - [AccessControlledResource](docs/AccessControlledResource.md)
 - [ActionId](docs/ActionId.md)
 - [AdjustHolding](docs/AdjustHolding.md)
 - [AdjustHoldingRequest](docs/AdjustHoldingRequest.md)
 - [AggregateSpec](docs/AggregateSpec.md)
 - [AggregationContext](docs/AggregationContext.md)
 - [AggregationOptions](docs/AggregationOptions.md)
 - [AggregationRequest](docs/AggregationRequest.md)
 - [AggregationResponseNodeOfDictionaryOfStringToObject](docs/AggregationResponseNodeOfDictionaryOfStringToObject.md)
 - [AnnulQuotesResponse](docs/AnnulQuotesResponse.md)
 - [AnnulSingleStructuredDataResponse](docs/AnnulSingleStructuredDataResponse.md)
 - [AnnulStructuredDataResponse](docs/AnnulStructuredDataResponse.md)
 - [Change](docs/Change.md)
 - [CompletePortfolio](docs/CompletePortfolio.md)
 - [ConfigurationRecipe](docs/ConfigurationRecipe.md)
 - [ConfigurationRecipeSnippet](docs/ConfigurationRecipeSnippet.md)
 - [ConstituentsAdjustmentHeader](docs/ConstituentsAdjustmentHeader.md)
 - [CorporateAction](docs/CorporateAction.md)
 - [CorporateActionSource](docs/CorporateActionSource.md)
 - [CorporateActionTransition](docs/CorporateActionTransition.md)
 - [CorporateActionTransitionComponent](docs/CorporateActionTransitionComponent.md)
 - [CorporateActionTransitionComponentRequest](docs/CorporateActionTransitionComponentRequest.md)
 - [CorporateActionTransitionRequest](docs/CorporateActionTransitionRequest.md)
 - [CreateCorporateActionSourceRequest](docs/CreateCorporateActionSourceRequest.md)
 - [CreateCutLabelDefinitionRequest](docs/CreateCutLabelDefinitionRequest.md)
 - [CreateDataTypeRequest](docs/CreateDataTypeRequest.md)
 - [CreateDerivedTransactionPortfolioRequest](docs/CreateDerivedTransactionPortfolioRequest.md)
 - [CreatePortfolioDetails](docs/CreatePortfolioDetails.md)
 - [CreatePortfolioGroupRequest](docs/CreatePortfolioGroupRequest.md)
 - [CreatePropertyDefinitionRequest](docs/CreatePropertyDefinitionRequest.md)
 - [CreateReferencePortfolioRequest](docs/CreateReferencePortfolioRequest.md)
 - [CreateResults](docs/CreateResults.md)
 - [CreateTransactionPortfolioRequest](docs/CreateTransactionPortfolioRequest.md)
 - [CreateUnitDefinition](docs/CreateUnitDefinition.md)
 - [CurrencyAndAmount](docs/CurrencyAndAmount.md)
 - [CutLabelDefinition](docs/CutLabelDefinition.md)
 - [CutLocalTime](docs/CutLocalTime.md)
 - [DataMapping](docs/DataMapping.md)
 - [DataType](docs/DataType.md)
 - [DeleteInstrumentPropertiesResponse](docs/DeleteInstrumentPropertiesResponse.md)
 - [DeleteInstrumentResponse](docs/DeleteInstrumentResponse.md)
 - [DeletedEntityResponse](docs/DeletedEntityResponse.md)
 - [ErrorDetail](docs/ErrorDetail.md)
 - [ExecutionRequest](docs/ExecutionRequest.md)
 - [ExpandedGroup](docs/ExpandedGroup.md)
 - [FieldSchema](docs/FieldSchema.md)
 - [FileResponse](docs/FileResponse.md)
 - [FxForwardInstrument](docs/FxForwardInstrument.md)
 - [FxOption](docs/FxOption.md)
 - [GetInstrumentsResponse](docs/GetInstrumentsResponse.md)
 - [GetQuotesResponse](docs/GetQuotesResponse.md)
 - [GetRecipeResponse](docs/GetRecipeResponse.md)
 - [GetReferencePortfolioConstituentsResponse](docs/GetReferencePortfolioConstituentsResponse.md)
 - [GetStructuredMarketDataResponse](docs/GetStructuredMarketDataResponse.md)
 - [GetStructuredResultDataResponse](docs/GetStructuredResultDataResponse.md)
 - [HoldingAdjustment](docs/HoldingAdjustment.md)
 - [HoldingsAdjustment](docs/HoldingsAdjustment.md)
 - [HoldingsAdjustmentHeader](docs/HoldingsAdjustmentHeader.md)
 - [IUnitDefinitionDto](docs/IUnitDefinitionDto.md)
 - [IdSelectorDefinition](docs/IdSelectorDefinition.md)
 - [IdentifierPartSchema](docs/IdentifierPartSchema.md)
 - [InlineAggregationRequest](docs/InlineAggregationRequest.md)
 - [Instrument](docs/Instrument.md)
 - [InstrumentDefinition](docs/InstrumentDefinition.md)
 - [InstrumentEconomicDefinition](docs/InstrumentEconomicDefinition.md)
 - [InstrumentIdTypeDescriptor](docs/InstrumentIdTypeDescriptor.md)
 - [InstrumentIdValue](docs/InstrumentIdValue.md)
 - [InstrumentMatch](docs/InstrumentMatch.md)
 - [InstrumentSearchProperty](docs/InstrumentSearchProperty.md)
 - [Link](docs/Link.md)
 - [ListAggregationResponse](docs/ListAggregationResponse.md)
 - [LusidInstrument](docs/LusidInstrument.md)
 - [LusidProblemDetails](docs/LusidProblemDetails.md)
 - [LusidValidationProblemDetails](docs/LusidValidationProblemDetails.md)
 - [MarketContext](docs/MarketContext.md)
 - [MarketContextSuppliers](docs/MarketContextSuppliers.md)
 - [MarketDataKeyRule](docs/MarketDataKeyRule.md)
 - [MarketOptions](docs/MarketOptions.md)
 - [MetricValue](docs/MetricValue.md)
 - [ModelSelection](docs/ModelSelection.md)
 - [NestedAggregationResponse](docs/NestedAggregationResponse.md)
 - [OrderBySpec](docs/OrderBySpec.md)
 - [OutputTransaction](docs/OutputTransaction.md)
 - [PagedResourceListOfPortfolioGroup](docs/PagedResourceListOfPortfolioGroup.md)
 - [PagedResourceListOfPortfolioSearchResult](docs/PagedResourceListOfPortfolioSearchResult.md)
 - [PagedResourceListOfPropertyDefinition](docs/PagedResourceListOfPropertyDefinition.md)
 - [PerpetualProperty](docs/PerpetualProperty.md)
 - [Portfolio](docs/Portfolio.md)
 - [PortfolioDetails](docs/PortfolioDetails.md)
 - [PortfolioGroup](docs/PortfolioGroup.md)
 - [PortfolioGroupProperties](docs/PortfolioGroupProperties.md)
 - [PortfolioHolding](docs/PortfolioHolding.md)
 - [PortfolioProperties](docs/PortfolioProperties.md)
 - [PortfolioReconciliationRequest](docs/PortfolioReconciliationRequest.md)
 - [PortfolioSearchResult](docs/PortfolioSearchResult.md)
 - [PortfoliosReconciliationRequest](docs/PortfoliosReconciliationRequest.md)
 - [PricingContext](docs/PricingContext.md)
 - [PricingOptions](docs/PricingOptions.md)
 - [ProcessedCommand](docs/ProcessedCommand.md)
 - [Property](docs/Property.md)
 - [PropertyDefinition](docs/PropertyDefinition.md)
 - [PropertyFilter](docs/PropertyFilter.md)
 - [PropertySchema](docs/PropertySchema.md)
 - [PropertyValue](docs/PropertyValue.md)
 - [Quote](docs/Quote.md)
 - [QuoteId](docs/QuoteId.md)
 - [QuoteSeriesId](docs/QuoteSeriesId.md)
 - [RealisedGainLoss](docs/RealisedGainLoss.md)
 - [ReconciliationBreak](docs/ReconciliationBreak.md)
 - [ReferencePortfolioConstituent](docs/ReferencePortfolioConstituent.md)
 - [ReferencePortfolioConstituentRequest](docs/ReferencePortfolioConstituentRequest.md)
 - [ResourceId](docs/ResourceId.md)
 - [ResourceListOfAccessControlledResource](docs/ResourceListOfAccessControlledResource.md)
 - [ResourceListOfChange](docs/ResourceListOfChange.md)
 - [ResourceListOfConstituentsAdjustmentHeader](docs/ResourceListOfConstituentsAdjustmentHeader.md)
 - [ResourceListOfCorporateAction](docs/ResourceListOfCorporateAction.md)
 - [ResourceListOfCorporateActionSource](docs/ResourceListOfCorporateActionSource.md)
 - [ResourceListOfCutLabelDefinition](docs/ResourceListOfCutLabelDefinition.md)
 - [ResourceListOfDataType](docs/ResourceListOfDataType.md)
 - [ResourceListOfHoldingsAdjustmentHeader](docs/ResourceListOfHoldingsAdjustmentHeader.md)
 - [ResourceListOfIUnitDefinitionDto](docs/ResourceListOfIUnitDefinitionDto.md)
 - [ResourceListOfInstrument](docs/ResourceListOfInstrument.md)
 - [ResourceListOfInstrumentIdTypeDescriptor](docs/ResourceListOfInstrumentIdTypeDescriptor.md)
 - [ResourceListOfPortfolio](docs/ResourceListOfPortfolio.md)
 - [ResourceListOfPortfolioGroup](docs/ResourceListOfPortfolioGroup.md)
 - [ResourceListOfPortfolioSearchResult](docs/ResourceListOfPortfolioSearchResult.md)
 - [ResourceListOfProcessedCommand](docs/ResourceListOfProcessedCommand.md)
 - [ResourceListOfPropertyDefinition](docs/ResourceListOfPropertyDefinition.md)
 - [ResourceListOfQuote](docs/ResourceListOfQuote.md)
 - [ResourceListOfReconciliationBreak](docs/ResourceListOfReconciliationBreak.md)
 - [ResourceListOfScopeDefinition](docs/ResourceListOfScopeDefinition.md)
 - [ResourceListOfString](docs/ResourceListOfString.md)
 - [ResourceListOfValueType](docs/ResourceListOfValueType.md)
 - [ResultDataSchema](docs/ResultDataSchema.md)
 - [Results](docs/Results.md)
 - [Schema](docs/Schema.md)
 - [ScopeDefinition](docs/ScopeDefinition.md)
 - [SideConfigurationData](docs/SideConfigurationData.md)
 - [SideConfigurationDataRequest](docs/SideConfigurationDataRequest.md)
 - [Stream](docs/Stream.md)
 - [StructuredMarketData](docs/StructuredMarketData.md)
 - [StructuredMarketDataId](docs/StructuredMarketDataId.md)
 - [StructuredResultData](docs/StructuredResultData.md)
 - [StructuredResultDataId](docs/StructuredResultDataId.md)
 - [TargetTaxLot](docs/TargetTaxLot.md)
 - [TargetTaxLotRequest](docs/TargetTaxLotRequest.md)
 - [Transaction](docs/Transaction.md)
 - [TransactionConfigurationData](docs/TransactionConfigurationData.md)
 - [TransactionConfigurationDataRequest](docs/TransactionConfigurationDataRequest.md)
 - [TransactionConfigurationMovementData](docs/TransactionConfigurationMovementData.md)
 - [TransactionConfigurationMovementDataRequest](docs/TransactionConfigurationMovementDataRequest.md)
 - [TransactionConfigurationTypeAlias](docs/TransactionConfigurationTypeAlias.md)
 - [TransactionPrice](docs/TransactionPrice.md)
 - [TransactionPropertyMapping](docs/TransactionPropertyMapping.md)
 - [TransactionPropertyMappingRequest](docs/TransactionPropertyMappingRequest.md)
 - [TransactionQueryParameters](docs/TransactionQueryParameters.md)
 - [TransactionRequest](docs/TransactionRequest.md)
 - [TransactionSetConfigurationData](docs/TransactionSetConfigurationData.md)
 - [TransactionSetConfigurationDataRequest](docs/TransactionSetConfigurationDataRequest.md)
 - [UpdateCutLabelDefinitionRequest](docs/UpdateCutLabelDefinitionRequest.md)
 - [UpdateDataTypeRequest](docs/UpdateDataTypeRequest.md)
 - [UpdateInstrumentIdentifierRequest](docs/UpdateInstrumentIdentifierRequest.md)
 - [UpdatePortfolioGroupRequest](docs/UpdatePortfolioGroupRequest.md)
 - [UpdatePortfolioRequest](docs/UpdatePortfolioRequest.md)
 - [UpdatePropertyDefinitionRequest](docs/UpdatePropertyDefinitionRequest.md)
 - [UpsertCorporateActionRequest](docs/UpsertCorporateActionRequest.md)
 - [UpsertCorporateActionsResponse](docs/UpsertCorporateActionsResponse.md)
 - [UpsertInstrumentPropertiesResponse](docs/UpsertInstrumentPropertiesResponse.md)
 - [UpsertInstrumentPropertyRequest](docs/UpsertInstrumentPropertyRequest.md)
 - [UpsertInstrumentsResponse](docs/UpsertInstrumentsResponse.md)
 - [UpsertPortfolioExecutionsResponse](docs/UpsertPortfolioExecutionsResponse.md)
 - [UpsertPortfolioTransactionsResponse](docs/UpsertPortfolioTransactionsResponse.md)
 - [UpsertQuoteRequest](docs/UpsertQuoteRequest.md)
 - [UpsertQuotesResponse](docs/UpsertQuotesResponse.md)
 - [UpsertRecipeRequest](docs/UpsertRecipeRequest.md)
 - [UpsertReferencePortfolioConstituentsRequest](docs/UpsertReferencePortfolioConstituentsRequest.md)
 - [UpsertReferencePortfolioConstituentsResponse](docs/UpsertReferencePortfolioConstituentsResponse.md)
 - [UpsertSingleStructuredDataResponse](docs/UpsertSingleStructuredDataResponse.md)
 - [UpsertStructuredDataResponse](docs/UpsertStructuredDataResponse.md)
 - [UpsertStructuredMarketDataRequest](docs/UpsertStructuredMarketDataRequest.md)
 - [UpsertStructuredResultDataRequest](docs/UpsertStructuredResultDataRequest.md)
 - [UpsertTransactionPropertiesResponse](docs/UpsertTransactionPropertiesResponse.md)
 - [User](docs/User.md)
 - [ValuationReconciliationRequest](docs/ValuationReconciliationRequest.md)
 - [ValuationsReconciliationRequest](docs/ValuationsReconciliationRequest.md)
 - [VendorModelRule](docs/VendorModelRule.md)
 - [Version](docs/Version.md)
 - [VersionSummaryDto](docs/VersionSummaryDto.md)
 - [VersionedResourceListOfOutputTransaction](docs/VersionedResourceListOfOutputTransaction.md)
 - [VersionedResourceListOfPortfolioHolding](docs/VersionedResourceListOfPortfolioHolding.md)
 - [VersionedResourceListOfTransaction](docs/VersionedResourceListOfTransaction.md)
 - [WeightedInstrument](docs/WeightedInstrument.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### oauth2

- **Type**: OAuth
- **Flow**: implicit
- **Authorization URL**: https://lusid.okta.com/oauth2/aus5al5yopbHW2wJn2p6/v1/authorize
- **Scopes**: N/A


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

info@finbourne.com

