package cl.uchile.dcc
package gwent.game.factory.deck
import gwent.game.card.handler.Deck

import cl.uchile.dcc.gwent.game.effects.unitCardEffects.{MoraleSupport, NullEffect, TightBond}
import cl.uchile.dcc.gwent.game.effects.weatherCardEffects.{BitingFrost, ImpenetrableFog, TorrentialRain}
import cl.uchile.dcc.gwent.game.factory.cardFactory.{MeleeCardFactory, RangedCardFactory, SiegeCardFactory}

class FlyingGangDeckFactory extends AbsDeckFactory {
  override def create(): Deck = {
    val deck = new Deck(_name, _capacity)
    // Adding some MeleeCards
    unitCardFactory = new MeleeCardFactory
    unitCardFactory.setName("Kelp, the drunkard")
    unitCardFactory.setStr(4)
    unitCardFactory.setEffect(new MoraleSupport)
    fill(deck, 3, unitCardFactory)

    unitCardFactory.setName("Buddi, the miserable")
    unitCardFactory.setStr(7)
    unitCardFactory.setEffect(new TightBond)
    fill(deck, 3, unitCardFactory)
    // Adding siege cards
    unitCardFactory = new SiegeCardFactory
    unitCardFactory.setName("Lumille, the heir")
    unitCardFactory.setStr(7)
    fill(deck, 3, unitCardFactory)
    // Adding more melee cards
    unitCardFactory = new RangedCardFactory
    unitCardFactory.setName("Klaus, wanderer of the ports")
    unitCardFactory.setStr(4)
    unitCardFactory.setEffect(new MoraleSupport)
    fill(deck, 3, unitCardFactory)
    //Adding weather cards
    weatherCardFactory.setName("Clear Weather")
    fill(deck, 3, weatherCardFactory)

    weatherCardFactory.setName("Biting Frost")
    weatherCardFactory.setEffect(new BitingFrost)
    fill(deck, 2, weatherCardFactory)

    weatherCardFactory.setName("Impenetrable Fog")
    weatherCardFactory.setEffect(new ImpenetrableFog)
    fill(deck, 2, weatherCardFactory)

    weatherCardFactory.setName("Torrential Rain")
    weatherCardFactory.setEffect(new TorrentialRain)
    fill(deck, 3, weatherCardFactory)

    deck
  }
}
