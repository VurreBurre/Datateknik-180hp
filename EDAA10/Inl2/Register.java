import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

public class Register {
	private ArrayList<Person> reg;

	private String listOfPeople;

	public Register() {

		reg = new ArrayList<Person>();

	}

	public void addPerson(Person p1) {

		int i = 0;

		while ((i < reg.size() && reg.get(i).getName().toLowerCase().compareTo(p1.getName().toLowerCase()) < 0)) {
			i++;

		}
		reg.add(i, p1);

	}

	public String getReg() {

		StringBuilder s = new StringBuilder();

		System.out.println(s.toString());
		for (int i = 0; i < reg.size(); i++) {

			Person p = reg.get(i);
			String namee = p.getName();
			s.append(namee + "\n");
			String pnbr = p.getDate();
			s.append(pnbr + "\n");

		}
		System.out.println(s.toString());

		return s.toString();
	}

	public void casetwo(String s) {
		s.toLowerCase();
		for (int j = 0; j < reg.size(); j++) {

			while (reg.get(j).getName().toLowerCase().indexOf(s) >= 0) {

				reg.remove(j);
			}
		}

	}

	public String casefour(String s) {
		int b = 0;
		StringBuilder a = new StringBuilder();

		for (int i = 0; i < reg.size(); i++) {
			if (reg.get(i).getDate().indexOf(s) >= 0) {
				Person p = reg.get(i);
				String name = p.getName();
				a.append(name + "\n");
				String pnbr = p.getDate();
				a.append(pnbr + "\n");

				b++;

			}

		}
		if (b > 0) {
			return a.toString();
		} else {
			return "Inga namn med det personnummret";
		}

	}

	public String caseFive() {
		for (int i = 0; i < reg.size(); i++) {

		}
		return null;
	}
	
	public String caseSix() {
			
		
		
	int index =0;
		StringBuilder s = new StringBuilder();
		Boolean[] help= new Boolean[reg.size()];
		for (int j = 0; j < help.length; j++) {
			help[j] = false;
		}
		for (int i = 0; i < reg.size(); i++) {
			int min = Integer.MAX_VALUE;
			for (int k = 0; k < reg.size(); k++) {
				if (help[k] == false && Integer.parseInt(reg.get(k).getDate()) < min) {
					index = k;
					min = Integer.parseInt(reg.get(k).getDate());
				}
			}
			
			s.append(min + " ");
			s.append(reg.get(index).getName() +"\n");
			help[index] = true;
			
		}
		return s.toString();
		}
	
	
	

	public String casethree(String name) {
		int b = 0;
		StringBuilder d = new StringBuilder();

		for (int i = 0; i < reg.size(); i++) {
			if (reg.get(i).getName().indexOf(name) >= 0) {
				Person p = reg.get(i);
				String namee = p.getName();
				d.append(namee + "\n");
				String pnbr = p.getDate();
				d.append(pnbr + "\n");
				b++;

			}

		}
		if (b > 0) {
			return d.toString();
		} else {

			return "Inga personer med det namnet";
		}
	}

	public String result() {
		
		StringBuilder e = new StringBuilder();
		for (int i = 0; i < reg.size(); i++) {
			Person p = reg.get(i);
			String name = p.getName();
			e.append(name + "\n");
			String pnbr = p.getDate();
			e.append(pnbr + "\n");
			listOfPeople = e.toString();
			System.out.println(reg.get(i));

		}
		return listOfPeople;
	}

	public void readFromFile(String fileName) {
		Scanner scan = null;
		try {
			scan = new Scanner(new File(fileName));
			
		}catch (FileNotFoundException e) {
			System.out.println("Filen kunde inte öppnas");
			System.exit(1);
		}
		
		while (scan.hasNextLine()) {
			
	        
				
			
	        reg.add(new Person(scan.nextLine(), scan.nextLine()));
	       
		}
		
		scan.close();

	}

	public void writeToFile(String fileName) {

		PrintWriter out = null;
		try {
			out = new PrintWriter(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("Filen kunde inte öppnas");
			System.exit(1);
		}
		for (int i = 0; i < reg.size(); i++) {
			
		System.out.println("jag kom in");
		out.println(reg.get(i).getName());
		out.println(reg.get(i).getDate());
		out.flush();
		}
		
	}

}
