package cl.uchile.dcc
package gwent.game

import cl.uchile.dcc.gwent.game.card.handler.{Deck, Hand}

class Player(name: String, gems: Int,
             deck: Deck, hand: Hand) extends AbsPlayer(name, gems, deck, hand) with Equals {
  /**
   * If constructor gems value < 0, then set them to 0.
   */
  gems_(gems)


  /**
   * =======================
   * Equals Implementation
   * =======================
   */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[Player]
  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[Player]) {
      super.equals(obj)
    } else {
      false
    }
  }

  /**
   * ===========================
   * Class Methods
   * ===========================
   */
}
