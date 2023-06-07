package cl.uchile.dcc
package gwent.game

import gwent.game.states._

class Controller {
  var state: State = _
  
  def setState(aState: State) = {
    state = aState
    state.setController(this)
  }
  
  def startGame(): Unit = {
    state = new StartState()
    state.setController(this)
  }

  def bothDraw(): Unit = state.bothDraw()
  def play(): Unit = state.play()
  def pass(): Unit = state.pass()
  def hit(): Unit = state.hit()
  def initializeGame(): Unit = state.initializeGame()
  def initialDraw(): Unit = state.initialDraw()

  def isStart: Boolean = state.isStart
  def isFirstDraw: Boolean = state.isFirstDraw
  def isPlayerTurn: Boolean = state.isPlayerTurn
  def isCpuTurn: Boolean = state.isCpuTurn
  def isPlayerExtendedTurn: Boolean = state.isPlayerExtendedTurn
  def isCpuExtendedTurn: Boolean = state.isCpuExtendedTurn
  def isEndPhase: Boolean = state.isEndPhase
  def isRoundStart: Boolean = state.isRoundStart
}
