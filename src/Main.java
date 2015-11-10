import acm.program.GraphicsProgram;
import java.util.List;

import static acm.util.JTFTools.pause;

public class Main extends GraphicsProgram {

    public void run() {
        setSize(1300,600);


        Juego juego =new Juego();

        List<Pez> peces = juego.getPeces();
        for(Pez pez:peces){
            add(pez.getImagen());
        }

        juego.posicion_inicial();


        while(juego.getPeces().size()!=0){
            juego.MoverPeces();
            pause(50);
        }

    }

}
