package logica;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Properties;

import processing.core.PImage;

public class Cuento {
	private ArrayList <String> texto;
	private Escena [] escenitas;
	
	public Cuento() {
		texto = new ArrayList<String>();
		escenitas = new Escena [11];
		for (int i = 0; i < escenitas.length; i++) {
			escenitas[i] = new Escena();
		}
		try {
			cargarArchivo();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void cargarArchivo() throws Exception {
		FileReader fr = null;
		File prueba = new File("cuento.txt");
		try {
			fr = new FileReader(prueba);
			BufferedReader br = new BufferedReader(fr);
			String linea;
	        while((linea=br.readLine())!=null)
	          texto.add(linea);
		} catch (Exception e) {
			 e.printStackTrace();
		}
		finally{
			         try{                    
			            if( null != fr ){   
			               fr.close();     
			            }                  
			         }catch (Exception e2){ 
			            e2.printStackTrace();
			         }
			      }
	}
	
	public ArrayList<String> darCuento() {
		return texto;
	}
	
	public void agregarEscena(Escena miEscena) {
		boolean salir = false;
		for (int i = 0; i < escenitas.length; i++) {
			if (escenitas[i].darElemento().getTipo() !=1 && !salir) {
				escenitas[i] = miEscena;
				salir = true;
			}
		}
	}
	
	public static void main (String[] args) {
		Cuento miCuento = new Cuento();
		try {
			miCuento.cargarArchivo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int i = 0; i < miCuento.cambioTexto(miCuento.darCuento()).size(); i++) {
			System.out.println(miCuento.cambioTexto(miCuento.darCuento()).get(i));
		}
		miCuento.cambioTexto(miCuento.darCuento());
	}

	public Escena[] darEscena() {
		return escenitas;
	}
	
	public ArrayList<String> cambioTexto(ArrayList<String> cuento) {
		String[] comparar = {"sol,","estrella","brinco","arbol","salvavidas","nave","espacial,"};
		ArrayList<String> frases = new ArrayList<String>();
		for (int i = 0; i < cuento.size(); i++) {
			String linea = cuento.get(i);
			String[] palabras = linea.split(" ");
			String temporal = "";
			for (int j = 0; j < palabras.length; j++) {
				for (int l = 0; l < comparar.length; l++) {
					if (palabras[j].equalsIgnoreCase(comparar[l])) {
						palabras[j] = palabras[j].toUpperCase();
					}
				}
				temporal+= palabras[j] + " ";
			}
			frases.add(temporal);
		}
		return frases;
	}
}
