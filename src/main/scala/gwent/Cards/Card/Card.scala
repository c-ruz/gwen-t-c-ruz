package cl.uchile.dcc
package gwent.Cards.Card

/**
 * Represents the common structure of a card in the game.
 */
trait Card {

  /**
   * =============
   * Getters
   * =============
   */

  /**
   * Gets the name of the card
   */
  def name: String
}
/**
 * Each card has a name. Not all cards have strength; only Units.
 */

