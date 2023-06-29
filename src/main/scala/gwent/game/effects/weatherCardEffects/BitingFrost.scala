package cl.uchile.dcc
package gwent.game.effects.weatherCardEffects

import gwent.game.effects.Effect

import cl.uchile.dcc.gwent.game.board.Board
import cl.uchile.dcc.gwent.game.card.Card
import cl.uchile.dcc.gwent.game.card.units.UnitCard

class BitingFrost extends AbsWeatherEffect {
  override def name: String = "Weather: Biting Frost"

  override def description: String = "Sets the strength of all Melee Card to 1 for both players."

  
}
