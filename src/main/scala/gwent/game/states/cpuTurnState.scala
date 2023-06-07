package cl.uchile.dcc
package gwent.game.states

class cpuTurnState extends State {
  override def isCpuTurn: Boolean = true

  override def play(): Unit = {
    this.changeState(new playerTurnState())
  }

  override def pass(): Unit = {
    this.changeState(new playerExtendTurn())
  }
}
