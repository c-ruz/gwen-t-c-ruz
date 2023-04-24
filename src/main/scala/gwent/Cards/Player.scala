package cl.uchile.dcc
package gwent.Cards

/**
 * Represents a player in the game.
 * @param name The name of the player.
 * @param gems How many lives the player starts with.
 * @param deck The deck assigned to the player
 * @param hand The hand assigned to the player
 */
class Player(val name: String, var gems: Int = 3, val deck: Deck, val hand: Hand) extends Equals {

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
    gems -= 1
  }
}
