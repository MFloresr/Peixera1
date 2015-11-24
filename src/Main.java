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
        List<Animal> animalesMarinos = pecera.getAnimalesMarinos();

        for(Animal animal:animalesMarinos){
            add(animal.getImagen());
        }

        pecera.posicion_inicial();

        while(pecera.getAnimalesMarinos().size()!=0){
            pecera.Mover();
            for(Iterator<Animal> it= pecera.getAnimalesMarinos().iterator();it.hasNext();){
                Animal pez1= it.next();
                if(!pez1.getEsMort()){
                    pecera.choque(pez1);
                }else{
                    it.remove();
                    remove(pez1.getImagen());
                }

            }
            //add crias
            for(Animal animalBb:pecera.getCrias()){
                animalesMarinos.add(animalBb);
            }

            for(Animal animalet:pecera.getCrias()){
                add(animalet.getImagen());
            }

            pecera.getCrias().clear();

            pause(50);
        }

    }

}
