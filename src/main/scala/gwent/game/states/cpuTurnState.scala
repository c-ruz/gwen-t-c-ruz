package cl.uchile.dcc
package gwent.game.states

import gwent.game.Controller

class cpuTurnState extends State {
  override def isCpuTurn: Boolean = true

  override def play(c: Controller): Unit = {
    this.changeState(c, new playerTurnState())
  }

  override def pass(c: Controller): Unit = {
    this.changeState(c, new playerExtendTurn())
  }
}
