
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
		System.out.println("�������� �������� ��������");
		Services.listEidikotites();
		for (int i = 0; i < 22; i++) {
			// System.out.println(Services.eidikotitesoles.get(i).get(0).getCategory());
			System.out.println(Services.eidikotites.get(i));
		}
		String eidikotita = v.next();
		return eidikotita;
	}*/
	public static String chooseService() {
		try {
			//create a new frame  
	        f = new JFrame("frame"); 
	        
	        //create a panel 
	        JPanel p =new JPanel();
	        //String array to store services 
	        String services[]= { "�������������","�������������","���������������", 
	                         "������������","�������� �����������","����������","������������������",
	                         "��������������","�����","������������","�������������","���������� �����������",
	                         "������������","���������������","������������","���������","������������ �������",
	                         "��������","checkup","doppler","triplex","������"}; 
	        //create list 
	        b= new JList(services); 
	        
			
			message = new JTextField();
			message.setText("�������� �������� ��������:");
			message.setBounds(0, 0, 180, 22);
			f.getContentPane().add(message);
			message.setColumns(10);
	        //add list to panel 
	        p.add(b); 
	        f.getContentPane().add(p);
	        JButton btn = new JButton("��");
	        p.add(btn);
	        btn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent ae) {
					// TODO Auto-generated method stub
					/*System.out.println("���������� ��������:");*/
					int[]indices=b.getSelectedIndices();
					for (int i=0;i<indices.length;i++) {
						 /*System.out.println(services[indices[i]]);*/
						 eidikotita=services[indices[i]];
						 
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
     public static String chooseCriterion() {
    	
		/*System.out.println("�������� �������� �� �� �������� ������ �� ����� � ���������� ��� ��������");
		System.out.println(" 1.���� ����������� \n 2.���� ������� ��� �����������");
		String ans = v.next();
		return ans;
		*/
    	String ans=JOptionPane.showInputDialog(fr,"�������� �������� �� �� �������� ������ �� ����� � ���������� ��� ��������"
    			                         + "\r\n 1.���� �����������"
    			                         + "\r\n 2.���� ������� ��� �����������");
    
        return ans;   
    }
	
	public static boolean filterAndPrintServices(String search, String eidikotita) { 	// ���� ��� ������� �� ����������
																						// ����� ���
																						// ��� ���������
																						// ���������-���������

		// eidikotita = ������ � ��������� ��������� ��� ������� � �������
		boolean flag = true;
		boolean exists = false;
		String exetasi_se_lista;// �� ����� ��� ��������� �������� ��� ��������� ��� ������ ���
		ArrayList<String> exetaseis_list = new ArrayList<String>(); // �� ���������� ��� ������������ �� ����� �� ���
																	// ��������� ��� ������
		if (search.contains("����")) {

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
					    /*System.out.println("��� ������� ������ �������");*/
					    JOptionPane.showMessageDialog(fr1,"��� ������� ������ �������");
					    flag = false;
					} else {
						/*System.out.println("�������� ��� ������� ��� ����������");*/
						JOptionPane.showMessageDialog(fr2,"�������� ��� ������� ��� ����������");
						for (int k = 0; k < exetaseis_list.size(); k++) {
							JOptionPane.showMessageDialog(fr2,exetaseis_list.get(k));
						}
					}

					break; // ������ ��� ��������� ��� ��������� ��� �������� �� �����, ��� ������ ��� ��
							// for ���
							// ������ ��� ������� ����������
				}
			}
		}
		return flag;
	}

}


