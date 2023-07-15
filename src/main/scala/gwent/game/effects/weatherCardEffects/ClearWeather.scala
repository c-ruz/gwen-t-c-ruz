package cl.uchile.dcc
package gwent.game.effects.weatherCardEffects

import gwent.game.effects.Effect

import cl.uchile.dcc.gwent.game.board.{Board, UnitBoard}
import cl.uchile.dcc.gwent.game.card.{Card, WeatherCard}
import cl.uchile.dcc.gwent.game.card.units.UnitCard

class ClearWeather() extends AbsWeatherEffect {
  override def name: String = "Weather: Clear Weather"

  override def description: String = "Removes any current weather effects across the entire battlefield."

  override def apply(self: Card, target: List[UnitCard]): Unit = {
    for (card <- target) {
      card.setStatus(false)
    }
  }

  /**
   * Applies Clear Weather effect to all rows in the UnitBoard received.
   * @param self  The card with the effect.
   * @param board The unit board where the effect is going to be applied.
   */
  override def activate(self: WeatherCard, board: UnitBoard): Unit = {
    board.onMelee(self)
    board.onRanged(self)
    board.onSiege(self)
  }

  override def canEqual(that: Any): Boolean = that.isInstanceOf[ClearWeather]
}
