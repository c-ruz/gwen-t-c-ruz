package cl.uchile.dcc
package gwent.game.board

import cl.uchile.dcc.gwent.game.card.WeatherCard
import cl.uchile.dcc.gwent.game.card.units.{MeleeCard, RangedCard, SiegeCard}

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

  /**
   * Gets the cards in the melee row.
   * @return  A List with the cards.
   */
  def MeleeFormation: List[MeleeCard] = {
    val clone = List[MeleeCard]()
    clone ::: _MeleeFormation
  }

  /**
   * Gets the cards in the ranged row.
   * @return  A List with the cards.
   */
  def RangedFormation: List[RangedCard] = {
    val clone = List[RangedCard]()
    clone ::: _RangedFormation
  }

  /**
   * Gets the cards in the siege row.
   * @return  A List with the cards.
   */
  def SiegeFormation: List[SiegeCard] = {
    val clone = List[SiegeCard]()
    clone ::: _SiegeFormation
  }
  /**
   * =========
   * Methods
   * =========
   */

  /**
   * Places a MeleeCard in the MeleeFormation list.
   * @param card  Card of type MeleeCard to be added.
   */
  def placeMelee(card: MeleeCard): Unit = {
    _MeleeFormation = card :: _MeleeFormation
    card.effect(card, _MeleeFormation)
  }
  /**
   * Places a RangedCard in the RangedFormation list.
   * @param card  Card of type RangedCard to be added.
   */
  def placeRanged(card: RangedCard): Unit = {
    _RangedFormation = card :: _RangedFormation
    card.effect(card, _RangedFormation)
  }
  /**
   * Places a SiegeCard in the SiegeFormation list.
   * @param card  Card of type SiegeCard to be added.
   */
  def placeSiege(card: SiegeCard): Unit = {
    _SiegeFormation = card :: _SiegeFormation
    card.effect(card, _SiegeFormation)
  }

  /**
   * Apply the effect of the weather card on the melee row.
   * @param card the card with the effect
   */
  def onMelee(card: WeatherCard): Unit = {
    card.effect(card, _MeleeFormation)
  }

  /**
   * Apply the effect of the weather card on the ranged row.
   * @param card the card with the effect
   */
  def onRanged(card: WeatherCard): Unit = {
    card.effect(card, _RangedFormation)
  }

  /**
   * Apply the effect of the weather card on the siege row.
   * @param card the card with the effect
   */
  def onSiege(card: WeatherCard): Unit = {
    card.effect(card, _SiegeFormation)
  }

  /**
   * Calculates the total strength of all cards placed.
   * @return  An int with the sum of the total strength of all rows.
   */
  def totalStr: Int = {
    var total: Int = 0
    _MeleeFormation.foreach(c => total += c.currStr)
    _RangedFormation.foreach(c => total += c.currStr)
    _SiegeFormation.foreach(c => total += c.currStr)
    total
  }

  /**
   * Removes all cards of the unit board.
   */
  def clean(): Unit = {
    _MeleeFormation = List()
    _RangedFormation = List()
    _SiegeFormation = List()
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
