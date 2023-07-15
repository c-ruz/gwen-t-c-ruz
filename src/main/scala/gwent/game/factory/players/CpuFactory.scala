package cl.uchile.dcc
package gwent.game.factory.players
import gwent.game.players.{Computer, Player}

import cl.uchile.dcc.gwent.game.board.Board
import cl.uchile.dcc.gwent.game.card.handler.Hand

class CpuFactory extends AbsPlayerFactory {

  override def create(board: Board): Computer = {
    new Computer(_name, _gemsAmount, _deckFactory.create(), new Hand(_handCap), board)
  }
}
