package cl.uchile.dcc
package gwent.game.factory.cardFactory

import gwent.game.card.Card

trait CardFactory {
  def create(): Card
  
  def setName(newName: String): Unit
}
