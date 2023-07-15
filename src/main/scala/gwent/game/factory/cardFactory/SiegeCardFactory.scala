package cl.uchile.dcc
package gwent.game.factory.cardFactory

import cl.uchile.dcc.gwent.game.card.units.SiegeCard

class SiegeCardFactory extends AbsUnitCardFactory {

  def create(): SiegeCard = {
    new SiegeCard(_name, _str, _effect)
  }
}
