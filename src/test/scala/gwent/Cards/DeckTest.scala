package cl.uchile.dcc
package gwent.Cards

import gwent.Cards
import gwent.Cards.Deck
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
    array2 = ArrayBuffer[Card](Card1,Card2,Card3)
    deck1 = new Deck(deckName, capacity)
    deck2 = new Deck(array2, deckName, capacity)
  }
  
  test("An empty deck can be created with a name and max capacity") {
    assertEquals(deck1.name, deckName)
    assertEquals(deck1.capacity, capacity)
    assertEquals(deck1.holding, 0)
  }

  test("A deck can be created with an array of cards, name and capacity") {
    assertEquals(deck2.name, deckName)
    assertEquals(deck2.capacity, capacity)
    assertEquals(deck2.holding, 3)
  }

  test("Testing structural equality between decks") {
    assert(!deck1.equals(Card1))

    assert(!deck1.equals(deck2))
    var expected = new Deck(array2, deckName, capacity)
    assertEquals(expected, deck2)

    val array = ArrayBuffer[Card](Card1, Card2, Card1)
    expected = new Deck(array, deckName, capacity)
    assert(!deck2.equals(expected))
  }


  test("An existing deck can be shuffled") {
    val before = new Deck(array2, deckName, capacity)
    deck2.mix()
    //Solo compara que tenga las mismas cartas
    assertEquals(before, deck2)
  }

  test("The first card of a Deck can be taken") {
    assert(deck2.getFirst().equals(Card1))
    assert(deck2.holding == 2)
    assert(deck2.getFirst().equals(Card2))
    assert(deck2.holding == 1)
    assert(deck2.getFirst().equals(Card3))
    assert(deck2.holding == 0)
  }

  /**test("A deck can be created with a set of cards, name and max capacity") {
    assertEquals(deck2.name, deckName)
    assertEquals(deck2.capacity, capacity)
    assertEquals(deck2.holding, 1)
  }*/

  /**test("A card can be removed from an existing deck") {
    assertEquals(deck1, deck2.removeCard(Card2))
    assertEquals(deck1, deck1.removeCard(Card1))
    assertEquals(deck2, deck2.removeCard(Card2))
  }*/

  /**test("A card can be added to an existing deck") {
    assertEquals(deck3, deck2.addCard(Card2))
    val monks = Set(Card1, Card2, Card1)
    val expected = new Deck(monks, deckName, capacity)
    assertEquals(expected, deck3.addCard(Card1))
  }*/
}
