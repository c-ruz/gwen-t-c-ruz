package cl.uchile.dcc
package gwent.game.factory.cardFactory

import gwent.game.effects.Effect

import cl.uchile.dcc.gwent.game.effects.unitCardEffects.{NullEffect, UnitEffect}

abstract class AbsUnitCardFactory extends UnitCardFactory {
  protected var _name: String = "Card Name"
  protected var _str: Int = 0
  protected var _effect: UnitEffect = new NullEffect

  def setName(newName: String): Unit = {
    _name = newName
  }

  def setStr(newStr: Int): Unit = {
    _str = math.max(0, newStr)
  }
  
  def setEffect(newEffect: UnitEffect): Unit = {
    _effect = newEffect
  }
}
