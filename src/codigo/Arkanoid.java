package codigo;

import java.io.*;
import java.awt.event.MouseEvent;
import acm.program.*;
import acm.util.RandomGenerator;
import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GRect;
import java.awt.*; //para el frame y demas
import java.awt.event.*; //para los eventos
import java.util.*; //para el random
import acm.graphics.*;
import acm.program.*;
import java.applet.*;
/*
 * Autor:Jose Antonio Roma
 * -----------------------
 * El Arkanoid pero orientado a objetos
 */

public class Arkanoid extends acm.program.GraphicsProgram{
	
	RandomGenerator aleatorio = new RandomGenerator();
	Pelota Pelota1=new Pelota(15,Color.green);
	Pelota Pelota2=new Pelota(40,Color.red);
	Barra barra1=new Barra(70, 10, Color.red );
	int anchoLadrillo=29;
	int altoLadrillo=15;
	//El sistema del marcador
	int bx=220; //es la ubicacion en x de la barra donde rebota la pelota
	int by; //es la ubicacion en y de la barra donde rebota la pelota
	int px; //es la ubicacion de la pelota en x
	int py; //es la ubicacion de la pelota en y
	float incX=1; 
	boolean inicio= false;
	Random r= new Random();
	Panel panel= new Panel();
	GImage imagenFondo = new GImage("joker.gif");
	GLabel texto= new GLabel("");
	Vidas vidas= new Vidas(40,160);
	Marcador marcador= new Marcador(40,80);
	int espacioMenu=75;


	public void init(){

		add(imagenFondo, -200, 0);

		Portada portada1 = new Portada(0,0);

		portada1.dibuja(this);


		waitForClick() ;//Clikea y empieza
		remove(portada1.portada);
		addMouseListeners();
		setSize(500, 600);

		GRect lateral=new GRect(3, getHeight());
		lateral.setFilled(true);

		add(lateral, getWidth()-espacioMenu-lateral.getWidth()-Pelota1.getWidth(), 0);
		add(Pelota1,50,getHeight()*0.79-Pelota1.getHeight());
		add(barra1, 0, getHeight()*0.8);

		addMouseListeners();

	}


	public void run(){


		dibujaNivel01();
		vidas.dibuja(this);
		marcador.dibuja(this);
		float tiempoPausa= 5;
		while(true){
			Pelota1.muevete(this);
			pause(tiempoPausa);
			tiempoPausa -=0.000333;
			if(tiempoPausa<1){
				tiempoPausa= 1;

			}
			
		}
		//barra1.mueveBarra((int)Pelota1.getX(), getWidth()-espacioMenu);
	}


	public void mouseMoved(MouseEvent evento){
		barra1.mueveBarra(evento.getX(), getWidth()-espacioMenu);

	}

	private void dibujaNivel01(){

		for(int j=1; j<14; j++){
			for(int i=j; i<14; i++){
				Ladrillo miLadrillo= new Ladrillo(anchoLadrillo*i -anchoLadrillo*j/2 + ((getWidth()-75)-anchoLadrillo*14)/2,//He pensado el ancho de la pantalla - el cnahco de lso ladrillos partido por el numero de ladrillos todo eso dividido entre dos.
						altoLadrillo*j ,
						anchoLadrillo, altoLadrillo, aleatorio.nextColor());
				add(miLadrillo);
				pause(7);
			}
		}
	}
	private void printGameOver() {
		GLabel gameOver = new GLabel ("Game Over", getWidth()/2, getHeight()/2);
		gameOver.move(-gameOver.getWidth()/2, -gameOver.getHeight());
		gameOver.setColor(Color.RED);
		add (gameOver);
	}

	private int brickCounter = 100;

	private void printWinner() {
		GLabel Winner = new GLabel ("Winner!!", getWidth()/2, getHeight()/2);
		Winner.move(-Winner.getWidth()/2, -Winner.getHeight());
		Winner.setColor(Color.RED);
		add (Winner);
	}


















}
