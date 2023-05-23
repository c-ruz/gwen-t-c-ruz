package cl.uchile.dcc
package gwent.game.players

import gwent.game.card.handler.{Deck, Hand}
import gwent.game.players.AbsPlayer
import cl.uchile.dcc.gwent.game.board.Board
import cl.uchile.dcc.gwent.game.card.Card

class Computer(name: String, gems: Int,
              deck: Deck, hand: Hand, board: Board) extends AbsPlayer(name, gems, deck, hand, board) {
  /**
   * If constructor gems value < 0, then set them to 0.
   */
  gems_(gems)

  /**
   * =======================
   * Equals Implementation
   * =======================
   */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[Computer]
  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[Computer]) {
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
   * Sends a message to card saying a computer is playing the card
   * @param card        card to be put in the board.
   */
  def play(card: Card): Unit = {
    card.placeOnComputer(board)
  }
}
