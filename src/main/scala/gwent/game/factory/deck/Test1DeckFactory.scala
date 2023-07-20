package cl.uchile.dcc
package gwent.game.factory.deck
import gwent.game.card.handler.Deck

import cl.uchile.dcc.gwent.game.effects.unitCardEffects.{MoraleSupport, NullEffect}
import cl.uchile.dcc.gwent.game.factory.cardFactory.MeleeCardFactory

class Test1DeckFactory(cardStr: Int = 0) extends AbsDeckFactory {
  override def create(): Deck = {
    val deck = new Deck(_name, _capacity)
    unitCardFactory = new MeleeCardFactory
    unitCardFactory.setName("Test Card")
    unitCardFactory.setStr(cardStr)
    unitCardFactory.setEffect(new NullEffect)
    fill(deck, _capacity, unitCardFactory)
    deck
  }
}
