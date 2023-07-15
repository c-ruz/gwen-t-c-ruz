package cl.uchile.dcc
package gwent.game.card.units

import gwent.game.card.Card

trait UnitCard extends Card {
  /**
   * Gets the base strength of the UnitCard.
   */
  def baseStr: Int

  /**
   * Gets the current strength of the UnitCard.
   */
  def currStr: Int

  /**
   * Sets the current strength of the UnitCard to newStr parameter. 
   * If newStr is less than 0, sets to 0 instead. 
   * @param newStr
   */
  def setCurrStr(newStr: Int): Unit

  /**
   * True if the UnitCard has been weakened by a weatherCard.
   */
  def isWeak: Boolean
  
  /**
   * Sets the state of the UnitCard.
   * @param status The new status.
   */
  def setStatus(status: Boolean): Unit
}
