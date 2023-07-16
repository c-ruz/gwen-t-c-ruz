package cl.uchile.dcc
package gwent.game.states

import gwent.game.Controller

class cpuExtendTurn extends State {
  override def isCpuExtendedTurn: Boolean = true

  override def play(c: Controller): Unit = {
    this.changeState(c, new cpuExtendTurn)
  }

  override def pass(c: Controller): Unit = {
    this.changeState(c, new endPhaseState)
  }
}
