package cl.uchile.dcc
package gwent.game.states

import gwent.game.Controller

class CpuTurnState extends State {
  override def isCpuTurn: Boolean = true

  override def play(c: Controller, index: Int): Unit = {
    c.cpuCapsule.head.play(index)
    this.changeState(c, new PlayerTurnState())
  }

  override def pass(c: Controller): Unit = {
    this.changeState(c, new PlayerExtendTurn())
  }
}
