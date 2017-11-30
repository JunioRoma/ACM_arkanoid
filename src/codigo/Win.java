package codigo;

import java.awt.Color;
import java.awt.Font;
import java.util.WeakHashMap;

import acm.graphics.GLabel;
import acm.graphics.GRect;

public class Win extends GRect{



	GLabel portada= new GLabel("");
	
	
	public Win(double width, double height) {
		super(width, height);
		portada.setLabel("Creo Que Tienes Descendencia Coreana!!!");
		portada.setFont(new Font("Rockwell", Font.BOLD, 20));
		portada.setColor(Color.blue);
	}

	public void dibuja(Arkanoid _arkanoid){
		_arkanoid.add(this, _arkanoid.getWidth()-400, getY());
		_arkanoid.add(portada,_arkanoid.getWidth()-450, getY()+250);
	}
	
	
	

}
