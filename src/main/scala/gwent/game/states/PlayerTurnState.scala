package cl.uchile.dcc
package gwent.game.states

import gwent.game.Controller

/**
 * Creates a PlayerTurn state. Can use play and pass transitions.
 */
class PlayerTurnState extends State {
  override def isPlayerTurn: Boolean = true

  /**
   * Calls the play method in IPlayer with the index given. Then, transitions to PlayerTurn state.
   *
   * @param c     A Controller who is calling the transition.
   * @param index An int with the index of the card.
   */
  override def play(c: Controller, index: Int): Unit = {
    c.playerCapsule.head.play(index)
    this.changeState(c, new CpuTurnState)
  }

  /**
   * Transitions to PlayerExtendTurn state.
   *
   * @param c A Controller who is calling the transition.
   */
  override def pass(c: Controller): Unit = {
    this.changeState(c, new CpuExtendTurn)
  }
}
