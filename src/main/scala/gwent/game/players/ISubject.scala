package cl.uchile.dcc
package gwent.game.players

import cl.uchile.dcc.gwent.game.controller.Observer


trait ISubject {
  /**
   * This method adds an observer to the list of observers of this subject.
   *
   * @param o An Observer.
   */
  def registerObserver(o: Observer): Unit

  /**
   * This method notifies the observers in list observers that some change has ocurred.
   *
   * @param arg Some argument for the notification.
   */
  def notifyObserver(arg: Any): Unit
}
