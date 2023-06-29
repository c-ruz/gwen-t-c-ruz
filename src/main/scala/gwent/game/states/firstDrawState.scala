package cl.uchile.dcc
package gwent.game.states

import gwent.game.Controller

class firstDrawState extends State {

  override def isFirstDraw: Boolean = true

  override def initialDraw(c: Controller): Unit = {
    this.changeState(c, new playerTurnState())
  } 
}
