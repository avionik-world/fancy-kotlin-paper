package world.avionik.kotlin.paper

import org.bukkit.Location
import org.bukkit.util.NumberConversions

/**
 * @author Niklas Nieberler
 */

fun Location.distanceNoYSquared(location: Location): Double {
    return NumberConversions.square(this.x - location.x) + NumberConversions.square(this.z - location.z)
}