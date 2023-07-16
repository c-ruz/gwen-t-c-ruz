package cl.uchile.dcc
package gwent.game.states

import gwent.game.Controller

class PlayerExtendTurn extends State {
  override def isPlayerExtendedTurn: Boolean = true

  override def play(c: Controller, index: Int): Unit = {
    c.playerCapsule.head.play(index)
    this.changeState(c, new PlayerExtendTurn)
  }

  override def pass(c: Controller): Unit = {
    this.changeState(c, new EndPhaseState)
  }
}
