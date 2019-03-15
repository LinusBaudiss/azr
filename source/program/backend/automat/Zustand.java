package program.backend.automat;

public abstract class Zustand {

	private boolean endzustand;

	public abstract Zustand processChar(char c);
	
	public boolean isEndzustand() {
		return endzustand;
	}

	public void setEndzustand(boolean b) {
		this.endzustand = b;
	}
	
}
