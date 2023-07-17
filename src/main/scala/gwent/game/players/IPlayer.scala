package cl.uchile.dcc
package gwent.game.players

import gwent.game.card.handler.{Deck, Hand}

trait IPlayer {
  /**
   * Gets the name of the player.
   * @return  A string with the name.
   */
  def name: String

  /**
   * Gets the gems of the player.
   * @return  An int with the amount of gems.
   */
  def gems: Int

  /**
   * Gets the hand of the player.
   * @return  A Hand obj equal to the player's.
   */
  def hand: Hand

  /**
   * Gets the deck of the player.
   * @return  A Deck object equal to the player's
   */
  def deck: Deck

  /**
   * Plays the card corresponding to the index in the player's hand. Index starts at 1.
   * @param index An int with the index.
   */
  def play(index: Int): Unit

  /**
   * Draws n cards from the deck and adds them to the player's hand.
   * @param n An int with the amount of cards to be drawn.
   */
  def draw(n: Int): Unit

  /**
   * Shuffles the deck of the player.
   */
  def shuffle(): Unit
}
