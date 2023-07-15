package cl.uchile.dcc
package gwent.game.factory.players
import gwent.game.board.Board
import gwent.game.players.Player

import cl.uchile.dcc.gwent.game.card.handler.Hand

class HumanFactory extends AbsPlayerFactory {
  override def create(board: Board): Player = {
    new Player(_name, _gemsAmount, _deckFactory.create(), new Hand(_handCap), board)
  }
}
