package cl.uchile.dcc

import CardHandler.{Deck, Hand}

/**
 * Represents a player in the game.
 *
 * @param _name The name of the player.
 * @param _gems How many lives the player starts with.
 * @param _deck The deck assigned to the player
 * @param _hand The hand assigned to the player
 */
class Player(private val _name: String, private var _gems: Int,
             private val _deck: Deck, private val _hand: Hand) extends Equals {
  /**
   * If constructor gems value < 0, then set them to 0.
   */
  gems_(gems)
  /**
   * ====================
   * Getters y Setters
   * ====================
   */
  def name: String = _name
  def gems: Int = _gems
  def hand: Hand = _hand
  def deck: Deck = _deck

  /**
   * =======================
   * Equals Implementation
   * =======================
   * @param NewGems
   */
  private def gems_(NewGems: Int): Unit = {
    _gems = math.max(0, NewGems)
  }
  override def canEqual(that: Any): Boolean = that.isInstanceOf[Player]
  override def equals(obj: Any): Boolean = {
    if (canEqual(obj: Any)) {
      val other = obj.asInstanceOf[Player]
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
   * @param n Amount of cards to draw from player's deck.
   */
  def draw(n: Int = 3): Unit = {
    var n2 = n
    if (hand.holding+n <= hand.handCapacity) {
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
    gems_(gems-1)
  }
}
