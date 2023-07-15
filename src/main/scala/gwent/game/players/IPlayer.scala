package cl.uchile.dcc
package gwent.game.players

import gwent.game.card.handler.{Deck, Hand}

trait IPlayer {
  def name: String

  def gems: Int

  def hand: Hand

  def deck: Deck

  def play(index: Int): Unit

  def draw(n: Int): Unit
  
  def shuffle(): Unit
}
