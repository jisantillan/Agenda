package modelo;

import java.util.List;

import dto.LocalidadDTO;
import dto.PaisDTO;
import dto.PersonaDTO;
import dto.ProvinciaDTO;
import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.LocalidadDAO;
import persistencia.dao.interfaz.PaisDAO;
import persistencia.dao.interfaz.PersonaDAO;
import persistencia.dao.interfaz.ProvinciaDAO;


public class Agenda 
{
	private PersonaDAO persona;
	private PaisDAO pais;
	private ProvinciaDAO provincia;
	private LocalidadDAO localidad;
	
	public Agenda(DAOAbstractFactory metodo_persistencia)
	{
		this.persona = metodo_persistencia.createPersonaDAO();
		this.pais = metodo_persistencia.createPaisDAO();
		this.provincia = metodo_persistencia.createProvinciaDAO();
		this.localidad = metodo_persistencia.createLocalidadDAO();
	}
	
	public void agregarPersona(PersonaDTO nuevaPersona)
	{
		this.persona.insert(nuevaPersona);
	}
	
	public void borrarPersona(PersonaDTO persona_a_eliminar) 
	{
		this.persona.delete(persona_a_eliminar);
	}
	

	public void editarPersona(PersonaDTO persona_a_editar) {
		
		this.persona.update(persona_a_editar);
	}
	
	public List<PersonaDTO> obtenerPersonas()
	{
		return this.persona.readAll();		
	}
	public PersonaDTO obtenerPersona(PersonaDTO persona_a_obtener)
	{
		return persona.getById(persona_a_obtener);
	}
	
	
	//Pais
	

	public void agregarPais(PaisDTO nuevoPais)
	{
		this.pais.insert(nuevoPais);
	}

	public void borrarPais(PaisDTO pais_a_eliminar) 
	{
		this.pais.delete(pais_a_eliminar);
	}
	
	public void editarPais(PaisDTO pais_a_editar) {
		
		this.pais.update(pais_a_editar);
	}
	
	public List<PaisDTO> obtenerPaises()
	{
		return this.pais.readAll();		
	}
	
	
	//Provincia

	
	public void agregarProvincia(ProvinciaDTO nuevaProvincia)
	{
		this.provincia.insert(nuevaProvincia);
	}

	public void borrarProvincia(ProvinciaDTO provincia_a_eliminar) 
	{
		this.provincia.delete(provincia_a_eliminar);
	}
	
	public void editarProvincia(ProvinciaDTO provincia_a_editar) {
		
		this.provincia.update(provincia_a_editar);
	}
	
	public List<ProvinciaDTO> obtenerProvincias()
	{
		return this.provincia.readAll();		
	}
	
	//Localidad
	
	public void agregarLocalidad(LocalidadDTO nuevaLocalidad)
	{
		this.localidad.insert(nuevaLocalidad);
	}

	public void borrarLocalidad(LocalidadDTO localidad_a_eliminar) 
	{
		this.localidad.delete(localidad_a_eliminar);
	}
	
	public void editarLocalidad(LocalidadDTO localidad_a_editar) {
		
		this.localidad.update(localidad_a_editar);
	}
	
	public List<LocalidadDTO> obtenerLocalidades()
	{
		return this.localidad.readAll();		
	}
	
	
	
	
	
	
	
	
	
}
