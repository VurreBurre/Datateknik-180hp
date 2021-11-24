package inl1;

import se.lth.cs.p.inl1.*;
import se.lth.cs.p.inl1.nbr2.*;

public class Decryptographer {

	Key key;

	public Decryptographer(Key key) {
		this.key = key;

	}

	public String decrypt(String text) {

		int text1 = text.length();
		StringBuilder sb = new StringBuilder();
		int utan = 0;
		for (int i = 0; i < text1; i++) {

			int skjut = key.getStart();
			char bok = text.charAt(i);
			int u = 0;
			int index;
			char bokstav;

			if ((bok == ' ')) {

				sb.append(bok);

			} else {

				for (int i1 = 0; i1 < 26; i1++) {
					if (key.getLetter(i1) == bok) {
						u = i1;
					}

				}

				int letter = (char) (u + 'A');

				letter -= (skjut + (utan++));

				System.out.println(letter);
				while (letter < 'A') {
					letter += 26;

				}

				System.out.println(letter);

				bokstav = (char) letter;
				sb.append(bokstav);
			}

		}
		String String = sb.toString();

		return String;
	}
}
