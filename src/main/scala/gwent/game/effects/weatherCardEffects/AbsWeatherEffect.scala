package cl.uchile.dcc
package gwent.game.effects.weatherCardEffects

import gwent.game.effects.Effect

import cl.uchile.dcc.gwent.game.board.Board
import cl.uchile.dcc.gwent.game.card.units.UnitCard

abstract class AbsWeatherEffect extends Effect {
  def activate(row: List[UnitCard]): Unit = {
  }
}
