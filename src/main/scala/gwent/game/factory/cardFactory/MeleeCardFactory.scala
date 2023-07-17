package cl.uchile.dcc
package gwent.game.factory.cardFactory

import cl.uchile.dcc.gwent.game.card.units.MeleeCard

class MeleeCardFactory extends AbsUnitCardFactory {
  /**
   * Creates a MeleeCard with the parameters.
   * @return  A MeleeCard created with the parameters.
   */
  def create(): MeleeCard = {
    new MeleeCard(_name, _str, _effect)
  }
}
