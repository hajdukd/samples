Sample project describing five ways to deserialize immutable objects using jackson.

Test suite contains usage examples.

- [@JsonCreator](https://fasterxml.github.io/jackson-annotations/javadoc/2.7/com/fasterxml/jackson/annotation/JsonCreator.html)
- [@ConstructorProperties](https://docs.oracle.com/javase/8/docs/api/java/beans/ConstructorProperties.html)
- [StdDeserializer](https://fasterxml.github.io/jackson-databind/javadoc/2.7/com/fasterxml/jackson/databind/deser/std/StdDeserializer.html)
- [MixIn](https://fasterxml.github.io/jackson-databind/javadoc/2.7/com/fasterxml/jackson/databind/ObjectMapper.html#addMixIn(java.lang.Class,%20java.lang.Class))
- [@JsonPOJOBuilder](https://fasterxml.github.io/jackson-databind/javadoc/2.7/com/fasterxml/jackson/databind/annotation/JsonPOJOBuilder.html)