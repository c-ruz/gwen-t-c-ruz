package cl.uchile.dcc
package gwent.game.states

import gwent.game.Controller

class StartState extends State {

  override def startGame(c: Controller): Unit = {
    this.changeState(c, new FirstDrawState())
  }
  override def isStart: Boolean = true
}
