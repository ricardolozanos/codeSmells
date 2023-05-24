package Contador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension; //Para ayudarnos a obtener la dimension de la pantalla
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.Toolkit;
import java.awt.SystemColor;

public class BotonContador extends JFrame implements MouseListener{

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnAumentar;
	private int contador=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BotonContador frame = new BotonContador();
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
	public BotonContador() {
		
	
		setForeground(Color.GRAY);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Antonio May Couoh\\Pictures\\34198-golpe_de_estado-deportivo-amarillo-coche_deportivo-mercedes_benz_clase_s-3840x2160.jpg"));
		setTitle("Contador con boton");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 316);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.textInactiveText);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.GRAY);
		panel.setToolTipText("");
		panel.setBounds(46, 28, 376, 213);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Value");
		lblNewLabel.setBounds(20, 83, 69, 28);
		lblNewLabel.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
		panel.add(lblNewLabel);
		
		btnAumentar = new JButton("Aumentar");
		btnAumentar.setToolTipText("Clic en el boton para incrementar el valor, con un paso de uno, mostrado en el JTextField.");
		btnAumentar.addMouseListener(this);
		btnAumentar.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		btnAumentar.setBounds(227, 81, 139, 34);
		panel.add(btnAumentar);
		
		textField = new JTextField();
		textField.setBounds(89, 83, 96, 28);
		panel.add(textField);
		textField.setColumns(10);
		actualizarTextField();
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		btnAumentar.setBackground(Color.GREEN);
		}

	@Override
	public void mouseClicked(MouseEvent e) {
		contador++;
		actualizarTextField();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		btnAumentar.setBackground(UIManager.getColor("Button.background"));
	}
	
	private void actualizarTextField() {
		textField.setText(Integer.toString(contador));
	}

}
