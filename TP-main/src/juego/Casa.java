package juego;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;

import entorno.Entorno;

public class Casa {
	private int x;
	private int y;
	private int ancho;
	private int alto;
	private boolean yaFueSeleccionada;
	private boolean pasoSakura;
	private Image imagen;
	private Image inquilino;
	
	public Casa(int x, int y,String tipoCasa) {
		this.x = x;
		this.y = y;
		this.ancho = 60;
		this.alto = 60;
		this.yaFueSeleccionada=false;
		this.pasoSakura=false;
		this.imagen = new ImageIcon(getClass().getResource(tipoCasa)).getImage();
		this.inquilino = new ImageIcon(getClass().getResource(dameInquilino())).getImage();
	}
	
	public void dibujar(Entorno entorno) {
		if(this.isYaFueSeleccionada() && !this.isPasoSakura()) {
			entorno.dibujarImagen(this.imagen, this.x, this.y, 0);
			entorno.dibujarImagen(this.inquilino, this.x, this.y, 0);
		}
		else {
			entorno.dibujarImagen(this.imagen, this.x, this.y, 0);
		}
	}
	
	//Inicializacion de casas
	public static Casa [] obternerCasas() {
		Casa[] casas= new Casa [34];
		casas[0]= new Casa(770,561,"static/Casa1.png");
	    casas[1]= new Casa(130,34,"static/Casa2.png");
	    casas[2]= new Casa(230,36,"static/Casa3.png");
	    casas[3]= new Casa(670,562,"static/Casa3.png");
	    casas[4]= new Casa(440,34,"static/Casa2.png");
	    casas[5]= new Casa(530,36,"static/Casa3.png");
	    casas[6]= new Casa(640,34,"static/Casa1.png");
	    casas[7]= new Casa(500,561,"static/Casa2.png");
	    casas[8]= new Casa(172,140,"static/Casa3.png");
	    casas[9]= new Casa(363,140,"static/Casa1.png");
	    casas[10]= new Casa(563,140,"static/Casa2.png");
	    casas[11]= new Casa(40,187,"static/Casa3.png");
	    casas[12]= new Casa(240,185,"static/Casa1.png");
	    casas[13]= new Casa(440,185,"static/Casa2.png");
	    casas[14]= new Casa(750,187,"static/Casa3.png");
	    casas[15]= new Casa(650,185,"static/Casa1.png");
	    casas[16]= new Casa(163,300,"static/Casa2.png");
	    casas[17]= new Casa(372,300,"static/Casa3.png");
	    casas[18]= new Casa(564,300,"static/Casa1.png");
	    casas[19]= new Casa(40,335,"static/Casa2.png");
	    casas[20]= new Casa(240,336,"static/Casa3.png");
	    casas[21]= new Casa(440,335,"static/Casa1.png");
	    casas[22]= new Casa(650,335,"static/Casa2.png");
	    casas[23]= new Casa(750,336,"static/Casa3.png");
	    casas[24]= new Casa(165,440,"static/Casa1.png");
	    casas[25]= new Casa(365,440,"static/Casa2.png");
	    casas[26]= new Casa(572,440,"static/Casa3.png");
	    casas[27]= new Casa(40,485,"static/Casa1.png");
	    casas[28]= new Casa(235,485,"static/Casa2.png");
	    casas[29]= new Casa(440,487,"static/Casa3.png");
	    casas[30]= new Casa(650,485,"static/Casa1.png");
	    casas[31]= new Casa(750,485,"static/Casa2.png");
	    casas[32]= new Casa(100,562,"static/Casa3.png");
	    casas[33]= new Casa(300,561,"static/Casa1.png");
	    
	    return casas;
	}
	
    public static Casa obtenerCasaEntregarFlores(Casa[] casas){
        int cantidadCasas = casas.length;
        int i = Util.random(0, cantidadCasas-1);
        if(casas[i].isYaFueSeleccionada()) {
        	return obtenerCasaEntregarFlores(casas);
        }
        casas[i].setYaFueSeleccionada(true);
        return casas[i];
    }
    
    private String dameInquilino() {
    	int i = Util.random(0, 2);
    	if(i == 0) {
    		return "static/recibe1.png";
    	}
    	else if(i == 1) {
    		return "static/recibe2.png";
    	}else {
    		return "static/recibe3.png";
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

	public boolean isYaFueSeleccionada() {
		return yaFueSeleccionada;
	}

	public void setYaFueSeleccionada(boolean yaFueSeleccionada) {
		this.yaFueSeleccionada = yaFueSeleccionada;
	}

	public boolean isPasoSakura() {
		return pasoSakura;
	}

	public void setPasoSakura(boolean pasoSakura) {
		this.pasoSakura = pasoSakura;
	}
}
