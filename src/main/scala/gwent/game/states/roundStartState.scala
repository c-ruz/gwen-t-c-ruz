package cl.uchile.dcc
package gwent.game.states

class roundStartState extends State {
  override def isRoundStart: Boolean = true

  override def bothDraw(): Unit = {
    this.changeState(new playerTurnState)
  }
}
