package cl.uchile.dcc
package gwent.game.board

import gwent.game.card.{MeleeCard, RangedCard, SiegeCard, WeatherCard}

class Board() {
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
   * initially empty, idk if that works
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
   * ========
   * Setters
   * ========
   */
  
  
  /**
   * ===============
   * Class methods
   * ===============
   */
  def placeWeather(card: WeatherCard): Unit = {
    _weatherSlot = card :: _weatherSlot 
  }
  
  





  

}
