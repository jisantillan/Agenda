package persistencia.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.ProvinciaDAO;
import dto.ProvinciaDTO;

public class ProvinciaDAOSQL implements ProvinciaDAO
{
	private static final String insert = "INSERT INTO provincias(idProvincia, nombre, idLocalidad) VALUES(?, ?, ?)";
	private static final String delete = "DELETE FROM paises WHERE idProvincias = ?";
	private static final String readall = "SELECT * FROM provincias";
	private static final String readById = "SELECT FROM provincias WHERE idProcincia = ?";
	private static final String update = "UPDATE provincias SET nombre = ?, idProvincia = ? WHERE idProvincia = ?";
	public static int idProvincia; 

	
	
	
	public void autoIncremento() {
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		Conexion conexion = Conexion.getConexion();
		int id = 0;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement("SELECT MAX(idProvincia) FROM provincias");
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				id = resultSet.getInt(1) ;
				System.out.println(id);
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
		
		idProvincia = id;
	}
	
	
	
	public boolean insert(ProvinciaDTO provincia)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, provincia.getIdProvincia());
			statement.setString(2, provincia.getNombre());
			statement.setInt(3, provincia.getIdLocalidad());
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
		autoIncremento();
		return isInsertExitoso;
	}
	
	public boolean delete(ProvinciaDTO provincia_a_eliminar)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setString(1, Integer.toString(provincia_a_eliminar.getIdProvincia()));
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
	
	public List<ProvinciaDTO> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<ProvinciaDTO> provincias = new ArrayList<ProvinciaDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				provincias.add(getProvinciaDTO(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return provincias;
	}
	public ProvinciaDTO readById() {
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ProvinciaDTO provincia = new ProvinciaDTO();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readById);
			resultSet = statement.executeQuery();
			provincia = getProvinciaDTO(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();		
			}
		return provincia;
	}
	
	private ProvinciaDTO getProvinciaDTO(ResultSet resultSet) throws SQLException
	{
		int id = resultSet.getInt("idProvincia");
		String nombre = resultSet.getString("Nombre");
		int idLocalidad =  resultSet.getInt("idLocalidad");
		return new ProvinciaDTO(id, nombre, idLocalidad);
		
	}
	
	public boolean update(ProvinciaDTO provincia) 
	{
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(update);
			statement.setInt(11, provincia.getIdProvincia());
			statement.setString(1, provincia.getNombre());
			statement.setInt(11, provincia.getIdLocalidad());
					
			if(statement.executeUpdate() > 0) //Si se ejecutá devuelvo true
				return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			conexion.cerrarConexion();
		}
		return false;
	}
}
