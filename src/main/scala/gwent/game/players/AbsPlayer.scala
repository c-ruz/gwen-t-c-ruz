package cl.uchile.dcc
package gwent.game.players

import gwent.game.card.handler.{Deck, Hand}
import gwent.game.card.Card
import cl.uchile.dcc.gwent.game.board.Board
import cl.uchile.dcc.gwent.game.controller.Observer

import scala.collection.mutable.ListBuffer

/**
 * Represents a player in the game.
 *
 * @param _name The name of the player.
 * @param _gems How many lives the player starts with.
 * @param _deck The deck assigned to the player
 * @param _hand The hand assigned to the player
 */
abstract class AbsPlayer(private val _name: String, private var _gems: Int,
                private val _deck: Deck, private val _hand: Hand, _board: Board) extends IPlayer with Equals with ISubject {

  /**
   * If constructor gems value < 0, then set them to 0.
   */
  gems_(gems)

  protected val observers: ListBuffer[Observer] = ListBuffer()
  /**
   * ====================
   * Getters and Setters
   * ====================
   */
  override def name: String = _name
  override def gems: Int = {
    val clone = _gems
    clone
  }
  override def hand: Hand = {
    val clone = new Hand(_hand.cards, _hand.handCapacity)
    clone
  }
  override def deck: Deck = {
    val clone = new Deck(_deck.cards, _deck.name, _deck.capacity)
    clone
  }
  /**
   * Sets new value for gems, min == 0.
   * @param NewGems New gem value to set.
   */
  private def gems_(NewGems: Int): Unit = {
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
      val other = obj.asInstanceOf[IPlayer]
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
   * Draws some cards from the player's deck and adds them to their hand. Adds until some break condition
   * is met. Break conditions are: max hand capacity reached, deck empty or finished drawing.
   *
   * @param n Amount of cards to draw from player's deck.
   */
  
  override def draw(n: Int = 3): Unit = {
    var n2 = math.max(0,n)
    while (_hand.holding < _hand.handCapacity &&
    _deck.holding != 0 && n2 != 0) {
      _hand.addCard(_deck.getFirst)
      n2 -= 1
    }
  }
  /**
   * Reduces the player's health (gems) by one.
   */
  def hit(): Unit = {
    gems_(_gems - 1)
    notifyObserver(this.gems)
  }

  /**
   * Shuffles the deck of the player.
   */
  override def shuffle(): Unit = {
    _deck.mix()
  }
  override def registerObserver(o: Observer): Unit = {
    observers += o
  }
}
