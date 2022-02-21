package dto;

public class PersonaDTO 
{
	

	private int idPersona;
	private String nombre;
	private String telefono;
	private DomicilioDTO domicilio;
	private String signo;
	private String email;
	private String tipoDeContacto;
	private String fechaNac;

	private SignoZodiacal signoZodiacal;

	public PersonaDTO(int idPersona, String nombre, String telefono, DomicilioDTO domicilio, String email, String tipoDeContacto, String fechaNac,  String signoZodiacal )
	{
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.telefono = telefono;
		this.domicilio = domicilio;
		this.email = email;
		this.tipoDeContacto = tipoDeContacto;
		this.fechaNac = fechaNac;
		this.setSignoZodiacal(signoZodiacal);
	}
		
//	public PersonaDTO(int idPersona, String nombre, String telefono) {
//		this.idPersona = idPersona;
//		this.nombre = nombre;
//		this.telefono = telefono;
//		}
	
	public PersonaDTO() {
		// TODO Auto-generated constructor stub
	}

	public SignoZodiacal getSignoZodiacal() {
		return signoZodiacal;
	}

	public void setSignoZodiacal(String signoZodiacal) {
		 switch (signoZodiacal.toUpperCase()) 
		 
	        {
	            case "ARIES":  this.signoZodiacal = SignoZodiacal.ARIES;
	                     break;
	            case "TAURO":  this.signoZodiacal = SignoZodiacal.TAURO;
	                     break;
	            case "GÉMINIS": this.signoZodiacal = SignoZodiacal.GÉMINIS;
	                     break;
	            case  "CÁNCER":  this.signoZodiacal = SignoZodiacal.CÁNCER;
	                     break;
	            case "LEO":  this.signoZodiacal = SignoZodiacal.LEO;
	                     break;
	            case "VIRGO":  this.signoZodiacal = SignoZodiacal.VIRGO;
	                     break;
	            case "LIBRA": this.signoZodiacal = SignoZodiacal.LIBRA;
	                     break;
	            case  "ESCORPIÓN": this.signoZodiacal = SignoZodiacal.ESCORPIÓN;
		                break;
		       case "SAGITARIO": this.signoZodiacal = SignoZodiacal.SAGITARIO;
		                break;
		       case "CAPRICORNIO": this.signoZodiacal = SignoZodiacal.CAPRICORNIO;
		                break;
		       case "ACUARIO":  this.signoZodiacal = SignoZodiacal.ACUARIO;
		                break;
		       case "PISCIS":  this.signoZodiacal = SignoZodiacal.PISCIS;
               			break;         
	           default: this.signoZodiacal = SignoZodiacal.NO_CORRESPONDE;
	                     break;
	        }
		
	}

	public String getTipoDeContacto() {
		return tipoDeContacto;
	}



	public void setTipoDeContacto(String tipoDeContacto) {
		this.tipoDeContacto = tipoDeContacto;
	}



	public String getFechaNac() {
		return fechaNac;
	}



	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}



	public String getSigno() {
		return signo;
	}

	public void setSigno(String etiqueta) {
		this.signo = etiqueta;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public DomicilioDTO getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(DomicilioDTO domicilio) {
		this.domicilio = domicilio;
	}

	public int getIdPersona() 
	{
		return this.idPersona;
	}

	public void setIdPersona(int idPersona) 
	{
		this.idPersona = idPersona;
	}

	public String getNombre() 
	{
		return this.nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public String getTelefono() 
	{
		return this.telefono;
	}

	public void setTelefono(String telefono) 
	{
		this.telefono = telefono;
	}
	@Override
	public String toString() {
		return "PersonaDTO [domicilio=" + domicilio.getCodPostal() + "]";
	}
}
