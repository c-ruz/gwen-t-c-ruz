package cl.uchile.dcc
package gwent.game.states

import cl.uchile.dcc.gwent.game.Controller
import cl.uchile.dcc.gwent.game.states.exception.InvalidTransitionException

class State {
  protected def changeState(c: Controller, state: State): Unit = {
    c.setState(state)
  }

  /**
   * Throws an exception of type InvalidTransitionException
   * @param method  A String with the name of the method who called this method.
   */
  def error(method: String) = {
    throw new InvalidTransitionException(s"Can't transition with $method in ${getClass.getSimpleName}")
  }

  /**
   * This method calls error().
   * 
   * @param c A Controller who is calling the transition.
   */
  def bothDraw(c: Controller): Unit = error("bothDraw")

  /**
   * This method calls error().
   *
   * @param c A Controller who is calling the transition.
   */
  def play(c: Controller, index: Int): Unit = error("play")

  /**
   * This method calls error().
   *
   * @param c A Controller who is calling the transition.
   */
  def pass(c: Controller): Unit = error("pass")

  /**
   * This method calls error().
   *
   * @param c A Controller who is calling the transition.
   */
  def hit(c: Controller): Unit = error("hit")

  /**
   * This method calls error().
   *
   * @param c A Controller who is calling the transition.
   */
  def startGame(c: Controller): Unit = error("startGame")

  /**
   * This method calls error().
   *
   * @param c A Controller who is calling the transition.
   */
  def initialDraw(c: Controller): Unit = error("initialDraw")

  /**
   * This method calls error().
   *
   * @param c A Controller who is calling the transition.
   */
  def reset(c: Controller): Unit = error("reset")

  /**
   * This method calls error().
   *
   * @param c A Controller who is calling the transition.
   */

  /**
   * Checks if the current state is Start.
   * 
   * @return  A Boolean with the answer.
   */
  def isStart: Boolean = false

  /**
   * Checks if the current state is FirstDraw.
   *
   * @return A Boolean with the answer.
   */
  def isFirstDraw: Boolean = false

  /**
   * Checks if the current state is PlayerTurn.
   *
   * @return A Boolean with the answer.
   */
  def isPlayerTurn: Boolean = false

  /**
   * Checks if the current state is CpuTurn.
   *
   * @return A Boolean with the answer.
   */
  def isCpuTurn: Boolean = false

  /**
   * Checks if the current state is PlayerExtendTurn.
   *
   * @return A Boolean with the answer.
   */
  def isPlayerExtendedTurn: Boolean = false

  /**
   * Checks if the current state is CpuExtendTurn.
   *
   * @return A Boolean with the answer.
   */
  def isCpuExtendedTurn: Boolean = false

  /**
   * Checks if the current state is EndPhase.
   *
   * @return A Boolean with the answer.
   */
  def isEndPhase: Boolean = false

  /**
   * Checks if the current state is RoundStart.
   *
   * @return A Boolean with the answer.
   */
  def isRoundStart: Boolean = false

  /**
   * Checks if the current state is GameFinished.
   *
   * @return A Boolean with the answer.
   */
  
  def isGameFinished: Boolean = false

}
