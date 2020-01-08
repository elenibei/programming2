import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author HP
 *
 */
public class Menu {

	static Scanner v = new Scanner(System.in);
	static JFrame fr;
	
	public static String chooseService() {
		String eidikotita;
		/*System.out.println("Παρακαλώ επιλέξτε υπηρεσία");
		System.out.println();
		for (int i = 0; i < 22; i++) {
			System.out.println(Services.eidikotites.get(i));
		}*/
		 StringBuilder text = new StringBuilder();
		 text.append("Παρακαλώ επιλέξτε υπηρεσία:"+"\r\n");
		 for (int i = 0; i < 22; i++) {
			text.append(Services.eidikotites.get(i)+"\r\n");
		 }
	     /*eidikotita=JOptionPane.showInputDialog(fr,text.toString());*/
		
		
		if (Client.numOfClients == 1) {
			eidikotita=JOptionPane.showInputDialog(fr,text.toString());
		} else {
			eidikotita=JOptionPane.showInputDialog(fr,text.toString());
		}
		return eidikotita;
	}

	
	public static String chooseCriterion() {
		/*System.out.println("Παρακαλώ επιλέξτε με τι κριτήρια θέλετε να γίνει η καταχώρηση του ραντεβού");*/
		boolean flag = true;
		String ans = null;
		while (flag) {
			ans=JOptionPane.showInputDialog(fr,"Παρακαλώ επιλέξτε με τι κριτήρια θέλετε να γίνει η καταχώρηση του ραντεβού"
					+"\r\n  1.Βάση Ημερομηνίας"
					+"\r\n 2.Βάση γιατρού και ημερομηνίας");
			/*System.out.println(" 1.Βάση Ημερομηνίας \n 2.Βάση γιατρού και ημερομηνίας");
			ans = v.next();*/
			if (!(ans.contains("1") || ans.contains("2"))) {
				flag = true;
			} else {
				flag = false;
			}
		}
		return ans;
	}

	
	
	public static boolean filterAndPrintServices(String search, String eidikotita) { 	// έχει την επιλογή να αναζητήσει
																						// μόνος του
																						// τις επιμέρους
																						// εξετάσεις-υπηρεσίες

		// eidikotita = εκείνη η κατηγορία εξετάσεων που επέλεξε ο πελάτης
		boolean flag = true;
		boolean exists = false;
		String exetasi_se_lista;// το όνομα της επιμέρους εξέτασης που βρίσκεται στα αρχεία μας
		ArrayList<String> exetaseis_list = new ArrayList<String>(); // οι απαντήσεις του προγράμματος σε σχέση με την
																	// αναζήτηση του πελάτη
		if (search.contains("ΟΛΕΣ")) {

			for (int a = 0; a < 22; a++) {
				if (eidikotita.toLowerCase().contains(Services.eidikotites.get(a))) {
					int size = Services.eidikotitesoles.get(a).size();
					/*for (int r = 0; r < size ; r++) {
						System.out.println(Services.eidikotitesoles.get(a).get(r).getName());
						exists = true;
					}
					break;*/
					 StringBuilder text = new StringBuilder();
					 text.append("Επιλέξτε την εξέταση που επιθυμείτε! \n(θα την εισάγετε στο επόμενο παράθυρο) \n\r\n");
					 for (int r = 0; r < size ; r++) {
						text.append("-" + Services.eidikotitesoles.get(a).get(r).getName() + "\r\n");
						exists = true;
					 }
				     JOptionPane.showMessageDialog(fr,text.toString());
				     break;
				}
				
			}
			
		} else {
			for (int y = 0; y < 22; y++) { 

				if (eidikotita.toLowerCase().contains(Services.eidikotites.get(y))) {

					for (int i = 0; i < Services.eidikotitesoles.get(y).size(); i++) {
						exetasi_se_lista = Services.eidikotitesoles.get(y).get(i).getName();

						if (exetasi_se_lista.toLowerCase().contains(search.toLowerCase())) {
							exetaseis_list.add(exetasi_se_lista);
							exists = true;
						}
					}
					if (exists == false) {
						JOptionPane.showMessageDialog(fr,"Δεν υπάρχει τέτοια εξέταση");
						flag = false;
					} else {
						/*System.out.println("Επιλέξτε την εξέταση που επιθυμείτε");
						for (int k = 0; k < exetaseis_list.size(); k++) {
							System.out.println(exetaseis_list.get(k));
						}*/
						 StringBuilder text = new StringBuilder();
						 text.append("Επιλέξτε την εξέταση που επιθυμείτε! \n(θα την εισάγετε στο επόμενο παράθυρο) \n\r\n");
						 for (int k = 0; k < exetaseis_list.size(); k++) {
							text.append("-" + exetaseis_list.get(k) + "\r\n");
							exists = true;
						 }
					     JOptionPane.showMessageDialog(fr,text.toString());
					}

					break; // βρήκες την κατηγορία των εξετάσεων που επιθυμεί να κάνει, άρα φεύγες απο το
							// for που
							// ψάχνει στα ονόματα κατηγοριών
				}
			}
		}
		return flag;
	}

	//--------------------------------------------------------
	//--------------METHODS FOR SUMS(STATISTICS)--------------
	
	static int sum_categories[] = new int[22]; // services' names

	public static void sumPlus(String category) {// WHEN ADDING

		for (int i = 0; i < Services.eidikotites.size(); i++) {

			if (Services.eidikotites.get(i).equals(category)) {
				sum_categories[i]++; // sum of category
			}
		}
	}

	public static void sumMinus(String category) {// WHEN REDUCING

		for (int i = 0; i < Services.eidikotites.size(); i++) {

			if (Services.eidikotites.get(i).equals(category)) {
				sum_categories[i]--; // sum of category
			}
		}
	}
	
	

}

