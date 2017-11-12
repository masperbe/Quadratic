import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class QuadraticCalc extends JFrame {

	private JPanel contentPane;
	private JTextField txtA;
	private JTextField txtB;
	private JTextField txtC;
	private JTextField txt1;
	private JTextField txt2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuadraticCalc frame = new QuadraticCalc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QuadraticCalc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(14,6,0,0));
		
		JLabel lblInstructions = new JLabel("Input the coefficients of the quadratic equation: Ax^2 + Bx + C = 0");
		lblInstructions.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel lblA = new JLabel("A:");
		txtA = new JTextField();
		JLabel lblB = new JLabel("B:");
		txtB = new JTextField();
		JLabel lblC = new JLabel("C:");
		txtC = new JTextField();
		JLabel lblBlank= new JLabel("");
		JButton btnCalc = new JButton("Calculate");
		JLabel lblBlank2 = new JLabel("");
		JLabel lblSol1 = new JLabel("1st Solution");
		txt1 = new JTextField();
		JLabel lblSol2 = new JLabel("2nd Solution");
		txt2 = new JTextField();
		
		btnCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				double a;
				double b;
				double c;
				try {
					a = Double.valueOf(txtA.getText());
					b = Double.valueOf(txtB.getText());
					c = Double.valueOf(txtC.getText());
					
					double det = (b*b)-(4*a*c);
					if (det < 0) {
						txt1.setText("No solution.");
						txt2.setText("");
					}
					else if (det == 0) {
						double sol1 = ((-1*b) + Math.sqrt(det)) / (2*a);
						txt1.setText(String.valueOf(sol1));
						txt2.setText("");
					}
					else {
						double sol1 = ((-1*b) + Math.sqrt(det)) / (2*a);
						double sol2 = ((-1*b) - Math.sqrt(det)) / (2*a);
						txt1.setText(String.valueOf(sol1));
						txt2.setText(String.valueOf(sol2));
					}
				}
				catch (NumberFormatException ex) {
					txt1.setText("Invalid entry.");
					txt2.setText("");
				}
			}
		});
		
		contentPane.add(lblInstructions);
		contentPane.add(lblA);
		contentPane.add(txtA);
		contentPane.add(lblB);
		contentPane.add(txtB);
		contentPane.add(lblC);
		contentPane.add(txtC);
		contentPane.add(lblBlank);
		contentPane.add(btnCalc);
		contentPane.add(lblBlank2);
		contentPane.add(lblSol1);
		contentPane.add(txt1);
		contentPane.add(lblSol2);
		contentPane.add(txt2);
	}

}
