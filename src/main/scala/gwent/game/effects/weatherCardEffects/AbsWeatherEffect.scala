package cl.uchile.dcc
package gwent.game.effects.weatherCardEffects

import gwent.game.effects.Effect

import cl.uchile.dcc.gwent.game.board.Board
import cl.uchile.dcc.gwent.game.card.Card
import cl.uchile.dcc.gwent.game.card.units.UnitCard

abstract class AbsWeatherEffect extends WeatherEffect {
  /**
   * Sets status field of all cards in target row to true.
   * @param self  The card with the effect.
   * @param target  The target row.
   */
  override def apply(self: Card, target: List[UnitCard]): Unit = {
    for (card <- target) {
      card.setStatus(true)
    }
  }
}
