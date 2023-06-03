package cl.uchile.dcc
package gwent.game.players

import gwent.game
import gwent.game.board.Board
import gwent.game.card.handler.{Deck, Hand}
import gwent.game.card.{MeleeCard, SiegeCard, WeatherCard}
import gwent.game.players.Player

import munit.FunSuite

import scala.collection.mutable.ArrayBuffer

class PlayerTest extends FunSuite {
  val Card1 = new MeleeCard("Eta, el Errabundo", 5)
  val Card2 = new MeleeCard("Zeeh, la primera luz", 3)
  val Card3 = new SiegeCard("Diral, dimensión espiral", 5)
  val Card4 = new WeatherCard("Escarcha mordiente")
  val Card5 = new WeatherCard("Clima despejado")
  val deckName = "Xan-kei deck"
  val gems = 3
  var deckCap = 5
  var handCap = 3
  var player1: Player = _
  var deck1: Deck = _
  var hand1: Hand = _
  val board: Board = new Board()

  override def beforeEach(context: BeforeEach): Unit = {
    deck1 = new Deck(ArrayBuffer(Card1, Card2, Card3, Card4, Card5), deckName, deckCap)
    hand1 = new Hand(3)
    player1 = new Player("Player1", gems, deck1, hand1, board)
  }

  test("A player can be created with a name, amount of gems, deck and hand assigned") {
    assertEquals(player1.name, "Player1")
    assertEquals(player1.gems, gems)
    assertEquals(player1.deck, deck1)
    assertEquals(player1.hand, hand1)
  }

  test("Two players are the same if they have the same name and deck") {
    assertEquals(player1, new Player("Player1",gems,deck1,hand1,board))

    assert(!player1.equals(new Player("Player2",gems,deck1,hand1,board)))

    val deck2 = new Deck("Empty deck", deckCap)
    val hand2 = new Hand(handCap)
    assert(!player1.equals(new Player("Player1", gems, deck2, hand2,board)))

    assert(!player1.equals(Card1))

  }

  test("Player can draw n cards from their deck") {
    // the standard draw amount is 3
    player1.draw()
    assertEquals(player1.hand.holding, 3)

    val expectedHand = new Hand(ArrayBuffer(Card1,Card2,Card3), handCap)
    val expectedDeck = new Deck(ArrayBuffer(Card4,Card5), deckName, deckCap)
    assertEquals(player1.hand, expectedHand)
    assertEquals(player1.deck, expectedDeck)

    // player cannot exceed hand capacity or draw when deck is empty
    player1.draw(1)
    assertEquals(player1.hand, expectedHand)

    // setting a new player with the same deck but empty hand.
    val deck3 = new Deck(ArrayBuffer(Card4,Card5), deckName, deckCap)
    val hand3 = new Hand(handCap)
    val player3 = new Player("Player3", gems, deck3, hand3, board)
    player3.draw()

    // since we only have 2 cards in the deck, hand should only draw 2 instead of 3 cards.
    val expectedHand2 = new Hand(ArrayBuffer(Card4, Card5), handCap)
    val expectedDeck2 = new Deck(deckName, deckCap)
    assertEquals(player3.hand, expectedHand2)
    assertEquals(player3.deck, expectedDeck2)
  }

  test("testing draw with negative value") {
    player1.draw(-1)
    val expectedHand = new Hand(handCap)

    assertEquals(player1.hand, expectedHand)
  }

  test("A player can get hit") {
    player1.hit()
    assert(player1.gems == 2)
  }

  test("If player is constructed with negative gems value, set to 0") {
    val expected = new Player("Player 1", 0, deck1, hand1, board)
    assertEquals(new Player("Player 1", -3, deck1, hand1, board), expected)
  }
}