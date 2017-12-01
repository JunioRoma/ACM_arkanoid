package codigo;
/*
 * Autor:Jose Antonio Roma
 * -----------------------
 * Esta es la clase para crear el Win
 */
import java.awt.Color;
import java.awt.Font;
import java.util.WeakHashMap;

import acm.graphics.GLabel;
import acm.graphics.GRect;

public class Win extends GRect{



	GLabel portada= new GLabel("");
	
	
	public Win(double width, double height) {//Aqui creo el tamaño ,el color ,la fuente etc, de pantalla del GameOver
		super(width, height);
		portada.setLabel("MMM Huele A q Has Usado Hacks!!!");
		portada.setFont(new Font("Rockwell", Font.BOLD, 20));
		portada.setColor(Color.blue);
	}

	public void dibuja(Arkanoid _arkanoid){//Aqui importamos las coordenas deseadas para situar el texto.
		_arkanoid.add(this, _arkanoid.getWidth()-400, getY());
		_arkanoid.add(portada,_arkanoid.getWidth()-450, getY()+250);
	}
//------------------------------------------------------------------------------	
	
	

}
