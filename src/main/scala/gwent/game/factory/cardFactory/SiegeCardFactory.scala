package cl.uchile.dcc
package gwent.game.factory.cardFactory

import cl.uchile.dcc.gwent.game.card.units.SiegeCard

class SiegeCardFactory extends AbsUnitCardFactory {
  /**
   *  Creates a SiegeCard.
   *  @return  A SiegeCard with the parameters saved.
   */
  def create(): SiegeCard = {
    new SiegeCard(_name, _str, _effect)
  }
}
