package cl.uchile.dcc
package gwent.game.effects.weatherCardEffects

import gwent.game.effects.Effect

import cl.uchile.dcc.gwent.game.board.{Board, UnitBoard}
import cl.uchile.dcc.gwent.game.card.{Card, WeatherCard}
import cl.uchile.dcc.gwent.game.card.units.UnitCard

class ImpenetrableFog extends AbsWeatherEffect {
  override def name: String = "Weather: Impenetrable Fog"

  override def description: String = "Sets the strength of all ranged cards to 1 for both players."

  /**
   * Applies the Impenetrable Fog effect to the ranged row of the UnitBoard received.
   * @param self  The card with the effect.
   * @param board The unit board where the effect is going to be applied.
   */
  override def activate(self: WeatherCard, board: UnitBoard): Unit = {
    board.onRanged(self)
  }

  override def canEqual(that: Any): Boolean = that.isInstanceOf[ImpenetrableFog]
}
