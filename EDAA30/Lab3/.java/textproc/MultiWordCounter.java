package textproc;

import java.util.HashMap;
import java.util.Map;

public class MultiWordCounter implements TextProcessor{
	private Map<String, Integer> mappen;
	
	
	public MultiWordCounter(String[] landskap) {
		mappen = new HashMap<String, Integer>();
		for (int i = 0; i < landskap.length; i++) {
			
		mappen.put(landskap[i], 0);
		
		}
	}

	@Override
	public void process(String w) {	
	
			if (mappen.containsKey(w)) {
				mappen.replace(w,mappen.get(w) +1);
				
			}
			
		
		
	}

	@Override
	public void report() {
		for (String key : mappen.keySet()) {
			
		
		System.out.println("Landskap " + key + " " + mappen.get(key));
		
	}
	}

}
