package cl.uchile.dcc
package gwent.game.effects.unitCardEffects

import gwent.game.effects.Effect

import cl.uchile.dcc.gwent.game.board.Board
import cl.uchile.dcc.gwent.game.card.Card
import cl.uchile.dcc.gwent.game.card.units.UnitCard

class TightBond() extends AbsUnitEffect {

  override def name: String = "Tight Bond"

  override def description: String = "Placing this unit in a row with cards with the same name, " +
    "will double both the strength of those cards and itself."

  override def activate(row: List[UnitCard]): Unit = {
    val compare = row.head.name
    if (row.tail.exists(card => {card.name == compare})) {
      for (card <- row) {
        if (card.name == compare) {
          card.SetCurrStr(card.currStr*2)
        }
      }
    }
  }
}
