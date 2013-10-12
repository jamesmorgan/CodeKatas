import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class BasicCountdownClockUnitTest {

	//@formatter:off
	//
	//	https://sites.google.com/site/tddproblems/all-problems-1/Reload-countdown
	//
	//	In many games, the logic of firing your gun is as follows:
	//		 
	//	    When the gun is loaded, pressing the fire key fires the gun
	//	    During a certain time period, the gun is "reloading", so re-pressing the fire key has no effect (other than maybe making a 'clicking' sound)
	//	    After the time period has passed, the gun may be fired again (assuming infinite-ammo..)
	//
	//	After giving that logic some thought, one idea is having a "Countdown clock" acting as the reload mechanism.
	//	 
	//	Create a helper class called Countdown with operations:
	//
	//	    Stopped() - true if the countdown has stopped. This is the initial state
	//	    Start(seconds) - set the countdown to seconds, therefore Stopped() will return false
	//	    Decrease(seconds) - decrease the countdown. If time reaches (or passes!) zero, Stopped() will return true again
	//	
	//		When developing the class, think about names. What names feel most "natural" when testing? Feel free to choose other 
	//		names than Stopped, Start and Decrease, if those feel awkward when testing the class.
	//@formatter:on

	private Countdown countdown;

	@Before
	public void setUp() {
		this.countdown = new CountdownClock();
	}

	@Test
	public void testCountdownClock() {
		this.countdown.start(10);
		assertThat(this.countdown.stopped(), is(false));
		this.countdown.decrease(10);
		assertThat(this.countdown.stopped(), is(true));
	}

	@Test
	public void testAll() {
		//
		this.countdown.start(10);
		assertThat(this.countdown.stopped(), is(false));
		this.countdown.reset();
		assertThat(this.countdown.stopped(), is(true));
		this.countdown.start(10);
		assertThat(this.countdown.stopped(), is(false));
		this.countdown.start(15);
		assertThat(this.countdown.stopped(), is(false));
		this.countdown.decrease(20);
		assertThat(this.countdown.stopped(), is(false));
		this.countdown.decrease(5);
		assertThat(this.countdown.stopped(), is(true));

		//
		this.countdown.reset();
		assertThat(this.countdown.stopped(), is(true));
		this.countdown.start(0);
		assertThat(this.countdown.stopped(), is(true));

	}
}
