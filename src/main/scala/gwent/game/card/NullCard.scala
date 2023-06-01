package cl.uchile.dcc
package gwent.game.card
import gwent.game.board.Board

/**
 * Represents a null card in the game. Null card don't do anything an can me used to mark certain states.
 * @param _name some name for the null card.
 */
class NullCard(val _name: String = "") extends Card with Equals {

  /**
   * ======
   * Getter
   * ======
   */
  override def name: String = _name

  /**
   * Method defined for the trait, doesn't do anything.
   * @param board the board where the card is going to be placed.
   */
  override def placeOnComputer(board: Board): Unit = {}

  /**
   * Method defined for the trait, doesn't do anything.
   * @param board the board where the card is going to be placed.
   */
  override def placeOnPlayer(board: Board): Unit = {}

  
  override def canEqual(that: Any): Boolean = that.isInstanceOf[NullCard]

  /**
   * All null cards are the equal.
   * @param obj the other object.
   * @return True if objects are the same.
   */
  override def equals(obj: Any): Boolean = {
    if (canEqual(obj)) {
      true
    }
    else {
      false
    }
  }
}
