package persistencia.dao.interfaz;


public interface DAOAbstractFactory 
{
	public DomicilioDAO cretaePersonaDAO();
	public PersonaDAO createPersonaDAO();
	
	public PaisDAO createPaisDAO();
	
	public ProvinciaDAO createProvinciaDAO();
	
	public LocalidadDAO createLocalidadDAO();
}
