package cl.uchile.dcc
package gwent.game

import gwent.game.players.ISubject

trait Observer {
  def updatePlayer(s: ISubject, arg: Any): Unit
  def updateCpu(s: ISubject, arg: Any): Unit
}
