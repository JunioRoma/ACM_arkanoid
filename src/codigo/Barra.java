package codigo;

import java.awt.Color;

import acm.graphics.GRect;

/**
 * 
 * @author Junior
 *---------------
 *La Clase Barra es la que dibuja el cursor del Juego.
 */

public class Barra extends GRect{

	//double widht=0; //Este width se declara en toda la estancia y patra ello necesitamos poner el this.
	/**
	 * Crea el cursor del juego
	 * @param width -> El ancho del cursor.
	 * @param height -> El alto del cursor.
	 * @param _color -> El color del cursor.
	 */
	public Barra(double width, double height, Color _color) {
		super(width, height); 
		//this.widht =width; //Asi decimos que el with del public barra equivale lo mismo que el width de fuera
		setFilled(true);
		setFillColor(_color);

	}
	/**
	 * MueveBarra reposiciona la barra en la coordenda en la que esta el raton
	 * @param posX ->PosicionX del ratón.
	 * @param anchopantalla ->Pq asi no tengo que pasar nada mas.
	 */
	public void mueveBarra(int posX, int anchopantalla){
		if (posX + getWidth() < anchopantalla){
			setLocation(posX, getY());
		}

	}

















}
