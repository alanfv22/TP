package juego;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;

import entorno.Entorno;

public class Moneda {
	private int x;
	private int y;
	private int diametro;
	private Color color;
	private Image imagen;
	
	public Moneda(int x, int y) {
		this.x = x;
		this.y = y;
		this.diametro = 20;
		this.color = Color.yellow;
		this.imagen = new ImageIcon(getClass().getResource("Moneda.png")).getImage();
		
	}
	
	public void dibujar(Entorno entorno) {
		entorno.dibujarImagen(this.imagen, this.x, this.y, 0);
	}
	
	public static Moneda[] obtenerMonedas () {
		Moneda [] monedas= new Moneda[19];
	  
		monedas[0] = new Moneda(100,75);
		monedas[1] = new Moneda(250,75);
		monedas[2] = new Moneda(450,75);
		monedas[3] = new Moneda(600,75);
		monedas[4] = new Moneda(400,150);
		monedas[5] = new Moneda(700,375);
		monedas[6] = new Moneda(300,525);
		monedas[7] = new Moneda(100,225);
		monedas[8] = new Moneda(250,225);
		monedas[9] = new Moneda(450,225);
		monedas[10] = new Moneda(600,225);
		monedas[11] = new Moneda(100,375);
		monedas[12] = new Moneda(250,375);
		monedas[13] = new Moneda(450,375);
		monedas[14] = new Moneda(600,375);
		monedas[15] = new Moneda(100,525);
		monedas[16] = new Moneda(250,525);
		monedas[17] = new Moneda(450,525);
		monedas[18] = new Moneda(600,525);
	
		return monedas;
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

	public int getDiametro() {
		return diametro;
	}

	public void setDiametro(int diametro) {
		this.diametro = diametro;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	
	
}
