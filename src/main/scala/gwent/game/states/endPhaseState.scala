package cl.uchile.dcc
package gwent.game.states

class endPhaseState extends State {
  override def isEndPhase: Boolean = true

  override def hit(): Unit = {
    this.changeState(new roundStartState)
  }
}
