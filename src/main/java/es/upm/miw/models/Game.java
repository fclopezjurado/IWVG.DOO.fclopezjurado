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

	public Game() {
		this.state = State.INITIAL;
		this.tableau = new Tableau();
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Tableau getTableau() {
		return tableau;
	}
}
