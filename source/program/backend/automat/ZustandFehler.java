package program.backend.automat;

public class ZustandFehler extends Zustand {

	private static ZustandFehler zF;

	private ZustandFehler() {
		setEndzustand(false);
	}

	public static ZustandFehler getZustand() {
		if(zF == null){
			zF = new ZustandFehler();
		}
		return zF;
	}
	
	@Override
	public Zustand processChar(char c) {
		return ZustandFehler.getZustand();
	}

}
