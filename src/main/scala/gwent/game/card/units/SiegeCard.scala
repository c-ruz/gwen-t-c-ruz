package cl.uchile.dcc
package gwent.game.card.units

import gwent.game.board.Board
import gwent.game.card.units.AbsUnitCard
import gwent.game.players.{Computer, Player}

import cl.uchile.dcc.gwent.game.effects.Effect
import cl.uchile.dcc.gwent.game.effects.unitCardEffects.UnitEffect

import java.util.Objects

/**
 * Represents a siege unit card used in the game.
 * @param name The name of the card.
 * @param str  The strength of the card.            
 */
class SiegeCard(name: String, str: Int, effect: UnitEffect) extends AbsUnitCard(name, str, effect) {
  override def canEqual(that: Any): Boolean = that.isInstanceOf[SiegeCard]
  override def hashCode(): Int = Objects.hash(classOf[SiegeCard], name, str)


  /**
   * ==================
   * Class methods
   * ==================
   */

  /**
   * Sends a message to the board that a Player is placing a SiegeCard.
    * @param board  the board where the card is going to be placed.
   */
  override def placeOnPlayer(board: Board): Unit = {
    board.playerArmy.placeSiege(this)
  }

  /**
   * Sends a message to the board that a Computer is placing a SiegeCard.
   * @param board  the board where the card is going to be placed.
   */
  override def placeOnComputer(board: Board): Unit = {
    board.computerArmy.placeSiege(this)
  }
}
