package cl.uchile.dcc
package gwent.game.card

import gwent.game.card.Card
import gwent.game.board.Board
import gwent.game.players.{Computer, Player}

import cl.uchile.dcc.gwent.game.effects.Effect
import cl.uchile.dcc.gwent.game.effects.weatherCardEffects.WeatherEffect

import java.util.Objects

/**
 * Represents a weather card used in the game.
 * @param _name The name of the card.
 */
class WeatherCard(private val _name: String, private val _effect: WeatherEffect) extends Card {
  /**
   * Gets the name of the card
   */
  override def name: String = _name
  override def effect: WeatherEffect = _effect
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

  /**
   * This method places the weather card in the weather slot of the board given.
   * @param board the board where the card is going to be placed.
   */
  def placeOnPlayer(board: Board): Unit = {
    board.placeWeather(this)
  }

  /**
   * This method places the weather card in the weather slot of the board given.
   * @param board the board where the card is going to be placed.
   */
  def placeOnComputer(board: Board): Unit = {
    board.placeWeather(this)
  }
}
