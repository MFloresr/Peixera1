import acm.program.GraphicsProgram;

import java.awt.*;
import java.util.Iterator;
import java.util.List;

import static acm.util.JTFTools.pause;

public class Main extends GraphicsProgram {

    public void run() {
        setSize(1300,600);
        setBackground(Color.cyan);

        Juego juego =new Juego();

        List<Pez> peces = juego.getPeces();
        for(Pez pez:peces){
            add(pez.getImagen());
        }

        juego.posicion_inicial();


        while(juego.getPeces().size()!=0){
            for(Iterator<Pez> it= juego.getPeces().iterator();it.hasNext();){
                Pez pez1= it.next();
                if(!pez1.getEsMort()){
                    juego.choque(pez1);
                }else{
                    it.remove();
                    remove(pez1.getImagen());
                }

            }
            juego.MoverPeces();
            pause(50);
        }

    }

}
