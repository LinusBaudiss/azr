package test.backend.automat;

import static org.junit.Assert.*;

import org.junit.Test;

import program.backend.Logic;
import program.exceptions.StartTimeInTheFutureException;
import program.exceptions.StartTimeNotPossibleException;
import program.exceptions.TimeFailureException;

public class LogicTest {

	@Test
	public void test01() throws TimeFailureException, StartTimeNotPossibleException, StartTimeInTheFutureException {
		Logic testLogic = new Logic("6:00");
		assertEquals("14:45", testLogic.calculateTimePauseInclusive(8));
	}

	@Test(expected = TimeFailureException.class)
	public void test02() throws TimeFailureException, StartTimeNotPossibleException, StartTimeInTheFutureException {
		Logic testLogic = new Logic("12:00");
		testLogic.calculateTimePauseInclusive(8);
	}

	@Test
	public void test03() throws TimeFailureException, StartTimeNotPossibleException, StartTimeInTheFutureException {
		Logic testLogic = new Logic("11:15");
		assertEquals("20:00", testLogic.calculateTimePauseInclusive(8));
	}

	/*
	 * Pausen Berechnungs Tests
	 */
	@Test
	public void test08() throws StartTimeNotPossibleException, StartTimeInTheFutureException {
		Logic testLogic = new Logic("6:00");
		int presenz = 0;
		assertEquals(0, testLogic.calculatePause(presenz));
	}

	@Test
	public void test09() throws StartTimeNotPossibleException, StartTimeInTheFutureException {
		Logic testLogic = new Logic("6:00");
		int presenz = 1 * 60;
		assertEquals(0, testLogic.calculatePause(presenz));
	}

	@Test
	public void test10() throws StartTimeNotPossibleException, StartTimeInTheFutureException {
		Logic testLogic = new Logic("6:00");
		int presenz = 2 * 60;
		assertEquals(0, testLogic.calculatePause(presenz));
	}

	@Test
	public void test11() throws StartTimeNotPossibleException, StartTimeInTheFutureException {
		Logic testLogic = new Logic("6:00");
		int presenz = 2 * 60 + 1;
		assertEquals(1, testLogic.calculatePause(presenz));
	}

	@Test
	public void test12() throws StartTimeNotPossibleException, StartTimeInTheFutureException {
		Logic testLogic = new Logic("6:00");
		int presenz = 2 * 60 + 10;
		assertEquals(10, testLogic.calculatePause(presenz));
	}

	@Test
	public void test13() throws StartTimeNotPossibleException, StartTimeInTheFutureException {
		Logic testLogic = new Logic("6:00");
		int presenz = 2 * 60 + 14;
		assertEquals(14, testLogic.calculatePause(presenz));
	}

	@Test
	public void test14() throws StartTimeNotPossibleException, StartTimeInTheFutureException {
		Logic testLogic = new Logic("6:00");
		int presenz = 2 * 60 + 15;
		assertEquals(15, testLogic.calculatePause(presenz));
	}

	@Test
	public void test15() throws StartTimeNotPossibleException, StartTimeInTheFutureException {
		Logic testLogic = new Logic("6:00");
		int presenz = 4 * 60 + 45;
		assertEquals(15, testLogic.calculatePause(presenz));
	}

	@Test
	public void test16() throws StartTimeNotPossibleException, StartTimeInTheFutureException {
		Logic testLogic = new Logic("6:00");
		int presenz = 4 * 60 + 46;
		assertEquals(16, testLogic.calculatePause(presenz));
	}
	
	@Test
	public void test17() throws StartTimeNotPossibleException, StartTimeInTheFutureException {
		Logic testLogic = new Logic("6:00");
		int presenz = 4 * 60 + 53;
		assertEquals(23, testLogic.calculatePause(presenz));
	}

	@Test
	public void test18() throws StartTimeNotPossibleException, StartTimeInTheFutureException {
		Logic testLogic = new Logic("6:00");
		int presenz = 4 * 60 + 59;
		assertEquals(29, testLogic.calculatePause(presenz));
	}

	@Test
	public void test19() throws StartTimeNotPossibleException, StartTimeInTheFutureException {
		Logic testLogic = new Logic("6:00");
		int presenz = 5 * 60;
		assertEquals(30, testLogic.calculatePause(presenz));
	}

	@Test
	public void test20() throws StartTimeNotPossibleException, StartTimeInTheFutureException {
		Logic testLogic = new Logic("6:00");
		int presenz = 6 * 60 + 30;
		assertEquals(30, testLogic.calculatePause(presenz));
	}

	@Test
	public void test21() throws StartTimeNotPossibleException, StartTimeInTheFutureException {
		Logic testLogic = new Logic("6:00");
		int presenz = 6 * 60 + 31;
		assertEquals(31, testLogic.calculatePause(presenz));
	}

	@Test
	public void test22() throws StartTimeNotPossibleException, StartTimeInTheFutureException {
		Logic testLogic = new Logic("6:00");
		int presenz = 6 * 60 + 40;
		assertEquals(40, testLogic.calculatePause(presenz));
	}

	@Test
	public void test23() throws StartTimeNotPossibleException, StartTimeInTheFutureException {
		Logic testLogic = new Logic("6:00");
		int presenz = 6 * 60 + 44;
		assertEquals(44, testLogic.calculatePause(presenz));
	}

	@Test
	public void test24() throws StartTimeNotPossibleException, StartTimeInTheFutureException {
		Logic testLogic = new Logic("6:00");
		int presenz = 6 * 60 + 45;
		assertEquals(45, testLogic.calculatePause(presenz));
	}

	@Test
	public void test25() throws StartTimeNotPossibleException, StartTimeInTheFutureException {
		Logic testLogic = new Logic("6:00");
		int presenz = 8 * 60;
		assertEquals(45, testLogic.calculatePause(presenz));
	}

	@Test
	public void test26() throws StartTimeNotPossibleException, StartTimeInTheFutureException {
		Logic testLogic = new Logic("6:00");
		int presenz = 10 * 60;
		assertEquals(45, testLogic.calculatePause(presenz));
	}

}
