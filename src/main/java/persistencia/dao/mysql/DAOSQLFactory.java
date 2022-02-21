/**
 * 
 */
package persistencia.dao.mysql;

import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.LocalidadDAO;
import persistencia.dao.interfaz.PaisDAO;
import persistencia.dao.interfaz.DomicilioDAO;

import persistencia.dao.interfaz.PersonaDAO;
import persistencia.dao.interfaz.ProvinciaDAO;

public class DAOSQLFactory implements DAOAbstractFactory 
{
	/* (non-Javadoc)
	 * @see persistencia.dao.interfaz.DAOAbstractFactory#createPersonaDAO()
	 */
	public PersonaDAO createPersonaDAO() 
	{
				return new PersonaDAOSQL();
	}
	
	public PaisDAO createPaisDAO() 
	{
				return new PaisDAOSQL();
	}

	public ProvinciaDAO createProvinciaDAO() 
	{
				return new ProvinciaDAOSQL();
	}
	
	public LocalidadDAO createLocalidadDAO() 
	{
				return new LocalidadDAOSQL();
	}
	
	
	@Override
	public DomicilioDAO cretaePersonaDAO() {
		// TODO Auto-generated method stub
		return new DomicilioDAOSQL ();

	}

}
