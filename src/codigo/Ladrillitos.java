package codigo;


import java.awt.*; //para el frame y demas

import java.awt.event.*; //para los eventos

import java.util.*; //para el random



public class Ladrillitos extends Frame implements WindowListener,  MouseListener, MouseMotionListener, Runnable {



    Panel panel= new Panel();

    int tx=220; //es la ubicacion en x de la barra donde rebota la pelota

    int ty; //es la ubicacion en y de la barra donde rebota la pelota

    int px; //es la ubicacion de la pelota en x

    int py; //es la ubicacion de la pelota en y

    int score=0; //son los puntos

    int vidas=4; //es la cantidad de vidas

    float incX=1; 

    float incY=1;

    //incX y incY son los que dicen si la pelota tiene que camboiar de rumbo dependiendo si rebota en algun lado

    boolean [] filas=  new boolean[30]; //filas sirve para saber si la pelota entro dentro de las coordenasdas de un ladrillito

    boolean inicio= false;

    Random r= new Random();

    

    /** Creates a new instance of Ladrillos */

    public Ladrillitos() {

    setSize(510, 400); //le damos el tamaño a la pantalla

    add(panel); //agregamos el panel

    panel.setBackground(Color.black); //lo pintamos de negro

    panel.addMouseMotionListener(this); //le decimos que escuche el evento de mover el mouse

    panel.addMouseListener(this); //le decimos que escuche los click del mouse

    px= 260; 

    py = this.getHeight()-60;

    addWindowListener(this);//le decimos que escuche si uno cierra la ventana

    for (int x=0; x!=30; x++){ 

        filas[x]=true;//inicializamos las filas y las ponemos a todas en false

    }

    }

    

    

    

    public static void main (String [] Args){

    Ladrillitos arkanoid= new Ladrillitos();

    arkanoid.show();

    arkanoid.run();//llamamos al thread

    }

   

    

