package cl.uchile.dcc
package gwent.Cards

import java.util.Objects

/**
 * Represents a ranged unit card used in the game.
 * @param name The name of the card.
 * @param str  The strength of the card.            
 */
class RangedCard(name: String, str: Int) extends AbsUnitCard(name, str) with Equals {
  override def canEqual(that: Any): Boolean = that.isInstanceOf[RangedCard]

  override def equals(obj: Any): Boolean = {
    if (canEqual(obj: Any)) {
      val other = obj.asInstanceOf[RangedCard]
      (this eq other) ||
        (this.name == other.name && this.str == other.str)
    } else {
      false
    }
  }
  override def hashCode(): Int = Objects.hash(classOf[RangedCard], name, str)
}
