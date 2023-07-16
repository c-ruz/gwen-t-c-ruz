package cl.uchile.dcc
package gwent.game

import gwent.game.states.*

import cl.uchile.dcc.gwent.game.board.Board
import cl.uchile.dcc.gwent.game.factory.deck.{DeckFactory, FlyingGangDeckFactory, XanKeiDeckFactory}
import cl.uchile.dcc.gwent.game.factory.players.{CpuFactory, HumanFactory}
import cl.uchile.dcc.gwent.game.players.{Computer, ISubject, Player}

import scala.collection.mutable.ListBuffer

class Controller(deckFactory1: DeckFactory, deckFactory2: DeckFactory) extends Observer {

  val playerCapsule: ListBuffer[Player] = ListBuffer.empty
  val cpuCapsule: ListBuffer[Computer] = ListBuffer.empty
  private val player1Factory: HumanFactory = new HumanFactory
  private val player2Factory: CpuFactory = new CpuFactory

  var state: State = new StartState
  var board: Board = new Board()
  private var gameActive: Boolean = false
  private var endMessage: String = _

  def getGameState: Boolean = gameActive
  def getEndMessage: String = endMessage
  
  def setState(aState: State) = {
    state = aState
  }
  
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

  def bothDraw(): Unit = state.bothDraw(this)
  def play(index: Int): Unit = state.play(this, index)
  def pass(): Unit = state.pass(this)
  def hit(): Unit = state.hit(this)
  def initialDraw(): Unit = state.initialDraw(this)
  def reset(): Unit = state.reset(this)

  def isStart: Boolean = state.isStart
  def isFirstDraw: Boolean = state.isFirstDraw
  def isPlayerTurn: Boolean = state.isPlayerTurn
  def isCpuTurn: Boolean = state.isCpuTurn
  def isPlayerExtendedTurn: Boolean = state.isPlayerExtendedTurn
  def isCpuExtendedTurn: Boolean = state.isCpuExtendedTurn
  def isEndPhase: Boolean = state.isEndPhase
  def isRoundStart: Boolean = state.isRoundStart
  def isGameFinished: Boolean = state.isGameFinished

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

  def drawHandler(): Unit = {
    if (playerCapsule.head.gems == 0 &&
    cpuCapsule.head.gems == 0){
      endMessage = "It's a Draw"
      gameActive = false
    }
  }
}
