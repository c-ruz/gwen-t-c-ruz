package cl.uchile.dcc
package gwent.game.effects

import gwent.game.board.Board
import gwent.game.card.WeatherCard
import gwent.game.card.handler.{Deck, Hand}
import gwent.game.card.units.{MeleeCard, RangedCard, SiegeCard}
import gwent.game.players.{Computer, Player}

import cl.uchile.dcc.gwent.game.effects.unitCardEffects.{MoraleSupport, NullEffect, TightBond}
import cl.uchile.dcc.gwent.game.effects.weatherCardEffects.{BitingFrost, ClearWeather, ImpenetrableFog, TorrentialRain}
import munit.FunSuite

import scala.collection.mutable.ArrayBuffer

class EffectTest extends FunSuite {
  val name1 = "Eta, el errabundo"
  val name2 = "Zeeh, la primera luz"
  val name3 = "Diran, la dimensión espiral"
  val name4 = "Bombardero Wyvern"
  val name5 = "Alunrus, la flecha negra"
  val name6 = "Escarcha Mordiente"
  val name7 = "Niebla Impenetrable"
  val name8 = "Lluvia torrencial"
  val name9 = "Clima despejado"
  val str = 10
  val deckName = "Xan-kei deck 1"
  val deckName2 = "Xan-kei deck 2"
  val gems = 3
  var deckCap = 25
  var handCap = 10
  var player1: Player = _
  var deck1: Deck = _
  var hand1: Hand = _
  var player2: Computer = _
  var deck2: Deck = _
  var hand2: Hand = _
  var board: Board = _

  override def beforeEach(context: BeforeEach): Unit = {
    board = new Board

    deck1 = new Deck(ArrayBuffer(
      new MeleeCard(name1, str, new MoraleSupport),
      new MeleeCard(name2, str, new NullEffect),
      new SiegeCard(name3, str, new NullEffect),
      new SiegeCard(name4, str, new NullEffect),
      new RangedCard(name5, str, new TightBond),
      new RangedCard(name5, str, new NullEffect),
      new WeatherCard(name6, new BitingFrost),
      new WeatherCard(name7, new ImpenetrableFog),
      new WeatherCard(name8, new TorrentialRain),
      new WeatherCard(name9, new ClearWeather)
    ), deckName, deckCap)
    hand1 = new Hand(handCap)
    player1 = new Player("Player1", gems, deck1, hand1, board)

    deck2 = new Deck(ArrayBuffer(
      new MeleeCard(name1, str, new MoraleSupport),
      new MeleeCard(name2, str, new NullEffect),
      new SiegeCard(name3, str, new NullEffect),
      new SiegeCard(name4, str, new NullEffect),
      new RangedCard(name5, str, new TightBond),
      new RangedCard(name5, str, new NullEffect),
      new WeatherCard(name6, new BitingFrost),
      new WeatherCard(name7, new ImpenetrableFog),
      new WeatherCard(name8, new TorrentialRain),
      new WeatherCard(name9, new ClearWeather)
    ), deckName2, deckCap)
    hand2 = new Hand(handCap)
    player2 = new Computer("Player2", gems, deck2, hand2, board)
  }

  test("Effects have a name and description") {
    val effect1 = new MoraleSupport
    assertEquals(effect1.name, "Morale Support")
    assertEquals(effect1.description,
      "Adds +1 to all units in the row (excluding itself).")
    assertEquals(effect1, new MoraleSupport)
    assert(!effect1.equals(new NullEffect))

    val effect2 = new TightBond
    assertEquals(effect2.name, "Tight Bond")
    assertEquals(effect2.description,
    "Placing this unit in a row with cards with the same name, will " +
      "double both the strength of those cards and itself.")
    assertEquals(effect2, new TightBond)
    assert(!effect2.equals(new NullEffect))

    val effect3 = new NullEffect
    assertEquals(effect3.name, "No effect")
    assertEquals(effect3.description,
      "This card has no effect.")
    assertEquals(effect3, new NullEffect)
    assert(!effect3.equals(new BitingFrost))

    val effect4 = new BitingFrost
    assertEquals(effect4.name, "Weather: Biting Frost")
    assertEquals(effect4.description,
    "Sets the strength of all melee cards to 1 for both players.")
    assertEquals(effect4, new BitingFrost)
    assert(!effect4.equals(new NullEffect))

    val effect5 = new ClearWeather
    assertEquals(effect5.name, "Weather: Clear Weather")
    assertEquals(effect5.description,
    "Removes any current weather effects across the entire battlefield.")
    assertEquals(effect5, new ClearWeather)
    assert(!effect5.equals(new NullEffect))

    val effect6 = new ImpenetrableFog
    assertEquals(effect6.name, "Weather: Impenetrable Fog")
    assertEquals(effect6.description,
    "Sets the strength of all ranged cards to 1 for both players.")
    assertEquals(effect6, new ImpenetrableFog)
    assert(!effect6.equals(new NullEffect))

    val effect7 = new TorrentialRain
    assertEquals(effect7.name, "Weather: Torrential Rain")
    assertEquals(effect7.description,
    "Sets the strength of all siege cards to 1 for both players.")
    assertEquals(effect7, new TorrentialRain)
    assert(!effect7.equals(new NullEffect))
  }

