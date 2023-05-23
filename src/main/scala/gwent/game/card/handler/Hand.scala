package cl.uchile.dcc
package gwent.Cards.card.handler

import cl.uchile.dcc.gwent.Cards.card.Card
import scala.collection.mutable.ArrayBuffer

/**
 * Represents a hand of cards used in the game.
 * @param _handCapacity How many cards can be on a hand.
 */
class Hand(private val _handCapacity: Int) extends Equals {
  private val cards: ArrayBuffer[Card] = ArrayBuffer()
  private var _holding = 0

  /**
   * Represents a hand of cards used in the game.
   *
   * @param list When creating a hand with initial cards.                   
   */
  def this(list: ArrayBuffer[Card], capacity: Int) = {
    this(capacity)
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
   * ===================
   * Getters y Setters
   * ===================
   */
  def handCapacity: Int = _handCapacity

  def holding: Int = _holding

  def holding_(NewHolding: Int): Unit = {
    _holding = math.max(0, NewHolding)
  }

  /**
   * ======================
   * Equals Implementation
   * ======================
   */
  override def canEqual(that: Any): Boolean = that.isInstanceOf[Hand]

  override def equals(obj: Any): Boolean = {
    if (canEqual(obj: Any)) {
      val other = obj.asInstanceOf[Hand]
      (this eq other) ||
        (this.handCapacity == other.handCapacity && this.sameCards(other))
    } else {
      false
    }
  }

  /**
   * Returns true if both hands have the same cards, regardless of order.
   *
   * @param other The other hand to compare.
   */
  def sameCards(other: Hand): Boolean = {
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
   * Class methods
   * ==============
   */

  /**
   * Adds a card to the hand if possible.
   */
  def addCard(card: Card): Unit = {
    if (this.holding < this.handCapacity) {
      this.cards += card
      this.holding_(holding + 1)
    }
  }
  /**
   * remove a card from the hand.
   *
   * @param card Some card inside the hand. Note that if the card is not present in the hand,
   *             nothing will be deleted.
   */
  def removeCard(card: Card): Unit = {
    cards.remove(cards.indexOf(card))
    holding_(holding - 1)
  }

  /**
   * Adds a card to the hand if possible.
   *
   * @param index The index of the cards in the array representing the hand
   */
  def getCard(index: Int): Card = {
    val card = cards(index)
    card
  }
}