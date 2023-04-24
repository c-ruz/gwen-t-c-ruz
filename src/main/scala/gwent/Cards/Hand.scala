package cl.uchile.dcc
package gwent.Cards

import scala.collection.mutable.ArrayBuffer

/**
 * Represents a hand of cards used in the game.
 * @param handCapacity How many cards can be on a hand.
 */
class Hand(val handCapacity: Int) extends Equals {
  private var cards: ArrayBuffer[Card] = ArrayBuffer()
  var holding = 0

  /**
   * Represents a deck of cards used in the game.
   * @param list When creating a hand with initial cards.                   
   */
  def this(list: ArrayBuffer[Card], capacity: Int) = {
    this(capacity)
    val amount = list.length
    if (amount <= capacity) {
      cards ++= list
      holding += amount
    } else {
      cards ++= list.take(capacity)
      holding += capacity
    }
  }  

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
   * Returns true if both hand have the same cards, regardless of order.
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
   * Adds a card to the hand if possible.
   */
  def addCard(card: Card): Unit = {
    if (this.holding < this.handCapacity) {
      this.cards += card
      this.holding += 1
    }
  }

  /**
   * remove a card to the hand.
   * @param card Some card inside the hand.
   */
  def removeCard(card: Card): Unit = {
    cards.remove(cards.indexOf(card))
    holding -= 1
  }

  /**
   * Adds a card to the hand if possible.
   * @param index The index of the cards in the array representing the hand
   */
  def getCard(index: Int): Card = {
    val card = cards(index)
    card
  }
}
