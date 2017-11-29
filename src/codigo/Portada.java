package codigo;

import java.awt.Color;
import java.awt.Font;
import java.util.WeakHashMap;

import acm.graphics.GLabel;
import acm.graphics.GRect;

public class Portada extends GRect{



	GLabel portada= new GLabel("");
	
	
	public Portada(double width, double height) {
		super(width, height);
		setFilled(true);
		setFillColor(Color.black);
		portada.setLabel("Clickea Para una Super Partida");
		portada.setFont(new Font("AR DARLING", Font.BOLD, 40));
		portada.setColor(Color.red);
	}

	public void dibuja(Arkanoid _arkanoid){
		_arkanoid.add(this, _arkanoid.getWidth()-600, getY());
		_arkanoid.add(portada,_arkanoid.getWidth()-700, getY()+250);
	}
	
	
	

}
