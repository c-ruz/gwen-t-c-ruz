package cl.uchile.dcc
package gwent.game.states

import cl.uchile.dcc.gwent.game.controller.Controller

/**
 * Creates a PlayerExtendTurn state. Can use play and pass transitions.
 */
class PlayerExtendTurn extends State {
  override def isPlayerExtendedTurn: Boolean = true

  /**
   * Calls the play method in IPlayer with the index given. Then, transitions to PlayerExtendTurn state.
   *
   * @param c     A Controller who is calling the transition.
   * @param index An int with the index of the card.
   */
  override def play(c: Controller, index: Int): Unit = {
    c.playerCapsule.head.play(index)
    this.changeState(c, new PlayerExtendTurn)
  }

  /**
   * Transitions to EndPhase state.
   *
   * @param c A Controller who is calling the transition.
   */
  override def pass(c: Controller): Unit = {
    this.changeState(c, new EndPhaseState)
  }
}
