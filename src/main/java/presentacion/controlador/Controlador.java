package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

//import org.apache.commons.collections.bag.SynchronizedSortedBag;

import modelo.Agenda;
import persistencia.dao.interfaz.LocalidadDAO;
import persistencia.dao.mysql.LocalidadDAOSQL;
import persistencia.dao.mysql.ProvinciaDAOSQL;

import persistencia.dao.mysql.DomicilioDAOSQL;
import presentacion.reportes.ReporteAgenda;
import presentacion.vista.VentanaLocalidad;

import presentacion.vista.VentanaEditarPersona;
import presentacion.vista.VentanaPersona;
import presentacion.vista.Vista;
import dto.DomicilioDTO;
import dto.PersonaDTO;

import dto.LocalidadDTO;
import dto.PaisDTO;
import dto.ProvinciaDTO;

public class Controlador implements ActionListener
{
		private Vista vista;
		private List<PersonaDTO> personasEnTabla;
		private List<PaisDTO> paisesEnTabla;
		private List<ProvinciaDTO> provinciasEnTabla;
		private List<LocalidadDTO> localidadesEnTabla;
		private VentanaPersona ventanaPersona; 
		private VentanaLocalidad ventanaLocalidad; 
		private VentanaEditarPersona ventanaEditarPersona;
		private Agenda agenda;
		private PersonaDTO persona;
		
		public Controlador(Vista vista, Agenda agenda)
		{
			this.vista = vista;
			this.vista.getBtnAgregar().addActionListener(a->ventanaAgregarPersona(a));
			this.vista.getBtnBorrar().addActionListener(s->borrarPersona(s));
			this.vista.getBtnReporte().addActionListener(r->mostrarReporte(r));
						
			this.ventanaLocalidad = VentanaLocalidad.getInstance();
			this.ventanaLocalidad.getBtnAgregarLocalidad().addActionListener(l->guardarLocalidad(l));
		
			this.vista.getBtnEditar().addActionListener(e->ventanaEditarPersona(e));
			this.ventanaPersona = VentanaPersona.getInstance();
			this.ventanaPersona.getBtnAgregarPersona().addActionListener(p->guardarPersona(p));
			this.ventanaPersona.getBtnAgregarLocalidad().addActionListener(n->ventanaAgregarLocalidad(n));
			
			this.ventanaPersona.getComboPais().addActionListener(pa->seleccionarPais(pa));
			this.ventanaPersona.getComboProvincia().addActionListener(pr->seleccionarProvincia(pr));
			this.ventanaPersona.getComboLocalidad().addActionListener(lo->seleccionarLocalidad(lo));
			
			this.ventanaEditarPersona = VentanaEditarPersona.getInstance();
			this.ventanaEditarPersona.getBtnEditarPersona().addActionListener(p->editarPersona(p));
			this.agenda = agenda;
		}
	
		private void ventanaAgregarLocalidad(ActionEvent n) {
			this.ventanaLocalidad.mostrarVentana();		}

		private void ventanaAgregarPersona(ActionEvent a) {
			this.ventanaPersona.mostrarVentana();
		}
		
		private void ventanaEditarPersona(ActionEvent e) {
			
			this.ventanaEditarPersona.mostrarVentana();
			int[] filasSeleccionadas = this.vista.getTablaPersonas().getSelectedRows();
			for (int fila : filasSeleccionadas)
			{
				this.persona = this.personasEnTabla.get(fila);
				this.ventanaEditarPersona.obtenerDatos(this.personasEnTabla.get(fila));

				//System.out.println(this.personasEnTabla.get(fila).getTelefono());
				
			}
		
		}




		private void guardarPersona(ActionEvent p) {
			String nombre = this.ventanaPersona.getTxtNombre().getText();
			String tel = ventanaPersona.getTxtTelefono().getText();
			String email =this.ventanaPersona.getTxtEmail().getText();
			String calle =this.ventanaPersona.getTxtCalle().getText();
			String altura =this.ventanaPersona.getTxtAltura().getText();
			String depto =this.ventanaPersona.getTxtDepto().getText();
			String piso =this.ventanaPersona.getTxtPiso().getText();
			String fecha =this.ventanaPersona.getTxtFecha().getText();

			String signo =(String) this.ventanaPersona.getComboSignoZodiacal().getSelectedItem();

			String cp =this.ventanaPersona.getTxtCp().getText();

			String contacto =this.ventanaPersona.getTxtContacto();
			String localidad =this.ventanaPersona.getTxtLocalidad();
			String provincia =this.ventanaPersona.getTxtProvincia();
			String pais =this.ventanaPersona.getTxtPais();
		
			DomicilioDTO domicilio = new DomicilioDTO (0, calle, altura, depto, piso, pais, provincia, localidad, cp);
			
			new DomicilioDAOSQL().insert(domicilio);

			PersonaDTO nuevaPersona = new PersonaDTO(0, nombre, tel, domicilio, email, contacto, fecha, signo);


			this.agenda.agregarPersona(nuevaPersona);
			this.refrescarTabla();
			this.ventanaPersona.cerrar();
		}

		private void mostrarReporte(ActionEvent r) {
//			ReporteAgenda reporte = new ReporteAgenda(agenda.obtenerPersonas());
//			reporte.mostrar();	
			
			int row = this.vista.getTablaPersonas().getRowCount();
			if(row == 0)
			{
				JOptionPane.showMessageDialog(null, "No hay ningun contacto en la agenda");
			}
			else
			{
				ReporteAgenda reporte = new ReporteAgenda(agenda.obtenerPersonas());
				reporte.mostrar();
			}
		}

