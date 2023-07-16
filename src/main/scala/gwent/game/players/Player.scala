package cl.uchile.dcc
package gwent.game.players

import gwent.game.card.handler.{Deck, Hand}
import gwent.game.board.Board
import gwent.game.card.Card

class Player(name: String, gems: Int,
             deck: Deck, hand: Hand, board: Board) extends AbsPlayer(name, gems, deck, hand, board) with Equals {


  /**
   * =======================
   * Equals Implementation
   * =======================
   */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[Player]

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
  override def play(index: Int): Unit = {
    if (index <= hand.holding && index > 0) {
      hand.getCard(index).placeOnPlayer(board)
      hand.removeCard(index)
    }
  }

  override def notifyObserver(arg: Any): Unit = {
    for (o <- observers) {
      o.updatePlayer(this, arg)
    }
  }
}
