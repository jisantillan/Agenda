package persistencia.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.PaisDAO;
import dto.PaisDTO;


public class PaisDAOSQL implements PaisDAO
{
	private static final String insert = "INSERT INTO paises(idPais, nombre, idProvincia) VALUES(?, ?, ?)";
	private static final String delete = "DELETE FROM paises WHERE idPais = ?";
	private static final String readall = "SELECT * FROM paises";
	private static final String readById = "SELECT FROM paises WHERE idPais = ?";
	private static final String update = "UPDATE paises SET nombre = ?, idProvincia = ? WHERE idPais = ?";
		
	public boolean insert(PaisDTO pais)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, pais.getIdPais());
			statement.setString(2, pais.getNombre());
			statement.setLong(3, pais.getIdProvincia());
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
	
	public boolean delete(PaisDTO pais_a_eliminar)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setString(1, Integer.toString(pais_a_eliminar.getIdPais()));
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
	
	public List<PaisDTO> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<PaisDTO> paises = new ArrayList<PaisDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				paises.add(getPaisDTO(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return paises;
	}
	public PaisDTO readById() {
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		PaisDTO pais = new PaisDTO();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readById);
			resultSet = statement.executeQuery();
			pais = getPaisDTO(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();		
			}
		return pais;
	}
	
	private PaisDTO getPaisDTO(ResultSet resultSet) throws SQLException
	{
		int id = resultSet.getInt("idPais");
		String nombre = resultSet.getString("Nombre");
		int idProvincia =  resultSet.getInt("idProvincia");
		return new PaisDTO(id, nombre, idProvincia);
		
	}
	
	public boolean update(PaisDTO pais) 
	{
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(update);
			statement.setInt(11, pais.getIdPais());
			statement.setString(1, pais.getNombre());
			statement.setInt(11, pais.getIdProvincia());
					
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
