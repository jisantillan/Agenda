package dto;

public class LocalidadDTO 
{	
	private int idLocalidad;
	private String nombre;
	
	public LocalidadDTO(int idLocalidad, String nombre) 
	{
		this.nombre = nombre;
		this.idLocalidad = idLocalidad;
	}
	
	public LocalidadDTO( String nombre) 
	{
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(int idLocalidad) {
		this.idLocalidad = idLocalidad;
	}		
	
	public LocalidadDTO() {
		
	}
}
