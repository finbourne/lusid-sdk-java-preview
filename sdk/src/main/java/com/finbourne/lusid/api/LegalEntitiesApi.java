/*
 * LUSID API
 * # Introduction  This page documents the [LUSID APIs](https://www.lusid.com/api/swagger), which allows authorised clients to query and update their data within the LUSID platform.  SDKs to interact with the LUSID APIs are available in the following languages and frameworks:  * [C#](https://github.com/finbourne/lusid-sdk-csharp) * [Java](https://github.com/finbourne/lusid-sdk-java) * [JavaScript](https://github.com/finbourne/lusid-sdk-js) * [Python](https://github.com/finbourne/lusid-sdk-python) * [Angular](https://github.com/finbourne/lusid-sdk-angular)  # Data Model  The LUSID API has a relatively lightweight but extremely powerful data model. One of the goals of LUSID was not to enforce on clients a single rigid data model but rather to provide a flexible foundation onto which clients can map their own data models.  The core entities in LUSID provide a minimal structure and set of relationships, and the data model can be extended using Properties.  The LUSID data model is exposed through the LUSID APIs.  The APIs provide access to both business objects and the meta data used to configure the systems behaviours.   The key business entities are: - * **Portfolios** A portfolio is a container for transactions and holdings (a **Transaction Portfolio**) or constituents (a **Reference Portfolio**). * **Derived Portfolios**. Derived Portfolios allow Portfolios to be created based on other Portfolios, by overriding or adding specific items. * **Holdings** A Holding is a quantity of an Instrument or a balance of cash within a Portfolio.  Holdings can only be adjusted via Transactions. * **Transactions** A Transaction is an economic event that occurs in a Portfolio, causing its holdings to change. * **Corporate Actions** A corporate action is a market event which occurs to an Instrument and thus applies to all portfolios which holding the instrument.  Examples are stock splits or mergers. * **Constituents** A constituent is a record in a Reference Portfolio containing an Instrument and an associated weight. * **Instruments**  An instrument represents a currency, tradable instrument or OTC contract that is attached to a transaction and a holding. * **Properties** All major entities allow additional user defined properties to be associated with them.   For example, a Portfolio manager may be associated with a portfolio.  Meta data includes: - * **Transaction Types** Transactions are booked with a specific transaction type.  The types are client defined and are used to map the Transaction to a series of movements which update the portfolio holdings.  * **Properties Types** Types of user defined properties used within the system.  ## Scope  All data in LUSID is segregated at the client level.  Entities in LUSID are identifiable by a unique code.  Every entity lives within a logical data partition known as a Scope.  Scope is an identity namespace allowing two entities with the same unique code to co-exist within individual address spaces.  For example, prices for equities from different vendors may be uploaded into different scopes such as `client/vendor1` and `client/vendor2`.  A portfolio may then be valued using either of the price sources by referencing the appropriate scope.  LUSID Clients cannot access scopes of other clients.  ## Instruments  LUSID has its own built-in instrument master which you can use to master your own instrument universe.  Every instrument must be created with one or more unique market identifiers, such as [FIGI](https://openfigi.com/). For any non-listed instruments (eg OTCs), you can upload an instrument against a custom ID of your choosing.  In addition, LUSID will allocate each instrument a unique 'LUSID instrument identifier'. The LUSID instrument identifier is what is used when uploading transactions, holdings, prices, etc. The API exposes an `instrument/lookup` endpoint which can be used to lookup these LUSID identifiers using their market identifiers.  Cash can be referenced using the ISO currency code prefixed with \"`CCY_`\" e.g. `CCY_GBP`  ## Instrument Data  Instrument data can be uploaded to the system using the [Instrument Properties](#operation/UpsertInstrumentsProperties) endpoint.  | Field|Type|Description | | ---|---|--- | | Key|propertykey|The key of the property. This takes the format {domain}/{scope}/{code} e.g. 'Instrument/system/Name' or 'Transaction/strategy/quantsignal'. | | Value|string|The value of the property. | | EffectiveFrom|datetimeoffset|The effective datetime from which the property is valid. | | EffectiveUntil|datetimeoffset|The effective datetime until which the property is valid. If not supplied this will be valid indefinitely, or until the next 'effectiveFrom' datetime of the property. |   ## Transaction Portfolios  Portfolios are the top-level entity containers within LUSID, containing transactions, corporate actions and holdings.    The transactions build up the portfolio holdings on which valuations, analytics profit & loss and risk can be calculated.  Properties can be associated with Portfolios to add in additional data.  Portfolio properties can be changed over time, for example to allow a Portfolio Manager to be linked with a Portfolio.  Additionally, portfolios can be securitised and held by other portfolios, allowing LUSID to perform \"drill-through\" into underlying fund holdings  ### Derived Portfolios  LUSID also allows for a portfolio to be composed of another portfolio via derived portfolios.  A derived portfolio can contain its own transactions and also inherits any transactions from its parent portfolio.  Any changes made to the parent portfolio are automatically reflected in derived portfolio.  Derived portfolios in conjunction with scopes are a powerful construct.  For example, to do pre-trade what-if analysis, a derived portfolio could be created a new namespace linked to the underlying live (parent) portfolio.  Analysis can then be undertaken on the derived portfolio without affecting the live portfolio.  ### Transactions  A transaction represents an economic activity against a Portfolio.  Transactions are processed according to a configuration. This will tell the LUSID engine how to interpret the transaction and correctly update the holdings. LUSID comes with a set of transaction types you can use out of the box, or you can configure your own set(s) of transactions.  For more details see the [LUSID Getting Started Guide for transaction configuration.](https://support.lusid.com/configuring-transaction-types)  | Field|Type|Description | | ---|---|--- | | TransactionId|string|The unique identifier of the transaction. | | Type|string|The type of the transaction, for example 'Buy' or 'Sell'. The transaction type must have been pre-configured using the System Configuration API. If not, this operation will succeed but you are not able to calculate holdings for the portfolio that include this transaction. | | InstrumentIdentifiers|map|A set of instrument identifiers that can resolve the transaction to a unique instrument. | | TransactionDate|dateorcutlabel|The date of the transaction. | | SettlementDate|dateorcutlabel|The settlement date of the transaction. | | Units|decimal|The number of units of the transacted instrument. | | TransactionPrice|transactionprice|The price of each instrument unit in the transaction currency. | | TotalConsideration|currencyandamount|The total value of the transaction in the settlement currency. | | ExchangeRate|decimal|The exchange rate between the transaction and settlement currency (settlement currency being represented by TotalConsideration.Currency). For example, if the transaction currency is USD and the settlement currency is GBP, this would be the appropriate USD/GBP rate. | | TransactionCurrency|currency|The transaction currency. | | Properties|map|A list of unique transaction properties and associated values to store for the transaction. Each property must be from the 'Transaction' domain. | | CounterpartyId|string|The identifier for the counterparty of the transaction. | | Source|string|The source of the transaction. This is used to look up the appropriate transaction group set in the transaction type configuration. |   From these fields, the following values can be calculated  * **Transaction value in Transaction currency**: TotalConsideration / ExchangeRate  * **Transaction value in Portfolio currency**: Transaction value in Transaction currency * TradeToPortfolioRate  #### Example Transactions  ##### A Common Purchase Example Three example transactions are shown in the table below.   They represent a purchase of USD denominated IBM shares within a Sterling denominated portfolio.   * The first two transactions are for separate buy and fx trades    * Buying 500 IBM shares for $71,480.00    * A spot foreign exchange conversion to fund the IBM purchase. (Buy $71,480.00 for &#163;54,846.60)  * The third transaction is an alternate version of the above trades. Buying 500 IBM shares and settling directly in Sterling.  | Column |  Buy Trade | Fx Trade | Buy Trade with foreign Settlement | | ----- | ----- | ----- | ----- | | TransactionId | FBN00001 | FBN00002 | FBN00003 | | Type | Buy | FxBuy | Buy | | InstrumentIdentifiers | { \"figi\", \"BBG000BLNNH6\" } | { \"CCY\", \"CCY_USD\" } | { \"figi\", \"BBG000BLNNH6\" } | | TransactionDate | 2018-08-02 | 2018-08-02 | 2018-08-02 | | SettlementDate | 2018-08-06 | 2018-08-06 | 2018-08-06 | | Units | 500 | 71480 | 500 | | TransactionPrice | 142.96 | 1 | 142.96 | | TradeCurrency | USD | USD | USD | | ExchangeRate | 1 | 0.7673 | 0.7673 | | TotalConsideration.Amount | 71480.00 | 54846.60 | 54846.60 | | TotalConsideration.Currency | USD | GBP | GBP | | Trade/default/TradeToPortfolioRate&ast; | 0.7673 | 0.7673 | 0.7673 |  [&ast; This is a property field]  ##### A Forward FX Example  LUSID has a flexible transaction modelling system, meaning there are a number of different ways of modelling forward fx trades.  The default LUSID transaction types are FwdFxBuy and FwdFxSell. Using these transaction types, LUSID will generate two holdings for each Forward FX trade, one for each currency in the trade.  An example Forward Fx trade to sell GBP for USD in a JPY-denominated portfolio is shown below:  | Column | Forward 'Sell' Trade | Notes | | ----- | ----- | ---- | | TransactionId | FBN00004 | | | Type | FwdFxSell | | | InstrumentIdentifiers | { \"Instrument/default/Currency\", \"GBP\" } | | | TransactionDate | 2018-08-02 | | | SettlementDate | 2019-02-06 | Six month forward | | Units | 10000.00 | Units of GBP | | TransactionPrice | 1 | | | TradeCurrency | GBP | Currency being sold | | ExchangeRate | 1.3142 | Agreed rate between GBP and USD | | TotalConsideration.Amount | 13142.00 | Amount in the settlement currency, USD | | TotalConsideration.Currency | USD | Settlement currency | | Trade/default/TradeToPortfolioRate | 142.88 | Rate between trade currency, GBP and portfolio base currency, JPY |  Please note that exactly the same economic behaviour could be modelled using the FwdFxBuy Transaction Type with the amounts and rates reversed.  ### Holdings  A holding represents a position in an instrument or cash on a given date.  | Field|Type|Description | | ---|---|--- | | InstrumentUid|string|The unqiue Lusid Instrument Id (LUID) of the instrument that the holding is in. | | SubHoldingKeys|map|The sub-holding properties which identify the holding. Each property will be from the 'Transaction' domain. These are configured when a transaction portfolio is created. | | Properties|map|The properties which have been requested to be decorated onto the holding. These will be from the 'Instrument' or 'Holding' domain. | | HoldingType|string|The type of the holding e.g. Position, Balance, CashCommitment, Receivable, ForwardFX etc. | | Units|decimal|The total number of units of the holding. | | SettledUnits|decimal|The total number of settled units of the holding. | | Cost|currencyandamount|The total cost of the holding in the transaction currency. | | CostPortfolioCcy|currencyandamount|The total cost of the holding in the portfolio currency. | | Transaction|transaction|The transaction associated with an unsettled holding. | | Currency|currency|The holding currency. |   ## Corporate Actions  Corporate actions are represented within LUSID in terms of a set of instrument-specific 'transitions'.  These transitions are used to specify the participants of the corporate action, and the effect that the corporate action will have on holdings in those participants.  ### Corporate Action  | Field|Type|Description | | ---|---|--- | | CorporateActionCode|code|The unique identifier of this corporate action | | Description|string|  | | AnnouncementDate|datetimeoffset|The announcement date of the corporate action | | ExDate|datetimeoffset|The ex date of the corporate action | | RecordDate|datetimeoffset|The record date of the corporate action | | PaymentDate|datetimeoffset|The payment date of the corporate action | | Transitions|corporateactiontransition[]|The transitions that result from this corporate action |   ### Transition | Field|Type|Description | | ---|---|--- | | InputTransition|corporateactiontransitioncomponent|Indicating the basis of the corporate action - which security and how many units | | OutputTransitions|corporateactiontransitioncomponent[]|What will be generated relative to the input transition |   ### Example Corporate Action Transitions  #### A Dividend Action Transition  In this example, for each share of IBM, 0.20 units (or 20 pence) of GBP are generated.  | Column |  Input Transition | Output Transition | | ----- | ----- | ----- | | Instrument Identifiers | { \"figi\" : \"BBG000BLNNH6\" } | { \"ccy\" : \"CCY_GBP\" } | | Units Factor | 1 | 0.20 | | Cost Factor | 1 | 0 |  #### A Split Action Transition  In this example, for each share of IBM, we end up with 2 units (2 shares) of IBM, with total value unchanged.  | Column |  Input Transition | Output Transition | | ----- | ----- | ----- | | Instrument Identifiers | { \"figi\" : \"BBG000BLNNH6\" } | { \"figi\" : \"BBG000BLNNH6\" } | | Units Factor | 1 | 2 | | Cost Factor | 1 | 1 |  #### A Spinoff Action Transition  In this example, for each share of IBM, we end up with 1 unit (1 share) of IBM and 3 units (3 shares) of Celestica, with 85% of the value remaining on the IBM share, and 5% in each Celestica share (15% total).  | Column |  Input Transition | Output Transition 1 | Output Transition 2 | | ----- | ----- | ----- | ----- | | Instrument Identifiers | { \"figi\" : \"BBG000BLNNH6\" } | { \"figi\" : \"BBG000BLNNH6\" } | { \"figi\" : \"BBG000HBGRF3\" } | | Units Factor | 1 | 1 | 3 | | Cost Factor | 1 | 0.85 | 0.15 |  ## Reference Portfolios Reference portfolios are portfolios that contain constituents with weights.  They are designed to represent entities such as indices and benchmarks.  ### Constituents | Field|Type|Description | | ---|---|--- | | InstrumentIdentifiers|map|Unique instrument identifiers | | InstrumentUid|string|LUSID's internal unique instrument identifier, resolved from the instrument identifiers | | Currency|decimal|  | | Weight|decimal|  | | FloatingWeight|decimal|  |   ## Portfolio Groups Portfolio groups allow the construction of a hierarchy from portfolios and groups.  Portfolio operations on the group are executed on an aggregated set of portfolios in the hierarchy.   For example:   * Global Portfolios _(group)_   * APAC _(group)_     * Hong Kong _(portfolio)_     * Japan _(portfolio)_   * Europe _(group)_     * France _(portfolio)_     * Germany _(portfolio)_   * UK _(portfolio)_   In this example **Global Portfolios** is a group that consists of an aggregate of **Hong Kong**, **Japan**, **France**, **Germany** and **UK** portfolios.  ## Properties  Properties are key-value pairs that can be applied to any entity within a domain (where a domain is `trade`, `portfolio`, `security` etc).  Properties must be defined before use with a `PropertyDefinition` and can then subsequently be added to entities.   ## Schema  A detailed description of the entities used by the API and parameters for endpoints which take a JSON document can be retrieved via the `schema` endpoint.  ## Meta data  The following headers are returned on all responses from LUSID  | Name | Purpose | | --- | --- | | lusid-meta-duration | Duration of the request | | lusid-meta-success | Whether or not LUSID considered the request to be successful | | lusid-meta-requestId | The unique identifier for the request | | lusid-schema-url | Url of the schema for the data being returned | | lusid-property-schema-url | Url of the schema for any properties |   # Error Codes  | Code|Name|Description | | ---|---|--- | | <a name=\"-10\">-10</a>|Server Configuration Error|  | | <a name=\"-1\">-1</a>|Unknown error|An unexpected error was encountered on our side. | | <a name=\"102\">102</a>|Version Not Found|  | | <a name=\"103\">103</a>|Api Rate Limit Violation|  | | <a name=\"104\">104</a>|Instrument Not Found|  | | <a name=\"105\">105</a>|Property Not Found|  | | <a name=\"106\">106</a>|Portfolio Recursion Depth|  | | <a name=\"108\">108</a>|Group Not Found|  | | <a name=\"109\">109</a>|Portfolio Not Found|  | | <a name=\"110\">110</a>|Property Schema Not Found|  | | <a name=\"111\">111</a>|Portfolio Ancestry Not Found|  | | <a name=\"112\">112</a>|Portfolio With Id Already Exists|  | | <a name=\"113\">113</a>|Orphaned Portfolio|  | | <a name=\"119\">119</a>|Missing Base Claims|  | | <a name=\"121\">121</a>|Property Not Defined|  | | <a name=\"122\">122</a>|Cannot Delete System Property|  | | <a name=\"123\">123</a>|Cannot Modify Immutable Property Field|  | | <a name=\"124\">124</a>|Property Already Exists|  | | <a name=\"125\">125</a>|Invalid Property Life Time|  | | <a name=\"126\">126</a>|Property Constraint Style Excludes Properties|  | | <a name=\"127\">127</a>|Cannot Modify Default Data Type|  | | <a name=\"128\">128</a>|Group Already Exists|  | | <a name=\"129\">129</a>|No Such Data Type|  | | <a name=\"130\">130</a>|Undefined Value For Data Type|  | | <a name=\"131\">131</a>|Unsupported Value Type Defined On Data Type|  | | <a name=\"132\">132</a>|Validation Error|  | | <a name=\"133\">133</a>|Loop Detected In Group Hierarchy|  | | <a name=\"134\">134</a>|Undefined Acceptable Values|  | | <a name=\"135\">135</a>|Sub Group Already Exists|  | | <a name=\"138\">138</a>|Price Source Not Found|  | | <a name=\"139\">139</a>|Analytic Store Not Found|  | | <a name=\"141\">141</a>|Analytic Store Already Exists|  | | <a name=\"143\">143</a>|Client Instrument Already Exists|  | | <a name=\"144\">144</a>|Duplicate In Parameter Set|  | | <a name=\"147\">147</a>|Results Not Found|  | | <a name=\"148\">148</a>|Order Field Not In Result Set|  | | <a name=\"149\">149</a>|Operation Failed|  | | <a name=\"150\">150</a>|Elastic Search Error|  | | <a name=\"151\">151</a>|Invalid Parameter Value|  | | <a name=\"153\">153</a>|Command Processing Failure|  | | <a name=\"154\">154</a>|Entity State Construction Failure|  | | <a name=\"155\">155</a>|Entity Timeline Does Not Exist|  | | <a name=\"156\">156</a>|Concurrency Conflict Failure|  | | <a name=\"157\">157</a>|Invalid Request|  | | <a name=\"158\">158</a>|Event Publish Unknown|  | | <a name=\"159\">159</a>|Event Query Failure|  | | <a name=\"160\">160</a>|Blob Did Not Exist|  | | <a name=\"162\">162</a>|Sub System Request Failure|  | | <a name=\"163\">163</a>|Sub System Configuration Failure|  | | <a name=\"165\">165</a>|Failed To Delete|  | | <a name=\"166\">166</a>|Upsert Client Instrument Failure|  | | <a name=\"167\">167</a>|Illegal As At Interval|  | | <a name=\"168\">168</a>|Illegal Bitemporal Query|  | | <a name=\"169\">169</a>|Invalid Alternate Id|  | | <a name=\"170\">170</a>|Cannot Add Source Portfolio Property Explicitly|  | | <a name=\"171\">171</a>|Entity Already Exists In Group|  | | <a name=\"173\">173</a>|Entity With Id Already Exists|  | | <a name=\"174\">174</a>|Derived Portfolio Details Do Not Exist|  | | <a name=\"176\">176</a>|Portfolio With Name Already Exists|  | | <a name=\"177\">177</a>|Invalid Transactions|  | | <a name=\"178\">178</a>|Reference Portfolio Not Found|  | | <a name=\"179\">179</a>|Duplicate Id|  | | <a name=\"180\">180</a>|Command Retrieval Failure|  | | <a name=\"181\">181</a>|Data Filter Application Failure|  | | <a name=\"182\">182</a>|Search Failed|  | | <a name=\"183\">183</a>|Movements Engine Configuration Key Failure|  | | <a name=\"184\">184</a>|Fx Rate Source Not Found|  | | <a name=\"185\">185</a>|Accrual Source Not Found|  | | <a name=\"186\">186</a>|Access Denied|  | | <a name=\"187\">187</a>|Invalid Identity Token|  | | <a name=\"188\">188</a>|Invalid Request Headers|  | | <a name=\"189\">189</a>|Price Not Found|  | | <a name=\"190\">190</a>|Invalid Sub Holding Keys Provided|  | | <a name=\"191\">191</a>|Duplicate Sub Holding Keys Provided|  | | <a name=\"192\">192</a>|Cut Definition Not Found|  | | <a name=\"193\">193</a>|Cut Definition Invalid|  | | <a name=\"194\">194</a>|Time Variant Property Deletion Date Unspecified|  | | <a name=\"195\">195</a>|Perpetual Property Deletion Date Specified|  | | <a name=\"196\">196</a>|Time Variant Property Upsert Date Unspecified|  | | <a name=\"197\">197</a>|Perpetual Property Upsert Date Specified|  | | <a name=\"200\">200</a>|Invalid Unit For Data Type|  | | <a name=\"201\">201</a>|Invalid Type For Data Type|  | | <a name=\"202\">202</a>|Invalid Value For Data Type|  | | <a name=\"203\">203</a>|Unit Not Defined For Data Type|  | | <a name=\"204\">204</a>|Units Not Supported On Data Type|  | | <a name=\"205\">205</a>|Cannot Specify Units On Data Type|  | | <a name=\"206\">206</a>|Unit Schema Inconsistent With Data Type|  | | <a name=\"207\">207</a>|Unit Definition Not Specified|  | | <a name=\"208\">208</a>|Duplicate Unit Definitions Specified|  | | <a name=\"209\">209</a>|Invalid Units Definition|  | | <a name=\"210\">210</a>|Invalid Instrument Identifier Unit|  | | <a name=\"211\">211</a>|Holdings Adjustment Does Not Exist|  | | <a name=\"212\">212</a>|Could Not Build Excel Url|  | | <a name=\"213\">213</a>|Could Not Get Excel Version|  | | <a name=\"214\">214</a>|Instrument By Code Not Found|  | | <a name=\"215\">215</a>|Entity Schema Does Not Exist|  | | <a name=\"216\">216</a>|Feature Not Supported On Portfolio Type|  | | <a name=\"217\">217</a>|Quote Not Found|  | | <a name=\"218\">218</a>|Invalid Quote Identifier|  | | <a name=\"219\">219</a>|Invalid Metric For Data Type|  | | <a name=\"220\">220</a>|Invalid Instrument Definition|  | | <a name=\"221\">221</a>|Instrument Upsert Failure|  | | <a name=\"222\">222</a>|Reference Portfolio Request Not Supported|  | | <a name=\"223\">223</a>|Transaction Portfolio Request Not Supported|  | | <a name=\"224\">224</a>|Invalid Property Value Assignment|  | | <a name=\"230\">230</a>|Transaction Type Not Found|  | | <a name=\"231\">231</a>|Transaction Type Duplication|  | | <a name=\"232\">232</a>|Portfolio Does Not Exist At Given Date|  | | <a name=\"233\">233</a>|Query Parser Failure|  | | <a name=\"234\">234</a>|Duplicate Constituent|  | | <a name=\"235\">235</a>|Unresolved Instrument Constituent|  | | <a name=\"236\">236</a>|Unresolved Instrument In Transition|  | | <a name=\"237\">237</a>|Missing Side Definitions|  | | <a name=\"299\">299</a>|Invalid Recipe|  | | <a name=\"300\">300</a>|Missing Recipe|  | | <a name=\"301\">301</a>|Dependencies|  | | <a name=\"304\">304</a>|Portfolio Preprocess Failure|  | | <a name=\"310\">310</a>|Valuation Engine Failure|  | | <a name=\"311\">311</a>|Task Factory Failure|  | | <a name=\"312\">312</a>|Task Evaluation Failure|  | | <a name=\"313\">313</a>|Task Generation Failure|  | | <a name=\"314\">314</a>|Engine Configuration Failure|  | | <a name=\"315\">315</a>|Model Specification Failure|  | | <a name=\"320\">320</a>|Market Data Key Failure|  | | <a name=\"321\">321</a>|Market Resolver Failure|  | | <a name=\"322\">322</a>|Market Data Failure|  | | <a name=\"330\">330</a>|Curve Failure|  | | <a name=\"331\">331</a>|Volatility Surface Failure|  | | <a name=\"332\">332</a>|Volatility Cube Failure|  | | <a name=\"350\">350</a>|Instrument Failure|  | | <a name=\"351\">351</a>|Cash Flows Failure|  | | <a name=\"352\">352</a>|Reference Data Failure|  | | <a name=\"360\">360</a>|Aggregation Failure|  | | <a name=\"361\">361</a>|Aggregation Measure Failure|  | | <a name=\"370\">370</a>|Result Retrieval Failure|  | | <a name=\"371\">371</a>|Result Processing Failure|  | | <a name=\"372\">372</a>|Vendor Result Processing Failure|  | | <a name=\"373\">373</a>|Vendor Result Mapping Failure|  | | <a name=\"374\">374</a>|Vendor Library Unauthorised|  | | <a name=\"375\">375</a>|Vendor Connectivity Error|  | | <a name=\"376\">376</a>|Vendor Interface Error|  | | <a name=\"377\">377</a>|Vendor Pricing Failure|  | | <a name=\"378\">378</a>|Vendor Translation Failure|  | | <a name=\"379\">379</a>|Vendor Key Mapping Failure|  | | <a name=\"380\">380</a>|Vendor Reflection Failure|  | | <a name=\"390\">390</a>|Attempt To Upsert Duplicate Quotes|  | | <a name=\"391\">391</a>|Corporate Action Source Does Not Exist|  | | <a name=\"392\">392</a>|Corporate Action Source Already Exists|  | | <a name=\"393\">393</a>|Instrument Identifier Already In Use|  | | <a name=\"394\">394</a>|Properties Not Found|  | | <a name=\"395\">395</a>|Batch Operation Aborted|  | | <a name=\"400\">400</a>|Invalid Iso4217 Currency Code|  | | <a name=\"401\">401</a>|Cannot Assign Instrument Identifier To Currency|  | | <a name=\"402\">402</a>|Cannot Assign Currency Identifier To Non Currency|  | | <a name=\"403\">403</a>|Currency Instrument Cannot Be Deleted|  | | <a name=\"404\">404</a>|Currency Instrument Cannot Have Economic Definition|  | | <a name=\"405\">405</a>|Currency Instrument Cannot Have Lookthrough Portfolio|  | | <a name=\"406\">406</a>|Cannot Create Currency Instrument With Multiple Identifiers|  | | <a name=\"407\">407</a>|Specified Currency Is Undefined|  | | <a name=\"410\">410</a>|Index Does Not Exist|  | | <a name=\"411\">411</a>|Sort Field Does Not Exist|  | | <a name=\"413\">413</a>|Negative Pagination Parameters|  | | <a name=\"414\">414</a>|Invalid Search Syntax|  | | <a name=\"415\">415</a>|Filter Execution Timeout|  | | <a name=\"420\">420</a>|Side Definition Inconsistent|  | | <a name=\"450\">450</a>|Invalid Quote Access Metadata Rule|  | | <a name=\"451\">451</a>|Access Metadata Not Found|  | | <a name=\"452\">452</a>|Invalid Access Metadata Identifier|  | | <a name=\"460\">460</a>|Standard Resource Not Found|  | | <a name=\"461\">461</a>|Standard Resource Conflict|  | | <a name=\"462\">462</a>|Calendar Not Found|  | | <a name=\"463\">463</a>|Date In A Calendar Not Found|  | | <a name=\"464\">464</a>|Invalid Date Source Data|  | | <a name=\"465\">465</a>|Invalid Timezone|  | | <a name=\"601\">601</a>|Person Identifier Already In Use|  | | <a name=\"602\">602</a>|Person Not Found|  | | <a name=\"603\">603</a>|Cannot Set Identifier|  | | <a name=\"617\">617</a>|Invalid Recipe Specification In Request|  | | <a name=\"618\">618</a>|Inline Recipe Deserialisation Failure|  | | <a name=\"619\">619</a>|Identifier Types Not Set For Entity|  | | <a name=\"620\">620</a>|Cannot Delete All Client Defined Identifiers|  | | <a name=\"650\">650</a>|The Order requested was not found.|  | | <a name=\"654\">654</a>|The Allocation requested was not found.|  | | <a name=\"655\">655</a>|Cannot build the fx forward target with the given holdings.|  | | <a name=\"656\">656</a>|Group does not contain expected entities.|  | | <a name=\"667\">667</a>|Relation definition already exists|  | | <a name=\"673\">673</a>|Missing entitlements for entities in Group|  | | <a name=\"674\">674</a>|Next Best Action not found|  | | <a name=\"676\">676</a>|Relation definition not defined|  | | <a name=\"677\">677</a>|Invalid entity identifier for relation|  | | <a name=\"681\">681</a>|Sorting by specified field not supported|One or more of the provided fields to order by were either invalid or not supported. | | <a name=\"682\">682</a>|Too many fields to sort by|The number of fields to sort the data by exceeds the number allowed by the endpoint | | <a name=\"684\">684</a>|Sequence Not Found|  | | <a name=\"685\">685</a>|Sequence Already Exists|  | | <a name=\"686\">686</a>|Non-cycling sequence has been exhausted|  | | <a name=\"687\">687</a>|Legal Entity Identifier Already In Use|  | | <a name=\"688\">688</a>|Legal Entity Not Found|  | | <a name=\"689\">689</a>|The supplied pagination token is invalid|  | | <a name=\"690\">690</a>|Property Type Is Not Supported|  | | <a name=\"691\">691</a>|Multiple Tax-lots For Currency Type Is Not Supported|  | | <a name=\"692\">692</a>|This endpoint does not support impersonation|  | | <a name=\"693\">693</a>|Entity type is not supported for Relationship|  | | <a name=\"694\">694</a>|Relationship Validation Failure|  | | <a name=\"695\">695</a>|Relationship Not Found|  | | <a name=\"697\">697</a>|Derived Property Formula No Longer Valid|  | | <a name=\"698\">698</a>|Story is not available|  | | <a name=\"703\">703</a>|Corporate Action Does Not Exist|  | 
 *
 * The version of the OpenAPI document: 0.11.3028-MARK
 * Contact: info@finbourne.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.finbourne.lusid.api;

import com.finbourne.lusid.ApiCallback;
import com.finbourne.lusid.ApiClient;
import com.finbourne.lusid.ApiException;
import com.finbourne.lusid.ApiResponse;
import com.finbourne.lusid.Configuration;
import com.finbourne.lusid.Pair;
import com.finbourne.lusid.ProgressRequestBody;
import com.finbourne.lusid.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import com.finbourne.lusid.model.AccessMetadataValue;
import com.finbourne.lusid.model.DeletedEntityResponse;
import com.finbourne.lusid.model.LegalEntity;
import com.finbourne.lusid.model.LusidProblemDetails;
import com.finbourne.lusid.model.LusidValidationProblemDetails;
import java.time.OffsetDateTime;
import com.finbourne.lusid.model.PagedResourceListOfLegalEntity;
import com.finbourne.lusid.model.ResourceListOfAccessMetadataValueOf;
import com.finbourne.lusid.model.ResourceListOfPropertyInterval;
import com.finbourne.lusid.model.ResourceListOfRelation;
import com.finbourne.lusid.model.ResourceListOfRelationship;
import com.finbourne.lusid.model.UpsertLegalEntityAccessMetadataRequest;
import com.finbourne.lusid.model.UpsertLegalEntityRequest;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LegalEntitiesApi {
    private ApiClient localVarApiClient;
    public LegalEntitiesApi() {
        this(Configuration.getDefaultApiClient());
    }

    public LegalEntitiesApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for deleteLegalEntity
     * @param idTypeScope The scope of the legal entity identifier type. (required)
     * @param idTypeCode The code of the legal entity identifier type. (required)
     * @param code Code of the legal entity under specified identifier type&#39;s scope and code. This together with defined              identifier type uniquely identifies the legal entity to delete. (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The response from deleting legal entity. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call deleteLegalEntityCall(String idTypeScope, String idTypeCode, String code, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/legalentities/{idTypeScope}/{idTypeCode}/{code}"
            .replaceAll("\\{" + "idTypeScope" + "\\}", localVarApiClient.escapeString(idTypeScope.toString()))
            .replaceAll("\\{" + "idTypeCode" + "\\}", localVarApiClient.escapeString(idTypeCode.toString()))
            .replaceAll("\\{" + "code" + "\\}", localVarApiClient.escapeString(code.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "text/plain", "application/json", "text/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);
        localVarHeaderParams.put("X-LUSID-SDK-Language", "Java");
        localVarHeaderParams.put("X-LUSID-SDK-Version", "0.11.3028-MARK");

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call deleteLegalEntityValidateBeforeCall(String idTypeScope, String idTypeCode, String code, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'idTypeScope' is set
        if (idTypeScope == null) {
            throw new ApiException("Missing the required parameter 'idTypeScope' when calling deleteLegalEntity(Async)");
        }
        
        // verify the required parameter 'idTypeCode' is set
        if (idTypeCode == null) {
            throw new ApiException("Missing the required parameter 'idTypeCode' when calling deleteLegalEntity(Async)");
        }
        
        // verify the required parameter 'code' is set
        if (code == null) {
            throw new ApiException("Missing the required parameter 'code' when calling deleteLegalEntity(Async)");
        }
        

        okhttp3.Call localVarCall = deleteLegalEntityCall(idTypeScope, idTypeCode, code, _callback);
        return localVarCall;

    }

    /**
     * [EARLY ACCESS] Delete Legal Entity
     * Delete a legal entity. Deletion will be valid from the legal entity&#39;s creation datetime.  This means that the legal entity will no longer exist at any effective datetime from the asAt datetime of deletion.
     * @param idTypeScope The scope of the legal entity identifier type. (required)
     * @param idTypeCode The code of the legal entity identifier type. (required)
     * @param code Code of the legal entity under specified identifier type&#39;s scope and code. This together with defined              identifier type uniquely identifies the legal entity to delete. (required)
     * @return DeletedEntityResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The response from deleting legal entity. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public DeletedEntityResponse deleteLegalEntity(String idTypeScope, String idTypeCode, String code) throws ApiException {
        ApiResponse<DeletedEntityResponse> localVarResp = deleteLegalEntityWithHttpInfo(idTypeScope, idTypeCode, code);
        return localVarResp.getData();
    }

    /**
     * [EARLY ACCESS] Delete Legal Entity
     * Delete a legal entity. Deletion will be valid from the legal entity&#39;s creation datetime.  This means that the legal entity will no longer exist at any effective datetime from the asAt datetime of deletion.
     * @param idTypeScope The scope of the legal entity identifier type. (required)
     * @param idTypeCode The code of the legal entity identifier type. (required)
     * @param code Code of the legal entity under specified identifier type&#39;s scope and code. This together with defined              identifier type uniquely identifies the legal entity to delete. (required)
     * @return ApiResponse&lt;DeletedEntityResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The response from deleting legal entity. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<DeletedEntityResponse> deleteLegalEntityWithHttpInfo(String idTypeScope, String idTypeCode, String code) throws ApiException {
        okhttp3.Call localVarCall = deleteLegalEntityValidateBeforeCall(idTypeScope, idTypeCode, code, null);
        Type localVarReturnType = new TypeToken<DeletedEntityResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * [EARLY ACCESS] Delete Legal Entity (asynchronously)
     * Delete a legal entity. Deletion will be valid from the legal entity&#39;s creation datetime.  This means that the legal entity will no longer exist at any effective datetime from the asAt datetime of deletion.
     * @param idTypeScope The scope of the legal entity identifier type. (required)
     * @param idTypeCode The code of the legal entity identifier type. (required)
     * @param code Code of the legal entity under specified identifier type&#39;s scope and code. This together with defined              identifier type uniquely identifies the legal entity to delete. (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The response from deleting legal entity. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call deleteLegalEntityAsync(String idTypeScope, String idTypeCode, String code, final ApiCallback<DeletedEntityResponse> _callback) throws ApiException {
        okhttp3.Call localVarCall = deleteLegalEntityValidateBeforeCall(idTypeScope, idTypeCode, code, _callback);
        Type localVarReturnType = new TypeToken<DeletedEntityResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for deleteLegalEntityAccessMetadata
     * @param idTypeScope Scope of the Legal Entity identifier. (required)
     * @param idTypeCode Code of the Legal Entity identifier. (required)
     * @param code Code of the Legal Entity under specified identifier type&#39;s scope and code. (required)
     * @param metadataKey Key of the metadata entry to retrieve (required)
     * @param effectiveAt The effective date to delete at, if this is not supplied, it will delete all data found (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The Access Metadata with the given metadataKey has been deleted </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call deleteLegalEntityAccessMetadataCall(String idTypeScope, String idTypeCode, String code, String metadataKey, String effectiveAt, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/legalentities/{idTypeScope}/{idTypeCode}/{code}/metadata/{metadataKey}"
            .replaceAll("\\{" + "idTypeScope" + "\\}", localVarApiClient.escapeString(idTypeScope.toString()))
            .replaceAll("\\{" + "idTypeCode" + "\\}", localVarApiClient.escapeString(idTypeCode.toString()))
            .replaceAll("\\{" + "code" + "\\}", localVarApiClient.escapeString(code.toString()))
            .replaceAll("\\{" + "metadataKey" + "\\}", localVarApiClient.escapeString(metadataKey.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (effectiveAt != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("effectiveAt", effectiveAt));
        }

        final String[] localVarAccepts = {
            "text/plain", "application/json", "text/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);
        localVarHeaderParams.put("X-LUSID-SDK-Language", "Java");
        localVarHeaderParams.put("X-LUSID-SDK-Version", "0.11.3028-MARK");

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call deleteLegalEntityAccessMetadataValidateBeforeCall(String idTypeScope, String idTypeCode, String code, String metadataKey, String effectiveAt, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'idTypeScope' is set
        if (idTypeScope == null) {
            throw new ApiException("Missing the required parameter 'idTypeScope' when calling deleteLegalEntityAccessMetadata(Async)");
        }
        
        // verify the required parameter 'idTypeCode' is set
        if (idTypeCode == null) {
            throw new ApiException("Missing the required parameter 'idTypeCode' when calling deleteLegalEntityAccessMetadata(Async)");
        }
        
        // verify the required parameter 'code' is set
        if (code == null) {
            throw new ApiException("Missing the required parameter 'code' when calling deleteLegalEntityAccessMetadata(Async)");
        }
        
        // verify the required parameter 'metadataKey' is set
        if (metadataKey == null) {
            throw new ApiException("Missing the required parameter 'metadataKey' when calling deleteLegalEntityAccessMetadata(Async)");
        }
        

        okhttp3.Call localVarCall = deleteLegalEntityAccessMetadataCall(idTypeScope, idTypeCode, code, metadataKey, effectiveAt, _callback);
        return localVarCall;

    }

    /**
     * [EXPERIMENTAL] Delete a Legal Entity Access Metadata entry
     * Deletes the Legal Entity Access Metadata entry that exactly matches the provided identifier parts.    It is important to always check to verify success (or failure).
     * @param idTypeScope Scope of the Legal Entity identifier. (required)
     * @param idTypeCode Code of the Legal Entity identifier. (required)
     * @param code Code of the Legal Entity under specified identifier type&#39;s scope and code. (required)
     * @param metadataKey Key of the metadata entry to retrieve (required)
     * @param effectiveAt The effective date to delete at, if this is not supplied, it will delete all data found (optional)
     * @return DeletedEntityResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The Access Metadata with the given metadataKey has been deleted </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public DeletedEntityResponse deleteLegalEntityAccessMetadata(String idTypeScope, String idTypeCode, String code, String metadataKey, String effectiveAt) throws ApiException {
        ApiResponse<DeletedEntityResponse> localVarResp = deleteLegalEntityAccessMetadataWithHttpInfo(idTypeScope, idTypeCode, code, metadataKey, effectiveAt);
        return localVarResp.getData();
    }

    /**
     * [EXPERIMENTAL] Delete a Legal Entity Access Metadata entry
     * Deletes the Legal Entity Access Metadata entry that exactly matches the provided identifier parts.    It is important to always check to verify success (or failure).
     * @param idTypeScope Scope of the Legal Entity identifier. (required)
     * @param idTypeCode Code of the Legal Entity identifier. (required)
     * @param code Code of the Legal Entity under specified identifier type&#39;s scope and code. (required)
     * @param metadataKey Key of the metadata entry to retrieve (required)
     * @param effectiveAt The effective date to delete at, if this is not supplied, it will delete all data found (optional)
     * @return ApiResponse&lt;DeletedEntityResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The Access Metadata with the given metadataKey has been deleted </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<DeletedEntityResponse> deleteLegalEntityAccessMetadataWithHttpInfo(String idTypeScope, String idTypeCode, String code, String metadataKey, String effectiveAt) throws ApiException {
        okhttp3.Call localVarCall = deleteLegalEntityAccessMetadataValidateBeforeCall(idTypeScope, idTypeCode, code, metadataKey, effectiveAt, null);
        Type localVarReturnType = new TypeToken<DeletedEntityResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * [EXPERIMENTAL] Delete a Legal Entity Access Metadata entry (asynchronously)
     * Deletes the Legal Entity Access Metadata entry that exactly matches the provided identifier parts.    It is important to always check to verify success (or failure).
     * @param idTypeScope Scope of the Legal Entity identifier. (required)
     * @param idTypeCode Code of the Legal Entity identifier. (required)
     * @param code Code of the Legal Entity under specified identifier type&#39;s scope and code. (required)
     * @param metadataKey Key of the metadata entry to retrieve (required)
     * @param effectiveAt The effective date to delete at, if this is not supplied, it will delete all data found (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The Access Metadata with the given metadataKey has been deleted </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call deleteLegalEntityAccessMetadataAsync(String idTypeScope, String idTypeCode, String code, String metadataKey, String effectiveAt, final ApiCallback<DeletedEntityResponse> _callback) throws ApiException {
        okhttp3.Call localVarCall = deleteLegalEntityAccessMetadataValidateBeforeCall(idTypeScope, idTypeCode, code, metadataKey, effectiveAt, _callback);
        Type localVarReturnType = new TypeToken<DeletedEntityResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getAllLegalEntityAccessMetadata
     * @param idTypeScope Scope of the Legal Entity identifier. (required)
     * @param idTypeCode Code of the Legal Entity identifier. (required)
     * @param code Code of the Legal Entity under specified identifier type&#39;s scope and code. (required)
     * @param effectiveAt The effectiveAt datetime at which to retrieve the Access Metadata (optional)
     * @param asAt The asAt datetime at which to retrieve the Access Metadata (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The access metadata for the Legal Entity or any failure. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getAllLegalEntityAccessMetadataCall(String idTypeScope, String idTypeCode, String code, String effectiveAt, OffsetDateTime asAt, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/legalentities/{idTypeScope}/{idTypeCode}/{code}/metadata"
            .replaceAll("\\{" + "idTypeScope" + "\\}", localVarApiClient.escapeString(idTypeScope.toString()))
            .replaceAll("\\{" + "idTypeCode" + "\\}", localVarApiClient.escapeString(idTypeCode.toString()))
            .replaceAll("\\{" + "code" + "\\}", localVarApiClient.escapeString(code.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (effectiveAt != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("effectiveAt", effectiveAt));
        }

        if (asAt != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("asAt", asAt));
        }

        final String[] localVarAccepts = {
            "text/plain", "application/json", "text/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);
        localVarHeaderParams.put("X-LUSID-SDK-Language", "Java");
        localVarHeaderParams.put("X-LUSID-SDK-Version", "0.11.3028-MARK");

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getAllLegalEntityAccessMetadataValidateBeforeCall(String idTypeScope, String idTypeCode, String code, String effectiveAt, OffsetDateTime asAt, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'idTypeScope' is set
        if (idTypeScope == null) {
            throw new ApiException("Missing the required parameter 'idTypeScope' when calling getAllLegalEntityAccessMetadata(Async)");
        }
        
        // verify the required parameter 'idTypeCode' is set
        if (idTypeCode == null) {
            throw new ApiException("Missing the required parameter 'idTypeCode' when calling getAllLegalEntityAccessMetadata(Async)");
        }
        
        // verify the required parameter 'code' is set
        if (code == null) {
            throw new ApiException("Missing the required parameter 'code' when calling getAllLegalEntityAccessMetadata(Async)");
        }
        

        okhttp3.Call localVarCall = getAllLegalEntityAccessMetadataCall(idTypeScope, idTypeCode, code, effectiveAt, asAt, _callback);
        return localVarCall;

    }

    /**
     * [EXPERIMENTAL] Get Access Metadata rules for a Legal Entity
     * Pass the Scope and Code of the Legal Entity identifier along with the Legal Entity code parameter to retrieve the associated Access Metadata
     * @param idTypeScope Scope of the Legal Entity identifier. (required)
     * @param idTypeCode Code of the Legal Entity identifier. (required)
     * @param code Code of the Legal Entity under specified identifier type&#39;s scope and code. (required)
     * @param effectiveAt The effectiveAt datetime at which to retrieve the Access Metadata (optional)
     * @param asAt The asAt datetime at which to retrieve the Access Metadata (optional)
     * @return Map&lt;String, List&lt;AccessMetadataValue&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The access metadata for the Legal Entity or any failure. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public Map<String, List<AccessMetadataValue>> getAllLegalEntityAccessMetadata(String idTypeScope, String idTypeCode, String code, String effectiveAt, OffsetDateTime asAt) throws ApiException {
        ApiResponse<Map<String, List<AccessMetadataValue>>> localVarResp = getAllLegalEntityAccessMetadataWithHttpInfo(idTypeScope, idTypeCode, code, effectiveAt, asAt);
        return localVarResp.getData();
    }

    /**
     * [EXPERIMENTAL] Get Access Metadata rules for a Legal Entity
     * Pass the Scope and Code of the Legal Entity identifier along with the Legal Entity code parameter to retrieve the associated Access Metadata
     * @param idTypeScope Scope of the Legal Entity identifier. (required)
     * @param idTypeCode Code of the Legal Entity identifier. (required)
     * @param code Code of the Legal Entity under specified identifier type&#39;s scope and code. (required)
     * @param effectiveAt The effectiveAt datetime at which to retrieve the Access Metadata (optional)
     * @param asAt The asAt datetime at which to retrieve the Access Metadata (optional)
     * @return ApiResponse&lt;Map&lt;String, List&lt;AccessMetadataValue&gt;&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The access metadata for the Legal Entity or any failure. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Map<String, List<AccessMetadataValue>>> getAllLegalEntityAccessMetadataWithHttpInfo(String idTypeScope, String idTypeCode, String code, String effectiveAt, OffsetDateTime asAt) throws ApiException {
        okhttp3.Call localVarCall = getAllLegalEntityAccessMetadataValidateBeforeCall(idTypeScope, idTypeCode, code, effectiveAt, asAt, null);
        Type localVarReturnType = new TypeToken<Map<String, List<AccessMetadataValue>>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * [EXPERIMENTAL] Get Access Metadata rules for a Legal Entity (asynchronously)
     * Pass the Scope and Code of the Legal Entity identifier along with the Legal Entity code parameter to retrieve the associated Access Metadata
     * @param idTypeScope Scope of the Legal Entity identifier. (required)
     * @param idTypeCode Code of the Legal Entity identifier. (required)
     * @param code Code of the Legal Entity under specified identifier type&#39;s scope and code. (required)
     * @param effectiveAt The effectiveAt datetime at which to retrieve the Access Metadata (optional)
     * @param asAt The asAt datetime at which to retrieve the Access Metadata (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The access metadata for the Legal Entity or any failure. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getAllLegalEntityAccessMetadataAsync(String idTypeScope, String idTypeCode, String code, String effectiveAt, OffsetDateTime asAt, final ApiCallback<Map<String, List<AccessMetadataValue>>> _callback) throws ApiException {
        okhttp3.Call localVarCall = getAllLegalEntityAccessMetadataValidateBeforeCall(idTypeScope, idTypeCode, code, effectiveAt, asAt, _callback);
        Type localVarReturnType = new TypeToken<Map<String, List<AccessMetadataValue>>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getLegalEntity
     * @param idTypeScope Scope of the legal entity identifier type. (required)
     * @param idTypeCode Code of the legal entity identifier type. (required)
     * @param code Code of the legal entity under specified identifier type&#39;s scope and code. This together with stated identifier type uniquely              identifies the legal entity. (required)
     * @param propertyKeys A list of property keys or identifier types (as property keys) from the \&quot;LegalEntity\&quot; domain to include for found legal entity.              These take the format {domain}/{scope}/{code} e.g. \&quot;LegalEntity/ContactDetails/Address\&quot;. (optional)
     * @param effectiveAt The effective datetime or cut label at which to retrieve the legal entity. Defaults to the current LUSID system datetime if not specified. (optional)
     * @param asAt The asAt datetime at which to retrieve the legal entity. Defaults to return the latest version of the legal entity if not specified. (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The requested legal entity </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getLegalEntityCall(String idTypeScope, String idTypeCode, String code, List<String> propertyKeys, String effectiveAt, OffsetDateTime asAt, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/legalentities/{idTypeScope}/{idTypeCode}/{code}"
            .replaceAll("\\{" + "idTypeScope" + "\\}", localVarApiClient.escapeString(idTypeScope.toString()))
            .replaceAll("\\{" + "idTypeCode" + "\\}", localVarApiClient.escapeString(idTypeCode.toString()))
            .replaceAll("\\{" + "code" + "\\}", localVarApiClient.escapeString(code.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (propertyKeys != null) {
            localVarCollectionQueryParams.addAll(localVarApiClient.parameterToPairs("multi", "propertyKeys", propertyKeys));
        }

        if (effectiveAt != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("effectiveAt", effectiveAt));
        }

        if (asAt != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("asAt", asAt));
        }

        final String[] localVarAccepts = {
            "text/plain", "application/json", "text/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);
        localVarHeaderParams.put("X-LUSID-SDK-Language", "Java");
        localVarHeaderParams.put("X-LUSID-SDK-Version", "0.11.3028-MARK");

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getLegalEntityValidateBeforeCall(String idTypeScope, String idTypeCode, String code, List<String> propertyKeys, String effectiveAt, OffsetDateTime asAt, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'idTypeScope' is set
        if (idTypeScope == null) {
            throw new ApiException("Missing the required parameter 'idTypeScope' when calling getLegalEntity(Async)");
        }
        
        // verify the required parameter 'idTypeCode' is set
        if (idTypeCode == null) {
            throw new ApiException("Missing the required parameter 'idTypeCode' when calling getLegalEntity(Async)");
        }
        
        // verify the required parameter 'code' is set
        if (code == null) {
            throw new ApiException("Missing the required parameter 'code' when calling getLegalEntity(Async)");
        }
        

        okhttp3.Call localVarCall = getLegalEntityCall(idTypeScope, idTypeCode, code, propertyKeys, effectiveAt, asAt, _callback);
        return localVarCall;

    }

    /**
     * [EARLY ACCESS] Get Legal Entity
     * Retrieve the definition of a legal entity.
     * @param idTypeScope Scope of the legal entity identifier type. (required)
     * @param idTypeCode Code of the legal entity identifier type. (required)
     * @param code Code of the legal entity under specified identifier type&#39;s scope and code. This together with stated identifier type uniquely              identifies the legal entity. (required)
     * @param propertyKeys A list of property keys or identifier types (as property keys) from the \&quot;LegalEntity\&quot; domain to include for found legal entity.              These take the format {domain}/{scope}/{code} e.g. \&quot;LegalEntity/ContactDetails/Address\&quot;. (optional)
     * @param effectiveAt The effective datetime or cut label at which to retrieve the legal entity. Defaults to the current LUSID system datetime if not specified. (optional)
     * @param asAt The asAt datetime at which to retrieve the legal entity. Defaults to return the latest version of the legal entity if not specified. (optional)
     * @return LegalEntity
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The requested legal entity </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public LegalEntity getLegalEntity(String idTypeScope, String idTypeCode, String code, List<String> propertyKeys, String effectiveAt, OffsetDateTime asAt) throws ApiException {
        ApiResponse<LegalEntity> localVarResp = getLegalEntityWithHttpInfo(idTypeScope, idTypeCode, code, propertyKeys, effectiveAt, asAt);
        return localVarResp.getData();
    }

    /**
     * [EARLY ACCESS] Get Legal Entity
     * Retrieve the definition of a legal entity.
     * @param idTypeScope Scope of the legal entity identifier type. (required)
     * @param idTypeCode Code of the legal entity identifier type. (required)
     * @param code Code of the legal entity under specified identifier type&#39;s scope and code. This together with stated identifier type uniquely              identifies the legal entity. (required)
     * @param propertyKeys A list of property keys or identifier types (as property keys) from the \&quot;LegalEntity\&quot; domain to include for found legal entity.              These take the format {domain}/{scope}/{code} e.g. \&quot;LegalEntity/ContactDetails/Address\&quot;. (optional)
     * @param effectiveAt The effective datetime or cut label at which to retrieve the legal entity. Defaults to the current LUSID system datetime if not specified. (optional)
     * @param asAt The asAt datetime at which to retrieve the legal entity. Defaults to return the latest version of the legal entity if not specified. (optional)
     * @return ApiResponse&lt;LegalEntity&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The requested legal entity </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<LegalEntity> getLegalEntityWithHttpInfo(String idTypeScope, String idTypeCode, String code, List<String> propertyKeys, String effectiveAt, OffsetDateTime asAt) throws ApiException {
        okhttp3.Call localVarCall = getLegalEntityValidateBeforeCall(idTypeScope, idTypeCode, code, propertyKeys, effectiveAt, asAt, null);
        Type localVarReturnType = new TypeToken<LegalEntity>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * [EARLY ACCESS] Get Legal Entity (asynchronously)
     * Retrieve the definition of a legal entity.
     * @param idTypeScope Scope of the legal entity identifier type. (required)
     * @param idTypeCode Code of the legal entity identifier type. (required)
     * @param code Code of the legal entity under specified identifier type&#39;s scope and code. This together with stated identifier type uniquely              identifies the legal entity. (required)
     * @param propertyKeys A list of property keys or identifier types (as property keys) from the \&quot;LegalEntity\&quot; domain to include for found legal entity.              These take the format {domain}/{scope}/{code} e.g. \&quot;LegalEntity/ContactDetails/Address\&quot;. (optional)
     * @param effectiveAt The effective datetime or cut label at which to retrieve the legal entity. Defaults to the current LUSID system datetime if not specified. (optional)
     * @param asAt The asAt datetime at which to retrieve the legal entity. Defaults to return the latest version of the legal entity if not specified. (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The requested legal entity </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getLegalEntityAsync(String idTypeScope, String idTypeCode, String code, List<String> propertyKeys, String effectiveAt, OffsetDateTime asAt, final ApiCallback<LegalEntity> _callback) throws ApiException {
        okhttp3.Call localVarCall = getLegalEntityValidateBeforeCall(idTypeScope, idTypeCode, code, propertyKeys, effectiveAt, asAt, _callback);
        Type localVarReturnType = new TypeToken<LegalEntity>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getLegalEntityAccessMetadataByKey
     * @param idTypeScope Scope of the Legal Entity identifier. (required)
     * @param idTypeCode Code of the Legal Entity identifier. (required)
     * @param code Code of the Legal Entity under specified identifier type&#39;s scope and code. (required)
     * @param metadataKey Key of the metadata entry to retrieve (required)
     * @param effectiveAt The effectiveAt datetime at which to retrieve the Access Metadata (optional)
     * @param asAt The asAt datetime at which to retrieve the Access Metadata (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The successfully retrieved Legal Entity access metadata filtered by metadataKey or any failure. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getLegalEntityAccessMetadataByKeyCall(String idTypeScope, String idTypeCode, String code, String metadataKey, String effectiveAt, OffsetDateTime asAt, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/legalentities/{idTypeScope}/{idTypeCode}/{code}/metadata/{metadataKey}"
            .replaceAll("\\{" + "idTypeScope" + "\\}", localVarApiClient.escapeString(idTypeScope.toString()))
            .replaceAll("\\{" + "idTypeCode" + "\\}", localVarApiClient.escapeString(idTypeCode.toString()))
            .replaceAll("\\{" + "code" + "\\}", localVarApiClient.escapeString(code.toString()))
            .replaceAll("\\{" + "metadataKey" + "\\}", localVarApiClient.escapeString(metadataKey.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (effectiveAt != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("effectiveAt", effectiveAt));
        }

        if (asAt != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("asAt", asAt));
        }

        final String[] localVarAccepts = {
            "text/plain", "application/json", "text/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);
        localVarHeaderParams.put("X-LUSID-SDK-Language", "Java");
        localVarHeaderParams.put("X-LUSID-SDK-Version", "0.11.3028-MARK");

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getLegalEntityAccessMetadataByKeyValidateBeforeCall(String idTypeScope, String idTypeCode, String code, String metadataKey, String effectiveAt, OffsetDateTime asAt, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'idTypeScope' is set
        if (idTypeScope == null) {
            throw new ApiException("Missing the required parameter 'idTypeScope' when calling getLegalEntityAccessMetadataByKey(Async)");
        }
        
        // verify the required parameter 'idTypeCode' is set
        if (idTypeCode == null) {
            throw new ApiException("Missing the required parameter 'idTypeCode' when calling getLegalEntityAccessMetadataByKey(Async)");
        }
        
        // verify the required parameter 'code' is set
        if (code == null) {
            throw new ApiException("Missing the required parameter 'code' when calling getLegalEntityAccessMetadataByKey(Async)");
        }
        
        // verify the required parameter 'metadataKey' is set
        if (metadataKey == null) {
            throw new ApiException("Missing the required parameter 'metadataKey' when calling getLegalEntityAccessMetadataByKey(Async)");
        }
        

        okhttp3.Call localVarCall = getLegalEntityAccessMetadataByKeyCall(idTypeScope, idTypeCode, code, metadataKey, effectiveAt, asAt, _callback);
        return localVarCall;

    }

    /**
     * [EXPERIMENTAL] Get an entry identified by a metadataKey in the Access Metadata of a Legal Entity
     * Get a specific Legal Entity Access Metadata by specifying the corresponding identifier parts and Legal Entity code                No matching will be performed through this endpoint. To retrieve an entry, it is necessary to specify, exactly, the identifier of the entry
     * @param idTypeScope Scope of the Legal Entity identifier. (required)
     * @param idTypeCode Code of the Legal Entity identifier. (required)
     * @param code Code of the Legal Entity under specified identifier type&#39;s scope and code. (required)
     * @param metadataKey Key of the metadata entry to retrieve (required)
     * @param effectiveAt The effectiveAt datetime at which to retrieve the Access Metadata (optional)
     * @param asAt The asAt datetime at which to retrieve the Access Metadata (optional)
     * @return List&lt;AccessMetadataValue&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The successfully retrieved Legal Entity access metadata filtered by metadataKey or any failure. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public List<AccessMetadataValue> getLegalEntityAccessMetadataByKey(String idTypeScope, String idTypeCode, String code, String metadataKey, String effectiveAt, OffsetDateTime asAt) throws ApiException {
        ApiResponse<List<AccessMetadataValue>> localVarResp = getLegalEntityAccessMetadataByKeyWithHttpInfo(idTypeScope, idTypeCode, code, metadataKey, effectiveAt, asAt);
        return localVarResp.getData();
    }

    /**
     * [EXPERIMENTAL] Get an entry identified by a metadataKey in the Access Metadata of a Legal Entity
     * Get a specific Legal Entity Access Metadata by specifying the corresponding identifier parts and Legal Entity code                No matching will be performed through this endpoint. To retrieve an entry, it is necessary to specify, exactly, the identifier of the entry
     * @param idTypeScope Scope of the Legal Entity identifier. (required)
     * @param idTypeCode Code of the Legal Entity identifier. (required)
     * @param code Code of the Legal Entity under specified identifier type&#39;s scope and code. (required)
     * @param metadataKey Key of the metadata entry to retrieve (required)
     * @param effectiveAt The effectiveAt datetime at which to retrieve the Access Metadata (optional)
     * @param asAt The asAt datetime at which to retrieve the Access Metadata (optional)
     * @return ApiResponse&lt;List&lt;AccessMetadataValue&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The successfully retrieved Legal Entity access metadata filtered by metadataKey or any failure. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<List<AccessMetadataValue>> getLegalEntityAccessMetadataByKeyWithHttpInfo(String idTypeScope, String idTypeCode, String code, String metadataKey, String effectiveAt, OffsetDateTime asAt) throws ApiException {
        okhttp3.Call localVarCall = getLegalEntityAccessMetadataByKeyValidateBeforeCall(idTypeScope, idTypeCode, code, metadataKey, effectiveAt, asAt, null);
        Type localVarReturnType = new TypeToken<List<AccessMetadataValue>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * [EXPERIMENTAL] Get an entry identified by a metadataKey in the Access Metadata of a Legal Entity (asynchronously)
     * Get a specific Legal Entity Access Metadata by specifying the corresponding identifier parts and Legal Entity code                No matching will be performed through this endpoint. To retrieve an entry, it is necessary to specify, exactly, the identifier of the entry
     * @param idTypeScope Scope of the Legal Entity identifier. (required)
     * @param idTypeCode Code of the Legal Entity identifier. (required)
     * @param code Code of the Legal Entity under specified identifier type&#39;s scope and code. (required)
     * @param metadataKey Key of the metadata entry to retrieve (required)
     * @param effectiveAt The effectiveAt datetime at which to retrieve the Access Metadata (optional)
     * @param asAt The asAt datetime at which to retrieve the Access Metadata (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The successfully retrieved Legal Entity access metadata filtered by metadataKey or any failure. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getLegalEntityAccessMetadataByKeyAsync(String idTypeScope, String idTypeCode, String code, String metadataKey, String effectiveAt, OffsetDateTime asAt, final ApiCallback<List<AccessMetadataValue>> _callback) throws ApiException {
        okhttp3.Call localVarCall = getLegalEntityAccessMetadataByKeyValidateBeforeCall(idTypeScope, idTypeCode, code, metadataKey, effectiveAt, asAt, _callback);
        Type localVarReturnType = new TypeToken<List<AccessMetadataValue>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getLegalEntityPropertyTimeSeries
     * @param idTypeScope Scope of the legal entity identifier type. (required)
     * @param idTypeCode Code of the legal entity identifier type. (required)
     * @param code Code of the legal entity under specified identifier type&#39;s scope and code. This together with stated identifier type uniquely identifies the legal entity. (required)
     * @param propertyKey The property key of the property that will have its history shown. These must be in the format {domain}/{scope}/{code} e.g. \&quot;LegalEntity/ContactDetails/Address\&quot;.              Each property must be from the \&quot;LegalEntity\&quot; domain. (optional)
     * @param asAt The asAt datetime at which to list the person&#39;s property history. Defaults to return the current datetime if not supplied. (optional)
     * @param filter Expression to filter the result set. Read more about filtering results from LUSID here https://support.lusid.com/filtering-results-from-lusid. (optional)
     * @param page The pagination token to use to continue listing properties from a previous call to get property time series.              This value is returned from the previous call. If a pagination token is provided the filter and asAt fields              must not have changed since the original request. (optional)
     * @param limit When paginating, limit the number of returned results to this many. (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The time series of the property </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getLegalEntityPropertyTimeSeriesCall(String idTypeScope, String idTypeCode, String code, String propertyKey, OffsetDateTime asAt, String filter, String page, Integer limit, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/legalentities/{idTypeScope}/{idTypeCode}/{code}/properties/time-series"
            .replaceAll("\\{" + "idTypeScope" + "\\}", localVarApiClient.escapeString(idTypeScope.toString()))
            .replaceAll("\\{" + "idTypeCode" + "\\}", localVarApiClient.escapeString(idTypeCode.toString()))
            .replaceAll("\\{" + "code" + "\\}", localVarApiClient.escapeString(code.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (propertyKey != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("propertyKey", propertyKey));
        }

        if (asAt != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("asAt", asAt));
        }

        if (filter != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("filter", filter));
        }

        if (page != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("page", page));
        }

        if (limit != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("limit", limit));
        }

        final String[] localVarAccepts = {
            "text/plain", "application/json", "text/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);
        localVarHeaderParams.put("X-LUSID-SDK-Language", "Java");
        localVarHeaderParams.put("X-LUSID-SDK-Version", "0.11.3028-MARK");

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getLegalEntityPropertyTimeSeriesValidateBeforeCall(String idTypeScope, String idTypeCode, String code, String propertyKey, OffsetDateTime asAt, String filter, String page, Integer limit, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'idTypeScope' is set
        if (idTypeScope == null) {
            throw new ApiException("Missing the required parameter 'idTypeScope' when calling getLegalEntityPropertyTimeSeries(Async)");
        }
        
        // verify the required parameter 'idTypeCode' is set
        if (idTypeCode == null) {
            throw new ApiException("Missing the required parameter 'idTypeCode' when calling getLegalEntityPropertyTimeSeries(Async)");
        }
        
        // verify the required parameter 'code' is set
        if (code == null) {
            throw new ApiException("Missing the required parameter 'code' when calling getLegalEntityPropertyTimeSeries(Async)");
        }
        

        okhttp3.Call localVarCall = getLegalEntityPropertyTimeSeriesCall(idTypeScope, idTypeCode, code, propertyKey, asAt, filter, page, limit, _callback);
        return localVarCall;

    }

    /**
     * [EXPERIMENTAL] Get Legal Entity Property Time Series
     * List the complete time series of a legal entity property.
     * @param idTypeScope Scope of the legal entity identifier type. (required)
     * @param idTypeCode Code of the legal entity identifier type. (required)
     * @param code Code of the legal entity under specified identifier type&#39;s scope and code. This together with stated identifier type uniquely identifies the legal entity. (required)
     * @param propertyKey The property key of the property that will have its history shown. These must be in the format {domain}/{scope}/{code} e.g. \&quot;LegalEntity/ContactDetails/Address\&quot;.              Each property must be from the \&quot;LegalEntity\&quot; domain. (optional)
     * @param asAt The asAt datetime at which to list the person&#39;s property history. Defaults to return the current datetime if not supplied. (optional)
     * @param filter Expression to filter the result set. Read more about filtering results from LUSID here https://support.lusid.com/filtering-results-from-lusid. (optional)
     * @param page The pagination token to use to continue listing properties from a previous call to get property time series.              This value is returned from the previous call. If a pagination token is provided the filter and asAt fields              must not have changed since the original request. (optional)
     * @param limit When paginating, limit the number of returned results to this many. (optional)
     * @return ResourceListOfPropertyInterval
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The time series of the property </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ResourceListOfPropertyInterval getLegalEntityPropertyTimeSeries(String idTypeScope, String idTypeCode, String code, String propertyKey, OffsetDateTime asAt, String filter, String page, Integer limit) throws ApiException {
        ApiResponse<ResourceListOfPropertyInterval> localVarResp = getLegalEntityPropertyTimeSeriesWithHttpInfo(idTypeScope, idTypeCode, code, propertyKey, asAt, filter, page, limit);
        return localVarResp.getData();
    }

    /**
     * [EXPERIMENTAL] Get Legal Entity Property Time Series
     * List the complete time series of a legal entity property.
     * @param idTypeScope Scope of the legal entity identifier type. (required)
     * @param idTypeCode Code of the legal entity identifier type. (required)
     * @param code Code of the legal entity under specified identifier type&#39;s scope and code. This together with stated identifier type uniquely identifies the legal entity. (required)
     * @param propertyKey The property key of the property that will have its history shown. These must be in the format {domain}/{scope}/{code} e.g. \&quot;LegalEntity/ContactDetails/Address\&quot;.              Each property must be from the \&quot;LegalEntity\&quot; domain. (optional)
     * @param asAt The asAt datetime at which to list the person&#39;s property history. Defaults to return the current datetime if not supplied. (optional)
     * @param filter Expression to filter the result set. Read more about filtering results from LUSID here https://support.lusid.com/filtering-results-from-lusid. (optional)
     * @param page The pagination token to use to continue listing properties from a previous call to get property time series.              This value is returned from the previous call. If a pagination token is provided the filter and asAt fields              must not have changed since the original request. (optional)
     * @param limit When paginating, limit the number of returned results to this many. (optional)
     * @return ApiResponse&lt;ResourceListOfPropertyInterval&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The time series of the property </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<ResourceListOfPropertyInterval> getLegalEntityPropertyTimeSeriesWithHttpInfo(String idTypeScope, String idTypeCode, String code, String propertyKey, OffsetDateTime asAt, String filter, String page, Integer limit) throws ApiException {
        okhttp3.Call localVarCall = getLegalEntityPropertyTimeSeriesValidateBeforeCall(idTypeScope, idTypeCode, code, propertyKey, asAt, filter, page, limit, null);
        Type localVarReturnType = new TypeToken<ResourceListOfPropertyInterval>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * [EXPERIMENTAL] Get Legal Entity Property Time Series (asynchronously)
     * List the complete time series of a legal entity property.
     * @param idTypeScope Scope of the legal entity identifier type. (required)
     * @param idTypeCode Code of the legal entity identifier type. (required)
     * @param code Code of the legal entity under specified identifier type&#39;s scope and code. This together with stated identifier type uniquely identifies the legal entity. (required)
     * @param propertyKey The property key of the property that will have its history shown. These must be in the format {domain}/{scope}/{code} e.g. \&quot;LegalEntity/ContactDetails/Address\&quot;.              Each property must be from the \&quot;LegalEntity\&quot; domain. (optional)
     * @param asAt The asAt datetime at which to list the person&#39;s property history. Defaults to return the current datetime if not supplied. (optional)
     * @param filter Expression to filter the result set. Read more about filtering results from LUSID here https://support.lusid.com/filtering-results-from-lusid. (optional)
     * @param page The pagination token to use to continue listing properties from a previous call to get property time series.              This value is returned from the previous call. If a pagination token is provided the filter and asAt fields              must not have changed since the original request. (optional)
     * @param limit When paginating, limit the number of returned results to this many. (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The time series of the property </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getLegalEntityPropertyTimeSeriesAsync(String idTypeScope, String idTypeCode, String code, String propertyKey, OffsetDateTime asAt, String filter, String page, Integer limit, final ApiCallback<ResourceListOfPropertyInterval> _callback) throws ApiException {
        okhttp3.Call localVarCall = getLegalEntityPropertyTimeSeriesValidateBeforeCall(idTypeScope, idTypeCode, code, propertyKey, asAt, filter, page, limit, _callback);
        Type localVarReturnType = new TypeToken<ResourceListOfPropertyInterval>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getLegalEntityRelations
     * @param idTypeScope Scope of the legal entity identifier type. (required)
     * @param idTypeCode Code of the legal entity identifier type. (required)
     * @param code Code of the legal entity under specified identifier type&#39;s scope and code. This together with stated identifier type uniquely              identifies the legal entity. (required)
     * @param effectiveAt The effective datetime or cut label at which to get relations. Defaults to the current LUSID system datetime if not specified. (optional)
     * @param asAt The asAt datetime at which to retrieve the legal entity&#39;s relations. Defaults to return the latest LUSID AsAt time if not specified. (optional)
     * @param filter Expression to filter the relations. Users should provide null or empty string for this field until further notice. (optional)
     * @param identifierTypes Identifiers types (as property keys) used for referencing Persons or Legal Entities. These take the format              {domain}/{scope}/{code} e.g. \&quot;Person/CompanyDetails/Role\&quot;. They must be from the \&quot;Person\&quot; or \&quot;LegalEntity\&quot; domain.              Only identifier types stated will be used to look up relevant entities in relations. If not applicable, provide an empty array. (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The relations for the specific legal entity. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getLegalEntityRelationsCall(String idTypeScope, String idTypeCode, String code, String effectiveAt, OffsetDateTime asAt, String filter, List<String> identifierTypes, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/legalentities/{idTypeScope}/{idTypeCode}/{code}/relations"
            .replaceAll("\\{" + "idTypeScope" + "\\}", localVarApiClient.escapeString(idTypeScope.toString()))
            .replaceAll("\\{" + "idTypeCode" + "\\}", localVarApiClient.escapeString(idTypeCode.toString()))
            .replaceAll("\\{" + "code" + "\\}", localVarApiClient.escapeString(code.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (effectiveAt != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("effectiveAt", effectiveAt));
        }

        if (asAt != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("asAt", asAt));
        }

        if (filter != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("filter", filter));
        }

        if (identifierTypes != null) {
            localVarCollectionQueryParams.addAll(localVarApiClient.parameterToPairs("multi", "identifierTypes", identifierTypes));
        }

        final String[] localVarAccepts = {
            "text/plain", "application/json", "text/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);
        localVarHeaderParams.put("X-LUSID-SDK-Language", "Java");
        localVarHeaderParams.put("X-LUSID-SDK-Version", "0.11.3028-MARK");

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getLegalEntityRelationsValidateBeforeCall(String idTypeScope, String idTypeCode, String code, String effectiveAt, OffsetDateTime asAt, String filter, List<String> identifierTypes, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'idTypeScope' is set
        if (idTypeScope == null) {
            throw new ApiException("Missing the required parameter 'idTypeScope' when calling getLegalEntityRelations(Async)");
        }
        
        // verify the required parameter 'idTypeCode' is set
        if (idTypeCode == null) {
            throw new ApiException("Missing the required parameter 'idTypeCode' when calling getLegalEntityRelations(Async)");
        }
        
        // verify the required parameter 'code' is set
        if (code == null) {
            throw new ApiException("Missing the required parameter 'code' when calling getLegalEntityRelations(Async)");
        }
        

        okhttp3.Call localVarCall = getLegalEntityRelationsCall(idTypeScope, idTypeCode, code, effectiveAt, asAt, filter, identifierTypes, _callback);
        return localVarCall;

    }

    /**
     * [EXPERIMENTAL] Get Relations for Legal Entity
     * Get relations for the specified Legal Entity
     * @param idTypeScope Scope of the legal entity identifier type. (required)
     * @param idTypeCode Code of the legal entity identifier type. (required)
     * @param code Code of the legal entity under specified identifier type&#39;s scope and code. This together with stated identifier type uniquely              identifies the legal entity. (required)
     * @param effectiveAt The effective datetime or cut label at which to get relations. Defaults to the current LUSID system datetime if not specified. (optional)
     * @param asAt The asAt datetime at which to retrieve the legal entity&#39;s relations. Defaults to return the latest LUSID AsAt time if not specified. (optional)
     * @param filter Expression to filter the relations. Users should provide null or empty string for this field until further notice. (optional)
     * @param identifierTypes Identifiers types (as property keys) used for referencing Persons or Legal Entities. These take the format              {domain}/{scope}/{code} e.g. \&quot;Person/CompanyDetails/Role\&quot;. They must be from the \&quot;Person\&quot; or \&quot;LegalEntity\&quot; domain.              Only identifier types stated will be used to look up relevant entities in relations. If not applicable, provide an empty array. (optional)
     * @return ResourceListOfRelation
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The relations for the specific legal entity. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ResourceListOfRelation getLegalEntityRelations(String idTypeScope, String idTypeCode, String code, String effectiveAt, OffsetDateTime asAt, String filter, List<String> identifierTypes) throws ApiException {
        ApiResponse<ResourceListOfRelation> localVarResp = getLegalEntityRelationsWithHttpInfo(idTypeScope, idTypeCode, code, effectiveAt, asAt, filter, identifierTypes);
        return localVarResp.getData();
    }

    /**
     * [EXPERIMENTAL] Get Relations for Legal Entity
     * Get relations for the specified Legal Entity
     * @param idTypeScope Scope of the legal entity identifier type. (required)
     * @param idTypeCode Code of the legal entity identifier type. (required)
     * @param code Code of the legal entity under specified identifier type&#39;s scope and code. This together with stated identifier type uniquely              identifies the legal entity. (required)
     * @param effectiveAt The effective datetime or cut label at which to get relations. Defaults to the current LUSID system datetime if not specified. (optional)
     * @param asAt The asAt datetime at which to retrieve the legal entity&#39;s relations. Defaults to return the latest LUSID AsAt time if not specified. (optional)
     * @param filter Expression to filter the relations. Users should provide null or empty string for this field until further notice. (optional)
     * @param identifierTypes Identifiers types (as property keys) used for referencing Persons or Legal Entities. These take the format              {domain}/{scope}/{code} e.g. \&quot;Person/CompanyDetails/Role\&quot;. They must be from the \&quot;Person\&quot; or \&quot;LegalEntity\&quot; domain.              Only identifier types stated will be used to look up relevant entities in relations. If not applicable, provide an empty array. (optional)
     * @return ApiResponse&lt;ResourceListOfRelation&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The relations for the specific legal entity. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<ResourceListOfRelation> getLegalEntityRelationsWithHttpInfo(String idTypeScope, String idTypeCode, String code, String effectiveAt, OffsetDateTime asAt, String filter, List<String> identifierTypes) throws ApiException {
        okhttp3.Call localVarCall = getLegalEntityRelationsValidateBeforeCall(idTypeScope, idTypeCode, code, effectiveAt, asAt, filter, identifierTypes, null);
        Type localVarReturnType = new TypeToken<ResourceListOfRelation>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * [EXPERIMENTAL] Get Relations for Legal Entity (asynchronously)
     * Get relations for the specified Legal Entity
     * @param idTypeScope Scope of the legal entity identifier type. (required)
     * @param idTypeCode Code of the legal entity identifier type. (required)
     * @param code Code of the legal entity under specified identifier type&#39;s scope and code. This together with stated identifier type uniquely              identifies the legal entity. (required)
     * @param effectiveAt The effective datetime or cut label at which to get relations. Defaults to the current LUSID system datetime if not specified. (optional)
     * @param asAt The asAt datetime at which to retrieve the legal entity&#39;s relations. Defaults to return the latest LUSID AsAt time if not specified. (optional)
     * @param filter Expression to filter the relations. Users should provide null or empty string for this field until further notice. (optional)
     * @param identifierTypes Identifiers types (as property keys) used for referencing Persons or Legal Entities. These take the format              {domain}/{scope}/{code} e.g. \&quot;Person/CompanyDetails/Role\&quot;. They must be from the \&quot;Person\&quot; or \&quot;LegalEntity\&quot; domain.              Only identifier types stated will be used to look up relevant entities in relations. If not applicable, provide an empty array. (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The relations for the specific legal entity. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getLegalEntityRelationsAsync(String idTypeScope, String idTypeCode, String code, String effectiveAt, OffsetDateTime asAt, String filter, List<String> identifierTypes, final ApiCallback<ResourceListOfRelation> _callback) throws ApiException {
        okhttp3.Call localVarCall = getLegalEntityRelationsValidateBeforeCall(idTypeScope, idTypeCode, code, effectiveAt, asAt, filter, identifierTypes, _callback);
        Type localVarReturnType = new TypeToken<ResourceListOfRelation>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getLegalEntityRelationships
     * @param idTypeScope Scope of the legal entity&#39;s identifier type. (required)
     * @param idTypeCode Code of the legal entity&#39;s identifier type. (required)
     * @param code Code of the legal entity under specified identifier type&#39;s scope and code. This together with stated identifier type uniquely              identifies the legal entity. (required)
     * @param effectiveAt The effective datetime or cut label at which to get relationships. Defaults to the current LUSID system datetime if not specified. (optional)
     * @param asAt The asAt datetime at which to retrieve relationships. Defaults to return the latest LUSID AsAt time if not specified. (optional)
     * @param filter Expression to filter relationships. Users should provide null or empty string for this field until further notice. (optional)
     * @param identifierTypes Identifiers types (as property keys) used for referencing Persons or Legal Entities. These take the format              {domain}/{scope}/{code} e.g. \&quot;Person/CompanyDetails/Role\&quot;. They must be from the \&quot;Person\&quot; or \&quot;LegalEntity\&quot; domain.              Only identifier types stated will be used to look up relevant entities in relationships. If not applicable, provide an empty array. (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The relationships for the specified legal entity. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getLegalEntityRelationshipsCall(String idTypeScope, String idTypeCode, String code, String effectiveAt, OffsetDateTime asAt, String filter, List<String> identifierTypes, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/legalentities/{idTypeScope}/{idTypeCode}/{code}/relationships"
            .replaceAll("\\{" + "idTypeScope" + "\\}", localVarApiClient.escapeString(idTypeScope.toString()))
            .replaceAll("\\{" + "idTypeCode" + "\\}", localVarApiClient.escapeString(idTypeCode.toString()))
            .replaceAll("\\{" + "code" + "\\}", localVarApiClient.escapeString(code.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (effectiveAt != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("effectiveAt", effectiveAt));
        }

        if (asAt != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("asAt", asAt));
        }

        if (filter != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("filter", filter));
        }

        if (identifierTypes != null) {
            localVarCollectionQueryParams.addAll(localVarApiClient.parameterToPairs("multi", "identifierTypes", identifierTypes));
        }

        final String[] localVarAccepts = {
            "text/plain", "application/json", "text/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);
        localVarHeaderParams.put("X-LUSID-SDK-Language", "Java");
        localVarHeaderParams.put("X-LUSID-SDK-Version", "0.11.3028-MARK");

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getLegalEntityRelationshipsValidateBeforeCall(String idTypeScope, String idTypeCode, String code, String effectiveAt, OffsetDateTime asAt, String filter, List<String> identifierTypes, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'idTypeScope' is set
        if (idTypeScope == null) {
            throw new ApiException("Missing the required parameter 'idTypeScope' when calling getLegalEntityRelationships(Async)");
        }
        
        // verify the required parameter 'idTypeCode' is set
        if (idTypeCode == null) {
            throw new ApiException("Missing the required parameter 'idTypeCode' when calling getLegalEntityRelationships(Async)");
        }
        
        // verify the required parameter 'code' is set
        if (code == null) {
            throw new ApiException("Missing the required parameter 'code' when calling getLegalEntityRelationships(Async)");
        }
        

        okhttp3.Call localVarCall = getLegalEntityRelationshipsCall(idTypeScope, idTypeCode, code, effectiveAt, asAt, filter, identifierTypes, _callback);
        return localVarCall;

    }

    /**
     * [EXPERIMENTAL] Get Relationships for Legal Entity
     * Get Relationships for the specified Legal Entity
     * @param idTypeScope Scope of the legal entity&#39;s identifier type. (required)
     * @param idTypeCode Code of the legal entity&#39;s identifier type. (required)
     * @param code Code of the legal entity under specified identifier type&#39;s scope and code. This together with stated identifier type uniquely              identifies the legal entity. (required)
     * @param effectiveAt The effective datetime or cut label at which to get relationships. Defaults to the current LUSID system datetime if not specified. (optional)
     * @param asAt The asAt datetime at which to retrieve relationships. Defaults to return the latest LUSID AsAt time if not specified. (optional)
     * @param filter Expression to filter relationships. Users should provide null or empty string for this field until further notice. (optional)
     * @param identifierTypes Identifiers types (as property keys) used for referencing Persons or Legal Entities. These take the format              {domain}/{scope}/{code} e.g. \&quot;Person/CompanyDetails/Role\&quot;. They must be from the \&quot;Person\&quot; or \&quot;LegalEntity\&quot; domain.              Only identifier types stated will be used to look up relevant entities in relationships. If not applicable, provide an empty array. (optional)
     * @return ResourceListOfRelationship
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The relationships for the specified legal entity. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ResourceListOfRelationship getLegalEntityRelationships(String idTypeScope, String idTypeCode, String code, String effectiveAt, OffsetDateTime asAt, String filter, List<String> identifierTypes) throws ApiException {
        ApiResponse<ResourceListOfRelationship> localVarResp = getLegalEntityRelationshipsWithHttpInfo(idTypeScope, idTypeCode, code, effectiveAt, asAt, filter, identifierTypes);
        return localVarResp.getData();
    }

    /**
     * [EXPERIMENTAL] Get Relationships for Legal Entity
     * Get Relationships for the specified Legal Entity
     * @param idTypeScope Scope of the legal entity&#39;s identifier type. (required)
     * @param idTypeCode Code of the legal entity&#39;s identifier type. (required)
     * @param code Code of the legal entity under specified identifier type&#39;s scope and code. This together with stated identifier type uniquely              identifies the legal entity. (required)
     * @param effectiveAt The effective datetime or cut label at which to get relationships. Defaults to the current LUSID system datetime if not specified. (optional)
     * @param asAt The asAt datetime at which to retrieve relationships. Defaults to return the latest LUSID AsAt time if not specified. (optional)
     * @param filter Expression to filter relationships. Users should provide null or empty string for this field until further notice. (optional)
     * @param identifierTypes Identifiers types (as property keys) used for referencing Persons or Legal Entities. These take the format              {domain}/{scope}/{code} e.g. \&quot;Person/CompanyDetails/Role\&quot;. They must be from the \&quot;Person\&quot; or \&quot;LegalEntity\&quot; domain.              Only identifier types stated will be used to look up relevant entities in relationships. If not applicable, provide an empty array. (optional)
     * @return ApiResponse&lt;ResourceListOfRelationship&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The relationships for the specified legal entity. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<ResourceListOfRelationship> getLegalEntityRelationshipsWithHttpInfo(String idTypeScope, String idTypeCode, String code, String effectiveAt, OffsetDateTime asAt, String filter, List<String> identifierTypes) throws ApiException {
        okhttp3.Call localVarCall = getLegalEntityRelationshipsValidateBeforeCall(idTypeScope, idTypeCode, code, effectiveAt, asAt, filter, identifierTypes, null);
        Type localVarReturnType = new TypeToken<ResourceListOfRelationship>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * [EXPERIMENTAL] Get Relationships for Legal Entity (asynchronously)
     * Get Relationships for the specified Legal Entity
     * @param idTypeScope Scope of the legal entity&#39;s identifier type. (required)
     * @param idTypeCode Code of the legal entity&#39;s identifier type. (required)
     * @param code Code of the legal entity under specified identifier type&#39;s scope and code. This together with stated identifier type uniquely              identifies the legal entity. (required)
     * @param effectiveAt The effective datetime or cut label at which to get relationships. Defaults to the current LUSID system datetime if not specified. (optional)
     * @param asAt The asAt datetime at which to retrieve relationships. Defaults to return the latest LUSID AsAt time if not specified. (optional)
     * @param filter Expression to filter relationships. Users should provide null or empty string for this field until further notice. (optional)
     * @param identifierTypes Identifiers types (as property keys) used for referencing Persons or Legal Entities. These take the format              {domain}/{scope}/{code} e.g. \&quot;Person/CompanyDetails/Role\&quot;. They must be from the \&quot;Person\&quot; or \&quot;LegalEntity\&quot; domain.              Only identifier types stated will be used to look up relevant entities in relationships. If not applicable, provide an empty array. (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The relationships for the specified legal entity. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getLegalEntityRelationshipsAsync(String idTypeScope, String idTypeCode, String code, String effectiveAt, OffsetDateTime asAt, String filter, List<String> identifierTypes, final ApiCallback<ResourceListOfRelationship> _callback) throws ApiException {
        okhttp3.Call localVarCall = getLegalEntityRelationshipsValidateBeforeCall(idTypeScope, idTypeCode, code, effectiveAt, asAt, filter, identifierTypes, _callback);
        Type localVarReturnType = new TypeToken<ResourceListOfRelationship>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for listLegalEntities
     * @param idTypeScope Scope of the legal entity identifier type. (required)
     * @param idTypeCode Code of the legal entity identifier type. (required)
     * @param effectiveAt The effective datetime or cut label at which to list the people. Defaults to the current LUSID              system datetime if not specified. (optional)
     * @param asAt The asAt datetime at which to list the people. Defaults to return the latest version              of each people if not specified. (optional)
     * @param page The pagination token to use to continue listing legal entities from a previous call to list legal entities. This  value is returned from the previous call. If a pagination token is provided the filter, effectiveAt  and asAt fields must not have changed since the original request. (optional)
     * @param limit When paginating, limit the number of returned results to this many. Defaults to 65,535 if not specified. (optional)
     * @param filter Expression to filter the result set.               Read more about filtering results from LUSID here https://support.lusid.com/filtering-results-from-lusid. (optional)
     * @param propertyKeys A list of property keys or identifier types (as property keys) from the \&quot;LegalEntity\&quot; domain to include for each legal entity.              These take the format {domain}/{scope}/{code} e.g. \&quot;LegalEntity/ContactDetails/Address\&quot;. (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Legal Entities with specified identifier type </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listLegalEntitiesCall(String idTypeScope, String idTypeCode, String effectiveAt, OffsetDateTime asAt, String page, Integer limit, String filter, List<String> propertyKeys, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/legalentities/{idTypeScope}/{idTypeCode}"
            .replaceAll("\\{" + "idTypeScope" + "\\}", localVarApiClient.escapeString(idTypeScope.toString()))
            .replaceAll("\\{" + "idTypeCode" + "\\}", localVarApiClient.escapeString(idTypeCode.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (effectiveAt != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("effectiveAt", effectiveAt));
        }

        if (asAt != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("asAt", asAt));
        }

        if (page != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("page", page));
        }

        if (limit != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("limit", limit));
        }

        if (filter != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("filter", filter));
        }

        if (propertyKeys != null) {
            localVarCollectionQueryParams.addAll(localVarApiClient.parameterToPairs("multi", "propertyKeys", propertyKeys));
        }

        final String[] localVarAccepts = {
            "text/plain", "application/json", "text/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);
        localVarHeaderParams.put("X-LUSID-SDK-Language", "Java");
        localVarHeaderParams.put("X-LUSID-SDK-Version", "0.11.3028-MARK");

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call listLegalEntitiesValidateBeforeCall(String idTypeScope, String idTypeCode, String effectiveAt, OffsetDateTime asAt, String page, Integer limit, String filter, List<String> propertyKeys, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'idTypeScope' is set
        if (idTypeScope == null) {
            throw new ApiException("Missing the required parameter 'idTypeScope' when calling listLegalEntities(Async)");
        }
        
        // verify the required parameter 'idTypeCode' is set
        if (idTypeCode == null) {
            throw new ApiException("Missing the required parameter 'idTypeCode' when calling listLegalEntities(Async)");
        }
        

        okhttp3.Call localVarCall = listLegalEntitiesCall(idTypeScope, idTypeCode, effectiveAt, asAt, page, limit, filter, propertyKeys, _callback);
        return localVarCall;

    }

    /**
     * [EARLY ACCESS] List Legal Entities
     * List legal entities which has identifier of specific identifier type&#39;s scope and code, and satisfies filter criteria.
     * @param idTypeScope Scope of the legal entity identifier type. (required)
     * @param idTypeCode Code of the legal entity identifier type. (required)
     * @param effectiveAt The effective datetime or cut label at which to list the people. Defaults to the current LUSID              system datetime if not specified. (optional)
     * @param asAt The asAt datetime at which to list the people. Defaults to return the latest version              of each people if not specified. (optional)
     * @param page The pagination token to use to continue listing legal entities from a previous call to list legal entities. This  value is returned from the previous call. If a pagination token is provided the filter, effectiveAt  and asAt fields must not have changed since the original request. (optional)
     * @param limit When paginating, limit the number of returned results to this many. Defaults to 65,535 if not specified. (optional)
     * @param filter Expression to filter the result set.               Read more about filtering results from LUSID here https://support.lusid.com/filtering-results-from-lusid. (optional)
     * @param propertyKeys A list of property keys or identifier types (as property keys) from the \&quot;LegalEntity\&quot; domain to include for each legal entity.              These take the format {domain}/{scope}/{code} e.g. \&quot;LegalEntity/ContactDetails/Address\&quot;. (optional)
     * @return PagedResourceListOfLegalEntity
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Legal Entities with specified identifier type </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public PagedResourceListOfLegalEntity listLegalEntities(String idTypeScope, String idTypeCode, String effectiveAt, OffsetDateTime asAt, String page, Integer limit, String filter, List<String> propertyKeys) throws ApiException {
        ApiResponse<PagedResourceListOfLegalEntity> localVarResp = listLegalEntitiesWithHttpInfo(idTypeScope, idTypeCode, effectiveAt, asAt, page, limit, filter, propertyKeys);
        return localVarResp.getData();
    }

    /**
     * [EARLY ACCESS] List Legal Entities
     * List legal entities which has identifier of specific identifier type&#39;s scope and code, and satisfies filter criteria.
     * @param idTypeScope Scope of the legal entity identifier type. (required)
     * @param idTypeCode Code of the legal entity identifier type. (required)
     * @param effectiveAt The effective datetime or cut label at which to list the people. Defaults to the current LUSID              system datetime if not specified. (optional)
     * @param asAt The asAt datetime at which to list the people. Defaults to return the latest version              of each people if not specified. (optional)
     * @param page The pagination token to use to continue listing legal entities from a previous call to list legal entities. This  value is returned from the previous call. If a pagination token is provided the filter, effectiveAt  and asAt fields must not have changed since the original request. (optional)
     * @param limit When paginating, limit the number of returned results to this many. Defaults to 65,535 if not specified. (optional)
     * @param filter Expression to filter the result set.               Read more about filtering results from LUSID here https://support.lusid.com/filtering-results-from-lusid. (optional)
     * @param propertyKeys A list of property keys or identifier types (as property keys) from the \&quot;LegalEntity\&quot; domain to include for each legal entity.              These take the format {domain}/{scope}/{code} e.g. \&quot;LegalEntity/ContactDetails/Address\&quot;. (optional)
     * @return ApiResponse&lt;PagedResourceListOfLegalEntity&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Legal Entities with specified identifier type </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<PagedResourceListOfLegalEntity> listLegalEntitiesWithHttpInfo(String idTypeScope, String idTypeCode, String effectiveAt, OffsetDateTime asAt, String page, Integer limit, String filter, List<String> propertyKeys) throws ApiException {
        okhttp3.Call localVarCall = listLegalEntitiesValidateBeforeCall(idTypeScope, idTypeCode, effectiveAt, asAt, page, limit, filter, propertyKeys, null);
        Type localVarReturnType = new TypeToken<PagedResourceListOfLegalEntity>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * [EARLY ACCESS] List Legal Entities (asynchronously)
     * List legal entities which has identifier of specific identifier type&#39;s scope and code, and satisfies filter criteria.
     * @param idTypeScope Scope of the legal entity identifier type. (required)
     * @param idTypeCode Code of the legal entity identifier type. (required)
     * @param effectiveAt The effective datetime or cut label at which to list the people. Defaults to the current LUSID              system datetime if not specified. (optional)
     * @param asAt The asAt datetime at which to list the people. Defaults to return the latest version              of each people if not specified. (optional)
     * @param page The pagination token to use to continue listing legal entities from a previous call to list legal entities. This  value is returned from the previous call. If a pagination token is provided the filter, effectiveAt  and asAt fields must not have changed since the original request. (optional)
     * @param limit When paginating, limit the number of returned results to this many. Defaults to 65,535 if not specified. (optional)
     * @param filter Expression to filter the result set.               Read more about filtering results from LUSID here https://support.lusid.com/filtering-results-from-lusid. (optional)
     * @param propertyKeys A list of property keys or identifier types (as property keys) from the \&quot;LegalEntity\&quot; domain to include for each legal entity.              These take the format {domain}/{scope}/{code} e.g. \&quot;LegalEntity/ContactDetails/Address\&quot;. (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Legal Entities with specified identifier type </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listLegalEntitiesAsync(String idTypeScope, String idTypeCode, String effectiveAt, OffsetDateTime asAt, String page, Integer limit, String filter, List<String> propertyKeys, final ApiCallback<PagedResourceListOfLegalEntity> _callback) throws ApiException {
        okhttp3.Call localVarCall = listLegalEntitiesValidateBeforeCall(idTypeScope, idTypeCode, effectiveAt, asAt, page, limit, filter, propertyKeys, _callback);
        Type localVarReturnType = new TypeToken<PagedResourceListOfLegalEntity>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for upsertLegalEntity
     * @param upsertLegalEntityRequest Request to create or update a legal entity. (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> The newly created or updated legal entity </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call upsertLegalEntityCall(UpsertLegalEntityRequest upsertLegalEntityRequest, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = upsertLegalEntityRequest;

        // create path and map variables
        String localVarPath = "/api/legalentities";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "text/plain", "application/json", "text/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json-patch+json", "application/json", "text/json", "application/_*+json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);
        localVarHeaderParams.put("X-LUSID-SDK-Language", "Java");
        localVarHeaderParams.put("X-LUSID-SDK-Version", "0.11.3028-MARK");

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call upsertLegalEntityValidateBeforeCall(UpsertLegalEntityRequest upsertLegalEntityRequest, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'upsertLegalEntityRequest' is set
        if (upsertLegalEntityRequest == null) {
            throw new ApiException("Missing the required parameter 'upsertLegalEntityRequest' when calling upsertLegalEntity(Async)");
        }
        

        okhttp3.Call localVarCall = upsertLegalEntityCall(upsertLegalEntityRequest, _callback);
        return localVarCall;

    }

    /**
     * [EARLY ACCESS] Upsert Legal Entity
     * Create or update a legal entity
     * @param upsertLegalEntityRequest Request to create or update a legal entity. (required)
     * @return LegalEntity
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> The newly created or updated legal entity </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public LegalEntity upsertLegalEntity(UpsertLegalEntityRequest upsertLegalEntityRequest) throws ApiException {
        ApiResponse<LegalEntity> localVarResp = upsertLegalEntityWithHttpInfo(upsertLegalEntityRequest);
        return localVarResp.getData();
    }

    /**
     * [EARLY ACCESS] Upsert Legal Entity
     * Create or update a legal entity
     * @param upsertLegalEntityRequest Request to create or update a legal entity. (required)
     * @return ApiResponse&lt;LegalEntity&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> The newly created or updated legal entity </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<LegalEntity> upsertLegalEntityWithHttpInfo(UpsertLegalEntityRequest upsertLegalEntityRequest) throws ApiException {
        okhttp3.Call localVarCall = upsertLegalEntityValidateBeforeCall(upsertLegalEntityRequest, null);
        Type localVarReturnType = new TypeToken<LegalEntity>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * [EARLY ACCESS] Upsert Legal Entity (asynchronously)
     * Create or update a legal entity
     * @param upsertLegalEntityRequest Request to create or update a legal entity. (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> The newly created or updated legal entity </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call upsertLegalEntityAsync(UpsertLegalEntityRequest upsertLegalEntityRequest, final ApiCallback<LegalEntity> _callback) throws ApiException {
        okhttp3.Call localVarCall = upsertLegalEntityValidateBeforeCall(upsertLegalEntityRequest, _callback);
        Type localVarReturnType = new TypeToken<LegalEntity>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for upsertLegalEntityAccessMetadata
     * @param idTypeScope Scope of the Legal Entity identifier. (required)
     * @param idTypeCode Code of the Legal Entity identifier. (required)
     * @param code Code of the Legal Entity under specified identifier type&#39;s scope and code. (required)
     * @param metadataKey Key of the metadata entry to retrieve (required)
     * @param upsertLegalEntityAccessMetadataRequest The Legal Entity Access Metadata entry to upsert (required)
     * @param effectiveAt The effectiveAt datetime at which to upsert the Access Metadata (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The successfully updated or inserted item or any failure. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call upsertLegalEntityAccessMetadataCall(String idTypeScope, String idTypeCode, String code, String metadataKey, UpsertLegalEntityAccessMetadataRequest upsertLegalEntityAccessMetadataRequest, String effectiveAt, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = upsertLegalEntityAccessMetadataRequest;

        // create path and map variables
        String localVarPath = "/api/legalentities/{idTypeScope}/{idTypeCode}/{code}/metadata/{metadataKey}"
            .replaceAll("\\{" + "idTypeScope" + "\\}", localVarApiClient.escapeString(idTypeScope.toString()))
            .replaceAll("\\{" + "idTypeCode" + "\\}", localVarApiClient.escapeString(idTypeCode.toString()))
            .replaceAll("\\{" + "code" + "\\}", localVarApiClient.escapeString(code.toString()))
            .replaceAll("\\{" + "metadataKey" + "\\}", localVarApiClient.escapeString(metadataKey.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (effectiveAt != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("effectiveAt", effectiveAt));
        }

        final String[] localVarAccepts = {
            "text/plain", "application/json", "text/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json-patch+json", "application/json", "text/json", "application/_*+json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);
        localVarHeaderParams.put("X-LUSID-SDK-Language", "Java");
        localVarHeaderParams.put("X-LUSID-SDK-Version", "0.11.3028-MARK");

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call upsertLegalEntityAccessMetadataValidateBeforeCall(String idTypeScope, String idTypeCode, String code, String metadataKey, UpsertLegalEntityAccessMetadataRequest upsertLegalEntityAccessMetadataRequest, String effectiveAt, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'idTypeScope' is set
        if (idTypeScope == null) {
            throw new ApiException("Missing the required parameter 'idTypeScope' when calling upsertLegalEntityAccessMetadata(Async)");
        }
        
        // verify the required parameter 'idTypeCode' is set
        if (idTypeCode == null) {
            throw new ApiException("Missing the required parameter 'idTypeCode' when calling upsertLegalEntityAccessMetadata(Async)");
        }
        
        // verify the required parameter 'code' is set
        if (code == null) {
            throw new ApiException("Missing the required parameter 'code' when calling upsertLegalEntityAccessMetadata(Async)");
        }
        
        // verify the required parameter 'metadataKey' is set
        if (metadataKey == null) {
            throw new ApiException("Missing the required parameter 'metadataKey' when calling upsertLegalEntityAccessMetadata(Async)");
        }
        
        // verify the required parameter 'upsertLegalEntityAccessMetadataRequest' is set
        if (upsertLegalEntityAccessMetadataRequest == null) {
            throw new ApiException("Missing the required parameter 'upsertLegalEntityAccessMetadataRequest' when calling upsertLegalEntityAccessMetadata(Async)");
        }
        

        okhttp3.Call localVarCall = upsertLegalEntityAccessMetadataCall(idTypeScope, idTypeCode, code, metadataKey, upsertLegalEntityAccessMetadataRequest, effectiveAt, _callback);
        return localVarCall;

    }

    /**
     * [EXPERIMENTAL] Upsert a Legal Entity Access Metadata entry associated with a specific metadataKey. This creates or updates the data in LUSID.
     * Update or insert one Legal Entity Access Metadata entry in a single scope. An item will be updated if it already exists  and inserted if it does not.                The response will return the successfully updated or inserted Legal Entity Access Metadata rule or failure message if unsuccessful.                It is important to always check to verify success (or failure).                Multiple rules for a metadataKey can exist with different effective at dates, when resources are accessed the rule that is active for the current time will be fetched.
     * @param idTypeScope Scope of the Legal Entity identifier. (required)
     * @param idTypeCode Code of the Legal Entity identifier. (required)
     * @param code Code of the Legal Entity under specified identifier type&#39;s scope and code. (required)
     * @param metadataKey Key of the metadata entry to retrieve (required)
     * @param upsertLegalEntityAccessMetadataRequest The Legal Entity Access Metadata entry to upsert (required)
     * @param effectiveAt The effectiveAt datetime at which to upsert the Access Metadata (optional)
     * @return ResourceListOfAccessMetadataValueOf
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The successfully updated or inserted item or any failure. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ResourceListOfAccessMetadataValueOf upsertLegalEntityAccessMetadata(String idTypeScope, String idTypeCode, String code, String metadataKey, UpsertLegalEntityAccessMetadataRequest upsertLegalEntityAccessMetadataRequest, String effectiveAt) throws ApiException {
        ApiResponse<ResourceListOfAccessMetadataValueOf> localVarResp = upsertLegalEntityAccessMetadataWithHttpInfo(idTypeScope, idTypeCode, code, metadataKey, upsertLegalEntityAccessMetadataRequest, effectiveAt);
        return localVarResp.getData();
    }

    /**
     * [EXPERIMENTAL] Upsert a Legal Entity Access Metadata entry associated with a specific metadataKey. This creates or updates the data in LUSID.
     * Update or insert one Legal Entity Access Metadata entry in a single scope. An item will be updated if it already exists  and inserted if it does not.                The response will return the successfully updated or inserted Legal Entity Access Metadata rule or failure message if unsuccessful.                It is important to always check to verify success (or failure).                Multiple rules for a metadataKey can exist with different effective at dates, when resources are accessed the rule that is active for the current time will be fetched.
     * @param idTypeScope Scope of the Legal Entity identifier. (required)
     * @param idTypeCode Code of the Legal Entity identifier. (required)
     * @param code Code of the Legal Entity under specified identifier type&#39;s scope and code. (required)
     * @param metadataKey Key of the metadata entry to retrieve (required)
     * @param upsertLegalEntityAccessMetadataRequest The Legal Entity Access Metadata entry to upsert (required)
     * @param effectiveAt The effectiveAt datetime at which to upsert the Access Metadata (optional)
     * @return ApiResponse&lt;ResourceListOfAccessMetadataValueOf&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The successfully updated or inserted item or any failure. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<ResourceListOfAccessMetadataValueOf> upsertLegalEntityAccessMetadataWithHttpInfo(String idTypeScope, String idTypeCode, String code, String metadataKey, UpsertLegalEntityAccessMetadataRequest upsertLegalEntityAccessMetadataRequest, String effectiveAt) throws ApiException {
        okhttp3.Call localVarCall = upsertLegalEntityAccessMetadataValidateBeforeCall(idTypeScope, idTypeCode, code, metadataKey, upsertLegalEntityAccessMetadataRequest, effectiveAt, null);
        Type localVarReturnType = new TypeToken<ResourceListOfAccessMetadataValueOf>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * [EXPERIMENTAL] Upsert a Legal Entity Access Metadata entry associated with a specific metadataKey. This creates or updates the data in LUSID. (asynchronously)
     * Update or insert one Legal Entity Access Metadata entry in a single scope. An item will be updated if it already exists  and inserted if it does not.                The response will return the successfully updated or inserted Legal Entity Access Metadata rule or failure message if unsuccessful.                It is important to always check to verify success (or failure).                Multiple rules for a metadataKey can exist with different effective at dates, when resources are accessed the rule that is active for the current time will be fetched.
     * @param idTypeScope Scope of the Legal Entity identifier. (required)
     * @param idTypeCode Code of the Legal Entity identifier. (required)
     * @param code Code of the Legal Entity under specified identifier type&#39;s scope and code. (required)
     * @param metadataKey Key of the metadata entry to retrieve (required)
     * @param upsertLegalEntityAccessMetadataRequest The Legal Entity Access Metadata entry to upsert (required)
     * @param effectiveAt The effectiveAt datetime at which to upsert the Access Metadata (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The successfully updated or inserted item or any failure. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call upsertLegalEntityAccessMetadataAsync(String idTypeScope, String idTypeCode, String code, String metadataKey, UpsertLegalEntityAccessMetadataRequest upsertLegalEntityAccessMetadataRequest, String effectiveAt, final ApiCallback<ResourceListOfAccessMetadataValueOf> _callback) throws ApiException {
        okhttp3.Call localVarCall = upsertLegalEntityAccessMetadataValidateBeforeCall(idTypeScope, idTypeCode, code, metadataKey, upsertLegalEntityAccessMetadataRequest, effectiveAt, _callback);
        Type localVarReturnType = new TypeToken<ResourceListOfAccessMetadataValueOf>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
