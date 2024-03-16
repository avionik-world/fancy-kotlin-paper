package world.avionik.kotlin.paper.listener

import org.bukkit.event.Event
import org.bukkit.event.EventPriority
import org.bukkit.event.HandlerList
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

/**
 * @authors Niklas Nieberler, Wetterbericht
 */

class FancyEventListener<E : Event>(
    private val listenerClass: Class<E>,
    private val eventPriority: EventPriority = EventPriority.NORMAL,
    private val javaPlugin: JavaPlugin
) {

    private var conditions: MutableList<((E) -> Boolean)> = ArrayList()
    private var actions: MutableList<((E) -> Unit)> = ArrayList()
    private val listener = createListener()

    fun addCondition(predicate: (E) -> Boolean): FancyEventListener<E> {
        this.conditions.add(predicate)
        return this
    }

    fun addAction(predicate: (E) -> Unit): FancyEventListener<E> {
        this.actions.add(predicate)
        return this
    }

    fun unregisterWhen(predicate: (Unit) -> FancyEventListener<*>): FancyEventListener<E> {
        val advancedListener = predicate(Unit)
        advancedListener.addAction { stopListening() }
        advancedListener.addAction { advancedListener.stopListening() }
        return this
    }

    fun stopListening() {
        HandlerList.unregisterAll(this.listener)
    }

    fun unregisterAfterCall(): FancyEventListener<E> {
        addAction { stopListening() }
        return this
    }

    private fun createListener(): Listener {
        return listen(this.javaPlugin, this.listenerClass, this.eventPriority) { event ->
            if (this.conditions.all { it(event) }) {
                this.actions.forEach { it(event) }
            }
        }
    }

}