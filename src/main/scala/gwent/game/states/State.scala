package cl.uchile.dcc
package gwent.game.states

import cl.uchile.dcc.gwent.game.Controller
import cl.uchile.dcc.gwent.game.states.exception.InvalidTransitionException

class State {
  private var controller: Option[Controller] = None

  def setController(controller: Controller): Unit = {
    this.controller = Some(controller)
  }

  protected def changeState(c: Controller, state: State): Unit = {
    c.setState(state)
  }

  def error() = throw new InvalidTransitionException("Wrong State")

  def bothDraw(c: Controller): Unit = error()
  def play(c: Controller): Unit = error()
  def pass(c: Controller): Unit = error()
  def hit(c: Controller): Unit = error()
  def initializeGame(c: Controller): Unit = error()
  def initialDraw(c: Controller): Unit = error()

  def isStart: Boolean = false
  def isFirstDraw: Boolean = false
  def isPlayerTurn: Boolean = false
  def isCpuTurn: Boolean = false
  def isPlayerExtendedTurn: Boolean = false
  def isCpuExtendedTurn: Boolean = false
  def isEndPhase: Boolean = false
  def isRoundStart: Boolean = false

}
