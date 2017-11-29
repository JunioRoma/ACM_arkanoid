package codigo;

import java.awt.Color;
import java.awt.Font;

import acm.graphics.GLabel;
import acm.graphics.GRect;

public class Vidas extends GRect{


	GLabel texto= new GLabel("");
	int vidas=3;
	
	public Vidas(double width, double height) {
		super(width, height);
		setFilled(true);
		setFillColor(Color.green);
		texto.setLabel("3");
		texto.setFont(new Font("Verdana", Font.BOLD, 18));
	}

	public void dibuja(Arkanoid _arkanoid){
		_arkanoid.add(this, _arkanoid.getWidth()-50, getY());
		_arkanoid.add(texto,_arkanoid.getWidth()-50, getY()+100);
	}
	
	
	
	public void actualizaVidas(int vida){
		vidas -=vida;
		texto.setLabel(""+vidas);
		
		
	}
	
	

}
