package cl.uchile.dcc
package gwent.Cards.card

/**
 * Represents a unit card in the game. this class DOESN'T exist in the actual game, is only to represent common
 * behaviors between all units cards.
 *
 * @param _name The name of the character in the card
 * @param _str The strength value of the card
 */
abstract class AbsUnitCard(private val _name: String, private var _str: Int) extends Card {
  /**
   * ===========================================================
   *  Getters and Setters
   * ===========================================================
   */
  def name: String = _name
  def str: Int = _str
  def str_(NewStr: Int): Unit = {
    _str = math.max(0, NewStr)
  }
}
