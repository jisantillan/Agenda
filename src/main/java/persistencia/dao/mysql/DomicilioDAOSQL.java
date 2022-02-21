package persistencia.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.DomicilioDAO;
import dto.DomicilioDTO;



public class DomicilioDAOSQL implements DomicilioDAO
{
	private static final String insert= "INSERT INTO domicilio(idDomicilio, localidad, calle, altura, piso, departamento, pais, provincia, codPostal ) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM domicilio WHERE idDomicilio = ?";
	private static final String readall = "SELECT * FROM domicilio";

	private static final String update = "UPDATE  domicilio SET calle = ?, altura = ?, departamento = ?, piso = ?, localidad = ?, codPostal = ? WHERE idDomicilio = ?";

	
	public boolean insert(DomicilioDTO domicilio)
	{	
		
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, domicilio.getIdDomicilio());
			statement.setString(2, domicilio.getLocalidad());
			statement.setString(3, domicilio.getCalle());
			statement.setString(4, domicilio.getAltura());
			statement.setString(5, domicilio.getPiso());
			statement.setString(6, domicilio.getDepto());
			statement.setString(7, domicilio.getPais());
			statement.setString(8, domicilio.getProvincia());
			statement.setString(9, domicilio.getCodPostal());
			
			
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
		
//		finally 
//		{
//			try {
//				conexion.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		return isInsertExitoso;
	}
	


	public boolean delete(DomicilioDTO domicilio_a_eliminar)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setString(1, Integer.toString(domicilio_a_eliminar.getIdDomicilio()));
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
	
	public List<DomicilioDTO> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<DomicilioDTO> domicilios = new ArrayList<DomicilioDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				domicilios.add(getPersonaDTO(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return domicilios;
	}
	
	public boolean update(DomicilioDTO dom) 
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

			statement.setInt(7, dom.getIdDomicilio());
			statement.setString(1, dom.getCalle());
			statement.setString(2, dom.getAltura());
			statement.setString(3, dom.getDepto());
			statement.setString(4, dom.getPiso());
			statement.setString(5, dom.getLocalidad());
			statement.setString(6, dom.getCodPostal());
			
			
		
		
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
	
	private DomicilioDTO getPersonaDTO(ResultSet resultSet) throws SQLException
	{
//		int id = resultSet.getInt("idPersona");
//		String nombre = resultSet.getString("Nombre");
//		String tel = resultSet.getString("Telefono");
//		String eti = resultSet.getString("etiqueta");
//		String fecha = resultSet.getString("fecha");
//		String contacto = resultSet.getString("contacto");
//		String email = resultSet.getString("email");
		//String idDom = resultSet.getString("idDomicilio");
		DomicilioDTO domicilio = new DomicilioDTO(resultSet.getInt("idDomicilio"), resultSet.getString("calle"), resultSet.getString("altura"), resultSet.getString("depto"), resultSet.getString("piso"),resultSet.getString("pais"),resultSet.getString("provincia"),resultSet.getString("localidad"), resultSet.getString("codPostal")); 



		
		return   domicilio; 
	}
}
