package cl.uchile.dcc
package gwent.game.players

import gwent.game.card.handler.{Deck, Hand}
import cl.uchile.dcc.gwent.game.board.Board
import cl.uchile.dcc.gwent.game.card.Card

class Player(name: String, gems: Int,
             deck: Deck, hand: Hand, board: Board) extends AbsPlayer(name, gems, deck, hand, board) with Equals {
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

  /**
   * Sends a message to the card saying a player is playing the card.
   * @param card        card to be put in the board.
   */
  def play(card: Card): Unit = {
    card.placeOnPlayer(board)
  }
}
