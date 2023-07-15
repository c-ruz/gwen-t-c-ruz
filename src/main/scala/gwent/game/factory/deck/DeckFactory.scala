package cl.uchile.dcc
package gwent.game.factory.deck

import gwent.game.card.handler.Deck

trait DeckFactory {
  def create(): Deck
  
  def setName(newName: String): Unit
  
  def setCapacity(newCap: Int): Unit
}