    public void dibujar(Color [] colores){

        Graphics g = panel.getGraphics();

        g.clearRect(0,0, this.getWidth(), this.getHeight()); //borra toda la pantalla

        g.setColor(Color.yellow); //le damos color a la pelotita

        g.fillOval((int)px,(int)py, 10,10); //hacemos la pelotita        

        g.setColor(Color.red); //le damos color rojo al contorno de la pelotita

        g.drawOval((int)px,(int)py, 10,10); //ahora hacemos el contorno        

        g.fillRect((int)tx,(int) ty, 80, 20); //hacemos  la barra

        g.setColor(Color.white); //le damos el color al contorno de la barra

        g.drawRect((int)tx,(int) ty, 80, 20); //ahora la hacemos el contorno

        g.setColor(Color.green); //le damos el color el texto

        g.drawString("Ladrillitos", 10, 15);

        g.drawString("Vidas:", 275, 15);

        g.setColor(Color.orange);

        g.drawString("sorbo@arnet.com.ar", 120, 15);

        g.setColor(Color.green); //le damos el color el texto

        switch(vidas){//muestra la cantidad de vida con unos rectangulitos arriba de la pantalla 

            //si las vidas son 4 significa que recien eempieza el juego y aparece un mensaje

            case 4: g.drawString("Bienvenidos", 230, 200);

                    g.drawString("Presione el boton del derecho del mouse para comenzar", 100, 220);

                    g.setColor(Color.white);

                    g.fillRect(320,5,15,10);

                    g.fillRect(340,5,15,10);

                    g.fillRect(360,5,15,10);

                    g.setColor(Color.red);

                    g.drawRect(320,5,15,10);

                    g.drawRect(340,5,15,10);

                    g.drawRect(360,5,15,10);

                    break;

            //si las vidas son 3 muestra 3 rectangulitos arriba

            case 3: g.setColor(Color.white);

                    g.fillRect(320,5,15,10);

                    g.fillRect(340,5,15,10);

                    g.fillRect(360,5,15,10);

                    g.setColor(Color.red);

                    g.drawRect(320,5,15,10);

                    g.drawRect(340,5,15,10);

                    g.drawRect(360,5,15,10);

                    break;

            //si las vidas son 2 muestra 2 rectangulitos arriba

            case 2: g.setColor(Color.white);

                    g.fillRect(320,5,15,10);

                    g.fillRect(340,5,15,10);

                    g.setColor(Color.red);

                    g.drawRect(320,5,15,10);

                    g.drawRect(340,5,15,10);

                    break;

            //si las vidas es 1 muestra 1 rectangulito arriba

            case 1: g.setColor(Color.white);

                    g.fillRect(320,5,15,10);

                    g.setColor(Color.red);

                    g.drawRect(320,5,15,10);

                    break;

            //si las vidas son 0 te muestra el cartelito de GAME OVER

            case 0: g.drawString("GAME OVER", 230, 200); 

                    g.drawString("Presione el boton del derecho del mouse para volver a jugar", 100, 220);

                    break;

        }

        g.setColor(Color.white); //color del texto

        g.drawString("Puntuacion:", 400, 15);

        g.drawString(String.valueOf(score), 470, 15); //te muestra la cantidad de puntos

        if (score==300){

        g.drawString("Ganaste!!!", 230, 200); 

        g.drawString("Calculo que dabes ser el hombre mas feliz del MUNDO, jaja", 70, 220);

        g.drawString("Presiona el boton del derecho del mouse para volver a jugar", 100, 240);

        vidas=4; //te reinicializa las vidas

        }

       //Ahora lo lindo!!! dibujamos los ladrillitos de colores de arriba       

       Graphics [] gl = new Graphics [30];

       //inicializamos todo

       int xp= 0;

       int yp= 30;

       int c=0; //este contador nos dice cuando tenemos que dibujar en la sig fila

       for (int x=0; x!=30; x++){

         gl[x]= panel.getGraphics(); //inicializamos el graficador

         c++; //le sumamos uno al contador

         if (c==11){ //porque son 10 ladrillitos por columna

         xp=0;

         yp=50; //hacemos que la proxima fila sea 20 pixeles mas abajo que la anterior

         }//fin del if c==11

         if (c==21){

         xp=0;

         yp=70; //hacemos que la proxima fila sea 20 pixeles mas abajo que la anterior

         }// fin del if c==21

         gl[x].setColor(colores[x]); //le asignamos los colores a cada uno de los ladrillitos

         if (filas[x]==true){ //si es true pintamos los ladrillitos sino borramos el espacio

            gl[x].fillRect(xp,yp,48,15);

            gl[x].setColor(Color.white);

            gl[x].drawRect(xp,yp,48,15);

         }//fin del if

         else{

             g.clearRect(xp,yp, 48, 15);

             }//fin del else

         xp+=50; //hacemos que se corra 50 px para la derecha para que pueda seguir agregando por columna

        

        }//fin del for

      

    }//fin del dibujar()

    

