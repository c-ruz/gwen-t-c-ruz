package cl.uchile.dcc
package gwent.game.states

import gwent.game.Controller

class StartState extends State {

  override def initializeGame(c: Controller): Unit = {
    this.changeState(c, new firstDrawState())
  }

  override def isStart: Boolean = true
}
