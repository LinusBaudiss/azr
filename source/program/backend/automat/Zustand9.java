package program.backend.automat;

public class Zustand9 extends Zustand {

	private static Zustand9 z9;

	private Zustand9() {
		setEndzustand(false);
	}

	public static Zustand9 getZustand() {
		if (z9 == null) {
			z9 = new Zustand9();
		}
		return z9;
	}

	@Override
	public Zustand processChar(char c) {
		if (c == '0') {
			return Zustand10.getZustand();
		}
		return ZustandFehler.getZustand();
	}

}
