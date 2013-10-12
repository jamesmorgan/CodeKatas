public interface Countdown {

	boolean stopped();

	void start(int seconds);

	void decrease(int seconds);

	void reset();

}
