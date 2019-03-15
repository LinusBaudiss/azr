package program.backend.automat;

public class TimeAutomat {

	private Zustand currentZustand;
	private String inputTime;
	
	public TimeAutomat(String input){
		setInputTime(input);
		setCurrentZustand(Zustand0.getZustand());
	}
	
	public boolean testTime(){
		for(int i = 0; i < inputTime.length(); i++){
			currentZustand = currentZustand.processChar(inputTime.charAt(i));
		}
		return currentZustand.isEndzustand();
	}

	public Zustand getCurrentZustand() {
		return currentZustand;
	}

	public void setCurrentZustand(Zustand z) {
		this.currentZustand = z;
	}

	public String getInputTime() {
		return inputTime;
	}

	public void setInputTime(String time) {
		this.inputTime = time;
	}
	
}
