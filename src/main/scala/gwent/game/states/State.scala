package cl.uchile.dcc
package gwent.game.states

import cl.uchile.dcc.gwent.game.Controller

class State {
  private var controller: Option[Controller] = None

  def setController(controller: Controller): Unit = {
    this.controller = Some(controller)
  }

  protected def changeState(state: State): Unit = {
    if (controller.isDefined) {
      controller.get.setState(state)
    }
  }

  def error() = throw new InvalidTransitionException("Wrong State")

  def bothDraw(): Unit = error()
  def play(): Unit = error()
  def pass(): Unit = error()
  def hit(): Unit = error()
  def initializeGame(): Unit = error()
  def initialDraw(): Unit = error()

  def isStart: Boolean = false
  def isFirstDraw: Boolean = false
  def isPlayerTurn: Boolean = false
  def isCpuTurn: Boolean = false
  def isPlayerExtendedTurn: Boolean = false
  def isCpuExtendedTurn: Boolean = false
  def isEndPhase: Boolean = false
  def isRoundStart: Boolean = false

}
