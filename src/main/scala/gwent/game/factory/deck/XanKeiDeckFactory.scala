package cl.uchile.dcc
package gwent.game.factory.deck

import gwent.game.card.handler.Deck
import gwent.game.factory.cardFactory.{CardFactory, MeleeCardFactory, RangedCardFactory, SiegeCardFactory, UnitCardFactory, WeatherCardFactory}

import gwent.game.effects.unitCardEffects.{MoraleSupport, NullEffect, TightBond}
import gwent.game.effects.weatherCardEffects.{BitingFrost, ImpenetrableFog, TorrentialRain}

class XanKeiDeckFactory extends AbsDeckFactory {

  override def create(): Deck  = {
    val deck = new Deck(_name, _capacity)
    // Adding some MeleeCards
    unitCardFactory = new MeleeCardFactory
    unitCardFactory.setName("Eta, the wanderer")
    unitCardFactory.setStr(8)
    unitCardFactory.setEffect(new TightBond)
    deck.addCard(unitCardFactory.create())
    deck.addCard(unitCardFactory.create())
    deck.addCard(unitCardFactory.create())
    // Adding some ranged cards
    unitCardFactory = new RangedCardFactory
    unitCardFactory.setName("Wu-Qi, the unforgiving")
    unitCardFactory.setStr(7)
    unitCardFactory.setEffect(new NullEffect)
    deck.addCard(unitCardFactory.create())
    deck.addCard(unitCardFactory.create())
    deck.addCard(unitCardFactory.create())
    // Adding siege cards
    unitCardFactory = new SiegeCardFactory
    unitCardFactory.setName("Zeeh, the first light")
    unitCardFactory.setStr(5)
    unitCardFactory.setEffect(new MoraleSupport)
    deck.addCard(unitCardFactory.create())
    deck.addCard(unitCardFactory.create())
    deck.addCard(unitCardFactory.create())
    // Adding more melee cards
    unitCardFactory = new MeleeCardFactory
    unitCardFactory.setName("Diral, the spiral dimension")
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
