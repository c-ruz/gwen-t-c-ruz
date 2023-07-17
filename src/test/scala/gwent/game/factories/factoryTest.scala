package cl.uchile.dcc
package gwent.game.factories

import gwent.game.Controller
import gwent.game.factory.deck.{DeckFactory, FlyingGangDeckFactory, Test1DeckFactory, XanKeiDeckFactory}

import cl.uchile.dcc.gwent.game.board.Board
import cl.uchile.dcc.gwent.game.factory.players.{HumanFactory, PlayerFactory}
import munit.FunSuite

class factoryTest extends FunSuite {
  var xankeiDeckFactory: DeckFactory = _
  var flyingGangDeckFactory: DeckFactory = _
  var playerFactory: PlayerFactory = _
  var board: Board = _

  override def beforeEach(context: BeforeEach): Unit = {
    xankeiDeckFactory = new XanKeiDeckFactory
    flyingGangDeckFactory = new FlyingGangDeckFactory
    playerFactory = new HumanFactory
    board = new Board
  }

  test("Testing if creation of deck is consistent") {
    var deck1 = xankeiDeckFactory.create()
    var deck2 = xankeiDeckFactory.create()

    assertEquals(deck1, deck2)

    deck1 = flyingGangDeckFactory.create()
    deck2 = flyingGangDeckFactory.create()

    assertEquals(deck1, deck2)
  }

  test("Testing setters of deck factory") {
    // either factory works
    val name = "Name Set Test"
    xankeiDeckFactory.setName(name)
    xankeiDeckFactory.setCapacity(20)

    val deck1 = xankeiDeckFactory.create()

    assertEquals(deck1.name, name)
    assertEquals(deck1.capacity, 20)
    assertEquals(deck1.holding, 20)
  }

  test("Testing setters of player factory") {
    val name = "Player Name Test"
    playerFactory.setName(name)
    playerFactory.setGems(2)
    playerFactory.setHandCap(8)
    playerFactory.setDeckFactory(xankeiDeckFactory)

    val test = playerFactory.create(board)

    assertEquals(test.name, name)
    assertEquals(test.gems, 2)
    assertEquals(test.hand.handCapacity, 8)
    assertEquals(test.deck, xankeiDeckFactory.create())
  }
}
