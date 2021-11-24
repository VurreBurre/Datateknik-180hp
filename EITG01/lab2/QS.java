import java.util.*;
import java.io.*;


class QS extends Proc implements Comparable<QS>{
	public int numberInQueue = 0, accumulated, noMeasurements;
	public Proc sendTo;
	Random slump = new Random();
	public int summa;

	public void TreatSignal(Signal x){
		switch (x.signalType){

			case ARRIVAL:{
				numberInQueue++;
				if (numberInQueue == 1){
					SignalList.SendSignal(READY,this, time + 0.2*slump.nextDouble());
				}
			} break;

			case READY:{
				numberInQueue--;
				if (sendTo != null){
					SignalList.SendSignal(ARRIVAL, sendTo, time);
				}
				if (numberInQueue > 0){
					SignalList.SendSignal(READY, this, time + 0.2*slump.nextDouble());
					summa++;
				}
			} break;

			case MEASURE:{
				noMeasurements++;
				accumulated = accumulated + numberInQueue;
				SignalList.SendSignal(MEASURE, this, time + 2*slump.nextDouble());
			} break;
		}
	}


	@Override
	public int compareTo(QS o) {
		return this.numberInQueue - o.numberInQueue;
	}
}