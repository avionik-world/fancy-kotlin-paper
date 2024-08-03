package world.avionik.kotlin.paper

import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
import java.util.function.Consumer

/**
 * @author Niklas Nieberler
 */

/**
 * Edits the {@link ItemMeta} of this stack if the meta is of the specified type.
 * <p>
 * The {@link java.util.function.Consumer} must only interact
 * with this stack's {@link ItemMeta} through the provided {@link ItemMeta} instance.
 * Calling this method or any other meta-related method of the {@link ItemStack} class
 * (such as {@link #getItemMeta()}, {@link #addItemFlags(ItemFlag...)}, {@link #lore()}, etc.)
 * from inside the consumer is disallowed and will produce undefined results or exceptions.
 * </p>
 *
 * @param <M> the meta type
 * @return {@code true} if the edit was successful, {@code false} otherwise
 */
inline fun <reified M : ItemMeta> ItemStack.editMeta(consumer: Consumer<M>) {
    this.editMeta(M::class.java, consumer)
}