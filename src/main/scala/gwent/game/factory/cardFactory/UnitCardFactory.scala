package cl.uchile.dcc
package gwent.game.factory.cardFactory

import gwent.game.effects.unitCardEffects.UnitEffect

trait UnitCardFactory extends CardFactory {
  
  def setStr(newStr: Int): Unit
  
  def setEffect(newEffect: UnitEffect): Unit
}
