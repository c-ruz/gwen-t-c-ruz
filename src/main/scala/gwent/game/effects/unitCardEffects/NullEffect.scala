package cl.uchile.dcc
package gwent.game.effects.unitCardEffects

import gwent.game.card.Card
import gwent.game.card.units.UnitCard
import gwent.game.effects.Effect

class NullEffect() extends AbsUnitEffect {
  
  override def name: String = "No effect"

  override def description: String = "This card has no effect"

  override def activate(row: List[UnitCard]): Unit = {
    // Does nothing
  }
}
