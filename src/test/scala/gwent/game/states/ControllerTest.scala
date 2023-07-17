package cl.uchile.dcc
package gwent.game.states

import gwent.game.states.exception.InvalidTransitionException
import cl.uchile.dcc.gwent.game.controller.Controller

import cl.uchile.dcc.gwent.game.factory.deck.Test1DeckFactory
import munit.FunSuite
import org.junit.Assert.assertThrows

class ControllerTest extends FunSuite{
  /**
   * Testing transitions only
   */
  var controller: Controller = _

  override def beforeEach(context: BeforeEach): Unit = {
    controller = new Controller(new Test1DeckFactory(0), new Test1DeckFactory(0))
  }

  test("Controller starts in Start state") {
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

  test("Start state can transition to FirstDraw") {
    assert(controller.isStart)
    // invalid transition
    assertThrows(classOf[InvalidTransitionException], () => controller.bothDraw())
    assertThrows(classOf[InvalidTransitionException], () => controller.play(1))
    assertThrows(classOf[InvalidTransitionException], () => controller.pass())
    assertThrows(classOf[InvalidTransitionException], () => controller.hit())
    assertThrows(classOf[InvalidTransitionException], () => controller.initialDraw())
    assertThrows(classOf[InvalidTransitionException], () => controller.reset())
    // valid transition
    controller.startGame()
    assert(!controller.isStart)
    assert(controller.isFirstDraw)
    assert(!controller.isPlayerTurn)
    assert(!controller.isCpuTurn)
    assert(!controller.isPlayerExtendedTurn)
    assert(!controller.isCpuExtendedTurn)
    assert(!controller.isEndPhase)
    assert(!controller.isRoundStart)
    assert(!controller.isGameFinished)
  }

  test("FirstDraw can transition to PlayerTurn") {
    // set controller
    controller.startGame()
    assert(controller.isFirstDraw)
    // invalid transition
    assertThrows(classOf[InvalidTransitionException], () => controller.startGame())
    assertThrows(classOf[InvalidTransitionException], () => controller.play(1))
    assertThrows(classOf[InvalidTransitionException], () => controller.pass())
    assertThrows(classOf[InvalidTransitionException], () => controller.hit())
    assertThrows(classOf[InvalidTransitionException], () => controller.bothDraw())
    assertThrows(classOf[InvalidTransitionException], () => controller.reset())
    // set controller
    controller.initialDraw()
    assert(!controller.isStart)
    assert(!controller.isFirstDraw)
    assert(controller.isPlayerTurn)
    assert(!controller.isCpuTurn)
    assert(!controller.isPlayerExtendedTurn)
    assert(!controller.isCpuExtendedTurn)
    assert(!controller.isEndPhase)
    assert(!controller.isRoundStart)
    assert(!controller.isGameFinished)
  }

  test("PlayerTurn can transition to CPUTurn") {
    // set controller
    controller.startGame()
    controller.initialDraw()
    assert(controller.isPlayerTurn)
    // invalid transition
    assertThrows(classOf[InvalidTransitionException], () => controller.startGame())
    assertThrows(classOf[InvalidTransitionException], () => controller.bothDraw())
    assertThrows(classOf[InvalidTransitionException], () => controller.hit())
    assertThrows(classOf[InvalidTransitionException], () => controller.initialDraw())
    assertThrows(classOf[InvalidTransitionException], () => controller.reset())
    // valid transition
    controller.play(1)
    assert(!controller.isStart)
    assert(!controller.isFirstDraw)
    assert(!controller.isPlayerTurn)
    assert(controller.isCpuTurn)
    assert(!controller.isPlayerExtendedTurn)
    assert(!controller.isCpuExtendedTurn)
    assert(!controller.isEndPhase)
    assert(!controller.isRoundStart)
    assert(!controller.isGameFinished)
  }

  test("PlayerTurn can transition to CpuExtendTurn") {
    // set controller
    controller.startGame()
    controller.initialDraw()
    assert(controller.isPlayerTurn)
    // valid transition
    controller.pass()
    assert(!controller.isStart)
    assert(!controller.isFirstDraw)
    assert(!controller.isPlayerTurn)
    assert(!controller.isCpuTurn)
    assert(!controller.isPlayerExtendedTurn)
    assert(controller.isCpuExtendedTurn)
    assert(!controller.isEndPhase)
    assert(!controller.isRoundStart)
    assert(!controller.isGameFinished)
  }

  test("CpuTurn can transition to PlayerTurn") {
    // set controller
    controller.startGame()
    controller.initialDraw()
    controller.play(1)
    assert(controller.isCpuTurn)
    // invalid transition
    assertThrows(classOf[InvalidTransitionException], () => controller.startGame())
    assertThrows(classOf[InvalidTransitionException], () => controller.bothDraw())
    assertThrows(classOf[InvalidTransitionException], () => controller.hit())
    assertThrows(classOf[InvalidTransitionException], () => controller.initialDraw())
    assertThrows(classOf[InvalidTransitionException], () => controller.reset())
    // valid transition
    controller.play(1)
    assert(!controller.isStart)
    assert(!controller.isFirstDraw)
    assert(controller.isPlayerTurn)
    assert(!controller.isCpuTurn)
    assert(!controller.isPlayerExtendedTurn)
    assert(!controller.isCpuExtendedTurn)
    assert(!controller.isEndPhase)
    assert(!controller.isRoundStart)
    assert(!controller.isGameFinished)
  }

  test("CpuTurn can transition to PlayerExtendedTurn") {
    // set controller
    controller.startGame()
    controller.initialDraw()
    controller.play(1)
    assert(controller.isCpuTurn)
    // valid transition
    controller.pass()
    assert(!controller.isStart)
    assert(!controller.isFirstDraw)
    assert(!controller.isPlayerTurn)
    assert(!controller.isCpuTurn)
    assert(controller.isPlayerExtendedTurn)
    assert(!controller.isCpuExtendedTurn)
    assert(!controller.isEndPhase)
    assert(!controller.isRoundStart)
    assert(!controller.isGameFinished)
  }

  test("CpuExtendedTurn can transition to itself") {
    // set controller
    controller.startGame()
    controller.initialDraw()
    controller.pass()
    assert(controller.isCpuExtendedTurn)
    // invalid transition
    assertThrows(classOf[InvalidTransitionException], () => controller.startGame())
    assertThrows(classOf[InvalidTransitionException], () => controller.bothDraw())
    assertThrows(classOf[InvalidTransitionException], () => controller.hit())
    assertThrows(classOf[InvalidTransitionException], () => controller.initialDraw())
    assertThrows(classOf[InvalidTransitionException], () => controller.reset())
    // valid transition
    controller.play(1)
    assert(!controller.isStart)
    assert(!controller.isFirstDraw)
    assert(!controller.isPlayerTurn)
    assert(!controller.isCpuTurn)
    assert(!controller.isPlayerExtendedTurn)
    assert(controller.isCpuExtendedTurn)
    assert(!controller.isEndPhase)
    assert(!controller.isRoundStart)
    assert(!controller.isGameFinished)
  }

  test("Cpu extended turn can transition to EndPhase") {
    // set controller
    controller.startGame()
    controller.initialDraw()
    controller.pass()
    assert(controller.isCpuExtendedTurn)
    // valid transition
    controller.pass()
    assert(!controller.isStart)
    assert(!controller.isFirstDraw)
    assert(!controller.isPlayerTurn)
    assert(!controller.isCpuTurn)
    assert(!controller.isPlayerExtendedTurn)
    assert(!controller.isCpuExtendedTurn)
    assert(controller.isEndPhase)
    assert(!controller.isRoundStart)
    assert(!controller.isGameFinished)
  }

  test("PlayerExtendedTurn can transition to itself") {
    // set controller
    controller.startGame()
    controller.initialDraw()
    controller.play(1)
    controller.pass()
    assert(controller.isPlayerExtendedTurn)
    // invalid transition
    assertThrows(classOf[InvalidTransitionException], () => controller.startGame())
    assertThrows(classOf[InvalidTransitionException], () => controller.bothDraw())
    assertThrows(classOf[InvalidTransitionException], () => controller.hit())
    assertThrows(classOf[InvalidTransitionException], () => controller.initialDraw())
    assertThrows(classOf[InvalidTransitionException], () => controller.reset())
    // valid transition
    controller.play(1)
    assert(!controller.isStart)
    assert(!controller.isFirstDraw)
    assert(!controller.isPlayerTurn)
    assert(!controller.isCpuTurn)
    assert(controller.isPlayerExtendedTurn)
    assert(!controller.isCpuExtendedTurn)
    assert(!controller.isEndPhase)
    assert(!controller.isRoundStart)
    assert(!controller.isGameFinished)
  }

  test("PlayerExtendedTurn can transition to EndPhase") {
    // set controller
    controller.startGame()
    controller.initialDraw()
    controller.play(1)
    controller.pass()
    assert(controller.isPlayerExtendedTurn)
    // valid transition
    controller.pass()
    assert(!controller.isStart)
    assert(!controller.isFirstDraw)
    assert(!controller.isPlayerTurn)
    assert(!controller.isCpuTurn)
    assert(!controller.isPlayerExtendedTurn)
    assert(!controller.isCpuExtendedTurn)
    assert(controller.isEndPhase)
    assert(!controller.isRoundStart)
    assert(!controller.isGameFinished)
  }

  test("EndPhase can return to RoundStart") {
    // set controller
    controller.startGame()
    controller.initialDraw()
    controller.pass()
    controller.pass()
    assert(controller.isEndPhase)
    // invalid transition
    assertThrows(classOf[InvalidTransitionException], () => controller.startGame())
    assertThrows(classOf[InvalidTransitionException], () => controller.play(1))
    assertThrows(classOf[InvalidTransitionException], () => controller.pass())
    assertThrows(classOf[InvalidTransitionException], () => controller.bothDraw())
    assertThrows(classOf[InvalidTransitionException], () => controller.initialDraw())
    assertThrows(classOf[InvalidTransitionException], () => controller.reset())
    // valid transition
    controller.hit()
    assert(!controller.isStart)
    assert(!controller.isFirstDraw)
    assert(!controller.isPlayerTurn)
    assert(!controller.isCpuTurn)
    assert(!controller.isPlayerExtendedTurn)
    assert(!controller.isCpuExtendedTurn)
    assert(!controller.isEndPhase)
    assert(controller.isRoundStart)
    assert(!controller.isGameFinished)
  }

  test("RoundStart can transition to PlayerTurn") {
    // set controller
    controller.startGame()
    controller.initialDraw()
    controller.pass()
    controller.pass()
    controller.hit()
    assert(controller.isRoundStart)
    // invalid transition
    assertThrows(classOf[InvalidTransitionException], () => controller.startGame())
    assertThrows(classOf[InvalidTransitionException], () => controller.play(1))
    assertThrows(classOf[InvalidTransitionException], () => controller.pass())
    assertThrows(classOf[InvalidTransitionException], () => controller.hit())
    assertThrows(classOf[InvalidTransitionException], () => controller.initialDraw())
    assertThrows(classOf[InvalidTransitionException], () => controller.reset())
    // valid transition
    controller.bothDraw()
    assert(!controller.isStart)
    assert(!controller.isFirstDraw)
    assert(controller.isPlayerTurn)
    assert(!controller.isCpuTurn)
    assert(!controller.isPlayerExtendedTurn)
    assert(!controller.isCpuExtendedTurn)
    assert(!controller.isEndPhase)
    assert(!controller.isRoundStart)
    assert(!controller.isGameFinished)
  }
}
