package dto;

public class ProvinciaDTO 
{

	private String nombre;
	private LocalidadDTO localidad;
	private int idProvincia;
	private int idLocalidad;
	
	public ProvinciaDTO(int idProvincia, String nombre, LocalidadDTO localidad, int idLocalidad) {
		this.idProvincia = idProvincia;
		this.nombre = nombre;
		this.localidad = localidad;
		this.idLocalidad = idLocalidad;
	}

	public ProvinciaDTO(int idProvincia, String nombre, int idLocalidad) {
		this.idProvincia = idProvincia;
		this.nombre = nombre;
		this.idLocalidad = idLocalidad;
	}
	
	public ProvinciaDTO(String nombre, int idLocalidad) {
		this.nombre = nombre;
		this.idLocalidad = idLocalidad;
	}
	
	public ProvinciaDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public int getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalidadDTO getLocalidad() {
		return localidad;
	}

	public void setLocalidad(LocalidadDTO localidad) {
		this.localidad = localidad;
	}

	public int getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(int idLocalidad) {
		this.idLocalidad = idLocalidad;
	}
	
	
	
}
