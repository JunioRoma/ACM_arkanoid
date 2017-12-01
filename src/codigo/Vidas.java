package codigo;
/*
 * Autor:Jose Antonio Roma
 * -----------------------
 * Esta es la clase para crear las Vidas
 */
import java.awt.Color;
import java.awt.Font;

import acm.graphics.GLabel;
import acm.graphics.GRect;

public class Vidas extends GRect{


	GLabel texto= new GLabel("");
	static int vidas=13;
	GLabel auxiliarvida = new GLabel("");
	int numvidas= 3;


	public Vidas(double width, double height) {//Aqui creo el tamaño ,el color ,la fuente etc, del marcador de vidas
		super(width, height);
		setFilled(true);
		setFillColor(Color.green);
		texto.setLabel("3");
		texto.setFont(new Font("Bauhaus 93", Font.BOLD, 18));
	}
//------------------------------------------------------------------------------
	public void dibuja(Arkanoid _arkanoid){// Aqui lo q consigo es situar el marcador de vidas en el lugar deseado
		
			_arkanoid.add(this, _arkanoid.getWidth() -50, getY() +60);
			_arkanoid.add(auxiliarvida, _arkanoid.getWidth() -50, getY()+10); 
			_arkanoid.add(texto, _arkanoid.getWidth() -38, getY()+50);		
	}
//-----------------------------------------------------------------------------------


	public void actualizaVidas(int vida){//Esto dice q cada vez q se actualize el marcador tendra q restar una vida
		numvidas += vida;
		texto.setLabel("" + numvidas);


	}


}
