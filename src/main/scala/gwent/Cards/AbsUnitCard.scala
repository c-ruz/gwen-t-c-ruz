package cl.uchile.dcc
package gwent.Cards

import gwent.Cards.Card

/**
 * Represents a unit card in the game. this class DOESN'T exist in the actual game, is only to represent common
 * behaviors between all units cards.
 *
 * @param name The name of the character in the card
 * @param str The strength value of the card
 */
abstract class AbsUnitCard(val name: String, var str: Int) extends Card {
}
