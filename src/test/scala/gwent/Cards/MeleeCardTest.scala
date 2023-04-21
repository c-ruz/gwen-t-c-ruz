package cl.uchile.dcc
package gwent.Cards

import cl.uchile.dcc.gwent.Cards.MeleeCard
import munit.FunSuite

class MeleeCardTest extends FunSuite {
  val name = "Eta, el errabundo"
  val str = 5
  var meleeMonk: MeleeCard = _
  override def beforeEach(context: BeforeEach): Unit = {
    meleeMonk = new MeleeCard(name, str)
  }

  test("A MeleeCard can be created with a name and strength") {
    assertEquals(meleeMonk.name, name)
    assertEquals(meleeMonk.str, str)
  }
  test("Testing structural equality between MeleeCard objects") {
    assertEquals(new MeleeCard(name, str), meleeMonk)

    assert(!meleeMonk.equals(new RangedCard(name, str)))

    val meleeMonk2 = new MeleeCard("Sun Tzu, el primer monje", str)
    assert(!meleeMonk.equals(meleeMonk2))
    
    val meleeMonk3 = new MeleeCard(name, 8)
    assert(!meleeMonk.equals(meleeMonk3))
  }
}

