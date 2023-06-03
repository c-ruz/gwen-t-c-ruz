package cl.uchile.dcc
package gwent.game.card

import gwent.game.players.{Computer, Player}
import gwent.game.board.Board

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
  /**
   * Sends a message that the card has to be placed on the player's side.
   * @param board the board where the card is going to be placed.
   */
  def placeOnPlayer(board: Board): Unit
  /**
   * Sends a message that the card has to be placed on the computer's side.
   * @param board the board where the card is going to be placed.
   */
  def placeOnComputer(board: Board): Unit
}
/**
 * Each card has a name. Not all cards have strength; only Units.
 */

