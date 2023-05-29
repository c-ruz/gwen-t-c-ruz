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
    super.equals(obj)
  }

  /**
   * ===========================
   * Class Methods
   * ===========================
   */

  /**
   * Sends a message to card saying a computer is playing the card
   * @param index        Position of the card to be played. Position starts at 1.
   */
  def play(index: Int): Unit = {
    if (index <= hand.holding && index > 0) {
      hand.getCard(index).placeOnComputer(board)
      hand.removeCard(index)
    }
  }
}
