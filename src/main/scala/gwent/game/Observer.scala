package cl.uchile.dcc
package gwent.game

import gwent.game.players.ISubject

trait Observer {
  /**
   * Update method for subjects of type Player for objects of type Observer.
   * @param s The subject.
   * @param arg The notification.
   */
  def updatePlayer(s: ISubject, arg: Any): Unit

  /**
   * Update method for subjects of type Computer for objects of type Observer.
   *
   * @param s   The subject.
   * @param arg The notification.
   */
  def updateCpu(s: ISubject, arg: Any): Unit
}
