package world.avionik.kotlin.paper.listener

import org.bukkit.Bukkit
import org.bukkit.event.Event
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

/**
 * @authors Niklas Nieberler, Wetterbericht
 */

inline fun <reified E : Event> listener(
    javaPlugin: JavaPlugin,
    eventPriority: EventPriority,
    noinline eventFunction: (E) -> Unit
): Listener {
    return listen(javaPlugin, E::class.java, eventPriority, eventFunction)
}

@Suppress("UNCHECKED_CAST")
fun <E : Event> listen(
    javaPlugin: JavaPlugin,
    eventClass: Class<E>,
    eventPriority: EventPriority,
    eventFunction: (E) -> Unit
): Listener {
    val emptyListenerInstance = object : Listener {}
    val pluginManager = Bukkit.getPluginManager()
    pluginManager.registerEvent(
        eventClass,
        emptyListenerInstance,
        eventPriority,
        { _, event -> eventFunction(event as E) },
        javaPlugin,
        false
    )
    return emptyListenerInstance
}

inline fun <reified E : Event> listenEvent(
    javaPlugin: JavaPlugin,
    priority: EventPriority = EventPriority.NORMAL
): FancyEventListener<E> {
    return FancyEventListener(E::class.java, priority, javaPlugin)
}