        public void mover(){

        if (inicio==false){

        }

        else{

        //inicializamos los ejes de la pelotita 

        px += 5*incX;

        py += 5*incY;

        }

        if (py>this.getHeight()){ //si es mas bajo que la barra

            vidas--;//le restamos una vida

            px= 260;//inicializamos el eje x de la pelotita

            tx=220;//inicializamos el eje x de la barra

            py = this.getHeight()-60; //inicializamos el eje y de la pelotita

            inicio=false; //le asignamos a inicio el false

        }

    

         //para que rebote en las paredes y el piso

               if ((px<0)||(px>this.getWidth()-20)){

            incX *= -1; //multiplicarlo por -1 al eje x hace que cambie totalmente el rumbo de la pelotita

            }

         if (py<20){

            incY *= -1; //multiplicarlo por -1 al eje y hace que cambie totalmente el rumbo de la pelotita

             }



         //para que rebote en la barra

        

         if ((py==ty)&&(tx<px)&&(px<tx+80)){

            incY *=-1;

            //paralos rebotes en las esquinas de la barra

            if ((px<tx+20)&&(incX>0)){

                incX *=-1.5;

            }

            if ((px>tx+60)&&(incX<0)){

                incX*=-1.5;

            }

       

        }     

       //verificamos donde pasa la pelotita y si pega en un ladrillito 

       //lo hace dasaparecer y cambia el rumbo(o se rebota))

       if ((py<74) && (py>56)){

          if (px<48){

              if (filas[20]==true){

                  filas[20]=false;

                  incY*=-1;

                  score+=10;;

              }

              }else if ((px<98)&&(px>48)){

              if (filas[21]==true){

                  filas[21]=false;

                  incY*=-1;

                  score+=10;

              }

              }else if  ((px<148)&&(px>98)){

              if (filas[22]==true){

                  filas[22]=false;

                  incY*=-1;

                  score+=10;;

              }

              }else if ((px<198)&&(px>148)){

              if (filas[23]==true){

                  filas[23]=false;

                  incY*=-1;

                  score+=10;;

              }

              }else if ((px<248)&&(px>198)){

              if (filas[24]==true){

                  filas[24]=false;

                  incY*=-1;

                  score+=10;

              }

              }else  if ((px<298)&&(px>248)){

              if (filas[25]==true){

                  filas[25]=false;

                  incY*=-1;

                  score+=10;;

              }

              }else if ((px<348)&&(px>298)){

              if (filas[26]==true){

                  filas[26]=false;

                  incY*=-1;

                  score+=10;;

                  

              }

              }else if ((px<398)&&(px>348)){

              if (filas[27]==true){

                  filas[27]=false;

                  incY*=-1;

                  score+=10;;

              }

              }else if ((px<448)&&(px>398)){

              if (filas[28]==true){

                  filas[28]=false;

                  incY*=-1;

                  score+=10;;

              }

              }else if (filas[29]==true){

                    filas[29]=false;

                    incY*=-1;

                    score+=10;;

                     }

          

       

       }

         if ((py<58) && (py>40)){

          if (px<48){

              if (filas[10]==true){

                  filas[10]=false;

                  incY*=-1;

                  score+=10;;

              }

          }

          if ((px<98)&&(px>48)){

              if (filas[11]==true){

                  filas[11]=false;

                  incY*=-1;  

                  score+=10;;

              }

          }

          if ((px<148)&&(px>98)){

              if (filas[12]==true){

                  filas[12]=false;

                  incY*=-1;

                  score+=10;;

              }

          }

          if ((px<198)&&(px>148)){

              if (filas[13]==true){

                  filas[13]=false;

                  incY*=-1;

                  score+=10;;

              }

          }

          if ((px<248)&&(px>198)){

              if (filas[14]==true){

                  filas[14]=false;

                  incY*=-1;

                  score+=10;;

              }

          }

          if ((px<298)&&(px>248)){

              if (filas[15]==true){

                  filas[15]=false;

                  incY*=-1;

                  score+=10;;

              }

          }

          if ((px<348)&&(px>298)){

              if (filas[16]==true){

                  filas[16]=false;

                  incY*=-1;

                  score+=10;;

              }

          }

          if ((px<398)&&(px>348)){

              if (filas[17]==true){

                  filas[17]=false;

                  incY*=-1;

                  score+=10;;

              }

          }

          if ((px<448)&&(px>398)){

              if (filas[18]==true){

                  filas[18]=false;

                  score+=10;;

              }

          }

          if ((px<598)&&(px>448)){

              if (filas[19]==true){

                  filas[19]=false;

                  incY*=-1;

                  score+=10;;

              }

       

          }

          }

          if ((py<43) && (py>24)){

          if (px<48){

              if (filas[0]==true){

                  filas[0]=false;

                  incY*=-1;

                  score+=10;;

              }

          }

          if ((px<98)&&(px>48)){

              if (filas[1]==true){

                  filas[1]=false;

                  incY*=-1;

                  score+=10;;

              }

          }

          if ((px<148)&&(px>98)){

              if (filas[2]==true){

                  filas[2]=false;

                  incY*=-1;

                  score+=10;;

              }

          }

          if ((px<198)&&(px>148)){

              if (filas[3]==true){

                  filas[3]=false;

                  incY*=-1;

                  score+=10;;

              }

          }

          if ((px<248)&&(px>198)){

              if (filas[4]==true){

                  filas[4]=false;

                  incY*=-1;

                  score+=10;;

              }

          }

          if ((px<298)&&(px>248)){

              if (filas[5]==true){

                  filas[5]=false;

                  incY*=-1;

                  score+=10;

                  

              }

          }

          if ((px<348)&&(px>298)){

              if (filas[6]==true){

                  filas[6]=false;

                  incY*=-1;

                  score+=10;

              }

          }

          if ((px<398)&&(px>348)){

              if (filas[7]==true){

                  filas[7]=false;

                  incY*=-1;

                  score+=10;  

              }

          }

          if ((px<448)&&(px>398)){

              if (filas[8]==true){

                  filas[8]=false;

                  incY*=-1;

                  score+=10;

              }

          }

          if ((px<598)&&(px>448)){

              if (filas[9]==true){

                  filas[9]=false;

                  incY*=-1;

                  score+=10;

                  

              }

       

          }

      }

        //para que la barra no salga del frame(o se de la ventana)

        if (tx>this.getWidth()-80){

            tx=this.getWidth()-80;

        }

        

        ty = this.getHeight()-50; //el eje y por el que se mueve la barra 



    }

        

