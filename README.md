# Fancy Kotlin Paper 🔩
This project is there to simplify some small methods for Kotlin.

## Using the Fancy Kotlin Paper in your plugin

### Maven
```xml
<dependencies>
 <dependency>
    <groupId>world.avionik</groupId>
    <artifactId>fancy-kotlin-paper</artifactId>
    <version>1.0.2</version>
    <scope>provided</scope>
  </dependency>
</dependencies>
```

### Gradle
```groovy
dependencies {
    compileOnly 'world.avionik:fancy-kotlin-paper:1.0.2'
}
```

## Kotlin Event-Listener
``` kotlin
listenEvent<PlayerJoinEvent>(javaPlugin)
    .addCondition { it.player.isOp } //here you can add a condition for this event
    .addAction { it.player.sendMessage("hello") } //when the event is fired, this function is executed
    .addAction { it.player.sendMessage("whats up ${it.player.name}") }
    .unregisterAfterCall() //unregisters the event after the first call
```

``` kotlin
Bukkit.getPluginManager().registerEvents(javaPlugin, PlayerJoinListener(), PlayerQuitListener())
```

## ServicesManager Examples
``` kotlin
//without fancy-kotlin-paper
servicesManager.register(
    TestServiceProvider::class.java
    TestServiceProvider(),
    javaPlugin,
    ServicePriority.Highest
)

//with fancy-kotlin-paper
servicesManager.register<TestServiceProvider>(
    TestServiceProvider(),
    javaPlugin,
    ServicePriority.Highest
)
```
``` kotlin
//without fancy-kotlin-paper
servicesManager.load(TestServiceProvider::class.java)

//with fancy-kotlin-paper
servicesManager.load<TestServiceProvider>()
```


## Other Examples
``` kotlin
//without fancy-kotlin-paper
world.createEntity(location, Spider::class.java)

//with fancy-kotlin-paper
world.createEntity<Spider>(location)
```
