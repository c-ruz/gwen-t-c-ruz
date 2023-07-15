package cl.uchile.dcc
package gwent.game.players

import gwent.game.Observer


trait ISubject {
  def registerObserver(o: Observer): Unit
  def notifyObserver(arg: Any): Unit
}
