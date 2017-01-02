/**
 * 
 */
package es.upm.miw.models;

/**
 * @author FCL
 *
 */
public class Game {
	private State state;
	private Tableau tableau;

	/**
	 * 
	 */
	protected Game() {
		this.state = State.INITIAL;
		this.tableau = new Tableau();
	}

	/**
	 * @return the state
	 */
	protected State getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	protected void setState(State state) {
		this.state = state;
	}

	/**
	 * @return the tableau
	 */
	protected Tableau getTableau() {
		return tableau;
	}
}
