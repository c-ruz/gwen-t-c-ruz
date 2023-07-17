package cl.uchile.dcc
package gwent.game.factory.cardFactory

import gwent.game.effects.unitCardEffects.UnitEffect

trait UnitCardFactory extends CardFactory {
  /**
   * This method changes the strength parameter of the cards.
   * @param newStr  The new strength.
   */
  def setStr(newStr: Int): Unit

  /**
   * This method changes the effect parameter od the factory.
   * @param newEffect The new effect of type UnitEffect.
   */
  def setEffect(newEffect: UnitEffect): Unit
}
