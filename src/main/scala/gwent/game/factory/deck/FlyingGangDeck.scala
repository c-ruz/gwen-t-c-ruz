package cl.uchile.dcc
package gwent.game.factory.deck
import gwent.game.card.handler.Deck

import cl.uchile.dcc.gwent.game.effects.unitCardEffects.{MoraleSupport, NullEffect, TightBond}
import cl.uchile.dcc.gwent.game.effects.weatherCardEffects.{BitingFrost, ImpenetrableFog, TorrentialRain}
import cl.uchile.dcc.gwent.game.factory.cardFactory.{MeleeCardFactory, RangedCardFactory, SiegeCardFactory}

class FlyingGangDeck extends AbsDeckFactory {
  override def create(): Deck = {
    val deck = new Deck(_name, _capacity)
    // Adding some MeleeCards
    unitCardFactory = new MeleeCardFactory
    unitCardFactory.setName("Kelp, the drunkard")
    unitCardFactory.setStr(4)
    unitCardFactory.setEffect(new MoraleSupport)
    deck.addCard(unitCardFactory.create())
    deck.addCard(unitCardFactory.create())
    deck.addCard(unitCardFactory.create())

    unitCardFactory.setName("Phell, the heretic")
    unitCardFactory.setStr(7)
    unitCardFactory.setEffect(new TightBond)
    deck.addCard(unitCardFactory.create())
    deck.addCard(unitCardFactory.create())
    deck.addCard(unitCardFactory.create())
    // Adding siege cards
    unitCardFactory = new SiegeCardFactory
    unitCardFactory.setName("Jeass, the boss")
    unitCardFactory.setStr(7)
    deck.addCard(unitCardFactory.create())
    deck.addCard(unitCardFactory.create())
    deck.addCard(unitCardFactory.create())
    // Adding more melee cards
    unitCardFactory = new RangedCardFactory
    unitCardFactory.setName("Grace & Silver, the inept")
    unitCardFactory.setStr(4)
    unitCardFactory.setEffect(new MoraleSupport)
    deck.addCard(unitCardFactory.create())
    deck.addCard(unitCardFactory.create())
    deck.addCard(unitCardFactory.create())
    //Adding weather cards
    weatherCardFactory.setName("Clear Weather")
    deck.addCard(weatherCardFactory.create())
    deck.addCard(weatherCardFactory.create())
    deck.addCard(weatherCardFactory.create())

    weatherCardFactory.setName("Biting Frost")
    weatherCardFactory.setEffect(new BitingFrost)
    deck.addCard(weatherCardFactory.create())
    deck.addCard(weatherCardFactory.create())

    weatherCardFactory.setName("Impenetrable Fog")
    weatherCardFactory.setEffect(new ImpenetrableFog)
    deck.addCard(weatherCardFactory.create())
    deck.addCard(weatherCardFactory.create())

    weatherCardFactory.setName("Torrential Rain")
    weatherCardFactory.setEffect(new TorrentialRain)
    deck.addCard(weatherCardFactory.create())
    deck.addCard(weatherCardFactory.create())
    deck.addCard(weatherCardFactory.create())

    deck
  }
}
