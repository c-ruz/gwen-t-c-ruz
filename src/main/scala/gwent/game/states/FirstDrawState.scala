package cl.uchile.dcc
package gwent.game.states

import cl.uchile.dcc.gwent.game.controller.Controller

/**
 * Creates a FirstDraw state. Can use the initialDraw transition.
 */
class FirstDrawState extends State {

  override def isFirstDraw: Boolean = true

  /**
   * Shuffles the decks of both players in c. Then, calls the draw(10) method in IPlayer.
   * Finally, transitions to PlayerTurn state.
   * @param c A Controller who is calling the transition.
   */
  override def initialDraw(c: Controller): Unit = {
    c.cpuCapsule.head.shuffle()
    c.cpuCapsule.head.draw(10)
    c.playerCapsule.head.shuffle()
    c.playerCapsule.head.draw(10)
    this.changeState(c, new PlayerTurnState())
  } 
}
