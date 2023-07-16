package cl.uchile.dcc
package gwent.game.states

import cl.uchile.dcc.gwent.game.Controller
import cl.uchile.dcc.gwent.game.states.exception.InvalidTransitionException

class State {
  protected def changeState(c: Controller, state: State): Unit = {
    c.setState(state)
  }

  def error(method: String) = {
    throw new InvalidTransitionException(s"Can't transition with $method in ${getClass.getSimpleName}")
  }
  def bothDraw(c: Controller): Unit = error("bothDraw")
  def play(c: Controller, index: Int): Unit = error("play")
  def pass(c: Controller): Unit = error("pass")
  def hit(c: Controller): Unit = error("hit")
  def startGame(c: Controller): Unit = error("startGame")
  def initialDraw(c: Controller): Unit = error("initialDraw")
  def reset(c: Controller): Unit = error("reset")

  def isStart: Boolean = false
  def isFirstDraw: Boolean = false
  def isPlayerTurn: Boolean = false
  def isCpuTurn: Boolean = false
  def isPlayerExtendedTurn: Boolean = false
  def isCpuExtendedTurn: Boolean = false
  def isEndPhase: Boolean = false
  def isRoundStart: Boolean = false
  
  def isGameFinished: Boolean = false

}
