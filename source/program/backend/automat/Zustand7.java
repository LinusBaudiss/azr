package program.backend.automat;

public class Zustand7 extends Zustand {

	private static Zustand7 z7;

	private Zustand7() {
		setEndzustand(true);
	}

	public static Zustand7 getZustand() {
		if (z7 == null) {
			z7 = new Zustand7();
		}
		return z7;
	}

	@Override
	public Zustand processChar(char c) {
		return ZustandFehler.getZustand();
	}

}
