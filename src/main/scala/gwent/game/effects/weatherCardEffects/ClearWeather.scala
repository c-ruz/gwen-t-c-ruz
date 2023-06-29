package cl.uchile.dcc
package gwent.game.effects.weatherCardEffects

import gwent.game.effects.Effect

import cl.uchile.dcc.gwent.game.board.Board
import cl.uchile.dcc.gwent.game.card.Card
import cl.uchile.dcc.gwent.game.card.units.UnitCard

class ClearWeather() extends AbsWeatherEffect {
  override def name: String = "Weather: Clear Weather"

  override def description: String = "Removes any current weather effects across the entire battlefield."

  
}
