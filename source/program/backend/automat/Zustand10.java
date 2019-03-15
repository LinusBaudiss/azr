package program.backend.automat;

public class Zustand10 extends Zustand {

	private static Zustand10 z10;

	private Zustand10() {
		setEndzustand(false);
	}

	public static Zustand10 getZustand() {
		if (z10 == null) {
			z10 = new Zustand10();
		}
		return z10;
	}

	@Override
	public Zustand processChar(char c) {
		if (c == '0') {
			return Zustand7.getZustand();
		}
		return ZustandFehler.getZustand();
	}

}
