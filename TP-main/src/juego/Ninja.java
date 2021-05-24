package juego;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;

import entorno.Entorno;

public class Ninja {
	private double x;
	private double y;
	private int ancho;
	private int alto;
	private Image imagen;
	
	
	public Ninja(int x, int y, String tipoNinja) {
		this.x = x;
		this.y = y;
		this.ancho = 25;
		this.alto = 25;
		this.imagen = new ImageIcon(getClass().getResource(tipoNinja)).getImage();
	}

	public void dibujar(Entorno entorno) {
		entorno.dibujarImagen(this.imagen, this.x, this.y, 0);
	}
	
	public static Ninja[] obtenerNinjas () {
		Ninja [] ninjas= new Ninja [7];
	  
		ninjas[0] = new Ninja(0,75,"Ninja1.png");//Movimiento Izq-Der
		ninjas[2]= new Ninja(0,225,"Ninja2.png");//Movimiento Izq-Der
		ninjas[4] = new Ninja(0,375,"Ninja3.png");//Movimiento Izq-Der
		ninjas[6] = new Ninja(0, 525,"Ninja1.png"); // Movimiento Izq- Der
		ninjas[1] = new Ninja(200,0,"Ninja2.png");//Movimiento Arr-Aba
		ninjas[3] = new Ninja(400,0,"Ninja3.png");//Movimiento Arr-Aba
		ninjas[5] = new Ninja(600,0,"Ninja1.png");//Movimiento Arr-Aba
		
	
		return ninjas;
	}
	
	// Movimiento
	public void moverDerecha(){
		this.x++;
	}
	
	public void moverAbajo(){
		this.y++;
	}
	public void moverDerechaFurious() {
		this.x+=1.5;
	}
	public void moverAbajoFurious() {
		this.y+=1.5;
	}

	
	// set and get
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}
}
