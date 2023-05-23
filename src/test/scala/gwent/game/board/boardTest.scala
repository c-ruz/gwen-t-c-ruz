package cl.uchile.dcc
package gwent.game.board

import cl.uchile.dcc.gwent.game.card.{MeleeCard, SiegeCard, WeatherCard}
import cl.uchile.dcc.gwent.game.card.handler.{Deck, Hand}
import cl.uchile.dcc.gwent.game.players.{Computer, Player}
import munit.FunSuite

import scala.collection.mutable.ArrayBuffer

class boardTest extends FunSuite {

  val Card1 = new MeleeCard("Eta, el Errabundo", 5)
  val Card2 = new MeleeCard("Zeeh, la primera luz", 3)
  val Card3 = new SiegeCard("Diral, dimensión espiral", 5)
  val Card4 = new WeatherCard("Escarcha mordiente")
  val Card5 = new WeatherCard("Clima despejado")
  val deckName = "Xan-kei deck 1"
  val deckName2 = "Xan-kei deck 2"
  val gems = 3
  var deckCap = 5
  var handCap = 3
  var player1: Player = _
  var deck1: Deck = _
  var hand1: Hand = _
  var player2: Computer = _
  var deck2: Deck = _
  var hand2: Hand = _
  val board: Board = new Board()

  override def beforeEach(context: BeforeEach): Unit = {
    deck1 = new Deck(ArrayBuffer(Card1, Card2, Card3, Card4), deckName, deckCap)
    hand1 = new Hand(3)
    player1 = new Player("Player1", gems, deck1, hand1, board)
    
    deck2 = new Deck(ArrayBuffer(Card1, Card2, Card3, Card5), deckName2, deckCap)
    hand2 = new Hand(3)
    player2 = new Computer("CPU", gems, deck2, hand2, board)
  }


  test("A new empty Unitboard is created with 3 empty lists for melee, range, and siege units") {
    val test = new UnitBoard()
    assert(test.MeleeFormation.isEmpty)
    assert(test.SiegeFormation.isEmpty)
    assert(test.RangedFormation.isEmpty)
  }


  test("A new board is created with 2 empty unit boards of type UnitBoard and a weather slot") {
    val expected = new Board()
    assert(board.equals(expected))
  }

  test("Cards played by a player are put in the player's half") {
    player1.draw()
    // hand should be Card1, Card2, Card3

    player1.play(player1.hand.get(2))
    // Card2 is a MeleeCard
    
    val expected1 = List(Card2)
    val expected2 = List()
    // checking if Card2 is where it should be
    assertEquals(board.playerArmy.MeleeFormation, expected1)
    assertEquals(board.playerArmy.RangedFormation, expected2)
    assertEquals(board.playerArmy.SiegeFormation, expected2)
    assertEquals(board.WeatherSlot, expected2)
    // checking if we are only adding in player half
    assertEquals(board.computerArmy.MeleeFormation, expected2)
  }
  
  test("When computer plays, cards are put in computer's half of board") {
    player2.draw()
    // hand is Card1, Card2, Card3
    player2.play(player1.hand.get(2))
    // Card2 is a MeleeCard

    val expected1 = List(Card2)
    val expected2 = List()

    // checking if Card2 is where it should be
    assertEquals(board.computerArmy.MeleeFormation, expected1)
    assertEquals(board.computerArmy.RangedFormation, expected2)
    assertEquals(board.computerArmy.SiegeFormation, expected2)
    assertEquals(board.WeatherSlot, expected2)
    // checking if we are only adding in computer half
    assertEquals(board.playerArmy.MeleeFormation, expected2)
  }
  
  test("Both players share the same weather slot") {
    player1.draw(4)
    player1.play(player1.hand.get(4))

    val expected1 = List(Card4)
    assert(board.WeatherSlot.equals(expected1))

    player2.draw(4)
    player2.play(player2.hand.get(4))

    val expected2 = List(Card5, Card4)
    assert(board.WeatherSlot.equals(expected2))
  }
  
}
