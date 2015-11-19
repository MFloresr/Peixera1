import acm.program.GraphicsProgram;

import java.awt.*;
import java.util.Iterator;
import java.util.List;

import static acm.util.JTFTools.pause;

public class Main extends GraphicsProgram {

    public void run() {
        setSize(1300,600);
        setBackground(Color.cyan);

        Pecera pecera =new Pecera();
        List<Pez> peces = pecera.getPeces();


        for(Pez pez:peces){
            add(pez.getImagen());
        }

        pecera.posicion_inicial();


        while(pecera.getPeces().size()!=0){
            pecera.MoverPeces();

            for(Iterator<Pez> it= pecera.getPeces().iterator();it.hasNext();){
                Pez pez1= it.next();
                if(!pez1.getEsMort()){
                    pecera.choque(pez1);
                }else{
                    it.remove();
                    remove(pez1.getImagen());
                }

            }
            for(Pez pez:pecera.getCrias()){
                add(pez.getImagen());
            }

            pause(50);
        }

    }

}
