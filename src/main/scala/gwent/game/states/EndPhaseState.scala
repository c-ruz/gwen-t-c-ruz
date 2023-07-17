package cl.uchile.dcc
package gwent.game.states

import gwent.game.Controller

/**
 * Creates an EndPhase state. Can use hit transition.
 */
class EndPhaseState extends State {
  override def isEndPhase: Boolean = true

  /**
   * Gets the total strength of each player in c. Calls the hit method on the player with the least gems.
   * If the total strengths are equal, calls hit on both. Then gets the game state from c. If the game
   * has ended, transitions to GameFinished state. Else, transitions to RoundStart state.
   * @param c A Controller who is calling the transition.
   */
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
