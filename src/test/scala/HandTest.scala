package cl.uchile.dcc

import munit.FunSuite

class HandTest extends FunSuite {
  val capacity = 2
  val Card1 = new Card("Eta, el Errabundo", 5)
  val Card2 = new Card("Zeeh, la primera luz", 3)
  var hand1: Hand = _
  var hand2: Hand = _
  override def beforeEach(context: BeforeEach): Unit = {
    hand1 = new Hand(capacity)
    hand2 = new Hand(monks, capacity)
  }
  test("An empty hand can be created with max capacity") {
    assertEquals(hand1.capacity, capacity)
    assertEquals(hand1.holding, 0)
  }
  test("A hand can be initialized with a set of cards and max capacity") {
    assertEquals(hand2.holding, 2)
  }
  test("A set of cards can be added to a hand") {
    hand1.addCards(monks)
    assertEquals(hand1, hand2)
  }
  test("Cards can be removed from a hand") {
    var expected = new Hand(Set(Card1), capacity)
    hand2.removeCard(Card2)
    assertEquals(expected, hand2)
    assertEquals(hand2.holding, capacity-1)
    hand1.removeCard(Card1)
    expected = new Hand(capacity)
    assertEquals(expected,hand1)
  }
  test("Cannot add cards over maximum capacity") {
    val monks = Set(Card1, Card2)
    val expected = new Hand(monks, capacity)
    hand2.addCards(Set(Card1))
    assertEquals(expected, hand2)
    assertEquals(hand2.holding, capacity)
  }
  test("Get a specified card from a hand based on order") {
    assertEquals(hand2.getCard(1), Card1)
  }
  test("Get a specified card from a hand based on order") {
    assertEquals(hand2.getCard(2), Card2)
  }
}
