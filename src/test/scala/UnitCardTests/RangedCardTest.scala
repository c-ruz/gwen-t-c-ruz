package cl.uchile.dcc
package UnitCardTests

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
  }
  test("Testing structural equality between RangedCard objects") {
    assertEquals(new RangedCard(name, str), rangedCard)

    val rangedCard2 = new RangedCard("Trotamundos Nuniq", str)
    assert(!rangedCard.equals(rangedCard2))

    val rangedCard3 = new RangedCard(name, 10)
    assert(!rangedCard.equals(rangedCard2))
  }
}