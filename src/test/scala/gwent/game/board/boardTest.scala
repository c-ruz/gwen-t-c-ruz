package cl.uchile.dcc
package gwent.game.board

import gwent.game.card.{MeleeCard, RangedCard, SiegeCard, WeatherCard}
import gwent.game.card.handler.{Deck, Hand}
import gwent.game.players.{Computer, Player}
import munit.FunSuite

import scala.collection.mutable.ArrayBuffer

/**
 * This test Class tests Board and UnitBoard functionality, as both classes are part of the general
 * board of the game.
 */
class boardTest extends FunSuite {

  val Card1 = new MeleeCard("Eta, el Errabundo", 5)
  val Card2 = new RangedCard("Zeeh, la primera luz", 3)
  val Card3 = new SiegeCard("Diral, dimensión espiral", 5)
  val Card4 = new WeatherCard("Escarcha mordiente")
  val Card5 = new WeatherCard("Clima despejado")
  val deckName = "Xan-kei deck 1"
  val deckName2 = "Xan-kei deck 2"
  val gems = 3
  var deckCap = 5
  var handCap = 4
  var player1: Player = _
  var deck1: Deck = _
  var hand1: Hand = _
  var player2: Computer = _
  var deck2: Deck = _
  var hand2: Hand = _
  var board: Board = _

  override def beforeEach(context: BeforeEach): Unit = {
    board = new Board

    deck1 = new Deck(ArrayBuffer(Card1, Card2, Card3, Card4), deckName, deckCap)
    hand1 = new Hand(handCap)
    player1 = new Player("Player1", gems, deck1, hand1, board)

    deck2 = new Deck(ArrayBuffer(Card1, Card2, Card3, Card5), deckName2, deckCap)
    hand2 = new Hand(handCap)
    player2 = new Computer("CPU", gems, deck2, hand2, board)
  }


  test("A new empty UnitBoard is created with 3 empty lists for melee, range, and siege units") {
    val test = new UnitBoard()
    assert(test.MeleeFormation.isEmpty)
    assert(test.SiegeFormation.isEmpty)
    assert(test.RangedFormation.isEmpty)
  }

  test("UnitBoard structural equality test"){
    val test = new UnitBoard
    val expected = new UnitBoard

    // Testing two empty unit boards
    assertEquals(test, expected)
    // Testing UnitBoard with Board
    assert(!test.equals(board))
  }


  test("A new board is created with 2 empty unit boards of type UnitBoard and a weather slot") {
    val expected = new Board()
    val expected2 = new UnitBoard
    assert(board.equals(expected))
    assert(!board.equals(expected2))
    assert(board.WeatherSlot.isEmpty)
  }

  test("Cards played by a player are put in the player's half") {
    player1.draw()
    // hand should be Card1, Card2, Card3
    player1.play(1)
    // Card1 is a MeleeCard
    player1.play(1)
    // Card2 is a RangedCard
    player1.play(1)
    // Card3 is a SiegeCard

    val expected1 = List(Card1)
    val expected2 = List(Card2)
    val expected3 = List(Card3)
    val expected4 = List()

    // checking if Card1, Card2 and Card3 are where they should be
    assertEquals(board.playerArmy.MeleeFormation, expected1)
    assertEquals(board.playerArmy.RangedFormation, expected2)
    assertEquals(board.playerArmy.SiegeFormation, expected3)
    assert(board.WeatherSlot.isEmpty)
    // checking if we are only adding in player half
    assertEquals(board.computerArmy.MeleeFormation, expected4)
    assertEquals(board.computerArmy.RangedFormation, expected4)
    assertEquals(board.computerArmy.SiegeFormation, expected4)
  }

  test("When computer plays, cards are put in computer's half of board") {
    player2.draw()
    // hand is Card1, Card2, Card3
    player2.play(1)
    // Card1 is a MeleeCard
    player2.play(1)
    // Card2 is a RangedCard
    player2.play(1)
    // Card3 is a SiegeCard

    val expected1 = List(Card1)
    val expected2 = List(Card2)
    val expected3 = List(Card3)
    val expected4 = List()

    // checking if Card2 is where it should be
    assertEquals(board.computerArmy.MeleeFormation, expected1)
    assertEquals(board.computerArmy.RangedFormation, expected2)
    assertEquals(board.computerArmy.SiegeFormation, expected3)
    assert(board.WeatherSlot.isEmpty)
    // checking if we are only adding in computer half
    assertEquals(board.playerArmy.MeleeFormation, expected4)
    assertEquals(board.playerArmy.RangedFormation, expected4)
    assertEquals(board.playerArmy.SiegeFormation, expected4)
  }

  test("Both players share the same weather slot") {
    player1.draw(4)
    player1.play(4)

    val expected1 = Card4
    assertEquals(board.WeatherSlot.get, expected1)

    player2.draw(4)
    player2.play(4)

    val expected2 = Card5
    assertEquals(board.WeatherSlot.get, expected2)
  }

  test("Testing structural equality of UnitBoard with already placed cards") {
    // Setting up the board
    player1.draw()
    player1.play(1)

    // Compare with an empty UnitBoard
    val compare = new UnitBoard
    assert(!board.playerArmy.equals(compare))
  }

  test("Played cards are removed from the hand of who played them") {
    player1.draw()
    // hand is Card1, Card2, Card3
    player1.play(1)

    val expected = new Hand(ArrayBuffer(Card2, Card3), handCap)
    assertEquals(player1.hand, expected)

    player2.draw()
    // hand is Card1, Card2, Card3
    player2.play(2)

    val expected2 = new Hand(ArrayBuffer(Card1, Card3), handCap)
    assertEquals(player2.hand, expected2)
  }

  test("Can't play card with index out of bounds") {
    player1.draw()
    // hand is 1.Card1, 2.Card2, 3.Card3
    // play index out of bounds
    player1.play(4)

    val expected = new Board()
    assertEquals(board, expected)

    player2.draw()
    // hand is 1.Card1, 2.Card2, 3.Card3
    player2.play(4)

    assertEquals(board, expected)
  }

  test("Can't play if index is less than zero or zero") {
    player1.draw()
    player1.play(-1)

    val expected = new Board
    assertEquals(board, expected)

    player1.play(0)

    assertEquals(board, expected)

    player2.draw()
    player2.play(-1)

    assertEquals(board, expected)

    player2.play(0)

    assertEquals(board, expected)
  }
}
