/*
 * LUSID API
 * # Introduction  This page documents the [LUSID APIs](../../../api/swagger), which allows authorised clients to query and update their data within the LUSID platform.  SDKs to interact with the LUSID APIs are available in the following languages and frameworks:  * [C#](https://github.com/finbourne/lusid-sdk-csharp) * [Java](https://github.com/finbourne/lusid-sdk-java) * [JavaScript](https://github.com/finbourne/lusid-sdk-js) * [Python](https://github.com/finbourne/lusid-sdk-python) * [Angular](https://github.com/finbourne/lusid-sdk-angular)  The LUSID platform is made up of a number of sub-applications. You can find the API / swagger documentation by following the links in the table below.   | Application   | Description                                                                       | API / Swagger Documentation                          | |---------------|-----------------------------------------------------------------------------------|------------------------------------------------------| | LUSID         | Open, API-first, developer-friendly investment data platform.                     | [Swagger](../../../api/swagger/index.html)           | | Web app       | User-facing front end for LUSID.                                                  | [Swagger](../../../app/swagger/index.html)           | | Scheduler     | Automated job scheduler.                                                          | [Swagger](../../../scheduler2/swagger/index.html)    | | Insights      | Monitoring and troubleshooting service.                                           | [Swagger](../../../insights/swagger/index.html)      | | Identity      | Identity management for LUSID (in conjunction with Access)                        | [Swagger](../../../identity/swagger/index.html)      | | Access        | Access control for LUSID (in conjunction with Identity)                           | [Swagger](../../../access/swagger/index.html)        | | Drive         | Secure file repository and manager for collaboration.                             | [Swagger](../../../drive/swagger/index.html)         | | Luminesce     | Data virtualisation service (query data from multiple providers, including LUSID) | [Swagger](../../../honeycomb/swagger/index.html)     | | Notification  | Notification service.                                                             | [Swagger](../../../notification/swagger/index.html)  | | Configuration | File store for secrets and other sensitive information.                           | [Swagger](../../../configuration/swagger/index.html) | | Workflow      | Workflow service.                                                                 | [Swagger](../../../workflow/swagger/index.html)      |   # Error Codes  | Code|Name|Description | | ---|---|--- | | <a name=\"-10\">-10</a>|Server Configuration Error|  | | <a name=\"-1\">-1</a>|Unknown error|An unexpected error was encountered on our side. | | <a name=\"102\">102</a>|Version Not Found|  | | <a name=\"103\">103</a>|Api Rate Limit Violation|  | | <a name=\"104\">104</a>|Instrument Not Found|  | | <a name=\"105\">105</a>|Property Not Found|  | | <a name=\"106\">106</a>|Portfolio Recursion Depth|  | | <a name=\"108\">108</a>|Group Not Found|  | | <a name=\"109\">109</a>|Portfolio Not Found|  | | <a name=\"110\">110</a>|Property Schema Not Found|  | | <a name=\"111\">111</a>|Portfolio Ancestry Not Found|  | | <a name=\"112\">112</a>|Portfolio With Id Already Exists|  | | <a name=\"113\">113</a>|Orphaned Portfolio|  | | <a name=\"119\">119</a>|Missing Base Claims|  | | <a name=\"121\">121</a>|Property Not Defined|  | | <a name=\"122\">122</a>|Cannot Delete System Property|  | | <a name=\"123\">123</a>|Cannot Modify Immutable Property Field|  | | <a name=\"124\">124</a>|Property Already Exists|  | | <a name=\"125\">125</a>|Invalid Property Life Time|  | | <a name=\"126\">126</a>|Property Constraint Style Excludes Properties|  | | <a name=\"127\">127</a>|Cannot Modify Default Data Type|  | | <a name=\"128\">128</a>|Group Already Exists|  | | <a name=\"129\">129</a>|No Such Data Type|  | | <a name=\"130\">130</a>|Undefined Value For Data Type|  | | <a name=\"131\">131</a>|Unsupported Value Type Defined On Data Type|  | | <a name=\"132\">132</a>|Validation Error|  | | <a name=\"133\">133</a>|Loop Detected In Group Hierarchy|  | | <a name=\"134\">134</a>|Undefined Acceptable Values|  | | <a name=\"135\">135</a>|Sub Group Already Exists|  | | <a name=\"138\">138</a>|Price Source Not Found|  | | <a name=\"139\">139</a>|Analytic Store Not Found|  | | <a name=\"141\">141</a>|Analytic Store Already Exists|  | | <a name=\"143\">143</a>|Client Instrument Already Exists|  | | <a name=\"144\">144</a>|Duplicate In Parameter Set|  | | <a name=\"147\">147</a>|Results Not Found|  | | <a name=\"148\">148</a>|Order Field Not In Result Set|  | | <a name=\"149\">149</a>|Operation Failed|  | | <a name=\"150\">150</a>|Elastic Search Error|  | | <a name=\"151\">151</a>|Invalid Parameter Value|  | | <a name=\"153\">153</a>|Command Processing Failure|  | | <a name=\"154\">154</a>|Entity State Construction Failure|  | | <a name=\"155\">155</a>|Entity Timeline Does Not Exist|  | | <a name=\"156\">156</a>|Concurrency Conflict Failure|  | | <a name=\"157\">157</a>|Invalid Request|  | | <a name=\"158\">158</a>|Event Publish Unknown|  | | <a name=\"159\">159</a>|Event Query Failure|  | | <a name=\"160\">160</a>|Blob Did Not Exist|  | | <a name=\"162\">162</a>|Sub System Request Failure|  | | <a name=\"163\">163</a>|Sub System Configuration Failure|  | | <a name=\"165\">165</a>|Failed To Delete|  | | <a name=\"166\">166</a>|Upsert Client Instrument Failure|  | | <a name=\"167\">167</a>|Illegal As At Interval|  | | <a name=\"168\">168</a>|Illegal Bitemporal Query|  | | <a name=\"169\">169</a>|Invalid Alternate Id|  | | <a name=\"170\">170</a>|Cannot Add Source Portfolio Property Explicitly|  | | <a name=\"171\">171</a>|Entity Already Exists In Group|  | | <a name=\"172\">172</a>|Entity With Id Does Not Exist|  | | <a name=\"173\">173</a>|Entity With Id Already Exists|  | | <a name=\"174\">174</a>|Derived Portfolio Details Do Not Exist|  | | <a name=\"175\">175</a>|Entity Not In Group|  | | <a name=\"176\">176</a>|Portfolio With Name Already Exists|  | | <a name=\"177\">177</a>|Invalid Transactions|  | | <a name=\"178\">178</a>|Reference Portfolio Not Found|  | | <a name=\"179\">179</a>|Duplicate Id|  | | <a name=\"180\">180</a>|Command Retrieval Failure|  | | <a name=\"181\">181</a>|Data Filter Application Failure|  | | <a name=\"182\">182</a>|Search Failed|  | | <a name=\"183\">183</a>|Movements Engine Configuration Key Failure|  | | <a name=\"184\">184</a>|Fx Rate Source Not Found|  | | <a name=\"185\">185</a>|Accrual Source Not Found|  | | <a name=\"186\">186</a>|Access Denied|  | | <a name=\"187\">187</a>|Invalid Identity Token|  | | <a name=\"188\">188</a>|Invalid Request Headers|  | | <a name=\"189\">189</a>|Price Not Found|  | | <a name=\"190\">190</a>|Invalid Sub Holding Keys Provided|  | | <a name=\"191\">191</a>|Duplicate Sub Holding Keys Provided|  | | <a name=\"192\">192</a>|Cut Definition Not Found|  | | <a name=\"193\">193</a>|Cut Definition Invalid|  | | <a name=\"194\">194</a>|Time Variant Property Deletion Date Unspecified|  | | <a name=\"195\">195</a>|Perpetual Property Deletion Date Specified|  | | <a name=\"196\">196</a>|Time Variant Property Upsert Date Unspecified|  | | <a name=\"197\">197</a>|Perpetual Property Upsert Date Specified|  | | <a name=\"200\">200</a>|Invalid Unit For Data Type|  | | <a name=\"201\">201</a>|Invalid Type For Data Type|  | | <a name=\"202\">202</a>|Invalid Value For Data Type|  | | <a name=\"203\">203</a>|Unit Not Defined For Data Type|  | | <a name=\"204\">204</a>|Units Not Supported On Data Type|  | | <a name=\"205\">205</a>|Cannot Specify Units On Data Type|  | | <a name=\"206\">206</a>|Unit Schema Inconsistent With Data Type|  | | <a name=\"207\">207</a>|Unit Definition Not Specified|  | | <a name=\"208\">208</a>|Duplicate Unit Definitions Specified|  | | <a name=\"209\">209</a>|Invalid Units Definition|  | | <a name=\"210\">210</a>|Invalid Instrument Identifier Unit|  | | <a name=\"211\">211</a>|Holdings Adjustment Does Not Exist|  | | <a name=\"212\">212</a>|Could Not Build Excel Url|  | | <a name=\"213\">213</a>|Could Not Get Excel Version|  | | <a name=\"214\">214</a>|Instrument By Code Not Found|  | | <a name=\"215\">215</a>|Entity Schema Does Not Exist|  | | <a name=\"216\">216</a>|Feature Not Supported On Portfolio Type|  | | <a name=\"217\">217</a>|Quote Not Found|  | | <a name=\"218\">218</a>|Invalid Quote Identifier|  | | <a name=\"219\">219</a>|Invalid Metric For Data Type|  | | <a name=\"220\">220</a>|Invalid Instrument Definition|  | | <a name=\"221\">221</a>|Instrument Upsert Failure|  | | <a name=\"222\">222</a>|Reference Portfolio Request Not Supported|  | | <a name=\"223\">223</a>|Transaction Portfolio Request Not Supported|  | | <a name=\"224\">224</a>|Invalid Property Value Assignment|  | | <a name=\"230\">230</a>|Transaction Type Not Found|  | | <a name=\"231\">231</a>|Transaction Type Duplication|  | | <a name=\"232\">232</a>|Portfolio Does Not Exist At Given Date|  | | <a name=\"233\">233</a>|Query Parser Failure|  | | <a name=\"234\">234</a>|Duplicate Constituent|  | | <a name=\"235\">235</a>|Unresolved Instrument Constituent|  | | <a name=\"236\">236</a>|Unresolved Instrument In Transition|  | | <a name=\"237\">237</a>|Missing Side Definitions|  | | <a name=\"240\">240</a>|Duplicate Calculations Failure|  | | <a name=\"299\">299</a>|Invalid Recipe|  | | <a name=\"300\">300</a>|Missing Recipe|  | | <a name=\"301\">301</a>|Dependencies|  | | <a name=\"304\">304</a>|Portfolio Preprocess Failure|  | | <a name=\"310\">310</a>|Valuation Engine Failure|  | | <a name=\"311\">311</a>|Task Factory Failure|  | | <a name=\"312\">312</a>|Task Evaluation Failure|  | | <a name=\"313\">313</a>|Task Generation Failure|  | | <a name=\"314\">314</a>|Engine Configuration Failure|  | | <a name=\"315\">315</a>|Model Specification Failure|  | | <a name=\"320\">320</a>|Market Data Key Failure|  | | <a name=\"321\">321</a>|Market Resolver Failure|  | | <a name=\"322\">322</a>|Market Data Failure|  | | <a name=\"330\">330</a>|Curve Failure|  | | <a name=\"331\">331</a>|Volatility Surface Failure|  | | <a name=\"332\">332</a>|Volatility Cube Failure|  | | <a name=\"350\">350</a>|Instrument Failure|  | | <a name=\"351\">351</a>|Cash Flows Failure|  | | <a name=\"352\">352</a>|Reference Data Failure|  | | <a name=\"360\">360</a>|Aggregation Failure|  | | <a name=\"361\">361</a>|Aggregation Measure Failure|  | | <a name=\"370\">370</a>|Result Retrieval Failure|  | | <a name=\"371\">371</a>|Result Processing Failure|  | | <a name=\"372\">372</a>|Vendor Result Processing Failure|  | | <a name=\"373\">373</a>|Vendor Result Mapping Failure|  | | <a name=\"374\">374</a>|Vendor Library Unauthorised|  | | <a name=\"375\">375</a>|Vendor Connectivity Error|  | | <a name=\"376\">376</a>|Vendor Interface Error|  | | <a name=\"377\">377</a>|Vendor Pricing Failure|  | | <a name=\"378\">378</a>|Vendor Translation Failure|  | | <a name=\"379\">379</a>|Vendor Key Mapping Failure|  | | <a name=\"380\">380</a>|Vendor Reflection Failure|  | | <a name=\"381\">381</a>|Vendor Process Failure|  | | <a name=\"382\">382</a>|Vendor System Failure|  | | <a name=\"390\">390</a>|Attempt To Upsert Duplicate Quotes|  | | <a name=\"391\">391</a>|Corporate Action Source Does Not Exist|  | | <a name=\"392\">392</a>|Corporate Action Source Already Exists|  | | <a name=\"393\">393</a>|Instrument Identifier Already In Use|  | | <a name=\"394\">394</a>|Properties Not Found|  | | <a name=\"395\">395</a>|Batch Operation Aborted|  | | <a name=\"400\">400</a>|Invalid Iso4217 Currency Code|  | | <a name=\"401\">401</a>|Cannot Assign Instrument Identifier To Currency|  | | <a name=\"402\">402</a>|Cannot Assign Currency Identifier To Non Currency|  | | <a name=\"403\">403</a>|Currency Instrument Cannot Be Deleted|  | | <a name=\"404\">404</a>|Currency Instrument Cannot Have Economic Definition|  | | <a name=\"405\">405</a>|Currency Instrument Cannot Have Lookthrough Portfolio|  | | <a name=\"406\">406</a>|Cannot Create Currency Instrument With Multiple Identifiers|  | | <a name=\"407\">407</a>|Specified Currency Is Undefined|  | | <a name=\"410\">410</a>|Index Does Not Exist|  | | <a name=\"411\">411</a>|Sort Field Does Not Exist|  | | <a name=\"413\">413</a>|Negative Pagination Parameters|  | | <a name=\"414\">414</a>|Invalid Search Syntax|  | | <a name=\"415\">415</a>|Filter Execution Timeout|  | | <a name=\"420\">420</a>|Side Definition Inconsistent|  | | <a name=\"450\">450</a>|Invalid Quote Access Metadata Rule|  | | <a name=\"451\">451</a>|Access Metadata Not Found|  | | <a name=\"452\">452</a>|Invalid Access Metadata Identifier|  | | <a name=\"460\">460</a>|Standard Resource Not Found|  | | <a name=\"461\">461</a>|Standard Resource Conflict|  | | <a name=\"462\">462</a>|Calendar Not Found|  | | <a name=\"463\">463</a>|Date In A Calendar Not Found|  | | <a name=\"464\">464</a>|Invalid Date Source Data|  | | <a name=\"465\">465</a>|Invalid Timezone|  | | <a name=\"601\">601</a>|Person Identifier Already In Use|  | | <a name=\"602\">602</a>|Person Not Found|  | | <a name=\"603\">603</a>|Cannot Set Identifier|  | | <a name=\"617\">617</a>|Invalid Recipe Specification In Request|  | | <a name=\"618\">618</a>|Inline Recipe Deserialisation Failure|  | | <a name=\"619\">619</a>|Identifier Types Not Set For Entity|  | | <a name=\"620\">620</a>|Cannot Delete All Client Defined Identifiers|  | | <a name=\"650\">650</a>|The Order requested was not found.|  | | <a name=\"654\">654</a>|The Allocation requested was not found.|  | | <a name=\"655\">655</a>|Cannot build the fx forward target with the given holdings.|  | | <a name=\"656\">656</a>|Group does not contain expected entities.|  | | <a name=\"665\">665</a>|Destination directory not found|  | | <a name=\"667\">667</a>|Relation definition already exists|  | | <a name=\"672\">672</a>|Could not retrieve file contents|  | | <a name=\"673\">673</a>|Missing entitlements for entities in Group|  | | <a name=\"674\">674</a>|Next Best Action not found|  | | <a name=\"676\">676</a>|Relation definition not defined|  | | <a name=\"677\">677</a>|Invalid entity identifier for relation|  | | <a name=\"681\">681</a>|Sorting by specified field not supported|One or more of the provided fields to order by were either invalid or not supported. | | <a name=\"682\">682</a>|Too many fields to sort by|The number of fields to sort the data by exceeds the number allowed by the endpoint | | <a name=\"684\">684</a>|Sequence Not Found|  | | <a name=\"685\">685</a>|Sequence Already Exists|  | | <a name=\"686\">686</a>|Non-cycling sequence has been exhausted|  | | <a name=\"687\">687</a>|Legal Entity Identifier Already In Use|  | | <a name=\"688\">688</a>|Legal Entity Not Found|  | | <a name=\"689\">689</a>|The supplied pagination token is invalid|  | | <a name=\"690\">690</a>|Property Type Is Not Supported|  | | <a name=\"691\">691</a>|Multiple Tax-lots For Currency Type Is Not Supported|  | | <a name=\"692\">692</a>|This endpoint does not support impersonation|  | | <a name=\"693\">693</a>|Entity type is not supported for Relationship|  | | <a name=\"694\">694</a>|Relationship Validation Failure|  | | <a name=\"695\">695</a>|Relationship Not Found|  | | <a name=\"697\">697</a>|Derived Property Formula No Longer Valid|  | | <a name=\"698\">698</a>|Story is not available|  | | <a name=\"703\">703</a>|Corporate Action Does Not Exist|  | | <a name=\"720\">720</a>|The provided sort and filter combination is not valid|  | | <a name=\"721\">721</a>|A2B generation failed|  | | <a name=\"722\">722</a>|Aggregated Return Calculation Failure|  | | <a name=\"723\">723</a>|Custom Entity Definition Identifier Already In Use|  | | <a name=\"724\">724</a>|Custom Entity Definition Not Found|  | | <a name=\"725\">725</a>|The Placement requested was not found.|  | | <a name=\"726\">726</a>|The Execution requested was not found.|  | | <a name=\"727\">727</a>|The Block requested was not found.|  | | <a name=\"728\">728</a>|The Participation requested was not found.|  | | <a name=\"729\">729</a>|The Package requested was not found.|  | | <a name=\"730\">730</a>|The OrderInstruction requested was not found.|  | | <a name=\"732\">732</a>|Custom Entity not found.|  | | <a name=\"733\">733</a>|Custom Entity Identifier already in use.|  | | <a name=\"735\">735</a>|Calculation Failed.|  | | <a name=\"736\">736</a>|An expected key on HttpResponse is missing.|  | | <a name=\"737\">737</a>|A required fee detail is missing.|  | | <a name=\"738\">738</a>|Zero rows were returned from Luminesce|  | | <a name=\"739\">739</a>|Provided Weekend Mask was invalid|  | | <a name=\"742\">742</a>|Custom Entity fields do not match the definition|  | | <a name=\"746\">746</a>|The provided sequence is not valid.|  | | <a name=\"751\">751</a>|The type of the Custom Entity is different than the type provided in the definition.|  | | <a name=\"752\">752</a>|Luminesce process returned an error.|  | | <a name=\"753\">753</a>|File name or content incompatible with operation.|  | | <a name=\"755\">755</a>|Schema of response from Drive is not as expected.|  | | <a name=\"757\">757</a>|Schema of response from Luminesce is not as expected.|  | | <a name=\"758\">758</a>|Luminesce timed out.|  | | <a name=\"763\">763</a>|Invalid Lusid Entity Identifier Unit|  | | <a name=\"768\">768</a>|Fee rule not found.|  | | <a name=\"769\">769</a>|Cannot update the base currency of a portfolio with transactions loaded|  | | <a name=\"771\">771</a>|Transaction configuration source not found|  | | <a name=\"774\">774</a>|Compliance rule not found.|  | | <a name=\"775\">775</a>|Fund accounting document cannot be processed.|  | | <a name=\"778\">778</a>|Unable to look up FX rate from trade ccy to portfolio ccy for some of the trades.|  | | <a name=\"782\">782</a>|The Property definition dataType is not matching the derivation formula dataType|  | | <a name=\"783\">783</a>|The Property definition domain is not supported for derived properties|  | | <a name=\"788\">788</a>|Compliance run not found failure.|  | | <a name=\"790\">790</a>|Custom Entity has missing or invalid identifiers|  | | <a name=\"791\">791</a>|Custom Entity definition already exists|  | | <a name=\"792\">792</a>|Compliance PropertyKey is missing.|  | | <a name=\"793\">793</a>|Compliance Criteria Value for matching is missing.|  | | <a name=\"795\">795</a>|Cannot delete identifier definition|  | | <a name=\"796\">796</a>|Tax rule set not found.|  | | <a name=\"797\">797</a>|A tax rule set with this id already exists.|  | | <a name=\"798\">798</a>|Multiple rule sets for the same property key are applicable.|  | | <a name=\"800\">800</a>|Can not upsert an instrument event of this type.|  | | <a name=\"801\">801</a>|The instrument event does not exist.|  | | <a name=\"802\">802</a>|The Instrument event is missing salient information.|  | | <a name=\"803\">803</a>|The Instrument event could not be processed.|  | | <a name=\"804\">804</a>|Some data requested does not follow the order graph assumptions.|  | | <a name=\"805\">805</a>|The instrument event type does not exist.|  | | <a name=\"806\">806</a>|The transaction template specification does not exist.|  | | <a name=\"807\">807</a>|The default transaction template does not exist.|  | | <a name=\"811\">811</a>|A price could not be found for an order.|  | | <a name=\"812\">812</a>|A price could not be found for an allocation.|  | | <a name=\"813\">813</a>|Chart of Accounts not found.|  | | <a name=\"814\">814</a>|Account not found.|  | | <a name=\"815\">815</a>|Abor not found.|  | | <a name=\"816\">816</a>|Abor Configuration not found.|  | | <a name=\"817\">817</a>|Reconciliation mapping not found|  | | <a name=\"818\">818</a>|Attribute type could not be deleted because it doesn't exist.|  | | <a name=\"819\">819</a>|Reconciliation not found.|  | | <a name=\"820\">820</a>|Custodian Account not found.|  | | <a name=\"821\">821</a>|Allocation Failure|  | | <a name=\"822\">822</a>|Reconciliation run not found|  | | <a name=\"823\">823</a>|Reconciliation break not found|  | | <a name=\"824\">824</a>|Entity link type could not be deleted because it doesn't exist.|  | | <a name=\"828\">828</a>|Address key definition not found.|  | | <a name=\"829\">829</a>|Compliance template not found.|  | | <a name=\"830\">830</a>|Action not supported|  | | <a name=\"831\">831</a>|Reference list not found.|  | | <a name=\"832\">832</a>|Posting Module not found.|  | | <a name=\"833\">833</a>|The type of parameter provided did not match that required by the compliance rule.|  | | <a name=\"834\">834</a>|The parameters provided by a rule did not match those required by its template.|  | | <a name=\"835\">835</a>|The entity has a property in a domain that is not supprted for that entity type.|  | | <a name=\"836\">836</a>|Structured result data not found.|  | | <a name=\"837\">837</a>|Diary entry not found.|  | | <a name=\"838\">838</a>|Diary entry could not be created.|  | | <a name=\"839\">839</a>|Diary entry already exists.|  | | <a name=\"861\">861</a>|Compliance run summary not found.|  | | <a name=\"869\">869</a>|Conflicting instrument properties in batch.|  | | <a name=\"870\">870</a>|Compliance run summary already exists.|  | | <a name=\"871\">871</a>|The specified impersonated user does not exist|  | | <a name=\"874\">874</a>|Provided Property Domain is not supported for entity filter.|  | | <a name=\"875\">875</a>|Cannot Delete System Reference List.|  | | <a name=\"876\">876</a>|Cleardown Module not found.|  | 
 *
 * The version of the OpenAPI document: 1.3.200
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


import com.finbourne.lusid.model.Account;
import com.finbourne.lusid.model.AccountProperties;
import com.finbourne.lusid.model.AccountsUpsertResponse;
import com.finbourne.lusid.model.ChartOfAccounts;
import com.finbourne.lusid.model.ChartOfAccountsProperties;
import com.finbourne.lusid.model.ChartOfAccountsRequest;
import com.finbourne.lusid.model.CleardownModuleDetails;
import com.finbourne.lusid.model.CleardownModuleRequest;
import com.finbourne.lusid.model.CleardownModuleResponse;
import com.finbourne.lusid.model.CleardownModuleRule;
import com.finbourne.lusid.model.CleardownModuleRulesUpdatedResponse;
import com.finbourne.lusid.model.DeleteAccountsResponse;
import com.finbourne.lusid.model.DeletedEntityResponse;
import com.finbourne.lusid.model.GeneralLedgerProfileMapping;
import com.finbourne.lusid.model.GeneralLedgerProfileRequest;
import com.finbourne.lusid.model.GeneralLedgerProfileResponse;
import com.finbourne.lusid.model.LusidProblemDetails;
import com.finbourne.lusid.model.LusidValidationProblemDetails;
import java.time.OffsetDateTime;
import com.finbourne.lusid.model.PagedResourceListOfAccount;
import com.finbourne.lusid.model.PagedResourceListOfChartOfAccounts;
import com.finbourne.lusid.model.PagedResourceListOfCleardownModuleResponse;
import com.finbourne.lusid.model.PagedResourceListOfCleardownModuleRule;
import com.finbourne.lusid.model.PagedResourceListOfGeneralLedgerProfileResponse;
import com.finbourne.lusid.model.PagedResourceListOfPostingModuleResponse;
import com.finbourne.lusid.model.PagedResourceListOfPostingModuleRule;
import com.finbourne.lusid.model.PostingModuleDetails;
import com.finbourne.lusid.model.PostingModuleRequest;
import com.finbourne.lusid.model.PostingModuleResponse;
import com.finbourne.lusid.model.PostingModuleRule;
import com.finbourne.lusid.model.PostingModuleRulesUpdatedResponse;
import com.finbourne.lusid.model.Property;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChartOfAccountsApi {
    private ApiClient localVarApiClient;
    public ChartOfAccountsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public ChartOfAccountsApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for createChartOfAccounts
     * @param scope The scope of the Chart of Accounts. (required)
     * @param chartOfAccountsRequest The definition of the Chart of Accounts. (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> The newly created Chart of Accounts. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createChartOfAccountsCall(String scope, ChartOfAccountsRequest chartOfAccountsRequest, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = chartOfAccountsRequest;

        // create path and map variables
        String localVarPath = "/api/chartofaccounts/{scope}"
            .replaceAll("\\{" + "scope" + "\\}", localVarApiClient.escapeString(scope.toString()));

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
        localVarHeaderParams.put("X-LUSID-SDK-Version", "1.3.200");

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call createChartOfAccountsValidateBeforeCall(String scope, ChartOfAccountsRequest chartOfAccountsRequest, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'scope' is set
        if (scope == null) {
            throw new ApiException("Missing the required parameter 'scope' when calling createChartOfAccounts(Async)");
        }
        
        // verify the required parameter 'chartOfAccountsRequest' is set
        if (chartOfAccountsRequest == null) {
            throw new ApiException("Missing the required parameter 'chartOfAccountsRequest' when calling createChartOfAccounts(Async)");
        }
        

        okhttp3.Call localVarCall = createChartOfAccountsCall(scope, chartOfAccountsRequest, _callback);
        return localVarCall;

    }

    /**
     * [EXPERIMENTAL] CreateChartOfAccounts: Create a Chart of Accounts
     * Create the given Chart of Accounts.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param chartOfAccountsRequest The definition of the Chart of Accounts. (required)
     * @return ChartOfAccounts
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> The newly created Chart of Accounts. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ChartOfAccounts createChartOfAccounts(String scope, ChartOfAccountsRequest chartOfAccountsRequest) throws ApiException {
        ApiResponse<ChartOfAccounts> localVarResp = createChartOfAccountsWithHttpInfo(scope, chartOfAccountsRequest);
        return localVarResp.getData();
    }

    /**
     * [EXPERIMENTAL] CreateChartOfAccounts: Create a Chart of Accounts
     * Create the given Chart of Accounts.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param chartOfAccountsRequest The definition of the Chart of Accounts. (required)
     * @return ApiResponse&lt;ChartOfAccounts&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> The newly created Chart of Accounts. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<ChartOfAccounts> createChartOfAccountsWithHttpInfo(String scope, ChartOfAccountsRequest chartOfAccountsRequest) throws ApiException {
        okhttp3.Call localVarCall = createChartOfAccountsValidateBeforeCall(scope, chartOfAccountsRequest, null);
        Type localVarReturnType = new TypeToken<ChartOfAccounts>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * [EXPERIMENTAL] CreateChartOfAccounts: Create a Chart of Accounts (asynchronously)
     * Create the given Chart of Accounts.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param chartOfAccountsRequest The definition of the Chart of Accounts. (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> The newly created Chart of Accounts. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createChartOfAccountsAsync(String scope, ChartOfAccountsRequest chartOfAccountsRequest, final ApiCallback<ChartOfAccounts> _callback) throws ApiException {
        okhttp3.Call localVarCall = createChartOfAccountsValidateBeforeCall(scope, chartOfAccountsRequest, _callback);
        Type localVarReturnType = new TypeToken<ChartOfAccounts>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for createCleardownModule
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param cleardownModuleRequest The definition of the Cleardown Module. (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> The newly created Cleardown Module. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createCleardownModuleCall(String scope, String code, CleardownModuleRequest cleardownModuleRequest, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = cleardownModuleRequest;

        // create path and map variables
        String localVarPath = "/api/chartofaccounts/{scope}/{code}/cleardownmodules"
            .replaceAll("\\{" + "scope" + "\\}", localVarApiClient.escapeString(scope.toString()))
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
            "application/json-patch+json", "application/json", "text/json", "application/_*+json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);
        localVarHeaderParams.put("X-LUSID-SDK-Language", "Java");
        localVarHeaderParams.put("X-LUSID-SDK-Version", "1.3.200");

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call createCleardownModuleValidateBeforeCall(String scope, String code, CleardownModuleRequest cleardownModuleRequest, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'scope' is set
        if (scope == null) {
            throw new ApiException("Missing the required parameter 'scope' when calling createCleardownModule(Async)");
        }
        
        // verify the required parameter 'code' is set
        if (code == null) {
            throw new ApiException("Missing the required parameter 'code' when calling createCleardownModule(Async)");
        }
        
        // verify the required parameter 'cleardownModuleRequest' is set
        if (cleardownModuleRequest == null) {
            throw new ApiException("Missing the required parameter 'cleardownModuleRequest' when calling createCleardownModule(Async)");
        }
        

        okhttp3.Call localVarCall = createCleardownModuleCall(scope, code, cleardownModuleRequest, _callback);
        return localVarCall;

    }

    /**
     * [EXPERIMENTAL] CreateCleardownModule: Create a Cleardown Module
     * Create the given Cleardown Module.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param cleardownModuleRequest The definition of the Cleardown Module. (required)
     * @return CleardownModuleResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> The newly created Cleardown Module. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public CleardownModuleResponse createCleardownModule(String scope, String code, CleardownModuleRequest cleardownModuleRequest) throws ApiException {
        ApiResponse<CleardownModuleResponse> localVarResp = createCleardownModuleWithHttpInfo(scope, code, cleardownModuleRequest);
        return localVarResp.getData();
    }

    /**
     * [EXPERIMENTAL] CreateCleardownModule: Create a Cleardown Module
     * Create the given Cleardown Module.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param cleardownModuleRequest The definition of the Cleardown Module. (required)
     * @return ApiResponse&lt;CleardownModuleResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> The newly created Cleardown Module. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<CleardownModuleResponse> createCleardownModuleWithHttpInfo(String scope, String code, CleardownModuleRequest cleardownModuleRequest) throws ApiException {
        okhttp3.Call localVarCall = createCleardownModuleValidateBeforeCall(scope, code, cleardownModuleRequest, null);
        Type localVarReturnType = new TypeToken<CleardownModuleResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * [EXPERIMENTAL] CreateCleardownModule: Create a Cleardown Module (asynchronously)
     * Create the given Cleardown Module.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param cleardownModuleRequest The definition of the Cleardown Module. (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> The newly created Cleardown Module. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createCleardownModuleAsync(String scope, String code, CleardownModuleRequest cleardownModuleRequest, final ApiCallback<CleardownModuleResponse> _callback) throws ApiException {
        okhttp3.Call localVarCall = createCleardownModuleValidateBeforeCall(scope, code, cleardownModuleRequest, _callback);
        Type localVarReturnType = new TypeToken<CleardownModuleResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for createGeneralLedgerProfile
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. (required)
     * @param generalLedgerProfileRequest The definition of the General Ledger Profile. (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> The newly created General Ledger Profile. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createGeneralLedgerProfileCall(String scope, String code, GeneralLedgerProfileRequest generalLedgerProfileRequest, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = generalLedgerProfileRequest;

        // create path and map variables
        String localVarPath = "/api/chartofaccounts/{scope}/{code}/generalledgerprofile"
            .replaceAll("\\{" + "scope" + "\\}", localVarApiClient.escapeString(scope.toString()))
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
            "application/json-patch+json", "application/json", "text/json", "application/_*+json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);
        localVarHeaderParams.put("X-LUSID-SDK-Language", "Java");
        localVarHeaderParams.put("X-LUSID-SDK-Version", "1.3.200");

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call createGeneralLedgerProfileValidateBeforeCall(String scope, String code, GeneralLedgerProfileRequest generalLedgerProfileRequest, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'scope' is set
        if (scope == null) {
            throw new ApiException("Missing the required parameter 'scope' when calling createGeneralLedgerProfile(Async)");
        }
        
        // verify the required parameter 'code' is set
        if (code == null) {
            throw new ApiException("Missing the required parameter 'code' when calling createGeneralLedgerProfile(Async)");
        }
        
        // verify the required parameter 'generalLedgerProfileRequest' is set
        if (generalLedgerProfileRequest == null) {
            throw new ApiException("Missing the required parameter 'generalLedgerProfileRequest' when calling createGeneralLedgerProfile(Async)");
        }
        

        okhttp3.Call localVarCall = createGeneralLedgerProfileCall(scope, code, generalLedgerProfileRequest, _callback);
        return localVarCall;

    }

    /**
     * [EXPERIMENTAL] CreateGeneralLedgerProfile: Create a General Ledger Profile.
     * Create the given General Ledger profile.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. (required)
     * @param generalLedgerProfileRequest The definition of the General Ledger Profile. (required)
     * @return GeneralLedgerProfileResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> The newly created General Ledger Profile. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public GeneralLedgerProfileResponse createGeneralLedgerProfile(String scope, String code, GeneralLedgerProfileRequest generalLedgerProfileRequest) throws ApiException {
        ApiResponse<GeneralLedgerProfileResponse> localVarResp = createGeneralLedgerProfileWithHttpInfo(scope, code, generalLedgerProfileRequest);
        return localVarResp.getData();
    }

    /**
     * [EXPERIMENTAL] CreateGeneralLedgerProfile: Create a General Ledger Profile.
     * Create the given General Ledger profile.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. (required)
     * @param generalLedgerProfileRequest The definition of the General Ledger Profile. (required)
     * @return ApiResponse&lt;GeneralLedgerProfileResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> The newly created General Ledger Profile. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<GeneralLedgerProfileResponse> createGeneralLedgerProfileWithHttpInfo(String scope, String code, GeneralLedgerProfileRequest generalLedgerProfileRequest) throws ApiException {
        okhttp3.Call localVarCall = createGeneralLedgerProfileValidateBeforeCall(scope, code, generalLedgerProfileRequest, null);
        Type localVarReturnType = new TypeToken<GeneralLedgerProfileResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * [EXPERIMENTAL] CreateGeneralLedgerProfile: Create a General Ledger Profile. (asynchronously)
     * Create the given General Ledger profile.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. (required)
     * @param generalLedgerProfileRequest The definition of the General Ledger Profile. (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> The newly created General Ledger Profile. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createGeneralLedgerProfileAsync(String scope, String code, GeneralLedgerProfileRequest generalLedgerProfileRequest, final ApiCallback<GeneralLedgerProfileResponse> _callback) throws ApiException {
        okhttp3.Call localVarCall = createGeneralLedgerProfileValidateBeforeCall(scope, code, generalLedgerProfileRequest, _callback);
        Type localVarReturnType = new TypeToken<GeneralLedgerProfileResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for createPostingModule
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param postingModuleRequest The definition of the Posting Module. (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> The newly created Posting Module. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createPostingModuleCall(String scope, String code, PostingModuleRequest postingModuleRequest, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = postingModuleRequest;

        // create path and map variables
        String localVarPath = "/api/chartofaccounts/{scope}/{code}/postingmodules"
            .replaceAll("\\{" + "scope" + "\\}", localVarApiClient.escapeString(scope.toString()))
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
            "application/json-patch+json", "application/json", "text/json", "application/_*+json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);
        localVarHeaderParams.put("X-LUSID-SDK-Language", "Java");
        localVarHeaderParams.put("X-LUSID-SDK-Version", "1.3.200");

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call createPostingModuleValidateBeforeCall(String scope, String code, PostingModuleRequest postingModuleRequest, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'scope' is set
        if (scope == null) {
            throw new ApiException("Missing the required parameter 'scope' when calling createPostingModule(Async)");
        }
        
        // verify the required parameter 'code' is set
        if (code == null) {
            throw new ApiException("Missing the required parameter 'code' when calling createPostingModule(Async)");
        }
        
        // verify the required parameter 'postingModuleRequest' is set
        if (postingModuleRequest == null) {
            throw new ApiException("Missing the required parameter 'postingModuleRequest' when calling createPostingModule(Async)");
        }
        

        okhttp3.Call localVarCall = createPostingModuleCall(scope, code, postingModuleRequest, _callback);
        return localVarCall;

    }

    /**
     * [EXPERIMENTAL] CreatePostingModule: Create a Posting Module
     * Create the given Posting Module.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param postingModuleRequest The definition of the Posting Module. (required)
     * @return PostingModuleResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> The newly created Posting Module. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public PostingModuleResponse createPostingModule(String scope, String code, PostingModuleRequest postingModuleRequest) throws ApiException {
        ApiResponse<PostingModuleResponse> localVarResp = createPostingModuleWithHttpInfo(scope, code, postingModuleRequest);
        return localVarResp.getData();
    }

    /**
     * [EXPERIMENTAL] CreatePostingModule: Create a Posting Module
     * Create the given Posting Module.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param postingModuleRequest The definition of the Posting Module. (required)
     * @return ApiResponse&lt;PostingModuleResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> The newly created Posting Module. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<PostingModuleResponse> createPostingModuleWithHttpInfo(String scope, String code, PostingModuleRequest postingModuleRequest) throws ApiException {
        okhttp3.Call localVarCall = createPostingModuleValidateBeforeCall(scope, code, postingModuleRequest, null);
        Type localVarReturnType = new TypeToken<PostingModuleResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * [EXPERIMENTAL] CreatePostingModule: Create a Posting Module (asynchronously)
     * Create the given Posting Module.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param postingModuleRequest The definition of the Posting Module. (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> The newly created Posting Module. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call createPostingModuleAsync(String scope, String code, PostingModuleRequest postingModuleRequest, final ApiCallback<PostingModuleResponse> _callback) throws ApiException {
        okhttp3.Call localVarCall = createPostingModuleValidateBeforeCall(scope, code, postingModuleRequest, _callback);
        Type localVarReturnType = new TypeToken<PostingModuleResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for deleteAccounts
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies              the Chart of Accounts. (required)
     * @param requestBody The codes of the accounts to delete. (required)
     * @param deleteMode The delete mode to use (defaults to &#39;Soft&#39;). (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The datetime that the Accounts were deleted. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call deleteAccountsCall(String scope, String code, List<String> requestBody, String deleteMode, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = requestBody;

        // create path and map variables
        String localVarPath = "/api/chartofaccounts/{scope}/{code}/accounts/$delete"
            .replaceAll("\\{" + "scope" + "\\}", localVarApiClient.escapeString(scope.toString()))
            .replaceAll("\\{" + "code" + "\\}", localVarApiClient.escapeString(code.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (deleteMode != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("deleteMode", deleteMode));
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
        localVarHeaderParams.put("X-LUSID-SDK-Version", "1.3.200");

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call deleteAccountsValidateBeforeCall(String scope, String code, List<String> requestBody, String deleteMode, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'scope' is set
        if (scope == null) {
            throw new ApiException("Missing the required parameter 'scope' when calling deleteAccounts(Async)");
        }
        
        // verify the required parameter 'code' is set
        if (code == null) {
            throw new ApiException("Missing the required parameter 'code' when calling deleteAccounts(Async)");
        }
        
        // verify the required parameter 'requestBody' is set
        if (requestBody == null) {
            throw new ApiException("Missing the required parameter 'requestBody' when calling deleteAccounts(Async)");
        }
        

        okhttp3.Call localVarCall = deleteAccountsCall(scope, code, requestBody, deleteMode, _callback);
        return localVarCall;

    }

    /**
     * [EXPERIMENTAL] DeleteAccounts: Soft or hard delete multiple accounts
     * Delete one or more account from the Chart of Accounts. Soft deletion marks the account as inactive  While the Hard deletion is deleting the account.  The maximum number of accounts that this method can delete per request is 2,000.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies              the Chart of Accounts. (required)
     * @param requestBody The codes of the accounts to delete. (required)
     * @param deleteMode The delete mode to use (defaults to &#39;Soft&#39;). (optional)
     * @return DeleteAccountsResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The datetime that the Accounts were deleted. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public DeleteAccountsResponse deleteAccounts(String scope, String code, List<String> requestBody, String deleteMode) throws ApiException {
        ApiResponse<DeleteAccountsResponse> localVarResp = deleteAccountsWithHttpInfo(scope, code, requestBody, deleteMode);
        return localVarResp.getData();
    }

    /**
     * [EXPERIMENTAL] DeleteAccounts: Soft or hard delete multiple accounts
     * Delete one or more account from the Chart of Accounts. Soft deletion marks the account as inactive  While the Hard deletion is deleting the account.  The maximum number of accounts that this method can delete per request is 2,000.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies              the Chart of Accounts. (required)
     * @param requestBody The codes of the accounts to delete. (required)
     * @param deleteMode The delete mode to use (defaults to &#39;Soft&#39;). (optional)
     * @return ApiResponse&lt;DeleteAccountsResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The datetime that the Accounts were deleted. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<DeleteAccountsResponse> deleteAccountsWithHttpInfo(String scope, String code, List<String> requestBody, String deleteMode) throws ApiException {
        okhttp3.Call localVarCall = deleteAccountsValidateBeforeCall(scope, code, requestBody, deleteMode, null);
        Type localVarReturnType = new TypeToken<DeleteAccountsResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * [EXPERIMENTAL] DeleteAccounts: Soft or hard delete multiple accounts (asynchronously)
     * Delete one or more account from the Chart of Accounts. Soft deletion marks the account as inactive  While the Hard deletion is deleting the account.  The maximum number of accounts that this method can delete per request is 2,000.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies              the Chart of Accounts. (required)
     * @param requestBody The codes of the accounts to delete. (required)
     * @param deleteMode The delete mode to use (defaults to &#39;Soft&#39;). (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The datetime that the Accounts were deleted. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call deleteAccountsAsync(String scope, String code, List<String> requestBody, String deleteMode, final ApiCallback<DeleteAccountsResponse> _callback) throws ApiException {
        okhttp3.Call localVarCall = deleteAccountsValidateBeforeCall(scope, code, requestBody, deleteMode, _callback);
        Type localVarReturnType = new TypeToken<DeleteAccountsResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for deleteChartOfAccounts
     * @param scope The scope of the Chart of Accounts to be deleted. (required)
     * @param code The code of the Chart of Accounts to be deleted. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The datetime that the Chart of Accounts was deleted. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call deleteChartOfAccountsCall(String scope, String code, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/chartofaccounts/{scope}/{code}"
            .replaceAll("\\{" + "scope" + "\\}", localVarApiClient.escapeString(scope.toString()))
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
        localVarHeaderParams.put("X-LUSID-SDK-Version", "1.3.200");

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call deleteChartOfAccountsValidateBeforeCall(String scope, String code, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'scope' is set
        if (scope == null) {
            throw new ApiException("Missing the required parameter 'scope' when calling deleteChartOfAccounts(Async)");
        }
        
        // verify the required parameter 'code' is set
        if (code == null) {
            throw new ApiException("Missing the required parameter 'code' when calling deleteChartOfAccounts(Async)");
        }
        

        okhttp3.Call localVarCall = deleteChartOfAccountsCall(scope, code, _callback);
        return localVarCall;

    }

    /**
     * [EXPERIMENTAL] DeleteChartOfAccounts: Delete a Chart of Accounts
     * Delete the given Chart of Accounts.
     * @param scope The scope of the Chart of Accounts to be deleted. (required)
     * @param code The code of the Chart of Accounts to be deleted. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @return DeletedEntityResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The datetime that the Chart of Accounts was deleted. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public DeletedEntityResponse deleteChartOfAccounts(String scope, String code) throws ApiException {
        ApiResponse<DeletedEntityResponse> localVarResp = deleteChartOfAccountsWithHttpInfo(scope, code);
        return localVarResp.getData();
    }

    /**
     * [EXPERIMENTAL] DeleteChartOfAccounts: Delete a Chart of Accounts
     * Delete the given Chart of Accounts.
     * @param scope The scope of the Chart of Accounts to be deleted. (required)
     * @param code The code of the Chart of Accounts to be deleted. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @return ApiResponse&lt;DeletedEntityResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The datetime that the Chart of Accounts was deleted. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<DeletedEntityResponse> deleteChartOfAccountsWithHttpInfo(String scope, String code) throws ApiException {
        okhttp3.Call localVarCall = deleteChartOfAccountsValidateBeforeCall(scope, code, null);
        Type localVarReturnType = new TypeToken<DeletedEntityResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * [EXPERIMENTAL] DeleteChartOfAccounts: Delete a Chart of Accounts (asynchronously)
     * Delete the given Chart of Accounts.
     * @param scope The scope of the Chart of Accounts to be deleted. (required)
     * @param code The code of the Chart of Accounts to be deleted. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The datetime that the Chart of Accounts was deleted. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call deleteChartOfAccountsAsync(String scope, String code, final ApiCallback<DeletedEntityResponse> _callback) throws ApiException {
        okhttp3.Call localVarCall = deleteChartOfAccountsValidateBeforeCall(scope, code, _callback);
        Type localVarReturnType = new TypeToken<DeletedEntityResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for deleteCleardownModule
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param cleardownModuleCode The code of the Cleardown Module to be deleted. (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The datetime that the Cleardown Module was deleted. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call deleteCleardownModuleCall(String scope, String code, String cleardownModuleCode, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/chartofaccounts/{scope}/{code}/cleardownmodules/{cleardownModuleCode}"
            .replaceAll("\\{" + "scope" + "\\}", localVarApiClient.escapeString(scope.toString()))
            .replaceAll("\\{" + "code" + "\\}", localVarApiClient.escapeString(code.toString()))
            .replaceAll("\\{" + "cleardownModuleCode" + "\\}", localVarApiClient.escapeString(cleardownModuleCode.toString()));

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
        localVarHeaderParams.put("X-LUSID-SDK-Version", "1.3.200");

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call deleteCleardownModuleValidateBeforeCall(String scope, String code, String cleardownModuleCode, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'scope' is set
        if (scope == null) {
            throw new ApiException("Missing the required parameter 'scope' when calling deleteCleardownModule(Async)");
        }
        
        // verify the required parameter 'code' is set
        if (code == null) {
            throw new ApiException("Missing the required parameter 'code' when calling deleteCleardownModule(Async)");
        }
        
        // verify the required parameter 'cleardownModuleCode' is set
        if (cleardownModuleCode == null) {
            throw new ApiException("Missing the required parameter 'cleardownModuleCode' when calling deleteCleardownModule(Async)");
        }
        

        okhttp3.Call localVarCall = deleteCleardownModuleCall(scope, code, cleardownModuleCode, _callback);
        return localVarCall;

    }

    /**
     * [EXPERIMENTAL] DeleteCleardownModule: Delete a Cleardown Module.
     * Delete the given Cleardown Module.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param cleardownModuleCode The code of the Cleardown Module to be deleted. (required)
     * @return DeletedEntityResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The datetime that the Cleardown Module was deleted. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public DeletedEntityResponse deleteCleardownModule(String scope, String code, String cleardownModuleCode) throws ApiException {
        ApiResponse<DeletedEntityResponse> localVarResp = deleteCleardownModuleWithHttpInfo(scope, code, cleardownModuleCode);
        return localVarResp.getData();
    }

    /**
     * [EXPERIMENTAL] DeleteCleardownModule: Delete a Cleardown Module.
     * Delete the given Cleardown Module.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param cleardownModuleCode The code of the Cleardown Module to be deleted. (required)
     * @return ApiResponse&lt;DeletedEntityResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The datetime that the Cleardown Module was deleted. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<DeletedEntityResponse> deleteCleardownModuleWithHttpInfo(String scope, String code, String cleardownModuleCode) throws ApiException {
        okhttp3.Call localVarCall = deleteCleardownModuleValidateBeforeCall(scope, code, cleardownModuleCode, null);
        Type localVarReturnType = new TypeToken<DeletedEntityResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * [EXPERIMENTAL] DeleteCleardownModule: Delete a Cleardown Module. (asynchronously)
     * Delete the given Cleardown Module.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param cleardownModuleCode The code of the Cleardown Module to be deleted. (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The datetime that the Cleardown Module was deleted. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call deleteCleardownModuleAsync(String scope, String code, String cleardownModuleCode, final ApiCallback<DeletedEntityResponse> _callback) throws ApiException {
        okhttp3.Call localVarCall = deleteCleardownModuleValidateBeforeCall(scope, code, cleardownModuleCode, _callback);
        Type localVarReturnType = new TypeToken<DeletedEntityResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for deleteGeneralLedgerProfile
     * @param scope The scope of the Chart of Accounts for the General Ledger Profile. (required)
     * @param code The code of the Chart of Accounts for the General Ledger Profile. (required)
     * @param generalLedgerProfileCode The Code of the General Ledger Profile. (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The datetime that the General Ledger Profile was deleted </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call deleteGeneralLedgerProfileCall(String scope, String code, String generalLedgerProfileCode, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/chartofaccounts/{scope}/{code}/generalledgerprofile/{generalLedgerProfileCode}"
            .replaceAll("\\{" + "scope" + "\\}", localVarApiClient.escapeString(scope.toString()))
            .replaceAll("\\{" + "code" + "\\}", localVarApiClient.escapeString(code.toString()))
            .replaceAll("\\{" + "generalLedgerProfileCode" + "\\}", localVarApiClient.escapeString(generalLedgerProfileCode.toString()));

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
        localVarHeaderParams.put("X-LUSID-SDK-Version", "1.3.200");

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call deleteGeneralLedgerProfileValidateBeforeCall(String scope, String code, String generalLedgerProfileCode, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'scope' is set
        if (scope == null) {
            throw new ApiException("Missing the required parameter 'scope' when calling deleteGeneralLedgerProfile(Async)");
        }
        
        // verify the required parameter 'code' is set
        if (code == null) {
            throw new ApiException("Missing the required parameter 'code' when calling deleteGeneralLedgerProfile(Async)");
        }
        
        // verify the required parameter 'generalLedgerProfileCode' is set
        if (generalLedgerProfileCode == null) {
            throw new ApiException("Missing the required parameter 'generalLedgerProfileCode' when calling deleteGeneralLedgerProfile(Async)");
        }
        

        okhttp3.Call localVarCall = deleteGeneralLedgerProfileCall(scope, code, generalLedgerProfileCode, _callback);
        return localVarCall;

    }

    /**
     * [EXPERIMENTAL] DeleteGeneralLedgerProfile: Delete a General Ledger Profile.
     * Delete the given General Ledger Profile.
     * @param scope The scope of the Chart of Accounts for the General Ledger Profile. (required)
     * @param code The code of the Chart of Accounts for the General Ledger Profile. (required)
     * @param generalLedgerProfileCode The Code of the General Ledger Profile. (required)
     * @return DeletedEntityResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The datetime that the General Ledger Profile was deleted </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public DeletedEntityResponse deleteGeneralLedgerProfile(String scope, String code, String generalLedgerProfileCode) throws ApiException {
        ApiResponse<DeletedEntityResponse> localVarResp = deleteGeneralLedgerProfileWithHttpInfo(scope, code, generalLedgerProfileCode);
        return localVarResp.getData();
    }

    /**
     * [EXPERIMENTAL] DeleteGeneralLedgerProfile: Delete a General Ledger Profile.
     * Delete the given General Ledger Profile.
     * @param scope The scope of the Chart of Accounts for the General Ledger Profile. (required)
     * @param code The code of the Chart of Accounts for the General Ledger Profile. (required)
     * @param generalLedgerProfileCode The Code of the General Ledger Profile. (required)
     * @return ApiResponse&lt;DeletedEntityResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The datetime that the General Ledger Profile was deleted </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<DeletedEntityResponse> deleteGeneralLedgerProfileWithHttpInfo(String scope, String code, String generalLedgerProfileCode) throws ApiException {
        okhttp3.Call localVarCall = deleteGeneralLedgerProfileValidateBeforeCall(scope, code, generalLedgerProfileCode, null);
        Type localVarReturnType = new TypeToken<DeletedEntityResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * [EXPERIMENTAL] DeleteGeneralLedgerProfile: Delete a General Ledger Profile. (asynchronously)
     * Delete the given General Ledger Profile.
     * @param scope The scope of the Chart of Accounts for the General Ledger Profile. (required)
     * @param code The code of the Chart of Accounts for the General Ledger Profile. (required)
     * @param generalLedgerProfileCode The Code of the General Ledger Profile. (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The datetime that the General Ledger Profile was deleted </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call deleteGeneralLedgerProfileAsync(String scope, String code, String generalLedgerProfileCode, final ApiCallback<DeletedEntityResponse> _callback) throws ApiException {
        okhttp3.Call localVarCall = deleteGeneralLedgerProfileValidateBeforeCall(scope, code, generalLedgerProfileCode, _callback);
        Type localVarReturnType = new TypeToken<DeletedEntityResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for deletePostingModule
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param postingModuleCode The code of the Posting Module to be deleted. (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The datetime that the Posting Module was deleted. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call deletePostingModuleCall(String scope, String code, String postingModuleCode, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/chartofaccounts/{scope}/{code}/postingmodules/{postingModuleCode}"
            .replaceAll("\\{" + "scope" + "\\}", localVarApiClient.escapeString(scope.toString()))
            .replaceAll("\\{" + "code" + "\\}", localVarApiClient.escapeString(code.toString()))
            .replaceAll("\\{" + "postingModuleCode" + "\\}", localVarApiClient.escapeString(postingModuleCode.toString()));

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
        localVarHeaderParams.put("X-LUSID-SDK-Version", "1.3.200");

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call deletePostingModuleValidateBeforeCall(String scope, String code, String postingModuleCode, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'scope' is set
        if (scope == null) {
            throw new ApiException("Missing the required parameter 'scope' when calling deletePostingModule(Async)");
        }
        
        // verify the required parameter 'code' is set
        if (code == null) {
            throw new ApiException("Missing the required parameter 'code' when calling deletePostingModule(Async)");
        }
        
        // verify the required parameter 'postingModuleCode' is set
        if (postingModuleCode == null) {
            throw new ApiException("Missing the required parameter 'postingModuleCode' when calling deletePostingModule(Async)");
        }
        

        okhttp3.Call localVarCall = deletePostingModuleCall(scope, code, postingModuleCode, _callback);
        return localVarCall;

    }

    /**
     * [EXPERIMENTAL] DeletePostingModule: Delete a Posting Module.
     * Delete the given Posting Module.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param postingModuleCode The code of the Posting Module to be deleted. (required)
     * @return DeletedEntityResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The datetime that the Posting Module was deleted. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public DeletedEntityResponse deletePostingModule(String scope, String code, String postingModuleCode) throws ApiException {
        ApiResponse<DeletedEntityResponse> localVarResp = deletePostingModuleWithHttpInfo(scope, code, postingModuleCode);
        return localVarResp.getData();
    }

    /**
     * [EXPERIMENTAL] DeletePostingModule: Delete a Posting Module.
     * Delete the given Posting Module.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param postingModuleCode The code of the Posting Module to be deleted. (required)
     * @return ApiResponse&lt;DeletedEntityResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The datetime that the Posting Module was deleted. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<DeletedEntityResponse> deletePostingModuleWithHttpInfo(String scope, String code, String postingModuleCode) throws ApiException {
        okhttp3.Call localVarCall = deletePostingModuleValidateBeforeCall(scope, code, postingModuleCode, null);
        Type localVarReturnType = new TypeToken<DeletedEntityResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * [EXPERIMENTAL] DeletePostingModule: Delete a Posting Module. (asynchronously)
     * Delete the given Posting Module.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param postingModuleCode The code of the Posting Module to be deleted. (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The datetime that the Posting Module was deleted. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call deletePostingModuleAsync(String scope, String code, String postingModuleCode, final ApiCallback<DeletedEntityResponse> _callback) throws ApiException {
        okhttp3.Call localVarCall = deletePostingModuleValidateBeforeCall(scope, code, postingModuleCode, _callback);
        Type localVarReturnType = new TypeToken<DeletedEntityResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getAccount
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param accountCode The code of the Account. (required)
     * @param effectiveAt The effective datetime or cut label at which to retrieve the Account properties. Defaults to the current LUSID system datetime if not specified. (optional)
     * @param asAt The asAt datetime at which to retrieve the Account definition. Defaults to returning the latest version of the Account definition if not specified. (optional)
     * @param propertyKeys A list of property keys from the &#39;Account&#39; domain to decorate onto the Account.              These must take the format {domain}/{scope}/{code}, for example &#39;Account/Manager/Id&#39;. If not provided will return all the entitled properties for that Account. (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The requested Account definition. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getAccountCall(String scope, String code, String accountCode, String effectiveAt, OffsetDateTime asAt, List<String> propertyKeys, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/chartofaccounts/{scope}/{code}/accounts/{accountCode}"
            .replaceAll("\\{" + "scope" + "\\}", localVarApiClient.escapeString(scope.toString()))
            .replaceAll("\\{" + "code" + "\\}", localVarApiClient.escapeString(code.toString()))
            .replaceAll("\\{" + "accountCode" + "\\}", localVarApiClient.escapeString(accountCode.toString()));

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
        localVarHeaderParams.put("X-LUSID-SDK-Version", "1.3.200");

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getAccountValidateBeforeCall(String scope, String code, String accountCode, String effectiveAt, OffsetDateTime asAt, List<String> propertyKeys, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'scope' is set
        if (scope == null) {
            throw new ApiException("Missing the required parameter 'scope' when calling getAccount(Async)");
        }
        
        // verify the required parameter 'code' is set
        if (code == null) {
            throw new ApiException("Missing the required parameter 'code' when calling getAccount(Async)");
        }
        
        // verify the required parameter 'accountCode' is set
        if (accountCode == null) {
            throw new ApiException("Missing the required parameter 'accountCode' when calling getAccount(Async)");
        }
        

        okhttp3.Call localVarCall = getAccountCall(scope, code, accountCode, effectiveAt, asAt, propertyKeys, _callback);
        return localVarCall;

    }

    /**
     * [EXPERIMENTAL] GetAccount: Get Account
     * Retrieve the definition of a particular Account which is part of a Chart of Accounts.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param accountCode The code of the Account. (required)
     * @param effectiveAt The effective datetime or cut label at which to retrieve the Account properties. Defaults to the current LUSID system datetime if not specified. (optional)
     * @param asAt The asAt datetime at which to retrieve the Account definition. Defaults to returning the latest version of the Account definition if not specified. (optional)
     * @param propertyKeys A list of property keys from the &#39;Account&#39; domain to decorate onto the Account.              These must take the format {domain}/{scope}/{code}, for example &#39;Account/Manager/Id&#39;. If not provided will return all the entitled properties for that Account. (optional)
     * @return Account
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The requested Account definition. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public Account getAccount(String scope, String code, String accountCode, String effectiveAt, OffsetDateTime asAt, List<String> propertyKeys) throws ApiException {
        ApiResponse<Account> localVarResp = getAccountWithHttpInfo(scope, code, accountCode, effectiveAt, asAt, propertyKeys);
        return localVarResp.getData();
    }

    /**
     * [EXPERIMENTAL] GetAccount: Get Account
     * Retrieve the definition of a particular Account which is part of a Chart of Accounts.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param accountCode The code of the Account. (required)
     * @param effectiveAt The effective datetime or cut label at which to retrieve the Account properties. Defaults to the current LUSID system datetime if not specified. (optional)
     * @param asAt The asAt datetime at which to retrieve the Account definition. Defaults to returning the latest version of the Account definition if not specified. (optional)
     * @param propertyKeys A list of property keys from the &#39;Account&#39; domain to decorate onto the Account.              These must take the format {domain}/{scope}/{code}, for example &#39;Account/Manager/Id&#39;. If not provided will return all the entitled properties for that Account. (optional)
     * @return ApiResponse&lt;Account&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The requested Account definition. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<Account> getAccountWithHttpInfo(String scope, String code, String accountCode, String effectiveAt, OffsetDateTime asAt, List<String> propertyKeys) throws ApiException {
        okhttp3.Call localVarCall = getAccountValidateBeforeCall(scope, code, accountCode, effectiveAt, asAt, propertyKeys, null);
        Type localVarReturnType = new TypeToken<Account>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * [EXPERIMENTAL] GetAccount: Get Account (asynchronously)
     * Retrieve the definition of a particular Account which is part of a Chart of Accounts.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param accountCode The code of the Account. (required)
     * @param effectiveAt The effective datetime or cut label at which to retrieve the Account properties. Defaults to the current LUSID system datetime if not specified. (optional)
     * @param asAt The asAt datetime at which to retrieve the Account definition. Defaults to returning the latest version of the Account definition if not specified. (optional)
     * @param propertyKeys A list of property keys from the &#39;Account&#39; domain to decorate onto the Account.              These must take the format {domain}/{scope}/{code}, for example &#39;Account/Manager/Id&#39;. If not provided will return all the entitled properties for that Account. (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The requested Account definition. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getAccountAsync(String scope, String code, String accountCode, String effectiveAt, OffsetDateTime asAt, List<String> propertyKeys, final ApiCallback<Account> _callback) throws ApiException {
        okhttp3.Call localVarCall = getAccountValidateBeforeCall(scope, code, accountCode, effectiveAt, asAt, propertyKeys, _callback);
        Type localVarReturnType = new TypeToken<Account>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getChartOfAccounts
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param effectiveAt The effective datetime or cut label at which to retrieve the Chart of Accounts properties. Defaults to the current LUSID system datetime if not specified. (optional)
     * @param asAt The asAt datetime at which to retrieve the Chart of Accounts definition. Defaults to returning the latest version of the Chart of Accounts definition if not specified. (optional)
     * @param propertyKeys A list of property keys from the &#39;ChartOfAccounts&#39; domain to decorate onto the Chart of Accounts.              These must take the format {domain}/{scope}/{code}, for example &#39;ChartOfAccounts/Manager/Id&#39;. If not provided will return all the entitled properties for that Chart of Accounts. (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The requested Chart Of Accounts definition. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getChartOfAccountsCall(String scope, String code, String effectiveAt, OffsetDateTime asAt, List<String> propertyKeys, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/chartofaccounts/{scope}/{code}"
            .replaceAll("\\{" + "scope" + "\\}", localVarApiClient.escapeString(scope.toString()))
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
        localVarHeaderParams.put("X-LUSID-SDK-Version", "1.3.200");

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getChartOfAccountsValidateBeforeCall(String scope, String code, String effectiveAt, OffsetDateTime asAt, List<String> propertyKeys, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'scope' is set
        if (scope == null) {
            throw new ApiException("Missing the required parameter 'scope' when calling getChartOfAccounts(Async)");
        }
        
        // verify the required parameter 'code' is set
        if (code == null) {
            throw new ApiException("Missing the required parameter 'code' when calling getChartOfAccounts(Async)");
        }
        

        okhttp3.Call localVarCall = getChartOfAccountsCall(scope, code, effectiveAt, asAt, propertyKeys, _callback);
        return localVarCall;

    }

    /**
     * [EXPERIMENTAL] GetChartOfAccounts: Get ChartOfAccounts
     * Retrieve the definition of a particular Chart of Accounts.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param effectiveAt The effective datetime or cut label at which to retrieve the Chart of Accounts properties. Defaults to the current LUSID system datetime if not specified. (optional)
     * @param asAt The asAt datetime at which to retrieve the Chart of Accounts definition. Defaults to returning the latest version of the Chart of Accounts definition if not specified. (optional)
     * @param propertyKeys A list of property keys from the &#39;ChartOfAccounts&#39; domain to decorate onto the Chart of Accounts.              These must take the format {domain}/{scope}/{code}, for example &#39;ChartOfAccounts/Manager/Id&#39;. If not provided will return all the entitled properties for that Chart of Accounts. (optional)
     * @return ChartOfAccounts
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The requested Chart Of Accounts definition. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ChartOfAccounts getChartOfAccounts(String scope, String code, String effectiveAt, OffsetDateTime asAt, List<String> propertyKeys) throws ApiException {
        ApiResponse<ChartOfAccounts> localVarResp = getChartOfAccountsWithHttpInfo(scope, code, effectiveAt, asAt, propertyKeys);
        return localVarResp.getData();
    }

    /**
     * [EXPERIMENTAL] GetChartOfAccounts: Get ChartOfAccounts
     * Retrieve the definition of a particular Chart of Accounts.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param effectiveAt The effective datetime or cut label at which to retrieve the Chart of Accounts properties. Defaults to the current LUSID system datetime if not specified. (optional)
     * @param asAt The asAt datetime at which to retrieve the Chart of Accounts definition. Defaults to returning the latest version of the Chart of Accounts definition if not specified. (optional)
     * @param propertyKeys A list of property keys from the &#39;ChartOfAccounts&#39; domain to decorate onto the Chart of Accounts.              These must take the format {domain}/{scope}/{code}, for example &#39;ChartOfAccounts/Manager/Id&#39;. If not provided will return all the entitled properties for that Chart of Accounts. (optional)
     * @return ApiResponse&lt;ChartOfAccounts&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The requested Chart Of Accounts definition. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<ChartOfAccounts> getChartOfAccountsWithHttpInfo(String scope, String code, String effectiveAt, OffsetDateTime asAt, List<String> propertyKeys) throws ApiException {
        okhttp3.Call localVarCall = getChartOfAccountsValidateBeforeCall(scope, code, effectiveAt, asAt, propertyKeys, null);
        Type localVarReturnType = new TypeToken<ChartOfAccounts>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * [EXPERIMENTAL] GetChartOfAccounts: Get ChartOfAccounts (asynchronously)
     * Retrieve the definition of a particular Chart of Accounts.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param effectiveAt The effective datetime or cut label at which to retrieve the Chart of Accounts properties. Defaults to the current LUSID system datetime if not specified. (optional)
     * @param asAt The asAt datetime at which to retrieve the Chart of Accounts definition. Defaults to returning the latest version of the Chart of Accounts definition if not specified. (optional)
     * @param propertyKeys A list of property keys from the &#39;ChartOfAccounts&#39; domain to decorate onto the Chart of Accounts.              These must take the format {domain}/{scope}/{code}, for example &#39;ChartOfAccounts/Manager/Id&#39;. If not provided will return all the entitled properties for that Chart of Accounts. (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The requested Chart Of Accounts definition. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getChartOfAccountsAsync(String scope, String code, String effectiveAt, OffsetDateTime asAt, List<String> propertyKeys, final ApiCallback<ChartOfAccounts> _callback) throws ApiException {
        okhttp3.Call localVarCall = getChartOfAccountsValidateBeforeCall(scope, code, effectiveAt, asAt, propertyKeys, _callback);
        Type localVarReturnType = new TypeToken<ChartOfAccounts>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getCleardownModule
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param cleardownModuleCode The code of the Cleardown Module. (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The full definition of the Cleardown Module. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getCleardownModuleCall(String scope, String code, String cleardownModuleCode, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/chartofaccounts/{scope}/{code}/cleardownmodules/{cleardownModuleCode}"
            .replaceAll("\\{" + "scope" + "\\}", localVarApiClient.escapeString(scope.toString()))
            .replaceAll("\\{" + "code" + "\\}", localVarApiClient.escapeString(code.toString()))
            .replaceAll("\\{" + "cleardownModuleCode" + "\\}", localVarApiClient.escapeString(cleardownModuleCode.toString()));

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
        localVarHeaderParams.put("X-LUSID-SDK-Version", "1.3.200");

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getCleardownModuleValidateBeforeCall(String scope, String code, String cleardownModuleCode, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'scope' is set
        if (scope == null) {
            throw new ApiException("Missing the required parameter 'scope' when calling getCleardownModule(Async)");
        }
        
        // verify the required parameter 'code' is set
        if (code == null) {
            throw new ApiException("Missing the required parameter 'code' when calling getCleardownModule(Async)");
        }
        
        // verify the required parameter 'cleardownModuleCode' is set
        if (cleardownModuleCode == null) {
            throw new ApiException("Missing the required parameter 'cleardownModuleCode' when calling getCleardownModule(Async)");
        }
        

        okhttp3.Call localVarCall = getCleardownModuleCall(scope, code, cleardownModuleCode, _callback);
        return localVarCall;

    }

    /**
     * [EXPERIMENTAL] GetCleardownModule: Get a Cleardown Module
     * Retrieve the definition of a Cleardown Module complete with its rules.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param cleardownModuleCode The code of the Cleardown Module. (required)
     * @return CleardownModuleResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The full definition of the Cleardown Module. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public CleardownModuleResponse getCleardownModule(String scope, String code, String cleardownModuleCode) throws ApiException {
        ApiResponse<CleardownModuleResponse> localVarResp = getCleardownModuleWithHttpInfo(scope, code, cleardownModuleCode);
        return localVarResp.getData();
    }

    /**
     * [EXPERIMENTAL] GetCleardownModule: Get a Cleardown Module
     * Retrieve the definition of a Cleardown Module complete with its rules.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param cleardownModuleCode The code of the Cleardown Module. (required)
     * @return ApiResponse&lt;CleardownModuleResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The full definition of the Cleardown Module. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<CleardownModuleResponse> getCleardownModuleWithHttpInfo(String scope, String code, String cleardownModuleCode) throws ApiException {
        okhttp3.Call localVarCall = getCleardownModuleValidateBeforeCall(scope, code, cleardownModuleCode, null);
        Type localVarReturnType = new TypeToken<CleardownModuleResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * [EXPERIMENTAL] GetCleardownModule: Get a Cleardown Module (asynchronously)
     * Retrieve the definition of a Cleardown Module complete with its rules.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param cleardownModuleCode The code of the Cleardown Module. (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The full definition of the Cleardown Module. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getCleardownModuleAsync(String scope, String code, String cleardownModuleCode, final ApiCallback<CleardownModuleResponse> _callback) throws ApiException {
        okhttp3.Call localVarCall = getCleardownModuleValidateBeforeCall(scope, code, cleardownModuleCode, _callback);
        Type localVarReturnType = new TypeToken<CleardownModuleResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getGeneralLedgerProfile
     * @param scope The scope of the Chart of Accounts for the General Ledger Profile. (required)
     * @param code The code of the Chart of Accounts for the General Ledger Profile. (required)
     * @param generalLedgerProfileCode The General Ledger Profile Code of the General Ledger Profile. (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The requested General Ledger Profile entry. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getGeneralLedgerProfileCall(String scope, String code, String generalLedgerProfileCode, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/chartofaccounts/{scope}/{code}/generalledgerprofile/{generalLedgerProfileCode}"
            .replaceAll("\\{" + "scope" + "\\}", localVarApiClient.escapeString(scope.toString()))
            .replaceAll("\\{" + "code" + "\\}", localVarApiClient.escapeString(code.toString()))
            .replaceAll("\\{" + "generalLedgerProfileCode" + "\\}", localVarApiClient.escapeString(generalLedgerProfileCode.toString()));

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
        localVarHeaderParams.put("X-LUSID-SDK-Version", "1.3.200");

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getGeneralLedgerProfileValidateBeforeCall(String scope, String code, String generalLedgerProfileCode, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'scope' is set
        if (scope == null) {
            throw new ApiException("Missing the required parameter 'scope' when calling getGeneralLedgerProfile(Async)");
        }
        
        // verify the required parameter 'code' is set
        if (code == null) {
            throw new ApiException("Missing the required parameter 'code' when calling getGeneralLedgerProfile(Async)");
        }
        
        // verify the required parameter 'generalLedgerProfileCode' is set
        if (generalLedgerProfileCode == null) {
            throw new ApiException("Missing the required parameter 'generalLedgerProfileCode' when calling getGeneralLedgerProfile(Async)");
        }
        

        okhttp3.Call localVarCall = getGeneralLedgerProfileCall(scope, code, generalLedgerProfileCode, _callback);
        return localVarCall;

    }

    /**
     * [EXPERIMENTAL] GetGeneralLedgerProfile: Get a General Ledger Profile.
     * Get the given General Ledger Profile.
     * @param scope The scope of the Chart of Accounts for the General Ledger Profile. (required)
     * @param code The code of the Chart of Accounts for the General Ledger Profile. (required)
     * @param generalLedgerProfileCode The General Ledger Profile Code of the General Ledger Profile. (required)
     * @return GeneralLedgerProfileResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The requested General Ledger Profile entry. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public GeneralLedgerProfileResponse getGeneralLedgerProfile(String scope, String code, String generalLedgerProfileCode) throws ApiException {
        ApiResponse<GeneralLedgerProfileResponse> localVarResp = getGeneralLedgerProfileWithHttpInfo(scope, code, generalLedgerProfileCode);
        return localVarResp.getData();
    }

    /**
     * [EXPERIMENTAL] GetGeneralLedgerProfile: Get a General Ledger Profile.
     * Get the given General Ledger Profile.
     * @param scope The scope of the Chart of Accounts for the General Ledger Profile. (required)
     * @param code The code of the Chart of Accounts for the General Ledger Profile. (required)
     * @param generalLedgerProfileCode The General Ledger Profile Code of the General Ledger Profile. (required)
     * @return ApiResponse&lt;GeneralLedgerProfileResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The requested General Ledger Profile entry. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<GeneralLedgerProfileResponse> getGeneralLedgerProfileWithHttpInfo(String scope, String code, String generalLedgerProfileCode) throws ApiException {
        okhttp3.Call localVarCall = getGeneralLedgerProfileValidateBeforeCall(scope, code, generalLedgerProfileCode, null);
        Type localVarReturnType = new TypeToken<GeneralLedgerProfileResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * [EXPERIMENTAL] GetGeneralLedgerProfile: Get a General Ledger Profile. (asynchronously)
     * Get the given General Ledger Profile.
     * @param scope The scope of the Chart of Accounts for the General Ledger Profile. (required)
     * @param code The code of the Chart of Accounts for the General Ledger Profile. (required)
     * @param generalLedgerProfileCode The General Ledger Profile Code of the General Ledger Profile. (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The requested General Ledger Profile entry. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getGeneralLedgerProfileAsync(String scope, String code, String generalLedgerProfileCode, final ApiCallback<GeneralLedgerProfileResponse> _callback) throws ApiException {
        okhttp3.Call localVarCall = getGeneralLedgerProfileValidateBeforeCall(scope, code, generalLedgerProfileCode, _callback);
        Type localVarReturnType = new TypeToken<GeneralLedgerProfileResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getPostingModule
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param postingModuleCode The code of the Posting Module. (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The full definition of the Posting Module. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getPostingModuleCall(String scope, String code, String postingModuleCode, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/chartofaccounts/{scope}/{code}/postingmodules/{postingModuleCode}"
            .replaceAll("\\{" + "scope" + "\\}", localVarApiClient.escapeString(scope.toString()))
            .replaceAll("\\{" + "code" + "\\}", localVarApiClient.escapeString(code.toString()))
            .replaceAll("\\{" + "postingModuleCode" + "\\}", localVarApiClient.escapeString(postingModuleCode.toString()));

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
        localVarHeaderParams.put("X-LUSID-SDK-Version", "1.3.200");

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getPostingModuleValidateBeforeCall(String scope, String code, String postingModuleCode, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'scope' is set
        if (scope == null) {
            throw new ApiException("Missing the required parameter 'scope' when calling getPostingModule(Async)");
        }
        
        // verify the required parameter 'code' is set
        if (code == null) {
            throw new ApiException("Missing the required parameter 'code' when calling getPostingModule(Async)");
        }
        
        // verify the required parameter 'postingModuleCode' is set
        if (postingModuleCode == null) {
            throw new ApiException("Missing the required parameter 'postingModuleCode' when calling getPostingModule(Async)");
        }
        

        okhttp3.Call localVarCall = getPostingModuleCall(scope, code, postingModuleCode, _callback);
        return localVarCall;

    }

    /**
     * [EXPERIMENTAL] GetPostingModule: Get a Posting Module
     * Retrieve the definition of a Posting Module complete with its rules.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param postingModuleCode The code of the Posting Module. (required)
     * @return PostingModuleResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The full definition of the Posting Module. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public PostingModuleResponse getPostingModule(String scope, String code, String postingModuleCode) throws ApiException {
        ApiResponse<PostingModuleResponse> localVarResp = getPostingModuleWithHttpInfo(scope, code, postingModuleCode);
        return localVarResp.getData();
    }

    /**
     * [EXPERIMENTAL] GetPostingModule: Get a Posting Module
     * Retrieve the definition of a Posting Module complete with its rules.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param postingModuleCode The code of the Posting Module. (required)
     * @return ApiResponse&lt;PostingModuleResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The full definition of the Posting Module. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<PostingModuleResponse> getPostingModuleWithHttpInfo(String scope, String code, String postingModuleCode) throws ApiException {
        okhttp3.Call localVarCall = getPostingModuleValidateBeforeCall(scope, code, postingModuleCode, null);
        Type localVarReturnType = new TypeToken<PostingModuleResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * [EXPERIMENTAL] GetPostingModule: Get a Posting Module (asynchronously)
     * Retrieve the definition of a Posting Module complete with its rules.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param postingModuleCode The code of the Posting Module. (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The full definition of the Posting Module. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getPostingModuleAsync(String scope, String code, String postingModuleCode, final ApiCallback<PostingModuleResponse> _callback) throws ApiException {
        okhttp3.Call localVarCall = getPostingModuleValidateBeforeCall(scope, code, postingModuleCode, _callback);
        Type localVarReturnType = new TypeToken<PostingModuleResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for listAccounts
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies              the Chart of Accounts. (required)
     * @param effectiveAt The effective datetime or cut label at which to list the TimeVariant properties decorated on Accounts. Defaults to the current LUSID              system datetime if not specified. (optional)
     * @param asAt The asAt datetime at which to retrieve the Accounts. Defaults to              returning the latest version if not specified. (optional)
     * @param page The pagination token to use to continue listing charts of accounts; this              value is returned from the previous call. If a pagination token is provided, the filter, effectiveAt              and asAt fields must not have changed since the original request. (optional)
     * @param limit When paginating, limit the results to this number. Defaults to 100 if not specified. (optional)
     * @param filter Expression to filter the results.              For example, to filter on the Account type, specify \&quot;code eq &#39;001&#39;\&quot;. For more information about filtering              results, see https://support.lusid.com/knowledgebase/article/KA-01914. (optional)
     * @param propertyKeys A list of property keys from the &#39;Account&#39; domain to decorate onto the Account.              These must have the format {domain}/{scope}/{code}, for example &#39;Account/system/Name&#39;. (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The Accounts in the given Chart of Accounts. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listAccountsCall(String scope, String code, String effectiveAt, OffsetDateTime asAt, String page, Integer limit, String filter, List<String> propertyKeys, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/chartofaccounts/{scope}/{code}/accounts"
            .replaceAll("\\{" + "scope" + "\\}", localVarApiClient.escapeString(scope.toString()))
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
        localVarHeaderParams.put("X-LUSID-SDK-Version", "1.3.200");

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call listAccountsValidateBeforeCall(String scope, String code, String effectiveAt, OffsetDateTime asAt, String page, Integer limit, String filter, List<String> propertyKeys, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'scope' is set
        if (scope == null) {
            throw new ApiException("Missing the required parameter 'scope' when calling listAccounts(Async)");
        }
        
        // verify the required parameter 'code' is set
        if (code == null) {
            throw new ApiException("Missing the required parameter 'code' when calling listAccounts(Async)");
        }
        

        okhttp3.Call localVarCall = listAccountsCall(scope, code, effectiveAt, asAt, page, limit, filter, propertyKeys, _callback);
        return localVarCall;

    }

    /**
     * [EXPERIMENTAL] ListAccounts: List Accounts
     * List the accounts in a Chart of Accounts
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies              the Chart of Accounts. (required)
     * @param effectiveAt The effective datetime or cut label at which to list the TimeVariant properties decorated on Accounts. Defaults to the current LUSID              system datetime if not specified. (optional)
     * @param asAt The asAt datetime at which to retrieve the Accounts. Defaults to              returning the latest version if not specified. (optional)
     * @param page The pagination token to use to continue listing charts of accounts; this              value is returned from the previous call. If a pagination token is provided, the filter, effectiveAt              and asAt fields must not have changed since the original request. (optional)
     * @param limit When paginating, limit the results to this number. Defaults to 100 if not specified. (optional)
     * @param filter Expression to filter the results.              For example, to filter on the Account type, specify \&quot;code eq &#39;001&#39;\&quot;. For more information about filtering              results, see https://support.lusid.com/knowledgebase/article/KA-01914. (optional)
     * @param propertyKeys A list of property keys from the &#39;Account&#39; domain to decorate onto the Account.              These must have the format {domain}/{scope}/{code}, for example &#39;Account/system/Name&#39;. (optional)
     * @return PagedResourceListOfAccount
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The Accounts in the given Chart of Accounts. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public PagedResourceListOfAccount listAccounts(String scope, String code, String effectiveAt, OffsetDateTime asAt, String page, Integer limit, String filter, List<String> propertyKeys) throws ApiException {
        ApiResponse<PagedResourceListOfAccount> localVarResp = listAccountsWithHttpInfo(scope, code, effectiveAt, asAt, page, limit, filter, propertyKeys);
        return localVarResp.getData();
    }

    /**
     * [EXPERIMENTAL] ListAccounts: List Accounts
     * List the accounts in a Chart of Accounts
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies              the Chart of Accounts. (required)
     * @param effectiveAt The effective datetime or cut label at which to list the TimeVariant properties decorated on Accounts. Defaults to the current LUSID              system datetime if not specified. (optional)
     * @param asAt The asAt datetime at which to retrieve the Accounts. Defaults to              returning the latest version if not specified. (optional)
     * @param page The pagination token to use to continue listing charts of accounts; this              value is returned from the previous call. If a pagination token is provided, the filter, effectiveAt              and asAt fields must not have changed since the original request. (optional)
     * @param limit When paginating, limit the results to this number. Defaults to 100 if not specified. (optional)
     * @param filter Expression to filter the results.              For example, to filter on the Account type, specify \&quot;code eq &#39;001&#39;\&quot;. For more information about filtering              results, see https://support.lusid.com/knowledgebase/article/KA-01914. (optional)
     * @param propertyKeys A list of property keys from the &#39;Account&#39; domain to decorate onto the Account.              These must have the format {domain}/{scope}/{code}, for example &#39;Account/system/Name&#39;. (optional)
     * @return ApiResponse&lt;PagedResourceListOfAccount&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The Accounts in the given Chart of Accounts. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<PagedResourceListOfAccount> listAccountsWithHttpInfo(String scope, String code, String effectiveAt, OffsetDateTime asAt, String page, Integer limit, String filter, List<String> propertyKeys) throws ApiException {
        okhttp3.Call localVarCall = listAccountsValidateBeforeCall(scope, code, effectiveAt, asAt, page, limit, filter, propertyKeys, null);
        Type localVarReturnType = new TypeToken<PagedResourceListOfAccount>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * [EXPERIMENTAL] ListAccounts: List Accounts (asynchronously)
     * List the accounts in a Chart of Accounts
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies              the Chart of Accounts. (required)
     * @param effectiveAt The effective datetime or cut label at which to list the TimeVariant properties decorated on Accounts. Defaults to the current LUSID              system datetime if not specified. (optional)
     * @param asAt The asAt datetime at which to retrieve the Accounts. Defaults to              returning the latest version if not specified. (optional)
     * @param page The pagination token to use to continue listing charts of accounts; this              value is returned from the previous call. If a pagination token is provided, the filter, effectiveAt              and asAt fields must not have changed since the original request. (optional)
     * @param limit When paginating, limit the results to this number. Defaults to 100 if not specified. (optional)
     * @param filter Expression to filter the results.              For example, to filter on the Account type, specify \&quot;code eq &#39;001&#39;\&quot;. For more information about filtering              results, see https://support.lusid.com/knowledgebase/article/KA-01914. (optional)
     * @param propertyKeys A list of property keys from the &#39;Account&#39; domain to decorate onto the Account.              These must have the format {domain}/{scope}/{code}, for example &#39;Account/system/Name&#39;. (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The Accounts in the given Chart of Accounts. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listAccountsAsync(String scope, String code, String effectiveAt, OffsetDateTime asAt, String page, Integer limit, String filter, List<String> propertyKeys, final ApiCallback<PagedResourceListOfAccount> _callback) throws ApiException {
        okhttp3.Call localVarCall = listAccountsValidateBeforeCall(scope, code, effectiveAt, asAt, page, limit, filter, propertyKeys, _callback);
        Type localVarReturnType = new TypeToken<PagedResourceListOfAccount>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for listChartsOfAccounts
     * @param effectiveAt The effective datetime or cut label at which to list the TimeVariant properties for the Chart Of Accounts. Defaults to the current LUSID              system datetime if not specified. (optional)
     * @param asAt The asAt datetime at which to list the charts of accounts. Defaults to returning the latest version              of each Chart of Accounts if not specified. (optional)
     * @param page The pagination token to use to continue listing charts of accounts; this              value is returned from the previous call. If a pagination token is provided, the filter, effectiveAt              and asAt fields must not have changed since the original request. (optional)
     * @param limit When paginating, limit the results to this number. Defaults to 100 if not specified. (optional)
     * @param filter Expression to filter the results.              For example, to filter on the Chart of Accounts type, specify \&quot;id.Code eq &#39;001&#39;\&quot;. For more information about filtering              results, see https://support.lusid.com/knowledgebase/article/KA-01914. (optional)
     * @param propertyKeys A list of property keys from the &#39;ChartOfAccounts&#39; domain to decorate onto each Chart of Accounts.              These must take the format {domain}/{scope}/{code}, for example &#39;ChartOfAccounts/Manager/Id&#39;. (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The requested Charts of Accounts. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listChartsOfAccountsCall(String effectiveAt, OffsetDateTime asAt, String page, Integer limit, String filter, List<String> propertyKeys, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/chartofaccounts";

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
        localVarHeaderParams.put("X-LUSID-SDK-Version", "1.3.200");

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call listChartsOfAccountsValidateBeforeCall(String effectiveAt, OffsetDateTime asAt, String page, Integer limit, String filter, List<String> propertyKeys, final ApiCallback _callback) throws ApiException {
        

        okhttp3.Call localVarCall = listChartsOfAccountsCall(effectiveAt, asAt, page, limit, filter, propertyKeys, _callback);
        return localVarCall;

    }

    /**
     * [EXPERIMENTAL] ListChartsOfAccounts: List Charts of Accounts
     * List all the Charts of Accounts matching particular criteria.
     * @param effectiveAt The effective datetime or cut label at which to list the TimeVariant properties for the Chart Of Accounts. Defaults to the current LUSID              system datetime if not specified. (optional)
     * @param asAt The asAt datetime at which to list the charts of accounts. Defaults to returning the latest version              of each Chart of Accounts if not specified. (optional)
     * @param page The pagination token to use to continue listing charts of accounts; this              value is returned from the previous call. If a pagination token is provided, the filter, effectiveAt              and asAt fields must not have changed since the original request. (optional)
     * @param limit When paginating, limit the results to this number. Defaults to 100 if not specified. (optional)
     * @param filter Expression to filter the results.              For example, to filter on the Chart of Accounts type, specify \&quot;id.Code eq &#39;001&#39;\&quot;. For more information about filtering              results, see https://support.lusid.com/knowledgebase/article/KA-01914. (optional)
     * @param propertyKeys A list of property keys from the &#39;ChartOfAccounts&#39; domain to decorate onto each Chart of Accounts.              These must take the format {domain}/{scope}/{code}, for example &#39;ChartOfAccounts/Manager/Id&#39;. (optional)
     * @return PagedResourceListOfChartOfAccounts
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The requested Charts of Accounts. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public PagedResourceListOfChartOfAccounts listChartsOfAccounts(String effectiveAt, OffsetDateTime asAt, String page, Integer limit, String filter, List<String> propertyKeys) throws ApiException {
        ApiResponse<PagedResourceListOfChartOfAccounts> localVarResp = listChartsOfAccountsWithHttpInfo(effectiveAt, asAt, page, limit, filter, propertyKeys);
        return localVarResp.getData();
    }

    /**
     * [EXPERIMENTAL] ListChartsOfAccounts: List Charts of Accounts
     * List all the Charts of Accounts matching particular criteria.
     * @param effectiveAt The effective datetime or cut label at which to list the TimeVariant properties for the Chart Of Accounts. Defaults to the current LUSID              system datetime if not specified. (optional)
     * @param asAt The asAt datetime at which to list the charts of accounts. Defaults to returning the latest version              of each Chart of Accounts if not specified. (optional)
     * @param page The pagination token to use to continue listing charts of accounts; this              value is returned from the previous call. If a pagination token is provided, the filter, effectiveAt              and asAt fields must not have changed since the original request. (optional)
     * @param limit When paginating, limit the results to this number. Defaults to 100 if not specified. (optional)
     * @param filter Expression to filter the results.              For example, to filter on the Chart of Accounts type, specify \&quot;id.Code eq &#39;001&#39;\&quot;. For more information about filtering              results, see https://support.lusid.com/knowledgebase/article/KA-01914. (optional)
     * @param propertyKeys A list of property keys from the &#39;ChartOfAccounts&#39; domain to decorate onto each Chart of Accounts.              These must take the format {domain}/{scope}/{code}, for example &#39;ChartOfAccounts/Manager/Id&#39;. (optional)
     * @return ApiResponse&lt;PagedResourceListOfChartOfAccounts&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The requested Charts of Accounts. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<PagedResourceListOfChartOfAccounts> listChartsOfAccountsWithHttpInfo(String effectiveAt, OffsetDateTime asAt, String page, Integer limit, String filter, List<String> propertyKeys) throws ApiException {
        okhttp3.Call localVarCall = listChartsOfAccountsValidateBeforeCall(effectiveAt, asAt, page, limit, filter, propertyKeys, null);
        Type localVarReturnType = new TypeToken<PagedResourceListOfChartOfAccounts>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * [EXPERIMENTAL] ListChartsOfAccounts: List Charts of Accounts (asynchronously)
     * List all the Charts of Accounts matching particular criteria.
     * @param effectiveAt The effective datetime or cut label at which to list the TimeVariant properties for the Chart Of Accounts. Defaults to the current LUSID              system datetime if not specified. (optional)
     * @param asAt The asAt datetime at which to list the charts of accounts. Defaults to returning the latest version              of each Chart of Accounts if not specified. (optional)
     * @param page The pagination token to use to continue listing charts of accounts; this              value is returned from the previous call. If a pagination token is provided, the filter, effectiveAt              and asAt fields must not have changed since the original request. (optional)
     * @param limit When paginating, limit the results to this number. Defaults to 100 if not specified. (optional)
     * @param filter Expression to filter the results.              For example, to filter on the Chart of Accounts type, specify \&quot;id.Code eq &#39;001&#39;\&quot;. For more information about filtering              results, see https://support.lusid.com/knowledgebase/article/KA-01914. (optional)
     * @param propertyKeys A list of property keys from the &#39;ChartOfAccounts&#39; domain to decorate onto each Chart of Accounts.              These must take the format {domain}/{scope}/{code}, for example &#39;ChartOfAccounts/Manager/Id&#39;. (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The requested Charts of Accounts. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listChartsOfAccountsAsync(String effectiveAt, OffsetDateTime asAt, String page, Integer limit, String filter, List<String> propertyKeys, final ApiCallback<PagedResourceListOfChartOfAccounts> _callback) throws ApiException {
        okhttp3.Call localVarCall = listChartsOfAccountsValidateBeforeCall(effectiveAt, asAt, page, limit, filter, propertyKeys, _callback);
        Type localVarReturnType = new TypeToken<PagedResourceListOfChartOfAccounts>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for listCleardownModuleRules
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param cleardownModuleCode The code of the cleardown module. (required)
     * @param asAt The asAt datetime at which to retrieve the instrument. Defaults to              returning the latest version if not specified. (optional)
     * @param page The pagination token to use to continue listing cleardown module rules; this              value is returned from the previous call. If a pagination token is provided, the filter              and asAt fields must not have changed since the original request. (optional)
     * @param limit When paginating, limit the results to this number. Defaults to 100 if not specified. (optional)
     * @param filter Expression to filter the results.              For example, to filter on the rule id, specify \&quot;ruleId eq &#39;rule 1&#39;\&quot;. For more information about filtering              results, see https://support.lusid.com/knowledgebase/article/KA-01914. (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The rules in the given Cleardown Module. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listCleardownModuleRulesCall(String scope, String code, String cleardownModuleCode, OffsetDateTime asAt, String page, Integer limit, String filter, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/chartofaccounts/{scope}/{code}/cleardownmodules/{cleardownModuleCode}/cleardownrules"
            .replaceAll("\\{" + "scope" + "\\}", localVarApiClient.escapeString(scope.toString()))
            .replaceAll("\\{" + "code" + "\\}", localVarApiClient.escapeString(code.toString()))
            .replaceAll("\\{" + "cleardownModuleCode" + "\\}", localVarApiClient.escapeString(cleardownModuleCode.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

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
        localVarHeaderParams.put("X-LUSID-SDK-Version", "1.3.200");

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call listCleardownModuleRulesValidateBeforeCall(String scope, String code, String cleardownModuleCode, OffsetDateTime asAt, String page, Integer limit, String filter, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'scope' is set
        if (scope == null) {
            throw new ApiException("Missing the required parameter 'scope' when calling listCleardownModuleRules(Async)");
        }
        
        // verify the required parameter 'code' is set
        if (code == null) {
            throw new ApiException("Missing the required parameter 'code' when calling listCleardownModuleRules(Async)");
        }
        
        // verify the required parameter 'cleardownModuleCode' is set
        if (cleardownModuleCode == null) {
            throw new ApiException("Missing the required parameter 'cleardownModuleCode' when calling listCleardownModuleRules(Async)");
        }
        

        okhttp3.Call localVarCall = listCleardownModuleRulesCall(scope, code, cleardownModuleCode, asAt, page, limit, filter, _callback);
        return localVarCall;

    }

    /**
     * [EXPERIMENTAL] ListCleardownModuleRules: List Cleardown Module Rules
     * List the Rules in a Cleardown Module
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param cleardownModuleCode The code of the cleardown module. (required)
     * @param asAt The asAt datetime at which to retrieve the instrument. Defaults to              returning the latest version if not specified. (optional)
     * @param page The pagination token to use to continue listing cleardown module rules; this              value is returned from the previous call. If a pagination token is provided, the filter              and asAt fields must not have changed since the original request. (optional)
     * @param limit When paginating, limit the results to this number. Defaults to 100 if not specified. (optional)
     * @param filter Expression to filter the results.              For example, to filter on the rule id, specify \&quot;ruleId eq &#39;rule 1&#39;\&quot;. For more information about filtering              results, see https://support.lusid.com/knowledgebase/article/KA-01914. (optional)
     * @return PagedResourceListOfCleardownModuleRule
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The rules in the given Cleardown Module. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public PagedResourceListOfCleardownModuleRule listCleardownModuleRules(String scope, String code, String cleardownModuleCode, OffsetDateTime asAt, String page, Integer limit, String filter) throws ApiException {
        ApiResponse<PagedResourceListOfCleardownModuleRule> localVarResp = listCleardownModuleRulesWithHttpInfo(scope, code, cleardownModuleCode, asAt, page, limit, filter);
        return localVarResp.getData();
    }

    /**
     * [EXPERIMENTAL] ListCleardownModuleRules: List Cleardown Module Rules
     * List the Rules in a Cleardown Module
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param cleardownModuleCode The code of the cleardown module. (required)
     * @param asAt The asAt datetime at which to retrieve the instrument. Defaults to              returning the latest version if not specified. (optional)
     * @param page The pagination token to use to continue listing cleardown module rules; this              value is returned from the previous call. If a pagination token is provided, the filter              and asAt fields must not have changed since the original request. (optional)
     * @param limit When paginating, limit the results to this number. Defaults to 100 if not specified. (optional)
     * @param filter Expression to filter the results.              For example, to filter on the rule id, specify \&quot;ruleId eq &#39;rule 1&#39;\&quot;. For more information about filtering              results, see https://support.lusid.com/knowledgebase/article/KA-01914. (optional)
     * @return ApiResponse&lt;PagedResourceListOfCleardownModuleRule&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The rules in the given Cleardown Module. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<PagedResourceListOfCleardownModuleRule> listCleardownModuleRulesWithHttpInfo(String scope, String code, String cleardownModuleCode, OffsetDateTime asAt, String page, Integer limit, String filter) throws ApiException {
        okhttp3.Call localVarCall = listCleardownModuleRulesValidateBeforeCall(scope, code, cleardownModuleCode, asAt, page, limit, filter, null);
        Type localVarReturnType = new TypeToken<PagedResourceListOfCleardownModuleRule>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * [EXPERIMENTAL] ListCleardownModuleRules: List Cleardown Module Rules (asynchronously)
     * List the Rules in a Cleardown Module
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param cleardownModuleCode The code of the cleardown module. (required)
     * @param asAt The asAt datetime at which to retrieve the instrument. Defaults to              returning the latest version if not specified. (optional)
     * @param page The pagination token to use to continue listing cleardown module rules; this              value is returned from the previous call. If a pagination token is provided, the filter              and asAt fields must not have changed since the original request. (optional)
     * @param limit When paginating, limit the results to this number. Defaults to 100 if not specified. (optional)
     * @param filter Expression to filter the results.              For example, to filter on the rule id, specify \&quot;ruleId eq &#39;rule 1&#39;\&quot;. For more information about filtering              results, see https://support.lusid.com/knowledgebase/article/KA-01914. (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The rules in the given Cleardown Module. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listCleardownModuleRulesAsync(String scope, String code, String cleardownModuleCode, OffsetDateTime asAt, String page, Integer limit, String filter, final ApiCallback<PagedResourceListOfCleardownModuleRule> _callback) throws ApiException {
        okhttp3.Call localVarCall = listCleardownModuleRulesValidateBeforeCall(scope, code, cleardownModuleCode, asAt, page, limit, filter, _callback);
        Type localVarReturnType = new TypeToken<PagedResourceListOfCleardownModuleRule>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for listCleardownModules
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param asAt The asAt datetime at which to list the Cleardown Module. Defaults to returning the latest version              of each Cleardown Module if not specified. (optional)
     * @param page The pagination token to use to continue listing Cleardown Modules; this              value is returned from the previous call. If a pagination token is provided, the filter, effectiveAt              and asAt fields must not have changed since the original request. (optional)
     * @param limit When paginating, limit the results to this number. Defaults to 100 if not specified. (optional)
     * @param filter Expression to filter the results.              For example, to filter on the Cleardown Module status, specify \&quot;status eq &#39;Active&#39;\&quot;. For more information about filtering              results, see https://support.lusid.com/knowledgebase/article/KA-01914. (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The requested Cleardown Modules. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listCleardownModulesCall(String scope, String code, OffsetDateTime asAt, String page, Integer limit, String filter, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/chartofaccounts/{scope}/{code}/cleardownmodules"
            .replaceAll("\\{" + "scope" + "\\}", localVarApiClient.escapeString(scope.toString()))
            .replaceAll("\\{" + "code" + "\\}", localVarApiClient.escapeString(code.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

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
        localVarHeaderParams.put("X-LUSID-SDK-Version", "1.3.200");

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call listCleardownModulesValidateBeforeCall(String scope, String code, OffsetDateTime asAt, String page, Integer limit, String filter, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'scope' is set
        if (scope == null) {
            throw new ApiException("Missing the required parameter 'scope' when calling listCleardownModules(Async)");
        }
        
        // verify the required parameter 'code' is set
        if (code == null) {
            throw new ApiException("Missing the required parameter 'code' when calling listCleardownModules(Async)");
        }
        

        okhttp3.Call localVarCall = listCleardownModulesCall(scope, code, asAt, page, limit, filter, _callback);
        return localVarCall;

    }

    /**
     * [EXPERIMENTAL] ListCleardownModules: List Cleardown Modules
     * List all the Cleardown Modules matching particular criteria.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param asAt The asAt datetime at which to list the Cleardown Module. Defaults to returning the latest version              of each Cleardown Module if not specified. (optional)
     * @param page The pagination token to use to continue listing Cleardown Modules; this              value is returned from the previous call. If a pagination token is provided, the filter, effectiveAt              and asAt fields must not have changed since the original request. (optional)
     * @param limit When paginating, limit the results to this number. Defaults to 100 if not specified. (optional)
     * @param filter Expression to filter the results.              For example, to filter on the Cleardown Module status, specify \&quot;status eq &#39;Active&#39;\&quot;. For more information about filtering              results, see https://support.lusid.com/knowledgebase/article/KA-01914. (optional)
     * @return PagedResourceListOfCleardownModuleResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The requested Cleardown Modules. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public PagedResourceListOfCleardownModuleResponse listCleardownModules(String scope, String code, OffsetDateTime asAt, String page, Integer limit, String filter) throws ApiException {
        ApiResponse<PagedResourceListOfCleardownModuleResponse> localVarResp = listCleardownModulesWithHttpInfo(scope, code, asAt, page, limit, filter);
        return localVarResp.getData();
    }

    /**
     * [EXPERIMENTAL] ListCleardownModules: List Cleardown Modules
     * List all the Cleardown Modules matching particular criteria.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param asAt The asAt datetime at which to list the Cleardown Module. Defaults to returning the latest version              of each Cleardown Module if not specified. (optional)
     * @param page The pagination token to use to continue listing Cleardown Modules; this              value is returned from the previous call. If a pagination token is provided, the filter, effectiveAt              and asAt fields must not have changed since the original request. (optional)
     * @param limit When paginating, limit the results to this number. Defaults to 100 if not specified. (optional)
     * @param filter Expression to filter the results.              For example, to filter on the Cleardown Module status, specify \&quot;status eq &#39;Active&#39;\&quot;. For more information about filtering              results, see https://support.lusid.com/knowledgebase/article/KA-01914. (optional)
     * @return ApiResponse&lt;PagedResourceListOfCleardownModuleResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The requested Cleardown Modules. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<PagedResourceListOfCleardownModuleResponse> listCleardownModulesWithHttpInfo(String scope, String code, OffsetDateTime asAt, String page, Integer limit, String filter) throws ApiException {
        okhttp3.Call localVarCall = listCleardownModulesValidateBeforeCall(scope, code, asAt, page, limit, filter, null);
        Type localVarReturnType = new TypeToken<PagedResourceListOfCleardownModuleResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * [EXPERIMENTAL] ListCleardownModules: List Cleardown Modules (asynchronously)
     * List all the Cleardown Modules matching particular criteria.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param asAt The asAt datetime at which to list the Cleardown Module. Defaults to returning the latest version              of each Cleardown Module if not specified. (optional)
     * @param page The pagination token to use to continue listing Cleardown Modules; this              value is returned from the previous call. If a pagination token is provided, the filter, effectiveAt              and asAt fields must not have changed since the original request. (optional)
     * @param limit When paginating, limit the results to this number. Defaults to 100 if not specified. (optional)
     * @param filter Expression to filter the results.              For example, to filter on the Cleardown Module status, specify \&quot;status eq &#39;Active&#39;\&quot;. For more information about filtering              results, see https://support.lusid.com/knowledgebase/article/KA-01914. (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The requested Cleardown Modules. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listCleardownModulesAsync(String scope, String code, OffsetDateTime asAt, String page, Integer limit, String filter, final ApiCallback<PagedResourceListOfCleardownModuleResponse> _callback) throws ApiException {
        okhttp3.Call localVarCall = listCleardownModulesValidateBeforeCall(scope, code, asAt, page, limit, filter, _callback);
        Type localVarReturnType = new TypeToken<PagedResourceListOfCleardownModuleResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for listGeneralLedgerProfiles
     * @param scope The scope of the Chart of Accounts (required)
     * @param code The code of the Chart of Accounts (required)
     * @param asAt The asAt datetime at which to list the General Ledger Profiles. Defaults to returning the latest version of each General Ledger Profile if not specified. (optional)
     * @param page The pagination token to use to continue listing General Ledger Profiles; this              value is returned from the previous call. If a pagination token is provided, the filter, effectiveAt              and asAt fields must not have changed since the original request. (optional)
     * @param limit When paginating, limit the results to this number. Defaults to 100 if not specified. (optional)
     * @param filter Expression to filter the results.              For example, to filter on the General Ledger profiles type, specify \&quot;type eq &#39;PeriodBoundary&#39;\&quot;. For more information about filtering              results, see https://support.lusid.com/knowledgebase/article/KA-01914. (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The requested General Ledger Profile entries. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listGeneralLedgerProfilesCall(String scope, String code, OffsetDateTime asAt, String page, Integer limit, String filter, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/chartofaccounts/{scope}/{code}/generalledgerprofile"
            .replaceAll("\\{" + "scope" + "\\}", localVarApiClient.escapeString(scope.toString()))
            .replaceAll("\\{" + "code" + "\\}", localVarApiClient.escapeString(code.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

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
        localVarHeaderParams.put("X-LUSID-SDK-Version", "1.3.200");

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call listGeneralLedgerProfilesValidateBeforeCall(String scope, String code, OffsetDateTime asAt, String page, Integer limit, String filter, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'scope' is set
        if (scope == null) {
            throw new ApiException("Missing the required parameter 'scope' when calling listGeneralLedgerProfiles(Async)");
        }
        
        // verify the required parameter 'code' is set
        if (code == null) {
            throw new ApiException("Missing the required parameter 'code' when calling listGeneralLedgerProfiles(Async)");
        }
        

        okhttp3.Call localVarCall = listGeneralLedgerProfilesCall(scope, code, asAt, page, limit, filter, _callback);
        return localVarCall;

    }

    /**
     * [EXPERIMENTAL] ListGeneralLedgerProfiles: List General Ledger Profiles.
     * List all the General Ledger profiles matching particular criteria.
     * @param scope The scope of the Chart of Accounts (required)
     * @param code The code of the Chart of Accounts (required)
     * @param asAt The asAt datetime at which to list the General Ledger Profiles. Defaults to returning the latest version of each General Ledger Profile if not specified. (optional)
     * @param page The pagination token to use to continue listing General Ledger Profiles; this              value is returned from the previous call. If a pagination token is provided, the filter, effectiveAt              and asAt fields must not have changed since the original request. (optional)
     * @param limit When paginating, limit the results to this number. Defaults to 100 if not specified. (optional)
     * @param filter Expression to filter the results.              For example, to filter on the General Ledger profiles type, specify \&quot;type eq &#39;PeriodBoundary&#39;\&quot;. For more information about filtering              results, see https://support.lusid.com/knowledgebase/article/KA-01914. (optional)
     * @return PagedResourceListOfGeneralLedgerProfileResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The requested General Ledger Profile entries. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public PagedResourceListOfGeneralLedgerProfileResponse listGeneralLedgerProfiles(String scope, String code, OffsetDateTime asAt, String page, Integer limit, String filter) throws ApiException {
        ApiResponse<PagedResourceListOfGeneralLedgerProfileResponse> localVarResp = listGeneralLedgerProfilesWithHttpInfo(scope, code, asAt, page, limit, filter);
        return localVarResp.getData();
    }

    /**
     * [EXPERIMENTAL] ListGeneralLedgerProfiles: List General Ledger Profiles.
     * List all the General Ledger profiles matching particular criteria.
     * @param scope The scope of the Chart of Accounts (required)
     * @param code The code of the Chart of Accounts (required)
     * @param asAt The asAt datetime at which to list the General Ledger Profiles. Defaults to returning the latest version of each General Ledger Profile if not specified. (optional)
     * @param page The pagination token to use to continue listing General Ledger Profiles; this              value is returned from the previous call. If a pagination token is provided, the filter, effectiveAt              and asAt fields must not have changed since the original request. (optional)
     * @param limit When paginating, limit the results to this number. Defaults to 100 if not specified. (optional)
     * @param filter Expression to filter the results.              For example, to filter on the General Ledger profiles type, specify \&quot;type eq &#39;PeriodBoundary&#39;\&quot;. For more information about filtering              results, see https://support.lusid.com/knowledgebase/article/KA-01914. (optional)
     * @return ApiResponse&lt;PagedResourceListOfGeneralLedgerProfileResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The requested General Ledger Profile entries. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<PagedResourceListOfGeneralLedgerProfileResponse> listGeneralLedgerProfilesWithHttpInfo(String scope, String code, OffsetDateTime asAt, String page, Integer limit, String filter) throws ApiException {
        okhttp3.Call localVarCall = listGeneralLedgerProfilesValidateBeforeCall(scope, code, asAt, page, limit, filter, null);
        Type localVarReturnType = new TypeToken<PagedResourceListOfGeneralLedgerProfileResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * [EXPERIMENTAL] ListGeneralLedgerProfiles: List General Ledger Profiles. (asynchronously)
     * List all the General Ledger profiles matching particular criteria.
     * @param scope The scope of the Chart of Accounts (required)
     * @param code The code of the Chart of Accounts (required)
     * @param asAt The asAt datetime at which to list the General Ledger Profiles. Defaults to returning the latest version of each General Ledger Profile if not specified. (optional)
     * @param page The pagination token to use to continue listing General Ledger Profiles; this              value is returned from the previous call. If a pagination token is provided, the filter, effectiveAt              and asAt fields must not have changed since the original request. (optional)
     * @param limit When paginating, limit the results to this number. Defaults to 100 if not specified. (optional)
     * @param filter Expression to filter the results.              For example, to filter on the General Ledger profiles type, specify \&quot;type eq &#39;PeriodBoundary&#39;\&quot;. For more information about filtering              results, see https://support.lusid.com/knowledgebase/article/KA-01914. (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The requested General Ledger Profile entries. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listGeneralLedgerProfilesAsync(String scope, String code, OffsetDateTime asAt, String page, Integer limit, String filter, final ApiCallback<PagedResourceListOfGeneralLedgerProfileResponse> _callback) throws ApiException {
        okhttp3.Call localVarCall = listGeneralLedgerProfilesValidateBeforeCall(scope, code, asAt, page, limit, filter, _callback);
        Type localVarReturnType = new TypeToken<PagedResourceListOfGeneralLedgerProfileResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for listPostingModuleRules
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param postingModuleCode The code of the posting module. (required)
     * @param asAt The asAt datetime at which to retrieve the instrument. Defaults to              returning the latest version if not specified. (optional)
     * @param page The pagination token to use to continue listing posting module rules; this              value is returned from the previous call. If a pagination token is provided, the filter              and asAt fields must not have changed since the original request. (optional)
     * @param limit When paginating, limit the results to this number. Defaults to 100 if not specified. (optional)
     * @param filter Expression to filter the results.              For example, to filter on the rule id, specify \&quot;ruleId eq &#39;rule 1&#39;\&quot;. For more information about filtering              results, see https://support.lusid.com/knowledgebase/article/KA-01914. (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The rules in the given Posting Module. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listPostingModuleRulesCall(String scope, String code, String postingModuleCode, OffsetDateTime asAt, String page, Integer limit, String filter, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/chartofaccounts/{scope}/{code}/postingmodules/{postingModuleCode}/postingrules"
            .replaceAll("\\{" + "scope" + "\\}", localVarApiClient.escapeString(scope.toString()))
            .replaceAll("\\{" + "code" + "\\}", localVarApiClient.escapeString(code.toString()))
            .replaceAll("\\{" + "postingModuleCode" + "\\}", localVarApiClient.escapeString(postingModuleCode.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

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
        localVarHeaderParams.put("X-LUSID-SDK-Version", "1.3.200");

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call listPostingModuleRulesValidateBeforeCall(String scope, String code, String postingModuleCode, OffsetDateTime asAt, String page, Integer limit, String filter, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'scope' is set
        if (scope == null) {
            throw new ApiException("Missing the required parameter 'scope' when calling listPostingModuleRules(Async)");
        }
        
        // verify the required parameter 'code' is set
        if (code == null) {
            throw new ApiException("Missing the required parameter 'code' when calling listPostingModuleRules(Async)");
        }
        
        // verify the required parameter 'postingModuleCode' is set
        if (postingModuleCode == null) {
            throw new ApiException("Missing the required parameter 'postingModuleCode' when calling listPostingModuleRules(Async)");
        }
        

        okhttp3.Call localVarCall = listPostingModuleRulesCall(scope, code, postingModuleCode, asAt, page, limit, filter, _callback);
        return localVarCall;

    }

    /**
     * [EXPERIMENTAL] ListPostingModuleRules: List Posting Module Rules
     * List the Rules in a Posting Module
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param postingModuleCode The code of the posting module. (required)
     * @param asAt The asAt datetime at which to retrieve the instrument. Defaults to              returning the latest version if not specified. (optional)
     * @param page The pagination token to use to continue listing posting module rules; this              value is returned from the previous call. If a pagination token is provided, the filter              and asAt fields must not have changed since the original request. (optional)
     * @param limit When paginating, limit the results to this number. Defaults to 100 if not specified. (optional)
     * @param filter Expression to filter the results.              For example, to filter on the rule id, specify \&quot;ruleId eq &#39;rule 1&#39;\&quot;. For more information about filtering              results, see https://support.lusid.com/knowledgebase/article/KA-01914. (optional)
     * @return PagedResourceListOfPostingModuleRule
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The rules in the given Posting Module. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public PagedResourceListOfPostingModuleRule listPostingModuleRules(String scope, String code, String postingModuleCode, OffsetDateTime asAt, String page, Integer limit, String filter) throws ApiException {
        ApiResponse<PagedResourceListOfPostingModuleRule> localVarResp = listPostingModuleRulesWithHttpInfo(scope, code, postingModuleCode, asAt, page, limit, filter);
        return localVarResp.getData();
    }

    /**
     * [EXPERIMENTAL] ListPostingModuleRules: List Posting Module Rules
     * List the Rules in a Posting Module
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param postingModuleCode The code of the posting module. (required)
     * @param asAt The asAt datetime at which to retrieve the instrument. Defaults to              returning the latest version if not specified. (optional)
     * @param page The pagination token to use to continue listing posting module rules; this              value is returned from the previous call. If a pagination token is provided, the filter              and asAt fields must not have changed since the original request. (optional)
     * @param limit When paginating, limit the results to this number. Defaults to 100 if not specified. (optional)
     * @param filter Expression to filter the results.              For example, to filter on the rule id, specify \&quot;ruleId eq &#39;rule 1&#39;\&quot;. For more information about filtering              results, see https://support.lusid.com/knowledgebase/article/KA-01914. (optional)
     * @return ApiResponse&lt;PagedResourceListOfPostingModuleRule&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The rules in the given Posting Module. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<PagedResourceListOfPostingModuleRule> listPostingModuleRulesWithHttpInfo(String scope, String code, String postingModuleCode, OffsetDateTime asAt, String page, Integer limit, String filter) throws ApiException {
        okhttp3.Call localVarCall = listPostingModuleRulesValidateBeforeCall(scope, code, postingModuleCode, asAt, page, limit, filter, null);
        Type localVarReturnType = new TypeToken<PagedResourceListOfPostingModuleRule>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * [EXPERIMENTAL] ListPostingModuleRules: List Posting Module Rules (asynchronously)
     * List the Rules in a Posting Module
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param postingModuleCode The code of the posting module. (required)
     * @param asAt The asAt datetime at which to retrieve the instrument. Defaults to              returning the latest version if not specified. (optional)
     * @param page The pagination token to use to continue listing posting module rules; this              value is returned from the previous call. If a pagination token is provided, the filter              and asAt fields must not have changed since the original request. (optional)
     * @param limit When paginating, limit the results to this number. Defaults to 100 if not specified. (optional)
     * @param filter Expression to filter the results.              For example, to filter on the rule id, specify \&quot;ruleId eq &#39;rule 1&#39;\&quot;. For more information about filtering              results, see https://support.lusid.com/knowledgebase/article/KA-01914. (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The rules in the given Posting Module. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listPostingModuleRulesAsync(String scope, String code, String postingModuleCode, OffsetDateTime asAt, String page, Integer limit, String filter, final ApiCallback<PagedResourceListOfPostingModuleRule> _callback) throws ApiException {
        okhttp3.Call localVarCall = listPostingModuleRulesValidateBeforeCall(scope, code, postingModuleCode, asAt, page, limit, filter, _callback);
        Type localVarReturnType = new TypeToken<PagedResourceListOfPostingModuleRule>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for listPostingModules
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param asAt The asAt datetime at which to list the Posting Module. Defaults to returning the latest version              of each Posting Module if not specified. (optional)
     * @param page The pagination token to use to continue listing Posting Modules; this              value is returned from the previous call. If a pagination token is provided, the filter, effectiveAt              and asAt fields must not have changed since the original request. (optional)
     * @param limit When paginating, limit the results to this number. Defaults to 100 if not specified. (optional)
     * @param filter Expression to filter the results.              For example, to filter on the Posting Module status, specify \&quot;status eq &#39;Active&#39;\&quot;. For more information about filtering              results, see https://support.lusid.com/knowledgebase/article/KA-01914. (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The requested Posting Modules. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listPostingModulesCall(String scope, String code, OffsetDateTime asAt, String page, Integer limit, String filter, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/chartofaccounts/{scope}/{code}/postingmodules"
            .replaceAll("\\{" + "scope" + "\\}", localVarApiClient.escapeString(scope.toString()))
            .replaceAll("\\{" + "code" + "\\}", localVarApiClient.escapeString(code.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

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
        localVarHeaderParams.put("X-LUSID-SDK-Version", "1.3.200");

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call listPostingModulesValidateBeforeCall(String scope, String code, OffsetDateTime asAt, String page, Integer limit, String filter, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'scope' is set
        if (scope == null) {
            throw new ApiException("Missing the required parameter 'scope' when calling listPostingModules(Async)");
        }
        
        // verify the required parameter 'code' is set
        if (code == null) {
            throw new ApiException("Missing the required parameter 'code' when calling listPostingModules(Async)");
        }
        

        okhttp3.Call localVarCall = listPostingModulesCall(scope, code, asAt, page, limit, filter, _callback);
        return localVarCall;

    }

    /**
     * [EXPERIMENTAL] ListPostingModules: List Posting Modules
     * List all the Posting Modules matching particular criteria.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param asAt The asAt datetime at which to list the Posting Module. Defaults to returning the latest version              of each Posting Module if not specified. (optional)
     * @param page The pagination token to use to continue listing Posting Modules; this              value is returned from the previous call. If a pagination token is provided, the filter, effectiveAt              and asAt fields must not have changed since the original request. (optional)
     * @param limit When paginating, limit the results to this number. Defaults to 100 if not specified. (optional)
     * @param filter Expression to filter the results.              For example, to filter on the Posting Module status, specify \&quot;status eq &#39;Active&#39;\&quot;. For more information about filtering              results, see https://support.lusid.com/knowledgebase/article/KA-01914. (optional)
     * @return PagedResourceListOfPostingModuleResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The requested Posting Modules. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public PagedResourceListOfPostingModuleResponse listPostingModules(String scope, String code, OffsetDateTime asAt, String page, Integer limit, String filter) throws ApiException {
        ApiResponse<PagedResourceListOfPostingModuleResponse> localVarResp = listPostingModulesWithHttpInfo(scope, code, asAt, page, limit, filter);
        return localVarResp.getData();
    }

    /**
     * [EXPERIMENTAL] ListPostingModules: List Posting Modules
     * List all the Posting Modules matching particular criteria.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param asAt The asAt datetime at which to list the Posting Module. Defaults to returning the latest version              of each Posting Module if not specified. (optional)
     * @param page The pagination token to use to continue listing Posting Modules; this              value is returned from the previous call. If a pagination token is provided, the filter, effectiveAt              and asAt fields must not have changed since the original request. (optional)
     * @param limit When paginating, limit the results to this number. Defaults to 100 if not specified. (optional)
     * @param filter Expression to filter the results.              For example, to filter on the Posting Module status, specify \&quot;status eq &#39;Active&#39;\&quot;. For more information about filtering              results, see https://support.lusid.com/knowledgebase/article/KA-01914. (optional)
     * @return ApiResponse&lt;PagedResourceListOfPostingModuleResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The requested Posting Modules. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<PagedResourceListOfPostingModuleResponse> listPostingModulesWithHttpInfo(String scope, String code, OffsetDateTime asAt, String page, Integer limit, String filter) throws ApiException {
        okhttp3.Call localVarCall = listPostingModulesValidateBeforeCall(scope, code, asAt, page, limit, filter, null);
        Type localVarReturnType = new TypeToken<PagedResourceListOfPostingModuleResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * [EXPERIMENTAL] ListPostingModules: List Posting Modules (asynchronously)
     * List all the Posting Modules matching particular criteria.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param asAt The asAt datetime at which to list the Posting Module. Defaults to returning the latest version              of each Posting Module if not specified. (optional)
     * @param page The pagination token to use to continue listing Posting Modules; this              value is returned from the previous call. If a pagination token is provided, the filter, effectiveAt              and asAt fields must not have changed since the original request. (optional)
     * @param limit When paginating, limit the results to this number. Defaults to 100 if not specified. (optional)
     * @param filter Expression to filter the results.              For example, to filter on the Posting Module status, specify \&quot;status eq &#39;Active&#39;\&quot;. For more information about filtering              results, see https://support.lusid.com/knowledgebase/article/KA-01914. (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The requested Posting Modules. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call listPostingModulesAsync(String scope, String code, OffsetDateTime asAt, String page, Integer limit, String filter, final ApiCallback<PagedResourceListOfPostingModuleResponse> _callback) throws ApiException {
        okhttp3.Call localVarCall = listPostingModulesValidateBeforeCall(scope, code, asAt, page, limit, filter, _callback);
        Type localVarReturnType = new TypeToken<PagedResourceListOfPostingModuleResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for setCleardownModuleDetails
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param cleardownModuleCode The code of the Cleardown Module to be updated. (required)
     * @param cleardownModuleDetails The new details for the Cleardown Module. (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The updated Cleardown Module. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call setCleardownModuleDetailsCall(String scope, String code, String cleardownModuleCode, CleardownModuleDetails cleardownModuleDetails, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = cleardownModuleDetails;

        // create path and map variables
        String localVarPath = "/api/chartofaccounts/{scope}/{code}/cleardownmodules/{cleardownModuleCode}"
            .replaceAll("\\{" + "scope" + "\\}", localVarApiClient.escapeString(scope.toString()))
            .replaceAll("\\{" + "code" + "\\}", localVarApiClient.escapeString(code.toString()))
            .replaceAll("\\{" + "cleardownModuleCode" + "\\}", localVarApiClient.escapeString(cleardownModuleCode.toString()));

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
        localVarHeaderParams.put("X-LUSID-SDK-Version", "1.3.200");

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call setCleardownModuleDetailsValidateBeforeCall(String scope, String code, String cleardownModuleCode, CleardownModuleDetails cleardownModuleDetails, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'scope' is set
        if (scope == null) {
            throw new ApiException("Missing the required parameter 'scope' when calling setCleardownModuleDetails(Async)");
        }
        
        // verify the required parameter 'code' is set
        if (code == null) {
            throw new ApiException("Missing the required parameter 'code' when calling setCleardownModuleDetails(Async)");
        }
        
        // verify the required parameter 'cleardownModuleCode' is set
        if (cleardownModuleCode == null) {
            throw new ApiException("Missing the required parameter 'cleardownModuleCode' when calling setCleardownModuleDetails(Async)");
        }
        
        // verify the required parameter 'cleardownModuleDetails' is set
        if (cleardownModuleDetails == null) {
            throw new ApiException("Missing the required parameter 'cleardownModuleDetails' when calling setCleardownModuleDetails(Async)");
        }
        

        okhttp3.Call localVarCall = setCleardownModuleDetailsCall(scope, code, cleardownModuleCode, cleardownModuleDetails, _callback);
        return localVarCall;

    }

    /**
     * [EXPERIMENTAL] SetCleardownModuleDetails: Set the details of a Cleardown Module
     * Update the given Cleardown Module details.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param cleardownModuleCode The code of the Cleardown Module to be updated. (required)
     * @param cleardownModuleDetails The new details for the Cleardown Module. (required)
     * @return CleardownModuleResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The updated Cleardown Module. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public CleardownModuleResponse setCleardownModuleDetails(String scope, String code, String cleardownModuleCode, CleardownModuleDetails cleardownModuleDetails) throws ApiException {
        ApiResponse<CleardownModuleResponse> localVarResp = setCleardownModuleDetailsWithHttpInfo(scope, code, cleardownModuleCode, cleardownModuleDetails);
        return localVarResp.getData();
    }

    /**
     * [EXPERIMENTAL] SetCleardownModuleDetails: Set the details of a Cleardown Module
     * Update the given Cleardown Module details.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param cleardownModuleCode The code of the Cleardown Module to be updated. (required)
     * @param cleardownModuleDetails The new details for the Cleardown Module. (required)
     * @return ApiResponse&lt;CleardownModuleResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The updated Cleardown Module. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<CleardownModuleResponse> setCleardownModuleDetailsWithHttpInfo(String scope, String code, String cleardownModuleCode, CleardownModuleDetails cleardownModuleDetails) throws ApiException {
        okhttp3.Call localVarCall = setCleardownModuleDetailsValidateBeforeCall(scope, code, cleardownModuleCode, cleardownModuleDetails, null);
        Type localVarReturnType = new TypeToken<CleardownModuleResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * [EXPERIMENTAL] SetCleardownModuleDetails: Set the details of a Cleardown Module (asynchronously)
     * Update the given Cleardown Module details.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param cleardownModuleCode The code of the Cleardown Module to be updated. (required)
     * @param cleardownModuleDetails The new details for the Cleardown Module. (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The updated Cleardown Module. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call setCleardownModuleDetailsAsync(String scope, String code, String cleardownModuleCode, CleardownModuleDetails cleardownModuleDetails, final ApiCallback<CleardownModuleResponse> _callback) throws ApiException {
        okhttp3.Call localVarCall = setCleardownModuleDetailsValidateBeforeCall(scope, code, cleardownModuleCode, cleardownModuleDetails, _callback);
        Type localVarReturnType = new TypeToken<CleardownModuleResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for setCleardownModuleRules
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param cleardownModuleCode The code of the Cleardown Module to be updated. (required)
     * @param cleardownModuleRule The new rule set for the Cleardown Module. (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The Cleardown Module with updated rules. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call setCleardownModuleRulesCall(String scope, String code, String cleardownModuleCode, List<CleardownModuleRule> cleardownModuleRule, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = cleardownModuleRule;

        // create path and map variables
        String localVarPath = "/api/chartofaccounts/{scope}/{code}/cleardownmodules/{cleardownModuleCode}/cleardownrules"
            .replaceAll("\\{" + "scope" + "\\}", localVarApiClient.escapeString(scope.toString()))
            .replaceAll("\\{" + "code" + "\\}", localVarApiClient.escapeString(code.toString()))
            .replaceAll("\\{" + "cleardownModuleCode" + "\\}", localVarApiClient.escapeString(cleardownModuleCode.toString()));

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
        localVarHeaderParams.put("X-LUSID-SDK-Version", "1.3.200");

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call setCleardownModuleRulesValidateBeforeCall(String scope, String code, String cleardownModuleCode, List<CleardownModuleRule> cleardownModuleRule, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'scope' is set
        if (scope == null) {
            throw new ApiException("Missing the required parameter 'scope' when calling setCleardownModuleRules(Async)");
        }
        
        // verify the required parameter 'code' is set
        if (code == null) {
            throw new ApiException("Missing the required parameter 'code' when calling setCleardownModuleRules(Async)");
        }
        
        // verify the required parameter 'cleardownModuleCode' is set
        if (cleardownModuleCode == null) {
            throw new ApiException("Missing the required parameter 'cleardownModuleCode' when calling setCleardownModuleRules(Async)");
        }
        
        // verify the required parameter 'cleardownModuleRule' is set
        if (cleardownModuleRule == null) {
            throw new ApiException("Missing the required parameter 'cleardownModuleRule' when calling setCleardownModuleRules(Async)");
        }
        

        okhttp3.Call localVarCall = setCleardownModuleRulesCall(scope, code, cleardownModuleCode, cleardownModuleRule, _callback);
        return localVarCall;

    }

    /**
     * [EXPERIMENTAL] SetCleardownModuleRules: Set the rules of a Cleardown Module
     * Set the given Cleardown Modules rules, this will replace the existing set of rules for the cleardown module.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param cleardownModuleCode The code of the Cleardown Module to be updated. (required)
     * @param cleardownModuleRule The new rule set for the Cleardown Module. (required)
     * @return CleardownModuleRulesUpdatedResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The Cleardown Module with updated rules. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public CleardownModuleRulesUpdatedResponse setCleardownModuleRules(String scope, String code, String cleardownModuleCode, List<CleardownModuleRule> cleardownModuleRule) throws ApiException {
        ApiResponse<CleardownModuleRulesUpdatedResponse> localVarResp = setCleardownModuleRulesWithHttpInfo(scope, code, cleardownModuleCode, cleardownModuleRule);
        return localVarResp.getData();
    }

    /**
     * [EXPERIMENTAL] SetCleardownModuleRules: Set the rules of a Cleardown Module
     * Set the given Cleardown Modules rules, this will replace the existing set of rules for the cleardown module.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param cleardownModuleCode The code of the Cleardown Module to be updated. (required)
     * @param cleardownModuleRule The new rule set for the Cleardown Module. (required)
     * @return ApiResponse&lt;CleardownModuleRulesUpdatedResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The Cleardown Module with updated rules. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<CleardownModuleRulesUpdatedResponse> setCleardownModuleRulesWithHttpInfo(String scope, String code, String cleardownModuleCode, List<CleardownModuleRule> cleardownModuleRule) throws ApiException {
        okhttp3.Call localVarCall = setCleardownModuleRulesValidateBeforeCall(scope, code, cleardownModuleCode, cleardownModuleRule, null);
        Type localVarReturnType = new TypeToken<CleardownModuleRulesUpdatedResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * [EXPERIMENTAL] SetCleardownModuleRules: Set the rules of a Cleardown Module (asynchronously)
     * Set the given Cleardown Modules rules, this will replace the existing set of rules for the cleardown module.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param cleardownModuleCode The code of the Cleardown Module to be updated. (required)
     * @param cleardownModuleRule The new rule set for the Cleardown Module. (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The Cleardown Module with updated rules. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call setCleardownModuleRulesAsync(String scope, String code, String cleardownModuleCode, List<CleardownModuleRule> cleardownModuleRule, final ApiCallback<CleardownModuleRulesUpdatedResponse> _callback) throws ApiException {
        okhttp3.Call localVarCall = setCleardownModuleRulesValidateBeforeCall(scope, code, cleardownModuleCode, cleardownModuleRule, _callback);
        Type localVarReturnType = new TypeToken<CleardownModuleRulesUpdatedResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for setGeneralLedgerProfileMappings
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. (required)
     * @param generalLedgerProfileCode The code of the General Ledger Profile (required)
     * @param generalLedgerProfileMapping The updated General Ledger Profile Mappings, the previous mappings will be wholly replaced with this data. Mappings will be evaluated in the order they are provided. (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The General Ledger Profile that holds the updated mappings. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call setGeneralLedgerProfileMappingsCall(String scope, String code, String generalLedgerProfileCode, List<GeneralLedgerProfileMapping> generalLedgerProfileMapping, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = generalLedgerProfileMapping;

        // create path and map variables
        String localVarPath = "/api/chartofaccounts/{scope}/{code}/generalledgerprofile/{generalLedgerProfileCode}/mappings"
            .replaceAll("\\{" + "scope" + "\\}", localVarApiClient.escapeString(scope.toString()))
            .replaceAll("\\{" + "code" + "\\}", localVarApiClient.escapeString(code.toString()))
            .replaceAll("\\{" + "generalLedgerProfileCode" + "\\}", localVarApiClient.escapeString(generalLedgerProfileCode.toString()));

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
        localVarHeaderParams.put("X-LUSID-SDK-Version", "1.3.200");

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call setGeneralLedgerProfileMappingsValidateBeforeCall(String scope, String code, String generalLedgerProfileCode, List<GeneralLedgerProfileMapping> generalLedgerProfileMapping, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'scope' is set
        if (scope == null) {
            throw new ApiException("Missing the required parameter 'scope' when calling setGeneralLedgerProfileMappings(Async)");
        }
        
        // verify the required parameter 'code' is set
        if (code == null) {
            throw new ApiException("Missing the required parameter 'code' when calling setGeneralLedgerProfileMappings(Async)");
        }
        
        // verify the required parameter 'generalLedgerProfileCode' is set
        if (generalLedgerProfileCode == null) {
            throw new ApiException("Missing the required parameter 'generalLedgerProfileCode' when calling setGeneralLedgerProfileMappings(Async)");
        }
        
        // verify the required parameter 'generalLedgerProfileMapping' is set
        if (generalLedgerProfileMapping == null) {
            throw new ApiException("Missing the required parameter 'generalLedgerProfileMapping' when calling setGeneralLedgerProfileMappings(Async)");
        }
        

        okhttp3.Call localVarCall = setGeneralLedgerProfileMappingsCall(scope, code, generalLedgerProfileCode, generalLedgerProfileMapping, _callback);
        return localVarCall;

    }

    /**
     * [EXPERIMENTAL] SetGeneralLedgerProfileMappings: Sets the General Ledger Profile Mappings.
     * Update the given General Ledger profile Mappings.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. (required)
     * @param generalLedgerProfileCode The code of the General Ledger Profile (required)
     * @param generalLedgerProfileMapping The updated General Ledger Profile Mappings, the previous mappings will be wholly replaced with this data. Mappings will be evaluated in the order they are provided. (required)
     * @return GeneralLedgerProfileResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The General Ledger Profile that holds the updated mappings. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public GeneralLedgerProfileResponse setGeneralLedgerProfileMappings(String scope, String code, String generalLedgerProfileCode, List<GeneralLedgerProfileMapping> generalLedgerProfileMapping) throws ApiException {
        ApiResponse<GeneralLedgerProfileResponse> localVarResp = setGeneralLedgerProfileMappingsWithHttpInfo(scope, code, generalLedgerProfileCode, generalLedgerProfileMapping);
        return localVarResp.getData();
    }

    /**
     * [EXPERIMENTAL] SetGeneralLedgerProfileMappings: Sets the General Ledger Profile Mappings.
     * Update the given General Ledger profile Mappings.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. (required)
     * @param generalLedgerProfileCode The code of the General Ledger Profile (required)
     * @param generalLedgerProfileMapping The updated General Ledger Profile Mappings, the previous mappings will be wholly replaced with this data. Mappings will be evaluated in the order they are provided. (required)
     * @return ApiResponse&lt;GeneralLedgerProfileResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The General Ledger Profile that holds the updated mappings. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<GeneralLedgerProfileResponse> setGeneralLedgerProfileMappingsWithHttpInfo(String scope, String code, String generalLedgerProfileCode, List<GeneralLedgerProfileMapping> generalLedgerProfileMapping) throws ApiException {
        okhttp3.Call localVarCall = setGeneralLedgerProfileMappingsValidateBeforeCall(scope, code, generalLedgerProfileCode, generalLedgerProfileMapping, null);
        Type localVarReturnType = new TypeToken<GeneralLedgerProfileResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * [EXPERIMENTAL] SetGeneralLedgerProfileMappings: Sets the General Ledger Profile Mappings. (asynchronously)
     * Update the given General Ledger profile Mappings.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. (required)
     * @param generalLedgerProfileCode The code of the General Ledger Profile (required)
     * @param generalLedgerProfileMapping The updated General Ledger Profile Mappings, the previous mappings will be wholly replaced with this data. Mappings will be evaluated in the order they are provided. (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The General Ledger Profile that holds the updated mappings. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call setGeneralLedgerProfileMappingsAsync(String scope, String code, String generalLedgerProfileCode, List<GeneralLedgerProfileMapping> generalLedgerProfileMapping, final ApiCallback<GeneralLedgerProfileResponse> _callback) throws ApiException {
        okhttp3.Call localVarCall = setGeneralLedgerProfileMappingsValidateBeforeCall(scope, code, generalLedgerProfileCode, generalLedgerProfileMapping, _callback);
        Type localVarReturnType = new TypeToken<GeneralLedgerProfileResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for setPostingModuleDetails
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param postingModuleCode The code of the Posting Module to be updated. (required)
     * @param postingModuleDetails The new details for the Posting Module. (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The updated Posting Module. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call setPostingModuleDetailsCall(String scope, String code, String postingModuleCode, PostingModuleDetails postingModuleDetails, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = postingModuleDetails;

        // create path and map variables
        String localVarPath = "/api/chartofaccounts/{scope}/{code}/postingmodules/{postingModuleCode}"
            .replaceAll("\\{" + "scope" + "\\}", localVarApiClient.escapeString(scope.toString()))
            .replaceAll("\\{" + "code" + "\\}", localVarApiClient.escapeString(code.toString()))
            .replaceAll("\\{" + "postingModuleCode" + "\\}", localVarApiClient.escapeString(postingModuleCode.toString()));

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
        localVarHeaderParams.put("X-LUSID-SDK-Version", "1.3.200");

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call setPostingModuleDetailsValidateBeforeCall(String scope, String code, String postingModuleCode, PostingModuleDetails postingModuleDetails, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'scope' is set
        if (scope == null) {
            throw new ApiException("Missing the required parameter 'scope' when calling setPostingModuleDetails(Async)");
        }
        
        // verify the required parameter 'code' is set
        if (code == null) {
            throw new ApiException("Missing the required parameter 'code' when calling setPostingModuleDetails(Async)");
        }
        
        // verify the required parameter 'postingModuleCode' is set
        if (postingModuleCode == null) {
            throw new ApiException("Missing the required parameter 'postingModuleCode' when calling setPostingModuleDetails(Async)");
        }
        
        // verify the required parameter 'postingModuleDetails' is set
        if (postingModuleDetails == null) {
            throw new ApiException("Missing the required parameter 'postingModuleDetails' when calling setPostingModuleDetails(Async)");
        }
        

        okhttp3.Call localVarCall = setPostingModuleDetailsCall(scope, code, postingModuleCode, postingModuleDetails, _callback);
        return localVarCall;

    }

    /**
     * [EXPERIMENTAL] SetPostingModuleDetails: Set the details of a Posting Module
     * Update the given Posting Module details.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param postingModuleCode The code of the Posting Module to be updated. (required)
     * @param postingModuleDetails The new details for the Posting Module. (required)
     * @return PostingModuleResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The updated Posting Module. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public PostingModuleResponse setPostingModuleDetails(String scope, String code, String postingModuleCode, PostingModuleDetails postingModuleDetails) throws ApiException {
        ApiResponse<PostingModuleResponse> localVarResp = setPostingModuleDetailsWithHttpInfo(scope, code, postingModuleCode, postingModuleDetails);
        return localVarResp.getData();
    }

    /**
     * [EXPERIMENTAL] SetPostingModuleDetails: Set the details of a Posting Module
     * Update the given Posting Module details.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param postingModuleCode The code of the Posting Module to be updated. (required)
     * @param postingModuleDetails The new details for the Posting Module. (required)
     * @return ApiResponse&lt;PostingModuleResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The updated Posting Module. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<PostingModuleResponse> setPostingModuleDetailsWithHttpInfo(String scope, String code, String postingModuleCode, PostingModuleDetails postingModuleDetails) throws ApiException {
        okhttp3.Call localVarCall = setPostingModuleDetailsValidateBeforeCall(scope, code, postingModuleCode, postingModuleDetails, null);
        Type localVarReturnType = new TypeToken<PostingModuleResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * [EXPERIMENTAL] SetPostingModuleDetails: Set the details of a Posting Module (asynchronously)
     * Update the given Posting Module details.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param postingModuleCode The code of the Posting Module to be updated. (required)
     * @param postingModuleDetails The new details for the Posting Module. (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The updated Posting Module. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call setPostingModuleDetailsAsync(String scope, String code, String postingModuleCode, PostingModuleDetails postingModuleDetails, final ApiCallback<PostingModuleResponse> _callback) throws ApiException {
        okhttp3.Call localVarCall = setPostingModuleDetailsValidateBeforeCall(scope, code, postingModuleCode, postingModuleDetails, _callback);
        Type localVarReturnType = new TypeToken<PostingModuleResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for setPostingModuleRules
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param postingModuleCode The code of the Posting Module to be updated. (required)
     * @param postingModuleRule The new rule set for the Posting Module. (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The Posting Module with updated rules. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call setPostingModuleRulesCall(String scope, String code, String postingModuleCode, List<PostingModuleRule> postingModuleRule, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = postingModuleRule;

        // create path and map variables
        String localVarPath = "/api/chartofaccounts/{scope}/{code}/postingmodules/{postingModuleCode}/postingrules"
            .replaceAll("\\{" + "scope" + "\\}", localVarApiClient.escapeString(scope.toString()))
            .replaceAll("\\{" + "code" + "\\}", localVarApiClient.escapeString(code.toString()))
            .replaceAll("\\{" + "postingModuleCode" + "\\}", localVarApiClient.escapeString(postingModuleCode.toString()));

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
        localVarHeaderParams.put("X-LUSID-SDK-Version", "1.3.200");

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call setPostingModuleRulesValidateBeforeCall(String scope, String code, String postingModuleCode, List<PostingModuleRule> postingModuleRule, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'scope' is set
        if (scope == null) {
            throw new ApiException("Missing the required parameter 'scope' when calling setPostingModuleRules(Async)");
        }
        
        // verify the required parameter 'code' is set
        if (code == null) {
            throw new ApiException("Missing the required parameter 'code' when calling setPostingModuleRules(Async)");
        }
        
        // verify the required parameter 'postingModuleCode' is set
        if (postingModuleCode == null) {
            throw new ApiException("Missing the required parameter 'postingModuleCode' when calling setPostingModuleRules(Async)");
        }
        
        // verify the required parameter 'postingModuleRule' is set
        if (postingModuleRule == null) {
            throw new ApiException("Missing the required parameter 'postingModuleRule' when calling setPostingModuleRules(Async)");
        }
        

        okhttp3.Call localVarCall = setPostingModuleRulesCall(scope, code, postingModuleCode, postingModuleRule, _callback);
        return localVarCall;

    }

    /**
     * [EXPERIMENTAL] SetPostingModuleRules: Set the rules of a Posting Module
     * Set the given Posting Modules rules, this will replace the existing set of rules for the posting module.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param postingModuleCode The code of the Posting Module to be updated. (required)
     * @param postingModuleRule The new rule set for the Posting Module. (required)
     * @return PostingModuleRulesUpdatedResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The Posting Module with updated rules. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public PostingModuleRulesUpdatedResponse setPostingModuleRules(String scope, String code, String postingModuleCode, List<PostingModuleRule> postingModuleRule) throws ApiException {
        ApiResponse<PostingModuleRulesUpdatedResponse> localVarResp = setPostingModuleRulesWithHttpInfo(scope, code, postingModuleCode, postingModuleRule);
        return localVarResp.getData();
    }

    /**
     * [EXPERIMENTAL] SetPostingModuleRules: Set the rules of a Posting Module
     * Set the given Posting Modules rules, this will replace the existing set of rules for the posting module.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param postingModuleCode The code of the Posting Module to be updated. (required)
     * @param postingModuleRule The new rule set for the Posting Module. (required)
     * @return ApiResponse&lt;PostingModuleRulesUpdatedResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The Posting Module with updated rules. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<PostingModuleRulesUpdatedResponse> setPostingModuleRulesWithHttpInfo(String scope, String code, String postingModuleCode, List<PostingModuleRule> postingModuleRule) throws ApiException {
        okhttp3.Call localVarCall = setPostingModuleRulesValidateBeforeCall(scope, code, postingModuleCode, postingModuleRule, null);
        Type localVarReturnType = new TypeToken<PostingModuleRulesUpdatedResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * [EXPERIMENTAL] SetPostingModuleRules: Set the rules of a Posting Module (asynchronously)
     * Set the given Posting Modules rules, this will replace the existing set of rules for the posting module.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param postingModuleCode The code of the Posting Module to be updated. (required)
     * @param postingModuleRule The new rule set for the Posting Module. (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The Posting Module with updated rules. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call setPostingModuleRulesAsync(String scope, String code, String postingModuleCode, List<PostingModuleRule> postingModuleRule, final ApiCallback<PostingModuleRulesUpdatedResponse> _callback) throws ApiException {
        okhttp3.Call localVarCall = setPostingModuleRulesValidateBeforeCall(scope, code, postingModuleCode, postingModuleRule, _callback);
        Type localVarReturnType = new TypeToken<PostingModuleRulesUpdatedResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for upsertAccountProperties
     * @param scope The scope of the Chart of Accounts to update or insert the properties onto. (required)
     * @param code The code of the Chart of Accounts to update or insert the properties onto. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param accountCode The unique ID of the account to create or update properties for. (required)
     * @param requestBody The properties to be updated or inserted onto the chart of account. Each property in               the request must be keyed by its unique property key. This has the format {domain}/{scope}/{code} e.g. \&quot;Account/Manager/Id\&quot;. (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The updated or inserted properties. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call upsertAccountPropertiesCall(String scope, String code, String accountCode, Map<String, Property> requestBody, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = requestBody;

        // create path and map variables
        String localVarPath = "/api/chartofaccounts/{scope}/{code}/accounts/{accountCode}/properties/$upsert"
            .replaceAll("\\{" + "scope" + "\\}", localVarApiClient.escapeString(scope.toString()))
            .replaceAll("\\{" + "code" + "\\}", localVarApiClient.escapeString(code.toString()))
            .replaceAll("\\{" + "accountCode" + "\\}", localVarApiClient.escapeString(accountCode.toString()));

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
        localVarHeaderParams.put("X-LUSID-SDK-Version", "1.3.200");

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call upsertAccountPropertiesValidateBeforeCall(String scope, String code, String accountCode, Map<String, Property> requestBody, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'scope' is set
        if (scope == null) {
            throw new ApiException("Missing the required parameter 'scope' when calling upsertAccountProperties(Async)");
        }
        
        // verify the required parameter 'code' is set
        if (code == null) {
            throw new ApiException("Missing the required parameter 'code' when calling upsertAccountProperties(Async)");
        }
        
        // verify the required parameter 'accountCode' is set
        if (accountCode == null) {
            throw new ApiException("Missing the required parameter 'accountCode' when calling upsertAccountProperties(Async)");
        }
        

        okhttp3.Call localVarCall = upsertAccountPropertiesCall(scope, code, accountCode, requestBody, _callback);
        return localVarCall;

    }

    /**
     * [EXPERIMENTAL] UpsertAccountProperties: Upsert account properties
     * Update or insert one or more properties onto a single account. A property will be updated if it  already exists and inserted if it does not. All properties must be of the domain &#39;Account&#39;.                Upserting a property that exists for an account, with a null value, will delete the instance of the property for that group.                Properties have an &lt;i&gt;effectiveFrom&lt;/i&gt; datetime for which the property is valid, and an &lt;i&gt;effectiveUntil&lt;/i&gt;  datetime until which the property is valid. Not supplying an &lt;i&gt;effectiveUntil&lt;/i&gt; datetime results in the property being  valid indefinitely, or until the next &lt;i&gt;effectiveFrom&lt;/i&gt; datetime of the property.
     * @param scope The scope of the Chart of Accounts to update or insert the properties onto. (required)
     * @param code The code of the Chart of Accounts to update or insert the properties onto. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param accountCode The unique ID of the account to create or update properties for. (required)
     * @param requestBody The properties to be updated or inserted onto the chart of account. Each property in               the request must be keyed by its unique property key. This has the format {domain}/{scope}/{code} e.g. \&quot;Account/Manager/Id\&quot;. (optional)
     * @return AccountProperties
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The updated or inserted properties. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public AccountProperties upsertAccountProperties(String scope, String code, String accountCode, Map<String, Property> requestBody) throws ApiException {
        ApiResponse<AccountProperties> localVarResp = upsertAccountPropertiesWithHttpInfo(scope, code, accountCode, requestBody);
        return localVarResp.getData();
    }

    /**
     * [EXPERIMENTAL] UpsertAccountProperties: Upsert account properties
     * Update or insert one or more properties onto a single account. A property will be updated if it  already exists and inserted if it does not. All properties must be of the domain &#39;Account&#39;.                Upserting a property that exists for an account, with a null value, will delete the instance of the property for that group.                Properties have an &lt;i&gt;effectiveFrom&lt;/i&gt; datetime for which the property is valid, and an &lt;i&gt;effectiveUntil&lt;/i&gt;  datetime until which the property is valid. Not supplying an &lt;i&gt;effectiveUntil&lt;/i&gt; datetime results in the property being  valid indefinitely, or until the next &lt;i&gt;effectiveFrom&lt;/i&gt; datetime of the property.
     * @param scope The scope of the Chart of Accounts to update or insert the properties onto. (required)
     * @param code The code of the Chart of Accounts to update or insert the properties onto. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param accountCode The unique ID of the account to create or update properties for. (required)
     * @param requestBody The properties to be updated or inserted onto the chart of account. Each property in               the request must be keyed by its unique property key. This has the format {domain}/{scope}/{code} e.g. \&quot;Account/Manager/Id\&quot;. (optional)
     * @return ApiResponse&lt;AccountProperties&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The updated or inserted properties. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<AccountProperties> upsertAccountPropertiesWithHttpInfo(String scope, String code, String accountCode, Map<String, Property> requestBody) throws ApiException {
        okhttp3.Call localVarCall = upsertAccountPropertiesValidateBeforeCall(scope, code, accountCode, requestBody, null);
        Type localVarReturnType = new TypeToken<AccountProperties>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * [EXPERIMENTAL] UpsertAccountProperties: Upsert account properties (asynchronously)
     * Update or insert one or more properties onto a single account. A property will be updated if it  already exists and inserted if it does not. All properties must be of the domain &#39;Account&#39;.                Upserting a property that exists for an account, with a null value, will delete the instance of the property for that group.                Properties have an &lt;i&gt;effectiveFrom&lt;/i&gt; datetime for which the property is valid, and an &lt;i&gt;effectiveUntil&lt;/i&gt;  datetime until which the property is valid. Not supplying an &lt;i&gt;effectiveUntil&lt;/i&gt; datetime results in the property being  valid indefinitely, or until the next &lt;i&gt;effectiveFrom&lt;/i&gt; datetime of the property.
     * @param scope The scope of the Chart of Accounts to update or insert the properties onto. (required)
     * @param code The code of the Chart of Accounts to update or insert the properties onto. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param accountCode The unique ID of the account to create or update properties for. (required)
     * @param requestBody The properties to be updated or inserted onto the chart of account. Each property in               the request must be keyed by its unique property key. This has the format {domain}/{scope}/{code} e.g. \&quot;Account/Manager/Id\&quot;. (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The updated or inserted properties. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call upsertAccountPropertiesAsync(String scope, String code, String accountCode, Map<String, Property> requestBody, final ApiCallback<AccountProperties> _callback) throws ApiException {
        okhttp3.Call localVarCall = upsertAccountPropertiesValidateBeforeCall(scope, code, accountCode, requestBody, _callback);
        Type localVarReturnType = new TypeToken<AccountProperties>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for upsertAccounts
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies              the Chart of Accounts. (required)
     * @param account A list of accounts to be created or updated. (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The newly upserted Accounts. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call upsertAccountsCall(String scope, String code, List<Account> account, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = account;

        // create path and map variables
        String localVarPath = "/api/chartofaccounts/{scope}/{code}/accounts"
            .replaceAll("\\{" + "scope" + "\\}", localVarApiClient.escapeString(scope.toString()))
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
            "application/json-patch+json", "application/json", "text/json", "application/_*+json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);
        localVarHeaderParams.put("X-LUSID-SDK-Language", "Java");
        localVarHeaderParams.put("X-LUSID-SDK-Version", "1.3.200");

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call upsertAccountsValidateBeforeCall(String scope, String code, List<Account> account, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'scope' is set
        if (scope == null) {
            throw new ApiException("Missing the required parameter 'scope' when calling upsertAccounts(Async)");
        }
        
        // verify the required parameter 'code' is set
        if (code == null) {
            throw new ApiException("Missing the required parameter 'code' when calling upsertAccounts(Async)");
        }
        
        // verify the required parameter 'account' is set
        if (account == null) {
            throw new ApiException("Missing the required parameter 'account' when calling upsertAccounts(Async)");
        }
        

        okhttp3.Call localVarCall = upsertAccountsCall(scope, code, account, _callback);
        return localVarCall;

    }

    /**
     * [EXPERIMENTAL] UpsertAccounts: Upsert Accounts
     * Create or update accounts in the Chart of Accounts. An account will be updated  if it already exists and created if it does not.  The maximum number of accounts that this method can upsert per request is 2,000.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies              the Chart of Accounts. (required)
     * @param account A list of accounts to be created or updated. (required)
     * @return AccountsUpsertResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The newly upserted Accounts. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public AccountsUpsertResponse upsertAccounts(String scope, String code, List<Account> account) throws ApiException {
        ApiResponse<AccountsUpsertResponse> localVarResp = upsertAccountsWithHttpInfo(scope, code, account);
        return localVarResp.getData();
    }

    /**
     * [EXPERIMENTAL] UpsertAccounts: Upsert Accounts
     * Create or update accounts in the Chart of Accounts. An account will be updated  if it already exists and created if it does not.  The maximum number of accounts that this method can upsert per request is 2,000.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies              the Chart of Accounts. (required)
     * @param account A list of accounts to be created or updated. (required)
     * @return ApiResponse&lt;AccountsUpsertResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The newly upserted Accounts. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<AccountsUpsertResponse> upsertAccountsWithHttpInfo(String scope, String code, List<Account> account) throws ApiException {
        okhttp3.Call localVarCall = upsertAccountsValidateBeforeCall(scope, code, account, null);
        Type localVarReturnType = new TypeToken<AccountsUpsertResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * [EXPERIMENTAL] UpsertAccounts: Upsert Accounts (asynchronously)
     * Create or update accounts in the Chart of Accounts. An account will be updated  if it already exists and created if it does not.  The maximum number of accounts that this method can upsert per request is 2,000.
     * @param scope The scope of the Chart of Accounts. (required)
     * @param code The code of the Chart of Accounts. Together with the scope this uniquely identifies              the Chart of Accounts. (required)
     * @param account A list of accounts to be created or updated. (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The newly upserted Accounts. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call upsertAccountsAsync(String scope, String code, List<Account> account, final ApiCallback<AccountsUpsertResponse> _callback) throws ApiException {
        okhttp3.Call localVarCall = upsertAccountsValidateBeforeCall(scope, code, account, _callback);
        Type localVarReturnType = new TypeToken<AccountsUpsertResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for upsertChartOfAccountsProperties
     * @param scope The scope of the Chart of Accounts to update or insert the properties onto. (required)
     * @param code The code of the Chart of Accounts to update or insert the properties onto. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param requestBody The properties to be updated or inserted onto the chart of account. Each property in               the request must be keyed by its unique property key. This has the format {domain}/{scope}/{code} e.g. \&quot;ChartOfAccounts/Manager/Id\&quot;. (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The updated or inserted properties. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call upsertChartOfAccountsPropertiesCall(String scope, String code, Map<String, Property> requestBody, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = requestBody;

        // create path and map variables
        String localVarPath = "/api/chartofaccounts/{scope}/{code}/properties/$upsert"
            .replaceAll("\\{" + "scope" + "\\}", localVarApiClient.escapeString(scope.toString()))
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
            "application/json-patch+json", "application/json", "text/json", "application/_*+json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);
        localVarHeaderParams.put("X-LUSID-SDK-Language", "Java");
        localVarHeaderParams.put("X-LUSID-SDK-Version", "1.3.200");

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call upsertChartOfAccountsPropertiesValidateBeforeCall(String scope, String code, Map<String, Property> requestBody, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'scope' is set
        if (scope == null) {
            throw new ApiException("Missing the required parameter 'scope' when calling upsertChartOfAccountsProperties(Async)");
        }
        
        // verify the required parameter 'code' is set
        if (code == null) {
            throw new ApiException("Missing the required parameter 'code' when calling upsertChartOfAccountsProperties(Async)");
        }
        

        okhttp3.Call localVarCall = upsertChartOfAccountsPropertiesCall(scope, code, requestBody, _callback);
        return localVarCall;

    }

    /**
     * [EXPERIMENTAL] UpsertChartOfAccountsProperties: Upsert Chart of Accounts properties
     * Update or insert one or more properties onto a single Chart of Accounts. A property will be updated if it  already exists and inserted if it does not. All properties must be of the domain &#39;ChartOfAccounts&#39;.                Upserting a property that exists for a Chart of Accounts, with a null value, will delete the instance of the property for that group.                Properties have an &lt;i&gt;effectiveFrom&lt;/i&gt; datetime for which the property is valid, and an &lt;i&gt;effectiveUntil&lt;/i&gt;  datetime until which the property is valid. Not supplying an &lt;i&gt;effectiveUntil&lt;/i&gt; datetime results in the property being  valid indefinitely, or until the next &lt;i&gt;effectiveFrom&lt;/i&gt; datetime of the property.
     * @param scope The scope of the Chart of Accounts to update or insert the properties onto. (required)
     * @param code The code of the Chart of Accounts to update or insert the properties onto. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param requestBody The properties to be updated or inserted onto the chart of account. Each property in               the request must be keyed by its unique property key. This has the format {domain}/{scope}/{code} e.g. \&quot;ChartOfAccounts/Manager/Id\&quot;. (optional)
     * @return ChartOfAccountsProperties
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The updated or inserted properties. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ChartOfAccountsProperties upsertChartOfAccountsProperties(String scope, String code, Map<String, Property> requestBody) throws ApiException {
        ApiResponse<ChartOfAccountsProperties> localVarResp = upsertChartOfAccountsPropertiesWithHttpInfo(scope, code, requestBody);
        return localVarResp.getData();
    }

    /**
     * [EXPERIMENTAL] UpsertChartOfAccountsProperties: Upsert Chart of Accounts properties
     * Update or insert one or more properties onto a single Chart of Accounts. A property will be updated if it  already exists and inserted if it does not. All properties must be of the domain &#39;ChartOfAccounts&#39;.                Upserting a property that exists for a Chart of Accounts, with a null value, will delete the instance of the property for that group.                Properties have an &lt;i&gt;effectiveFrom&lt;/i&gt; datetime for which the property is valid, and an &lt;i&gt;effectiveUntil&lt;/i&gt;  datetime until which the property is valid. Not supplying an &lt;i&gt;effectiveUntil&lt;/i&gt; datetime results in the property being  valid indefinitely, or until the next &lt;i&gt;effectiveFrom&lt;/i&gt; datetime of the property.
     * @param scope The scope of the Chart of Accounts to update or insert the properties onto. (required)
     * @param code The code of the Chart of Accounts to update or insert the properties onto. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param requestBody The properties to be updated or inserted onto the chart of account. Each property in               the request must be keyed by its unique property key. This has the format {domain}/{scope}/{code} e.g. \&quot;ChartOfAccounts/Manager/Id\&quot;. (optional)
     * @return ApiResponse&lt;ChartOfAccountsProperties&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The updated or inserted properties. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<ChartOfAccountsProperties> upsertChartOfAccountsPropertiesWithHttpInfo(String scope, String code, Map<String, Property> requestBody) throws ApiException {
        okhttp3.Call localVarCall = upsertChartOfAccountsPropertiesValidateBeforeCall(scope, code, requestBody, null);
        Type localVarReturnType = new TypeToken<ChartOfAccountsProperties>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * [EXPERIMENTAL] UpsertChartOfAccountsProperties: Upsert Chart of Accounts properties (asynchronously)
     * Update or insert one or more properties onto a single Chart of Accounts. A property will be updated if it  already exists and inserted if it does not. All properties must be of the domain &#39;ChartOfAccounts&#39;.                Upserting a property that exists for a Chart of Accounts, with a null value, will delete the instance of the property for that group.                Properties have an &lt;i&gt;effectiveFrom&lt;/i&gt; datetime for which the property is valid, and an &lt;i&gt;effectiveUntil&lt;/i&gt;  datetime until which the property is valid. Not supplying an &lt;i&gt;effectiveUntil&lt;/i&gt; datetime results in the property being  valid indefinitely, or until the next &lt;i&gt;effectiveFrom&lt;/i&gt; datetime of the property.
     * @param scope The scope of the Chart of Accounts to update or insert the properties onto. (required)
     * @param code The code of the Chart of Accounts to update or insert the properties onto. Together with the scope this uniquely identifies the Chart of Accounts. (required)
     * @param requestBody The properties to be updated or inserted onto the chart of account. Each property in               the request must be keyed by its unique property key. This has the format {domain}/{scope}/{code} e.g. \&quot;ChartOfAccounts/Manager/Id\&quot;. (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> The updated or inserted properties. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> The details of the input related failure </td><td>  -  </td></tr>
        <tr><td> 0 </td><td> Error response </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call upsertChartOfAccountsPropertiesAsync(String scope, String code, Map<String, Property> requestBody, final ApiCallback<ChartOfAccountsProperties> _callback) throws ApiException {
        okhttp3.Call localVarCall = upsertChartOfAccountsPropertiesValidateBeforeCall(scope, code, requestBody, _callback);
        Type localVarReturnType = new TypeToken<ChartOfAccountsProperties>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
