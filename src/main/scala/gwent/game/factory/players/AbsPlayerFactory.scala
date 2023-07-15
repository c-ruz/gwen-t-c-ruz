package cl.uchile.dcc
package gwent.game.factory.players

import gwent.game.factory.deck.DeckFactory

abstract class AbsPlayerFactory extends PlayerFactory {
  protected var _name: String = "Player Name"
  protected var _deckFactory: DeckFactory = null
  protected var _gemsAmount: Int = 3
  protected var _handCap: Int = 10

  override def setDeckFactory(newDeckFactory: DeckFactory): Unit = {
    _deckFactory = newDeckFactory
  }

  override def setName(newName: String): Unit = {
    _name = newName
  }

  override def setGems(newAmount: Int): Unit = {
    _gemsAmount = math.max(0, newAmount)
  }

  override def setHandCap(newCap: Int): Unit = {
    _handCap = math.max(0, newCap)
  }
}
