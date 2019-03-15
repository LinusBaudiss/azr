package test.backend.automat;

import static org.junit.Assert.*;

import program.backend.automat.TimeAutomat;

public class TestTimeAutomat {

	@org.junit.Test
	public void test01() {
		TimeAutomat testAutomat = new TimeAutomat("6:00");
		assertTrue(testAutomat.testTime());
	}

	@org.junit.Test
	public void test02() {
		TimeAutomat testAutomat = new TimeAutomat("06:00");
		assertTrue(testAutomat.testTime());
	}

	@org.junit.Test
	public void test03() {
		TimeAutomat testAutomat = new TimeAutomat("20:00");
		assertTrue(testAutomat.testTime());
	}

	@org.junit.Test
	public void test04() {
		TimeAutomat testAutomat = new TimeAutomat("13:49");
		assertTrue(testAutomat.testTime());
	}

	@org.junit.Test
	public void test05() {
		TimeAutomat testAutomat = new TimeAutomat("9:18");
		assertTrue(testAutomat.testTime());
	}

	@org.junit.Test
	public void test06() {
		TimeAutomat testAutomat = new TimeAutomat("5:59");
		assertFalse(testAutomat.testTime());
	}

	@org.junit.Test
	public void test07() {
		TimeAutomat testAutomat = new TimeAutomat("03:00");
		assertFalse(testAutomat.testTime());
	}

	@org.junit.Test
	public void test08() {
		TimeAutomat testAutomat = new TimeAutomat("20:01");
		assertFalse(testAutomat.testTime());
	}

	@org.junit.Test
	public void test09() {
		TimeAutomat testAutomat = new TimeAutomat("13:79");
		assertFalse(testAutomat.testTime());
	}

	@org.junit.Test
	public void test10() {
		TimeAutomat testAutomat = new TimeAutomat("39:18");
		assertFalse(testAutomat.testTime());
	}

	@org.junit.Test
	public void test11() {
		TimeAutomat testAutomat = new TimeAutomat("xyz");
		assertFalse(testAutomat.testTime());
	}

	@org.junit.Test
	public void test12() {
		TimeAutomat testAutomat = new TimeAutomat("ah:gt");
		assertFalse(testAutomat.testTime());
	}

	@org.junit.Test
	public void test13() {
		TimeAutomat testAutomat = new TimeAutomat("38789");
		assertFalse(testAutomat.testTime());
	}

	@org.junit.Test
	public void test14() {
		TimeAutomat testAutomat = new TimeAutomat("4:30");
		assertFalse(testAutomat.testTime());
	}

	@org.junit.Test
	public void test15() {
		TimeAutomat testAutomat = new TimeAutomat("09:89");
		assertFalse(testAutomat.testTime());
	}

}
