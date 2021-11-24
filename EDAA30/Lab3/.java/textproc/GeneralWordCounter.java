package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;


public class GeneralWordCounter implements TextProcessor{
		private Map<String, Integer> counts;
		private Set<String> a;
		
	public GeneralWordCounter(Set<String> a) throws FileNotFoundException {
		this.a = a;
		counts = new HashMap<>();
		
	}

	@Override
	public void process(String w) {
		if (!a.contains(w)) {
			counts.put(w, counts.getOrDefault(w, 0) +1);
		}
		
	}
	public List<Map.Entry<String, Integer>> getWordList() {
		return new ArrayList<>(counts.entrySet());
	}


	@Override
	public void report() {
			/*for (String key : mappen.keySet()) {
				if (mappen.get(key)> 200) {
					System.out.println("ORD: " + key + " " + mappen.get(key));
					
					
				}
				*/
		
				Set<Map.Entry<String, Integer>> wordSet = counts.entrySet();
				List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordSet);
				wordList.sort((Comparator<? super Entry<String, Integer>>) new WordCountComparator());
				for (int i = 0; i < 5; i++) {
					System.out.println("ord: " + wordList.get(i));
				}
				
				
			}
		
	

}

