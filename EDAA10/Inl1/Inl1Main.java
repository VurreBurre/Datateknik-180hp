package inl1;
import se.lth.cs.p.inl1.*;
import se.lth.cs.p.inl1.nbr2.*;

public class Inl1Main {

	public static void main(String[] args) {
		Key key = new Key();
		Decryptographer  d = new Decryptographer(key);
		StringBuilder sb = new StringBuilder();

		
		
		TestCase test = new TestCase();
		
		String crypt1 = test.getCryptoText(1);
		
		String clear1 = test.getClearText(1);
		
		String crypt2 = test.getCryptoText(2);
		String clear2 = test.getClearText(2);
		
		String crypt3 = test.getCryptoText(3);
		String clear3 = test.getClearText(3);
		
		String crypt4 = test.getCryptoText(4);
		String clear4 = test.getClearText(4);
		
		String crypt5 = test.getCryptoText(5);
		String clear5 = test.getClearText(5);
		
		
		
		
		
		TextWindow w = new TextWindow("Window");
		TextView tw = new TextView("Chiffertext", 10,50);
		w.addView(tw);
		TextWindow ww = new TextWindow("Window");
		TextView tww = new TextView("Min klartext", 10,50);
		w.addView(tww);
		TextWindow www = new TextWindow("Window");
		TextView twww = new TextView("Korrekt klartext", 10,50);
		w.addView(twww);
			
		
		
		
		
		
		
		
		String r = d.decrypt(crypt1);
		tw.displayText(crypt1);
		tww.displayText(r);
		twww.displayText(clear1);
		
		
		w.waitForMouseClick();
		String r2 = d.decrypt(crypt2);
		tw.displayText(crypt2);
		tww.displayText(r2);
		twww.displayText(clear2);
		
		w.waitForMouseClick();
		String r3 = d.decrypt(crypt3);
		tw.displayText(crypt3);
		tww.displayText(r3);
		twww.displayText(clear3);
		
		w.waitForMouseClick();
		String r4 = d.decrypt(crypt4);
		tw.displayText(crypt4);
		tww.displayText(r4);
		twww.displayText(clear4);
		
		w.waitForMouseClick();
		String r5 = d.decrypt(crypt5);
		tw.displayText(crypt5);
		tww.displayText(r5);
		twww.displayText(clear5);
		
		
	}


	

}
