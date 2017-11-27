package codigo;

import java.io.*;
import java.awt.event.MouseEvent;
import acm.program.*;
import acm.util.RandomGenerator;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GRect;
import acm.graphics.GRectangle;

import java.awt.*; //para el frame y demas
import java.awt.event.*; //para los eventos
import java.util.*; //para el random


public class Texto extends Arkanoid{



	Panel panel= new Panel();

	int score=0; //son los puntos

	int vidas=4; //es la cantidad de vidas

	boolean [] filas=  new boolean[30]; //filas sirve para saber si la pelota entro dentro de las coordenasdas de un ladrillito

	boolean inicio= false;

	Random r= new Random();


	public void dibujar(Arkanoid color){

		Graphics g = panel.getGraphics();


		g.drawString("ARKANOID.HD", 10, 400);

		g.drawString("Vidas:", 275, 400);

		g.setColor(Color.orange);

		g.drawString("ByJoseRoma", 120, 15);

		g.setColor(Color.green); //le damos el color el texto

		switch(vidas){//muestra la cantidad de vida con unos rectangulitos arriba de la pantalla 

		//si las vidas son 4 significa que empieza el juego y aparece un mensaje

		case 4: g.drawString("Bienvenidos", 230, 200);

		g.drawString("Presione Click Derecho Princeso", 100, 220);

		g.setColor(Color.white);

		g.fillRect(120,5,400,10);

		g.fillRect(140,5,400,10);

		g.fillRect(160,5,400,10);

		g.setColor(Color.red);

		g.drawRect(120,5,400,10);

		g.drawRect(140,5,400,10);

		g.drawRect(160,5,400,10);


		//si las vidas son 3 muestra 3 rectangulitos arriba

		case 3: g.setColor(Color.white);

		g.fillRect(120,5,400,10);

		g.fillRect(140,5,400,10);

		g.fillRect(160,5,400,10);

		g.setColor(Color.red);

		g.drawRect(120,5,400,10);

		g.drawRect(140,5,400,10);

		g.drawRect(160,5,400,10);



		//si las vidas son 2 muestra 2 rectangulitos arriba

		case 2: g.setColor(Color.white);

		g.fillRect(120,5,400,10);

		g.fillRect(140,5,400,10);

		g.setColor(Color.red);

		g.drawRect(120,5,400,10);

		g.drawRect(140,5,400,10);



		//si las vidas es 1 muestra 1 rectangulito arriba

		case 1: g.setColor(Color.white);

		g.fillRect(120,5,400,10);

		g.setColor(Color.red);

		g.drawRect(120,400,15,10);



		//si las vidas son 0 te muestra el cartelito de GAME OVER

		case 0: g.drawString("GAME OVER", 230, 200); 

		g.drawString("Clickea para volver a jugar", 100, 220);

		g.setColor(Color.white); //color del texto

		}




		if (score==300){

			g.drawString("Ganaste!!!", 230, 200); 

			g.drawString("MMM Estas to Feliiiis eee", 70, 220);

			g.drawString("Clikea Para Superarte Weeey", 100, 240);

			vidas=4; //te reinicializa las vidas

		}

	}


}
