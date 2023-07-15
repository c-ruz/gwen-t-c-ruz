package cl.uchile.dcc
package gwent.game.card.units

import gwent.game.card.Card
import gwent.game.players.{Computer, Player}

import cl.uchile.dcc.gwent.game.effects.Effect
import cl.uchile.dcc.gwent.game.effects.unitCardEffects.UnitEffect

/**
 * Represents a unit card in the game. this class DOESN'T exist in the actual game, is only to represent common
 * behaviors between all units cards.
 *
 * @param _name The name of the character in the card
 * @param _str The strength value of the card
 */
abstract class AbsUnitCard(private val _name: String, private var _str: Int, private var _effect: UnitEffect) extends UnitCard {
  // Fixes card having negative strength
  str_(_str)
  
  private var _currStr = _str
  private var _status: Boolean = false
  
  /**
   * ===========================================================
   *  Getters and Setters
   * ===========================================================
   */

  /**
   * Card name getter.
   */
  override def name: String = _name

  /**
   * Returns the base strength of the card.
   */
  override def baseStr: Int = _str

  /**
   * Returns the effect of the card.
   */
  override def effect: UnitEffect = _effect

  /**
   * Returns the current strength of the card. If the card has been weakened by a card effect, returns 1.
   */
  override def currStr: Int = {
    if (this.isWeak) {
      1
    } else {
      _currStr
    }
  }

  /**
   * Returns true if the cards has been weakened by a card effect.
   */
  override def isWeak: Boolean = _status

  /**
   * Sets the base strength of the card. Used to fix construction of card with negative strength.
   * @param NewStr The strength to be set.
   */
  private def str_(NewStr: Int): Unit = {
    _str = math.max(0, NewStr)
  }

  /**
   * Sets the current strength.
   * @param newStr The strength to be set.
   */
  override def setCurrStr(newStr: Int): Unit = {
    _currStr = math.max(0, newStr)
  }

  /**
   * Sets the status of the card. 
   * @param NewStatus The new status.
   */
  override def setStatus(NewStatus: Boolean): Unit = {
    _status = NewStatus
  }
}
