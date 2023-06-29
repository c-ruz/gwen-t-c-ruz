package cl.uchile.dcc
package gwent.game.effects

import gwent.game.card.Card

import cl.uchile.dcc.gwent.game.board.Board
import cl.uchile.dcc.gwent.game.card.units.UnitCard

trait Effect {
  
  def name: String
  
  def description: String
  
  def activate(row: List[UnitCard]): Unit
  
}
