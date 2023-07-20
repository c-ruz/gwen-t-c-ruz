package cl.uchile.dcc
package gwent.game.factory.cardFactory

import gwent.game.effects.Effect

import cl.uchile.dcc.gwent.game.effects.unitCardEffects.{NullEffect, UnitEffect}

abstract class AbsUnitCardFactory extends UnitCardFactory {
  protected var _name: String = "Card Name"
  protected var _str: Int = 0
  protected var _effect: UnitEffect = new NullEffect

  /**
   * Changes the name of the card created.
   * @param newName String with the name of the card.
   */
  def setName(newName: String): Unit = {
    _name = newName
  }

  /**
   * Changes the strength of the unit card created.
   * @param newStr  Int with the strength.
   */
  def setStr(newStr: Int): Unit = {
    _str = math.max(0, newStr)
  }

  /**
   * Changes the effect of the unit card created.
   * @param newEffect UnitEffect to be changed into.
   */
  def setEffect(newEffect: UnitEffect): Unit = {
    _effect = newEffect
  }
}
