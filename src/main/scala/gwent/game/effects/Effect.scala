package cl.uchile.dcc
package gwent.game.effects

import gwent.game.card.Card

import cl.uchile.dcc.gwent.game.board.Board
import cl.uchile.dcc.gwent.game.card.units.UnitCard

trait Effect extends Equals {
  /**
   * Effect name getter.
   * @return A string with the name of the effect.
   */
  def name: String

  /**
   * Effect description getter
   * @return A string with the description of the effect.
   */
  def description: String

  /**
   * Apply the effect of the card.
   * @param self  The card with the effect.
   * @param target  Target row of cards.
   */
  def apply(self: Card, target: List[UnitCard]): Unit

  override def equals(obj: Any): Boolean = {
    if (canEqual(obj)) {
      true
    } else {
      false
    }
  }
}
