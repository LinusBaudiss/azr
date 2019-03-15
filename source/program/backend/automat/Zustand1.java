package program.backend.automat;

public class Zustand1 extends Zustand {

	private static Zustand1 z1;

	private Zustand1() {
		setEndzustand(false);
	}

	public static Zustand1 getZustand() {
		if (z1 == null) {
			z1 = new Zustand1();
		}
		return z1;
	}

	@Override
	public Zustand processChar(char c) {
		switch (c) {
		case '6':
		case '7':
		case '8':
		case '9':
			return Zustand4.getZustand();
		}
		return ZustandFehler.getZustand();
	}

}
