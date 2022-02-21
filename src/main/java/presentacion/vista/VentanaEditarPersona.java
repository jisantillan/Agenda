package presentacion.vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dto.PersonaDTO;
import java.awt.Color;
import java.awt.Font;

public class VentanaEditarPersona extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtEmail;
	private JTextField txtCalle;
	private JTextField txtAltura;
	private JTextField txtDepto;
	private JTextField txtPiso;
	private JTextField txtFecha;
	private JTextField txtCp;
	private String txtLocalidad;
	private String txtContactos;
	private DefaultTableModel modelPersonas;
	private JComboBox<String> comboContactos;
	private JComboBox<String> comboLocalidad;
	private JComboBox<String> comboSignoZodiacal;
	private JButton btnEditarPersona;
	private static VentanaEditarPersona INSTANCE;
	private JLabel lblCP;
	
	public static VentanaEditarPersona getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new VentanaEditarPersona(); 	
			return new VentanaEditarPersona();
		}
		else
			return INSTANCE;
	}
	
	private VentanaEditarPersona() {
		super();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 906, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 59, 870, 289);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombreYApellido = new JLabel("Nombre y apellido");
		lblNombreYApellido.setBounds(10, 11, 113, 14);
		panel.add(lblNombreYApellido);
		
		JLabel lblTelfono = new JLabel("Telefono");
		lblTelfono.setBounds(10, 52, 113, 14);
		panel.add(lblTelfono);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 93, 113, 14);
		panel.add(lblEmail);
		
		JLabel lblNewLabel = new JLabel("Editar persona");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(279, 11, 348, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(346, 11, 113, 14);
		panel.add(lblCalle);
		
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(346, 52, 113, 14);
		panel.add(lblAltura);
		
		JLabel lblDepto = new JLabel("Departamento");
		lblDepto.setBounds(535, 52, 113, 14);
		panel.add(lblDepto);
		
		
		JLabel lblPiso = new JLabel("Piso");
		lblPiso.setBounds(346, 93, 113, 14);
		panel.add(lblPiso);
		
		JLabel lblFecha = new JLabel("Fecha Nacimiento");
		lblFecha.setBounds(10, 132, 113, 14);
		panel.add(lblFecha);
		

		JLabel lblCp = new JLabel("Codigo Postal");
		lblCp.setBounds(10, 339, 113, 14);
		panel.add(lblCp);

		JLabel lblSigno= new JLabel("Signo Zodiacal");
		lblSigno.setBounds(10, 179, 113, 14);
		panel.add(lblSigno);

		
		JLabel lblContacto = new JLabel("Contacto");
		lblContacto.setBounds(10, 214, 113, 14);
		panel.add(lblContacto);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(346, 132, 113, 14);
		panel.add(lblLocalidad);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(133, 8, 164, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(133, 49, 164, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(133, 90, 164, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtCalle = new JTextField();
		txtCalle.setBounds(402, 8, 164, 20);
		panel.add(txtCalle);
		txtCalle.setColumns(10);

		txtAltura = new JTextField();
		txtAltura.setBounds(402, 49, 98, 20);
		panel.add(txtAltura);
		txtAltura.setColumns(10);
		
		txtDepto = new JTextField();
		txtDepto.setBounds(628, 49, 164, 20);
		panel.add(txtDepto);
		txtDepto.setColumns(10);
		
		txtPiso = new JTextField();
		txtPiso.setBounds(402, 90, 98, 20);
		panel.add(txtPiso);
		txtPiso.setColumns(10);

		txtFecha = new JTextField();
		txtFecha.setBounds(133, 129, 164, 20);
		panel.add(txtFecha);
		txtFecha.setColumns(10);
		

		comboSignoZodiacal = new JComboBox<String>();
		comboSignoZodiacal.setBounds(133, 175, 98, 22);
		comboSignoZodiacal.addItem("ARIES");
		comboSignoZodiacal.addItem("TAURO");
		comboSignoZodiacal.addItem("GÉMINIS");
		comboSignoZodiacal.addItem("CÁNCER");
		comboSignoZodiacal.addItem("LEO");
		comboSignoZodiacal.addItem("VIRGO");
		comboSignoZodiacal.addItem("LIBRA");
		comboSignoZodiacal.addItem("ESCORPIÓN");
		comboSignoZodiacal.addItem("SAGITARIO");
		comboSignoZodiacal.addItem("CAPRICORNIO");
		comboSignoZodiacal.addItem("ACUARIO");
		comboSignoZodiacal.addItem("PISCIS");
		panel.add(comboSignoZodiacal);


		txtCp = new JTextField();
		txtCp.setBounds(696, 8, 164, 20);
		panel.add(txtCp);
		txtCp.setColumns(10);

		
		comboContactos = new JComboBox<String>();
		comboContactos.setBounds(133, 214, 98, 22);
		comboContactos.addItem("Trabajo");
		comboContactos.addItem("Familia");
		comboContactos.addItem("Amigos");
		panel.add(comboContactos);
		
		comboContactos.addActionListener(new ActionListener(){			
	        @Override
	        public void actionPerformed(ActionEvent arg0) {
	              txtContactos  = (String) comboContactos.getSelectedItem();
	        }
	    });
		
		comboLocalidad = new JComboBox<String>();
		comboLocalidad.setBounds(402, 128, 98, 22);
		comboLocalidad.addItem("San Miguel");
		comboLocalidad.addItem("Jose C Paz");
		comboLocalidad.addItem("Del Viso");
		panel.add(comboLocalidad);
		
		comboLocalidad.addActionListener(new ActionListener(){			
	        @Override
	        public void actionPerformed(ActionEvent arg0) {
	              txtLocalidad  = (String) comboLocalidad.getSelectedItem();
	        }
	    });
		
		
		btnEditarPersona = new JButton("Actualizar");
		btnEditarPersona.setForeground(new Color(0, 128, 0));
		btnEditarPersona.setBounds(748, 254, 89, 23);
		panel.add(btnEditarPersona);
		
		lblCP = new JLabel("Codigo Postal");
		lblCP.setBounds(600, 11, 86, 14);
		panel.add(lblCP);
		
		
		
		this.setVisible(false);
		
	}
	public void mostrarVentana()
	{
		this.setVisible(true);
	}
	
	public JTextField getTxtNombre() 
	{
		return txtNombre;
	}

	public JTextField getTxtTelefono() 
	{
		return txtTelefono;
	}
	
	public JButton getBtnEditarPersona()
	{
		return btnEditarPersona;
	}
	public void obtenerDatos(PersonaDTO persona) {
		txtNombre.setText(persona.getNombre());
		txtTelefono.setText(persona.getTelefono());
	
		txtEmail.setText(persona.getEmail());
		
		txtCalle.setText(persona.getDomicilio().getCalle());
		txtAltura.setText(persona.getDomicilio().getAltura());
		txtDepto.setText(persona.getDomicilio().getDepto());
		txtFecha.setText(persona.getFechaNac());
		txtCp.setText(persona.getDomicilio().getCodPostal());
		txtPiso.setText(persona.getDomicilio().getPiso());
		
		comboLocalidad.addItem(persona.getDomicilio().getLocalidad());
		comboLocalidad.setSelectedItem(persona.getDomicilio().getLocalidad());
		
		comboContactos.addItem(persona.getTipoDeContacto());
		comboContactos.setSelectedItem(persona.getTipoDeContacto());
		
		
		comboSignoZodiacal.setSelectedItem(persona.getSignoZodiacal().toString());
		
	}
	
	
	public void setearDatos(PersonaDTO persona) {
		persona.setNombre(txtNombre.getText());
		persona.setTelefono(txtTelefono.getText());
		persona.setSigno("capricornio");
		persona.setEmail(txtEmail.getText());
		persona.setFechaNac(txtFecha.getText());
		
		persona.getDomicilio().setDepto(txtDepto.getText());
		persona.getDomicilio().setAltura(txtAltura.getText());
		persona.getDomicilio().setCalle(txtCalle.getText());
		persona.getDomicilio().setPiso(txtPiso.getText());
		persona.getDomicilio().setLocalidad(txtLocalidad);
		persona.getDomicilio().setCodPostal(txtCp.getText());
		
		persona.setTipoDeContacto(txtContactos);
		
		persona.setSignoZodiacal((String) comboSignoZodiacal.getSelectedItem());

	}
	
	public void cerrar()
	{
		this.txtNombre.setText(null);
		this.txtTelefono.setText(null);
		this.txtEmail.setText(null);
		this.txtCalle.setText(null);
		this.txtAltura.setText(null);
		this.txtDepto.setText(null);
		this.txtFecha.setText(null);

		this.txtCp.setText(null);


		this.dispose();
	}


}