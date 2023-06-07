package cl.uchile.dcc
package gwent.game.states

class StartState extends State {

  override def initializeGame(): Unit = {
    this.changeState(new firstDrawState())
  }

  override def isStart: Boolean = true
}
