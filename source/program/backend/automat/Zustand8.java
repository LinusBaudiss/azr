package program.backend.automat;

public class Zustand8 extends Zustand {

	private static Zustand8 z8;

	private Zustand8() {
		setEndzustand(false);
	}

	public static Zustand8 getZustand() {
		if (z8 == null) {
			z8 = new Zustand8();
		}
		return z8;
	}

	@Override
	public Zustand processChar(char c) {
		if (c == ':') {
			return Zustand9.getZustand();
		}
		return ZustandFehler.getZustand();
	}

}
