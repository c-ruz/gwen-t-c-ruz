package cl.uchile.dcc
package gwent.game.states

class cpuExtendTurn extends State {
  override def isCpuExtendedTurn: Boolean = true

  override def play(): Unit = {
    this.changeState(new cpuExtendTurn)
  }

  override def pass(): Unit = {
    this.changeState(new endPhaseState)
  }
}
