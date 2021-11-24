import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

//Denna klass �rver Global s� att man kan anv�nda time och signalnamnen utan punktnotation


public class MainSimulation extends Global{

    public static void main(String[] args) throws IOException {

    	
    	
    	//Signallistan startas och actSignal deklareras. actSignal �r den senast utplockade signalen i huvudloopen nedan.

    	Signal actSignal;
    	new SignalList();

    	//H�r nedan skapas de processinstanser som beh�vs och parametrar i dem ges v�rden.
    	
    	QS Dispatcher = new QS();
    	QS Q1 = new QS();
    	QS Q2 = new QS();
    	QS Q3 = new QS();
    	QS Q4 = new QS();
    	QS Q5 = new QS();
    	Random rand = new Random();
    	int low = 0;
    	int high = 5;
    	
    	ArrayList<QS> list = new ArrayList<QS>();
    	list.add(Q1);
    	list.add(Q2);
    	list.add(Q3);
    	list.add(Q4);
    	list.add(Q5);
    	
    	
    	Q1.sendTo = null;
    	Q2.sendTo = null;
    	Q3.sendTo = null;
    	Q4.sendTo = null;
    	Q5.sendTo = null;
    	
    	
    	int result = rand.nextInt(high-low) + low;
    	double antal =0;
    	
    	
    	Gen Generator = new Gen();
    	Generator.lambda = 45; //Generator ska generera nio kunder per sekund
    	//Generator.sendTo = Dispatcher; //De genererade kunderna ska skickas till k�systemet QS
    	

    	//H�r nedan skickas de f�rsta signalerna f�r att simuleringen ska komma ig�ng.

    	SignalList.SendSignal(READY, Generator, time);
    	SignalList.SendSignal(MEASURE, Q1, time);
    	SignalList.SendSignal(MEASURE, Q2, time);
    	SignalList.SendSignal(MEASURE, Q3, time);
    	SignalList.SendSignal(MEASURE, Q4, time);
    	SignalList.SendSignal(MEASURE, Q5, time);

    	int count =0;
    	// Detta �r simuleringsloopen:
    	while (time < 100000){
    		actSignal = SignalList.FetchSignal();
    		time = actSignal.arrivalTime;
    		actSignal.destination.TreatSignal(actSignal);
    		//result = rand.nextInt(high-low) + low;
    		count++;
    		Generator.sendTo = list.get(count);
    		if (count == 4) {
    			count =-1;
    		}
			//}
    		//Collections.sort(list);
    		//Generator.sendTo = (list.get(0));
    		
    		
    	}
    	
    	antal = + 1.0*Q1.accumulated/Q1.noMeasurements + 1.0*Q2.accumulated/Q2.noMeasurements + 1.0*Q3.accumulated/Q3.noMeasurements + 1.0*Q4.accumulated/Q2.noMeasurements + 1.0*Q5.accumulated/Q3.noMeasurements;

    	//Slutligen skrivs resultatet av simuleringen ut nedan:
    	System.out.println("Betj�ningstiden " + Q1.summa/time);
    	System.out.println("Medelantal kunder i k�system: " + 1.0*Q1.accumulated/Q1.noMeasurements);
    	System.out.println("Medelantal kunder i k�system: " + 1.0*Q2.accumulated/Q2.noMeasurements);
    	System.out.println("Medelantal kunder i k�system: " + 1.0*Q3.accumulated/Q3.noMeasurements);
    	System.out.println("Medelantal kunder i k�system: " + 1.0*Q4.accumulated/Q2.noMeasurements);
    	System.out.println("Medelantal kunder i k�system: " + 1.0*Q5.accumulated/Q3.noMeasurements);
    	System.out.println("Antal i systemet: " + antal );

    }
}