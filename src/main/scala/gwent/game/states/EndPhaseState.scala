package cl.uchile.dcc
package gwent.game.states

import gwent.game.Controller

class EndPhaseState extends State {
  override def isEndPhase: Boolean = true

  override def hit(c: Controller): Unit = {
    val playerTotal: Int = c.board.playerStr
    val cpuTotal: Int = c.board.cpuStr
    if (playerTotal > cpuTotal){
      c.cpuCapsule.head.hit()
    }
    else if (cpuTotal > playerTotal){
      c.playerCapsule.head.hit()
    }
    else {
      c.playerCapsule.head.hit()
      c.cpuCapsule.head.hit()
      c.drawHandler()
    }
    if (c.getGameState) {
      this.changeState(c, new RoundStartState)
    }
    else {
      println(c.getEndMessage)
      this.changeState(c, new GameFinished)
    }
  }
}
