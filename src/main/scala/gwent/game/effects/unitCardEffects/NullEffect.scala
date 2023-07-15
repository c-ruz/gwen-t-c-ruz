package cl.uchile.dcc
package gwent.game.effects.unitCardEffects

import gwent.game.card.Card
import gwent.game.effects.Effect
import gwent.game.card.units.UnitCard

class NullEffect() extends UnitEffect {
  
  override def name: String = "No effect"

  override def description: String = "This card has no effect."

  /**
   * Does nothing.
   * @param self  The card with the effect.
   * @param target  Target row of cards.
   */
  override def apply(self: Card, target: List[UnitCard]): Unit = {
  }

  override def canEqual(that: Any): Boolean = that.isInstanceOf[NullEffect]
}
