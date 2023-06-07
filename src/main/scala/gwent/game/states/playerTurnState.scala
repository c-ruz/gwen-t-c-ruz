package cl.uchile.dcc
package gwent.game.states

class playerTurnState extends State {
  override def isPlayerTurn: Boolean = true

  override def play(): Unit = {
    this.changeState(new cpuTurnState)
  }

  override def pass(): Unit = {
    this.changeState(new cpuExtendTurn)
  }
}
