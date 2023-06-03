package cl.uchile.dcc
package gwent.game.card.handler

import gwent.game.card.Card
import scala.collection.mutable.ArrayBuffer

/**
 * Represents a hand of cards used in the game.
 * @param _handCapacity How many cards can be on a hand.
 */
class Hand(private val _handCapacity: Int) extends Equals {
  private val _cards: ArrayBuffer[Card] = ArrayBuffer()
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
      _cards ++= list
      holding_(amount)
    } else {
      _cards ++= list.take(capacity)
      holding_(capacity)
    }
  }

  /**
   * ===================
   * Getters y Setters
   * ===================
   */
  def handCapacity: Int = _handCapacity

  def holding: Int = {
    val clone = _holding
    clone
  }
  def cards: ArrayBuffer[Card] = {
    val clone = _cards.clone()
    clone
  }

  private def holding_(NewHolding: Int): Unit = {
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
    if (this._cards.length == other._cards.length) {
      val compare = other._cards.clone()
      for (card <- this._cards) {
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
   * Adds a card to the hand. If there is not space left, does nothing.
   *
   * @param  card card to be added.
   */
  def addCard(card: Card): Unit = {
    if (this.holding < this.handCapacity) {
      this._cards += card
      this.holding_(holding + 1)
    }
  }
  /**
   * remove a card from the hand.
   *
   * @param index   position of the card to be removed. If there is no card, does nothing.
   */
  def removeCard(index: Int): Unit = {
    if (index > 0 && index <= holding) {
      _cards.remove(index-1)
      holding_(holding-1)
    }
  }

  /**
   * Auxiliary method to use when playing cards. Possible exception is handled by play method
   * on Player/Computer class.
   *
   * @param index The index of the card in the hand
   */
  def getCard(index: Int): Card = {
    _cards(index-1)
  }
}