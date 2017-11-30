package codigo;

import java.awt.Color;
import java.awt.Font;

import acm.graphics.GLabel;
import acm.graphics.GRect;

public class Marcador extends GRect{

	GLabel texto= new GLabel("");
	int puntuacion=0;
	
	
	public Marcador(double width, double height) {
		super(width, height);
		setFilled(true);
		setFillColor(Color.green);
		texto.setLabel("Pts");
		texto.setFont(new Font("Bauhaus 93", Font.BOLD, 18));
	}

	public void dibuja(Arkanoid _arkanoid){
		_arkanoid.add(this, _arkanoid.getWidth()-50, getY());
		_arkanoid.add(texto,_arkanoid.getWidth()-40, getY()+30);
	}
	
	
	
	public void actualizaMarcador(int puntos){
		puntuacion +=puntos;
		texto.setLabel(""+puntuacion);
		
		
	}
	
	

}
