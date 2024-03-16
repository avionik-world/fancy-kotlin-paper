package world.avionik.kotlin.paper

import io.papermc.paper.event.player.AbstractChatEvent
import net.kyori.adventure.text.Component

/**
 * Sets the chat renderer.
 *
 * @param function the chat renderer function
 * @throws NullPointerException if {@code renderer} is {@code null}
 */
fun AbstractChatEvent.renderer(function: () -> Component) {
    this.renderer { _, _, _, _ -> function() }
}