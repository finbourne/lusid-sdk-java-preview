![LUSID_by_Finbourne](https://content.finbourne.com/LUSID_repo.png)

| branch | status |
| --- | --- |
| `master` |  [![Build Status](https://travis-ci.org/finbourne/lusid-sdk-java-preview.svg?branch=master)](https://travis-ci.org/finbourne/lusid-sdk-java-preview) |
| `develop` | [![Build Status](https://travis-ci.org/finbourne/lusid-sdk-java-preview.svg?branch=develop)](https://travis-ci.org/finbourne/lusid-sdk-java-preview) |

# LUSID<sup>®</sup> Java SDK

Maven artifacts can be downloaded from the Open Source Software Repository Hosting (OSSRH) by adding the following to your pom.xml

```
<project>
  ...
  <repositories>
    <repository>
      <id>osssrh</id>
      <name>OSSRH</name>
      <url>https://oss.sonatype.org/content/repositories/snapshots/</url>
    </repository>
  </repositories>

  <dependencies>
    <dependency>
      <groupId>com.finbourne</groupId>
      <artifactId>lusid-sdk-preview</artifactId>
      <version>{INSERT VERSION}</version>
    </dependency>
    ...
  </dependencies>
  ...
</project>
```


For further documentation on building the SDK, running the tutorials and using the SDK please see the [wiki](https://github.com/finbourne/lusid-sdk-java-preview/wiki).
