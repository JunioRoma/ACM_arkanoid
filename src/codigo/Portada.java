package codigo;
/*
 * Autor:Jose Antonio Roma
 * -----------------------
 * Esta es la clase para crear la preiosa Portada
 */
import java.awt.Color;
import java.awt.Font;
import java.util.WeakHashMap;

import acm.graphics.GLabel;
import acm.graphics.GRect;

public class Portada extends GRect{



	GLabel portada= new GLabel("");
	
	
	public Portada(double width, double height) {//Aqui creamos el tamaño,el color,la fuente etc, de lo q desees poner en la portda antes de empezar el juego
		super(width, height);
		setFilled(true);
		setFillColor(Color.black);
		portada.setLabel("Clickea Para una Super Partida");
		portada.setFont(new Font("AR DARLING", Font.BOLD, 40));
		portada.setColor(Color.red);
	}
//------------------------------------------------------------------------------------
	public void dibuja(Arkanoid _arkanoid){//Aqui importamos las coordenas deseadas para situar el texto.
		_arkanoid.add(this, _arkanoid.getWidth()-600, getY());
		_arkanoid.add(portada,_arkanoid.getWidth()-700, getY()+250);
	}
//----------------------------------------------------------------------------------------	
	
	

}
