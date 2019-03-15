package program.backend.automat;

public class Zustand4 extends Zustand {

	private static Zustand4 z4;

	private Zustand4() {
		setEndzustand(false);
	}

	public static Zustand4 getZustand() {
		if (z4 == null) {
			z4 = new Zustand4();
		}
		return z4;
	}

	@Override
	public Zustand processChar(char c) {
		if (c == ':') {
			return Zustand5.getZustand();
		}
		return ZustandFehler.getZustand();
	}

}
