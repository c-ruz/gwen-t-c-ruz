package cl.uchile.dcc
package gwent.game

import gwent.game.states._

class Controller {
  var state: State = _
  
  def setState(aState: State) = {
    state = aState
  }
  
  def startGame(): Unit = {
    state = new StartState()
  }

  def bothDraw(): Unit = state.bothDraw(this)
  def play(): Unit = state.play(this)
  def pass(): Unit = state.pass(this)
  def hit(): Unit = state.hit(this)
  def initializeGame(): Unit = state.initializeGame(this)
  def initialDraw(): Unit = state.initialDraw(this)

  def isStart: Boolean = state.isStart
  def isFirstDraw: Boolean = state.isFirstDraw
  def isPlayerTurn: Boolean = state.isPlayerTurn
  def isCpuTurn: Boolean = state.isCpuTurn
  def isPlayerExtendedTurn: Boolean = state.isPlayerExtendedTurn
  def isCpuExtendedTurn: Boolean = state.isCpuExtendedTurn
  def isEndPhase: Boolean = state.isEndPhase
  def isRoundStart: Boolean = state.isRoundStart
}
