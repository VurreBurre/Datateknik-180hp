import java.util.*;

class State extends GlobalSimulation{
	
	public int numberInQueue = 0, accumulated = 0, noMeasurements = 0, numberOfA =0, numberOfB =0;
	
	private EventList myEventList;

	Random slump = new Random();
	static int summa =0;
	int beskän =0;
	State(EventList x){
		myEventList = x;
	}
	
	private void InsertEvent(int event, double timeOfEvent){
		myEventList.InsertEvent(event, timeOfEvent);
	}
	
	
	public void TreatEvent(Event x){
	
		switch (x.eventType){
		
			case ARRIVALA:
				arrivalA();
				break;
			case READYA:
				readyA();
				break;
			case MEASURE:
				measure();
				break;
			case ARRIVALB:
				arrivalB();
			case READYB:
				readyB();
		}
	}
	
	private double generateMean(double mean){
		return 2*mean*slump.nextDouble();
	}
	
	private void arrivalA(){
		
		if (numberOfA == 0) {
			InsertEvent(READYA,time + 0.002);
		
		}
		numberOfA++;
		InsertEvent(ARRIVALA, time + generateMean(1f/150f)); // Ändras för att ändra lambda
	}
	
	private void arrivalB() {
		if (numberOfA == 0) {
			InsertEvent(READYB,time + 0.004);
			
			
		}
		numberOfB++;
	}
	
	private void readyA(){
		numberOfA--;
		
		if (numberOfA > 0) {
			InsertEvent(READYA, time + 0.002);
		InsertEvent(ARRIVALB, time +1);
		}
	}
	
	private void readyB() {
		numberOfB--;
		if (numberOfB > 0) {
			InsertEvent(READYB,time + 0.004);
		}
		
	}
	
	
	private void measure(){

		accumulated += + numberOfA + numberOfB;
		if (noMeasurements <1000) {

			noMeasurements++;
		}
		
		
		InsertEvent(MEASURE, time + 0.1);
	}
	 
}