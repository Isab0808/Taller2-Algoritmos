package logica;

import processing.core.PImage;

public class Escena {
	
	private Elemento miElemento;
	PImage escena1;
	
	public Escena() {
		this.miElemento = new Elemento();
		this.escena1 = null;
	}
	public Escena(Elemento miElemento, PImage escena) {
		this.miElemento = miElemento;
		this.escena1 = escena;
	}
	
	public PImage darImagen() {
		return escena1;
	}
	
	public Elemento darElemento() {
		return miElemento;
	}

}
