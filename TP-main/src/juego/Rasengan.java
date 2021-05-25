package juego;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;

import entorno.Entorno;

public class Rasengan {
	private int x;
	private int y;
	private int alto;
	private int ancho;
	private Image imagen;

	
	public Rasengan(int x, int y, int alto, int ancho) {
		this.x = x;
		this.y = y;
		this.alto = alto;
		this.ancho = ancho;
		this.imagen = new ImageIcon(getClass().getResource("Rasengan.png")).getImage();
	}

	public void dibujar(Entorno entorno) {
		entorno.dibujarImagen(this.imagen, this.x, this.y, 0);
		
	}
	
	public void moverDerecha(){
		this.x+=2;
	}
	
public void moverIzquierda(){
		this.x-=2;
	}

public void moverArriba(){
		this.y-=2;
	}

public void moverAbajo(){
		this.y+=2;
	}

	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getAlto() {
		return alto;
	}
	
	public void setAlto(int alto) {
		this.alto = alto;
	}
	public int getAncho() {
		return ancho;
	}
	
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
}


