package cl.uchile.dcc
package gwent.game.board

import gwent.game.card.{MeleeCard, RangedCard, SiegeCard}

class UnitBoard {

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
}
