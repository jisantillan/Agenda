package dto;

public class DomicilioDTO 
{
	private String calle;
	private String altura;
	private String depto;
	private String piso;
	private String localidad;
	private String provincia;
	private String pais;
	private String codPostal;
	
	


	private int idDomicilio;
	
	public DomicilioDTO(int idDomicilio, String calle, String altura, String depto, String piso, String pais, String provincia, String localidad, String codPostal) {
		this.idDomicilio = idDomicilio;
		this.calle = calle;
		this.altura = altura;
		this.depto = depto;
		this.piso = piso;
		this.localidad = localidad;
		this.pais = pais;
		this.provincia = provincia;
		this.codPostal = codPostal;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getAltura() {
		return altura;
	}
	public void setAltura(String altura) {
		this.altura = altura;
	}
	public String getDepto() {
		return depto;
	}
	
	public int getIdDomicilio() {
		return idDomicilio;
	}


	public void setIdDomicilio(int idDomicilio) {
		this.idDomicilio = idDomicilio;
	}


	public void setDepto(String depto) {
		this.depto = depto;
	}
	public String getPiso() {
		return piso;
	}
	public void setPiso(String piso) {
		this.piso = piso;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	public String getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idDomicilio;
		result = prime * result + ((localidad == null) ? 0 : localidad.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DomicilioDTO other = (DomicilioDTO) obj;
		if (idDomicilio != other.idDomicilio)
			return false;
		if (localidad == null) {
			if (other.localidad != null)
				return false;
		} else if (!localidad.equals(other.localidad))
			return false;
		return true;
	}
}
