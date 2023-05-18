package cl.uchile.dcc
package gwent.Cards

import java.util.Objects

/**
 * Represents a weather card used in the game.
 * @param _name The name of the card.
 */
class WeatherCard(val _name: String) extends Card with Equals {
  /**
   * Gets the name of the card
   */
  def name: String = _name

  /**
   * ==============================
   * Equals implementation
   * ==============================
   */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[WeatherCard]
  override def equals(obj: Any): Boolean = {
    if (canEqual(obj: Any)) {
      val other = obj.asInstanceOf[WeatherCard]
      (this eq other) ||
        (this.name == other.name)
    } else {
      false
    }
  }
  override def hashCode(): Int = Objects.hash(classOf[WeatherCard], name)
}
