package cl.uchile.dcc

import munit.FunSuite

// todavía no se testearan clasificaciones ni efectos
class CardTest extends FunSuite {
  val name = "Eta, el Errabundo"
  val atk = 5
  var card1: Card = _
  override def beforeEach(context: BeforeEach): Unit = {
    card1 = new Card(name, atk)
  }
  test("A card can be created with a name and a strength value"){
    assertEquals(card1.name, name)
    assertEquals(card1.str, atk)
  }
}
