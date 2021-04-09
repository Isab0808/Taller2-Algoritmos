package logica;

import processing.core.PImage;

public class Elemento {

	public String nombre;
	public boolean estado;
	public int tipo;
	public int posX, posY;
	
	PImage imagen;
	
	public Elemento() {
		this.nombre = "";
		this.estado = false;
		this.tipo = 0;
		this.imagen = null;
	}
	
	public Elemento(String nombre, boolean estado, int tipo, PImage imagen, int posX, int posY) {
		this.nombre = nombre;
		this.estado = estado;
		this.tipo = tipo;
		this.imagen = imagen;
		this.posX = posX;
		this.posY = posY;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public PImage getImagen() {
		return imagen;
	}

	public void setImagen(PImage imagen) {
		this.imagen = imagen;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	
	
	

}
