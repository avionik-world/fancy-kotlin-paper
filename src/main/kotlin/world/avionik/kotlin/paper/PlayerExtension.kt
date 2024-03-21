package world.avionik.kotlin.paper

import org.bukkit.Sound
import org.bukkit.entity.Player

/**
 * @author Niklas Nieberler
 */

/**
 * Play a sound for a player at the location.
 * This function will fail silently if Location or Sound are null.
 * @param sound The sound to play
 * @param volume The volume of the sound
 * @param pitch The pitch of the sound
 */
fun Player.playSound(sound: Sound, volume: Float, pitch: Float) {
    this.playSound(this.location, sound, volume, pitch)
}