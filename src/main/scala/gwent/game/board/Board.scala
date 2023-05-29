package cl.uchile.dcc
package gwent.game.board

import gwent.game.card.{MeleeCard, RangedCard, SiegeCard, WeatherCard}

class Board() extends Equals {
  /**
   * ================
   * Player board
   * ================
   */
  private val _playerArmy: UnitBoard = new UnitBoard()

  /**
   * ================
   * Computer board
   * ================
   */
  private val _computerArmy: UnitBoard = new UnitBoard()

  /**
   * ==================
   * Weather card slot
   * ==================
   */
  private var _weatherSlot: List[WeatherCard] = List()

  /**
   * ========
   * Getters
   * ========
   */
  def playerArmy: UnitBoard = _playerArmy
  def computerArmy: UnitBoard = _computerArmy
  def WeatherSlot: List[WeatherCard] = _weatherSlot

  /**
   * ===============
   * Class methods
   * ===============
   */
  def placeWeather(card: WeatherCard): Unit = {
    _weatherSlot = card :: _weatherSlot
  }

  /**
   * =====================
   * Equals Implementation
   * =====================
   */

  override def canEqual(that: Any): Boolean = that.isInstanceOf[Board]

  override def equals(obj: Any): Boolean = {
    if (canEqual(obj)) {
      val other = obj.asInstanceOf[Board]
      (this eq other) || (this.playerArmy == other.playerArmy &&
        this.computerArmy == other.computerArmy && this.WeatherSlot == other.WeatherSlot)
    }
    else {
      false
    }
  }
}
