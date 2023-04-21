package cl.uchile.dcc
package gwent

import gwent.Cards

import cl.uchile.dcc.gwent.Cards.Deck
import munit.FunSuite

import scala.collection.mutable.ArrayBuffer

class DeckTest extends FunSuite{
  val deckName = "Xan-Kei Deck"
  val capacity = 3
  val Card1 = new MeleeCard("Zeeh, la primera luz", 3)
  val Card2 = new RangeCard("Emperador Ten", 5)
  val Card3 = new SiegeCard("Soldado de arcilla", 2)
  var array2 = ArrayBuffer[Card](Card1,Card2,Card3)
  var deck1: Deck = _
  var deck2: Deck = _

  override def beforeEach(context: BeforeEach): Unit = {
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

  test("Testing estructural equality between decks") {
    val expected = new Deck(array2, deckName, capacity)
    assertEquals(expected, deck2)
  }


  test("An existing deck can be shuffled") {
    val before = new Deck(array2, deckName, capacity)
    deck2.mix()
    //Solo compara que tenga las mismas cartas
    assertEquals(before, deck2)
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
