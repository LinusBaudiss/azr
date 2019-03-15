package program.backend.automat;

public class Zustand2 extends Zustand {

	private static Zustand2 z2;

	private Zustand2() {
		setEndzustand(false);
	}

	public static Zustand2 getZustand() {
		if (z2 == null) {
			z2 = new Zustand2();
		}
		return z2;
	}

	@Override
	public Zustand processChar(char c) {
		if (Character.isDigit(c)) {
			return Zustand4.getZustand();
		}
		return ZustandFehler.getZustand();
	}

}
