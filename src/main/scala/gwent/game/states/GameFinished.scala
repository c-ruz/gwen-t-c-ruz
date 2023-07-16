package cl.uchile.dcc
package gwent.game.states
import gwent.game.Controller

class GameFinished extends State {
  override def reset(c: Controller): Unit = {
    c.board.reset()
    this.changeState(c, new StartState)
  }

  override def isGameFinished: Boolean = true
}
