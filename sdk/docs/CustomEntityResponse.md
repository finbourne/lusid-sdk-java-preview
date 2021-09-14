

# CustomEntityResponse


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**href** | **URI** | The specific Uniform Resource Identifier (URI) for this resource at the requested effective and asAt datetime. |  [optional]
**entityType** | **String** | The EntityType to be used when relations are created to the CustomEntity | 
**customEntityId** | **String** | A unique identifier for the CustomEntity | 
**version** | [**Version**](Version.md) |  | 
**displayName** | **String** | The display name of the CustomEntity | 
**description** | **String** | The description of the CustomEntity |  [optional]
**identifiers** | [**List&lt;CustomEntityIdResponse&gt;**](CustomEntityIdResponse.md) | A collection of CustomEntityIdentifiers that can identify the CustomEntity | 
**fields** | [**List&lt;CustomEntityField&gt;**](CustomEntityField.md) | A collection of CustomEntityFields that decorate the CustomEntity | 
**effectiveRange** | [**DateRange**](DateRange.md) |  | 
**asAtRange** | [**DateRange**](DateRange.md) |  | 
**links** | [**List&lt;Link&gt;**](Link.md) | Collection of links. |  [optional]



