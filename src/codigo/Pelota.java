package codigo;
/*
 * Autor:Jose Antonio Roma
 * -----------------------
 * La clase pelota es la que vamos a utilizar en 
 * el juego Arkanoid
 */
import java.awt.Color;
import acm.graphics.GRect;
import java.util.Random;

import acm.graphics.GObject;
import acm.graphics.GOval;

public class Pelota extends GOval{

	double xVelocidad= 1; //Velocidad de la bola en el eje X
	double yVelocidad= -1; //Velocidad de la bola en el eje Y
	GRect Rect;


	/**
	 * Este es el Constructor basico, que es identico 
	 * al de la Clase GOval
	 * @param _ancho
	 * @param _alto
	 */
	public Pelota(double _ancho, double _alto){
		super(_ancho, _alto);
	}

	/**
	 * Este es el Constructor dabuti que permite
	 * pasar el color como parametro.
	 * @param _ancho
	 * @param _color
	 */
	public Pelota(double _ancho,Color _color){

		super(_ancho, _ancho);
		if(_ancho <=0){
			this.setSize(1,1);
		}
		setFillColor(_color);
		setFilled(true);
	}




	/**
	 * Se encarga de mover a la pelota y chequear si ha habido colisiones. 
	 * 
	 */
	public void muevete(Arkanoid _arkanoid){
		//chuequea si se ha chocado con las paredes derecha e izquierda
		if(getX()+ this.getWidth()>=_arkanoid.getWidth()-_arkanoid.espacioMenu|| getX()<=0){
			xVelocidad*=-1;

		}
		//Chequea si se ha chocado con el techo
		if(getY()<=0){
			yVelocidad*=-1;

		}
		if (chequeaColision(getX(), getY(), _arkanoid)){//Chequeo la esquina superior izquierda

			if (chequeaColision(getX()+getWidth(), getY(), _arkanoid)){//Chequeo la esquina  superior derecha

				if (chequeaColision(getX()+getWidth(), getY()+getWidth(), _arkanoid)){//Chequeo la esquina inferior izquierda

					if (chequeaColision(getX(), getY()+getWidth(), _arkanoid)){	//Chequeo la esquina inferior derecha
					}
				}
			}
		}
		/*
		 * Voy a crear un metodo chuequea colision generico que sirva para comprobar 
		 * los choques entre la bola y los ladrillos y la bola y el cursor
		 */

		move(xVelocidad, yVelocidad);

	}

	private boolean chequeaColision(double posX, double posY, Arkanoid _arkanoid){
		boolean noHaChocado=true;
		GObject auxiliar;
		auxiliar= _arkanoid.getElementAt(posX, posY);

		if(auxiliar instanceof Ladrillo){
			if(auxiliar.getY()== posY || auxiliar.getY() + auxiliar.getHeight()== posY){
				yVelocidad *=-1;	
			}
			else if(auxiliar.getX()== posX || auxiliar.getX() + auxiliar.getWidth()== posX){
				xVelocidad *=-1;
			}
			_arkanoid.remove(auxiliar);
			_arkanoid.marcador.actualizaMarcador(1);
			noHaChocado=false;
		}
		else if(auxiliar instanceof Barra){

			randomVelocidad();
			noHaChocado = false;
		}
		return noHaChocado;




	}
	public void yVelocidadContraria(){
		yVelocidad = -yVelocidad;
	}

	public void xVelocidadContraria(){
		xVelocidad = -xVelocidad;
	}

	public void randomVelocidad(){
		Random generator = new Random();

		yVelocidad *=-1;

	}

}









