package cl.uchile.dcc

import munit.FunSuite

class HandTest extends FunSuite {
  val capacity = 10
  val hand1: Hand = _
  override def beforeEach(context: BeforeEach): Unit = {
    hand1 = new Hand(capacity)
  }
  test("An empty hand can be created with max capacity") {
    assertEquals(hand1.capacity, capacity)
  }
}
