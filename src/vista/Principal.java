package vista;
import controlador.Control;
import logica.Cuento;
import logica.Elemento;
import logica.Escena;
import processing.core.PApplet;
import processing.core.PImage;

public class Principal extends PApplet{

	public static void main(String[] args) {
		PApplet.main(Principal.class.getName());
	}

	@Override
	public void settings() {
		size(933,900);
	}
	//PImage fondos
	PImage[] escenas;
	
	// PImage individuales (elementos)
	PImage sol;
	PImage niño;
	PImage arbol;
	PImage salvaVidas;
	PImage naveEspacial;
	
	private Control controlador;
	
	@Override
	public void setup() {
	// Cargando PImages fondos
		escenas = new PImage[8];
		escenas[0] = loadImage("PantallaInicio.jpg");
		escenas[1] = loadImage("Escena1.jpg");
		escenas[2] = loadImage("Escena2.jpg");
		escenas[3] = loadImage("Escena3.jpg");
		escenas[4] = loadImage("Escena4.jpg");
		escenas[5] = loadImage("Escena4-1.jpg");
		escenas[6] = loadImage("Escena5.jpg");
		escenas[7] = loadImage("Escena5-1.jpg");
		
	// Cargando PImages individuales
		sol = loadImage("Sol.png");
		niño = loadImage("Niño.png");
		arbol = loadImage("Arbol.png");
		salvaVidas = loadImage("Salvavidas.png");
		naveEspacial = loadImage("NaveEspacial.png");
		
	//Creacion de elementos
		Elemento elementoSol = new Elemento("Sol", false, 0, sol);
		Elemento elementoNiño = new Elemento("Niño", false, 0, niño);
		Elemento elementoArbol = new Elemento("Arbol", false, 0, arbol);
		Elemento elementoSalva = new Elemento("SalvaVidas", false, 0, salvaVidas);
		Elemento elementoNave = new Elemento("NaveEspacial", false, 0, naveEspacial);
		
	//Creacion de escenas
		Escena pantallaInicio = new Escena(new Elemento(), escenas[0]); 
		Escena escena1 = new Escena(elementoSol, escenas[1]); 
		Escena escena2 = new Escena(elementoNiño, escenas[2]); 
		Escena escena3 = new Escena(elementoArbol, escenas[3]); 
		Escena escena4 = new Escena(elementoSalva, escenas[4]); 
		Escena escena4_1 = new Escena(new Elemento(), escenas[5]); 
		Escena escena5 = new Escena(elementoNave, escenas[6]); 
		Escena escena5_1 = new Escena(new Elemento(), escenas[7]);
		
		controlador = new Control();
		
		controlador.agregarEscena(pantallaInicio);
		controlador.agregarEscena(escena1);
		controlador.agregarEscena(escena2);
		controlador.agregarEscena(escena3);
		controlador.agregarEscena(escena4);
		controlador.agregarEscena(escena4_1);
		controlador.agregarEscena(escena5);
		controlador.agregarEscena(escena5_1);
	}
	
	@Override
	public void draw() {
		background(255);
		image(controlador.darEscenas()[0].darImagen(), 0, 0);
	}

}
