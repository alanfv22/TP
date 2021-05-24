package juego;

import java.awt.Image;

import javax.swing.ImageIcon;

import entorno.Entorno;

public class Explosion {
	   private int x;
	    private int y;
	    private Image imagen;
	    private int tiempo;

	    public Explosion(int x, int y) {
	        this.x = x;
	        this.y = y;
	        this.imagen = new ImageIcon(getClass().getResource("explosion1.png")).getImage();
	        this.tiempo = 60;
	    }

	    public void dibujar(Entorno entorno) {
	        entorno.dibujarImagen(this.imagen, x, y, 90);
	    }

	    public void explotando() {
	        if(this.tiempo > 50) {
	            this.imagen = new ImageIcon(getClass().getResource("explosion1.png")).getImage();
	            this.tiempo--;
	        }
	        else if(this.tiempo > 40 && this.tiempo <= 50) {
	            this.imagen = new ImageIcon(getClass().getResource("explosion2.png")).getImage();
	            this.tiempo--;
	        }
	        else if(this.tiempo > 30 && this.tiempo <= 40) {
	            this.imagen = new ImageIcon(getClass().getResource("explosion3.png")).getImage();
	            this.tiempo--;
	        }
	        else if(this.tiempo > 20 && tiempo <= 30 ) {
	            this.imagen = new ImageIcon(getClass().getResource("explosion4.png")).getImage();
	            this.tiempo--;
	        }
	        else if(this.tiempo > 10 && this.tiempo <= 20) {
	            this.imagen = new ImageIcon(getClass().getResource("explosion5.png")).getImage();
	            this.tiempo--;
	        }
	        else if(this.tiempo > 0 && tiempo <= 10 ) {
	            this.imagen = new ImageIcon(getClass().getResource("explosion6.png")).getImage();
	            this.tiempo--;
	        }
	        else{
	            this.imagen = null;
	        }
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
	public Image getImagen() {
	        return imagen;
	    }

	    public void setImagen(Image imagen) {
	        this.imagen = imagen;
	    }

	    public int getTiempo() {
	        return tiempo;
	    }

	    public void setTiempo(int tiempo) {
	        this.tiempo = tiempo;
	    }
	}

