

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.log4j.varia.NullAppender;

public class Goten {
	
	//Nombre del fichero que almacena las apuestas.
	private static final String fichero_apuestas="/home/bruno/AST/db/apuestas.txt";
	
	//Nombre y localización del fichero de logs para este programa.
	private static final String fichero_log = "/home/bruno/AST/db/goten_log.txt";
	
	//Nombres de los servicios en UDDI
	private static final String name_service_goku = "Goku";
	private static final String name_service_mundial = "Mundial";
	
	/**
	 * Permite obtener los datos de una determinada apuesta separados por "//".
	 *     - Para apuesta a partidos: Identificador de partido, goles del equipo local, goles del equipo visitante, cuota que se paga por la apuesta.
	 *     - Para apuesta a pichichi: Nombre jugador, cuota que se paga por la apuesta.
	 * En caso de pasar como identificador 0, retornará el identificador mayor actual incrementado en una unidad.
	 * @param id_a -> Idenificador de la apuesta.
	 * @return Datos de la apuesta.
	 */
	private static String verApuesta(String id_a)
	 {
		String apuesta="-1";
		ArrayList<Integer> id = new ArrayList<Integer>();
		int mayor=0;
		
		BufferedReader in = null;
		try
		 {
			in = new BufferedReader(new FileReader(fichero_apuestas));
			String l_apuesta="";
			while((l_apuesta=in.readLine())!=null)
			 {
				if(l_apuesta.equals("")) continue;
				if(id_a.equals("0"))
				 {
					id.add(Integer.parseInt(l_apuesta.split("-.-")[0]));
				 }
				else if(l_apuesta.split("-.-")[0].equals(id_a))
				 {
					apuesta = l_apuesta.split("-.-")[1];
					break;
				 }
			 }
		 }
		catch(IOException ioe)
		 {
			log(ioe.toString());
		 }
		finally
		 {
			try
				 {
				if( null != in )
				 {
					in.close();
				 }
			 }
			catch (Exception e2)
			 {
				log(e2.toString());
				return null;
			 }
		 }
		
		if(id_a.equals("0"))
		 {
			for(int i=0; i<id.size(); i++)
			 {
				if(id.get(i)>mayor) mayor=id.get(i);
			 }
			return (mayor+1)+"";
		 }
		return apuesta;
	 }
	
	
	/**
	 * Almacena los datos de una determinada apuesta separado por "//";
	 *     - Para apuesta a partidos: Identificador de partido, goles del equipo local, goles del equipo visitante, cuota que se paga por la apuesta.
	 *     - Para apuesta a pichichi: Nombre jugador, cuota que se paga por la apuesta.
	 * @param id_a -> Identificador de la apuesta.
	 * @param datos -> Datos de la apuesta separado por "//";
	 */
	private static void guardarApuesta(int id_a, String datos)
	 {
		BufferedWriter out = null;
		try
		 {
			out = new BufferedWriter(new FileWriter(fichero_apuestas, true));   
			out.write(id_a+"-.-"+datos+"\n");
		 }
		catch(Exception e1)
		 {
			log(e1.toString());
		 }
		finally
		 {
			try
				 {
				if( null != out )
				 {
					out.close();
				 }
			 }
			catch (Exception e2)
			 {
				log(e2.toString());
			 }
		 }
	 }
	
	
	
