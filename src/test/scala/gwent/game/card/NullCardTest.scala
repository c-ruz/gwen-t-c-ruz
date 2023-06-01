package cl.uchile.dcc
package gwent.game.card

import munit.FunSuite

class NullCardTest extends FunSuite {
  val Card1 = new NullCard()
  val Card2 = new WeatherCard("Dia soleado")
  
  test("Constructor test") {
    assertEquals(Card1.name, "")
  }
  
  test("Equality testing") {
    // All null cards are equals
    assertEquals(Card1, new NullCard())
    // Other cards are not equals to a Null Card
    assert(!Card1.equals(Card2))
  }
}
