package cl.uchile.dcc
package gwent.game.observer

import gwent.game.factory.deck.Test1DeckFactory
import cl.uchile.dcc.gwent.game.controller.Controller

import cl.uchile.dcc.gwent.game.states.exception.InvalidTransitionException
import munit.FunSuite
import org.junit.Assert.assertThrows

class ObserverTest extends FunSuite{
  var controller: Controller = _
  var controller2: Controller = _
  var controller3: Controller = _

  override def beforeEach(context: BeforeEach): Unit = {
    controller = new Controller(new Test1DeckFactory(), new Test1DeckFactory())

    controller2 = new Controller(new Test1DeckFactory(1), new Test1DeckFactory())

    controller3 = new Controller(new Test1DeckFactory(), new Test1DeckFactory(1))
  }

  test("Game ending in a Draw") {
    controller.startGame()
    controller.initialDraw()
    controller.pass()
    controller.pass()
    controller.hit()
    controller.bothDraw()
    controller.pass()
    controller.pass()
    controller.hit()
    controller.bothDraw()
    controller.pass()
    controller.pass()
    controller.hit()

    assert(controller.isGameFinished)
    assert(controller.getEndMessage == "It's a Draw")
  }

  test("Player 1 winning the game") {
    controller2.startGame()
    controller2.initialDraw()
    controller2.play(1)
    controller2.pass()
    controller2.pass()
    controller2.hit()
    controller2.bothDraw()
    controller2.play(1)
    controller2.pass()
    controller2.pass()
    controller2.hit()
    controller2.bothDraw()
    controller2.play(1)
    controller2.pass()
    controller2.pass()
    controller2.hit()

    assert(controller2.isGameFinished)
    assert(controller2.getEndMessage == "The winner is Player 1")
  }

  test("Player 2 winning the game") {
    controller3.startGame()
    controller3.initialDraw()
    controller3.pass()
    controller3.play(1)
    controller3.pass()
    controller3.hit()
    controller3.bothDraw()
    controller3.pass()
    controller3.play(1)
    controller3.pass()
    controller3.hit()
    controller3.bothDraw()
    controller3.pass()
    controller3.play(1)
    controller3.pass()
    controller3.hit()

    assert(controller3.isGameFinished)
    assert(controller3.getEndMessage == "The winner is Player 2")
  }

  test("GameFinished can transition to Start"){
    // Set state
    controller.startGame()
    controller.initialDraw()
    controller.pass()
    controller.pass()
    controller.hit()
    controller.bothDraw()
    controller.pass()
    controller.pass()
    controller.hit()
    controller.bothDraw()
    controller.pass()
    controller.pass()
    controller.hit()
    // invalid transition
    assertThrows(classOf[InvalidTransitionException], () => controller.startGame())
    assertThrows(classOf[InvalidTransitionException], () => controller.play(1))
    assertThrows(classOf[InvalidTransitionException], () => controller.pass())
    assertThrows(classOf[InvalidTransitionException], () => controller.hit())
    assertThrows(classOf[InvalidTransitionException], () => controller.initialDraw())
    assertThrows(classOf[InvalidTransitionException], () => controller.bothDraw())
    // valid transition
    controller.reset()
    assert(controller.isStart)
    assert(!controller.isFirstDraw)
    assert(!controller.isPlayerTurn)
    assert(!controller.isCpuTurn)
    assert(!controller.isPlayerExtendedTurn)
    assert(!controller.isCpuExtendedTurn)
    assert(!controller.isEndPhase)
    assert(!controller.isRoundStart)
    assert(!controller.isGameFinished)
  }
}
