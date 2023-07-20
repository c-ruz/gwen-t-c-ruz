package cl.uchile.dcc
package gwent.game.states

import cl.uchile.dcc.gwent.game.controller.Controller

/**
 * Creates a GameFinished state. Can use the reset transition
 */
class GameFinished extends State {
  /**
   * Calls the reset() method in Board. Then, transitions to Start state.
   * @param c A Controller who is calling the transition.
   */
  override def reset(c: Controller): Unit = {
    c.board.reset()
    this.changeState(c, new StartState)
  }

  override def isGameFinished: Boolean = true
}
