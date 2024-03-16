package world.avionik.kotlin.paper.plugin

import org.bukkit.event.Listener
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.PluginManager

/**
 * @author Niklas Nieberler
 */

/**
 * Registers all the events in the given listeners class
 *
 * @param plugin Plugin to register
 * @param listener Listeners to register
 */
fun PluginManager.registerEvents(plugin: Plugin, vararg listener: Listener) {
    listener.forEach { this.registerEvents(it, plugin) }
}