package cl.uchile.dcc
package UnitCardTests

import cl.uchile.dcc.gwent.Cards.SiegeCard
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
    assertEquals(new SiegeCard(name, str), bomba)

    val siegeCard2 = new SiegeCard("Soldado de arcilla", str)
    assert(!bomba.equals(siegeCard2))
    
    val siegeCard3 = new SiegeCard(name, 5)
    assert(!bomba.equals(siegeCard3))
  }
}
