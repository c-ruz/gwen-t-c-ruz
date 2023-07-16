package cl.uchile.dcc
package gwent.game.states

import gwent.game.Controller

class RoundStartState extends State {
  override def isRoundStart: Boolean = true

  override def bothDraw(c: Controller): Unit = {
    c.board.reset()
    c.playerCapsule.head.draw()
    c.cpuCapsule.head.draw()
    this.changeState(c, new PlayerTurnState)
  }
}
