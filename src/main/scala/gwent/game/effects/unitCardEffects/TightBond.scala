package cl.uchile.dcc
package gwent.game.effects.unitCardEffects

import gwent.game.effects.Effect

import cl.uchile.dcc.gwent.game.board.Board
import cl.uchile.dcc.gwent.game.card.Card
import cl.uchile.dcc.gwent.game.card.units.UnitCard

class TightBond() extends UnitEffect {

  override def name: String = "Tight Bond"

  override def description: String = "Placing this unit in a row with cards with the same name, " +
    "will double both the strength of those cards and itself."

  /**
   * If there exists one or more cards with the same name as self, in the target row, then 
   * doubles the strength of those cards and self.
   * @param self  The card with the effect.
   * @param target  Target row of cards.
   */
  override def apply(self: Card, target: List[UnitCard]): Unit = {
    if (target.tail.exists(card => {card.name == self.name})) {
      for (card <- target) {
        if (card.name == self.name) {
          card.setCurrStr(card.currStr * 2)
        }
      }
    }
  }

  override def canEqual(that: Any): Boolean = that.isInstanceOf[TightBond]
}
