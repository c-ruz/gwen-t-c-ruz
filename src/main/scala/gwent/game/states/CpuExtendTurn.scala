package cl.uchile.dcc
package gwent.game.states

import cl.uchile.dcc.gwent.game.controller.Controller

/**
 * Creates a CpuExtendTurn state. Can use play and pass transitions.
 */
class CpuExtendTurn extends State {
  override def isCpuExtendedTurn: Boolean = true

  /**
   * Calls the play method in IPlayer with the index given. Then, transitions to CpuExtendTurn state.
   * @param c A Controller who is calling the transition.
   * @param index An int with the index of the card.
   */
  override def play(c: Controller, index: Int): Unit = {
    c.cpuCapsule.head.play(index)
    this.changeState(c, new CpuExtendTurn)
  }

  /**
   * Transitions to EndPhase state.
   * @param c A Controller who is calling the transition.
   */
  override def pass(c: Controller): Unit = {
    this.changeState(c, new EndPhaseState)
  }
}
