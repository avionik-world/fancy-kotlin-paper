package world.avionik.kotlin.paper

import org.bukkit.Location
import org.bukkit.RegionAccessor
import org.bukkit.entity.Entity

/**
 * Creates an entity of a specific class at the given {@link Location} but
 * does not spawn it in the world.
 * <p>
 * <b>Note:</b> The created entity keeps a reference to the world it was
 * created in, care should be taken that the entity does not outlive the
 * world instance as this will lead to memory leaks.
 *
 * @param <T> the class of the {@link Entity} to create
 * @param location the {@link Location} to create the entity at
 * @return an instance of the created {@link Entity}
 * @see #addEntity(Entity)
 * @see Entity#createSnapshot()
 */
inline fun <reified T : Entity> RegionAccessor.createEntity(location: Location): T {
    return this.createEntity(location, T::class.java)
}

/**
 * Spawn an entity of a specific class at the given {@link Location}
 *
 * @param location the {@link Location} to spawn the entity at
 * @return an instance of the spawned {@link Entity}
 */
inline fun <reified T : Entity> RegionAccessor.spawn(location: Location): T {
    return this.spawn(location, T::class.java)
}