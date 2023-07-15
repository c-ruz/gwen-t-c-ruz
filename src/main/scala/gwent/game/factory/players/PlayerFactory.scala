package cl.uchile.dcc
package gwent.game.factory.players

import gwent.game.players.{IPlayer, Player}

import cl.uchile.dcc.gwent.game.board.Board
import cl.uchile.dcc.gwent.game.factory.deck.DeckFactory

trait PlayerFactory {
  def create(board: Board): IPlayer
  
  def setDeckFactory(newDeckFactory: DeckFactory): Unit
  
  def setName(newName: String): Unit
  
  def setGems(newAmount: Int): Unit
  
  def setHandCap(newCap: Int): Unit
}
