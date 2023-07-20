package cl.uchile.dcc
package gwent.game.effects.weatherCardEffects

import gwent.game.board.UnitBoard

import cl.uchile.dcc.gwent.game.card.WeatherCard
import cl.uchile.dcc.gwent.game.effects.Effect

trait WeatherEffect extends Effect {
  def activate(self: WeatherCard, board: UnitBoard): Unit
}
