package cl.uchile.dcc
package gwent.game.card

import cl.uchile.dcc.gwent.game.card.units.{RangedCard, SiegeCard}
import cl.uchile.dcc.gwent.game.effects.unitCardEffects.NullEffect
import munit.FunSuite

class SiegeCardTest extends FunSuite{
  val name = "Bombardero Wyvern"
  val str = 10
  var bomba: SiegeCard = _

  override def beforeEach(context: BeforeEach): Unit = {
    bomba = new SiegeCard(name, str, new NullEffect)
  }

  test("A SiegeCard can be created with a name and strength") {
    assertEquals(bomba.name, name)
    assertEquals(bomba.str, str)

    val strengthTest = new SiegeCard(name, -1, new NullEffect)
    assertEquals(strengthTest.str, 0)
  }

  test("Testing structural equality between SiegeCard objects") {
    
    val compare = new SiegeCard(name, str, new NullEffect)
    assertEquals(compare, bomba)
    assertEquals(compare.##, bomba.##)
    
    val compare2 = new RangedCard(name, str, new NullEffect)
    assert(!bomba.equals(compare2))
    assert(!bomba.##.equals(compare2.##))

    val siegeCard2 = new SiegeCard("Soldado de arcilla", str, new NullEffect)
    assert(!bomba.equals(siegeCard2))
    
    val siegeCard3 = new SiegeCard(name, 5, new NullEffect)
    assert(!bomba.equals(siegeCard3))
  }
}
