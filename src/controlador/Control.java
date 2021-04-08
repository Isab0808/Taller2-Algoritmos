package controlador;

import logica.Cuento;
import logica.Elemento;
import logica.Escena;
import processing.core.PImage;
import vista.Principal;

public class Control {

	private Cuento logica;
	private Principal vista;
	
	public Control() {
		logica = new Cuento();
	}
	
	public void agregarEscena(Escena miEscena) {
		logica.agregarEscena(miEscena);
	}
	
	public Escena[] darEscenas(){
		return logica.darEscena();
	}

}
