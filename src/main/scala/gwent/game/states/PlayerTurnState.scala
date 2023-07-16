package cl.uchile.dcc
package gwent.game.states

import gwent.game.Controller

class PlayerTurnState extends State {
  override def isPlayerTurn: Boolean = true

  override def play(c: Controller, index: Int): Unit = {
    c.playerCapsule.head.play(index)
    this.changeState(c, new CpuTurnState)
  }

  override def pass(c: Controller): Unit = {
    this.changeState(c, new CpuExtendTurn)
  }
}
