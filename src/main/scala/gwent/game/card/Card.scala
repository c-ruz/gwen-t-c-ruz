package cl.uchile.dcc
package gwent.game.card

import gwent.game.players.{Computer, Player}
import cl.uchile.dcc.gwent.game.board.Board

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
   * Overloaded method place used in double dispatch method for playing cards. 
   * @param player      Receives player, of type Player, 
   *                    to play cards in the player section of the board.
   */
  def placeOnPlayer(board: Board): Unit
  /**
   * Overloaded method place used in double dispatch method for playing cards.
   * @param computer    Receives computer, of type Computer, 
   *                    to play cards in the computer section of the board.
   */
  def placeOnComputer(board: Board): Unit
}
/**
 * Each card has a name. Not all cards have strength; only Units.
 */

