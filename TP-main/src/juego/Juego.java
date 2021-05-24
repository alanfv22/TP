package juego;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;

import entorno.Entorno;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;

	// Variables y métodos propios de cada grupo
	private Sakura sakura;
	private Rasengan rasengan;
	private Calle[] calles;
	private Casa[] casas;
	private Ninja[] ninjas;
	private int puntaje;
	private int ninjasKO;
	private Casa casaSeleccionada;
	private Image imagenFondo;
	private int dificultad;
	private Moneda moneda;
	private String ultTeclaPresionada;
	private int tiempoMonedas;
	private boolean termino;
	private boolean ganaste;
	private Explosion explosion;
	
	Juego() {
		// Inicializa el objeto entorno
		int anchoPantalla = 600;
		int altoPantalla = 800;
		this.entorno = new Entorno(this, "Sakura Ikebana Delivery - Grupo 07 - v1", altoPantalla, anchoPantalla);
		this.termino=false;
		this.ganaste=false;
		
		// Inicializar lo que haga falta para el juego
		this.sakura = new Sakura (400,300,26,26);
		this.puntaje = 0;
		this.ninjasKO = 0;
		
		//Dibujo de calles
		this.calles=Calle.obtenerCalles();	
        
        //Dibujo  de casas	
        this.casas = Casa.obternerCasas();
        this.casaSeleccionada = Casa.obtenerCasaEntregarFlores(this.casas);
 
        //Dibujo de ninjas
        this.ninjas = Ninja.obtenerNinjas();
        this.ninjas[3] = null;
        
        //Seteo dificultad
        this.dificultad = 1;
        
        // Seteo de ultima tecla presionada por defecto
        this.ultTeclaPresionada = "Up";
        
        establecerMoneda();
        this.tiempoMonedas = 0;
        
        this.imagenFondo = new ImageIcon(getClass().getResource("Fondo.jpg")).getImage();
		// Inicia el juego!
		this.entorno.iniciar();
	}

	public void tick()
	{	
		if(!termino) {
		// Dibujo Fondo
		this.entorno.dibujarImagen(this.imagenFondo, 400, 300, 0);
		
		//Dibujo fondo de marcador
		this.entorno.dibujarRectangulo(400, 0, 800, 40, 0, Color.black);
		
		// Dibujo Mapa
		for( Calle calle : calles) {
			calle.dibujar(entorno);
		}
		
		// Dibujo casa
		for(Casa casa : casas) {
			casa.dibujar(entorno);
		}
		
		// Dibujo Monedas
		if (moneda != null) {
			moneda.dibujar(entorno);
		}
		
		// Dibujo Sakura
		this.sakura.dibujar(entorno);
		
		// Dibujo ninjas
		for(Ninja ninja : ninjas){
			if(ninja != null) {
			ninja.dibujar(entorno);
		}
	}
		
		
		// SAKURA 
		// Movimientos sakura
		if(entorno.estaPresionada(this.entorno.TECLA_DERECHA) && this.sakura.getX() + this.sakura.getAncho()/2 <800 && 
				(this.sakura.getY()==75 || this.sakura.getY()==225 || this.sakura.getY()==375 || this.sakura.getY()==525)) {
			sakura.moverDerecha();
			if(this.rasengan == null) {
			this.ultTeclaPresionada = "Right";
		}}
		if(entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA) && this.sakura.getX() - this.sakura.getAncho()/2 >0 && 
				(this.sakura.getY()==75 || this.sakura.getY()==225 || this.sakura.getY()==375 || this.sakura.getY()==525)) {
			sakura.moverIzquierda();
			if(this.rasengan == null) {
			this.ultTeclaPresionada = "Left";
			}}
		if(entorno.estaPresionada(this.entorno.TECLA_ARRIBA) && this.sakura.getY() - this.sakura.getAlto()/2>0 && 
				(this.sakura.getX()==200 || this.sakura.getX()==400 || this.sakura.getX()==600)) {
			sakura.moverArriba();
			if(this.rasengan == null) {
			this.ultTeclaPresionada = "Up";
		}}
		if(entorno.estaPresionada(this.entorno.TECLA_ABAJO) && this.sakura.getY() + this.sakura.getAlto()/2 <600 && 
				(this.sakura.getX()==200 || this.sakura.getX()==400 || this.sakura.getX()==600)) {
			sakura.moverAbajo();
			if(this.rasengan == null) {
			this.ultTeclaPresionada = "Down";
		}}
		
		// ENTREGA FLORES 
        if(entregoFloresSakura(sakura, casaSeleccionada)) {
        	casaSeleccionada.setPasoSakura(true);
        	this.casaSeleccionada=Casa.obtenerCasaEntregarFlores(casas);
        }
        
        
		// DISPARA RASENGAN
        if (rasengan == null) {
        	rasenganShoot(entorno);
        } 
        else	{
        	this.rasengan.dibujar(entorno);
			switch(ultTeclaPresionada) {
			case "Down":
				rasengan.moverAbajo();
				break;
			case "Up":
				rasengan.moverArriba();
				break;
			case "Right":
				rasengan.moverDerecha();
				break;
			default:
				rasengan.moverIzquierda();
				break;	
			}
			if(rasengan.getX() < 1 || rasengan.getX() > 799 || rasengan.getY() > 599 || rasengan.getY() < 1) {
				this.rasengan=null; 
				}
			else {
				for (int i = 0; i < ninjas.length ; i++) {	
					if(ninjas[i] != null && rasengan != null) {	
						if(this.hayColisionRasengan(ninjas[i], rasengan)) {
							this.explosion=new Explosion (rasengan.getX(),rasengan.getY());
				        	this.ninjas[i] = null;
				        	this.rasengan = null;
				        	this.ninjasKO += 1;
				        }
					}
				}
			}
        }
		
        if(this.explosion != null) {
            this.explosion.dibujar(entorno);
            explosion.explotando();
            if(explosion.getTiempo() == 0) {
                this.explosion = null;
            }
        }
		// NINJAS
        
		//Movimientos ninjas 
		for (int i = 0; i < ninjas.length ; i++) { 
			if (i % 2 == 0) {
				if(ninjas[i] == null) {
					continue;
				}
				if(this.dificultad != 4) {
					ninjas[i].moverDerecha();
					if(ninjas[i].getX() > 800 - 25/2) {
						ninjas[i].setX(25/2);
				}}
				else {
					ninjas[i].moverDerechaFurious();
					if(ninjas[i].getX() > 800 - 25/2) {
						ninjas[i].setX(25/2);
				}
				}
			}else {
				if(ninjas[i] == null) {
					continue;
				}
				if(this.dificultad != 4) {
				ninjas[i].moverAbajo();
				if(ninjas[i].getY() > 600 - 25/2) {
					ninjas[i].setY(25/2);
				}}else {
					ninjas[i].moverAbajoFurious();
					if(ninjas[i].getY() > 600 - 25/2) {
						ninjas[i].setY(25/2);
				}
				}
			}
		}
		
		//COLISION SAKURA - NINJA
		for(Ninja ninja: ninjas) {
			if(ninja!=null && this.hayColision(sakura,ninja) )
				this.termino=true;
				}
		
		if (moneda != null) {
			if(obtieneMoneda(sakura, moneda)){
				this.moneda = null;
				this.puntaje += 15;
			}
		}
		
        // METER NINJA
        meterNinja(this.ninjas, this.dificultad);
        
        // MANEJADOR DE DIFICULTAD
        if(this.puntaje > 20) {
        	this.dificultad = 2;
        }
        if(this.puntaje > 40) {
        	this.dificultad = 3;
        }
        if(this.puntaje > 60) {
        	this.dificultad = 4;
        }
        
        //1400
        if(tiempoMonedas > 600) {
        	establecerMoneda();
        }
        // Marcadores
        marcador(entorno);
        this.tiempoMonedas++;
        
        if(puntaje>=80) {
        	this.ganaste=true;
        	this.termino=true;
        }
}
		else {
			if(!ganaste) {
				Image imagen= new ImageIcon(getClass().getResource("Perdiste.png")).getImage();
				entorno.dibujarImagen(imagen,400, 300,0);
			}
			else {
				Image imagen= new ImageIcon(getClass().getResource("Ganaste.png")).getImage();
				entorno.dibujarImagen(imagen,400, 300,0);
			}
		}
	}
	
	
	private boolean hayColision(Sakura sakura, Ninja ninja) {
	            return !((sakura.getX() - sakura.getAncho()/2 > ninja.getX() + ninja.getAncho()/2 )||
	            (sakura.getY() - sakura.getAlto()/2 > ninja.getY() + ninja.getAlto()/2) ||
	             (sakura.getX() + sakura.getAncho()/2 < ninja.getX() - ninja.getAncho()/2 )||
	            (sakura.getY() + sakura.getAlto()/2 < ninja.getY() - ninja.getAlto()/2));         
	        }
	
	private boolean entregoFloresSakura(Sakura sakura, Casa casa) {
	            if (!((sakura.getX() - sakura.getAncho()> casa.getX() + casa.getAncho()/4)||
	            (sakura.getY() - sakura.getAlto() > casa.getY() + casa.getAlto()/4) ||
	             (sakura.getX() + sakura.getAncho() < casa.getX() - casa.getAncho()/4)||
	            (sakura.getY() + sakura.getAlto() < casa.getY() - casa.getAlto()/4))) {
	            	this.puntaje += 5;
	            	return true;
	            }
	            return false;   
	        }
	
	private boolean hayColisionRasengan(Ninja ninja,Rasengan rasengan) {
		return !((rasengan.getX() - rasengan.getAncho()/2 > ninja.getX() + ninja.getAncho()/2 )||
	            (rasengan.getY() - rasengan.getAlto()/2 > ninja.getY() + ninja.getAlto()/2) ||
	             (rasengan.getX() + rasengan.getAncho()/2 < ninja.getX() - ninja.getAncho()/2 )||
	            (rasengan.getY() + rasengan.getAlto()/2 < ninja.getY() - ninja.getAlto()/2));         
	        }
	
	private boolean obtieneMoneda(Sakura sakura, Moneda moneda) {
        return !((sakura.getX() - sakura.getAncho()/2 > moneda.getX() + moneda.getDiametro()/2 )||
        (sakura.getY() - sakura.getAlto()/2 > moneda.getY() + moneda.getDiametro()/2) ||
         (sakura.getX() + sakura.getAncho()/2 < moneda.getX() - moneda.getDiametro()/2 )||
        (sakura.getY() + sakura.getAlto()/2 < moneda.getY() - moneda.getDiametro()/2));         
    }
	
	private void meterNinja(Ninja[] ninjas, int dificultad) {
		int contador = 0;
		for (Ninja ninja : ninjas) {
			if (ninja != null) {
				contador++;
			}
		}
		if (dificultad == 1) {
			while(contador < 4) {
				Ninja[] listadoNinjas = Ninja.obtenerNinjas();
				int random = Util.random(0,6);
	 			if (this.ninjas[random] == null) {
	 				this.ninjas[random] = listadoNinjas[random];
	 				contador++;
	 			}
	 		}
		}
		else if (dificultad == 2) {
			while(contador < 5) {
				Ninja[] listadoNinjas = Ninja.obtenerNinjas();
				int random = Util.random(0,6);
		 		if (this.ninjas[random] == null) {
		 			this.ninjas[random] = listadoNinjas[random];
		 			contador++;
		 		}
		 	}
		}
		else {
			while(contador < 6) {
				Ninja[] listadoNinjas = Ninja.obtenerNinjas();
				int random = Util.random(0,6);
		 		if (this.ninjas[random] == null) {
		 			this.ninjas[random] = listadoNinjas[random];
		 			contador++;
		 		}
		 	}
		}
	}	
	
	private void establecerMoneda() {
		Moneda[] monedas = Moneda.obtenerMonedas();
		int ind = Util.random(0, 18);
		this.moneda = monedas[ind];
		this.tiempoMonedas = 0;
	}
	
	private void marcador(Entorno entorno) {
		entorno.cambiarFont("Dialog", 15,Color.WHITE);
		entorno.escribirTexto("Puntaje", 700, 15);
		entorno.escribirTexto(String.valueOf(puntaje), 770, 15);
		entorno.escribirTexto("Ninjas-KO", 0, 15);
		entorno.escribirTexto(String.valueOf(ninjasKO), 80, 15);
		entorno.escribirTexto("Dificultad", 260 , 15 );
		entorno.escribirTexto(String.valueOf(this.dificultad), 330, 15);
	}
	
	private void rasenganShoot(Entorno entorno) {
		if(entorno.sePresiono(this.entorno.TECLA_ESPACIO) && this.rasengan==null) {
			this.rasengan=sakura.disparar();
		}
	}
	
	            
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