    public void run() {

    Color [] colores= new Color[30];//son los colores de los ladrillitos

    for (int x=0; x!=30; x++){

        colores[x]=new Color (r.nextInt(256),r.nextInt(256),r.nextInt(256));

        //aca le asignamos los colores

    }

    while ((true)&&(score!=300)){

        this.mover(); //que nos sirve para el rebote de la pelota y para saber si paso sobre un ladrillito    

        this.dibujar(colores); //dibuja todo (seria bueno hacerlo por parte para manejar mejor el tema de thread)

        try{

            Thread.sleep(50);

        }

        catch (InterruptedException IE){}

    }//fin del while

    }

    

    public void mouseDragged(MouseEvent e) {

    }

    

    public void mouseMoved(MouseEvent e) {

        if (inicio==false){

            px=e.getX()+40;}//aca inicializamos la pelota para que este arriba de la barra

        tx= e.getX();//este es el que le da la coordena del eje x de la barra o sea que si

        //movemos el mouse para la derecha la barra va para la derecha

    }

    

    public void windowActivated(WindowEvent e) {

    }

    

    public void windowClosed(WindowEvent e) {

    }

    

    public void windowClosing(WindowEvent e) {

        System.exit(0); //cierra la ventana cuando clickeamos en la X

    }

    

    public void windowDeactivated(WindowEvent e) {

    }

    

    public void windowDeiconified(WindowEvent e) {

    }

    

    public void windowIconified(WindowEvent e) {

    }

    

    public void windowOpened(WindowEvent e) {

    }

    

    public void mouseClicked(MouseEvent e) {

    if (vidas==4){

        vidas--;//si las vidas son 4 cuando hace un click se le elimina uno(lo de 4 solo es para mostar un mensaje)

    }

    if (vidas==0){

        vidas=4;//significas que volves a empezar

        score=0;//el puntaje tb se inicializa

        for (int x=0; x!=30; x++){

        filas[x]=true; // y con las filas pasa lo mismo

        }

    }

    inicio=true; 

    }

    

    public void mouseEntered(MouseEvent e) {

    }

    

    public void mouseExited(MouseEvent e) {

    }

    

    public void mousePressed(MouseEvent e) {

    }

    

    public void mouseReleased(MouseEvent e) {

    }

    

}//fin de la clase
