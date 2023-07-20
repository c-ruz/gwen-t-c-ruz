package cl.uchile.dcc
package gwent.game.controller

import gwent.game.board.Board
import gwent.game.factory.deck.{DeckFactory, FlyingGangDeckFactory, XanKeiDeckFactory}
import gwent.game.factory.players.{CpuFactory, HumanFactory}
import gwent.game.players.{Computer, ISubject, Player}
import gwent.game.states.*

import scala.collection.mutable.ListBuffer

/**
 * Creates a Controller. Controller starts in Start state and is waiting to commence with the game.
 *
 * @param deckFactory1  DeckFactory for the player.
 * @param deckFactory2  DeckFactory for the cpu.
 */
class Controller(deckFactory1: DeckFactory, deckFactory2: DeckFactory) extends Observer {

  val playerCapsule: ListBuffer[Player] = ListBuffer.empty
  val cpuCapsule: ListBuffer[Computer] = ListBuffer.empty
  private val player1Factory: HumanFactory = new HumanFactory
  private val player2Factory: CpuFactory = new CpuFactory

  var state: State = new StartState
  var board: Board = new Board()
  private var gameActive: Boolean = false
  private var endMessage: String = _

  /**
   * Gets the state of the game.
   * @return  True if this controller is currently in a game. False if not.
   */
  def getGameState: Boolean = gameActive

  /**
   * Gets the end message of the controller. Used for testing.
   * @return  A string with the custom message of who won.
   */
  def getEndMessage: String = endMessage

  /**
   * Changes the state of the controller.
   * @param aState  The new state.
   */
  def setState(aState: State) = {
    state = aState
  }

  /**
   * When called, sets the controller in a game. Adds the player and cpu and calls the current state
   * startGame() method.
   */
  def startGame(): Unit = {
    gameActive = true

    player1Factory.setDeckFactory(deckFactory1)
    player2Factory.setDeckFactory(deckFactory2)
    val player1 = player1Factory.create(board)
    val player2 = player2Factory.create(board)

    player1.registerObserver(this)
    player2.registerObserver(this)
    playerCapsule += player1
    cpuCapsule += player2

    state.startGame(this)
  }

  /**
   * Calls the current state's method bothDraw.
   */
  def bothDraw(): Unit = state.bothDraw(this)

  /**
   * Calls the current state's method play.
   */
  def play(index: Int): Unit = state.play(this, index)

  /**
   * Calls the current state's method pass.
   */
  def pass(): Unit = state.pass(this)

  /**
   * Calls the current state's method hit.
   */
  def hit(): Unit = state.hit(this)

  /**
   * Calls the current state's method initialDraw.
   */
  def initialDraw(): Unit = state.initialDraw(this)

  /**
   * Calls the current state's method reset.
   */
  def reset(): Unit = state.reset(this)

  /**
   * calls the current state's method isStart.
   * @return  Boolean returned from call.
   */
  def isStart: Boolean = state.isStart

  /**
   * calls the current state's method isFirstDraw.
   *
   * @return Boolean returned from call.
   */
  def isFirstDraw: Boolean = state.isFirstDraw

  /**
   * calls the current state's method isPlayerTurn.
   *
   * @return Boolean returned from call.
   */
  def isPlayerTurn: Boolean = state.isPlayerTurn

  /**
   * calls the current state's method isCpuTurn.
   *
   * @return Boolean returned from call.
   */
  def isCpuTurn: Boolean = state.isCpuTurn

  /**
   * calls the current state's method isPlayerExtendedTurn.
   *
   * @return Boolean returned from call.
   */
  def isPlayerExtendedTurn: Boolean = state.isPlayerExtendedTurn

  /**
   * calls the current state's method isCpuExtendedTurn.
   *
   * @return Boolean returned from call.
   */
  def isCpuExtendedTurn: Boolean = state.isCpuExtendedTurn

  /**
   * calls the current state's method isEndPhase.
   *
   * @return Boolean returned from call.
   */
  def isEndPhase: Boolean = state.isEndPhase

  /**
   * calls the current state's method isRoundStart.
   *
   * @return Boolean returned from call.
   */
  def isRoundStart: Boolean = state.isRoundStart

  /**
   * calls the current state's method isGameFinished.
   *
   * @return Boolean returned from call.
   */
  def isGameFinished: Boolean = state.isGameFinished

  /**
   * This method receives the notification sent by subject of type Player.
   * @param s The Subject of type Player.
   * @param arg The amount of gems the player currently has.
   */
  override def updatePlayer(s: ISubject, arg: Any): Unit = {
    val remaining = arg.asInstanceOf[Int]
    if (remaining <= 0){
      endMessage = "The winner is Player 2"
      gameActive = false
    }
    else {
      if (remaining > 1) {
        println(s"Player 1 has $remaining gems remaining.")
      }
      else {
        println(s"Player 1 has $remaining gem remaining.")
      }
    }
  }

  /**
   * This method receives the notification sent by subject of type Computer.
   *
   * @param s   The Subject of type Player.
   * @param arg The amount of gems the player currently has.
   */
  override def updateCpu(s: ISubject, arg: Any): Unit = {
    val remaining = arg.asInstanceOf[Int]
    if (remaining <= 0) {
      endMessage = "The winner is Player 1"
      gameActive = false
    }
    else {
      if (remaining > 1) {
        println(s"Player 2 has $remaining gems remaining.")
      }
      else {
        println(s"Player 2 has $remaining gem remaining.")
      }
    }
  }

  /**
   * This method is called when both players have the same total strength at the
   * end of a round. If both players have 0 gems left, ends the game as a Draw.
   */
  def drawHandler(): Unit = {
    if (playerCapsule.head.gems == 0 &&
    cpuCapsule.head.gems == 0){
      endMessage = "It's a Draw"
      gameActive = false
    }
  }
}
