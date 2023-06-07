package cl.uchile.dcc
package gwent.game.card

import gwent.game.card.{MeleeCard, WeatherCard}

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
    assertEquals(expected.##, weather.##)

    assert(!weather.equals(new MeleeCard(name, 10)))

    expected = new WeatherCard("Clima Despejado")
    assert(!weather.equals(expected))
    assert(!weather.##.equals(expected.##))
  }
}
