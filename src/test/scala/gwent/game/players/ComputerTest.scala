package cl.uchile.dcc
package gwent.game.players

import gwent.game.board.Board
import gwent.game.card.{MeleeCard, SiegeCard, WeatherCard}
import gwent.game.card.handler.{Deck, Hand}
import scala.collection.mutable.ArrayBuffer
import munit.FunSuite

class ComputerTest extends FunSuite {
  val Card1 = new MeleeCard("Eta, el Errabundo", 5)
  val Card2 = new MeleeCard("Zeeh, la primera luz", 3)
  val Card3 = new SiegeCard("Diral, dimensión espiral", 5)
  val Card4 = new WeatherCard("Escarcha mordiente")
  val Card5 = new WeatherCard("Clima despejado")
  val deckName = "Xan-kei deck"
  val gems = 3
  var deckCap = 5
  var handCap = 3
  var player1: Computer = _
  var deck1: Deck = _
  var hand1: Hand = _
  val board: Board = new Board()

  override def beforeEach(context: BeforeEach): Unit = {
   deck1 = new Deck(ArrayBuffer(Card1, Card2, Card3, Card4, Card5), deckName, deckCap)
   hand1 = new Hand(handCap)
   player1 = new Computer("CPU", gems, deck1, hand1, board)
  }

  test("constructor test") {
    // Computer has a name, gems, deck, hand and board
    assertEquals(player1.name, "CPU")
    assertEquals(player1.gems, gems)
    assertEquals(player1.deck, deck1)
    assertEquals(player1.hand, hand1)
    assertEquals(player1.board, board)

    // Testing constructor when gems value is negative
    val player2 = new Computer("CPU", -1, deck1, hand1, board)
    assertEquals(player2.gems, 0)
  }

  test("structural equality") {
    // Computer objects are equal if they have the same name and deck
    val expected = new Computer("CPU", gems, deck1, hand1, board)
    assertEquals(player1, expected)
    val expected2 = new Computer("CPU2", gems, deck1, hand1, board)
    assert(!player1.equals(expected2))

    // Computer object is not equal to Player object
    // This player has an equivalent name and deck
    val deck2 = new Deck(ArrayBuffer(Card1, Card2, Card3, Card4, Card5), deckName, deckCap)
    val hand2 = new Hand(handCap)
    val player2 = new Player("CPU", gems, deck2, hand2, board)
    assert(!player1.equals(player2))
  }

  test("Computer object can draw cards from his deck") {
    player1.draw()
    // base draw amount is 3
    val expected = new Hand(ArrayBuffer(Card1,Card2,Card3), handCap)
    val expected2 = new Deck(ArrayBuffer(Card4,Card5), deckName, deckCap)
    assertEquals(player1.hand, expected)
    assertEquals(player1.deck, expected2)
  }
}
