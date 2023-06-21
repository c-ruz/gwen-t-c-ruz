package cl.uchile.dcc
package gwent.game.states

import gwent.game.Controller

class playerTurnState extends State {
  override def isPlayerTurn: Boolean = true

  override def play(c: Controller): Unit = {
    this.changeState(c, new cpuTurnState)
  }

  override def pass(c: Controller): Unit = {
    this.changeState(c, new cpuExtendTurn)
  }
}
