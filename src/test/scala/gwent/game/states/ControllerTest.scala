package cl.uchile.dcc
package gwent.game.states

import cl.uchile.dcc.gwent.game.Controller
import munit.FunSuite
import org.junit.Assert.assertThrows

class ControllerTest extends FunSuite{
  /**
   * Testing transitions only
   */
  var controller: Controller = _

  override def beforeEach(context: BeforeEach): Unit = {
    controller = new Controller()
    // start gaming
    controller.startGame()
  }

  test("Game starts in Start state") {
    assert(controller.isStart)
    assert(!controller.isFirstDraw)
    assert(!controller.isPlayerTurn)
    assert(!controller.isCpuTurn)
    assert(!controller.isPlayerExtendedTurn)
    assert(!controller.isCpuExtendedTurn)
    assert(!controller.isEndPhase)
    assert(!controller.isRoundStart)
  }

  test("Start state can transition to FirstDraw") {
    // invalid transition
    assertThrows(classOf[Exception], () => controller.bothDraw())
    assertThrows(classOf[Exception], () => controller.play())
    assertThrows(classOf[Exception], () => controller.pass())
    assertThrows(classOf[Exception], () => controller.hit())
    assertThrows(classOf[Exception], () => controller.initialDraw())
    // valid transition
    controller.initializeGame()
    assert(!controller.isStart)
    assert(controller.isFirstDraw)
    assert(!controller.isPlayerTurn)
    assert(!controller.isCpuTurn)
    assert(!controller.isPlayerExtendedTurn)
    assert(!controller.isCpuExtendedTurn)
    assert(!controller.isEndPhase)
    assert(!controller.isRoundStart)
  }

  test("FirstDraw can transition to PlayerTurn") {
    // set controller
    controller.initializeGame()
    // invalid transition
    assertThrows(classOf[Exception], () => controller.initializeGame())
    assertThrows(classOf[Exception], () => controller.play())
    assertThrows(classOf[Exception], () => controller.pass())
    assertThrows(classOf[Exception], () => controller.hit())
    assertThrows(classOf[Exception], () => controller.bothDraw())
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
  }

  test("PlayerTurn can transition to CPUTurn") {
    // set controller
    controller.initializeGame()
    controller.initialDraw()
    // invalid transition
    assertThrows(classOf[Exception], () => controller.initializeGame())
    assertThrows(classOf[Exception], () => controller.bothDraw())
    assertThrows(classOf[Exception], () => controller.hit())
    assertThrows(classOf[Exception], () => controller.initialDraw())
    // valid transition
    controller.play()
    assert(!controller.isStart)
    assert(!controller.isFirstDraw)
    assert(!controller.isPlayerTurn)
    assert(controller.isCpuTurn)
    assert(!controller.isPlayerExtendedTurn)
    assert(!controller.isCpuExtendedTurn)
    assert(!controller.isEndPhase)
    assert(!controller.isRoundStart)
  }

  test("PlayerTurn can transition to CpuExtendTurn") {
    // set controller
    controller.initializeGame()
    controller.initialDraw()
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
  }

  test("CpuTurn can transition to PlayerTurn") {
    // set controller
    controller.initializeGame()
    controller.initialDraw()
    controller.play()
    // invalid transition
    assertThrows(classOf[Exception], () => controller.initializeGame())
    assertThrows(classOf[Exception], () => controller.bothDraw())
    assertThrows(classOf[Exception], () => controller.hit())
    assertThrows(classOf[Exception], () => controller.initialDraw())
    // valid transition
    controller.play()
    assert(!controller.isStart)
    assert(!controller.isFirstDraw)
    assert(controller.isPlayerTurn)
    assert(!controller.isCpuTurn)
    assert(!controller.isPlayerExtendedTurn)
    assert(!controller.isCpuExtendedTurn)
    assert(!controller.isEndPhase)
    assert(!controller.isRoundStart)
  }

  test("CpuTurn can transition to PlayerExtendedTurn") {
    // set controller
    controller.initializeGame()
    controller.initialDraw()
    controller.play()
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
  }

  test("CpuExtendedTurn can transition to itself") {
    // set controller
    controller.initializeGame()
    controller.initialDraw()
    controller.pass()
    // invalid transition
    assertThrows(classOf[Exception], () => controller.initializeGame())
    assertThrows(classOf[Exception], () => controller.bothDraw())
    assertThrows(classOf[Exception], () => controller.hit())
    assertThrows(classOf[Exception], () => controller.initialDraw())
    // valid transition
    controller.play()
    assert(!controller.isStart)
    assert(!controller.isFirstDraw)
    assert(!controller.isPlayerTurn)
    assert(!controller.isCpuTurn)
    assert(!controller.isPlayerExtendedTurn)
    assert(controller.isCpuExtendedTurn)
    assert(!controller.isEndPhase)
    assert(!controller.isRoundStart)
  }

  test("Cpu extended turn can transition to EndPhase") {
    // set controller
    controller.initializeGame()
    controller.initialDraw()
    controller.pass()
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
  }

  test("PlayerExtendedTurn can transition to itself") {
    // set controller
    controller.initializeGame()
    controller.initialDraw()
    controller.play()
    controller.pass()
    // invalid transition
    assertThrows(classOf[Exception], () => controller.initializeGame())
    assertThrows(classOf[Exception], () => controller.bothDraw())
    assertThrows(classOf[Exception], () => controller.hit())
    assertThrows(classOf[Exception], () => controller.initialDraw())
    // valid transition
    controller.play()
    assert(!controller.isStart)
    assert(!controller.isFirstDraw)
    assert(!controller.isPlayerTurn)
    assert(!controller.isCpuTurn)
    assert(controller.isPlayerExtendedTurn)
    assert(!controller.isCpuExtendedTurn)
    assert(!controller.isEndPhase)
    assert(!controller.isRoundStart)
  }

  test("PlayerExtendedTurn can transition to EndPhase") {
    // set controller
    controller.initializeGame()
    controller.initialDraw()
    controller.play()
    controller.pass()
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
  }

  test("EndPhase can return to RoundStart") {
    // set controller
    controller.initializeGame()
    controller.initialDraw()
    controller.pass()
    controller.pass()
    // invalid transition
    assertThrows(classOf[Exception], () => controller.initializeGame())
    assertThrows(classOf[Exception], () => controller.play())
    assertThrows(classOf[Exception], () => controller.pass())
    assertThrows(classOf[Exception], () => controller.bothDraw())
    assertThrows(classOf[Exception], () => controller.initialDraw())
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
  }

  test("RoundStart can transition to PlayerTurn") {
    // set controller
    controller.initializeGame()
    controller.initialDraw()
    controller.pass()
    controller.pass()
    controller.hit()
    // invalid transition
    assertThrows(classOf[Exception], () => controller.initializeGame())
    assertThrows(classOf[Exception], () => controller.play())
    assertThrows(classOf[Exception], () => controller.pass())
    assertThrows(classOf[Exception], () => controller.hit())
    assertThrows(classOf[Exception], () => controller.initialDraw())
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
  }
}
