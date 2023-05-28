package cl.uchile.dcc
package gwent.game.board

import gwent.game.card.{MeleeCard, RangedCard, SiegeCard}

class UnitBoard extends Equals {

  /**
   * Each list corresponds to the line of units forming the units' board
   */
  private var _MeleeFormation: List[MeleeCard] = List()
  private var _RangedFormation: List[RangedCard] = List()
  private var _SiegeFormation: List[SiegeCard] = List()

  /**
   * ==========
   * Getters
   * ==========
   */
  def MeleeFormation: List[MeleeCard] = _MeleeFormation
  def RangedFormation: List[RangedCard] = _RangedFormation
  def SiegeFormation: List[SiegeCard] = _SiegeFormation
  /**
   * =========
   * Methods
   * =========
   */
  def placeMelee(card: MeleeCard): Unit = {
    _MeleeFormation = card :: _MeleeFormation
  }
  
  def placeRanged(card: RangedCard): Unit = {
    _RangedFormation = card :: _RangedFormation
  }
  
  def placeSiege(card: SiegeCard): Unit = {
    _SiegeFormation = card :: _SiegeFormation
  }

  /**
   * ======================
   * Equals Implementation
   * ======================
   */

  override def canEqual(that: Any): Boolean = that.isInstanceOf[UnitBoard]

  override def equals(obj: Any): Boolean = {
    if (canEqual(obj)) {
      val other = obj.asInstanceOf[UnitBoard]
      (this eq other) || (this.MeleeFormation == other.MeleeFormation &&
        this.RangedFormation == other.RangedFormation && this.SiegeFormation == other.SiegeFormation)
    }
    else {
      false
    }
  }
}
