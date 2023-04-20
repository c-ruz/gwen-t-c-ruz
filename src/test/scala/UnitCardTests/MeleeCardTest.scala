package cl.uchile.dcc
package UnitCardTests

import munit.FunSuite

class MeleeCardTest extends FunSuite {
  val name = "Eta, el errabundo"
  val str = 5
  var meleeMonk: MeleeCard = _
  override def beforeEach(context: BeforeEach): Unit = {
    meleeMonk = new MeleeCard(name, str)
  }

  test("A MeleeCard can be created with a name and strength") {
    assertEquals(new MeleeCard(name, str), meleeMonk)
  }
}
