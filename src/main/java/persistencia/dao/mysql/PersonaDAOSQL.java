package persistencia.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.PersonaDAO;
import dto.DomicilioDTO;
import dto.PersonaDTO;

public class PersonaDAOSQL implements PersonaDAO
{
	private static final String insert = "INSERT INTO personas(idPersona, nombre, telefono, signoZodiacal ,fecha, contacto, email, idDomicilio) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM personas WHERE idPersona = ?";
	private static final String readById = "SELECT FROM personas WHERE idPersona = ?";

	private static final String update = "UPDATE  personas SET nombre = ?, telefono = ?, signoZodiacal = ?, fecha = ?, contacto = ?, email = ? WHERE idPersona = ?";
	
	private static final String readall = 	"SELECT p.idPersona, p.nombre, p.telefono, p.signoZodiacal, p.fecha, p.contacto, p.email,d.idDomicilio, d.localidad , d.calle, d.altura, d.piso, d.departamento, d.pais, d.provincia, d.codPostal  FROM personas as p INNER JOIN domicilio as d ON p.idDomicilio = d.idDomicilio; " ;


											
	public boolean insert(PersonaDTO persona)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, persona.getIdPersona());
			statement.setString(2, persona.getNombre());
			statement.setString(3, persona.getTelefono());

			statement.setString(4, persona.getSignoZodiacal().toString());

			statement.setString(5, persona.getFechaNac());
			statement.setString(6, persona.getTipoDeContacto());
			statement.setString(7, persona.getEmail());
    		statement.setInt(8, autoIncremento());

//     		statement.setInt(8, persona.getDomicilio().getIdDomicilio());
			
			
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isInsertExitoso;
	}
	
	public int autoIncremento() {
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		Conexion conexion = Conexion.getConexion();
		int id = 0;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement("SELECT MAX(idDomicilio) FROM domicilio");
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				id = resultSet.getInt(1) ;
				System.out.println("Este es el ID:"+id);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
//		finally 
//		{
//			try {
//				statement.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		return id;
		
		
	}
	

	public boolean delete(PersonaDTO persona_a_eliminar)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setString(1, Integer.toString(persona_a_eliminar.getIdPersona()));
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isdeleteExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return isdeleteExitoso;
	}
	
	public List<PersonaDTO> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<PersonaDTO> personas = new ArrayList<PersonaDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				personas.add(getPersonaDTO(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return personas;
	}
	public PersonaDTO readById() {
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		PersonaDTO persona = new PersonaDTO();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readById);
			resultSet = statement.executeQuery();
			persona = getPersonaDTO(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();		
			}
		return persona;
	}
	
	private PersonaDTO getPersonaDTO(ResultSet resultSet) throws SQLException
	{
		int id = resultSet.getInt("idPersona");
		String nombre = resultSet.getString("Nombre");
		String tel = resultSet.getString("Telefono");
		
		String signo = resultSet.getString("signoZodiacal");
		String email = resultSet.getString("email");

		String contacto = resultSet.getString("contacto");
		String fecha = resultSet.getString("fecha");

		
		DomicilioDTO domicilio = new DomicilioDTO(resultSet.getInt("idDomicilio"), resultSet.getString("calle"), resultSet.getString("altura"), resultSet.getString("departamento"), resultSet.getString("piso"),resultSet.getString("pais"),resultSet.getString("provincia"),resultSet.getString("localidad"), resultSet.getString("CodPostal")); 
		
		return new PersonaDTO(id, nombre, tel, domicilio,email,contacto,fecha, signo);
		

	}
	
	public boolean update(PersonaDTO persona) 
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isUpdateExitoso = false;

//		PreparedStatement statement;
//		Conexion conexion = Conexion.getConexion();
		try 
		{
			//statement = conexion.getSQLConexion().prepareStatement(update);
			statement = conexion.prepareStatement(update);

			statement.setInt(7, persona.getIdPersona());
			statement.setString(1, persona.getNombre());
			statement.setString(2, persona.getTelefono());
			statement.setString(3, persona.getSignoZodiacal().toString());
			statement.setString(4, persona.getFechaNac());
			statement.setString(5, persona.getTipoDeContacto());
			statement.setString(6, persona.getEmail());

			
			System.out.println(persona.getEmail());
			
		
		
		if(statement.executeUpdate() > 0)
		{
			conexion.commit();
			isUpdateExitoso = true;
		}
	} 
	catch (SQLException e) 
	{
		e.printStackTrace();
		try {
			conexion.rollback();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	return isUpdateExitoso;
		
	}

	@Override
	public PersonaDTO getById(PersonaDTO persona) {
		// TODO Auto-generated method stub
		return null;
	}
}
