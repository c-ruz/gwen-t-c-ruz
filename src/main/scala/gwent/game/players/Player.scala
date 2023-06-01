package cl.uchile.dcc
package gwent.game.players

import gwent.game.card.handler.{Deck, Hand}
import cl.uchile.dcc.gwent.game.board.Board
import cl.uchile.dcc.gwent.game.card.Card

class Player(name: String, gems: Int,
             deck: Deck, hand: Hand, board: Board) extends AbsPlayer(name, gems, deck, hand, board) with Equals {


  /**
   * =======================
   * Equals Implementation
   * =======================
   */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[Player]
  override def equals(obj: Any): Boolean = {
    super.equals(obj)
  }

  /**
   * ===========================
   * Class Methods
   * ===========================
   */

  /**
   * Sends a message to the card saying a player is playing the card.
   * @param index   Position of the card to be played. Position starts at 1.
   *
   */
  def play(index: Int): Unit = {
    if (index <= hand.holding && index > 0) {
      hand.getCard(index).placeOnPlayer(board)
      hand.removeCard(index)
    }
  }
}
