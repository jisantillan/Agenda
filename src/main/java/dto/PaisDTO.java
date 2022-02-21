package dto;

public class PaisDTO 
{	
	private int idPais;
	private String nombre;
	private ProvinciaDTO provincia;
	private int idProvincia;
	
	public PaisDTO(String nombre, ProvinciaDTO provincia) 
	{
		super();
		this.nombre = nombre;
		this.provincia = provincia;
	}

	public PaisDTO(int idPais , String nombre, ProvinciaDTO provincia,  int idProvincia) 
	{
		super();
		this.idPais = idPais;
		this.nombre = nombre;
		this.idProvincia = idProvincia;
		this.provincia = provincia;
	}
	
	public PaisDTO(int idPais , String nombre,   int idProvincia) 
	{
		super();
		this.idPais = idPais;
		this.nombre = nombre;
		this.idProvincia = idProvincia;

	}
	
	public PaisDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public int getIdPais() {
		return idPais;
	}




	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}




	public String getNombre() 
	{
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ProvinciaDTO getProvincia() {
		return provincia;
	}

	public void setProvincia(ProvinciaDTO provincia) {
		this.provincia = provincia;
	}

	public int getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}	
	
	
	
}
