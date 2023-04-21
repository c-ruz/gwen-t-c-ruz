package cl.uchile.dcc
package Cards

import gwent.Cards.WeatherCard
import munit.FunSuite

class WeatherCardTest extends FunSuite {
  val name = "Escarcha mordiente"
  var weather: WeatherCard = _

  override def beforeEach(context: BeforeEach): Unit = {
    weather = new WeatherCard(name)
  }
  test("A weather card can be created with a name") {
    /** For now */
    var expected = new WeatherCard(name)
    assertEquals(expected, weather)

    expected = new WeatherCard("Clima Despejado")
    assert(!weather.equals(expected))
  }
}
