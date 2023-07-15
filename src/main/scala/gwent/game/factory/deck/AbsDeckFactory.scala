package cl.uchile.dcc
package gwent.game.factory.deck

import gwent.game.factory.cardFactory.{UnitCardFactory, WeatherCardFactory}

abstract class AbsDeckFactory extends DeckFactory {
  protected var _name: String = "Deck Name"
  protected var _capacity: Int = 25

  protected var unitCardFactory: UnitCardFactory = null
  protected val weatherCardFactory: WeatherCardFactory = new WeatherCardFactory
  
  override def setName(newName: String): Unit = {
    _name = newName
  }

  override def setCapacity(newCap: Int): Unit = {
    _capacity = math.max(0, newCap)
  }
}
