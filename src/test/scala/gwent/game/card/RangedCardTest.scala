package cl.uchile.dcc
package gwent.game.card

import gwent.game.card.{MeleeCard, RangedCard}

import munit.FunSuite

class RangedCardTest extends FunSuite{
  val name = "Trotamundos Marah"
  val str = 7
  var rangedCard: RangedCard = _
  override def beforeEach(context: BeforeEach): Unit = {
    rangedCard = new RangedCard(name, str)
  }
  test("A RangedCard can be created with a name and strength") {
    assertEquals(rangedCard.name, name)
    assertEquals(rangedCard.str, str)

    val strengthTest = new RangedCard(name, -1)
    assertEquals(strengthTest.str, 0)
  }
  test("Testing structural equality between RangedCard objects") {
    val compare = new RangedCard(name, str)
    assertEquals(compare, rangedCard)
    assertEquals(compare.##, rangedCard.##)
    
    val compare2 = new MeleeCard(name, str)
    assert(!rangedCard.equals(new MeleeCard(name, str)))
    assert(!rangedCard.##.equals(compare2.##))

    val rangedCard2 = new RangedCard("Trotamundos Nuniq", str)
    assert(!rangedCard.equals(rangedCard2))

    val rangedCard3 = new RangedCard(name, 10)
    assert(!rangedCard.equals(rangedCard3))
  }
}