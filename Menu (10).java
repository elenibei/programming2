import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * @author HP
 *
 */
public class Menu {

	static Scanner v = new Scanner(System.in);
	private static JFrame f;
	private static JFrame fr;
	private static JFrame fr1;
	private static JFrame fr2;
	private static JFrame fr11;
    private static JList b;
    private static JTextField message;
    private static JTextField message2;
    public static String eidikotita;
    
    /*public static String chooseService() {
		String eidikotita;
		System.out.println("Παρακαλώ επιλέξτε υπηρεσία");
		System.out.println();
		for (int i = 0; i < 22; i++) {
			// System.out.println(Services.eidikotitesoles.get(i).get(0).getCategory());
			System.out.println(Services.eidikotites.get(i));
		}
		if (Client.numOfClients == 1) {
			eidikotita = v.nextLine();
		} else {
			v.nextLine();
			eidikotita = v.nextLine();
		}
		return eidikotita;
	}*/
	public static String chooseService() {
		try {
			//create a new frame  
	        f = new JFrame("frame"); 
	        
	        //create a panel 
	        JPanel p =new JPanel();
	        //String array to store services 
	        String services[]= { "Αιματολογικές","Ακτινογραφίες","Αλλεργιολογικές", 
	                         "Ανοσολογικές","Αξονικές Τομογραφίες","Βιοχημικές","Γαστρεντερολογικές",
	                         "Γυναικολογικές","Ούρων","Καλλιέργειες","Καρδιολογικές","Μαγνητικές Τομογραφίες",
	                         "Μαστογραφίες","Μικροβιολογικές","Νευρολογικές","Ορμονικές","Προγενητικός Έλεγχος",
	                         "Υπέρηχοι","checkup","doppler","triplex","πακέτα"}; 
	        //create list 
	        b= new JList(services); 
	        
			
			message = new JTextField();
			message.setText("Παρακαλώ επιλέξτε υπηρεσία:");
			message.setBounds(0, 0, 180, 22);
			f.getContentPane().add(message);
			message.setColumns(10);
	        //add list to panel 
	        p.add(b); 
	        f.getContentPane().add(p);
	        JButton btn = new JButton("οκ");
	        p.add(btn);
	        btn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent ae) {
					// TODO Auto-generated method stub
					/*System.out.println("Επιλεγμένη υπηρεσία:");*/
					int[]indices=b.getSelectedIndices();
					for (int i=0;i<indices.length;i++) {
						 /*System.out.println(services[indices[i]]);*/
						if (Client.numOfClients == 1) {
							eidikotita = services[indices[i]];
						} else {
							eidikotita = services[indices[i]];
						}
						 
					}
					System.exit(0);
				}
	       
	        }); 
	        
	        //set the size of frame 
	        f.setSize(700,600); 
	        f.show(); 
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eidikotita;
	}
	/*public static String chooseCriterion() {
	System.out.println("Παρακαλώ επιλέξτε με τι κριτήρια θέλετε να γίνει η καταχώρηση του ραντεβού");
	boolean flag = true;
	String ans = null;
	while (flag) {
		System.out.println(" 1.Βάση Ημερομηνίας \n 2.Βάση γιατρού και ημερομηνίας");
		ans = v.next();
		if (!(ans.contains("1") || ans.contains("2"))) {
			flag = true;
		} else {
			flag = false;
		}
	}
	return ans;
   }*/
     public static String chooseCriterion() {
    	boolean flag = true;
 		String ans = null;
 		while (flag) {
    	  ans=JOptionPane.showInputDialog(fr,"Παρακαλώ επιλέξτε με τι κριτήρια θέλετε να γίνει η καταχώρηση του ραντεβού"
    			                         + "\r\n 1.Βάση Ημερομηνίας"
    			                         + "\r\n 2.Βάση γιατρού και ημερομηνίας");
    
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
					for (int r = 0; r < size ; r++) {
						JOptionPane.showMessageDialog(fr11,Services.eidikotitesoles.get(a).get(r).getName());
						exists = true;
					}
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
					    /*System.out.println("Δεν υπάρχει τέτοια εξέταση");*/
					    JOptionPane.showMessageDialog(fr1,"Δεν υπάρχει τέτοια εξέταση");
					    flag = false;
					} else {
						/*System.out.println("Επιλέξτε την εξέταση που επιθυμείτε");*/
						JOptionPane.showMessageDialog(fr2,"Επιλέξτε την εξέταση που επιθυμείτε");
						for (int k = 0; k < exetaseis_list.size(); k++) {
							JOptionPane.showMessageDialog(fr2,exetaseis_list.get(k));
						}
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

			JOptionPane.showMessageDialog(fr11,Services.eidikotites.size());
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


