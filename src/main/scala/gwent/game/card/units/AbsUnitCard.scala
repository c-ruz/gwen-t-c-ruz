package cl.uchile.dcc
package gwent.game.card.units

import gwent.game.card.Card
import gwent.game.players.{Computer, Player}

import cl.uchile.dcc.gwent.game.effects.Effect

/**
 * Represents a unit card in the game. this class DOESN'T exist in the actual game, is only to represent common
 * behaviors between all units cards.
 *
 * @param _name The name of the character in the card
 * @param _str The strength value of the card
 */
abstract class AbsUnitCard(private val _name: String, private var _str: Int, private var _effect: Effect) extends UnitCard {
  // Fixes card having negative strength
  str_(_str)
  
  private var _currStr = _str
  
  /**
   * ===========================================================
   *  Getters and Setters
   * ===========================================================
   */
  def name: String = _name
  def str: Int = _str
  
  def effect: Effect = _effect
  def currStr: Int = _currStr
  

  private def str_(NewStr: Int): Unit = {
    _str = math.max(0, NewStr)
  }

  def SetCurrStr(newStr: Int): Unit = {
    _currStr = math.max(0, newStr)
  }
}
