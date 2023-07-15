package cl.uchile.dcc
package gwent.game.factory.cardFactory

import cl.uchile.dcc.gwent.game.card.units.RangedCard

class RangedCardFactory extends AbsUnitCardFactory {
  
  def create(): RangedCard = {
    new RangedCard(_name, _str, _effect)
  }
}
