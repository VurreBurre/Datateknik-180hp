package textproc;

import java.util.*;
import java.util.Map.Entry;
public class WordCountComparator implements Comparator<Map.Entry<String,Integer>> {

	public WordCountComparator() {
			
	
	}

	@Override
	public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
			/*if (o1.getValue() == o2.getValue() ) {
				
				for (int i = 0; i<o1.getKey().length(); i++) {
					if(o1.getKey().charAt(i) > o2.getKey().charAt(i)) {
						return o1.getValue() - o2.getValue();
				}
				}
			}*/
			return o2.getValue() - o1.getValue();
	}

}
