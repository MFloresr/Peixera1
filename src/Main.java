import acm.graphics.GImage;
import acm.program.GraphicsProgram;

import java.util.List;

public class Main extends GraphicsProgram {

    public void run() {
        setSize(1300,600);


        Juego juego =new Juego();

        List<Pez> peces = (List<Pez>) juego.getPeces();

        for(Pez pez: peces){
            add(pez.getImagen());
        }

        /*GImage imatge = new GImage("imagenes/M.png", 100, 100);
        imatge.setSize(60,60);
        add(imatge);
        GImage imatge2 = new GImage("imagenes/MH.png", 200, 100);
        imatge2.setSize(60,80);
        add(imatge2);*/




    }
}
