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
	Elemento sel;
	
	
	//PImage fondos
	PImage[] escenas;
	
	//PImage Elementos Oprimidos
	PImage[] elemenOprimido;
	
	//PImage Botones
	PImage[] botones;
	
	// PImage individuales (elementos)
	PImage sol;
	PImage niño;
	PImage arbol;
	PImage salvaVidas;
	PImage naveEspacial;
	
	private Control controlador;
	
	@Override
	public void setup() {
		sel = null;
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
		
	// Cargando PImages Elementos Oprimidos
		elemenOprimido = new PImage[4];
		elemenOprimido[0] = loadImage("SolOprimido.png");
		elemenOprimido[1] = loadImage("ArbolOprimido.png");
		elemenOprimido[2] = loadImage("SalvavidasOprimido.png");
		elemenOprimido[3] = loadImage("NaveEspacialOprimido.png");
		
	// Cargando PImages Botones
		botones = new PImage[2];
		botones[0] = loadImage("BotonInicioOprimido.png");
		botones[1] = loadImage("BotonFinOprimido.png");
		
	// Cargando PImages individuales
		sol = loadImage("Sol.png");
		niño = loadImage("Niño.png");
		arbol = loadImage("Arbol.png");
		salvaVidas = loadImage("Salvavidas.png");
		naveEspacial = loadImage("NaveEspacial.png");
		
	//Creacion de elementos
		Elemento elementoSol = new Elemento("Sol", false, 1, sol, 100,100);
		Elemento elementoNiño = new Elemento("Niño", false, 1, niño, 255,255);
		Elemento elementoArbol = new Elemento("Arbol", false, 1, arbol, 255,255);
		Elemento elementoSalva = new Elemento("SalvaVidas", false, 1, salvaVidas, 255,255);
		Elemento elementoNave = new Elemento("NaveEspacial", false, 1, naveEspacial, 255,255);
		
	//Creacion de escenas
		Escena pantallaInicio = new Escena(new Elemento("",false,1,null, 255,255), escenas[0]); 
		Escena escena1 = new Escena(elementoSol, escenas[1]); 
		Escena escena2 = new Escena(elementoNiño, escenas[2]); 
		Escena escena3 = new Escena(elementoArbol, escenas[3]); 
		Escena escena4 = new Escena(elementoSalva, escenas[4]); 
		Escena escena4_1 = new Escena(new Elemento("",false,1,null, 255,255), escenas[5]); 
		Escena escena5 = new Escena(elementoNave, escenas[6]); 
		Escena escena5_1 = new Escena(new Elemento("",false,1,null, 255,255), escenas[7]);
		
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
		System.out.println(mouseX + "," + mouseY);
		background(255);
			
		switch (controlador.darPantalla()) {
		case 0:
			//PANTALLA INICIO
			//Imagen Pantalla Inicio 
			image(controlador.darEscenas()[0].darImagen(), 0, 0);
			
			// Si esta el mouse encima del Boton mostrar imagen Boton Inicio Oprimido
			if (mouseX > 660 && mouseX < 660 + 388 && mouseY > 656 && mouseY < 656 + 348) {
				image(botones[0], 660, 656);
			}
			
			break;
		case 1:
			//ESCENA 1
			//Imagen Escena 1
			image(controlador.darEscenas()[1].darImagen(), 0, 0);
			
			//Imagen Elemento de Escena 1 - Sol
			imageMode(CENTER);
			image(controlador.darEscenas()[1].darElemento().getImagen(),controlador.darEscenas()[1].darElemento().getPosX(),controlador.darEscenas()[1].darElemento().getPosY());
			imageMode(CORNER);
			
			// Si esta el mouse encima del Boton mostrar imagen Boton Inicio Oprimido
			if (mouseX > 100 && mouseX < 100 + 377 && mouseY > 100 && mouseY < 100 + 377) {
				image(elemenOprimido[0], controlador.darEscenas()[1].darElemento().getPosX()-182, controlador.darEscenas()[1].darElemento().getPosY()-182);
			}
		}
	}
	
	@Override
	public void mousePressed() {
		switch (controlador.darPantalla()) {
		case 0:
			//PANTALLA INICIO
			//Si se le da clic al boton, pasar a la siguiente pantalla Escena 1
			if (mouseX > 660 && mouseX < 660 + 388 && mouseY > 656 && mouseY < 656 + 348) {
				controlador.plusPantalla();
				}
			break;
		case 1:
			//ESCENA 1
			//Agarrar el Elemento 1 - Sol
			if (mouseX > 100 && mouseX < 100 + 365 && mouseY > 100 && mouseY < 100 + 365) {
				sel = controlador.darEscenas()[1].darElemento();
				}
		}
	}
	
	@Override
	public void mouseDragged() {
		//Arrastrar el Elemento 1 - Sol
			if(sel != null) {
				sel.setPosX(mouseX);
				sel.setPosY(mouseY);
		}
	}
	
	@Override
	public void mouseReleased() {
		sel = null;
		int tempX = controlador.darEscenas()[1].darElemento().getPosX();
		int tempY = controlador.darEscenas()[1].darElemento().getPosY();
		if (tempX >89 && tempY >609 && controlador.darPantalla()==1) {
			controlador.plusPantalla();
		}
	}

}
