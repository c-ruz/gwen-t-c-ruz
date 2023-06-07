package cl.uchile.dcc
package gwent.game.card

import gwent.game.card.AbsUnitCard
import gwent.game.board.Board
import gwent.game.players.{Computer, Player}

import java.util.Objects

/**
 * Represents a ranged unit card used in the game.
 * @param name The name of the card.
 * @param str  The strength of the card.            
 */
class RangedCard(name: String, str: Int) extends AbsUnitCard(name, str) with Equals {
  override def canEqual(that: Any): Boolean = that.isInstanceOf[RangedCard]

  override def equals(obj: Any): Boolean = {
    if (canEqual(obj: Any)) {
      val other = obj.asInstanceOf[RangedCard]
      (this eq other) ||
        (this.name == other.name && this.str == other.str)
    } else {
      false
    }
  }
  override def hashCode(): Int = Objects.hash(classOf[RangedCard], name, str)

  /**
   * ==================
   * Class methods
   * ==================
   */

  /**
   * Sends a message to the board that a Player is placing a RangedCard.
   * @param board the board where the card is going to be placed.
   */
  def placeOnPlayer(board: Board): Unit = {
    board.playerArmy.placeRanged(this)
  }

  /**
   * Sends a message to the board that a Computer is placing a RangedCard.
   * @param board the board where the card is going to be placed.
   */

  def placeOnComputer(board: Board): Unit = {
    board.computerArmy.placeRanged(this)
  }
}
