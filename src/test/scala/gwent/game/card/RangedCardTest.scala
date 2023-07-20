package cl.uchile.dcc
package gwent.game.card

import cl.uchile.dcc.gwent.game.card.units.{MeleeCard, RangedCard}
import cl.uchile.dcc.gwent.game.effects.unitCardEffects.NullEffect
import munit.FunSuite

class RangedCardTest extends FunSuite{
  val name = "Trotamundos Marah"
  val str = 7
  var rangedCard: RangedCard = _
  override def beforeEach(context: BeforeEach): Unit = {
    rangedCard = new RangedCard(name, str, new NullEffect)
  }
  test("A RangedCard can be created with a name and strength") {
    assertEquals(rangedCard.name, name)
    assertEquals(rangedCard.baseStr, str)

    val strengthTest = new RangedCard(name, -1, new NullEffect)
    assertEquals(strengthTest.baseStr, 0)
  }
  test("Testing structural equality between RangedCard objects") {
    val compare = new RangedCard(name, str, new NullEffect)
    assertEquals(compare, rangedCard)
    assertEquals(compare.##, rangedCard.##)

    val compare2 = new MeleeCard(name, str, new NullEffect)
    assert(!rangedCard.equals(new MeleeCard(name, str, new NullEffect)))
    assert(!rangedCard.##.equals(compare2.##))

    val rangedCard2 = new RangedCard("Trotamundos Nuniq", str, new NullEffect)
    assert(!rangedCard.equals(rangedCard2))

    val rangedCard3 = new RangedCard(name, 10, new NullEffect)
    assert(!rangedCard.equals(rangedCard3))
  }
}