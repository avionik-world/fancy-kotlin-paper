package world.avionik.kotlin.paper

import org.bukkit.plugin.Plugin
import org.bukkit.plugin.ServicePriority
import org.bukkit.plugin.ServicesManager

/**
 * Queries for a provider. This may return null if no provider has been
 * registered for a service. The highest priority provider is returned.
 *
 * @param <T> The service interface
 * @return provider or null
 */
inline fun <reified T> ServicesManager.load(): T? {
    return this.load(T::class.java)
}

/**
 * Register a provider of a service.
 *
 * @param <T> Provider
 * @param provider provider to register
 * @param plugin plugin with the provider
 * @param priority priority of the provider
 */
inline fun <reified T : Any> ServicesManager.register(provider: T, plugin: Plugin, priority: ServicePriority) {
    this.register(
        T::class.java,
        provider,
        plugin,
        priority
    )
}