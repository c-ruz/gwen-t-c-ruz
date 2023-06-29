package cl.uchile.dcc
package gwent.game.card

import cl.uchile.dcc.gwent.game.card.units.{MeleeCard, RangedCard}
import cl.uchile.dcc.gwent.game.effects.unitCardEffects.NullEffect
import munit.FunSuite

class MeleeCardTest extends FunSuite {
  val name = "Eta, el errabundo"
  val str = 5
  var meleeMonk: MeleeCard = _
  override def beforeEach(context: BeforeEach): Unit = {
    meleeMonk = new MeleeCard(name, str, new NullEffect)
  }

  test("A MeleeCard can be created with a name and strength") {
    assertEquals(meleeMonk.name, name)
    assertEquals(meleeMonk.str, str)

    val strengthTest = new MeleeCard(name, -1, new NullEffect)
    assertEquals(strengthTest.str, 0)
  }
  test("Testing structural equality between MeleeCard objects") {
    val compare = new MeleeCard(name, str, new NullEffect)
    assertEquals(compare, meleeMonk)
    assertEquals(compare.##, meleeMonk.##)

    val compare2 = new RangedCard(name, str, new NullEffect)
    assert(!meleeMonk.equals(compare2))
    assert(!meleeMonk.##.equals(compare2.##))

    val meleeMonk2 = new MeleeCard("Sun Tzu, el primer monje", str, new NullEffect)
    assert(!meleeMonk.equals(meleeMonk2))
    
    val meleeMonk3 = new MeleeCard(name, 8, new NullEffect)
    assert(!meleeMonk.equals(meleeMonk3))
  }

  test("current strength") {
    assertEquals(str, meleeMonk.currStr)
  }
}