  test("Morale Support and Biting Frost test") {
    player1.draw(10)
    player2.draw(10)
    // playing some melee card
    player1.play(2)
    // playing some siege card
    player1.play(2)
    // playing some melee card in computer side
    player2.play(2)
    // playing morale support card on player side
    player1.play(1)

    // Checks if Morale Support excludes itself
    assertEquals(board.playerArmy.MeleeFormation(0).currStr, str)
    // Checks Morale Support effect
    assertEquals(board.playerArmy.MeleeFormation(1).currStr, str+1)
    // Checks if is only applying on player row
    assertEquals(board.computerArmy.MeleeFormation(0).currStr, str)
    // Checks if is only applying on melee row
    assertEquals(board.playerArmy.SiegeFormation(0).currStr, str)

    // playing biting frost weather
    player1.play(4)

    // Checking effect
    assertEquals(board.playerArmy.MeleeFormation(0).currStr, 1)
    assertEquals(board.playerArmy.MeleeFormation(1).currStr, 1)
    assertEquals(board.computerArmy.MeleeFormation(0).currStr, 1)
    // Checking if only applying in melee row
    assertEquals(board.playerArmy.SiegeFormation(0).currStr, str)
  }

  test("Extra: Morale support when alone test") {
    /**
     * Morale Support is not retroactive, so if no cards are presents when the card is played,
     * the cards played after it do not receive the effect. TL;DR: Effects activate when cards
     * are played.
     */
    player1.draw()
    player1.play(1)
    player1.play(1)

    assertEquals(board.playerArmy.MeleeFormation(0).currStr, str)
    assertEquals(board.playerArmy.MeleeFormation(1).currStr, str)
  }

  test("Tight bond test and impenetrable fog test") {
    player1.draw(10)
    player2.draw(10)
    // playing some ranged card
    player1.play(6)
    // playing some ranged card on computer side
    player2.play(6)
    // playing tight bond card
    player1.play(5)
    // playing some melee card
    player1.play(2)

    // checking tight bond effect
    assertEquals(board.playerArmy.RangedFormation(0).currStr, str*2)
    assertEquals(board.playerArmy.RangedFormation(1).currStr, str*2)
    // checking if is only applying in player side
    assertEquals(board.computerArmy.RangedFormation(0).currStr, str)

    player1.play(5)

    // checking impenetrable fog effect
    assertEquals(board.playerArmy.RangedFormation(0).currStr, 1)
    assertEquals(board.playerArmy.RangedFormation(1).currStr, 1)
    assertEquals(board.computerArmy.RangedFormation(0).currStr, 1)
    // checking if is only applying in ranged row
    assertEquals(board.playerArmy.MeleeFormation(0).currStr, str)
  }

  test("Torrential Rain and Clear Weather test"){
    player1.draw(10)
    player2.draw(10)
    // playing two siege cards
    player1.play(3)
    player1.play(3)
    // playing two siege cards in computer side
    player2.play(3)
    player2.play(3)
    // playing torrential rain weather
    player1.play(7)
    player1.play(1)

    // checking torrential rain effect
    assertEquals(board.playerArmy.SiegeFormation(0).currStr, 1)
    assertEquals(board.playerArmy.SiegeFormation(1).currStr, 1)
    assertEquals(board.computerArmy.SiegeFormation(0).currStr, 1)
    assertEquals(board.computerArmy.SiegeFormation(1).currStr, 1)
    // checking if is only applying in siege row
    assertEquals(board.playerArmy.MeleeFormation(0).currStr, str)

    // playing clear weather
    player1.play(6)

    // checking clear weather effect
    assertEquals(board.playerArmy.SiegeFormation(0).currStr, str)
    assertEquals(board.playerArmy.SiegeFormation(1).currStr, str)
    assertEquals(board.computerArmy.SiegeFormation(0).currStr, str)
    assertEquals(board.computerArmy.SiegeFormation(1).currStr, str)
  }
}
