import javax.swing.JOptionPane;
import java.io.File;
import javax.swing.JPopupMenu;

public class inl2Main {

	public static void main(String[] args) {
		Dialog dialog = new Dialog();
		StringBuilder s = new StringBuilder();
		String List =null;

		
		
		
			
		
		Register reg = new Register();
		String menuItems = "Meny" + "\n" + "1: Sätt in en ny person" + "\n" + "2: Tag bort person(er)" + " \n"
				+ "3: Sök upp alla födelsedatum från namn/del av namn" + " \n" + "4: Sök namn från födelsedatum" + " \n"
				+ "5: Presentera alla personer sorterat efter namn" + " \n"
				+ "6: Presentera alla personer sorterat efter födelsedatum" + " \n" + "7: Spara registret på en fil" + " \n"
				+ "8: Läs registret från en fil" + " \n" + "9: EXIT";
		
		while(true) {
			
			int i = dialog.readInt(menuItems);
			
			switch (i) {
			case 1:
				
				String inNamn = dialog.readString("Skriv in ditt efternamn och förnamn");
				String inNbr = dialog.readString("Skriv in ditt personnummer (6 siffror)");
				Person p = new Person(inNamn, inNbr);
				reg.addPerson(p);
				
				List = reg.getReg();
				dialog.printString(List);
				
				break;
				
				
			case 2:
				
				String taBort  = dialog.readString("Skriv in del av namn som du vill ta bort");
				reg.casetwo(taBort);
				
				dialog.printString(reg.result());
				
				break;
				
			case 3:
				
				String h = dialog.readString("Skriv in ett namn som du vill kolla födelsedatum på");
				String svar = reg.casethree(h);
				
				dialog.printString(svar);
				
				
				
				break;
				
			case 4: 
				
				String a = dialog.readString("Skriv in födelsedatumet som personen du söker har");
				String result = reg.casefour(a);
				dialog.printString(result);
				

				break;
				
			case 5:
				String o = reg.getReg();
				dialog.printString(o);
				break;
				
			case 6: 
				
				String t = reg.caseSix();
				dialog.printString(t);
				
				
				
				break;
				
			case 7:
				
				reg.writeToFile("text.txt");
				break;
				
			case 8:
				reg.readFromFile("text.txt");
				reg.result();
				
				break;
				
			case 9:
				System.exit(1);
				

			default:
				break;
			}
			
		}

	/**	int i = dialog.readInt(menuItems);
		if ( i== 1) {//MENYVAL 1
			while (JOptionPane.showConfirmDialog(null, "Vill du lägga till fler i listan?") == 0) {
				String inNamn = dialog.readString("Skriv in ditt efternamn och förnamn");
				String inNbr = dialog.readString("Skriv in ditt personnummer (6 siffror)");
				Person p = new Person(inNamn, inNbr);
				reg.addPerson(p);
			}
			 List = reg.getReg();
			dialog.printString(List);
		}else if ( i==2) {//MENYVAL 2
			String taBort  = dialog.readString("Skriv in del av namn som du vill ta bort");
			reg.remove(taBort);
			
			
			dialog.printString(reg.result());
			
			
		}else if (i == 4) {//MENYVAL 4
			String a = dialog.readString("Skriv in födelsedatumet som personen du söker har");
			String result = reg.date(a);
			dialog.printString(result);
			List = reg.getReg();
			dialog.printString(reg.result());
			
			
		}else if (i==9) {
			System.exit(1);
		}
	}**/
	}
}
