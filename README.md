# Catwalk

--- 

## Swagger Available!

If you followed the instructions for installing the project locally, the plugin will automatically host Swagger instance
on `http://localhost:4567/swagger`. So in other words:

You can check the API documentation in the following link: [Swagger](http://localhost:4567/swagger)

## Installation

1. Add the JitPack repository to your build file

Gradle:

```
repositories {
    maven {
        name = "jitpack"
        url = "https://jitpack.io"
    }
}
```

2. Add the dependency to your `build.gradle` file

Gradle:

```
dependencies {
    compileOnly 'com.github.mc-uaproject:uaproject-catwalk:<version>'
}
```

3. Add dependency to Paper plugin.yml

```
depend: [Catwalk]
```

4. (Optional) Get the plugin instance in your plugin

```java
Catwalk catwalk = (Catwalk) Bukkit.getPluginManager().getPlugin("Catwalk");
```

You are ready to go! 🎉

## Usage

You can mostly use the API by implementing the `Listener` interface from Bukkit API and then registering the listener. The API uses Event API, so you can listen to the events and do your logic. For example:

---
- GraylistUpdateEvent: This event is called when the graylist is updated. Has two parameters: `username` and boolean `granted`. When `granted` is true, the event means the player is added to the graylist. When `granted` is false, the event means the player is removed from the graylist.

- ---

- To be continued...

---


## P.S. Server-Tap
In order to successfully run the plugin, you need to have the `Server-Tap` plugin installed on your server. You can download it from the following link: [Server-Tap](https://github.com/servertap-io/servertap)