		public void borrarPersona(ActionEvent s)
		{
			int[] filasSeleccionadas = this.vista.getTablaPersonas().getSelectedRows();
			for (int fila : filasSeleccionadas)
			{
				this.agenda.borrarPersona(this.personasEnTabla.get(fila));
				new DomicilioDAOSQL().delete(this.personasEnTabla.get(fila).getDomicilio());

			}
			
			this.refrescarTabla();
		}
		
		public void inicializar()
		{
			this.refrescarTabla();
			this.vista.show();
		}
		
		private void refrescarTabla()
		{				
			this.personasEnTabla = agenda.obtenerPersonas();
			this.vista.llenarTabla(this.personasEnTabla);			
			this.paisesEnTabla = agenda.obtenerPaises();
			this.provinciasEnTabla = agenda.obtenerProvincias();
			this.localidadesEnTabla = agenda.obtenerLocalidades();

			for (PaisDTO paisDTO : paisesEnTabla) 
			{				
				for (ProvinciaDTO provinciaDTO : provinciasEnTabla) 
				{
					if (paisDTO.getIdProvincia() == provinciaDTO.getIdProvincia() )
					{			
						for (LocalidadDTO localidadDTO : localidadesEnTabla) 
						{	
							if(provinciaDTO.getIdLocalidad() == localidadDTO.getIdLocalidad())
							{								
								provinciaDTO.setLocalidad(localidadDTO);
								paisDTO.setProvincia(provinciaDTO);
							}
						}
					}
				}			
			}	
			
			this.ventanaPersona.getComboPais().removeAllItems();
			ArrayList <String> paisesAgregados = new ArrayList<String>();
			
			for (PaisDTO paisDTO : paisesEnTabla) 
			{
				if(!paisesAgregados.contains(paisDTO.getNombre())) 
				{
					this.ventanaPersona.getComboPais().addItem(paisDTO.getNombre());
					paisesAgregados.add(paisDTO.getNombre());
				}
			}		
			this.ventanaPersona.getComboPais().setSelectedItem("Argentina");
			this.ventanaPersona.getComboProvincia().setSelectedItem("Buenos Aires");
			this.ventanaPersona.getComboLocalidad().setSelectedItem("Del Viso");
		}
		

		
		private void editarPersona(ActionEvent p) {
			
			
			this.ventanaEditarPersona.setearDatos(this.persona);
			this.agenda.editarPersona(this.persona);
			new DomicilioDAOSQL().update(this.persona.getDomicilio());
	
			for (ProvinciaDTO provinciaDTO : provinciasEnTabla) 
			{
				this.ventanaPersona.getComboPais().addItem(provinciaDTO.getNombre());	
			}	
			
			this.ventanaEditarPersona.cerrar();
			this.refrescarTabla();		
		}
	
		private void seleccionarPais(ActionEvent pa)
		{				
			this.ventanaPersona.setTxtPais((String) this.ventanaPersona.getComboPais().getSelectedItem());
			this.ventanaPersona.getComboProvincia().removeAllItems();
				
			ArrayList <String> provinciasAgregadas = new ArrayList<String>();

			
			for (PaisDTO paisDTO : paisesEnTabla) 
			{
				if(  paisDTO.getNombre().equals(this.ventanaPersona.getTxtPais()) && !provinciasAgregadas.contains(paisDTO.getProvincia().getNombre()) )
				{
					this.ventanaPersona.getComboProvincia().addItem(paisDTO.getProvincia().getNombre());
					provinciasAgregadas.add(paisDTO.getProvincia().getNombre());
				}
			}	
		}
		
		private void seleccionarProvincia(ActionEvent pr)
		{
			this.ventanaPersona.setTxtProvincia((String) this.ventanaPersona.getComboProvincia().getSelectedItem());
			this.ventanaPersona.getComboLocalidad().removeAllItems();
		
			for (ProvinciaDTO provinciaDTO : provinciasEnTabla) 
			{
				if(  provinciaDTO.getNombre().equals(this.ventanaPersona.getTxtProvincia())  )
				{
					this.ventanaPersona.getComboLocalidad().addItem(provinciaDTO.getLocalidad().getNombre());	
					
					
					
				}
			}	
			
		}
		
		private void seleccionarLocalidad(ActionEvent lo)
		{
			this.ventanaPersona.setTxtLocalidad((String) this.ventanaPersona.getComboLocalidad().getSelectedItem());
		}
		
		private void guardarLocalidad(ActionEvent l) 
		{
			String nombrePais = this.ventanaLocalidad.getTxtPais().getText();
			String nombreProvincia = this.ventanaLocalidad.getTxtProvincia().getText();
			String nombreLocalidad = this.ventanaLocalidad.getTxtLocalidad().getText();
			
			LocalidadDTO localidad = new LocalidadDTO (0 , nombreLocalidad);
			this.agenda.agregarLocalidad(localidad);
			ProvinciaDTO provincia = new ProvinciaDTO ( 0 , nombreProvincia, localidad , LocalidadDAOSQL.idLocalidad);
			this.agenda.agregarProvincia(provincia);
			PaisDTO pais = new PaisDTO (0, nombrePais, provincia, ProvinciaDAOSQL.idProvincia);
			this.agenda.agregarPais(pais);
			
			this.ventanaLocalidad.cerrar();
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) { }
		
}
