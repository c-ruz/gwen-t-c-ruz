package cl.uchile.dcc
package gwent.game.card.handler

import cl.uchile.dcc.gwent.game.card.Card
import scala.collection.mutable.ArrayBuffer

/**
 * Represents a deck of cards used in the game.
 * @param _name       The name of the deck (mostly for differentiation).
 * @param _capacity   How many cards can a deck hold.
 */
class Deck(private val _name: String,
           private val _capacity: Int) extends Equals {
  private val cards: ArrayBuffer[Card] = ArrayBuffer()
  private var _holding = 0
  /**
   * Represents a deck of cards used in the game.
   *
   * @param _name      The name of the deck (mostly for differentiation).
   * @param _capacity  How many cards can a deck hold.
   * @param list       When creating a deck with initial cards, add a list.
   *                   If cards in list are > deck.capacity, add until full.
   */
  def this(list: ArrayBuffer[Card], _name: String, _capacity: Int) = {
    this(_name, _capacity)
    val amount = list.length
    if (amount <= capacity) {
      cards ++= list
      holding_(amount)
    } else {
      cards ++= list.take(capacity)
      holding_(capacity)
    }
  }

  /**
   * ==================
   * Getters y Setters
   * ==================
   */
  def name: String = _name
  def capacity: Int = _capacity
  def holding: Int = _holding

  def holding_(NewHolding: Int): Unit = {
    _holding = math.max(0, NewHolding)
  }

  /**
   * ========================
   * Equals implementation
   * ========================
   */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[Deck]
  override def equals(obj: Any): Boolean = {
    if (canEqual(obj: Any)) {
      val other = obj.asInstanceOf[Deck]
      (this eq other) ||
        (this.name == other.name && this.capacity == other.capacity
          && this.sameCards(other))
    } else {
      false
    }
  }
  /**
   * Returns true if both decks have the same cards, regardless of order.
   * @param other The other deck to compare.
   */
  def sameCards(other: Deck): Boolean = {
    if (this.cards.length == other.cards.length) {
      val compare = other.cards.clone()
      for (card <- this.cards) {
        compare -= card
      }
      if (compare.isEmpty) {
        true
      } else {
        false
      }
    } else {
      false
    }
  }

  /**
   * ==============
   * Class Methods
   * ==============
   */

  /**
   * Shuffles the cards in the deck.
   */
  def mix(): Unit = {
    util.Random.shuffle(this.cards)
  }

  /**
   * Returns the first card in the deck and removes it.
   */
  def getFirst: Card = {
    val card = this.cards(0)
    this.cards.remove(0)
    this.holding_(holding-1)
    card
  }

  /**
   * Adds a card to the deck if possible.
   * @param card  card that's going to be added.
   */
  def addCard(card: Card): Unit = {
    if (this.holding < this.capacity) {
      this.cards += card
      this.holding_(holding+1)
    }
  }
}
