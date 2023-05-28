package cl.uchile.dcc
package gwent.game.card

import gwent.game.card.Card
import gwent.game.board.Board
import gwent.game.players.{Computer, Player}

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

  /**
   * Both methods place a weather card in the board received.
   * @param board the board where the card is going to be placed.
   */
  def placeOnPlayer(board: Board): Unit = {
    board.placeWeather(this)
  }

  def placeOnComputer(board: Board): Unit = {
    board.placeWeather(this)
  }
}
