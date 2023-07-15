package cl.uchile.dcc
package gwent.game.factory.cardFactory

import cl.uchile.dcc.gwent.game.card.units.MeleeCard

class MeleeCardFactory extends AbsUnitCardFactory {
  
  def create(): MeleeCard = {
    new MeleeCard(_name, _str, _effect)
  }
}
