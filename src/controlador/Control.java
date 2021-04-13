package controlador;

import java.util.ArrayList;

import logica.Cuento;
import logica.Elemento;
import logica.Escena;
import processing.core.PImage;
import vista.Principal;

public class Control {

	private int pantalla;
	private Cuento logica;
	private Principal vista;
	
	public Control() {
		pantalla = 0;
		logica = new Cuento();
	}
	
	public void agregarEscena(Escena miEscena) {
		logica.agregarEscena(miEscena);
	}
	
	public Escena[] darEscenas(){
		return logica.darEscena();
	}
	
	public void plusPantalla() {
		pantalla++;
	}
	
	public void menosPantalla () {
		pantalla--;
	}
	
	public ArrayList<String> exportarTexto(){
		return logica.cambioTexto(logica.darCuento());
	}
	
	public void setPantalla (int pantalla) {
		this.pantalla = pantalla;
	}
	
	public int darPantalla() {
		return pantalla;
	}

}
