package cl.uchile.dcc
package gwent.game.effects.weatherCardEffects

import gwent.game.effects.Effect

import cl.uchile.dcc.gwent.game.board.{Board, UnitBoard}
import cl.uchile.dcc.gwent.game.card.{Card, WeatherCard}
import cl.uchile.dcc.gwent.game.card.units.UnitCard

class TorrentialRain extends AbsWeatherEffect {
  
  override def name: String = "Weather: Torrential Rain"

  override def description: String = "Sets the strength of all siege cards to 1 for both players."

  /**
   * Applies the Torrential Rain effect to the siege row of the UnitBoard received.
   * @param self  The card with the effect
   * @param board The unit board where the effect is going to be applied.
   */
  override def activate(self: WeatherCard, board: UnitBoard): Unit = {
    board.onSiege(self)
  }

  override def canEqual(that: Any): Boolean = that.isInstanceOf[TorrentialRain]
}
