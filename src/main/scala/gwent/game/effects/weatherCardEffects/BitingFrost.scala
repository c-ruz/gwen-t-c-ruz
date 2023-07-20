package cl.uchile.dcc
package gwent.game.effects.weatherCardEffects

import gwent.game.effects.Effect

import cl.uchile.dcc.gwent.game.board.{Board, UnitBoard}
import cl.uchile.dcc.gwent.game.card.{Card, WeatherCard}
import cl.uchile.dcc.gwent.game.card.units.UnitCard

class BitingFrost extends AbsWeatherEffect {
  override def name: String = "Weather: Biting Frost"

  override def description: String = "Sets the strength of all melee cards to 1 for both players."

  /**
   * Activates the effect on the melee rows of the UnitBoard received.
   * @param self  The weather card with the effect.
   * @param board The UnitBoard where the effect is going to be applied. 
   */
  override def activate(self: WeatherCard, board: UnitBoard): Unit = {
    board.onMelee(self)
  }

  override def canEqual(that: Any): Boolean = that.isInstanceOf[BitingFrost]
}
