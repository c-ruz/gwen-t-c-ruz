package cl.uchile.dcc
package gwent.game.effects

import gwent.game.board.Board
import gwent.game.card.WeatherCard
import gwent.game.card.handler.{Deck, Hand}
import gwent.game.card.units.{MeleeCard, RangedCard, SiegeCard}
import gwent.game.players.{Computer, Player}

import cl.uchile.dcc.gwent.game.effects.unitCardEffects.{MoraleSupport, NullEffect}
import munit.FunSuite

import scala.collection.mutable.ArrayBuffer

class EffectTest extends FunSuite {

  val Card1 = new MeleeCard("Eta, el Errabundo", 5, new MoraleSupport)
  val Card2 = new MeleeCard("Zeeh, la primera luz", 3, new NullEffect)
  val Card3 = new SiegeCard("Diral, dimensión espiral", 5, new NullEffect)
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

  test("Effects have a name and description") {
    val effect = new MoraleSupport
    assertEquals(effect.name, "Morale Support")
    assertEquals(effect.description,
      "Adds +1 to all units in the row (excluding itself).")
  }

  test("Morale support activation test") {
    player1.draw()
    player1.play(2)
    player1.play(1)

    assertEquals(board.playerArmy.MeleeFormation(0).currStr, 5)
    assertEquals(board.playerArmy.MeleeFormation(1).currStr, 4)
  }

  test("Morale support when alone test") {
    /**
     * Morale Support is not retroactive, so if no cards are presents when the card is played,
     * the cards played after it do not receive the effect. TL;DR: Effects activate when cards
     * are played.
     */
    player1.draw()
    player1.play(1)
    player1.play(1)

    assertEquals(board.playerArmy.MeleeFormation(0).currStr, 3)
    assertEquals(board.playerArmy.MeleeFormation(1).currStr, 5)
  }
}
