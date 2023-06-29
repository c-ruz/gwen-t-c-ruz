package cl.uchile.dcc
package gwent.game.effects.unitCardEffects

import gwent.game.effects.Effect

import cl.uchile.dcc.gwent.game.card.units.UnitCard

abstract class AbsUnitEffect extends Effect {
  def activate(row: List[UnitCard]): Unit
}
