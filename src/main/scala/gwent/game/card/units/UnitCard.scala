package cl.uchile.dcc
package gwent.game.card.units

import gwent.game.card.Card

trait UnitCard extends Card {
  
  def str: Int
  
  def currStr: Int
  
  def SetCurrStr(newStr: Int): Unit
}
