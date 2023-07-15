package cl.uchile.dcc
package gwent.game

import gwent.game.players.ISubject

trait Observer {
  def update(s: ISubject, arg: Any): Unit
}
