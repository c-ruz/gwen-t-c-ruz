package cl.uchile.dcc
package gwent.game.players

import gwent.game.card.handler.{Deck, Hand}
import gwent.game.players.AbsPlayer
import gwent.game.board.Board
import gwent.game.card.Card

class Computer(name: String, gems: Int,
              deck: Deck, hand: Hand, board: Board) extends AbsPlayer(name, gems, deck, hand, board) {
  /**
   * If constructor gems value < 0, then set them to 0.
   */

  /**
   * =======================
   * Equals Implementation
   * =======================
   */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[Computer]

  /**
   * ===========================
   * Class Methods
   * ===========================
   */

  /**
   * Sends a message to card saying a computer is playing the card
   * @param index        Position of the card to be played. Position starts at 1.
   */
  override def play(index: Int): Unit = {
    if (index <= hand.holding && index > 0) {
      hand.getCard(index).placeOnComputer(board)
      hand.removeCard(index)
    }
  }

  override def notifyObserver(arg: Any): Unit = {
    for (o <- observers) {
      o.updateCpu(this, arg)
    }
  }
}