	/**
	 * Método para almacenar una linea de error en el fichero de log del programa.
	 * Se añade la fecha y hora del error, así como el nombre del programa desde el que se ha generado.
	 * @param datos -> Información del error.
	 */
	private static void log(String datos)
	 {
		BufferedWriter out = null;
		try
		 {
			Date fecha = new Date();
			out = new BufferedWriter(new FileWriter(fichero_log, true));   
			out.write(fecha+":"+" Goten -- "+datos+"\n");
		 }
		catch(Exception e1)
		 {
			e1.printStackTrace();
		 }
		finally
		 {
			try
				 {
				if( null != out )
				 {
					out.close();
				 }
			 }
			catch (Exception e2)
			 {
				e2.printStackTrace();
			 }
		 }
	 }
	
	
	/**
	 * Permite comprobar el resultado de una apuesta a un partido.
	 * @param id_a -> Identificador de la apuesta.
	 * @return Cuota por la que se paga en caso de haber acertado.
	 */
	public double comprobarApuestaPartido(int id_a)
	 {
		OMElement res = null;
		String apostado="", resultado="", goles1="", goles2="";
		double cuota=0;
		
		//Obtenemos los datos de la apuesta.
		apostado = verApuesta(id_a+"");
		
		if(apostado.equals("-1"))
			return -1;
		
		String[] datos = apostado.split("//");
		
		//Creamos el objeto servicio que nos permitirá obtener el endPoint.
		Servicio mundial = new Servicio(name_service_mundial);
		try
		 {
			cuota = Double.parseDouble(datos[3]);
			
			
			//POSTUREO, NO TOCAR.
			org.apache.log4j.BasicConfigurator.configure(new NullAppender());
			
			//Instanciamos el servicio de cliente y las opciones
			ServiceClient sc = new ServiceClient();
			Options opts = new Options();
			
			opts.setAction("gameInfo");
			
			//Asignamos en las opciones la referencia al servicio externo.
			opts.setTo(new EndpointReference(mundial.getEndpoint()));
	
			//Llamamos al servicio GetCardType
			sc.setOptions(opts);
			res = sc.sendReceive(gameInfo(datos[0]));
		
			//Obtenemos los resultados del partido que corresponde a la apuesta.
			//Separamos los goles del visitante y del local.
			resultado = ((OMElement)res.getFirstElement().getChildrenWithLocalName("sScore").next()).getText();
			goles1 = resultado.split("-")[0];
			goles2 = resultado.split("-")[1];
			sc.cleanupTransport();
		 }
		catch(AxisFault af)
		 {
			log(af.toString());
			return -2;
		 }
		catch(Exception e)
		 {
			log(e.toString());
			return -3;
		 }
		
		//En caso de que la apuesta haya sido acertada retornamos la cuota de la apuesta.
		//En otro caso retornamos 0.
		if(goles1.equals(datos[1]) && goles2.equals(datos[2]))
		 {
			return cuota;
		 }
		else
		 {
			return 0;
		 }
	 }
	
	
	/**
	 * Permite comprobar el resultado de una apuesta a un pichichi.
	 * @param id_a -> Identificador de la apuesta.
	 * @return Cuota por la que se paga en caso de haber acertado.
	 */
	public double comprobarApuestaPichichi(int id_a)
	 {
		ServiceClient sc = null;
		OMElement res = null;
		String apostado="";
		double cuota=0;
		
		//Obtenemos los datos de la apuesta
		apostado = verApuesta(id_a+"");
		if(apostado.equals("-1"))
			return -4;
		
		ArrayList<String> goleadores = new ArrayList<String>();
		String[] datos = apostado.split("//");
		
		//Creamos el objeto servicio que nos permitirá obtener el endPoint.
		Servicio mundial = new Servicio(name_service_mundial);
		
		try
		 {
			
			cuota = Double.parseDouble(datos[1]);
			
			//POSTUREO, NO TOCAR.
			org.apache.log4j.BasicConfigurator.configure(new NullAppender());

			//Instanciamos el servicio de cliente y las opciones
			sc = new ServiceClient();
			Options opts = new Options();

			opts.setAction("topGoalScores");
			
			//Asignamos en las opciones la referencia al servicio externo.
			opts.setTo(new EndpointReference(mundial.getEndpoint()));		
			
			//Llamamos al servicio GetCardType
			sc.setOptions(opts);
			
			res = sc.sendReceive(topGoalScores());
			
			//Obtenemos el nombre de los 3 máximos goleadores de la competición.
			Iterator<OMElement> it = res.getFirstElement().getChildElements();
			while(it.hasNext())
			 {
				goleadores.add(((OMElement)it.next().getChildrenWithLocalName("sName").next()).getText());
			 }

			sc.cleanupTransport();
		 }
		catch(AxisFault af)
		 {
			log(af.toString());
			return -5;
		 }
		catch(NumberFormatException ne)
		 {
			log(ne.toString());
			return -6;
		 }
		catch(Exception e)
		 {
			log(e.toString());
			return -7;
		 }
	
		//Si el jugador por el que se a apostado se sitúa de primero en la lista de goleadores se devuelve la cuota integra, en caso de estar en segundo lugar
		//se devuelve la mitad de la cuota y en caso de estar de tercero la cuarta parte de la cuota, en otro caso 0.
		if(datos[0].equals(goleadores.get(0)))
		 {
			return cuota;
		 }
		else if(datos[0].equals(goleadores.get(1)))
		 {
			cuota = cuota/2;
			cuota = Math.rint(cuota*100)/100;
			return cuota;
		 }
		else if(datos[0].equals(goleadores.get(2)))
		 {
			cuota = cuota/4;
			cuota = Math.rint(cuota*100)/100;
			return cuota;
		 }
		else
			return 0.0;
	 }
	
	
	/**
	 * Permite realizar una apuesta a un partido.
	 * @param id_p -> Identificado del partido por el que se quiere apostar.
	 * @param goles_e1 -> Goles del equipo local.
	 * @param goles_e2 -> Goles del equipo visitante.
	 * @return -> Retorna el identificador con el que se a almacenado la apuesta.
	 */
	public int realizarApuestaPartido(int id_p, int goles_e1, int goles_e2)
	 {
		double cuota=0;
		
		//Obtenemos el nuevo identificador de la apuesta.
		String sid_a = verApuesta("0");
		int id_a=0;
		try
		 {
			id_a = Integer.parseInt(sid_a);
		 }
		catch(Exception e)
		 {
			log(e.toString());
			return -1;
		 }
		
		//Se calcula una cuota aleatoria
		//Este proceso se repite en caso de dar el valor 1
		while((cuota=Math.random()*25+1)==1);
		//Redondeamos la cuota a 2 decimales
		cuota = Math.rint(cuota*100)/100;
		
		//Almacenamos la apuesta.
		guardarApuesta(id_a, id_p+"//"+goles_e1+"//"+goles_e2+"//"+cuota);
		
		return id_a;
	 }
	
	
	/**
	 * Permite realizar una apuesta a un jugador.
	 * @param jugador -> Nombre del jugador por el que se quiere apostar.
	 * @return -> Retorna el identificador con el que se a almacenado la apuesta.
	 */
	public int realizarApuestaPichichi(String jugador)
	 {
		double cuota=0;
		
		//Obtenemos el nuevo identificador de la apuesta.
		String sid_a = verApuesta("0");
		int id_a=0;
		try
		 {
			id_a = Integer.parseInt(sid_a);
		 }
		catch(Exception e)
		 {
			log(e.toString());
			return -1;
		 }
		
		if(jugador==null) return -1;
		
		//Se calcula una cuota aleatoria
		//Este proceso se repite en caso de dar el valor 1
		while((cuota=Math.random()*25+1)==1);
		//Redondeamos la cuota a 2 decimales
		cuota = Math.rint(cuota*100)/100;
		
		//Almacenamos los datos de la apuesta.
		guardarApuesta(id_a, jugador+"//"+cuota);
		
		return id_a;
	}
	
	
	/**
	 * Este método es llamado exclusivamente por el administrador para indicar que a finalizado un partido.
	 * Comprobará si existe alguna apuesta referente a este partido y llamará a la función apuestaFinalizada del servidor principal
	 * que llevará a cabo el pago del mismo.
	 * @param id_p identificador del partido
	 */
	public void partidoFinalizado(int id_p)
	 {
		
	 }
	
	
	/**
	 * Este método es llamado exclusivamente por el administrador para indicar que a finalizado la competición.
	 * Llamará a la función apuestaFinalizada del servidor principal por cada apuesta, que llevará a cabo el pago.
	 */
	public void competicionFinalizada()
	 {
		
	 }
	
	
	//*************************************************************************************************************************//
	//							Métodos para contruir el mensaje de llamada a cada servicio externo							   //
	//*************************************************************************************************************************//

	
	private OMElement gameInfo(String valor)
	 {
		OMFactory fac = OMAbstractFactory.getOMFactory();
		OMNamespace omNs = fac.createOMNamespace( "http://footballpool.dataaccess.eu", "");
		OMElement method = fac.createOMElement("GameInfo", omNs);
		OMElement value = fac.createOMElement("iGameId", omNs);
		value.setText(valor);
		method.addChild(value);
		return method;
	 }
	
	private OMElement topGoalScores()
	 {
		OMFactory fac = OMAbstractFactory.getOMFactory();
		OMNamespace omNs = fac.createOMNamespace( "http://footballpool.dataaccess.eu", "");
		OMElement method = fac.createOMElement("TopGoalScorers", omNs);
		OMElement value = fac.createOMElement("iTopN", omNs);
		value.setText("3");
		method.addChild(value);
		return method;
	 }
 }