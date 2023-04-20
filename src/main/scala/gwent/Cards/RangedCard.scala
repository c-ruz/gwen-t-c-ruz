package cl.uchile.dcc
package gwent.Cards

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
}
