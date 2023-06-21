package cl.uchile.dcc
package gwent.game.states

import gwent.game.Controller

class roundStartState extends State {
  override def isRoundStart: Boolean = true

  override def bothDraw(c: Controller): Unit = {
    this.changeState(c, new playerTurnState)
  }
}
