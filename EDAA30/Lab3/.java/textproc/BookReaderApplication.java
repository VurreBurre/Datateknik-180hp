package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class BookReaderApplication {
	

	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
            "halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
            "södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
            "öland", "östergötland" };
	

	public static void main(String[] args) throws FileNotFoundException {
		long t0 = System.nanoTime();
		List<TextProcessor> lista = new ArrayList<>();
		
		
		Set<String> stopwords = new HashSet<>();
		//TextProcessor p = new SingleWordCounter("nils");
		//TextProcessor q = new SingleWordCounter("norge");
		//TextProcessor Multi = new MultiWordCounter(REGIONS);
		//TextProcessor r = new GeneralWordCounter(stopwords);
		//lista.add(p);
		//lista.add(q);
		//lista.add(Multi);
		//lista.add(r);
		GeneralWordCounter counter = new GeneralWordCounter(stopwords);
		lista.add(counter);
		
		


		for (int i = 0; i < lista.size(); i++) {
			Scanner s = new Scanner(new File("nilsholg.txt"));
			Scanner scan = new Scanner(new File("undantagsord.txt"));
			s.findWithinHorizon("\uFEFF", 1);
			s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning
			scan.findWithinHorizon("\uFEFF", 1);
			scan.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+");
			
		while (s.hasNext()) {
			String word = s.next().toLowerCase();
			
			lista.get(i).process(word);
			
		}
		while (scan.hasNext()) {
			String word2 = scan.next().toLowerCase();
			stopwords.add(word2);
		}
		scan.close();
		s.close();

		lista.get(i).report();
		}
		
		long t1 = System.nanoTime();
		System.out.println("tid: " + (t1 -t0) / 1000000.0 + " ms");
		
		BookReaderController controller = new BookReaderController(counter);

	}

}
