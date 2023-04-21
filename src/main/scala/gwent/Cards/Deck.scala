package cl.uchile.dcc
package gwent.Cards

import scala.collection.mutable.ArrayBuffer

class Deck(val name: String,
           val capacity: Int) extends Equals {
  val cards: ArrayBuffer[Card] = ArrayBuffer[Card]()
  var holding = 0
  def this(list: ArrayBuffer[Card], name: String, capacity: Int) = {
    this(name, capacity)
    cards ++= list
    holding += list.length
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
      for (card <- this.cards) {
        other.cards -= card
      }
      if (other.cards.length == 0) {
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
}
