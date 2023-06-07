package cl.uchile.dcc
package gwent.game.states

class playerExtendTurn extends State {
  override def isPlayerExtendedTurn: Boolean = true

  override def play(): Unit = {
    this.changeState(new playerExtendTurn)
  }

  override def pass(): Unit = {
    this.changeState(new endPhaseState)
  }
}
