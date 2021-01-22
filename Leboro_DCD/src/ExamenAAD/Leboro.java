package ExamenAAD;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Leboro {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = factoria.newDocumentBuilder();
		FileInputStream fis = new FileInputStream(new File("C:\\Users\\diego\\Desktop\\2º DAM\\AAD\\pruebas\\leboro.xml"));
		Document leer = db.parse(fis);
		
		NodeList codequipo = leer.getElementsByTagName("codequipo");
		NodeList nombreEq = leer.getElementsByTagName("nombreEq");
		NodeList Ciudad = leer.getElementsByTagName("Ciudad");
		NodeList anho = leer.getElementsByTagName("anho");
		NodeList codjugador = leer.getElementsByTagName("codjugador");
		NodeList nombreJu = leer.getElementsByTagName("nombreJu");
		NodeList posicion = leer.getElementsByTagName("posicion");
		NodeList codequipoJu = leer.getElementsByTagName("codequipoJu");

		
		for (int i = 0; i < codequipo.getLength(); i++)
			if(codequipo.item(i).getTextContent().equals("200")) {
				System.out.println("El nombre del equipo con el código 200 es: " + nombreEq.item(i).getTextContent());
			}
		for (int i = 0; i < codjugador.getLength(); i++)
			if(codjugador.item(i).getTextContent().equals("50")) {
				System.out.println("El nombre del jugador con el código 50 es: " + nombreJu.item(i).getTextContent());
			}
		for (int i = 0; i < codjugador.getLength(); i++)
			if(codjugador.item(i).getTextContent().equals("40")) {
				System.out.println("La posición del jugador con el código 40 es: " + posicion.item(i).getTextContent());
			}

		for(int i = 0; i < codequipo.getLength(); i++) {	
			String equipos[] = {codequipo.item(i).getTextContent(),nombreEq.item(i).getTextContent(),Ciudad.item(i).getTextContent(),anho.item(i).getTextContent()};
	        }
		for(int i = 0; i < codjugador.getLength(); i++) {
			String jugadores[] = {codjugador.item(i).getTextContent(),nombreJu.item(i).getTextContent(),posicion.item(i).getTextContent(),codequipoJu.item(i).getTextContent()};
			}
		
		Path rutaEquipos = Paths.get("C:\\Users\\diego\\Desktop\\equipos.csv");
		BufferedWriter bwequipos = Files.newBufferedWriter(rutaEquipos);
	
		
		Path rutaJugadores = Paths.get("C:\\Users\\diego\\Desktop\\jugadores.csv");
		BufferedWriter bwjugadores = Files.newBufferedWriter(rutaJugadores);		
		
		for(int i = 0; i<codequipo.getLength(); i++) {
			bwequipos.write(codequipo.item(i).getTextContent() + "; " + nombreEq.item(i).getTextContent() + "; " + Ciudad.item(i).getTextContent() + "; " + anho.item(i).getTextContent());
		}
		bwequipos.flush();
		bwequipos.close();
		for(int i = 0; i<codjugador.getLength(); i++) {
			bwequipos.write(codjugador.item(i).getTextContent() + "; " + nombreJu.item(i).getTextContent() + "; " + posicion.item(i).getTextContent() + "; " + codequipoJu.item(i).getTextContent());
		}
		bwjugadores.flush();
		bwjugadores.close();
	}

}
