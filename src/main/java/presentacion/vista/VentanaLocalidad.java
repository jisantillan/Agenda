package presentacion.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

public class VentanaLocalidad extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPais;
	private JTextField txtProvincia;
	private JTextField txtLocalidad;
	private JButton btnAgregarLocalidad;
	private static VentanaLocalidad INSTANCE;
	
	public static VentanaLocalidad getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new VentanaLocalidad(); 	
			return new VentanaLocalidad();
		}
		else
			return INSTANCE;
	}

	private VentanaLocalidad() 
	{
		super();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 356, 247);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 320, 193);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblPais = new JLabel("Pais");
		lblPais.setBounds(10, 11, 113, 14);
		panel.add(lblPais);
		
		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setBounds(10, 52, 113, 14);
		panel.add(lblProvincia);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(10, 93, 113, 14);
		panel.add(lblLocalidad);
		
		txtPais = new JTextField();
		txtPais.setBounds(133, 8, 164, 20);
		panel.add(txtPais);
		txtPais.setColumns(10);
		
		txtProvincia = new JTextField();
		txtProvincia.setBounds(133, 49, 164, 20);
		panel.add(txtProvincia);
		txtProvincia.setColumns(10);
		
		txtLocalidad = new JTextField();
		txtLocalidad.setBounds(133, 90, 164, 20);
		panel.add(txtLocalidad);
		txtLocalidad.setColumns(10);
		
		btnAgregarLocalidad = new JButton("Agregar");
		btnAgregarLocalidad.setBounds(111, 144, 89, 23);
		panel.add(btnAgregarLocalidad);
		
		this.setVisible(false);
	}
	
	
	
	

	public JTextField getTxtLocalidad() {
		return txtLocalidad;
	}







	public void mostrarVentana()
	{
		this.setVisible(true);
	}
	
	public JTextField getTxtPais() 
	{
		return txtPais;
	}

	public JTextField getTxtProvincia() 
	{
		return txtProvincia;
	}
	
	public JButton getBtnAgregarPersona() 
	{
		return btnAgregarLocalidad;
	}
	
	public JButton getBtnAgregarLocalidad() {
		return btnAgregarLocalidad;
	}

	public void setBtnAgregarLocalidad(JButton btnAgregarLocalidad) {
		this.btnAgregarLocalidad = btnAgregarLocalidad;
	}

	public void cerrar()
	{
		this.txtPais.setText(null);
		this.txtProvincia.setText(null);
		this.txtLocalidad.setText(null);
		this.dispose();
	}
}

