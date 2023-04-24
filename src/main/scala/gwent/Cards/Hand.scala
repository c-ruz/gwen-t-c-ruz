package cl.uchile.dcc
package gwent.Cards

import scala.collection.mutable.ArrayBuffer

class Hand(val handCapacity: Int) extends Equals {
  private var cards: ArrayBuffer[Card] = ArrayBuffer()
  var holding = 0

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

  private def sameCards(other: Hand): Boolean = {
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

  def addCard(card: Card): Unit = {
    if (this.holding < this.handCapacity) {
      this.cards += card
      this.holding += 1
    }
  }

  def removeCard(card: Card): Unit = {
    cards.remove(cards.indexOf(card))
    holding -= 1
  }

  def getCard(index: Int): Card = {
    val card = cards(index)
    card
  }
}
