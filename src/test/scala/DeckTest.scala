package cl.uchile.dcc

import munit.FunSuite

class DeckTest extends FunSuite {
  val deckName = "Xan-Kei Deck"
  val capacity = 25
  val Card1 = new Card("Eta, el Errabundo", 5)
  val Card2 = new Card("Zeeh, la primera luz", 3)
  var deck1: Deck = _
  var deck2: Deck = _
  var deck3: Deck = _
  override def beforeEach(context: BeforeEach): Unit = {
    deck1 = new Deck(deckName, capacity)
    deck2 = new Deck(Set(Card1), deckName, capacity)
    deck3 = new Deck(Set(Card1, Card2), deckName, capacity)
  }
  test("An empty deck can be created with a name and max capacity") {
    assertEquals(deck1.name, deckName)
    assertEquals(deck1.capacity, capacity)
    assertEquals(deck1.holding, 0)
  }
  test("A deck can be created with a set of cards, name and max capacity") {
    assertEquals(deck2.name, deckName)
    assertEquals(deck2.capacity, capacity)
    assertEquals(deck2.holding, 1)
  }
  test("A card can be added to an existing deck") {
    assertEquals(deck3, deck2.addCard(Card2))
    val monks = Set(Card1, Card2, Card1)
    val expected = new Deck(monks, deckName, capacity)
    assertEquals(expected, deck3.addCard(Card1))
  }
  test("A card can be removed from an existing deck") {
    assertEquals(deck1, deck2.removeCard(Card2))
    assertEquals(deck1, deck1.removeCard(Card1))
  }
  test("An existing deck can be shuffled") {
    val monks = Set(Card2, Card1)
    val expected = new Deck(monks, deckName, capacity)
    assertEquals(expected, deck3.shuffle())
  }
}
