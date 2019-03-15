package program.backend.automat;

public class Zustand3 extends Zustand {

	private static Zustand3 z3;

	private Zustand3() {
		setEndzustand(false);
	}

	public static Zustand3 getZustand() {
		if (z3 == null) {
			z3 = new Zustand3();
		}
		return z3;
	}

	@Override
	public Zustand processChar(char c) {
		if (c == '0') {
			return Zustand8.getZustand();
		}
		return ZustandFehler.getZustand();
	}

}
