package cl.uchile.dcc
package gwent.game.effects.unitCardEffects
import gwent.game.effects.Effect

import cl.uchile.dcc.gwent.game.board.Board
import cl.uchile.dcc.gwent.game.card.Card
import cl.uchile.dcc.gwent.game.card.units.UnitCard

class MoraleSupport() extends AbsUnitEffect {

  override def name: String = "Morale Support"

  override def description: String = "Adds +1 to all units in the row (excluding itself)."

  override def activate(row: List[UnitCard]): Unit = {
    for (card <- row.tail) {
      card.SetCurrStr(card.currStr + 1)
    }
  }

}
