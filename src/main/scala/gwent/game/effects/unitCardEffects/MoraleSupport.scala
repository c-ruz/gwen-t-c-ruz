package cl.uchile.dcc
package gwent.game.effects.unitCardEffects
import gwent.game.effects.Effect

import cl.uchile.dcc.gwent.game.board.Board
import cl.uchile.dcc.gwent.game.card.Card
import cl.uchile.dcc.gwent.game.card.units.UnitCard

class MoraleSupport() extends UnitEffect {

  override def name: String = "Morale Support"

  override def description: String = "Adds +1 to all units in the row (excluding itself)."

  /**
   * Sums 1 to the strength of cards in target row's tail.
   * @param self  The card with the effect.
   * @param target  Target row of cards.
   */
  override def apply(self: Card, target: List[UnitCard]): Unit = {
    for (card <- target.tail) {
      card.setCurrStr(card.currStr + 1)
    }
  }

  override def canEqual(that: Any): Boolean = that.isInstanceOf[MoraleSupport]
}
