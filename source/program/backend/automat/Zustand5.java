package program.backend.automat;

public class Zustand5 extends Zustand {

	private static Zustand5 z5;

	private Zustand5() {
		setEndzustand(false);
	}

	public static Zustand5 getZustand() {
		if (z5 == null) {
			z5 = new Zustand5();
		}
		return z5;
	}

	@Override
	public Zustand processChar(char c) {
		switch (c) {
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
			return Zustand6.getZustand();
		default:
			return ZustandFehler.getZustand();
		}
	}
}