package persistencia.dao.mysql; 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dto.LocalidadDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.LocalidadDAO;

public class LocalidadDAOSQL implements LocalidadDAO
{
	private static final String insert = "INSERT INTO localidades(idLocalidad, nombre) VALUES(?, ?)";
	private static final String delete = "DELETE FROM localidades WHERE idLocalidad = ?";
	private static final String readall = "SELECT * FROM localidades";
	private static final String readById = "SELECT FROM localidades WHERE idLocalidad = ?";
	private static final String update = "UPDATE localidades SET nombre = ?, idLocalidad = ?";
	public static int idLocalidad; 
//	private static final String selectID = "SELECT idLocalidad FROM localidades WHERE nombre = ?";

	
//	public int selectID() {
//		PreparedStatement statement;
//		ResultSet resultSet; //Guarda el resultado de la query
//		int localidadID = -1 ;
//		Conexion conexion = Conexion.getConexion();
//		try {
//			statement = conexion.getSQLConexion().prepareStatement(selectID);
//			resultSet = statement.executeQuery();
//			localidadID = getLocalidadDTO(resultSet).getIdLocalidad();
//		} catch (SQLException e) {
//			e.printStackTrace();		
//			}
//		return localidadID;
//	}
	
	
	
	public boolean insert(LocalidadDTO localidad)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, localidad.getIdLocalidad());
			statement.setString(2, localidad.getNombre());
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
	
	
	public void autoIncremento() {
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		Conexion conexion = Conexion.getConexion();
		int id = 0;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement("SELECT MAX(idLocalidad) FROM localidades");
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
		
		idLocalidad = id;
	}
	
	
	
	public boolean delete(LocalidadDTO localidad_a_eliminar)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setString(1, Integer.toString(localidad_a_eliminar.getIdLocalidad()));
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
	
	public List<LocalidadDTO> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<LocalidadDTO> localidades = new ArrayList<LocalidadDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				localidades.add(getLocalidadDTO(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return localidades;
	}
	public LocalidadDTO readById() {
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		LocalidadDTO localidad = new LocalidadDTO();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readById);
			resultSet = statement.executeQuery();
			localidad = getLocalidadDTO(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();		
			}
		return localidad;
	}
	
	private LocalidadDTO getLocalidadDTO(ResultSet resultSet) throws SQLException
	{
		int id = resultSet.getInt("idLocalidad");
		String nombre = resultSet.getString("Nombre");
		return new LocalidadDTO(id, nombre);
		
	}
	

	
	public boolean update(LocalidadDTO localidad) 
	{
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(update);
			statement.setInt(11, localidad.getIdLocalidad());
			statement.setString(1, localidad.getNombre());

					
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
