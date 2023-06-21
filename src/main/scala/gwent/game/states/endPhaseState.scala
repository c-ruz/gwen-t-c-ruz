package cl.uchile.dcc
package gwent.game.states

import gwent.game.Controller

class endPhaseState extends State {
  override def isEndPhase: Boolean = true

  override def hit(c: Controller): Unit = {
    this.changeState(c, new roundStartState)
  }
}
