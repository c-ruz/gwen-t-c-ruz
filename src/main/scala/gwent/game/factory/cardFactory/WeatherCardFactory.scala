package cl.uchile.dcc
package gwent.game.factory.cardFactory

import gwent.game.card.WeatherCard

import cl.uchile.dcc.gwent.game.effects
import cl.uchile.dcc.gwent.game.effects.unitCardEffects.NullEffect
import cl.uchile.dcc.gwent.game.effects.weatherCardEffects.{ClearWeather, WeatherEffect}

class WeatherCardFactory extends CardFactory {
  private var _name: String = "Card Name"
  private var _effect: WeatherEffect = new ClearWeather
  
  def setName(newName: String): Unit = {
    _name = newName
  }

  /**
   * Changes the effect of the WeatherCard.
   * @param newEffect A WeatherEffect.
   */
  def setEffect(newEffect: WeatherEffect): Unit = {
    _effect = newEffect
  }
  
  def create(): WeatherCard = {
    new WeatherCard(_name, _effect)
  }
}
