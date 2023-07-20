package cl.uchile.dcc
package gwent.game.factory.cardFactory

import gwent.game.card.Card

trait CardFactory {
  /**
   * This method creates the card.
   * @return  A card with the parameters saved.
   */
  def create(): Card

  /**
   * This method changes the parameter for the name of the cards.
   * @param newName The new name.
   */
  def setName(newName: String): Unit
}
