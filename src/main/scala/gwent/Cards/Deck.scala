package cl.uchile.dcc
package gwent.Cards

import scala.collection.mutable.ArrayBuffer

class Deck(val name: String,
           val capacity: Int) extends Equals {
  private var cards: ArrayBuffer[Card] = ArrayBuffer()
  var holding = 0

  def this(list: ArrayBuffer[Card], name: String, capacity: Int) = {
    this(name, capacity)
    val amount = list.length
    if (amount <= capacity) {
      cards ++= list
      holding += amount
    } else {
      cards ++= list.take(capacity)
      holding += capacity
    }
  }

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

  private def sameCards(other: Deck): Boolean = {
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

  def mix(): Unit = {
    util.Random.shuffle(this.cards)
  }

  def getFirst: Card = {
    val card = this.cards(0)
    this.cards.remove(0)
    this.holding -= 1
    card
  }
  
  def addCard(card: Card): Unit = {
    if (this.holding < this.capacity) {
      this.cards += card
      this.holding += 1
    }
  }
}

  /**
  var cards: List[Card] = List[Card]()
  var holding = 0

  def this(list: List[Card], name: String, capacity: Int) = {
    this(name, capacity)
    val amount = list.length
    if (amount <= capacity) {
      cards ++= list
      holding += amount
    }
  }

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

  private def sameCards(other: Deck): Boolean = {
    if (this.cards.length == other.cards.length) {
      val traverse = this.cards.distinct
      for (card <- traverse) {

      }
    }
  }
}*/
