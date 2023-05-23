package cl.uchile.dcc
package gwent.game.card.handler

import gwent.game
import gwent.game.card.{Card, MeleeCard, RangedCard, SiegeCard}
import gwent.game.card.handler.Deck

import munit.FunSuite

import scala.collection.mutable.ArrayBuffer

class DeckTest extends FunSuite{
  val deckName = "Xan-Kei Deck"
  val capacity = 3
  val Card1 = new MeleeCard("Zeeh, la primera luz", 3)
  val Card2 = new RangedCard("Emperador Ten", 5)
  val Card3 = new SiegeCard("Soldado de terracota", 2)
  var array2: ArrayBuffer[Card] = _
  var deck1: Deck = _
  var deck2: Deck = _

  override def beforeEach(context: BeforeEach): Unit = {
    array2 = ArrayBuffer(Card1,Card2,Card3)
    deck1 = new Deck(deckName, capacity)
    deck2 = new Deck(array2, deckName, capacity)
  }
  
  test("An empty deck can be created with a name and max capacity") {
    assertEquals(deck1.name, deckName)
    assertEquals(deck1.capacity, capacity)
    assertEquals(deck1.holding, 0)
  }

  test("Can add cards to a deck") {
    deck1.addCard(Card1)

    val expected = new Deck(ArrayBuffer(Card1), deckName, capacity)
    assertEquals(deck1, expected)
    assert(deck1.holding == 1)
  }

  test("Cannot add cards over capacity") {
    deck2.addCard(Card3)
    val expected = new Deck(array2, deckName, capacity)
    assertEquals(deck2, expected)
    assert(deck2.capacity == 3)
  }

  test("A deck can be created with an array of cards, name and capacity") {
    assertEquals(deck2.name, deckName)
    assertEquals(deck2.capacity, capacity)
    assertEquals(deck2.holding, 3)
  }

  test("When creating a Deck, if capacity is exceeded, only add the first cards that fit") {
    // if capacity is 3, then the first 3 in (Card1,Card2,Card3,Card1) 
    array2 += Card1
    val compare = new Deck(array2, deckName, capacity)
    assertEquals(deck2, compare)
  }

  test("Testing structural equality between decks") {
    assert(!deck1.equals(Card1))
    assert(!deck1.equals(deck2))

    var expected = new Deck( array2, deckName, capacity)
    assertEquals(expected, deck2)

    expected = new Deck(ArrayBuffer[Card](Card1, Card2, Card1), deckName, capacity)
    assert(!deck2.equals(expected))
  }


  test("An existing deck can be shuffled") {
    val before = new Deck(array2, deckName, capacity)
    deck2.mix()
    // We only compare if they have the same cards for now
    assertEquals(before, deck2)
  }

  test("The first card of a Deck can be taken") {
    assert(deck2.getFirst.equals(Card1))
    assert(deck2.holding == 2)
    assert(deck2.getFirst.equals(Card2))
    assert(deck2.holding == 1)
    assert(deck2.getFirst.equals(Card3))
    assert(deck2.holding == 0)
  }
}
