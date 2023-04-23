package cl.uchile.dcc

import munit.FunSuite
import gwent.Cards

class PlayerTest extends FunSuite {
  val Card1 = new Card("Eta, el Errabundo", 5)
  val Card2 = new Card("Zeeh, la primera luz", 3)
  val Card3 = new Card("Diral, dimensión espiral")
  val Card4 = new Card("Escarcha mordiente")
  val Card5 = new Card("Clima despejado")
  val gems = 3
  var player1: Player = _
  var deck1: Deck = _
  var hand1: Hand = _
  var deckHolding: Int = _
  var handHolding: Int = _

  override def beforeEach(context: BeforeEach): Unit = {
    deck1 = new Deck(Set(Card1, Card2, Card3, Card4, Card5), "Xan-kei deck", 5)
    hand1 = new Hand(3)
    player1 = new Player("Player1", gems, deck1, hand1)
    deckHolding = deck1.holding
    handHolding = hand1.holding
  }

  test("A player can be created with a name, amount of gems, deck and hand assigned") {
    assertEquals(player1.name, "Player1")
    assertEquals(player1.gems, gems)
    assertEquals(player1.deck, deck1)
    assertEquals(player1.hand, hand1)
  }
  test("Player can draw a set of cards from their deck") {
    var n = 3
    assertEquals(player1.hand.holding, 0)
    player1.draw(n)
    assertEquals(player1.hand.holding, handHolding+n)
    assertEquals(player1.deck.holding, deckHolding-handHolding)

    //player cannot exceed hand capacity
    n = 1
    assertEquals(player1.hand.holding, player1.hand.capacity)
    val expected = player1.hand.holding
    val expected2 = player1.deck.holding
    player1.draw(n)
    assertEquals(expected, player1.hand.holding)
    assertEquals(expected2, player1.deck.holding)
  }
  test("Player can play cards from their hand") {
    //player.play(n) uses hand.getCard(n) method, and sets them in their respective board section
  }
}