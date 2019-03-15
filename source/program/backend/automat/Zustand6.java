package program.backend.automat;

public class Zustand6 extends Zustand {

	private static Zustand6 z6;

	private Zustand6() {
		setEndzustand(false);
	}

	public static Zustand6 getZustand() {
		if (z6 == null) {
			z6 = new Zustand6();
		}
		return z6;
	}

	@Override
	public Zustand processChar(char c) {
		if (Character.isDigit(c)) {
			return Zustand7.getZustand();
		}
		return ZustandFehler.getZustand();
	}

}
