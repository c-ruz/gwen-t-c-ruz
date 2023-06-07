package cl.uchile.dcc
package gwent.game.states

class firstDrawState extends State {

  override def isFirstDraw: Boolean = true

  override def initialDraw(): Unit = {
    this.changeState(new playerTurnState())
  } 
}
