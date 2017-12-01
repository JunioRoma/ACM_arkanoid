package codigo;
/*
 * Autor:Jose Antonio Roma
 * -----------------------
 * El Arkanoid pero orientado a objetos to XULIII
 */
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


public class Arkanoid extends acm.program.GraphicsProgram{

	RandomGenerator aleatorio = new RandomGenerator();
	Pelota Pelota1=new Pelota(15,Color.green);
	Pelota Pelota2=new Pelota(40,Color.red);
	Barra barra1=new Barra(70, 10, Color.red );
	int anchoLadrillo=29;
	int altoLadrillo=15;
	//El sistema del marcado
	Random r= new Random();
	Panel panel= new Panel();
	GImage imagenFondo = new GImage("joker.gif");
	GImage imagenGameOver = new GImage("loser1.gif");
	GImage imagenWin = new GImage("win.gif");
	GLabel texto= new GLabel("");
	float tiempoPausa= 5;
	Marcador marcador= new Marcador(40,80);
	int espacioMenu=75;
	Vidas vidaAbajo = new Vidas (40,80);


	public void init(){

		add(imagenFondo, -200, 0);//La imagen del fondo

		Portada portada1 = new Portada(0,0);//Con esto creamos las variables para escribir en la portada
		portada1.dibuja(this);



		waitForClick() ;//Clikea y empieza
		remove(portada1.portada);//Una vez clikee q se borre los string de la portada
		addMouseListeners();
		setSize(500, 600);//El tamaño de la Ventana

		GRect lateral=new GRect(3, getHeight());//Con esto nombramos la barra q separa el lugar de juego con el marcador y las vidas
		lateral.setFilled(true);

		add(lateral, getWidth()-espacioMenu-lateral.getWidth()-Pelota1.getWidth(), 0);//Asi creamos la condicion para q rebote la pelota con la barra de separacion
		add(Pelota1,50,getHeight()*0.79-Pelota1.getHeight());
		add(barra1, 0, getHeight()*0.8);
//-----------------------------------------------------------------------------------------------
		addMouseListeners();

	}


	public void run(){


		dibujaNivel01();//Dibuja a partir en el nivel 1

		marcador.dibuja(this);//Dibuja el marcador
		vidaAbajo.dibuja(this);	//Dibuja las vidas

		while(true){//Es la condicon para q a medida q pasa el tiempo aumente la velocidad
			Pelota1.muevete(this);
			pause(tiempoPausa);
			tiempoPausa -=0.000333;
			if(tiempoPausa<1){
				tiempoPausa= 1;
//----------------------------------------------
			}
			if(vidaAbajo.numvidas <= 0)	{//Si llega el momento en q haya 0 vidas....
				removeAll();
				GameOver gameOver1= new GameOver(0, 0);						
				gameOver1.dibuja(this);	//Añado el game over
				add(imagenGameOver,75, 0);//Y una presiosa foto de fondo

			}

			if(marcador.puntuacion >= 91) {//En el momento q llegue el marcador a 91 significa q has ganaddo y dibujara....
				removeAll();
				Win winner1= new Win(0,0);
				winner1.dibuja(this);//Dibuja winner
				add(imagenWin, 95, 0);//Añade una foto


			}
			//Esto es el bot q hace q nunca pierdas;
			
			//barra1.mueveBarra((int)Pelota1.getX(), getWidth()-espacioMenu);
		}


	}



	public void mouseMoved(MouseEvent evento){//Esto loq hace esque la barra te siga donde pones el raton
		barra1.mueveBarra(evento.getX(), getWidth()-espacioMenu);

	}

	private void dibujaNivel01(){//Esto dibuja la piramide de ladrillitos

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
//_-----------------------------------------------------------------------------------------------------------------------------

}


























