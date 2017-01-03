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
	public State getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(State state) {
		this.state = state;
	}

	/**
	 * @return the tableau
	 */
	public Tableau getTableau() {
		return tableau;
	}
}
