package cl.uchile.dcc
package gwent.game.states

import cl.uchile.dcc.gwent.game.controller.Controller

/**
 * Creates a Start state. Can use startGame transition.
 */
class StartState extends State {
  /**
   * Transitions to FirstDraw state.
   * @param c A Controller who is calling the transition.
   */
  override def startGame(c: Controller): Unit = {
    this.changeState(c, new FirstDrawState())
  }
  override def isStart: Boolean = true
}
