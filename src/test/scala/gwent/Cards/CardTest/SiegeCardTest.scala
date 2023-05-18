package cl.uchile.dcc
package gwent.Cards.CardTest

import gwent.Cards.Card.{RangedCard, SiegeCard}

import munit.FunSuite

class SiegeCardTest extends FunSuite{
  val name = "Bombardero Wyvern"
  val str = 10
  var bomba: SiegeCard = _

  override def beforeEach(context: BeforeEach): Unit = {
    bomba = new SiegeCard(name, str)
  }

  test("A SiegeCard can be created with a name and strength") {
    assertEquals(bomba.name, name)
    assertEquals(bomba.str, str)
  }

  test("Testing structural equality between SiegeCard objects") {
    
    val compare = new SiegeCard(name, str)
    assertEquals(compare, bomba)
    assertEquals(compare.##, bomba.##)
    
    val compare2 = new RangedCard(name, str)
    assert(!bomba.equals(compare2))
    assert(!bomba.##.equals(compare2.##))

    val siegeCard2 = new SiegeCard("Soldado de arcilla", str)
    assert(!bomba.equals(siegeCard2))
    
    val siegeCard3 = new SiegeCard(name, 5)
    assert(!bomba.equals(siegeCard3))
  }
}
