package cl.uchile.dcc
package gwent.game.states

import gwent.game.Controller

class CpuExtendTurn extends State {
  override def isCpuExtendedTurn: Boolean = true

  override def play(c: Controller, index: Int): Unit = {
    c.cpuCapsule.head.play(index)
    this.changeState(c, new CpuExtendTurn)
  }

  override def pass(c: Controller): Unit = {
    this.changeState(c, new EndPhaseState)
  }
}
