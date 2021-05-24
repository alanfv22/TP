package juego;

import java.awt.Color;

import entorno.Entorno;

public class Calle {
	private int x;
	private int y;
	private int ancho;
	private int alto;
	
	public Calle(int x, int y, int ancho, int alto) {
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
	}
	
	public void dibujar(Entorno entorno) {
		entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.gray);
	}

	//Inicializacion de calles
	public static Calle[] obtenerCalles () {
		Calle[] calles= new Calle [7];
		
		calles[0] = new Calle(400,75,800,25);//horizontal
        calles[1] = new Calle(400,225,800,25);//horizontal
        calles[2] = new Calle(400,375,800,25);//horizontal
        calles[3] = new Calle(400,525,800,25);//horizontal
        calles[4] = new Calle(200,300,25,600);//vertical
        calles[5] = new Calle(400,300,25,600);//vertical
        calles[6] = new Calle(600,300,25,600);//vertical
        
        return calles;
	}
}
