package program.backend;

import program.backend.automat.TimeAutomat;
import program.exceptions.StartTimeInTheFutureException;
import program.exceptions.StartTimeNotPossibleException;
import program.exceptions.TimeFailureException;

public class Logic {

	private TimeAutomat automat;
	private int minutesComing;
	private int minutesPresent;
	private int pause;

	public Logic(String time) throws StartTimeNotPossibleException, StartTimeInTheFutureException {
		automat = new TimeAutomat(time);
		if (!automat.testTime()) {
			throw new StartTimeNotPossibleException("Die Eingabe Zeit ist nicht möglich!");
		}
		if (isTimeInFuture(time)) {
			throw new StartTimeInTheFutureException(
					"Die Eingabe Zeit liegt in der Zukunft und ist deswegen nicht möglich!");
		}
		calculateMinutes(time);
	}

	public int timeStringToMinutes(String time) {
		String[] split = time.split(":");
		int h = Integer.parseInt(split[0]);
		int min = Integer.parseInt(split[1]);
		return h * 60 + min;
	}

	public void calculateMinutes(String time) {
		minutesComing = timeStringToMinutes(time);
		minutesPresent = 0;
		pause = 0;
	}

	public boolean isTimeInFuture(String time) {
		int inputMinutes = timeStringToMinutes(time);
		long actualTime = System.currentTimeMillis();
		int actualMinutes = (int) (actualTime / 1000 / 60 / 60 % 24 + 1) * 60 + (int) (actualTime / 1000 / 60 % 60);
		return actualMinutes < inputMinutes;
	}

	public String updateFlexTime(int h, int m) {
		int eightHours = 480; // 8 Stunden in Minuten
		int currentTime = h * 60 + m;
		minutesPresent = currentTime - minutesComing;
		pause = calculatePause(minutesPresent);
		return getTimeString(eightHours + pause - minutesPresent, true);
	}

	public int calculatePause(int minPresent) {
		if (minPresent > 120 && minPresent < 135) // 2:01h bis 2:14h
		{
			return minPresent - 120;
		}
		if (minPresent >= 135 && minPresent <= 285) // 2:15h bis 4:45h
		{
			return 15;
		}
		if (minPresent > 285 && minPresent < 300) // 4:46h bis 4:59h
		{
			return minPresent - 270;
		}
		if (minPresent >= 300 && minPresent <= 390) // 5:00h bis 6:30h
		{
			return 30;
		}
		if (minPresent > 390 && minPresent < 405) // 6:31h bis 6:44h
		{
			return minPresent - 360;
		}
		if (minPresent >= 405) // mehr als 6:45h
		{
			return 45;
		}
		return 0; // unter 2:00h
	}

	/*
	 * Exception String: Stunden Parameter - String der Zeit, die zu viel ist -
	 * String der Höchstarbeitszeit
	 */
	public String calculateTimePauseInclusive(int h) throws TimeFailureException {
		int maxWorkTimeInMinutes = 1200; // 20 Uhr
		int minutesToAdd = h * 60 + 45; // inklusive Pause
		int time = minutesComing + minutesToAdd;
		if (time > maxWorkTimeInMinutes) {
			int tooMuch = time - maxWorkTimeInMinutes;
			throw new TimeFailureException(h + "-" + getTimeString(tooMuch, false) + "-20:00");
		}
		return getTimeString(time, false);
	}

	public String getTimeString(int in, boolean flex) {
		if (flex && isTimeUp()) {
			in *= -1;
		}
		int h = in / 60;
		int min = in % 60;
		if (flex) {
			if (isTimeUp()) {
				return "+" + getTimeString(h, min);
			}
			return "-" + getTimeString(h, min);
		}
		return getTimeString(h, min);
	}

	public boolean isTimeUp() {
		return minutesPresent >= 525; // Schon 8:45h anwesend?
	}

	public String getTimeString(int h, int min) {
		if (min < 10) {
			return h + ":0" + min;
		}
		return h + ":" + min;
	}

}
