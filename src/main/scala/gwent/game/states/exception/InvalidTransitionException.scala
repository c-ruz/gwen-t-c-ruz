package cl.uchile.dcc
package gwent.game.states.exception

/**
 * Creates a custom exception for transitions done in the incorrect state.
 * @param message A string with the message to be displayed in the throw.
 */
class InvalidTransitionException(message: String) extends Exception(message){

}
