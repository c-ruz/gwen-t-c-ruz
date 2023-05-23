package cl.uchile.dcc
package gwent.game.card

import gwent.game.card.AbsUnitCard
import cl.uchile.dcc.gwent.game.board.Board
import cl.uchile.dcc.gwent.game.players.{Computer, Player}

import java.util.Objects

/**
 * Represents a siege unit card used in the game.
 * @param name The name of the card.
 * @param str  The strength of the card.            
 */
class SiegeCard(name: String, str: Int) extends AbsUnitCard(name, str) with Equals {
  override def canEqual(that: Any): Boolean = that.isInstanceOf[SiegeCard]

  override def equals(obj: Any): Boolean = {
    if (canEqual(obj: Any)) {
      val other = obj.asInstanceOf[SiegeCard]
      (this eq other) ||
        (this.name == other.name && this.str == other.str)
    } else {
      false
    }
  }

  override def hashCode(): Int = Objects.hash(classOf[SiegeCard], name, str)

  def placeOnPlayer(board: Board): Unit = {
    board.playerArmy.placeSiege(this)
  }

  def placeOnComputer(board: Board): Unit = {
    board.computerArmy.placeSiege(this)
  }
}
