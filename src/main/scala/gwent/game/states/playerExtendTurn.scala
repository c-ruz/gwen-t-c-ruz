package cl.uchile.dcc
package gwent.game.states

import gwent.game.Controller

class playerExtendTurn extends State {
  override def isPlayerExtendedTurn: Boolean = true

  override def play(c: Controller): Unit = {
    this.changeState(c, new playerExtendTurn)
  }

  override def pass(c: Controller): Unit = {
    this.changeState(c, new endPhaseState)
  }
}
