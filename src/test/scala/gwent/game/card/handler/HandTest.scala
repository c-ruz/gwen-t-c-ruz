package cl.uchile.dcc
package gwent.game.card.handler

import gwent.game.card.{Card, MeleeCard, RangedCard}
import gwent.game.card.handler.Hand

import munit.FunSuite

import scala.collection.mutable.ArrayBuffer

class HandTest extends FunSuite {
  val capacity = 2
  val Card1 = new MeleeCard("Eta, el Errabundo", 5)
  val Card2 = new RangedCard("Zeeh, la primera luz", 3)
  var cards: ArrayBuffer[Card] = _
  var hand1: Hand = _
  var hand2: Hand = _
  override def beforeEach(context: BeforeEach): Unit = {
    cards = ArrayBuffer(Card1, Card2)
    hand1 = new Hand(capacity)
    hand2 = new Hand(cards, capacity)

  }
  test("An empty hand can be created with capacity") {
    assertEquals(hand1.handCapacity, capacity)
    assertEquals(hand1.holding, 0)
  }

  test("Can create a hand with initial cards and capacity") {
    // Normally we will create empty hands, this is mostly for testing
    assertEquals(hand2.handCapacity, capacity)
    assertEquals(hand2.holding, 2)
  }

  test("Can add cards to a hand") {
    //usually from a deck, but not necessarily
    hand1.addCard(Card1)
    assertEquals(hand1.holding, 1)
  }

  test("Two hands are the same if they have the same cards and the same capacity") {
    assert(!hand1.equals(Card1))

    hand1.addCard(Card2)
    assert(!hand1.equals(hand2))

    hand1.addCard(Card1)
    assertEquals(hand1, hand2)

    val compare = new Hand(ArrayBuffer(Card1, Card1), capacity)
    assert(!hand2.equals(compare))
  }

  test("When creating a hand, if capacity is exceeded, only add the first cards that fit") {
    // if capacity is 2, then the first 2 cards in (Card1,Card2,Card2)
    val compare = new Hand(ArrayBuffer(Card1, Card2, Card2), capacity)
    assertEquals(compare, hand2)
  }

  test("Cannot add cards over maximum capacity") {
    hand2.addCard(Card2)
    val expected = new Hand(cards, capacity)
    assertEquals(hand2, expected)
    assertEquals(hand2.holding, 2)
  }

  test("Get a specified card from a hand based on order") {
    assertEquals(hand2.getCard(0), Card1)
    assertEquals(hand2.getCard(1), Card2)
  }
  test("Remove a card from a hand") {
    hand2.removeCard(Card1)
    assertEquals(hand2.holding, 1)
    hand2.removeCard(Card2)
    assertEquals(hand2.holding, 0)

    assertEquals(hand1, hand2)
  }
}