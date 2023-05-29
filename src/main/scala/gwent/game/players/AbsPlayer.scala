package cl.uchile.dcc
package gwent.game.players

import gwent.game.card.handler.{Deck, Hand}
import gwent.game.card.Card

import cl.uchile.dcc.gwent.game.board.Board

/**
 * Represents a player in the game.
 *
 * @param _name The name of the player.
 * @param _gems How many lives the player starts with.
 * @param _deck The deck assigned to the player
 * @param _hand The hand assigned to the player
 */
abstract class AbsPlayer(private val _name: String, private var _gems: Int,
                private val _deck: Deck, private val _hand: Hand, _board: Board) extends Equals {

  /**
   * ====================
   * Getters y Setters
   * ====================
   */
  def name: String = _name
  def gems: Int = _gems
  def hand: Hand = _hand
  def deck: Deck = _deck
  def board: Board = _board
  /**
   * Sets new value for gems, min == 0.
   * @param NewGems New gem value to set.
   */
  protected def gems_(NewGems: Int): Unit = {
    _gems = math.max(0, NewGems)
  }

  /**
   * We only define equals for the abstract class, since canEquals is going
   * to be implemented by the subclasses.
   * @param obj     The other AbsPlayer to compare
   * @return        True if objects have the same name and deck
   */
  override def equals(obj: Any): Boolean = {
    if (canEqual(obj)) {
      val other = obj.asInstanceOf[AbsPlayer]
      (this eq other) ||
        (this.name == other.name && this.deck.equals(other.deck))
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
   * Draws some cards from the player's deck and adds them to their hand.
   *
   * @param n Amount of cards to draw from player's deck.
   */
  def draw(n: Int = 3): Unit = {
    var n2 = n
    if (hand.holding + n <= hand.handCapacity) {
      while (n2 != 0) {
        hand.addCard(deck.getFirst)
        n2 -= 1
      }
    }
  }
  /**
   * Reduces the player's health (gems) by one.
   */
  def hit(): Unit = {
    gems_(gems - 1)
  }

  /**
   * Sends a message to the card for it to place itself in the corresponding board section.
   * @param index        position on hand of the card to be put in the board.
   */
  def play(index: Int): Unit
  
}
