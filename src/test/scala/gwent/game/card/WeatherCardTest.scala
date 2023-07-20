package cl.uchile.dcc
package gwent.game.card

import gwent.game.card.WeatherCard

import cl.uchile.dcc.gwent.game.card.units.MeleeCard
import cl.uchile.dcc.gwent.game.effects.unitCardEffects.NullEffect
import cl.uchile.dcc.gwent.game.effects.weatherCardEffects.ClearWeather
import munit.FunSuite

class WeatherCardTest extends FunSuite {
  val name = "Escarcha mordiente"
  val effect = new ClearWeather
  var weather: WeatherCard = _

  override def beforeEach(context: BeforeEach): Unit = {
    weather = new WeatherCard(name, effect)
  }
  test("A weather card can be created with a name") {
    /** For now */
    var expected = new WeatherCard(name, effect)
    assertEquals(expected, weather)
    assertEquals(expected.##, weather.##)

    assert(!weather.equals(new MeleeCard(name, 10, new NullEffect)))

    expected = new WeatherCard("Clima Despejado", effect)
    assert(!weather.equals(expected))
    assert(!weather.##.equals(expected.##))
  }
}
