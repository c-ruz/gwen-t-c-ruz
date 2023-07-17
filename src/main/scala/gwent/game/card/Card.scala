package cl.uchile.dcc
package gwent.game.card

import gwent.game.players.{Computer, Player}
import gwent.game.board.Board

import cl.uchile.dcc.gwent.game.effects.Effect

/**
 * Represents the common structure of a card in the game.
 */
trait Card extends Equals {

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
   * Gets the effect.
   */
  def effect: Effect
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

