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
	Elemento sel2;
	
	
	//PImage fondos
	PImage[] escenas;
	
	//PImage Elementos Oprimidos
	PImage[] elemenOprimido;
	
	//PImage Botones
	PImage[] botones;
	
	// PImage individuales (elementos)
	PImage sol;
	PImage estrella;
	PImage niño;
	PImage arbol;
	PImage salvaVidas;
	PImage naveEspacial;
	
	private Control controlador;
	
	@Override
	public void setup() {
		sel = null;
	// Cargando PImages fondos
		escenas = new PImage[11];
		escenas[0] = loadImage("PantallaInicio.jpg");
		escenas[1] = loadImage("Escena1.jpg");
		escenas[2] = loadImage("Escena1-1.jpg");
		escenas[3] = loadImage("Escena2.jpg");
		escenas[4] = loadImage("Escena2-2.jpg");
		escenas[5] = loadImage("Escena3.jpg");
		escenas[6] = loadImage("Escena3-1.jpg");
		escenas[7] = loadImage("Escena4.jpg");
		escenas[8] = loadImage("Escena4-1.jpg");
		escenas[9] = loadImage("Escena5.jpg");
		escenas[10] = loadImage("Escena5-1.jpg");
		
	// Cargando PImages Elementos Oprimidos
		elemenOprimido = new PImage[5];
		elemenOprimido[0] = loadImage("SolOprimido.png");
		elemenOprimido[1] = loadImage("ArbolOprimido.png");
		elemenOprimido[2] = loadImage("SalvavidasOprimido.png");
		elemenOprimido[3] = loadImage("NaveEspacialOprimido.png");
		elemenOprimido[4] = loadImage("EstrellaOprimida.png");
		
	// Cargando PImages Botones
		botones = new PImage[2];
		botones[0] = loadImage("BotonInicioOprimido.png");
		botones[1] = loadImage("BotonFinOprimido.png");
		
	// Cargando PImages individuales
		sol = loadImage("Sol.png");
		estrella = loadImage("Estrella.png");
		niño = loadImage("Niño.png");
		arbol = loadImage("Arbol.png");
		salvaVidas = loadImage("Salvavidas.png");
		naveEspacial = loadImage("NaveEspacial.png");
		
	//Creacion de elementos
		Elemento elementoSol = new Elemento("Sol", false, 1, sol, 100,100);
		Elemento elementoEstrella = new Elemento("Estrella", false, 1, estrella, 248,94);
		Elemento elementoNiño = new Elemento("Niño", false, 1, niño, 255,610);
		Elemento elementoArbol = new Elemento("Arbol", false, 1, arbol, 520,300);
		Elemento elementoSalva = new Elemento("SalvaVidas", false, 1, salvaVidas, 255,255);
		Elemento elementoNave = new Elemento("NaveEspacial", false, 1, naveEspacial, 255,255);
		
	//Creacion de escenas
		Escena pantallaInicio = new Escena(new Elemento("",false,1,null, 255,255), escenas[0]); 
		Escena escena1 = new Escena(elementoSol, escenas[1]); 
		Escena escena1_1 = new Escena(elementoEstrella, escenas[2]); 
		Escena escena2 = new Escena(elementoNiño, escenas[3]); 
		Escena escena2_2 = new Escena(new Elemento("",false,1,null, 255,255), escenas[4]); 
		Escena escena3 = new Escena(elementoArbol, escenas[5]); 
		Escena escena3_1 = new Escena(new Elemento("",false,1,null, 255,255), escenas[6]); 
		Escena escena4 = new Escena(elementoSalva, escenas[7]); 
		Escena escena4_1 = new Escena(new Elemento("",false,1,null, 255,255), escenas[8]); 
		Escena escena5 = new Escena(elementoNave, escenas[9]); 
		Escena escena5_1 = new Escena(new Elemento("",false,1,null, 255,255), escenas[10]);
		
		controlador = new Control();
		
		controlador.agregarEscena(pantallaInicio);
		controlador.agregarEscena(escena1);
		controlador.agregarEscena(escena1_1);
		controlador.agregarEscena(escena2);
		controlador.agregarEscena(escena2_2);
		controlador.agregarEscena(escena3);
		controlador.agregarEscena(escena3_1);
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
			//ESCENA 1 SOL
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
			break;
		case 2:
			//ESCENA 1-1 ESTRELLA
			//Imagen Escena 2
			image(controlador.darEscenas()[2].darImagen(), 0, 0);
			
			//Imagen Elemento de Escena 2 - ESTRELLA
			imageMode(CENTER);
			image(controlador.darEscenas()[2].darElemento().getImagen(),controlador.darEscenas()[2].darElemento().getPosX(),controlador.darEscenas()[2].darElemento().getPosY());
			imageMode(CORNER);
			
			// Si esta el mouse encima del Boton mostrar imagen Boton Inicio Oprimido
			if (mouseX > 248 && mouseX < 248 + 65 && mouseY > 94 && mouseY < 94 + 64) {
			image(elemenOprimido[4], controlador.darEscenas()[2].darElemento().getPosX()-32, controlador.darEscenas()[2].darElemento().getPosY()-32);
			}
			break;
		case 3:
			//ESCENA 2 BRINCA
			//Imagen Escena 2
			image(controlador.darEscenas()[3].darImagen(), 0, 0);
			
			//Imagen Elemento de Escena 2 - Niño
			imageMode(CENTER);
			image(controlador.darEscenas()[3].darElemento().getImagen(),controlador.darEscenas()[3].darElemento().getPosX(),controlador.darEscenas()[3].darElemento().getPosY());
			imageMode(CORNER);
			break;
		case 4:
			//ESCENA 2-2 BRINCA
			//Imagen Escena 2-2
			image(controlador.darEscenas()[4].darImagen(), 0, 0);
			
			fill(0);
			ellipse(255, 255, 30, 30);
			
			break;
		case 5:
			//ESCENA 3 ARBOL
			//Imagen Escena 3
			image(controlador.darEscenas()[5].darImagen(), 0, 0);
			
			//Imagen Elemento de Escena 3 - Arbol
			image(controlador.darEscenas()[5].darElemento().getImagen(),controlador.darEscenas()[5].darElemento().getPosX(),controlador.darEscenas()[5].darElemento().getPosY());
			
			// Si esta el mouse encima del Boton mostrar imagen Boton Inicio Oprimido
			if (mouseX > 520 && mouseX < 520 + 276 && mouseY > 300 && mouseY < 300 + 586) {
				image(elemenOprimido[1], controlador.darEscenas()[5].darElemento().getPosX()-14, controlador.darEscenas()[5].darElemento().getPosY()+124);
			}
			break;
		case 6:
			//ESCENA 3-1 ARBOL
			//Imagen Escena 4
			image(controlador.darEscenas()[6].darImagen(), 0, 0);
			
			fill(0);
			ellipse(255, 255, 30, 30);
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
			//ESCENA 1 SOL
			//Agarrar el Elemento 1 - Sol
			if (mouseX > 100 && mouseX < 100 + 365 && mouseY > 100 && mouseY < 100 + 365) {
				sel = controlador.darEscenas()[1].darElemento();
				}
			break;
		case 2:
			//ESCENA 1-1 ESTRELLA
			if (mouseX > 248 && mouseX < 248 + 65 && mouseY > 94 && mouseY < 94 + 64) {
				controlador.plusPantalla();
				}
			break;
		case 4:
			//ESCENA 2-2 BRINCA
			if (mouseX > 255 && mouseX < 50 + 276 && mouseY > 50 && mouseY < 255 + 50) {
				controlador.plusPantalla();
				}
			break;
		case 5:
			//ESCENA 3 ARBOL
			if (mouseX > 520 && mouseX < 520 + 276 && mouseY > 300 && mouseY < 300 + 586) {
				controlador.plusPantalla();
				}
			break;
		case 6:
			//ESCENA 3-1 ARBOL
			if (mouseX > 255 && mouseX < 50 + 276 && mouseY > 50 && mouseY < 255 + 50) {
				controlador.plusPantalla();
				}
			break;
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
		switch (controlador.darPantalla()) {
		case 1:
		//Suelto el elemento - Sol, paso a la siguiente pantalla
		sel = null;
		int tempX = controlador.darEscenas()[1].darElemento().getPosX();
		int tempY = controlador.darEscenas()[1].darElemento().getPosY();
		if (tempX >89 && tempY >609 && controlador.darPantalla()==1) {
			controlador.plusPantalla();
		}
		break;
	}
}
	
	@Override
	public void keyPressed() {
		switch (controlador.darPantalla()) {
		case 3:
		//Presiono la tecla para que pase a la siguiente pantalla
		if(keyCode == UP) {
			controlador.darEscenas()[3].darElemento().setPosY(500);
		}else {
			controlador.darEscenas()[3].darElemento().setPosY(610);
			controlador.plusPantalla();
		}
		break;
	}
}

}
