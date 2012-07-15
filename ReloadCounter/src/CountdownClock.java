/**
 *
 */
public class CountdownClock implements Countdown {

	private State state;
	private int ticker;

	public CountdownClock() {
		this.state = State.STOPPED;
		this.ticker = 0;
	}

	public boolean stopped() {
		return this.state.equals(State.STOPPED);
	}

	public void start(final int seconds) {
		this.ticker += seconds;
		if ((this.ticker + seconds) > this.ticker) {
			this.state = State.STARTED;
		}
	}

	public void decrease(final int seconds) {
		this.ticker = this.ticker - seconds;
		if (this.ticker <= 0) {
			this.state = State.STOPPED;
		}
	}

	public void reset() {
		this.state = State.STOPPED;
		this.ticker = 0;
	}

	enum State {
		STARTED, STOPPED, RUNNING;
	}
}
