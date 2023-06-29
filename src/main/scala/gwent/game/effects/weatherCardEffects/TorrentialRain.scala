package cl.uchile.dcc
package gwent.game.effects.weatherCardEffects

import gwent.game.effects.Effect

import cl.uchile.dcc.gwent.game.board.Board
import cl.uchile.dcc.gwent.game.card.Card
import cl.uchile.dcc.gwent.game.card.units.UnitCard

class TorrentialRain extends AbsWeatherEffect {
  
  override def name: String = "Weather: Torrential Rain"

  override def description: String = "Sets the strength of all Siege cards to 1 for both players."

  
  
}
