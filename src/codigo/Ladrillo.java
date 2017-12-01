package codigo;
/*
 * Autor:Jose Antonio Roma
 * -----------------------
 * Esto es la clase Ladrillo
 */
import java.awt.Color;

import acm.graphics.GRect;

/**
 * 
 * @author Junior
 *---------------
 *La clase Ladrillo sirve para dibujar los ladrillos del juego.
 */

public class Ladrillo extends GRect{
	/**
	 * Construye un ladrillo
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param _color
	 * futuros cambios: que admita numero de golpes
	 */
	public Ladrillo(double x, double y, double width, double height,Color _color) {//Aqui creamos los ladrillos para mas tarde recopilarlos y q cree la piramide
		super(x, y, width, height);
		setFillColor(_color);
		setFilled(true);
//-------------------------------------------------------------------------------------
	}

}
