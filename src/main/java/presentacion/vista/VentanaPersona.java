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
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class VentanaPersona extends JFrame 
{
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
	private String txtContacto;
	private String txtLocalidad;
	private String txtPais;
	private String txtProvincia;



	private JButton btnAgregarLocalidad;

	private JButton btnAgregarPersona;
	private static VentanaPersona INSTANCE;
	JComboBox<String> comboProvincia;
	JComboBox<String> comboPais;
	JComboBox<String> comboLocalidad;
	JComboBox<String> comboContactos;
	
	JComboBox<String> comboSignoZodiacal;
	
	public static VentanaPersona getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new VentanaPersona(); 	
			return new VentanaPersona();
		}
		else
			return INSTANCE;
	}

	private VentanaPersona() 
	{
		super();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 950, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 49, 914, 343);
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
		
		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(377, 11, 113, 14);
		panel.add(lblCalle);
		
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(377, 52, 113, 14);
		panel.add(lblAltura);
		
		JLabel lblDepto = new JLabel("Departamento");
		lblDepto.setBounds(547, 52, 113, 14);
		panel.add(lblDepto);
		
		
		JLabel lblPiso = new JLabel("Piso");
		lblPiso.setBounds(377, 93, 113, 14);
		panel.add(lblPiso);
		
		JLabel lblFecha = new JLabel("Fecha nacimiento "); 
		lblFecha.setBounds(10, 129, 183, 14);
		panel.add(lblFecha);
		
		JLabel lblSigno = new JLabel("Signo Zodiacal");
		lblSigno.setBounds(10, 168, 113, 14);
		panel.add(lblSigno);

		JLabel lblEtiqueta = new JLabel("Cod Postal");
		lblEtiqueta.setBounds(621, 11, 113, 14);
		panel.add(lblEtiqueta);

		JLabel lblContacto = new JLabel("Contacto");
		lblContacto.setBounds(10, 205, 113, 14);
		panel.add(lblContacto);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(721, 129, 113, 14);
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
		txtCalle.setBounds(419, 8, 164, 20);
		panel.add(txtCalle);
		txtCalle.setColumns(10);

		txtAltura = new JTextField();
		txtAltura.setBounds(419, 49, 86, 20);
		panel.add(txtAltura);
		txtAltura.setColumns(10);
		
		txtDepto = new JTextField();
		txtDepto.setBounds(670, 49, 98, 20);
		panel.add(txtDepto);
		txtDepto.setColumns(10);
		
		txtPiso = new JTextField();
		txtPiso.setBounds(419, 90, 98, 20);
		panel.add(txtPiso);
		txtPiso.setColumns(10);

		txtFecha = new JTextField();
		txtFecha.setBounds(133, 126, 164, 20);
		panel.add(txtFecha);
		txtFecha.setColumns(10);

			
		comboSignoZodiacal= new JComboBox<String>();
		comboSignoZodiacal.setBounds(133, 164, 98, 22);
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
		txtCp.setBounds(682, 8, 86, 20);
		panel.add(txtCp);
		txtCp.setColumns(10);

		
		comboContactos = new JComboBox<String>();
		comboContactos.setBounds(133, 201, 98, 22);
		comboContactos.addItem("Trabajo");
		comboContactos.addItem("Familia");
		comboContactos.addItem("Amigos");
		panel.add(comboContactos);
		
		comboContactos.addActionListener(new ActionListener(){			
	        @Override
	        public void actionPerformed(ActionEvent arg0) {
	              txtContacto  = (String) comboContactos.getSelectedItem();
	        }
	    });
		
		comboContactos.setSelectedItem("Trabajo");
		
		comboLocalidad = new JComboBox<String>();
		comboLocalidad.setBounds(793, 125, 98, 22);
		panel.add(comboLocalidad);
		
	
		btnAgregarPersona = new JButton("Agregar persona");
		btnAgregarPersona.setForeground(new Color(0, 128, 0));
		btnAgregarPersona.setBounds(682, 309, 211, 23);
		panel.add(btnAgregarPersona);
		
		JLabel lblPais = new JLabel("País");
		lblPais.setBounds(377, 129, 46, 14);
		panel.add(lblPais);
		
		JLabel lblprovincia = new JLabel("Provincia");
		lblprovincia.setBounds(547, 129, 46, 14);
		panel.add(lblprovincia);
		
		comboPais = new JComboBox<String>();
		comboPais.setBounds(419, 125, 98, 22); 
		comboPais.addItem("Argentina");
		panel.add(comboPais);
		

		
		comboProvincia = new JComboBox<String>();
		comboProvincia.setBounds(603, 125, 98, 22);
		comboProvincia.addItem("Bs As");

		panel.add(comboProvincia);
		
		btnAgregarLocalidad = new JButton("Agregar Localidad");
		btnAgregarLocalidad.setBounds(574, 184, 149, 23);
		panel.add(btnAgregarLocalidad);
		
		JLabel lblNewLabel = new JLabel("Agregar persona");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(279, 11, 348, 27);
		contentPane.add(lblNewLabel);
		

		
		this.setVisible(false);
	}
	
	
	
	
	public JComboBox<String> getComboContactos() {
		return comboContactos;
	}

	public void setComboContactos(JComboBox<String> comboContactos) {
		this.comboContactos = comboContactos;
	}

	public JComboBox<String> getComboProvincia() {
		return comboProvincia;
	}

	public void setComboProvincia(JComboBox<String> comboProvincia) {
		this.comboProvincia = comboProvincia;
	}

	public JComboBox<String> getComboPais() {
		return comboPais;
	}

	public void setComboPais(JComboBox<String> comboPais) {
		this.comboPais = comboPais;
	}

	public JComboBox<String> getComboLocalidad() {
		return comboLocalidad;
	}

	public void setComboLocalidad(JComboBox<String> comboLocalidad) {
		this.comboLocalidad = comboLocalidad;
	}
	
	
	

	public void setTxtLocalidad(String txtLocalidad) {
		this.txtLocalidad = txtLocalidad;
	}

	public String getTxtPais() {
		return txtPais;
	}

	public void setTxtPais(String txtPais) {
		this.txtPais = txtPais;
	}

	public String getTxtProvincia() {
		return txtProvincia;
	}

	public void setTxtProvincia(String txtProvincia) {
		this.txtProvincia = txtProvincia;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}



	public JTextField getTxtCalle() {
		return txtCalle;
	}

	

	public JTextField getTxtAltura() {
		return txtAltura;
	}

	

	public JTextField getTxtDepto() {
		return txtDepto;
	}

	

	public JTextField getTxtPiso() {
		return txtPiso;
	}

	

	public JTextField getTxtFecha() {
		return txtFecha;
	}


	public JTextField getTxtCp() {
		return txtCp;
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
	
	public String getTxtContacto() 
	{
		return txtContacto;
	}

	public String getTxtLocalidad() 
	{
		return txtLocalidad;
	}
	public JButton getBtnAgregarPersona() 
	{
		return btnAgregarPersona;
	}
	
	public JButton getBtnAgregarLocalidad() {
		return btnAgregarLocalidad;
	}

	public void setBtnAgregarLocalidad(JButton btnAgregarLocalidad) {
		this.btnAgregarLocalidad = btnAgregarLocalidad;
	}
	
	
	

	public JComboBox<String> getComboSignoZodiacal() {
		return comboSignoZodiacal;
	}

	public void setComboSignoZodiacal(JComboBox<String> comboSignoZodiacal) {
		this.comboSignoZodiacal = comboSignoZodiacal;
	}

	public void cerrar()
	{
		this.txtNombre.setText(null);
		this.txtTelefono.setText(null);
		this.dispose();
	}
}

