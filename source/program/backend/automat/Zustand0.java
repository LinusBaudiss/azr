package program.backend.automat;

public class Zustand0 extends Zustand {

	private static Zustand0 z0;

	private Zustand0() {
		setEndzustand(false);

	}

	public static Zustand0 getZustand() {
		if (z0 == null) {
			z0 = new Zustand0();
		}
		return z0;
	}

	@Override
	public Zustand processChar(char c) {
		switch (c) {
		case '0':
			return Zustand1.getZustand();
		case '1':
			return Zustand2.getZustand();
		case '2':
			return Zustand3.getZustand();
		case '6':
		case '7':
		case '8':
		case '9':
			return Zustand4.getZustand();
		default:
			return ZustandFehler.getZustand();
		}
		
	}

}
