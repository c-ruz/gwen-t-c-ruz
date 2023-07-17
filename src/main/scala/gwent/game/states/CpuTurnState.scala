package cl.uchile.dcc
package gwent.game.states

import gwent.game.Controller

/**
 * Creates a CpuTurn state. Can use play and pass transitions.
 */
class CpuTurnState extends State {
  override def isCpuTurn: Boolean = true

  /**
   * Calls the play method in IPlayer with the index given. Then, transitions to PlayerTurn state.
   * @param c A Controller who is calling the transition.
   * @param index An int with the index of the card.
   */
  override def play(c: Controller, index: Int): Unit = {
    c.cpuCapsule.head.play(index)
    this.changeState(c, new PlayerTurnState())
  }

  /**
   * Transitions to PlayerExtendTurn state.
   * @param c A Controller who is calling the transition.
   */
  override def pass(c: Controller): Unit = {
    this.changeState(c, new PlayerExtendTurn())
  }
}
