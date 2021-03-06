package presentacion.reportes;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import dto.PersonaDTO;
import dto.ReporteData;

public class ReporteAgenda
{
	private JasperReport reporte;
	private JasperViewer reporteViewer;
	private JasperPrint	reporteLleno;
	private Logger log = Logger.getLogger(ReporteAgenda.class);
	//Recibe la lista de personas para armar el reporte
    public ReporteAgenda(List<PersonaDTO> personas)
    {
    	List<ReporteData> personasReporte = obtenerDatosParaReporte(personas);

    	//Hardcodeado
		Map<String, Object> parametersMap = new HashMap<String, Object>();
		parametersMap.put("Fecha", new SimpleDateFormat("dd/MM/yyyy").format(new Date()));		
    	try		{
			this.reporte = (JasperReport) JRLoader.loadObjectFromFile( "reportes" + File.separator + "ReporteAgenda.jasper" );
			this.reporteLleno = JasperFillManager.fillReport(this.reporte, parametersMap, 
					new JRBeanCollectionDataSource(personasReporte));
    		log.info("Se cargó correctamente el reporte");
		}
		catch( JRException ex ) 
		{
			log.error("Ocurrió un error mientras se cargaba el archivo ReporteAgenda.Jasper", ex);
		}
    }       
    
    public void mostrar()
	{
		this.reporteViewer = new JasperViewer(this.reporteLleno,false);
		this.reporteViewer.setVisible(true);
	}
    
    private List<ReporteData> obtenerDatosParaReporte(List<PersonaDTO> personasDTO)
	{
		List<ReporteData> personas = new ArrayList<ReporteData>();
		for(PersonaDTO p : personasDTO)
		{
			personas.add(new ReporteData(p.getNombre(), p.getTelefono(), p.getEmail(), p.getFechaNac(), p.getDomicilio().getCalle(), p.getDomicilio().getAltura(), p.getDomicilio().getPiso(), p.getDomicilio().getDepto(), p.getDomicilio().getLocalidad(), p.getTipoDeContacto(),p.getSignoZodiacal().toString(),p.getDomicilio().getCodPostal()));
		}
		return personas;
	}
   
}	