# JarSON
JarSON is a simple Java api that utilizes the "org.json" package. 

Documentation is being continued in future, but for now, here is the usage:

```java
    JarSON jarSON = new JarSON(new Document(new JSONFile(System.getProperty("user.dir") + "/JSON/jarsonTest.json")));
    
    or:
    
    jarSON.loadDocument(new JSONFile(<JSONFile Path>));
    
    or:
    
    jarSON.loadDocument(new Document(<JSONFILE>));
    
    then:
    
    jarSON.getDocument().getWriter().setString("key", "value");
    jarSON.getDocument().getReader().getString("key");
```
