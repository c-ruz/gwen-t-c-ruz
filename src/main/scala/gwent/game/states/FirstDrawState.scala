package cl.uchile.dcc
package gwent.game.states

import gwent.game.Controller

class FirstDrawState extends State {

  override def isFirstDraw: Boolean = true

  override def initialDraw(c: Controller): Unit = {
    c.cpuCapsule.head.draw(10)
    c.playerCapsule.head.draw(10)
    this.changeState(c, new PlayerTurnState())
  } 
}
