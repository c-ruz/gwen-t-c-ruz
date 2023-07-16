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
    fill(deck, 3, unitCardFactory)
    // Adding some ranged cards
    unitCardFactory = new RangedCardFactory
    unitCardFactory.setName("Archird, the reborn")
    unitCardFactory.setStr(7)
    unitCardFactory.setEffect(new NullEffect)
    fill(deck, 3, unitCardFactory)
    // Adding siege cards
    unitCardFactory = new SiegeCardFactory
    unitCardFactory.setName("Sobek, no Kami")
    unitCardFactory.setStr(5)
    unitCardFactory.setEffect(new MoraleSupport)
    fill(deck, 3, unitCardFactory)
    // Adding more melee cards
    unitCardFactory = new MeleeCardFactory
    unitCardFactory.setName("Lao-Hu, incarnated will")
    unitCardFactory.setStr(5)
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
