package cl.uchile.dcc
package gwent.game.states

import gwent.game.Controller

/**
 * Creates a RoundStart state. Can use the bothDraw transition.
 */
class RoundStartState extends State {
  override def isRoundStart: Boolean = true

  /**
   * Calls the reset() method in Board. Then, calls the shuffle() method for both IPlayer in c. Then,
   * calls the draw() method in IPlayer. Finally, transitions to PlayerTurn state.
   * @param c A Controller who is calling the transition.
   */
  override def bothDraw(c: Controller): Unit = {
    c.board.reset()
    c.playerCapsule.head.shuffle()
    c.playerCapsule.head.draw()
    c.cpuCapsule.head.shuffle()
    c.cpuCapsule.head.draw()
    this.changeState(c, new PlayerTurnState)
  }
}
