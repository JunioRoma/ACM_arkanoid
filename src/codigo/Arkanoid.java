package codigo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import acm.program.*;
import acm.util.RandomGenerator;
import acm.graphics.GLabel;
import acm.graphics.GRect;

/*
 * Autor:Jose Antonio Roma
 * -----------------------
 * El Arkanoid pero orientado a objetos
 */

public class Arkanoid extends acm.program.GraphicsProgram{
	RandomGenerator aleatorio = new RandomGenerator();
	Pelota Pelota1=new Pelota(15,Color.MAGENTA);
	Pelota Pelota2=new Pelota(40,Color.red);
	Barra barra1=new Barra(70, 10, Color.GREEN);
	int anchoLadrillo=29;
	int altoLadrillo=15;
	//El sistema del marcador
	int puntuacion=0;
	Marcador marcador= new Marcador(20,40);
	int espacioMenu=75;

	public void init(){
		waitForClick() ;//Clikea y empieza
		println("MMMM SE QUE TE GUSTA MI JUEGOO JEJEJEJE SALU2(Me debes 3000$)");
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
		marcador.dibuja(this);
		float tiempoPausa= 5;
		while(true){
			Pelota1.muevete(this);
			pause(tiempoPausa);
			tiempoPausa -=0.0001333;
			if(tiempoPausa<1){
				tiempoPausa= 1;

			}
			barra1.mueveBarra((int)Pelota1.getX(), getWidth()-espacioMenu);
		}
	}

	public void mouseMoved(MouseEvent evento){
		barra1.mueveBarra((int)Pelota1.getX(), getWidth()-espacioMenu);

	}

	private void dibujaNivel01(){

		for(int j=0; j<14; j++){
			for(int i=j; i<14; i++){
				Ladrillo miLadrillo= new Ladrillo(anchoLadrillo*i -anchoLadrillo*j/2 + ((getWidth()-75)-anchoLadrillo*14)/2,//He pensado el ancho de la pantalla - el cnahco de lso ladrillos partido por el numero de ladrillos todo eso dividido entre dos.
						altoLadrillo*j ,
						anchoLadrillo, altoLadrillo, aleatorio.nextColor());
				add(miLadrillo);
				pause(7);
			}
		}
	}
















}