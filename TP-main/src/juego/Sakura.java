package juego;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;

import entorno.Entorno;

public class Sakura {
	private int x;
	private int y;
	private int ancho;
	private int alto;
	private Image imagen;
	
	public Sakura(int x, int y,int ancho, int alto) {
		this.x= x;
		this.y= y;
		this.ancho= ancho;
		this.alto= alto;
		this.imagen = new ImageIcon(getClass().getResource("static/Sakura.gif")).getImage();
	}
	
	public void moverDerecha(){
		this.x++;
	}
	public void moverIzquierda(){
		this.x--;
	}
	public void moverArriba(){
		this.y--;
	}
	public void moverAbajo(){
		this.y++;
	}
	
	public void dibujar(Entorno entorno) {
		entorno.dibujarImagen(this.imagen, this.x, this.y, 0);
	
		
	}
	
	public  Rasengan disparar() {	
		return new Rasengan(this.x,this.y,10, 10);	
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


	
