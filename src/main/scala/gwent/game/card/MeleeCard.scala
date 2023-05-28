package cl.uchile.dcc
package gwent.game.card

import gwent.game.card.AbsUnitCard
import cl.uchile.dcc.gwent.game.board.Board

import cl.uchile.dcc.gwent.game.players.{Player, Computer}

import java.util.Objects

/**
 * Represents a melee unit card used in the game.
 * @param name The name of the card.
 * @param str  The strength of the card.            
 */
class MeleeCard(name: String, str: Int) extends AbsUnitCard(name, str) with Equals {
  override def canEqual(that: Any): Boolean = that.isInstanceOf[MeleeCard]

  override def equals(obj: Any): Boolean = {
    if (canEqual(obj: Any)) {
      val other = obj.asInstanceOf[MeleeCard]
      (this eq other) ||
        (this.name == other.name && this.str == other.str)
    } else {
      false
    }
  }
  override def hashCode(): Int = Objects.hash(classOf[MeleeCard], name, str)

  /**
   * ==================
   * Class methods
   * ==================
   */

  /**
   * Sends a message to the board that a Player is placing a MeleeCard
    * @param board  the board where the card is going to be placed.
   */
  def placeOnPlayer(board: Board): Unit = {
    board.playerArmy.placeMelee(this)
  }

  /**
   * Send a message to the board that a Computer is placing a MeleeCard
   * @param board the board where the card is going to be placed.
   */
  def placeOnComputer(board: Board): Unit = {
    board.computerArmy.placeMelee(this)
  }
}
