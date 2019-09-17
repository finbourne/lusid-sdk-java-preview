

# DataMapping

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**dataFieldNameMappings** | **Map&lt;String, String&gt;** | A map from a client source, or other source that is not addressed in terms of the internal LUSID property paths to the internal LUSID property paths.  In a simple case this could be something like \&quot;ISIN\&quot; to \&quot;Instrument/default/ISIN\&quot;. The DataMapping dictionary provides a way to make LUSID aware of  documents that have an external format that the client might not wish to change but where it would be useful to be able to query that data within LUSID.  Queries within LUSID are preferably to be written using the LUSID property paths in order to encourage the same semantic meaning to be attached to pieces of data. |  [optional]
**links** | [**List&lt;Link&gt;**](Link.md) |  |  [optional]



